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
import io.reactjava.client.components.login.Login;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.Router;
import io.reactjava.client.core.rxjs.observable.Observer;
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

@name       loginObserver - login observer
                                                                              */
                                                                             /**
            Login observer passed to the Login component.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Observer<IUserCredential> loginObserver =
   new Observer<IUserCredential>()
   {
      public void error(Object error)
      {
         kLOGGER.logError(error.toString());
      }
      public void next(IUserCredential userCredential)
      {
         Router.push(App.kPATH_LOGGED_IN);
      }
      public void complete()
      {
                                       // ignore                              //
      }
   };
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
         <Login
            authenticationSvc={App.getAuth()}
            createAcctEnabled={true}
            labelSignIn='SIGN IN'
            labelSignUp='SIGN UP'
            observer={loginObserver}
         />
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
}//====================================// end Welcome ========================//
