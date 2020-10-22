/*==============================================================================

name:       App.java

purpose:    Demonstrates directly binding native React components

history:    Sat Aug 29, 2020 10:30:00 (Giavaneers - LBM) created

notes:      see "https://github.com/tomkp/react-split-pane"

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.splitpanel;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.components.splitpanel.SplitPanel;

                                       // App ================================//
public class App extends AppComponentTemplate
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

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Sat Aug 29, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <SplitPanel split="horizontal" minSize={50} defaultSize={"80%"}>
      <div class='panel top' >
         <@material-ui.core.Grid container>
            <@material-ui.core.Grid item xs={6}>
               <div class='leftPanel' />
            </@material-ui.core.Grid>
            <@material-ui.core.Grid item xs={6}>
               <div class='rightPanel' />
            </@material-ui.core.Grid>
         </@material-ui.core.Grid>
      </div>
      <div class='panel bottom' />
   </SplitPanel>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

            When assigned to be 'horizontal', the top pane is a 'div' with

               class="Pane horizontal Pane1"

            and the bottom pane is a 'div with

               class="Pane horizontal Pane2"

            Resizer styling gives a single pixel wide divider, but with a
            'grabbable' surface of 11 pixels thanks to
            background-clip: padding-box; for making transparent borders
            possible (tomkp)

@history    Sat Aug 29, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
.panel
{
   width:  100%;
   height: 100%;
}
.top
{
   background-color:lightskyblue
}
.bottom
{
   background-color:lightgreen
}
.leftPanel
{
   width:  100%;
   height: 100%;
}
.rightPanel
{
   width:  100%;
   height: 600px;
   background-color:blue
}
--*/
}
}//====================================// end App ============================//
