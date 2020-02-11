/*==============================================================================

name:       App.java

purpose:    Google Analytics Reporting Example App.

            see   "https://flaviocopes.com/google-analytics-api-nodejs/"
                  "#import-the-google-library"

history:    Fri Jan 03, 2020 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.googleanalytics.reportdata;
                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Configuration.CloudServices;
import io.reactjava.client.core.react.IConfiguration.ICloudServices;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
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

public static final String kACCESS_SCOPE_READ_ONLY =
   "https://www.googleapis.com/auth/analytics.readonly";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       getCloudServicesConfig - get cloud services configuration
                                                                              */
                                                                             /**
            Get cloud services configuration.

@return     cloud services configuration.

@history    Fri Jan 03, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected ICloudServices getCloudServicesConfig()
{
   return(kCLOUD_SERVICES_CONFIG);
}
/*------------------------------------------------------------------------------

@name       analyticsGet - get cloud services configuration
                                                                              */
                                                                             /**
            Get cloud services configuration.

@return     cloud services configuration.

@history    Fri Jan 03, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void analyticsGet()
{
   String req =
      "https://www.googleapis.com/analytics/v3/data/ga"
    + "?ids=ga%3A197589691"
    + "&start-date=30daysAgo"
    + "&end-date=yesterday"
    + "&metrics=ga%3Asessions%2Cga%3Abounces";

   req += "&access_token=ya29.ImG9B5nUoUWM6qtqjia-3v9S1D-5SR04JABfc2TtZnbCakUTily_i15zjdzz4kH6oVFWtrja1vKYVvpyatMZRYvcEZbDoD3R8k2yvrqmeN_sm0BxZzIXV0YpYTLpkNdd5W3z";

   HttpClient.get(req)
      .subscribe(
         (HttpResponse rsp) ->
         {
            DomGlobal.window.console.log(rsp);
         },
         (Throwable t) ->
         {
            DomGlobal.window.console.log(
               "AppComponentTemplate.analyticsGet(): " + t.getMessage());
         });
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Fri Jan 03, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("initialized", false);
   if (!getStateBoolean("initialized"))
   {
      analyticsGet();
   }
/*--
   <h1 style='color:blue;marginTop:30px;fontSize:20px'>
      Analytics ReportData Example
   </h1>
--*/
}
}//====================================// end App ============================//

