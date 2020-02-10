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
import io.reactjava.client.core.react.NativeObject;
import io.reactjava.client.core.react.Properties;
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
                                       // class variables ------------------- //
                                       // (none)                              //
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
