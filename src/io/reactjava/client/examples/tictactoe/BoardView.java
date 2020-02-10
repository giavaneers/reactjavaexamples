/*==============================================================================

name:       BoardView.java

purpose:    BoardView page.

history:    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.tictactoe;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.Component;

                                       // BoardView ==========================//
public class BoardView extends Component
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
/*--  <div class='board'> --*/
      for (int i = 0; i < 9; i++)
      {
         /*--
         <SubBoardView
            board={props.get(App.kKEY_BOARD)}
            subboardindex={i}
            key={i}
            movefcn={props.get(App.kKEY_MOVE_FCN)}
         >
         </SubBoardView>
         --*/
      }
/*-- </div> --*/
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
   .board
   {
      display:        flex;
      flex-direction: row;
      flex-wrap:      wrap;
   }
   @media (min-width: 576px)  {.board{height: 540px;  width: 540px;}}
   @media (min-width: 768px)  {.board{height: 720px;  width: 720px;}}
   @media (min-width: 992px)  {.board{height: 960px;  width: 960px;}}
   @media (min-width: 1200px) {.board{height: 1140px; width: 1140px;}}
--*/
};
}//====================================// end BoardView ======================//
