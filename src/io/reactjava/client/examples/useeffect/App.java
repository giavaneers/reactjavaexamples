/*==============================================================================

name:       App.java

purpose:    UseEffect App.

            Since ReactJava components are implemented as React functional
            components, the normal lifetime events such as componentDidMount and
            componenUpdate are not available. Instead, the useEffect hook is
            available.

history:    Mon Jan 06, 2020 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.useeffect;
                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEffectHandler;

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

@name       effectHandler - useEffect handler
                                                                              */
                                                                             /**
            useEffect handler invoked after DOM is initially updated, instead
            of componentDidMount.

@history    Mon Jan 06, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEffectHandler effectHandler = () ->
{
   Element square = DomGlobal.document.getElementById("square");
   String  style  = square.getAttribute("style");
   square.setAttribute("style", style + "background-color:green;");

                                       // no cleanup function                 //
   return(INativeEffectHandler.kNO_CLEANUP_FCN);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

            Passing an empty set of dependencies causes the effect handler to be
            invoked only when mounted and unmounted, not also on update as will
            occurr if the single argument useEffect() method is used.

@history    Mon Jan 06, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useEffect(effectHandler, new Object[0]);
/*--
   <div id='square' style='width:{kSIZE}; height:{kSIZE};'></div>
--*/
};
}//====================================// end App ============================//
