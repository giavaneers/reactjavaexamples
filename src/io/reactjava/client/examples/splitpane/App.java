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
package io.reactjava.client.examples.splitpane;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.StringLiteralList;

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

@name       getImportedNodeModules - get imported node modules
                                                                              */
                                                                             /**
            The react-split-pane SplitPanel tag cannot be inferred from the
            component javascript filename, which is 'index.cjs.js', and so
            the corresponding importedNodeModule is declared with the tag name
            included; namely 'react-split-pane as SplitPanel'.

@return     list of node module names.

@history    Sat Aug 29, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
@Override
protected StringLiteralList getImportedNodeModules()
{
   return(StringLiteralList.newInstance("react-split-pane as SplitPane"));
}
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
   <SplitPane split="horizontal" minSize={50} defaultSize={"80%"}>
      <div class='panel top' />
      <div class='panel bottom' />
   </SplitPane>
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
.Pane
{
   width:  100%;
   height: 100%;
   overflow: hidden;
}
.Pane1
{
   background-color:lightskyblue
}
.Pane2
{
   background-color:lightgreen
}
.Resizer
{
   background: #000;
   opacity: 0.2;
   z-index: 1;
   -moz-box-sizing: border-box;
   -webkit-box-sizing: border-box;
   box-sizing: border-box;
   -moz-background-clip: padding;
   -webkit-background-clip: padding;
   background-clip: padding-box;
}

.Resizer:hover
{
   -webkit-transition: all 2s ease;
   transition: all 2s ease;
}

.Resizer.horizontal
{
   height: 11px;
   margin: -5px 0;
   border-top: 5px solid rgba(255, 255, 255, 0);
   border-bottom: 5px solid rgba(255, 255, 255, 0);
   cursor: row-resize;
   width: 100%;
}

.Resizer.horizontal:hover
{
   border-top: 5px solid rgba(0, 0, 0, 0.5);
   border-bottom: 5px solid rgba(0, 0, 0, 0.5);
}

.Resizer.vertical
{
   width: 11px;
   margin: 0 -5px;
   border-left: 5px solid rgba(255, 255, 255, 0);
   border-right: 5px solid rgba(255, 255, 255, 0);
   cursor: col-resize;
}

.Resizer.vertical:hover
 {
   border-left: 5px solid rgba(0, 0, 0, 0.5);
   border-right: 5px solid rgba(0, 0, 0, 0.5);
}
.Resizer.disabled
{
   cursor: not-allowed;
}
.Resizer.disabled:hover
{
   border-color: transparent;
}
--*/
}
}//====================================// end App ============================//
