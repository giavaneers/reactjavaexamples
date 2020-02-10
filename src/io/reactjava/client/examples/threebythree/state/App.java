/*==============================================================================

name:       App.java

purpose:    Three By Three App version state.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.state;

                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;

                                       // App ================================//
public class App extends AppComponentTemplate
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

@name       squareClickHandler - square onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as an instance variable, accessible in
            markup.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler squareClickHandler = (Event e) ->
{
                                       // get the square clicked              //
   final Component square = Component.forElement((Element)e.target);

                                       // request a color from the backend    //
   HttpClient.get(
      "http://reactjavabackend.appspot.com/examples/threebythree/getColor")
      .subscribe(
         (HttpResponse rsp) ->
         {
                                       // change the clicked square to the    //
                                       // new color by changing its state     //
            String newColor = rsp.getText();
            square.setState("color", newColor);
         },
         (Throwable error) ->
         {
            DomGlobal.window.console.log(error.getMessage());
         });
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation includes java with markup.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <Board
      numcolumns={3}
      clickhandler={squareClickHandler}
      squareclass={"SquareByRenderCSS"}
   />
--*/
}
}//====================================// end App ============================//
