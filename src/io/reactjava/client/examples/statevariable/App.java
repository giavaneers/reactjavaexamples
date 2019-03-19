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
package io.reactjava.client.examples.statevariable;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import java.util.function.Consumer;
                                       // App ================================//
public class App extends AppComponentTemplate
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

@name       onHandler - initialize
                                                                              */
                                                                             /**
            Initialize.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer onHandler = (bOn) ->
{
   setState(kSTATE_ON, bOn);
};
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
   useState(kSTATE_ON, false);
   boolean bOn = getStateBoolean(kSTATE_ON);
/*--
   <React.Fragment>
      <A on={bOn}  onHandler={onHandler}></A>
      <B on={!bOn} onHandler={onHandler}></B>
   </React.Fragment>
--*/
};
}//====================================// end App ============================//
