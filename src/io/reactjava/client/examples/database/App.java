/*==============================================================================

name:       App.java

purpose:    Keyboard App.

history:    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.database;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.dom.DomGlobal;
import io.reactjava.client.core.providers.database.IDatabaseService;
import io.reactjava.client.core.providers.database.IDatabaseService.IEventCallback;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.rxjs.observable.Observable;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // logger                              //
public static final Logger   kLOGGER = Logger.newInstance();

                                       // database config (same as auth)      //
public static final String[] kFIREBASE_CONFIGURATION =
{
   "AIzaSyC2lsGWFpARlWm2janyFT1f8tcUx7I9b-U",
   "pumajtourofheroes.firebaseapp.com",
   "https://pumajtourofheroes.firebaseio.com",
   "pumajtourofheroes",
   "pumajtourofheroes.appspot.com",
   "433064327713"
};
                                       // state variables ------------------- //
public static final String kSTATE_INITIAL             = "Initial";
public static final String kSTATE_CONFIGURE           = "Configure";
public static final String kSTATE_WRITE_FIRST         = "Write First";
public static final String kSTATE_READ_FIRST          = "Read One";
public static final String kSTATE_REMOVE_FIRST        = "Remove First";
public static final String kSTATE_READ_FIRST_REMOVED  = "Read First Removed";
public static final String kSTATE_READ_REGISTER       = "Read Register";
public static final String kSTATE_READING_ON          = "Reading On";
public static final String kSTATE_READ_DEREGISTER     = "Reading Off";
public static final String kSTATE_DONE                = "Done";

                                       // class variables ------------------- //
                                       // database service                    //
protected static IDatabaseService database;
                                       // public instance variables --------- //
                                       // global event handler                //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       databaseConfigure - configure the database service
                                                                              */
                                                                             /**
            Cnfigure the database service.

@return     an Observable to subscribe to to be notified of completion.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Observable databaseConfigure()
{
   Observable observable = database.configure(kFIREBASE_CONFIGURATION);
   return(observable);
}
/*------------------------------------------------------------------------------

@name       databaseReadDeregister - deregister read notifications
                                                                              */
                                                                             /**
            Deregister read notifications.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void databaseReadDeregister()
{
   database.getStop(
      "messages", IDatabaseService.kEVENT_TYPE_CHILD_ADDED, newChildCallback);
}
/*------------------------------------------------------------------------------

@name       databaseReadOnNewChild - read a record whenever a child is added
                                                                              */
                                                                             /**
            Read a record whenever a child id added to the database.

@return     an Observable to subscribe to to be notified of completion.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public IEventCallback databaseReadOnNewChild()
{
   IEventCallback callback =
      database.getStart(
         "messages", IDatabaseService.kEVENT_TYPE_CHILD_ADDED, newChildCallback);

   return(callback);
}
/*------------------------------------------------------------------------------

@name       databaseReadFirst - read a single record from the database
                                                                              */
                                                                             /**
            Read a single record from the database.

@return     an Observable to subscribe to to be notified of completion.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Observable databaseReadFirst()
{
   Observable observable = database.get("messages/message1");
   return(observable);
}
/*------------------------------------------------------------------------------

@name       databaseRemoveFirst - remove a single record from the database
                                                                              */
                                                                             /**
            Remove a single record from the database.

@return     an Observable to subscribe to to be notified of completion.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Observable databaseRemoveFirst()
{
   Observable observable = database.remove("messages/message1");
   return(observable);
}
/*------------------------------------------------------------------------------

@name       databaseWriteFirst - write a single record to the database
                                                                              */
                                                                             /**
            Write a single record to the database.

@return     an Observable to subscribe to to be notified of completion.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public Observable databaseWriteFirst(
   int index)
{
   Observable observable =
      database.put(
         "messages",
         new HashMap<String,String>()
         {{
            put("message" + index, "This is message " + index);
         }});

   return(observable);
}
/*------------------------------------------------------------------------------

@name       newChildCallback - new child callback
                                                                              */
                                                                             /**
            New child callback.

@param      dataSnapshot      snapshot of new child
@param      prevChildKey      previous child key

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public IEventCallback newChildCallback =
   (Map<String,Object> dataSnapshot, String prevChildKey) ->
   {
      int numWrites = getStateInt("numWrites");
      if (numWrites < 5)
      {
         kLOGGER.logInfo("New child " + numWrites + " reported.");
         for (String key : dataSnapshot.keySet())
         {
            kLOGGER.logInfo(key + " -> " + dataSnapshot.get(key));
         }
      }
      else
      {
         kLOGGER.logError(
            "New child " + numWrites + " reported even though deregisterd.");
      }
   };
/*------------------------------------------------------------------------------

@name       onError - shared subscriber onError handler
                                                                              */
                                                                             /**
            Shared subscriber onError handler.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes
public static final String kSTATE_INITIAL             = "Initial";
public static final String kSTATE_CONFIGURE           = "Configure";
public static final String kSTATE_WRITE_FIRST         = "Write First";
public static final String kSTATE_READ_FIRST          = "Read One";
public static final String kSTATE_REMOVE_FIRST        = "Remove First";
public static final String kSTATE_READ_FIRST_REMOVED  = "Read First Removed";
public static final String kSTATE_READ_REGISTER       = "Read Register";
public static final String kSTATE_READING_ON          = "Reading On";
public static final String kSTATE_READ_DEREGISTER     = "Reading Off";
public static final String kSTATE_DONE                = "Done";

                                                                              */
//------------------------------------------------------------------------------
public void onError(
   Object result)
{
   switch (getStateString("state"))
   {
      case kSTATE_CONFIGURE:
      {
         kLOGGER.logError("Database service configuration failed.");
         break;
      }
      case kSTATE_WRITE_FIRST:
      {
         kLOGGER.logError("Database write first operation failed.");
         break;
      }
      case kSTATE_READ_FIRST:
      {
         kLOGGER.logError("Database read first operation failed.");
         break;
      }
      case kSTATE_REMOVE_FIRST:
      {
         kLOGGER.logError("Database remove first operation failed.");
         break;
      }
      case kSTATE_READ_FIRST_REMOVED:
      {
         kLOGGER.logError("Database read first removed operation failed.");
         break;
      }
      case kSTATE_READ_REGISTER:
      {
         kLOGGER.logError("Database read register operation failed.");
         break;
      }
      case kSTATE_READING_ON:
      {
         kLOGGER.logError("Database reading on operation failed.");
         break;
      }
      case kSTATE_READ_DEREGISTER:
      {
         kLOGGER.logError("Database read deregister operation failed.");
         break;
      }
      default:
      {
         kLOGGER.logError("State inconsistency");
      }
   }
}
/*------------------------------------------------------------------------------

@name       onNext - shared subscriber onNext handler
                                                                              */
                                                                             /**
            Shared subscriber onNext handler.

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void onNext(
   Object     result)
{
   Observable observable   = null;
   String     currentState = getStateString("state");
   String     nextState    = currentState;
   int        numWrites    = getStateInt("numWrites");

   switch(getStateString("state"))
   {
      case kSTATE_INITIAL:
      {
         observable = databaseConfigure();
         nextState  = kSTATE_CONFIGURE;
         break;
      }
      case kSTATE_CONFIGURE:
      {
         kLOGGER.logInfo("Database service configuration succeeded.");

                                       // try writing a record                //
         observable = databaseWriteFirst(++numWrites);
         nextState  = kSTATE_WRITE_FIRST;
         break;
      }
      case kSTATE_WRITE_FIRST:
      {
         kLOGGER.logInfo("Database write operation succeeded.");

                                       // try reading it back                 //
         observable = databaseReadFirst();
         nextState  = kSTATE_READ_FIRST;
         break;
      }
      case kSTATE_READ_FIRST:
      {
         kLOGGER.logInfo("Database read operation succeeded:");

         Map<String,Object> valueMap = (Map<String,Object>)result;
         for (String key : valueMap.keySet())
         {
            kLOGGER.logInfo(key + " -> " + valueMap.get(key));
         }
                                       // try removing it                     //
         observable = databaseRemoveFirst();
         nextState  = kSTATE_REMOVE_FIRST;
         break;
      }
      case kSTATE_REMOVE_FIRST:
      {
         kLOGGER.logInfo("Database remove operation succeeded.");

                                       // try reading it back                 //
         observable = databaseReadFirst();
         nextState  = kSTATE_READ_FIRST_REMOVED;
         break;
      }
      case kSTATE_READ_FIRST_REMOVED:
      {
         kLOGGER.logInfo("Database read removed operation succeeded.");

                                       // check that nothing was read         //
         if (result != null)
         {
            kLOGGER.logError("Database record was not removed.");
            nextState  = kSTATE_DONE;
         }
         else
         {
            kLOGGER.logInfo("Database record was removed.");
            nextState = kSTATE_READ_REGISTER;
         }
         break;
      }
      case kSTATE_READ_REGISTER:
      {
         kLOGGER.logInfo("Database reading begin.");

         databaseReadOnNewChild();
         nextState  = kSTATE_READING_ON;
         break;
      }
      case kSTATE_READING_ON:
      {
         if (numWrites < 4)
         {
            numWrites++;
            kLOGGER.logInfo("Database writing record " + numWrites);
            observable = databaseWriteFirst(numWrites);
         }
         else
         {
            kLOGGER.logInfo("Database writing done");
            databaseReadDeregister();
            nextState  = kSTATE_READ_DEREGISTER;
         }
         break;
      }
      case kSTATE_READ_DEREGISTER:
      {
         kLOGGER.logInfo("Database reading deregistered.");

         if (numWrites < 7)
         {
            numWrites++;
            kLOGGER.logInfo("Database writing record " + numWrites);
            observable = databaseWriteFirst(numWrites);
         }
         else
         {
            kLOGGER.logInfo("Database writing done");
            nextState  = kSTATE_DONE;
         }
         break;
      }
      default:
      {
         kLOGGER.logError("State inconsistency");
      }
   }

   setState("state",     nextState);
   setState("numWrites", numWrites);

   if (observable != null)
   {
      observable.subscribe(
         response ->
         {
            onNext(response);
         },
         error ->
         {
            onError(error);
         });
   }
   else if (!kSTATE_DONE.equals(nextState))
   {
                                       // timeout instead of recursive call   //
      DomGlobal.setTimeout((e) ->{onNext(null);}, 0);
   }
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component. This implementation is all markup, with no java
            code included.

@return     void

@history    Wed Nov 27, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
   useState("state",     kSTATE_INITIAL);
   useState("numWrites", 0);
   if (database == null)
   {
                                       // get a database service instance     //
      database = ReactJava.getProvider(IDatabaseService.class);

                                       // start the database operations       //
      onNext(null);
   }
/*--
   <h1 style='color:blue;marginTop:30px;fontSize:20px'>
      {getStateString("state")}
   </h1>
--*/
}
}//====================================// end App ============================//
