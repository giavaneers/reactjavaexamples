/*==============================================================================

name:       Game.java

purpose:    TicTacToe game logic

history:    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.tictactoe;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import java.util.ArrayList;
import java.util.List;
                                       // Game ===============================//
public class Game
{
                                       // class constants --------------------//
private static final Logger kLOGGER = Logger.newInstance();

                                       // game status                         //
public static final int kSTATUS_INIT     = -3;
public static final int kSTATUS_START    = -2;
public static final int kSTATUS_PLAYING  = -1;
public static final int kSTATUS_TIE      = 0;
public static final int kSTATUS_PLAYER   = 1;
public static final int kSTATUS_OPPONENT = 2;

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //

/*==============================================================================

name:       Board - game board

purpose:    Game board

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class Board
{
                                       // constants ------------------------- //
                                       // subBoard index by position          //
public static final int[] kSUBBOARD_IDX_BY_POSITION =
{
   0, 0, 0, 1, 1, 1, 2, 2, 2,
   0, 0, 0, 1, 1, 1, 2, 2, 2,
   0, 0, 0, 1, 1, 1, 2, 2, 2,
   3, 3, 3, 4, 4, 4, 5, 5, 5,
   3, 3, 3, 4, 4, 4, 5, 5, 5,
   3, 3, 3, 4, 4, 4, 5, 5, 5,
   6, 6, 6, 7, 7, 7, 8, 8, 8,
   6, 6, 6, 7, 7, 7, 8, 8, 8,
   6, 6, 6, 7, 7, 7, 8, 8, 8
};
                                       // next subBoard index by position     //
public static final int[] kSUBBOARD_IDX_NEXT_BY_POSITION =
{
   0, 1, 2, 0, 1, 2, 0, 1, 2,
   3, 4, 5, 3, 4, 5, 3, 4, 5,
   6, 7, 8, 6, 7, 8, 6, 7, 8,
   0, 1, 2, 0, 1, 2, 0, 1, 2,
   3, 4, 5, 3, 4, 5, 3, 4, 5,
   6, 7, 8, 6, 7, 8, 6, 7, 8,
   0, 1, 2, 0, 1, 2, 0, 1, 2,
   3, 4, 5, 3, 4, 5, 3, 4, 5,
   6, 7, 8, 6, 7, 8, 6, 7, 8
};
                                       // possible positions by subBoard      //
public static final int[][] kPOSSIBLE_POSITIONS_BY_SUBBOARD =
{
   {0,   1,  2,  9, 10, 11, 18, 19, 20},
   {3,   4,  5, 12, 13, 14, 21, 22, 23},
   {6,   7,  8, 15, 16, 17, 24, 25, 26},
   {27, 28, 29, 36, 37, 38, 45, 46, 47},
   {30, 31, 32, 39, 40, 41, 48, 49, 50},
   {33, 34, 35, 42, 43, 44, 51, 52, 53},
   {54, 55, 56, 63, 64, 65, 72, 73, 74},
   {57, 58, 59, 66, 67, 68, 75, 76, 77},
   {60, 61, 62, 69, 70, 71, 78, 79, 80}
};
                                       // win configurtions                   //
public static final int[][] kWIN_CONFIGURATIONS =
{
   {0, 1, 2},
   {3, 4, 5},
   {6, 7, 8},
   {0, 3, 6},
   {1, 4, 7},
   {2, 5, 8},
   {0, 4, 8},
   {2, 4, 6}
};
                                       // win configurations by subBoard      //
public static final int[][][] kWIN_CONFIGURATIONS_BY_SUBBOARD = new int[9][8][3];
static
{
   for (int i = 0; i < 9; i++)
   {
      int[] positionsForSubBoard = kPOSSIBLE_POSITIONS_BY_SUBBOARD[i];
      for (int j = 0; j < 8; j++)
      {
         int[] winConfiguration = kWIN_CONFIGURATIONS[j];
         for (int k = 0; k < 3; k++)
         {
            int winPosition = positionsForSubBoard[winConfiguration[k]];
            kWIN_CONFIGURATIONS_BY_SUBBOARD[i][j][k] = winPosition;
         }
      }
   }
}
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
public int[] grid;                     // grid                                //
public int[] subWinners;               // subBoard winners                    //
public int   lastMove;                 // last move                           //

/*------------------------------------------------------------------------------

@name       BoardView - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of BoardView if successful.

@history    Mon Aug 28, 2017 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public Board()
{
   grid       = new int[81];
   subWinners = new int[9];
   lastMove   = -1;
}
/*------------------------------------------------------------------------------

@name       copy - copy specified board
                                                                              */
                                                                             /**
            Copy specified board

@return     void

@param      src      source to copy

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void copy(
   Board src)
{
   this.grid = new int[src.grid.length];
   System.arraycopy(src.grid, 0, this.grid, 0, src.grid.length);

   this.subWinners = new int[src.subWinners.length];
   System.arraycopy(src.subWinners, 0, this.subWinners, 0, src.subWinners.length);

   this.lastMove  = src.lastMove;
}
/*------------------------------------------------------------------------------

@name       calcSubWinner - calculate subBoard winner
                                                                              */
                                                                             /**
            Calculate subBoard winner

@return     void

@param      p     subBoard indices (0...8)

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int calcSubWinner(
   int p)
{
   int winner = 0;

   for (int i = 0; i < 8; i++)
   {
      int[] winPos = kWIN_CONFIGURATIONS_BY_SUBBOARD[p][i];
      int   first  = this.grid[winPos[0]];

      if (first != 0
            && first == this.grid[winPos[1]]
            && first == this.grid[winPos[2]])
      {
         winner = first;
         break;
      }
   }

   return(winner);
}
/*------------------------------------------------------------------------------

@name       indexOf - get index of array element with specified value
                                                                              */
                                                                             /**
            Get the first index of an array element with a specified value.

@return     the first index of an array element with a specified value or -first
            if not found

@param      array    array
@param      value    target value

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int indexOf(
   int[] array,
   int   value)
{
   int index = -1;
   for (int i = 0; i < array.length; i++)
   {
      if (array[i] == value)
      {
         index = 0;
         break;
      }
   }
   return(index);
}
/*------------------------------------------------------------------------------

@name       isValidAction - test if specified grid position is a valid action
                                                                              */
                                                                             /**
            Test if specified grid position is a valid action

@return     true iff specified grid position is a valid action

@param      gridPosition      gid position

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public boolean isValidAction(
   int gridPosition)
{
   return(indexOf(validActions(), gridPosition) >= 0);
}
/*------------------------------------------------------------------------------

@name       move - move
                                                                              */
                                                                             /**
            Move

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void move(
   int pos,
   int player)
{
   grid[pos] = player;
   lastMove  = pos;
                                       // refresh subBoard winner             //

   int subBoardIdx         = kSUBBOARD_IDX_BY_POSITION[pos];
   subWinners[subBoardIdx] = calcSubWinner(subBoardIdx);
}
/*------------------------------------------------------------------------------

@name       status - check for 3 aligned sub-tictactoe
                                                                              */
                                                                             /**
            Check for 3 aligned sub-tictactoe

@return     the current status

@param      validActions      valid actions

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int status(
   int[] validActions)
{
   int winner = kSTATUS_TIE;
   for (int i = 0; i < 8; i++)
   {
      int[] winpos = kWIN_CONFIGURATIONS[i];
      int   first = this.subWinners[winpos[0]];
      if (first != 0
            && first == subWinners[winpos[1]]
            && first == subWinners[winpos[2]])
      {
         winner = first;
         break;
      }
   }
   if (winner == kSTATUS_TIE)
   {
      if (validActions.length == 0)
      {
                                       // if there is no valid action left,   //
                                       // count number of subBoards won       //
         int np = 0, no = 0;
         for (int i = 0; i < 9; i++)
         {
            if (subWinners[i] == kSTATUS_PLAYER)
            {
               np++;
            }
            else if (subWinners[i] == kSTATUS_OPPONENT)
            {
               no++;
            }
         }

         winner =
            np > no ? kSTATUS_PLAYER : np < no ? kSTATUS_OPPONENT : kSTATUS_TIE;
      }
      else
      {
         winner = kSTATUS_PLAYING;
      }
   }

   return(winner);
}
/*------------------------------------------------------------------------------

@name       validActions - move
                                                                              */
                                                                             /**
            Move

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int[] validActions()
{
   List<Integer> validActionsList = new ArrayList<Integer>();

   if (lastMove != -1)
   {
      int nextAllowedSub = kSUBBOARD_IDX_NEXT_BY_POSITION[lastMove];

      if (subWinners[nextAllowedSub] == 0)
      {
         for (int i = 0; i < 9; i++)
         {
            int pos = kPOSSIBLE_POSITIONS_BY_SUBBOARD[nextAllowedSub][i];
            if (grid[pos] == 0)
            {
               validActionsList.add(pos);
            }
         }
      }

      if (validActionsList.size() == 0)
      {
                                       // subBoard is won or tie              //
         for (int s = 0; s < 9; s++)
         {
            if (subWinners[s] == 0)
            {
               for (int i = 0; i < 9; i++)
               {
                  int pos = kPOSSIBLE_POSITIONS_BY_SUBBOARD[s][i];
                  if (this.grid[pos] == 0)
                  {
                     validActionsList.add(pos);
                  }
               }
            }
         }
      }

   }
   else
   {
      for (int r = 0; r < 81; r++)
      {
          validActionsList.add(r);
      }
   }

   int[] validActions = new int[validActionsList.size()];
   for (int i = 0; i < validActions.length; i++)
   {
      validActions[i] = validActionsList.get(i);
   }
   return(validActions);
}
}//====================================// end BoardView ==========================//
/*==============================================================================

name:       MonteCarloTreeSearchNode - node

purpose:    Monte Carlo Tree Search node

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class MonteCarloTreeSearchNode
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // parent node                         //
protected MonteCarloTreeSearchNode parent;
                                       // first child node                    //
protected MonteCarloTreeSearchNode firstChild;
                                       // next sibling node                   //
protected MonteCarloTreeSearchNode next;
                                       // move                                //
protected int                      move;
                                       // associated player                   //
protected int                      player;
                                       // visit count                         //
protected int                      visitCount;
                                       // score                               //
protected double                   winScore;

/*------------------------------------------------------------------------------

@name       MonteCarloTreeSearchNode - constructor
                                                                              */
                                                                             /**
            Constructor

@return     An instance of MonteCarloTreeSearchNode if successful.

@history    Mon Aug 28, 2017 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public MonteCarloTreeSearchNode(
   MonteCarloTreeSearchNode parent,
   int                      move,
   int                      player)
{
   this.parent = parent;
   this.move   = move;
   this.player = player;
}
}//====================================// end MonteCarloTreeSearchNode =======//
/*==============================================================================

name:       MonteCarloTreeSearchPlayer - player

purpose:    Monte Carlo Tree Search player

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class MonteCarloTreeSearchPlayer
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables ------ //
                                       // last node                           //
protected MonteCarloTreeSearchNode lastNode;
                                       // opponent                            //
protected int                      opponent;
                                       // iteration count                     //
protected int                      iter;

/*------------------------------------------------------------------------------

@name       MonteCarloTreeSearchPlayer - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of MonteCarloTreeSearchPlayer if successful.

@history    Mon Aug 28, 2017 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public MonteCarloTreeSearchPlayer()
{
}
/*------------------------------------------------------------------------------

@name       backPropagate - back propogate
                                                                              */
                                                                             /**
            Back propogate.

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void backPropagate(
   MonteCarloTreeSearchNode fromNode,
   int                      status)
{
   for (MonteCarloTreeSearchNode n = fromNode; n != null; n = n.parent)
   {
      n.visitCount++;
      if (n.player == status)
      {
         n.winScore += 1;
      }
      else if (kSTATUS_TIE == status)
      {
         n.winScore += 0.5;
      }
   }
}
/*------------------------------------------------------------------------------

@name       expandNode - expand node
                                                                              */
                                                                             /**
            Expand node.

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected MonteCarloTreeSearchNode expandNode(
   MonteCarloTreeSearchNode fromNode,
   int[]                    validActions)
{
   int                      player = 3 - fromNode.player;
   MonteCarloTreeSearchNode res    = fromNode;
   MonteCarloTreeSearchNode last   = null;

   for (int pos : validActions)
   {
      res = new MonteCarloTreeSearchNode(fromNode, pos, player);
      if (last == null)
      {
         fromNode.firstChild = res;
      }
      else
      {
         last.next = res;
      }
      last = res;
   }

   return res;
}
/*------------------------------------------------------------------------------

@name       getMove - get move
                                                                              */
                                                                             /**
            Get move.

@return     move

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int getMove(
   Board board,
   int   opMove,
   long  maxTime)
{
   double magicConstant = 0.4;
   opponent             = 1;

                                 // reusing previous tree gives better results//
   MonteCarloTreeSearchNode root = null;
   if (this.lastNode == null)
   {
      root = new MonteCarloTreeSearchNode(null, opMove, opponent);
   }
   else
   {
      for (MonteCarloTreeSearchNode c = this.lastNode.firstChild;
            c != null;
            c = c.next)
      {
         if (c.move == opMove)
         {
            root        = c;
            root.parent = null;
            break;
         }
      }
   }
   if (root == null)
   {
      kLOGGER.logError("MonteCarloTreeSearchPlayer.getMove(): root is null.");
      root = new MonteCarloTreeSearchNode(null, opMove, opponent);
   }

   Board board2 = new Board();
   this.iter    = 0;

   long   start = System.currentTimeMillis();
   long   end   = start + maxTime;

   while (System.currentTimeMillis() < end)
   {
      board2.copy(board);

      MonteCarloTreeSearchNode promisingNode =
         selectPromisingNode(root, board2, magicConstant);

                                       // expand root or node with statistics //
      if (promisingNode == root || promisingNode.visitCount > 0)
      {
         int[] validActions = board2.validActions();

         if (board2.status(validActions) == kSTATUS_PLAYING)
         {
            promisingNode = this.expandNode(promisingNode, validActions);
            board2.move(promisingNode.move, promisingNode.player);
         }
      }

      int simStatus = this.simulateNode(promisingNode, board2);

      this.backPropagate(promisingNode, simStatus);
      this.iter++;
   }

   MonteCarloTreeSearchNode bestNode = root.firstChild;
   for (MonteCarloTreeSearchNode c = root.firstChild; c != null; c = c.next)
   {
      double diff =
         c.winScore / c.visitCount - bestNode.winScore / bestNode.visitCount;

      if (diff > 0 || (diff == 0 && c.visitCount > bestNode.visitCount))
      {
         bestNode = c;
      }
   }

   this.lastNode = bestNode;

   return(bestNode.move);
}
/*------------------------------------------------------------------------------

@name       selectPromisingNode - select promising node
                                                                              */
                                                                             /**
            Select promising node.

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected MonteCarloTreeSearchNode selectPromisingNode(
   MonteCarloTreeSearchNode fromNode,
   Board                    board,
   double                   magicConstant)
{
   MonteCarloTreeSearchNode n = fromNode;
   while (n.firstChild != null)
   {
      double                   maxUtc   = -Double.MAX_VALUE;
      MonteCarloTreeSearchNode maxChild = n.firstChild;
      for (MonteCarloTreeSearchNode c = n.firstChild; c != null; c = c.next)
      {
         if (c.visitCount == 0)
         {
                                       // no statistics => using this node    //
            maxChild = c;
            break;
         }

         double utc =
            c.winScore / c.visitCount
               + magicConstant * Math.sqrt(Math.log(n.visitCount)/c.visitCount);

         if (utc >= maxUtc)
         {
            maxUtc   = utc;
            maxChild = c;
         }
      }
                                       // update the board                    //
      board.move(maxChild.move, maxChild.player);

      n = maxChild;
   }
   return n;
}
/*------------------------------------------------------------------------------

@name       simulateNode - simulate node
                                                                              */
                                                                             /**
            Simulate node.

@return     void

@param      pos
@param      player

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected int simulateNode(
   MonteCarloTreeSearchNode node,
   Board                    board)
{
   int[] validActions = board.validActions();
   int   boardStatus  = board.status(validActions);
   if (boardStatus == opponent)
   {
      node.parent.winScore = -Double.MAX_VALUE;
   }
   else
   {
      int player = node.player;
      while (boardStatus == kSTATUS_PLAYING)
      {
         int move = validActions[(int)(Math.random() * validActions.length)];

         player = 3 - player;
         board.move(move, player);
         validActions = board.validActions();
         boardStatus  = board.status(validActions);
      }
   }

   return boardStatus;
}
}//====================================// end MonteCarloTreeSearchPlayer =====//
}//====================================// end Game ===========================//
