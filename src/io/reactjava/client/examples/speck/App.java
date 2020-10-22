/*==============================================================================

name:       App.java

purpose:    Speck Molecular Viewer App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.speck;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.components.speck.Speck;
import io.reactjava.client.core.react.INativeEffectHandler;
import io.reactjava.client.core.react.Utilities;
import io.reactjava.client.core.rxjs.functions.Action1;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final Logger kLOGGER  = Logger.newInstance();

public static final String kBAIO_MICROSERVICE_CONVERT_BASE_URL =
   "https://webservice-mna5yn6qga-uw.a.run.app/OBConvert?target=";

public static final String kSTATE_MOLECULE_DATA = "moleculeData";

public static final String kPROTEIN_ID_DEFAULT  = "6lu7";

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
            onClick event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
//public INativeEventHandler clickHandler = (Event e) ->
//{
//   getMoleculeData(kPROTEIN_ID_DEFAULT);
//};
/*------------------------------------------------------------------------------

@name       getCustomJavascripts - get custom javascripts
                                                                              */
                                                                             /**
            Get custom javascripts. This method is typically invoked at
            boot time.

@return     ordered list of javascript urls

@history    Fri May 22, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
@Override
protected List<String> getCustomJavascripts()
{
                                       // use the embedded javascript         //
   return(new ArrayList<>(
      Arrays.asList(getExportedResourceURL("javascript/reactjavaspeck.js"))));
}
/*------------------------------------------------------------------------------

@name       getMoleculeData - get molecule data
                                                                              */
                                                                             /**
            Get molecule data for specified proteindId from Baio Microservice
            and set kSTATE_MOLECULE_DATA with the result.

@param      proteinId      molecule proteinId

@history    Sun Nov 02, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void getMoleculeData(
   String proteinId)
{
   final int[]    urlIdx = {0};
   final long[]   begin  = {0};
   final String[] urls   =
   {
      kBAIO_MICROSERVICE_CONVERT_BASE_URL + proteinId + ".xyz",
      "speckSamples/" + proteinId + ".xyz"
   };

   final Action1<HttpResponse> onNext =
      (HttpResponse rsp) ->
      {
         switch(urlIdx[0])
         {
            case 0:
            {
               kLOGGER.logInfo(
                  "App.getMoleculeData(): baio microservice response msec="
                     + (System.currentTimeMillis() - begin[0]));
               break;
            }
            case 1:
            {
               kLOGGER.logInfo(
                  "App.getMoleculeData(): retrieved local sample, msec="
                     + (System.currentTimeMillis() - begin[0]));
               break;
            }
         }
                                       // add result to cache                 //
         String responseText = rsp.getText();
         Utilities.localStorageSet(proteinId + ".xyz", responseText);
         setState(kSTATE_MOLECULE_DATA, responseText);
      };

   Action1<?> onErrors[] = {null};
   Action1<?> onError    =
      (Throwable error) ->
      {
         switch(urlIdx[0])
         {
            case 0:
            {
               begin[0] = System.currentTimeMillis();
               HttpClient.get(urls[++urlIdx[0]]).subscribe(onNext, onErrors[0]);
               break;
            }
            case 1:
            {
               kLOGGER.logError(error);
            }
         }
      };

   onErrors[0] = onError;


                                       // try to get a cached value           //
   String cached = Utilities.localStorageGet(proteinId + ".xyz");
   if (cached != null)
   {
      setState(kSTATE_MOLECULE_DATA, cached);
   }
   else
   {
      begin[0] = System.currentTimeMillis();
      HttpClient.get(urls[urlIdx[0]]).subscribe(onNext, onErrors[0]);
   }
}
/*------------------------------------------------------------------------------

@name       handleEffectSansUpdate - handleEffect handler
                                                                              */
                                                                             /**
            handleEffect handler as a public instance variable which only
            handles componentDidMount, no onComponentUpdate() since it was
            declared in the rendor() method with an empty array as the second
            argument, and no onComponentWillUnmount since no cleanup function
            is provided.

            On componentDidMount, get molecule data.

@history    Thu Jun 25, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEffectHandler handleEffectSansUpdate = () ->
{
   getMoleculeData(kPROTEIN_ID_DEFAULT);
                                       //  no cleanup function provided so no //
                                       //  handling of componentWillUnmount   //
   return(INativeEffectHandler.kNO_CLEANUP_FCN);
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
   useState(kSTATE_MOLECULE_DATA, null);
                                       // passing an empty set of dependencies//
                                       // causes the effect handler to be     //
                                       // invoked only when mounted and       //
                                       // unmounted, not on update as would   //
                                       // occurr if used the single argument  //
                                       // useEffect() method                  //
   useEffect(handleEffectSansUpdate, new Object[0]);
/*--
   <Speck target={getStateString(kSTATE_MOLECULE_DATA)}/>
--*/
};
}//====================================// end App ============================//
