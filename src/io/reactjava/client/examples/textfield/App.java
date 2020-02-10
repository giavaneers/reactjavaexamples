/*==============================================================================

name:       App.java

purpose:    TextField Example App.

history:    Sat May 13, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                  This program was created by Giavaneers
        and is the confidential and proprietary product of Giavaneers Inc.
      Any unauthorized use, reproduction or transfer is strictly prohibited.

                     COPYRIGHT 2018 BY GIAVANEERS, INC.
      (Subject to limited distribution and restricted disclosure only).
                           All rights reserved.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.textfield;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEventHandler;
import jsinterop.base.Js;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final Logger kLOGGER = Logger.newInstance();
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
protected String           default1;   // input1 default value                //
protected String           default2;   // input2 default value                //
protected int              length1;    // length of input1                    //
protected int              length2;    // length of input2                    //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       clickHandler - onClick event handler
                                                                              */
                                                                             /**
            onClick event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   Element element = DomGlobal.document.getElementById("totalLength");
   ((HTMLInputElement)element).value = Integer.toString(length1 + length2);
};
/*------------------------------------------------------------------------------

@name       keyUpHandler - keyUp event handler
                                                                              */
                                                                             /**
            keyUp event handler as a public instance variable. A TextField
            does not intrinsicly support input of the RETURN character, so we
            add this keyboard event handler.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler keyUpHandler = (Event e) ->
{
   KeyboardEvent keyEvent = Js.uncheckedCast(e);
   switch(keyEvent.key)
   {
      case "Enter":
      {
                                       // flash a grey background             //
         HTMLInputElement element = (HTMLInputElement)keyEvent.target;
         element.setAttribute("style", "background-color:lightgrey");
         DomGlobal.setTimeout((et) ->
         {
            element.setAttribute("style", "background-color:inherit");
         }, 50);
         break;
      }
   }
};
/*------------------------------------------------------------------------------

@name       onChangeHandler - input change event handler
                                                                              */
                                                                             /**
            onChange event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler onChangeHandler = (Event e) ->
{
   HTMLInputElement element = (HTMLInputElement)e.target;
   String           id      = element.id;
   int              length  = element.value.length();
   if ("input1".equals(id))
   {
      length1 = length;
   }
   else
   {
      length2 = length;
   }
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created
            Wed Oct 17, 2018 10:30:00 (Giavaneers - LBM) renamed per suggestion
               by Ethan Elshyeb.

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   if (default1 == null)
   {
      default1 = "Cat in the Hat";
      default2 = "Dog in the Bog";
      length1  = default1.length();
      length2  = default2.length();
   }
/*--
   <div>
      <@material-ui.core.AppBar position="static" color="primary">
         <@material-ui.core.Toolbar>
            <@material-ui.core.Typography variant="h6" color="inherit">
               Strings Length Calculator
            </@material-ui.core.Typography>
         </@material-ui.core.Toolbar>
      </@material-ui.core.AppBar>
      <@material-ui.core.Grid container justify="center">
         <@material-ui.core.Grid container class="contentWidth">
            <@material-ui.core.Grid item xs={12}>
               <div class='gutter'></div>
               <@material-ui.core.TextField
                  id="input1"
                  label="Item1"
                  defaultValue={"Cat in the Hat"}
                  margin="normal"
                  variant="outlined"
                  onChange={onChangeHandler}
                  onKeyUp={keyUpHandler}
                  fullWidth
               />
               <@material-ui.core.TextField
                  id="input2"
                  label="Item2"
                  defaultValue={"Dog in the Blog"}
                  margin="normal"
                  variant="outlined"
                  onChange={onChangeHandler}
                  onKeyUp={keyUpHandler}
                  fullWidth
               />
               <div class='gutter'></div>
               <@material-ui.core.TextField
                  id="totalLength"
                  label="Total Length"
                  value={Integer.toString(length1 + length2)}
                  margin="normal"
                  variant="outlined"
                  fullWidth
               />
               <div class='gutter'></div>
               <@material-ui.core.Button
                  variant="outlined"
                  color="primary"
                  onClick={clickHandler}
                  fullWidth>
                  Calculate Length
               </@material-ui.core.Button>
            </@material-ui.core.Grid>
         </@material-ui.core.Grid>
      </@material-ui.core.Grid>
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
   .contentWidth
   {
      width: 300px;
   }
   .gutter
   {
      height: 25px;
      width:  100%;
   }
--*/
};
}//====================================// end App ============================//
