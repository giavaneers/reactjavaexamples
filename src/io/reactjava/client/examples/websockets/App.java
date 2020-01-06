/*==============================================================================

name:       App.java

purpose:    WebSockets App.

history:    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.websockets;
                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.MessageEvent;
import elemental2.dom.WebSocket;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEffectHandler;
import io.reactjava.client.core.react.NativeObject;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

import static elemental2.core.Global.JSON;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // websocket server endpoint           //
public static final String kSERVER_URL = "wss://ws.blockchain.info/inv";

                                       // read-only input attribute           //
public static final NativeObject kATTRIB_READ_ONLY =
   NativeObject.with("readOnly", true);
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       handleConversation - initialize
                                                                              */
                                                                             /**
            Do socket conversation.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void handleConversation()
{
   Element textField = DomGlobal.document.getElementById("conversation");
      textField.textContent  = "ReactJava Websockets Example ---\n\n";
      textField.textContent += "Opening socket to " + kSERVER_URL + ".\n";

   WebSocket socket = new WebSocket(kSERVER_URL);
   socket.addEventListener("open", e->
   {
      textField.textContent += "Connected.\n";

                                       // connected, so send server 'ping'    //
      textField.textContent += "Sending server \"ping\" message.\n";

      socket.send(JSON.stringify(NativeObject.with("op", "ping")));
   });
   socket.addEventListener("message", e ->
   {
                                    // server responded to 'ping'          //
      JsPropertyMap response =
         Js.asPropertyMap(JSON.parse(((MessageEvent<String>)e).data));

      String op = (String)response.get("op");
      if ("pong".equals(op))
      {
         textField.textContent += "Server responded with \"pong\".\n";

                                       // close the socket                    //
         socket.close();
         textField.textContent += "Socket closed.\n";
      }
      else
      {
         throw new IllegalStateException("response op=" + response);
      }
   });
}
/*------------------------------------------------------------------------------

@name       handleEffect - effect handler
                                                                              */
                                                                             /**
            effect handler.

@return     void

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEffectHandler handleEffect = () ->
{
   handleConversation();
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

            Passing an empty set of dependencies causes the effect handler to be
            invoked only when mounted and unmounted, not also on update as will
            occurr if the single argument useEffect() method is used.

@return     void

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useEffect(handleEffect, new Object[0]);
/*--
   <@material-ui.core.Grid container justify="center">
      <@material-ui.core.Grid item class='contentWidth'>
         <div class='padding'>
            <@material-ui.core.TextField
               id="conversation"
               multiline={true}
               rows=16
               rowsMax=16
               margin="normal"
               variant="outlined"
               fullWidth
               InputProps={App.kATTRIB_READ_ONLY}/>
          </div>
      </@material-ui.core.Grid>
   </@material-ui.core.Grid>
--*/
}
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.This implementation is all css, with no java
            code included.

@return     void

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
/*--
   .padding
   {
      padding:          16px;
      display:          block;
      box-sizing:       border-box;
   }
   .contentWidth
   {
   }
   @media (min-width: 320px)
   {
      .contentWidth {width: 300px;}
   }
   @media (min-width: 576px)
   {
      .contentWidth {width: 540px;}
   }
   @media (min-width: 768px)
   {
      .contentWidth {width: 720px;}
   }
   @media (min-width: 992px)
   {
      .contentWidth {width: 960px;}
   }
   @media (min-width: 1200px)
   {
      .contentWidth {width: 1140px;}
   }
--*/
}
}//====================================// end App ============================//

