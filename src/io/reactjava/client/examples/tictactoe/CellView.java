/*==============================================================================

name:       CellView.java

purpose:    CellView view.

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
import java.util.function.Consumer;
                                       // CellView ===========================//
public class CellView extends Component
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
protected Board   board;               // board                               //
protected int     cellIndex;           // cell index                          //
protected Integer gridPos;             // grid position                       //

/*------------------------------------------------------------------------------

@name       clickHandler - cell onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as a public instance variable, accessible
            in markup.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   if (board.isValidAction(gridPos))
   {
                                       // invoke the app move function        //
      getMoveFunction().accept(gridPos);
   }
};
/*------------------------------------------------------------------------------

@name       getMoveFunction - get move function
                                                                              */
                                                                             /**
            Get move function

@return     move function

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected Consumer<Integer> getMoveFunction()
{
   return((Consumer<Integer>)props().get(App.kKEY_MOVE_FCN));
}
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
   if (board == null)
   {
      this.board         = (Board)props().get(App.kKEY_BOARD);
      this.cellIndex     = props().getInt(App.kKEY_CELL_INDEX);
      int  subBoardIndex = props().getInt(App.kKEY_SUBBOARD_INDEX);
      int  subBoardY     = subBoardIndex / 3;
      int  subBoardX     = subBoardIndex % 3;
      int  cellY         = subBoardY * 3 + cellIndex / 3;
      int  cellX         = subBoardX * 3 + cellIndex % 3;
      this.gridPos       = cellY * 9     + cellX;
   }
   int     player    = board.grid[gridPos];
   boolean bValid    = board.isValidAction(gridPos);
   String  brdStyle  = "border" + cellIndex;
   String  cellStyle = "cell " + (bValid ? "cellValid " : "") + brdStyle;
   String  textStyle = "cellText cellTextPlayer" + player;
   String  text      =
      player == Game.kSTATUS_PLAYER
         ? "X"
         : player == Game.kSTATUS_OPPONENT ? "O" : bValid ? "." : "";
/*--
  <div class={cellStyle} onClick={clickHandler}>
    <div class={textStyle}>
      {text}
    </div>
  </div>
--*/
};
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
   .cell
   {
      box-sizing:          border-box;
      border-style:        solid;
      border-left-color:   #666;
      border-right-color:  #666;
      border-top-color:    #666;
      border-bottom-color: #666;
      border-width:        3/addcss;
   }
   .cellValid
   {
      background-color:    #222;
      border-left-color:   #ddd;
      border-right-color:  #ddd;
      border-top-color:    #ddd;
      border-bottom-color: #ddd;
   }
   .cellText
   {
      text-align:          column;
      line-height:         first;
      width:               100%;
      height:              100%;
   }
   .cellTextPlayer1
   {
      color:               #a70;
   }
   .cellTextPlayer2
   {
      color:               #0af;
   }
   @media (min-width: 576px)
   {
      .cell{height: 55px; width: 55px;}
      .cellText{font-size: 55px;}
   }
   @media (min-width: 768px)
   {
      .cell{height: 75px; width: 75px;}
      .cellText{font-size: 75px;}
   }
   @media (min-width: 992px)
   {
      .cell{height: 101px; width: 101px;}
      .cellText{font-size: 101px;}
   }
   @media (min-width: 1200px)
   {
      .cell{height: 121px; width: 121px;}
      .cellText{font-size: 121px;}
   }
--*/
}
}//====================================// end CellView =======================//
