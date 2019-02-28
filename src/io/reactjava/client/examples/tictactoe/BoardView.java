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
import io.reactjava.client.core.react.Properties;
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

@name       BoardView - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of BoardView if successful.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public BoardView()
{
   super();
}
/*------------------------------------------------------------------------------

@name       BoardView - constructor for specified properties
                                                                              */
                                                                             /**
            Constructor for specified properties

@return     An instance of BoardView if successful.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
@SuppressWarnings("unusable-by-js")
public BoardView(
   Properties props)
{
   super(props);
}
/*------------------------------------------------------------------------------

@name       render - render markup
                                                                              */
                                                                             /**
            Render markup.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
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

@return     void

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
