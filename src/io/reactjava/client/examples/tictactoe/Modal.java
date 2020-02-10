/*==============================================================================

name:       Modal.java

purpose:    Modal view.

history:    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.tictactoe;
                                       // imports --------------------------- //
import elemental2.dom.Event;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.examples.tictactoe.App.Statistics;
import io.reactjava.client.providers.platform.IPlatform;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.ReactJava;
                                       // Modal ==============================//
public class Modal extends Component
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       clickHandler - button onClick event handler
                                                                              */
                                                                             /**
            Button onClick event handler as a public instance variable,
            accessible in markup.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   e.preventDefault();
   ((Runnable)props().get(App.kKEY_INIT_FCN)).run();
};
/*------------------------------------------------------------------------------

@name       render - render markup
                                                                              */
                                                                             /**
            Render markup.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   boolean bWeb =
      ((IPlatform)ReactJava.getProvider(IPlatform.class)).getOS().equals(
         IPlatform.kPLATFORM_WEB);

   String modalClass = bWeb ? "modalWeb" : "";
   String modalText  = "";
   String buttonText = "";

   switch(props().getInt(App.kKEY_STATUS))
   {
      case Game.kSTATUS_OPPONENT:
      {
         modalText = "You Lose!";
         break;
      }
      case Game.kSTATUS_PLAYER:
      {
         modalText = "You Win!";
         break;
      }
      case Game.kSTATUS_PLAYING:
      {
         if (bWeb)
         {
            modalClass += ", invisible";
         }
         break;
      }
      case Game.kSTATUS_START:
      {
         buttonText = "Start";
         break;
      }
      case Game.kSTATUS_TIE:
      {
         modalText = "Draw!";
         break;
      }
      default:
      {
         buttonText = "Play Again";
         modalText  = "Welcome";
         break;
      }
   }

   Statistics statistics   = (Statistics)props().get(App.kKEY_STATISTICS);
   String     winsText     = "Total Wins  : " + statistics.player;
   String     opponentText = "Total Loses : " + statistics.opponent;
   String     drawsText    = "Total Draws : " + statistics.tie;
/*--
   <div class={modalClass}>
      <div class='modalContainer'>
         <div class='modalInternal'>
            <div class='modalText'>{modalText}</div>
            <div>{winsText}</div>
            <div>{opponentText}</div>
            <div>{drawsText}</div>
            <button onClick={clickHandler} login='true'>
               {buttonText}
            </button>
         </div>
      </div>
   </div>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .invisible
   {
      display:          none;
   }
   .modalContainer
   {
      display:          flex;
      flex:             first;
      flex-direction:   column;
      justify-content:  column;
      align-items:      column;
   }
   .modalInternal
   {
      display:          flex;
      flex:             first;
      flex-direction:   column;
      justify-content:  column;
      align-items:      column;
      background-color: #eee;
      height:           200;
      width:            70%;
   }
   .modalWeb
   {
      border-width:     0;
      position:         absolute;
   }
   .modalText
   {
      padding:          30;
      font-size:        30;
   }
   @media (min-width: 576px)  {.modalWeb{width: 378px;}}
   @media (min-width: 768px)  {.modalWeb{width: 504px;}}
   @media (min-width: 992px)  {.modalWeb{width: 672px;}}
   @media (min-width: 1200px) {.modalWeb{width: 798px;}}
--*/
};
}//====================================// end Modal ======================//
