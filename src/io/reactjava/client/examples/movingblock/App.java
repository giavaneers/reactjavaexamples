/*==============================================================================

name:       App.java

purpose:    Three By Three App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.movingblock;
                                       // imports --------------------------- //
import com.google.gwt.user.client.Timer;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;
                                       // App ================================//
public class App extends AppComponentTemplate<Properties>
{
                                       // class constants --------------------//
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
public int top;                        // top position                        //
public int left;                       // left position                       //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       App - default constructor
                                                                              */
                                                                             /**
            Required default constructor. This implementation is null, but it
            is not required to be.

@return     An instance of App iff successful.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public App()
{
}
/*------------------------------------------------------------------------------

@name       App - constructor for specified properties
                                                                              */
                                                                             /**
            Required constructor for specified properties. This implementation
            is essentially null, but it often is not.

@return     An instance of App iff successful.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public App(
   Properties props)
{
   super(props);
                                       // start timer to kick off every second//
   new Timer()
   {
      public void run()
      {
                                       // move down and to right by 2px each  //
         top  += 2;
         left += 2;
                                       // cause render() to be invoked        //
         update();
      }

   }.scheduleRepeating(100);
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
/*--
   <div style="width : 100%; height : 100%;">
      <div class='panel' />
   </div>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - parse styles
                                                                              */
                                                                             /**
            Parse styles.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
   String topValue  = "" + this.top  + "px";
   String leftValue = "" + this.left + "px";
/*--
   .panel
   {
      background-color: blue;
      position:         relative;
      height:           30px;
      width:            30px;
      top:              {topValue};
      left:             {leftValue};
   }
--*/
};
}//====================================// end App ============================//
