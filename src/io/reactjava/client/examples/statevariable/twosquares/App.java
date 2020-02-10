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
package io.reactjava.client.examples.statevariable.twosquares;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;
import java.util.function.Consumer;
                                       // App ================================//
public class App<P extends Properties> extends AppComponentTemplate
{
                                       // class constants ------------------- //
public static final String kSTATE_ON = "on";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       onhandler - initialize
                                                                              */
                                                                             /**
            Initialize.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer onHandler = (onValue) ->
{
   setState(kSTATE_ON, onValue);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
                                       // react complains when a state        //
                                       // variable is boolean                 //
   useState(kSTATE_ON, "false");
   String onValue = getStateString(kSTATE_ON);

                                       // react complains if an attribute     //
                                       // is not all lower case; so           //
                                       // 'stateChangeHandler' ->             //
                                       //    'statechangehandler'             //
/*--
   <div id={"App"}>
      <A on={onValue} statechangehandler={onHandler} id="A"></A>
      <B on={onValue.equals("true") ? "false" : "true"}
         statechangehandler={onHandler} id="B">
      </B>
   </div>
--*/
};
}//====================================// end App ============================//
