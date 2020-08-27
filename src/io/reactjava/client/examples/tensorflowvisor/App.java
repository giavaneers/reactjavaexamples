/*==============================================================================

name:       App.java

purpose:    Tensorflow Visor App.

history:    Fri Aug 14, 2020 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.tensorflowvisor;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import io.reactjava.client.core.react.INativeEffectHandler;
import io.reactjava.tensorflow.TensorflowAppTemplate;
import io.reactjava.tensorflow.components.visor.Visor;

                                       // App ================================//
public class App extends TensorflowAppTemplate
{
                                       // class constants --------------------//
protected static final Logger kLOGGER = Logger.newInstance();
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       handleEffectSansUpdate - handleEffect handler
                                                                              */
                                                                             /**
            handleEffect handler as a public instance variable which only
            handles componentDidMount, no onComponentUpdate() since it was
            declared in the rendor() method with an empty array as the second
            argument, and no onComponentWillUnmount since no cleanup function
            is provided.

            On componentDidMount, indirectly instantiates the Visor, which must
            done after the DOM is rendered.

@history    Thu Jun 25, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEffectHandler handleEffectSansUpdate = () ->
{
   kLOGGER.logInfo("App.handleEffect(): componentDidMount");

                                       // start a timer                       //
   final double[] myTimerId = {0};
   myTimerId[0] = DomGlobal.setInterval((e) ->
   {
      int count = getStateInt("count");
      switch(count)
      {
         case 0:
         {
            Visor.surface("Custom Height", "Tab 1");
            break;
         }
         case 1:
         {
            Visor.surface("Custom Weight", "Tab 2");
            break;
         }
         case 2:
         {
            Visor.surface("Custom Color", "Tab 3");
            break;
         }
         case 3:
         {
            DomGlobal.clearInterval(myTimerId[0]);
         }
      }
      setState("count", ++count);
   }, 3000);
                                       //  no cleanup function provided so no //
                                       //  handling of componentWillUnmount   //
   return(INativeEffectHandler.kNO_CLEANUP_FCN);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@return     void

@history    Fri Aug 14, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
                                       // passing an empty set of dependencies//
                                       // causes the effect handler to be     //
                                       // invoked only when mounted and       //
                                       // unmounted, not on update as would   //
                                       // occurr if used the single argument  //
                                       // useEffect() method                  //
   useEffect(handleEffectSansUpdate, new Object[0]);

                                       // state change once a second          //
   useState("count", 0);

   kLOGGER.logInfo("App.render(): entered");
/*--
   <@material-ui.core.Grid container>
      <@material-ui.core.Grid item xs={6}>
         <div style='background-color:blue;height:100%'>
         </div>
      </@material-ui.core.Grid>
      <@material-ui.core.Grid item xs={6}>
         <Visor />
      </@material-ui.core.Grid>
   </@material-ui.core.Grid>
--*/
};
/*------------------------------------------------------------------------------

@name       workflow - tensorflow workflow
                                                                              */
                                                                             /**
            Tensorflow workflow.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected void workflow(
   State state)
{
}
}//====================================// end App ============================//
