/*==============================================================================

name:       SquareByRender.java

purpose:    Three By Three Square whose style is dynamically generated by
            the style attribute in render()

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.state;

                                       // imports --------------------------- //
import io.reactjava.client.core.react.Component;

                                       // SquareByRender =====================//
public class SquareByRender extends Component
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

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("color", "blue");
   String color = getStateString("color");
                                       // use Paper instead of div to allow   //
                                       // non-string parameter 'clickhandler" //
                                       // to be passed as a property by parent//
                                       // which can't be done for div         //
/*--
   <@material-ui.core.Paper
      style='backgroundColor:{color};paddingTop:100%'
      onClick={props().get("clickhandler")}
   />
--*/
}
}//====================================// end SquareByRender =================//
