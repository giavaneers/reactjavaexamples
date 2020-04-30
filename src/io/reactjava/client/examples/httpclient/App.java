/*==============================================================================

name:       App.java

purpose:    HttpClient GET and POST.

history:    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.httpclient;

                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.IUITheme;
import io.reactjava.client.core.react.IUITheme.Breakpoints;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants ------------------- //
protected static final boolean kSRC_CFG_DEVELOPMENT = false;
                                       // logger                              //
public static final Logger     kLOGGER = Logger.newInstance();

protected static final String  kREQUEST_URL =
   kSRC_CFG_DEVELOPMENT
      ? "http://localhost:8080/examples/threebythree/getColor"
      : "http://reactjavabackend.appspot.com/examples/threebythree/getColor";

                                       // class variables ------------------- //
protected static Units units;          // theme based units                   //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       buttonClickHandler - button onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as an instance variable, accessible in
            markup.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler buttonClickHandler = (Event e) ->
{
                                       // assign the next color from  backend //
   try
   {
      HttpClient.post(kREQUEST_URL + "?color=yellow", null).subscribe(
         (HttpResponse rsp) ->
         {
            kLOGGER.logInfo("buttonClickHandler(): success");
         },
         (Throwable error) ->
         {
            kLOGGER.logError(error);
         });
   }
   catch(Exception error)
   {
      kLOGGER.logError(error);
   }
};
/*------------------------------------------------------------------------------

@name       squareClickHandler - square onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as an instance variable, accessible in
            markup.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler squareClickHandler = (Event e) ->
{
   final Element element = (Element)e.target;

                                       // request a color from the backend    //
   HttpClient.get(kREQUEST_URL).subscribe(
      (HttpResponse rsp) ->
      {
                                       // change the clicked element to green //
         element.setAttribute("style", "background-color:" + rsp.getText());
      },
      (Throwable error) ->
      {
         kLOGGER.logError(error);
      });
};
/*------------------------------------------------------------------------------

@name       getUnits - get theme based units
                                                                              */
                                                                             /**
            Get theme based units, required to be created only once per class
            load.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Units getUnits()
{
   if (units == null)
   {
      units = new Units();
   }
   return(units);
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <@material-ui.core.Grid container justify="center">
--*/
   for (int iRow = 0; iRow < 3; iRow++)
   {
/*--
      <@material-ui.core.Grid container spacing={8} class='contentWidth'>
--*/
      for (int iCol = 0; iCol < 3; iCol++)
      {
/*--
         <@material-ui.core.Grid item xs={4}>
            <div class='square' onClick={squareClickHandler}></div>
         </@material-ui.core.Grid>
--*/
      }
/*--
      </@material-ui.core.Grid>
--*/
   }
                                       // add a button at the bottom          //
/*--
      <@material-ui.core.Grid container class='contentWidth'>
         <@material-ui.core.Button
            class='button'
            variant='contained'
            fullWidth={true}
            onClick={buttonClickHandler} >
            Next Color Yellow
         </@material-ui.core.Button>
      </@material-ui.core.Grid>
   </@material-ui.core.Grid>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
   Units units = getUnits();
/*--
   .button
   {
      margin-top:  20px;
      background:  green;
      color:       white;
   }
   .square
   {
      background:  blue;
      padding-top: 100%
   }
   .contentWidth
   {
      margin-top: 4px;
   }
   @media (max-width: {units.sm})
   {
      .contentWidth {width: {units.xsDim};}
   }
   @media (min-width: {units.sm})
   {
      .contentWidth {width: {units.smDim};}
   }
   @media (min-width: {units.md})
   {
      .contentWidth {width: {units.mdDim};}
   }
   @media (min-width: {units.lg})
   {
      .contentWidth {width: {units.lgDim};}
   }
   @media (min-width: {units.xl})
   {
      .contentWidth {width: {units.xlDim};}
   }
--*/
}
/*==============================================================================

name:       Units - theme based units

purpose:    Theme based units

history:    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public class Units
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
protected String sm;                   // theme small breakpoint value        //
protected String md;                   // theme medium breakpoint value       //
protected String lg;                   // theme large breakpoint value        //
protected String xl;                   // theme extra large breakpoint value  //
protected String xsDim;                // theme extra small dimension         //
protected String smDim;                // theme small dimension               //
protected String mdDim;                // theme medium dimension              //
protected String lgDim;                // theme large dimension               //
protected String xlDim;                // theme extra large dimension         //

/*------------------------------------------------------------------------------

@name       Units - default constructor
                                                                              */
                                                                             /**
            Default constructor

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public Units()
{
   Breakpoints bkpts = getTheme().getBreakpoints();
   sm    = IUITheme.toPx(bkpts.getSizeSmall());
   md    = IUITheme.toPx(bkpts.getSizeMedium());
   lg    = IUITheme.toPx(bkpts.getSizeLarge());
   xl    = IUITheme.toPx(bkpts.getSizeExtraLarge());
   xsDim = IUITheme.cssLengthScale(sm, 0.5);
   smDim = IUITheme.cssLengthScale(sm, 0.8);
   mdDim = IUITheme.cssLengthScale(md, 0.8);
   lgDim = IUITheme.cssLengthScale(lg, 0.8);
   xlDim = IUITheme.cssLengthScale(xl, 0.8);
}
}//====================================// end Units ==========================//
}//====================================// end App ============================//
