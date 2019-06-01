/*==============================================================================

name:       Board.java

purpose:    Three By Three Board.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.components;

                                       // imports --------------------------- //
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.IUITheme;
import io.reactjava.client.core.react.IUITheme.Breakpoints;

                                       // Board ==============================//
public class Board extends Component
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
public void render()
{
   int numColumns;
   int gridColsEach;
                                       // normalize the closest integral fit  //
                                       // to the twelve column grid layout    //
   numColumns   = props().getInt("numcolumns");
   gridColsEach = 12 / numColumns;
   numColumns   = 12 / gridColsEach;
                                                                           /*--
   <@material-ui.core.Grid container justify="center">
                                                                           --*/
   for (int iRow = 0; iRow < numColumns; iRow++)
   {
                                                                           /*--
      <@material-ui.core.Grid container spacing={8} class='contentWidth' >
                                                                           --*/
      for (int iCol = 0; iCol < numColumns; iCol++)
      {
                                                                           /*--
         <@material-ui.core.Grid item xs={gridColsEach}>
            <SquareByRenderCSS clickhandler={props().get("clickhandler")}></SquareByRenderCSS>
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
