/*==============================================================================

name:       App.java

purpose:    Three By Three App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.threebythree;
                                       // imports --------------------------- //

import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.Properties;

                                       // App ================================//
public class App extends AppComponentTemplate<Properties>
{
                                       // class constants --------------------//
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
public String[] colors;                // a theme                             //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       buttonClickHandler - button onClick event handler
                                                                              */
                                                                             /**
            Button onClick event handler as a public instance variable,
            accessible via 'this' in markup.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler buttonClickHandler = (Event e) ->
{
                                       // reassign the colors                 //
   getColors();
                                       // re-render                           //
   update();
};
/*------------------------------------------------------------------------------

@name       cellClickHandler - cell onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as a public instance variable, accessible
            via 'this' in markup.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler cellClickHandler = (Event e) ->
{
                                       // the clicked element                 //
   Element element = (Element)e.target;
                                       // change the clicked element to the   //
                                       // third element of the colors array   //
   element.setAttribute("style", "background-color:" + getColor(-1));
};
/*------------------------------------------------------------------------------

@name       getColor- get background color for specified index
                                                                              */
                                                                             /**
            Get background color for specified index. Method accessible via
            'this' in markup.

@return     background color for specified index

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public String getColor(
   int idx)
{
   return(idx < 0 ? this.colors[2] : this.colors[idx % 2]);
}
/*------------------------------------------------------------------------------

@name       getColors - assign colors array
                                                                              */
                                                                             /**
            Assign colors array.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void getColors()
{
   String[] themes =
   {
      "blue,lightblue,yellow",
      "red,grey,blue",
      "lightcoral,lightpink,lightseagreen",
      "blue,white,red",
   };

   this.colors = themes[(int)(Math.random() * themes.length)].split(",");
}
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

                                       // create a set of colors              //
   getColors();
   return(props);
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
/*--
   <div class='container'>
      <div class='board'>
--*/
      for (int i = 0; i < 9; i++)
      {
/*--
         <div class='cell'
            style='background-color:{this.getColor(i)}'
            onClick={this.cellClickHandler} />
--*/
      }
/*--
         <@material-ui.core.Button
            class='button'
            variant='contained'
            fullWidth={true}
            onClick={this.buttonClickHandler}>
            Change Colors
         </@material-ui.core.Button>
         <ul>
--*/
         for (int i = 0; i < this.colors.length; i++)
         {
            String sKey  = Integer.toString(i);
            String color = this.colors[i];
/*--
            <li key={sKey}>{color}</li>
--*/
         }
/*--
         </ul>
      </div>
   </div>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .container
   {
      display:          flex;
      flex:             1;
      flex-direction:   row;
      width:            100%;
      align-items:      center;
      justify-content:  center;
   }
   .board
   {
      display:          flex;
      flex-direction:   row;
      flex-wrap:        wrap;
      margin-top:       40px;
   }
   .button
   {
      font-size:        18pt;
      margin-top:       20px;
   }
   .cell
   {
   }
   ul
   {
      font-size: 18pt;
   }
   @media (min-width: 320px)
   {
      .board{height: 300px;  width: 300px;}
      .cell {height:  100px;  width: 100px;}
      ul    {height:  100px;  width: 300px;}
      button{height:  100px;  width: 300px;}
   }
   @media (min-width: 576px)
   {
      .board {height: 540px;  width: 540px;}
      .cell {height:  180px;  width: 180px;}
      ul    {height:  100px;  width: 540px;}
      button{height:  100px;  width: 540px;}
   }
   @media (min-width: 768px)
   {
      .board {height: 720px;  width: 720px;}
      .cell {height:  240px;  width: 240px;}
      ul    {height:  100px;  width: 720px;}
      button{height:  100px;  width: 720px;}
   }
   @media (min-width: 992px)
   {
      .board{height:  960px;  width: 960px;}
      .cell {height:  320px;  width: 320px;}
      ul    {height:  100px;  width: 960px;}
      button{height:  100px;  width: 960px;}
   }
   @media (min-width: 1200px)
   {
      .board{height: 1140px; width: 1140px;}
      .cell {height:  380px; width:  380px;}
      ul    {height:  100px;  width: 1140px;}
      button{height:  100px;  width: 1140px;}
   }
--*/
}
}//====================================// end App ============================//
