/*==============================================================================

name:       App.java

purpose:    Chat App using authentication and a database

history:    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                  This program was created by Giavaneers
        and is the confidential and proprietary product of Giavaneers Inc.
      Any unauthorized use, reproduction or transfer is strictly prohibited.

                     COPYRIGHT 2019 BY GIAVANEERS, INC.
      (Subject to limited distribution and restricted disclosure only).
                           All rights reserved.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.chat;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Configuration.CloudServices;
import io.reactjava.client.core.react.IConfiguration.ICloudServices;
import io.reactjava.client.core.react.NativeObject;
import io.reactjava.client.core.react.Properties;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.providers.auth.IAuthenticationService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // read-only input attribute           //
public static final NativeObject kATTRIB_READ_ONLY =
   NativeObject.with("readOnly", true);
                                       // route paths ---                     //
                                       // default path                        //
public static final String kPATH_LOG_IN  = "";
                                       // Chat class path assigning Chat      //
                                       // instance 'displayname' property     //
public static final String kDISPLAY_NAME = "displayname";
public static final String kPATH_CHAT    = "Chat/:" + kDISPLAY_NAME;

                                       // target component class              //
public static final Class  kCLASS_CHAT   = Chat.class;
public static final Class  kCLASS_LOG_IN = Login.class;

public static final Map<String,Class> kAPP_ROUTES =
   Collections.unmodifiableMap(
      new HashMap<String,Class>()
      {
         {
            put(kPATH_CHAT,   kCLASS_CHAT);
            put(kPATH_LOG_IN, kCLASS_LOG_IN);
         }
      });
                                       // auth configuration                  //
public static final ICloudServices kCLOUD_SERVICES_CONFIG =
   new CloudServices()
      .setAPIKey("AIzaSyDh9OrV7rghijudnkyQ9wSUz4BKZE8F-sI")
      .setProjectId("reactjava-f11e6")
      .setAppId("1:1074492811559:web:37c314c24f220974952102")
      .setAuthDomain("reactjava-f11e6.firebaseapp.com")
      .setDatabaseURL("https://reactjava-f11e6.firebaseio.com");

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

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

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

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public App(
   Properties properties)
{
   super(properties);
}
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

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Map<String,Class> getNavRoutes()
{
   return(kAPP_ROUTES);
}
}//====================================// end App ============================//
