/*==============================================================================

name:       App.java

purpose:    Google Analytics Tracking Example App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.googleanalytics.tracking;
                                       // imports --------------------------- //
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.core.providers.analytics.IAnalyticsService;
import io.reactjava.client.core.providers.analytics.IAnalyticsService.EventNames;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Configuration.CloudServices;
import io.reactjava.client.core.react.IConfiguration.ICloudServices;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.ReactJava;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // unlike for other config parameters, //
                                       // if the only cloud service to be     //
                                       // used is Google Analytics, only the  //
                                       // 'trackingId' parameter need be      //
                                       // specified                           //
public static final ICloudServices kCLOUD_SERVICES_CONFIG =
   new CloudServices().setTrackingId("G-ZNP1NLDLLB");

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            Logs an ADD_TO_CART event to Google Analytics for the specified
            trackingId.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   IAnalyticsService analytics = ReactJava.getProvider(IAnalyticsService.class);
   analytics.logEvent(EventNames.ADD_TO_CART.value(), "Added item to cart");
};
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

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.



@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <div style='color:blue;marginTop:30px;fontSize:20px'>
      <h1>
         Analytics Tracking Example
      </h1>
      <button type="button" onClick={clickHandler}>
         Add item to cart
      </button>
   </div>
--*/
}
}//====================================// end App ============================//

