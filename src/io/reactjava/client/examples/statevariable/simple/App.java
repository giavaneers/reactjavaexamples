/*==============================================================================

name:       App.java

purpose:    Simple State Variable App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.statevariable.simple;
                                       // imports --------------------------- //
import elemental2.dom.Event;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEventHandler;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants ------------------- //
public static final String kSIZE = "300px";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("on", true);
   String background = getStateBoolean("on") ? "green" : "red";
/*--
   <div
      style='width:{kSIZE}; height:{kSIZE}; backgroundColor:{background};'
      onClick=
      {
         (INativeEventHandler)(Event e) ->
         {
            setState("on", !getStateBoolean("on"));
         }
      }
   >
   </div>
--*/
};
}//====================================// end App ============================//
