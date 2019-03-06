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
import com.google.gwt.user.client.Timer;
import io.reactjava.client.examples.tictactoe.Game.Board;
import io.reactjava.client.examples.tictactoe.Game.MonteCarloTreeSearchPlayer;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;
import java.util.function.Consumer;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_INIT;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_OPPONENT;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_PLAYER;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_PLAYING;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_START;
import static io.reactjava.client.examples.tictactoe.Game.kSTATUS_TIE;

                                       // App ================================//
public class App extends AppComponentTemplate<Properties>
{
                                       // class constants --------------------//
public static final String kKEY_BOARD          = "board";
public static final String kKEY_CELL_INDEX     = "cellindex";
public static final String kKEY_GRID_POSITION  = "gridposition";
public static final String kKEY_INIT_FCN       = "initfcn";
public static final String kKEY_MOVE_FCN       = "movefcn";
public static final String kKEY_PLAYER         = "player";
public static final String kKEY_STATISTICS     = "statistics";
public static final String kKEY_STATUS         = "status";
public static final String kKEY_SUBBOARD_INDEX = "subboardindex";

public static final long   kTHINK_TIME         = 100;

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       getBoard - get board
                                                                              */
                                                                             /**
            Get board.

@return     board

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected Board getBoard()
{
   return((Board)props.get(kKEY_BOARD));
}
/*------------------------------------------------------------------------------

@name       getPlayer - get player
                                                                              */
                                                                             /**
            Get player.

@return     player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected MonteCarloTreeSearchPlayer getPlayer()
{
   return((MonteCarloTreeSearchPlayer)props.get(kKEY_PLAYER));
}
/*------------------------------------------------------------------------------

@name       initFcn - initialize
                                                                              */
                                                                             /**
            Initialize.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer initFcn = (statusPrevious) ->
{
   props.set(kKEY_BOARD,  new Board());
   props.set(kKEY_PLAYER, new MonteCarloTreeSearchPlayer());

   if (statusPrevious.equals(kSTATUS_INIT))
   {
      Statistics stats = retrieveStatistics();
      if (stats == null)
      {
         stats = new Statistics();
      }
      props.set(kKEY_STATISTICS, stats);
      props.set(kKEY_STATUS, kSTATUS_START);
   }
   else
   {
      props.set(kKEY_STATUS, kSTATUS_PLAYING);
                                       // explicitly re-render since this     //
                                       // property change can affect          //
                                       // appearance. Perhaps updates can be  //
                                       // done automatically (like react      //
                                       // component state changes) or leverage//
                                       // react built-in update mechanism...  //
                                       // can functional components in react  //
                                       // be automatically or explicitly      //
                                       // updated?                            //
      update();
   }
};
/*------------------------------------------------------------------------------

@name       moveFcn - move function
                                                                              */
                                                                             /**
            Move function, invoked by cell click handler

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer<Integer> moveFcn = (move) ->
{
   if (getBoard().isValidAction(move))
   {
      if (updateBoard(move, kSTATUS_PLAYER) == kSTATUS_PLAYING)
      {
         new Timer()
         {
                                       // process the next opponent move on a //
                                       // new thread to avoid holding up the  //
                                       // event thread                        //
            public void run()
            {
               int opMove =
                  getPlayer().getMove(
                     getBoard(), move, kSTATUS_OPPONENT, kTHINK_TIME);

               updateBoard(opMove, kSTATUS_OPPONENT);
            }
         }.schedule(0);
      }
   }
};
/*------------------------------------------------------------------------------

@name       initialize - set properties
                                                                              */
                                                                             /**
            Set properties.

@return     void

@return     props     properties

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Properties initialize(
   Properties props)
{
   super.initialize(props);

   props.set(kKEY_INIT_FCN, initFcn);
   props.set(kKEY_MOVE_FCN, moveFcn);

   initFcn.accept(kSTATUS_INIT);
   return(props);
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   Statistics stats   = (Statistics)props.get(App.kKEY_STATISTICS);
   int        status  = props.getInt(App.kKEY_STATUS);
/*--
   <div class='container'>
      <BoardView
         board={props.get(App.kKEY_BOARD)}
         statistics={stats}
         status={status}
         movefcn={moveFcn}
      >
      </BoardView>
      <Modal
         statistics={stats}
         status={status}
         initfcn={initFcn}
      >
      </Modal>
   </div>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - parse styles
                                                                              */
                                                                             /**
            Parse styles.

@return     void

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
      flex:             1;
      flex-direction:   row;
      width:            100%;
      background-color: black;
      align-items:      center;
      justify-content:  center;
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
   Board      board = (Board)props.get(kKEY_BOARD);
   Statistics stats = (Statistics)props.get(kKEY_STATISTICS);

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

   props.set(kKEY_BOARD,      board);
   props.set(kKEY_STATISTICS, stats);
   props.set(kKEY_STATUS,     status);
                                       // explicitly re-render since this     //
                                       // property change can affect          //
                                       // appearance. Perhaps updates can be  //
                                       // done automatically (like react      //
                                       // component state changes) or leverage//
                                       // react built-in update mechanism...  //
                                       // can functional components in react  //
                                       // be automatically or explicitly      //
                                       // updated?                            //
   update();

   return(status);
}
/*------------------------------------------------------------------------------

@name       updateStatistics - update statistics to local storage
                                                                              */
                                                                             /**
            Update statistics to local storage

@return     void

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
