/*==============================================================================

name:       App.java

purpose:    Three By Three App version progress.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.progress;

                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.core.providers.http.HttpClient;
import io.reactjava.client.core.providers.http.HttpResponse;
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

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler squareClickHandler = (Event e) ->
{
                                       // get the square clicked              //
   final Component square = Component.forElement((Element)e.target);

                                       // start a timer that will signal a    //
                                       // progress indicator should be shown  //
                                       // if the request to the backend takes //
                                       // more than 500 msec to complete      //
   final double timeoutId =
      DomGlobal.setTimeout((eTimeout) ->
      {
                                       // signal the clicked square that a    //
                                       // color change is pending             //
         square.setState("color", "pending");
      }, 500);
                                       // request a color from the backend    //
   HttpClient.get(
      "http://reactjavabackend.appspot.com/examples/threebythree/getColor")
      .subscribe(
         (HttpResponse rsp) ->
         {
                                       // clear the timeout if it hasn't      //
                                       // executed already                    //
            DomGlobal.clearTimeout(timeoutId);

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

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
/*--
   <Board
      numcolumns={3}
      clickhandler={squareClickHandler}
      squareclass={"SquareByRender"}
   />
--*/
};
}//====================================// end App ============================//