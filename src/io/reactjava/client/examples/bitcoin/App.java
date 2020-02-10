/*==============================================================================

name:       App.java

purpose:    Bitcoin App.

history:    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.bitcoin;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.MessageEvent;
import elemental2.dom.WebSocket;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.INativeEffectHandler;
import io.reactjava.client.core.react.NativeObject;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

import static elemental2.core.Global.JSON;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final Logger kLOGGER = Logger.newInstance();
                                       // websocket server endpoint           //
public static final String kSERVER_URL = "wss://ws.blockchain.info/inv";

                                       // read-only input attribute           //
public static final NativeObject kATTRIB_READ_ONLY =
   NativeObject.with("readOnly", true);

public static final double kSATOSHI = 100000000;

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
protected int numTransactions;         // new transaction notifications       //
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
protected void handleConversation(
   Double exchangeRate)
{
   Element textField = DomGlobal.document.getElementById("conversation");
   if (exchangeRate == null)
   {
      textField.textContent  = "ReactJava Bitcoin Example ---\n\n";
      textField.textContent += "Getting Bitcoins -> USD exchange rate.\n";
      HttpClient.get(
         "https://blockchain.info/ticker?cors=true")
         .subscribe(
            (HttpResponse rsp) ->
            {
               handleConversation(handleExchangeRate(rsp, textField));
            },
            (Throwable error) ->
            {
               kLOGGER.logError(error);
            });
   }
   else
   {
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
            handlePing(response, socket, textField);
         }
         else if ("utx".equals(op))
         {
            handleTransaction(response, socket, textField, exchangeRate);
         }
         else
         {
            throw new IllegalStateException("response op=" + response);
         }
      });
   }
}
/*------------------------------------------------------------------------------

@name       handleEffect - effect handler
                                                                              */
                                                                             /**
            effect handler.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEffectHandler handleEffect = () ->
{
   handleConversation(null);
};
/*------------------------------------------------------------------------------

@name       handleExchangeRate - initialize
                                                                              */
                                                                             /**
            Do socket conversation.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected double handleExchangeRate(
   HttpResponse  rsp,
   Element       textField)
{
   JsPropertyMap response = Js.asPropertyMap(JSON.parse(rsp.getText()));
   JsPropertyMap usd      = Js.asPropertyMap(response.get("USD"));
   double        rate     = Js.asDouble(usd.get("last"));

   textField.textContent += "Exchange rate=" + rate + ".\n";
   return(rate);
}
/*------------------------------------------------------------------------------

@name       handleRate - initialize
                                                                              */
                                                                             /**
            Do socket conversation.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void handlePing(
   JsPropertyMap response,
   WebSocket     socket,
   Element       textField)
{
   textField.textContent += "Server responded with \"pong\".\n";
   textField.textContent +=
      "Subscribing to notifications for all new bitcoin transactions.\n";

   socket.send(JSON.stringify(NativeObject.with("op","unconfirmed_sub")));
}
/*------------------------------------------------------------------------------

@name       handleTransaction - initialize
                                                                              */
                                                                             /**
            Do socket conversation.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected void handleTransaction(
   JsPropertyMap response,
   WebSocket     socket,
   Element       textField,
   Double        exchangeRate)
{
   JsPropertyMap x = Js.asPropertyMap(response.get("x"));

   double transacted = 0;
   for (Any out : Js.asArray(x.get("out")))
   {
      transacted += Js.asInt(Js.asPropertyMap(out).get("value"));
   }

   double bitcoins = transacted / kSATOSHI;
   double dollars  = bitcoins * exchangeRate;
   String sDollars = Double.toString(dollars);
          sDollars = sDollars.substring(0, sDollars.indexOf('.') + 3);

   textField.textContent +=
      "Received notification of new bitcoin transaction "
     + (++numTransactions) + " $" + sDollars + ".\n";

   if (numTransactions >= 100)
   {
                                       // close the socket                    //
      socket.close();
      textField.textContent += "Socket closed.\n";
   }
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Sat Jan 04, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
                                       // passing an empty set of dependencies//
                                       // causes the effect handler to be     //
                                       // invoked only when mounted and       //
                                       // unmounted, not on update as would   //
                                       // occurr if used the single argument  //
                                       // useEffect() method                  //
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
            Get component css.

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

