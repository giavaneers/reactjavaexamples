/*==============================================================================

name:       Welcome.java

purpose:    Login example.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.login;

                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLInputElement;
import io.reactjava.client.providers.auth.IAuthenticationService;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.react.Router;
import io.reactjava.client.providers.auth.IAuthenticationService.IUserCredential;
                                       // Welcome ============================//
public class Welcome extends Component
{
                                       // class constants ------------------- //
                                       // logger                              //
public static final Logger kLOGGER = Logger.newInstance();

                                       // class variables ------------------- //
                                       // (none)                              //
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

@history    Fri Jan 26, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void doLogin(
   String email,
   String password)
{
   if (App.auth == null)
   {
                                       // get an authentication service       //
                                       // instance                            //
      App.auth = ReactJava.getProvider(IAuthenticationService.class);
   }

   App.auth.signInWithEmailAndPassword(email, password).subscribe(
      (IUserCredential userCredential) ->
      {
         Router.push(App.kPATH_LOGGED_IN);
      },
      error ->
      {
         kLOGGER.logError("User authentication failed.");
      });
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <@material-ui.core.Grid container justify="center">
      <@material-ui.core.Grid item class='contentWidth'>
         <img src='images/logo.svg' />
         <div class='padding'>
            <@material-ui.core.TextField
               id="email"
               label="EMail"
               defaultValue={"Enter EMail"}
               margin="normal"
               variant="outlined"
               fullWidth />
            <@material-ui.core.TextField
               id="password"
               label="Password"
               defaultValue={"Enter Password"}
               margin="normal"
               variant="outlined"
               fullWidth />
            <@material-ui.core.Button
               variant='contained'
               fullWidth={true}
               onClick={signInHandler} >
               Sign In
            </@material-ui.core.Button>
            <@material-ui.core.Button
               variant='contained'
               fullWidth={true}
               onClick={signUpHandler}
               class='signup' >
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

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

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
   .signup
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

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler signInHandler = (Event e) ->
{
   Element  emailEntry    = DomGlobal.document.getElementById("email");
   String   email         = ((HTMLInputElement)emailEntry).value;
   Element  passwordEntry = DomGlobal.document.getElementById("password");
   String   password      = ((HTMLInputElement)passwordEntry).value;

   doLogin(email, password);
};
/*------------------------------------------------------------------------------

@name       signUpHandler - signUp onClick event handler
                                                                              */
                                                                             /**
            SignUp onClick event handler as a public instance variable.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler signUpHandler = (Event e) ->
{
   Router.push(App.kPATH_SIGN_UP);
};
}//====================================// end Welcome ========================//
