/*==============================================================================

name:       Modal.java

purpose:    Modal Dialog.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.modal;
                                       // imports --------------------------- //
import elemental2.dom.Event;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
                                       // Modal ==============================//
public class Modal extends Component
{
                                       // class constants --------------------//
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

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   setState("show", false);
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
   useState("show", false);
   if (getStateBoolean("show"))
   {
/*--
   <div class="backdrop">
      <div class="modal">
         <button class="close" onClick={clickHandler}>Close</button>
         <div class="content">{props().getString("msg")}</div>
      </div>
   </div>
--*/
   }
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .backdrop
   {
      z-index:          999;
      position:         fixed;
      top:              0px;
      bottom:           0px;
      left:             0px;
      right:            0px;
      background-color: rgba(0,0,0,0.3);
      padding:          50px;
   }
   .modal
   {
      position:         relative;
      border-radius:    5px;
      max-width:        500px;
      min-height:       300px;
      margin:           auto;
      padding:          10px;
      background-color: white;
   }
   .close
   {
      position:         relative;
      float:            right;
      border-radius:    5px;
      width:            50px;
      height:           50px;
   }
   .content
   {
      position:         relative;
      margin-top:       50px;
   }
--*/
}
}//====================================// end Modal ==========================//
