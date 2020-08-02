/*==============================================================================

name:       Drawer.java

purpose:    Drawer Dialog.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.pdf;
                                       // imports --------------------------- //
import elemental2.dom.Element;
import elemental2.dom.Event;
import io.reactjava.client.components.pdfviewer.Bookmark;
import io.reactjava.client.components.pdfviewer.PDFViewer;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.INativeEventHandler;
import io.reactjava.client.core.react.INativeFunction;
import io.reactjava.client.core.react.NativeObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
                                       // Drawer =============================//
public class Drawer extends Component
{
                                       // class constants --------------------//
public static final String kPROPERTY_KEY_0PEN_HANDLER = "openhandler";

                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       clickHandler - cell onClick event handler
                                                                              */
                                                                             /**
            Cell onClick event handler as a public instance variable, accessible
            via 'this' in markup.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public INativeEventHandler clickHandler = (Event e) ->
{
   setState("show", false);

   String   id       = ((Element)e.currentTarget).getAttribute("id");
   Bookmark bookmark = Bookmark.bookmarkById.get(id);
   String   url      = bookmark.toURL();

   ((Consumer)props().get(kPROPERTY_KEY_0PEN_HANDLER)).accept(
      new HashMap<String,Object>()
      {{
         put("url", url);
      }});
};
/*------------------------------------------------------------------------------

@name       getBookmarks - get any pdf document bookmarks
                                                                              */
                                                                             /**
            Get any pdf document bookmarks.

@return     any pdf document bookmarks

@history    Sun Mar 31, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected List<List<Bookmark>> getBookmarks()
{
   List<List<Bookmark>> bookmarks = (List<List<Bookmark>>)getState("bookmarks");
   if (bookmarks == null)
   {
      bookmarks = new ArrayList<>();
      Component.forClass(PDFViewer.class).subscribe(
         this,
         (Component pdfViewer) ->
         {
            ((PDFViewer)pdfViewer).getBookmarks().subscribe(
               this,
               (List<List<Bookmark>> viewerBookmarks) ->
               {
                  setState("bookmarks", viewerBookmarks);
               },
               error ->{});
         },
         error ->{});
   }

   return(bookmarks);
}
/*------------------------------------------------------------------------------

@name       onCloseHandler - onClose event handler
                                                                              */
                                                                             /**
            onClose event handler as a public instance variable.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public INativeFunction onCloseHandler = () ->
{
   setState("show", false);
};
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

@notes
class="itemText"
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   useState("show",      false);
   useState("bookmarks", null);

   List<List<Bookmark>> bookmarks    = getBookmarks();
   boolean              bDisplayHash = props().getBoolean("displayhash");
   boolean              bShow        = getStateBoolean("show");

   if (bShow)
   {
      if (bookmarks == null || bookmarks.size() == 0)
      {
         onCloseHandler.call();
      }
      else
      {
/*--
      <@material-ui.core.Drawer open={bShow} onClose={onCloseHandler} >
         <@material-ui.core.List>
--*/
         for (List<Bookmark> pageMarks : bookmarks)
         {
            for (Bookmark bookmark : pageMarks)
            {
               String bookmarkText = bookmark.getText();
               double unitScale    = bookmark.height / Bookmark.maxHeight;
               double marginScale  = (1.0 - unitScale) * 100;

               if (bDisplayHash)
               {
                  bookmarkText += " (#" + bookmark.getId() + ")";

                  NativeObject markStyle =
                     NativeObject.with(
                        "fontSize",   "1em",
                        "fontWeight", 300,
                        "marginLeft", marginScale + "px");

                                       // a list whose elements can be copied //
                                       // to get all url hash values          //
/*--
               <div style={markStyle}>{bookmarkText}</div>
--*/
               }
               else
               {
                  NativeObject markStyle =
                     NativeObject.with(
                        "color",      "#367DA2",
                        "fontSize",   unitScale   + "em",
                        "fontWeight", 300,
                        "marginLeft", marginScale + "px");
/*--
               <@material-ui.core.ListItem
                  button id={bookmark.getId()}
                  onClick={bDisplayHash ? null : clickHandler}
                >
                  <@material-ui.core.ListItemText disableTypography>
                     <@material-ui.core.Typography style={markStyle}>
                        {bookmarkText}
                     </@material-ui.core.Typography>
                  </@material-ui.core.ListItemText>
               </@material-ui.core.ListItem>
--*/
            }
         }
      }
/*--
         </@material-ui.core.List>
      </@material-ui.core.Drawer>
--*/
      }
   }
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
   .itemText {
      color:       #367DA2;
      font-weight: 200;
   }
--*/
}
}//====================================// end Drawer =========================//
