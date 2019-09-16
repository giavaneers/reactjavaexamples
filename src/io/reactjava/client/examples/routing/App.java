/*==============================================================================

name:       App.java

purpose:    ReactJava routing example.

history:    Sun Apr 07, 2019 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.routing;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // route paths                         //
public static final String kPATH_A       = "A";
public static final String kPATH_B       = "B";
public static final String kPATH_DEFAULT = "";

                                       // component class                     //
public static final Class kCLASS_A =
   io.reactjava.client.examples.routing.A.class;

public static final Class kCLASS_B =
   io.reactjava.client.examples.routing.B.class;

public static final Map<String,Class> kAPP_ROUTES =
   Collections.unmodifiableMap(
      new HashMap<String,Class>()
      {
         {
            put(kPATH_A,       kCLASS_A);
            put(kPATH_B,       kCLASS_B);
            put(kPATH_DEFAULT, kCLASS_A);
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

@name       getNavRoutes - get navigation routes for application
                                                                              */
                                                                             /**
            Get map of component classname by route path.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Map<String,Class> getNavRoutes()
{
   return(kAPP_ROUTES);
}
}//====================================// end App ============================//
