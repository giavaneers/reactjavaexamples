/*==============================================================================

name:       Login.java

purpose:    Chat example login.

history:    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created


notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.chat;

                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import io.reactjava.client.providers.auth.IAuthenticationService;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.react.Router;
import jsinterop.base.Js;
                                       // Login ==============================//
public class Login extends Component
{
                                       // class constants ------------------- //
                                       // logger                              //
public static final Logger kLOGGER = Logger.newInstance();

                                       // elementIds                          //
public static final String kELEMENT_ID_DISPLAY_NAME = App.kDISPLAY_NAME;
public static final String kELEMENT_ID_EMAIL        = "email";
public static final String kELEMENT_ID_ERROR        = "error";
public static final String kELEMENT_ID_PASSWORD     = "password";

                                       // another state variable              //
public static final String kSTATE_CREDENTIALS_ENTERED = "credentialsEntered";
public static final String kSTATE_ERROR               = "error";

                                       // auth configuration                  //
public static final String[] kFIREBASE_CONFIGURATION =
{
   "AIzaSyC2lsGWFpARlWm2janyFT1f8tcUx7I9b-U",
   "pumajtourofheroes.firebaseapp.com",
   "https://pumajtourofheroes.firebaseio.com",
   "pumajtourofheroes",
   "pumajtourofheroes.appspot.com",
   "433064327713"
};
                                       // class variables ------------------- //
                                       // authentication service provider     //
public static IAuthenticationService auth;
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       doLogin - signin button-click handler
                                                                              */
                                                                             /**
            Signin button-click handler.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void configureServices()
{
   if (auth == null)
   {
                                       // get an authentication service       //
                                       // instance                            //
      auth = ReactJava.getProvider(IAuthenticationService.class);

                                       // configure the services              //
      auth.configure(kFIREBASE_CONFIGURATION).subscribe(
         response ->
         {
         },
         error ->
         {
            errorPut("Authentication service configuration failed.");
         });
   }
}
/*------------------------------------------------------------------------------

@name       createAccount - create a new account
                                                                              */
                                                                             /**
            Create a new  account.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void createAccount()
{
   String email    = getInputElementText(kELEMENT_ID_EMAIL);
   String password = getInputElementText(kELEMENT_ID_PASSWORD);

   auth.createUserWithEmailAndPassword(email, password).subscribe(
      (response) ->
      {
         kLOGGER.logInfo("Account created successfully for " + email);
         pushPathToChat();
      },
      (String error) ->
      {
         errorPut(error);
      });
}
/*------------------------------------------------------------------------------

@name       errorPut - handle the specified error
                                                                              */
                                                                             /**
            Handle the specified error.

@param      error    error string

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void errorPut(
   String error)
{
   getInputElement(kELEMENT_ID_ERROR).value = error;
   if (error.length() > 0)
   {
      kLOGGER.logError(error);
   }
   setState(kSTATE_ERROR, error);
}
/*------------------------------------------------------------------------------

@name       errorRemove - remove any error condition
                                                                              */
                                                                             /**
            remove any error condition.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void errorRemove()
{
   errorPut("");
}
/*------------------------------------------------------------------------------

@name       getCredentialsEntered - get whether credentials have been entered
                                                                              */
                                                                             /**
            Get whether credentials have been entered.

@return     true iff credentials have been entered

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public boolean getCredentialsEntered()
{
   boolean getCredentialsEntered =
      getInputElementText(kELEMENT_ID_EMAIL).length() > 0
         && getInputElementText(kELEMENT_ID_PASSWORD).length() > 0;

   return(getCredentialsEntered);
}
/*------------------------------------------------------------------------------

@name       getInputElement - get specified input element
                                                                              */
                                                                             /**
            Get specified input element text.

@return     specified input element text, or the empty string if not found

@param      elementId      specified input elementId

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public String getInputElementText(
   String elementId)
{
   HTMLInputElement inputElement = getInputElement(elementId);
   return(inputElement != null ? inputElement.value : "");
}
/*------------------------------------------------------------------------------

@name       getInputElement - get specified input element
                                                                              */
                                                                             /**
            Get specified input element.

@return     specified input element

@param      elementId      specified input elementId

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public HTMLInputElement getInputElement(
   String elementId)
{
   HTMLInputElement inputElement =
      (HTMLInputElement)DomGlobal.document.getElementById(elementId);

   return(inputElement);
}
/*------------------------------------------------------------------------------

@name       keyUpHandler - keyUp event handler
                                                                              */
                                                                             /**
            keyUp event handler as a public instance variable. A TextField
            does not intrinsicly support input of the RETURN character, so we
            add this keyboard event handler.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler keyUpHandler = (Event e) ->
{
   KeyboardEvent keyEvent = Js.uncheckedCast(e);
   switch(keyEvent.key)
   {
      case "Enter":
      {
         if (getCredentialsEntered())
         {
                                       // attempt to login                    //
            login();
         }
         break;
      }
   }
};
/*------------------------------------------------------------------------------

@name       login - login to existing account
                                                                              */
                                                                             /**
            Login to existing account.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void login()
{
   String email    = getInputElementText(kELEMENT_ID_EMAIL);
   String password = getInputElementText(kELEMENT_ID_PASSWORD);

   auth.signInWithEmailAndPassword(email, password).subscribe(
      responseSignIn ->
      {
         pushPathToChat();
      },
      (String error) ->
      {
         errorPut(error);
      });
}
/*------------------------------------------------------------------------------

@name       pushPathToChat - push the chat path
                                                                              */
                                                                             /**
            Push the chat path.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void pushPathToChat()
{
                                       // this route path syntax assigns the  //
                                       // 'username' property of the Chat     //
                                       // instance to the username value      //
                                       // See the Dynamic Routing section of  //
                                       // the ReactJava Developer Guide       //
   String email       = getInputElementText(kELEMENT_ID_EMAIL);
   String displayName = getInputElementText(kELEMENT_ID_DISPLAY_NAME);
   String propValue   = displayName.length() > 0 ? displayName : email;

   String path = App.kPATH_CHAT.replace(":" + App.kDISPLAY_NAME, propValue);
   Router.push(path);
}
/*------------------------------------------------------------------------------

@name       onChangeHandler - input change event handler
                                                                              */
                                                                             /**
            onChange event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler onChangeHandler = (Event e) ->
{
   HTMLInputElement element = (HTMLInputElement)e.target;
   switch(element.id)
   {
      case kELEMENT_ID_EMAIL:
      case kELEMENT_ID_PASSWORD:
      {
         errorRemove();
         setState(kSTATE_CREDENTIALS_ENTERED, getCredentialsEntered());
         break;
      }
   }
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState(kSTATE_CREDENTIALS_ENTERED, false);
   useState(kSTATE_ERROR, "");

   if (auth == null)
   {
      configureServices();
   }
/*--
   <@material-ui.core.Grid container justify="center">
      <@material-ui.core.Grid item class='contentWidth'>
         <img src='images/logo.svg' />
         <div class='padding'>
            <@material-ui.core.TextField
               id={kELEMENT_ID_ERROR}
               margin="normal"
               error={getStateString(kSTATE_ERROR).length() > 0}
               fullWidth
               InputProps={App.kATTRIB_READ_ONLY}/>
            <@material-ui.core.TextField
               id={kELEMENT_ID_DISPLAY_NAME}
               label="Display Name"
               placeholder="Enter Chat Display Name"
               margin="normal"
               variant="outlined"
               fullWidth
               onChange={onChangeHandler} />
            <@material-ui.core.TextField
               id={kELEMENT_ID_EMAIL}
               label="EMail"
               placeholder="Enter EMail"
               margin="normal"
               variant="outlined"
               fullWidth
               onChange={onChangeHandler}
               onKeyUp={keyUpHandler} />
            <@material-ui.core.TextField
               id={kELEMENT_ID_PASSWORD}
               label="Password"
               placeholder="Enter Password"
               margin="normal"
               variant="outlined"
               fullWidth
               onChange={onChangeHandler}
               onKeyUp={keyUpHandler} />
            <@material-ui.core.Button
               class='padtop'
               variant='contained'
               fullWidth={true}
               disabled={!getStateBoolean(kSTATE_CREDENTIALS_ENTERED)}
               onClick={signInHandler} >
               Sign In
            </@material-ui.core.Button>
            <@material-ui.core.Button
               class='padtop'
               variant='contained'
               fullWidth={true}
               disabled={!getStateBoolean(kSTATE_CREDENTIALS_ENTERED)}
               onClick={signUpHandler} >
               Sign Up
            </@material-ui.core.Button>
         </div>
      </@material-ui.core.Grid>
   </@material-ui.core.Grid>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .padding
   {
      padding:          16px;
      display:          block;
      box-sizing:       border-box;
   }
   .padtop
   {
      margin-top:       20px;
   }
   .contentWidth
   {
   }
   @media (min-width: 320px)
   {
      .contentWidth {width: 300px;}
   }
   @media (min-width: 576px)
   {
      .contentWidth {width: 540px;}
   }
   @media (min-width: 768px)
   {
      .contentWidth {width: 720px;}
   }
   @media (min-width: 992px)
   {
      .contentWidth {width: 960px;}
   }
   @media (min-width: 1200px)
   {
      .contentWidth {width: 1140px;}
   }
--*/
}
/*------------------------------------------------------------------------------

@name       signInHandler - signIn onClick event handler
                                                                              */
                                                                             /**
            SignIn onClick event handler as a public instance variable.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler signInHandler = (Event e) ->
{
   login();
};
/*------------------------------------------------------------------------------

@name       signUpHandler - signUp onClick event handler
                                                                              */
                                                                             /**
            SignUp onClick event handler as a public instance variable.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler signUpHandler = (Event e) ->
{
   createAccount();
};
}//====================================// end Login ========================//
