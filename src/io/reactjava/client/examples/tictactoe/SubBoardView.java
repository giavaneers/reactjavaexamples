/*==============================================================================

name:       SubBoardView.java

purpose:    SubBoardView view.

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
import io.reactjava.client.examples.tictactoe.Game.Board;
import io.reactjava.client.core.react.Component;

                                       // SubBoardView =======================//
public class SubBoardView extends Component
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
   Board  board               = (Board)props().get(App.kKEY_BOARD);
   int    index               = props().getInt(App.kKEY_SUBBOARD_INDEX);
   int    winner              = board.subWinners[index];
   String borderStyle         = "border" + index;
   String subBoardStyle       = "subBoard " + borderStyle;
   String subBoardWinnerStyle = subBoardStyle + " subBoardWinner";

   if (winner == Game.kSTATUS_TIE)
   {
      /*--
      <div class={subBoardStyle}>
      --*/
      for (int i = 0; i < 9; i++)
      {
         /*--
         <CellView
            board={board}
            subboardindex={index}
            key={i}
            cellindex={i}
            movefcn={props.get(App.kKEY_MOVE_FCN)}
            onClick={clickHandler}
         >
         </CellView>
         --*/
      }
      /*--
      </div>
      --*/
   }
   else
   {
      String textStyle = "subBoardText cellTextPlayer" + winner;
      String text      = winner == Game.kSTATUS_PLAYER ? "X" : "O";
      /*--
      <div class={subBoardWinnerStyle}>
         <div class={textStyle}>{text} </div>
      </div>
      --*/
   }
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
   .border0
   {
      border-left-color:   #000;
      border-top-color:    #000;
   }
   .border1
   {
      border-top-color:    #000;
   }
   .border2
   {
      border-right-color:  #000;
      border-top-color:    #000;
   }
   .border3
   {
      border-left-color:   #000;
   }
   .border4
   {
   }
   .border5
   {
      border-right-color:  #000;
   }
   .border6
   {
      border-left-color:   #000;
      border-bottom-color: #000;
   }
   .border7
   {
      border-bottom-color: #000;
   }
   .border8
   {
      border-right-color:  #000;
      border-bottom-color: #000;
   }
   .cellTextPlayer1
   {
      color:               #a70;
   }
   .cellTextPlayer2
   {
      color:               #0af;
   }
   .subBoard
   {
      display:             flex;
      flex-direction:      row;
      flex-wrap:           wrap;
      box-sizing:          border-box;
      padding:             4px;
      border-style:        solid;
      border-width:        3px;
      border-left-color:   #1f9;
      border-right-color:  #1f9;
      border-top-color:    #1f9;
      border-bottom-color: #1f9;
   }
   .subBoardText
   {
      text-align:          column;
      line-height:         first;
      width:               100%;
   }
   @media (min-width: 576px)
   {
      .subBoard{height: 180px; width: 180px;}
      .subBoardText{font-size: 150px;}
   }
   @media (min-width: 768px)
   {
      .subBoard{height: 240px; width: 240px;}
      .subBoardText{font-size: 210px;}
   }
   @media (min-width: 992px)
   {
      .subBoard{height: 320px; width: 320px;}
      .subBoardText{font-size: 290px;}
   }
   @media (min-width: 1200px)
   {
      .subBoard{height: 380px; width: 380px;}
      .subBoardText{font-size: 350px;}
   }
--*/
};
}//====================================// end SubBoardView ===================//
