/*==============================================================================

name:       App.java

purpose:    Three By Three App version httpclient.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.step10.httpclient;

                                       // imports --------------------------- //
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
                                       // (none)                              //
                                       // class variables ------------------- //
protected static Units units;          // theme based units                   //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       squareClickHandler - square onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as an instance variable, accessible in
            markup.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler squareClickHandler = (Event e) ->
{
   final Element element = (Element)e.target;

                                       // request a color from the backend    //
   HttpClient.get(
      "http://reactjavabackend.appspot.com/examples/threebythree/getColor")
      .subscribe(
         (HttpResponse rsp) ->
         {
                                       // change the clicked element to green //
            element.setAttribute("style", "background-color:" + rsp.getText());
         },
         (Throwable error) ->
         {
            DomGlobal.window.console.log(error.getMessage());
         });
};
/*------------------------------------------------------------------------------

@name       getUnits - get theme based units
                                                                              */
                                                                             /**
            Get theme based units, required to be created only once per class
            load.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

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
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation includes java with markup.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

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
/*--
   </@material-ui.core.Grid>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.This implementation is all css, with no java
            code included.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
   Units units = getUnits();
/*--
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
