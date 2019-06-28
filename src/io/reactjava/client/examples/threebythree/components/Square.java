/*==============================================================================

name:       SquareByRenderCSS.java

purpose:    Three By Three SquareByRenderCSS.

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
                                       // SquareByRenderCSS =============================//
public class Square extends Component
{
                                       // class constants ------------------- //
                                       // (none)                              //
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
            Render component. This implementation includes only markup.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
/*--
   <div class='square' onClick={props().get("clickhandler")}></div>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css. This implementation is all css, with no java
            code included.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .square
   {
      background:  blue;
      padding-top: 100%
   }
--*/
}
}//====================================// end SquareByRenderCSS =========================//