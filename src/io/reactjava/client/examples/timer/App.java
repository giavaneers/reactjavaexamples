/*==============================================================================

name:       App.java

purpose:    Timer App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.timer;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import io.reactjava.client.core.react.AppComponentTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   useState("topLeft", new int[]{0,0});

   int[]  test = new int[]{0,1};
   List   list = Arrays.asList(test);
   int    size = list.size();
   Object copy = list.toArray();


   kLOGGER.logInfo("render() entered");
   int[] topLeft = (int[])getState("topLeft");
   if (topLeft[0] == 0)
   {
      DomGlobal.setInterval(
         (e) ->
         {
                                       // move down by 2px and to right by 1px//
                                       // and cause render() to be invoked    //
            int[] stateValue     = (int[])getState("topLeft");
                  stateValue[0] += 2;
                  stateValue[1] += 1;

            setState("topLeft", stateValue);
         }, 17);
   }
/*--
   <div style='width:100%; height:100%;'>
      <div style=
         'background-color: blue;
          position:         relative;
          height:           30px;
          width:            30px;
          top:              {topLeft[0]};
          left:             {topLeft[1]};
       />
   </div>
--*/
}
}//====================================// end App ============================//

