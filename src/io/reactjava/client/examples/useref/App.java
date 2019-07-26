/*==============================================================================

name:       App.java

purpose:    UseRef App.

            Note, the useRef hook is supported for research purposes only, since
            its functionality can be readily replaced in ReactJava by use of a
            declared component instance variable. See 'examples/statevariable'.

history:    Thu Jul 25, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.useref;
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

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable, accessible in
            markup.

            Note, the useRef hook is supported for research purposes only, since
            its functionality can be readily replaced in ReactJava by use of a
            declared component instance variable. See 'examples/statevariable'.

@return     void

@history    Thu Jul 25, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   setState("on", "true".equals(getStateString("on")) ? "false" : "true");
   setRef("clickCount", getRefInt("clickCount") + 1);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

            Note, the useRef hook is supported for research purposes only, since
            its functionality can be readily replaced in ReactJava by use of a
            declared component instance variable. See 'examples/statevariable'.

@return     void

@history    Thu Jul 25, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   useState("on", "true");
   useRef("clickCount", 0);

   String currentState = getStateString("on");
   String background   = "true".equals(currentState) ? "green" : "red";
   String clickCount   = Integer.toString(getRefInt("clickCount"));
/*--
   <div
      style='width:{kSIZE}; height:{kSIZE}; backgroundColor:{background};'
      onClick={clickHandler}
   >
      {"Click count = " + clickCount}
   </div>
--*/
};
}//====================================// end App ============================//
