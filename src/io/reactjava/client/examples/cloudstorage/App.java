/*==============================================================================

name:       App.java

purpose:    Cloud storage

history:    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

notes:
                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.cloudstorage;

                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import elemental2.core.ArrayBuffer;
import elemental2.core.Float32Array;
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Observable;
import io.reactjava.client.core.react.Subscriber;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import io.reactjava.client.providers.http.IHttpClient;
import io.reactjava.client.providers.http.IHttpResponse.ResponseType;
import jsinterop.base.Js;

import static io.reactjava.client.providers.http.IHttpClientBase.kGET;
import static io.reactjava.client.providers.http.IHttpClientBase.kPOST;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants ------------------- //
protected static final boolean kSRC_CFG_DEVELOPMENT = true;
                                       // logger                              //
public static final Logger     kLOGGER = Logger.newInstance();

protected static final String  kREQUEST_READ_URL =
   kSRC_CFG_DEVELOPMENT
      ? "http://localhost:8080/archiver/read/"
      : "http://hellotensorflowbackend.appspot.com/archiver/get/";

protected static final String  kREQUEST_WRITE_URL =
   kSRC_CFG_DEVELOPMENT
      ? "http://localhost:8080/archiver/write/"
      : "http://hellotensorflowbackend.appspot.com/archiver/set/";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       fileRead - read file
                                                                              */
                                                                             /**
            Read file

@params     path      file path: bucketname/pathname

@history    Thu May 14, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public Observable<ArrayBuffer> fileRead(
   String path)
{
   Observable<ArrayBuffer> observable = Observable.create(
      (Subscriber<ArrayBuffer> subscriber) ->
      {
         new HttpClient()
            .setURL(kREQUEST_READ_URL + path)
            .setMethod(kGET)
            .setResponseType(ResponseType.kARRAYBUFFER)
            .send((byte[])null)
            .subscribe(
               (HttpResponse rsp) ->
               {
                  subscriber.next(rsp.getArrayBuffer());
                  subscriber.complete();
               },
               (Throwable error) ->
               {
                  kLOGGER.logError(error);
               });
         return(subscriber);
      });

   return(observable);
}
/*------------------------------------------------------------------------------

@name       fileWrite - write file
                                                                              */
                                                                             /**
            Write file

@params     path      file path: bucketname/pathname
@params     bytes     file content

@history    Thu May 14, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public Observable<String> fileWrite(
   String path,
   byte[] bytes)
{
   return(fileWrite(path, bytes, null));
}
/*------------------------------------------------------------------------------

@name       fileWrite - write file
                                                                              */
                                                                             /**
            Write file

@params     path      file path: bucketname/pathname
@params     bytes     file content

@history    Thu May 14, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public Observable<String> fileWrite(
   String      path,
   ArrayBuffer arrayBuffer)
{
   return(fileWrite(path, null, arrayBuffer));
}
/*------------------------------------------------------------------------------

@name       fileWrite - write file
                                                                              */
                                                                             /**
            Write file

@params     path      file path: bucketname/pathname
@params     bytes     file content

@history    Thu May 14, 2020 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Observable<String> fileWrite(
   String      path,
   byte[]      bytes,
   ArrayBuffer arrayBuffer)
{
   Observable<String> observable = Observable.create(
      (Subscriber<String> subscriber) ->
      {
         IHttpClient httpClient =
            new HttpClient()
               .setURL(kREQUEST_WRITE_URL + path)
               .setMethod(kPOST);

         Observable<HttpResponse> o =
            bytes != null
               ? httpClient.send(bytes) : httpClient.send(arrayBuffer);

         o.subscribe(
            (HttpResponse rsp) ->
            {
               String text = rsp.getText();
               subscriber.next(text);
               subscriber.complete();
            },
            (Throwable error) ->
            {
               kLOGGER.logError(error);
            });
         return(subscriber);
      });

   return(observable);
}
/*------------------------------------------------------------------------------

@name       initialize - initialize
                                                                              */
                                                                             /**
            Initialize. This method is invoked in the constructor prior to
            initial rendering. This is the initialize method typically
            overridden by subclasses.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected void initialize()
{
   workflow();
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <h1 class='hello' style='color:blue;marginTop:30px;fontSize:20px'>
      Cloud storage!
   </h1>
--*/
}
/*------------------------------------------------------------------------------

@name       workflow - workflow
                                                                              */
                                                                             /**
            workflow.

@history    Thu Apr 30, 2020 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void workflow()
{
   Float32Array float32Write = new Float32Array(10000000);
   float[]      dataWrite    = Js.uncheckedCast(float32Write);
   for (int i = 0; i < dataWrite.length; i++)
   {
      dataWrite[i] = (float)i;
   }

   fileWrite("mybucket/myfile", float32Write.buffer).subscribe((String text) ->
   {
      kLOGGER.logInfo("write file returned: " + text);

      fileRead("mybucket/myfile").subscribe((ArrayBuffer buffer) ->
      {
         Float32Array float32Read = new Float32Array(buffer);
         float[]      dataRead    = Js.uncheckedCast(float32Read);

         boolean bMatch = dataWrite.length == dataRead.length;
         for (int i = 0; bMatch && i < dataWrite.length; i++)
         {
            bMatch = dataWrite[i] == dataRead[i];
         }

         kLOGGER.logInfo(
            "file written and file read "
               + (bMatch ? "" : "do not ") + "match");
      });
   });

}
}//====================================// end App ============================//
