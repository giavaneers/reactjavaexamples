/*==============================================================================

name:       Chat.java

purpose:    Chat example.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.chat;

                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.KeyboardEvent;
import io.reactjava.client.providers.database.IDatabaseService;
import io.reactjava.client.providers.database.IDatabaseService.IEventCallback;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.rxjs.observable.Observable;
import java.util.HashMap;
import java.util.Map;
import jsinterop.base.Js;
                                       // Chat ===============================//
public class Chat extends Component
{
                                       // class constants ------------------- //
public static final Logger kLOGGER = Logger.newInstance();

                                       // class variables ------------------- //
                                       // database service provider           //
public static IDatabaseService database;
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       initialize - initialize
                                                                              */
                                                                             /**
            Configure the database service.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void initialize()
{
   if (database == null)
   {
                                       // get a database service instance     //
      database = ReactJava.getProvider(IDatabaseService.class);

                                       // clear any existing messages         //
      Observable oClear = database.remove("Messages/PublicChat");
      oClear.subscribe(
         removeResponse ->
         {
                                       // successfully cleared ...            //
            kLOGGER.logInfo("Messages/PublicChat removed");

                                       // register for all child additions to //
                                       // the PublicChat/Messages node        //
            database.getStart(
               "Messages/PublicChat",
               IDatabaseService.kEVENT_TYPE_CHILD_ADDED,
               newChildCallback);
         },
         error ->
         {
                                       // clear unsuccessful                  //
            kLOGGER.logInfo("Messages/PublicChat couldn't be removed");
         });
   }
}
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
         databaseWriteMessage((HTMLInputElement)keyEvent.target);
         break;
      }
   }
};
/*------------------------------------------------------------------------------

@name       newChildCallback - new child callback
                                                                              */
                                                                             /**
            New child callback.

            This will be invoked initially for each of the child records that
            already exists in the database, and subsequently as each new child
            is added.

            The snapshot is a Map whose sole key is the name of the child; that
            is, the last element of the child path. The value is the Map of
            fileldname and value tuples for the child, in this case
            'message' : message string.

@param      value             snapshot of new child
@param      anyPrevChildKey   any previous child key (ignored here)

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public IEventCallback newChildCallback =
   (Map<String, Map<String,Object>> value, String anyPrevChildKey) ->
   {
      String childName = value.keySet().toArray(new String[0])[0];

                                       // get the message string of the child //
      String newMessage = (String)value.get(childName).get("message");

                                       // append the message to the chat      //
      DomGlobal.document.getElementById("chat").textContent += newMessage + "\n";
   };
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Thu Dec 12, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <@material-ui.core.Grid container justify="center">
      <@material-ui.core.Grid item class='contentWidth'>
         <div class='padding'>
            <@material-ui.core.TextField
               id="chat"
               multiline={true}
               rows=16
               rowsMax=16
               margin="normal"
               variant="outlined"
               fullWidth
               InputProps={App.kATTRIB_READ_ONLY}/>
          </div>
         <div class='padding'>
            <@material-ui.core.TextField
               id="message"
               label="Message"
               placeholder="Enter Message"
               margin="normal"
               variant="outlined"
               fullWidth
               onKeyUp={keyUpHandler} />
         </div>
      </@material-ui.core.Grid>
   </@material-ui.core.Grid>
--*/
};
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
/*------------------------------------------------------------------------------

@name       databaseWriteMessage - write message to database
                                                                              */
                                                                             /**
            Write message to database.

@param      content     messageString

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void databaseWriteMessage(
   HTMLInputElement inputElement)
{
   String content = inputElement.value;
   if (content.length() > 0)
   {
                                       // prepend with the username assigned  //
                                       // with the route                      //
      String displayName = props().getString(App.kDISPLAY_NAME);

      content = "(" + displayName + ") " + content;

                                       // the new child message name is the   //
                                       // current timestamp                   //
      String newEntryName = Long.toString(System.currentTimeMillis());

                                       // the new child reference path        //
      String entryPath = "Messages/PublicChat/message" + newEntryName;

                                       // package the new child value         //
      Map<String,String> value = new HashMap<>();
      value.put("message", content);

                                       // write the new child                 //
      Observable observable = database.put(entryPath, value);
      observable.subscribe(
         successfulResponse ->
         {
                                       // newChildCallback() will have been   //
                                       // invoked                             //
            kLOGGER.logInfo("Wrote " + newEntryName + "!");

                                       // clear the TextField                 //
            inputElement.value = "";
         },
         error ->
         {
            kLOGGER.logError("Error writing " + newEntryName + "!");
         });
   }
};
}//====================================// end Chat =======================//
