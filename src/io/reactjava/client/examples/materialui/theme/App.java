/*==============================================================================

name:       GetStarted.java

purpose:    ReactJava website GetStarted page.

history:    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                  This program was created by Giavaneers
        and is the confidential and proprietary product of Giavaneers Inc.
      Any unauthorized use, reproduction or transfer is strictly prohibited.

                     COPYRIGHT 2019 BY GIAVANEERS, INC.
      (Subject to limited distribution and restricted disclosure only).
                           All rights reserved.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.materialui.theme;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.IUITheme;
import java.util.function.Consumer;
                                       // GetStarted =========================//
public class App extends AppComponentTemplate
{
                                       // class constants ------------------- //
public static final String kSTATE_OPEN = "open";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       openHandler - initialize
                                                                              */
                                                                             /**
            Initialize.

@return     void

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Consumer openHandler = (bOpen) ->
{
   setState(kSTATE_OPEN, bOpen);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   useState(kSTATE_OPEN, false);
   boolean bOpen = getStateBoolean(kSTATE_OPEN);
/*--
   <React.Fragment>
                                       <!-- App Bar --------------------------->
      <GeneralAppBar open={bOpen} openHandler={openHandler}></GeneralAppBar>
      <main class="layout">
                                       <!-- Hero Unit ------------------------->
         <div class="heroUnit">
            <@material-ui.core.Grid container justify="flex-first" spacing={16}
               class="heroUnitCaption">
               <@material-ui.core.Grid key=0 item>
                  <@material-ui.core.Typography
                     component="h1" variant="h4" color="textPrimary">
                     ReactJava Component
                  </@material-ui.core.Typography>
               </@material-ui.core.Grid>
            </@material-ui.core.Grid>
            <@material-ui.core.Typography
               variant="body1" align="left" color="textSecondary" gutterBottom>
               This page contains a description of the ReactJava Component class.
               It assumes you are familar with fundamental React and ReactJava
               concepts such as Components and Properties. If you're not, it's
               best to read them first.
            </@material-ui.core.Typography>
            <@material-ui.core.Divider />
         </div>
      </main>
                                       <!-- Side Drawer ----------------------->
      <SideDrawer open={bOpen} openHandler={openHandler} >
      </SideDrawer>
   </React.Fragment>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
   .toolbar : getTheme().getMixins().toolbar;
                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
   String   unit   = "" + getTheme().getSpacing().getUnit() + "px";
   String   unitX3 = IUITheme.cssLengthScale(unit, 3);
   String   unitX6 = IUITheme.cssLengthScale(unit, 6);
   String   unitX8 = IUITheme.cssLengthScale(unit, 8);
/*--
   .heroUnit
   {
      margin:    0 auto;
      max-width: 600px;
      padding:   {unitX8 + " 0" + unitX6};
   }
   .heroUnitCaption
   {
      flex-grow:     first;
      margin-bottom: {IUITheme.cssLengthScale(unit, 3)};
   }
   .layout
   {
      margin-left:  {unitX3};
      margin-right: {unitX3};
      width:        auto;
   }

   @media (min-width: {IUITheme.cssLengthAdd(unitX6, 900)})
   {
      .layout
      {
         margin-left:  auto;
         margin-right: auto;
         width:        900px;
      }
   }
--*/
}
}//====================================// end App ============================//
