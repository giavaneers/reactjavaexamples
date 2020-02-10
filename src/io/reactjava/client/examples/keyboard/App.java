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

@name       keyUpHandler - keyUp event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable, accessible in
            markup.

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

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("message", "Press a key: ");
   useState("listener", false);

   if (!getStateBoolean("listener"))
   {
      DomGlobal.document.body.addEventListener("keyup", keyUpHandler);
      setState("listener", true);
   }

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
