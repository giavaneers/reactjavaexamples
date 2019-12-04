/*==============================================================================

name:       App.java

purpose:    Keyboard App.

history:    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.keyboard;
                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.KeyboardEvent;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;
import jsinterop.base.Js;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // global event handler                //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       initialize - initial setup
                                                                              */
                                                                             /**
            This implementation adds a global keyboard handler

@return     void

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Properties initialize(
   Properties initialProps)
{
                                       // let the super do its thing          //
   super.initialize(initialProps);
                                       // add a keyup handler to the body elem//
   DomGlobal.document.body.addEventListener("keyup", keyUpHandler);
   return(initialProps);
}
/*------------------------------------------------------------------------------

@name       keyUpHandler - keyUp event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable, accessible in
            markup.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public EventListener keyUpHandler = event ->
{
   KeyboardEvent keyEvent = Js.uncheckedCast(event);
   String        key      = keyEvent.key;
   String        message  = getStateString("message");
   switch(key)
   {
      case "Control":
      case "Meta":
      case "Shift":
      {
         break;
      }
      case "Backspace":
      {
         setState("message",message.substring(0,message.length() - 1));
         break;
      }
      case "Enter":
      {
         System.out.println("Enter key pressed.");
         break;
      }
      default:
      {
         setState("message", message + key);
      }
   }
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@return     void

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   useState("message", "Press a key: ");
/*--
   <h1 class='keyboard' style='color:blue;marginTop:30px;fontSize:20px'>
      {getStateString("message")}
   </h1>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .keyboard {
      color: blue
   }
--*/
}
}//====================================// end App ============================//
