/*==============================================================================

name:       App.java

purpose:    PDFViewer App.

history:    Mon Feb 24, 2020 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.pdf;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import io.reactjava.client.components.pdfviewer.PDFViewer;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.NativeObject;
import io.reactjava.client.core.react.Router;
import io.reactjava.client.core.react.Utilities;
import java.util.Map;
import java.util.function.Consumer;
                                       // App ================================//
public class App extends AppComponentTemplate
{

                                       // class constants --------------------//
public static final Logger kLOGGER  = Logger.newInstance();
public static final String kPDF_URL =
   //"https://storage.googleapis.com/reactjava.io/docs/ReactJavaDeveloperGuide.web.pdf";
   "pdfs/ReactJavaDeveloperGuide.web.pdf#929492837";

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
public INativeEventHandler clickHandler = (Event e) ->
{
   Component.forId("drawer").setState("show", true);
};
/*------------------------------------------------------------------------------

@name       clickHandlerRender - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandlerRender = (Event e) ->
{
   forceUpdate();
};
/*------------------------------------------------------------------------------

@name       getPDFViewer - get any PDFViewer
                                                                              */
                                                                             /**
            Get any PDFViewer.

@return     any PDFViewer

@history    Sun Mar 31, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected PDFViewer getPDFViewer()
{
   return((PDFViewer)Component.forId(PDFViewer.kCOMPONENT_ID_PDF_VIEWER));
}
/*------------------------------------------------------------------------------

@name       openHandler - open handler
                                                                              */
                                                                             /**
            Open handler.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer<Map<String,Object>> openHandler = (Map<String,Object> args) ->
{
   String url = (String)args.get("url");
   String id  = url != null ? url : (String)args.get("id");
   if (id == null)
   {
   }
   else if (id.startsWith("path:"))
   {
      Router.push(id.substring(id.indexOf(':') + 1).trim());
   }
   else if (id.startsWith("bookmark:"))
   {
                                       // ex: bookmark:{157,0,'XYZ',72,720,0} //
      getPDFViewer().navigateTo(id);
   }
   else if (Utilities.isURL(id))
   {
                                       // relative or absolute reference      //
      DomGlobal.window.open(id, "_blank");
   }
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@history    Mon Feb 24, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("show", false);

   kLOGGER.logInfo("App.render(): entered");

   NativeObject viewerStyle =
      NativeObject.with(
         "position", "absolute",
         "overflow", "auto",
         "top",      "20px",
         "bottom",   "0px",
         "left",     "0px",
         "width",    "100%");

   NativeObject pdfOptions =
      NativeObject.with(
         "pdfurl",      kPDF_URL,
         "viewerstyle", viewerStyle,
         "cover",       "#bdcff1");
/*--
   <div>
      <button onClick={clickHandlerRender}>Re-Render</button>
      <button onClick={clickHandler}>Open Sidebar</button>
      <Drawer id="drawer" openhandler={openHandler} />
      <PDFViewer pdfoptions={pdfOptions} />
   </div>
--*/
}
}//====================================// end App ============================//
