/*==============================================================================

name:       App.java

purpose:    Titles App.

history:    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                  This program was created by Giavaneers
        and is the confidential and proprietary product of Giavaneers Inc.
      Any unauthorized use, reproduction or transfer is strictly prohibited.

                     COPYRIGHT 2018 BY GIAVANEERS, INC.
      (Subject to limited distribution and restricted disclosure only).
                           All rights reserved.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.login;
                                       // imports --------------------------- //
import io.reactjava.client.core.providers.auth.IAuthenticationService;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // route paths                         //
public static final String kPATH_LOGGED_IN = "LoggedIn";
public static final String kPATH_SIGN_UP   = "SignUp";
public static final String kPATH_WELCOME   = "";

                                       // component class                     //
public static final Class  kCLASS_LOGGED_IN = LoggedIn.class;
public static final Class  kCLASS_SIGN_UP   = SignUp.class;
public static final Class  kCLASS_WELCOME   = Welcome.class;

public static final Map<String,Class> kAPP_ROUTES =
   Collections.unmodifiableMap(
      new HashMap<String,Class>()
      {
         {
            put(kPATH_LOGGED_IN, kCLASS_LOGGED_IN);
            put(kPATH_SIGN_UP,   kCLASS_SIGN_UP);
            put(kPATH_WELCOME,   kCLASS_WELCOME);
         }
      });
                                       // auth configuration                  //
public static final String[] kAUTH_CONFIGURATION =
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

@name       App - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of App if successful.

@history    Mon Aug 28, 2017 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public App()
{
   super();
}
/*------------------------------------------------------------------------------

@name       App - constructor for specified properties
                                                                              */
                                                                             /**
            Constructor for specified properties

@return     An instance of App if successful.

@history    Mon Aug 28, 2017 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public App(
   Properties properties)
{
   super(properties);
}
/*------------------------------------------------------------------------------

@name       getNavRoutes - get navigation routes for application
                                                                              */
                                                                             /**
            Get map of component classname by route path.

@return     void

@history    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Map<String,Class> getNavRoutes()
{
   return(kAPP_ROUTES);
}
}//====================================// end App ============================//
