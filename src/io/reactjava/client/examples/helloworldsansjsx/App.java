/*==============================================================================

name:       App.java

purpose:    HelloWorldSansJSX App.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.helloworldsansjsx;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.ReactElement;
import io.reactjava.client.core.react.ElementDsc;
import io.reactjava.client.core.react.Properties;
import java.util.Stack;
import java.util.function.Function;
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

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   Function<Properties,ReactElement> fcn = (props) ->
   {
      ReactElement      element = null;
      Stack<ElementDsc> parents = new Stack<>();
      ElementDsc        root    = null;
      ElementDsc        elem;
      Properties        p;

      p =
         Properties.with(
            "className", "hello",
            "style",
            Properties.with(
               "color", "blue", "marginTop", "30px", "fontSize", "20px"),
            "id", getNextId());

      elem = ElementDsc.create(parents.size() > 0 ? parents.peek() : null,"h1", p);
      root = root == null ? elem : root;
      parents.push(elem);

      p    = Properties.with("id", getNextId());
      elem = ElementDsc.create(parents.size() > 0 ? parents.peek() : null,"span", p," Hello world! ");
      root = root == null ? elem : root;
      parents.pop();

      if (root != null)
      {
         element = ElementDsc.createElement(root);
      }
      return(element);
   };
   setComponentFcn(fcn);
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .hello {
      color: blue
   }
--*/
}
}//====================================// end App ============================//
