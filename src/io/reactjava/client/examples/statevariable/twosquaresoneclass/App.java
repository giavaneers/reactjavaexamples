/*==============================================================================

name:       App.java

purpose:    ReactJava TwoSquares State Variable Example.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.statevariable.twosquaresoneclass;
                                       // imports --------------------------- //
import elemental2.dom.Event;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
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

@name       onhandler - initialize
                                                                              */
                                                                             /**
            Initialize.

@return     void

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

@return     void

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
/*==============================================================================

name:       A - component A

purpose:    Component A

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class A extends Component
{
                                       // constants ------------------------- //
public static final String kPROPERTY_ON                   = "on";
public static final String kPROPERTY_STATE_CHANGE_HANDLER = "statechangehandler";
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable, accessible in
            markup.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   ((Consumer)props().get(kPROPERTY_STATE_CHANGE_HANDLER)).accept("true");
};
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
   String clas = "true".equals(props().getString(kPROPERTY_ON)) ? "on" : "off";
/*--
   <div class={clas} onClick={clickHandler} id="Adiv"></div>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .on
   {
      height:           300px;
      width:            300px;
      background-color: green;
   }
   .off
   {
      height:           300px;
      width:            300px;
      background-color: red;
   }
--*/
}
}//====================================// end A ==============================//
/*==============================================================================

name:       B - component B

purpose:    Component B

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class B extends Component
{
                                       // constants ------------------------- //
public static final String kPROPERTY_ON                   = "on";
public static final String kPROPERTY_STATE_CHANGE_HANDLER = "statechangehandler";
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable, accessible in
            markup.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   ((Consumer)props().get(kPROPERTY_STATE_CHANGE_HANDLER)).accept("false");
};
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
   String clas = "true".equals(props().getString(kPROPERTY_ON)) ? "on" : "off";
/*--
   <div class={clas} onClick={clickHandler} id="Bdiv"></div>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .on
   {
      height:           300px;
      width:            300px;
      background-color: green;
   }
   .off
   {
      height:           300px;
      width:            300px;
      background-color: red;
   }
--*/
}
}//====================================// end B ==============================//
}//====================================// end App ============================//
