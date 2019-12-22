/*==============================================================================

name:       App.java

purpose:    Three By Three App version components.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree.components;

                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.core.providers.http.HttpClient;
import io.reactjava.client.core.providers.http.HttpResponse;
import io.reactjava.client.core.react.AppComponentTemplate;
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
   final Element element = (Element)e.target;

                                       // request a color from the backend    //
   HttpClient.get(
      "http://reactjavabackend.appspot.com/examples/threebythree/getColor")
      .subscribe(
         (HttpResponse rsp) ->
         {
                                       // change the clicked element to green //
            element.setAttribute("style", "background-color:" + rsp.getText());
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
public final void render()
{
/*--
   <Board numcolumns={4} clickhandler={squareClickHandler}></Board>
--*/
};
}//====================================// end App ============================//
