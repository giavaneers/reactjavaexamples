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
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.react.StringLiteralList;
import io.reactjava.client.providers.auth.IAuthenticationService;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Configuration.CloudServices;
import io.reactjava.client.core.react.IConfiguration.ICloudServices;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // route paths                         //
public static final String kPATH_LOGGED_IN = "LoggedIn";
public static final String kPATH_WELCOME   = "";

                                       // component class                     //
public static final Class  kCLASS_LOGGED_IN = LoggedIn.class;
public static final Class  kCLASS_WELCOME   = Welcome.class;

public static final Map<String,Class> kAPP_ROUTES =
   Collections.unmodifiableMap(
      new HashMap<String,Class>()
      {
         {
            put(kPATH_LOGGED_IN, kCLASS_LOGGED_IN);
            put(kPATH_WELCOME,   kCLASS_WELCOME);
         }
      });
                                       // auth configuration                  //
public static final ICloudServices kCLOUD_SERVICES_CONFIG =
   new CloudServices()
      .setAPIKey("AIzaSyDh9OrV7rghijudnkyQ9wSUz4BKZE8F-sI")
      .setProjectId("reactjava-f11e6")
      .setAppId("1:1074492811559:web:04a915c2562cdf92952102")
      .setAuthDomain("reactjava-f11e6.firebaseapp.com");

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

@name       getAuth - get authentication service provider
                                                                              */
                                                                             /**
            Get authentication service provider.

@return     authentication service provider.

@history    Sun Nov 02, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected static IAuthenticationService getAuth()
{
   if (auth == null)
   {
      auth = ReactJava.getProvider(IAuthenticationService.class);
   }
   return(auth);
}
/*------------------------------------------------------------------------------

@name       getCloudServicesConfig - get cloud services configuration
                                                                              */
                                                                             /**
            Get cloud services configuration.

@return     cloud services configuration.

@history    Sun Nov 02, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected ICloudServices getCloudServicesConfig()
{
   return(kCLOUD_SERVICES_CONFIG);
}
/*------------------------------------------------------------------------------

@name       getNavRoutes - get navigation routes for application
                                                                              */
                                                                             /**
            Get map of component classname by route path.

@history    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Map<String,Class> getNavRoutes()
{
   return(kAPP_ROUTES);
}
}//====================================// end App ============================//
