/*==============================================================================

name:       App.java

purpose:    TicTacToe App.

history:    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.tictactoe;
                                       // imports --------------------------- //
import com.google.gwt.storage.client.Storage;
import elemental2.dom.DomGlobal;
import io.reactjava.client.examples.tictactoe.Game.Board;
import io.reactjava.client.examples.tictactoe.Game.MonteCarloTreeSearchPlayer;
import io.reactjava.client.core.react.AppComponentTemplate;
import java.util.function.Consumer;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_INIT;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_OPPONENT;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_PLAYER;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_PLAYING;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_START;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_TIE;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final String kKEY_BOARD          = "board";
public static final String kKEY_CELL_INDEX     = "cellindex";
public static final String kKEY_INIT_FCN       = "initfcn";
public static final String kKEY_MOVE_FCN       = "movefcn";
public static final String kKEY_STATISTICS     = "statistics";
public static final String kKEY_STATUS         = "status";
public static final String kKEY_SUBBOARD_INDEX = "subboardindex";
public static final String kKEY_TURN           = "turn";

public static final long   kTHINK_TIME         = 100;

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // current board                       //
protected Board                      board;
                                       // current player                      //
protected MonteCarloTreeSearchPlayer player;
                                       // statistics                          //
protected Statistics                 stats;

/*------------------------------------------------------------------------------

@name       initFcn - initialize
                                                                              */
                                                                             /**
            Initialize.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Runnable initFcn = () ->
{
   board  = new Board();
   player = new MonteCarloTreeSearchPlayer();


   if (getStateInt(kKEY_STATUS) == kSTATUS_INIT)
   {
      stats = retrieveStatistics();
      if (stats == null)
      {
         stats = new Statistics();
      }
                                       // update state causing render         //
      setState(kKEY_STATUS, kSTATUS_START);
   }
   else
   {
                                       // update state causing render         //
      setState(kKEY_STATUS, kSTATUS_PLAYING);
   }
};
/*------------------------------------------------------------------------------

@name       moveFcn - move function
                                                                              */
                                                                             /**
            Move function, invoked by cell click handler

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer<Integer> moveFcn = (move) ->
{
   if (board.isValidAction(move))
   {
      if (updateBoard(move, kSTATUS_PLAYER) == kSTATUS_PLAYING)
      {
         //new Timer()
         //{
         //                              // process the next opponent move on a //
         //                              // new thread to avoid holding up the  //
         //                              // event thread                        //
         //   public void run()
         //   {
         //      int opMove = player.getMove(board, move, kTHINK_TIME);
         //      updateBoard(opMove, kSTATUS_OPPONENT);
         //   }
         //}.schedule(0);

         DomGlobal.setTimeout(
            (e) ->
            {

                                       // process the next opponent move on a //
                                       // new thread to avoid holding up the  //
                                       // event thread                        //
               int opMove = player.getMove(board, move, kTHINK_TIME);
               updateBoard(opMove, kSTATUS_OPPONENT);
            }, 0, new Object[]{board, move});
      }
   }
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState(kKEY_STATUS, kSTATUS_INIT);
   useState(kKEY_TURN,   kSTATUS_PLAYER);

   int status = getStateInt(kKEY_STATUS);
   if (kSTATUS_INIT == status)
   {
      initFcn.run();
   }
/*--
   <div class='container'>
      <BoardView board={board} statistics={stats} status={status} movefcn={moveFcn}>
      </BoardView>
      <Modal statistics={stats} status={status} initfcn={initFcn}>
      </Modal>
   </div>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - parse styles
                                                                              */
                                                                             /**
            Parse styles.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   #root
   {
      display:          flex;
      flex-direction:   column;
      min-height:       100vh;
   }
   .container
   {
      display:          flex;
      flex:             first;
      flex-direction:   row;
      width:            100%;
      background-color: black;
      align-items:      column;
      justify-content:  column;
   }
--*/
}
/*------------------------------------------------------------------------------

@name       retrieveStatistics - retrieve any statistics from local storage
                                                                              */
                                                                             /**
            Retrieve statistics from local storage

@return     statistics from local storage, or null if none found

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Statistics retrieveStatistics()
{
   Statistics stats = null;
   Storage localStorage = Storage.getLocalStorageIfSupported();
   if (localStorage != null)
   {
      String sStats = localStorage.getItem("@AppStore:stats");
      if (sStats != null)
      {
         String[] params = sStats.split(",");
         stats           = new Statistics();
         stats.player    = Integer.parseInt(params[0]);
         stats.opponent  = Integer.parseInt(params[1]);
         stats.tie       = Integer.parseInt(params[2]);
      }
   }
   return(stats);
}
/*------------------------------------------------------------------------------

@name       updateBoard - copy specified board
                                                                              */
                                                                             /**
            Copy specified board

@return     status

@param      src      source to copy

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int updateBoard(
   int move,
   int player)
{
   board.move(move, player);

   int[]   validActions = board.validActions();
   int     status       = board.status(validActions);
   boolean bUpdateStats = true;
   switch(status)
   {
      case kSTATUS_PLAYER:
      {
         stats.player++;
         break;
      }
      case kSTATUS_OPPONENT:
      {
         stats.opponent++;
         break;
      }
      case kSTATUS_TIE:
      {
         stats.tie++;
         break;
      }
      default:
      {
         bUpdateStats = false;
      }
   }

   if (bUpdateStats)
   {
      updateStatistics(stats);
   }
                                       // modify whose turn causing re-render //
   setState(kKEY_TURN,   player);
   setState(kKEY_STATUS, status);
   return(status);
}
/*------------------------------------------------------------------------------

@name       updateStatistics - update statistics to local storage
                                                                              */
                                                                             /**
            Update statistics to local storage

 @param      stats    new statistics

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void updateStatistics(
   Statistics stats)
{
   Storage localStorage = Storage.getLocalStorageIfSupported();
   if (localStorage != null)
   {
      String sStats = "" + stats.player + "," + stats.opponent + "," +stats.tie;
      localStorage.setItem("@AppStore:stats", sStats);
   }
}
/*==============================================================================

name:       Statistics - wrapper

purpose:    Public wrapper

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class Statistics
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // associated player                   //
public int player;                     // num player wins                     //
public int opponent;                   // num opponent wins                   //
public int tie;                        // num ties                            //

}//====================================// end Statistics =====================//
}//====================================// end App ============================//
