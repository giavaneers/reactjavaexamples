/*==============================================================================

name:       View.java

purpose:    SEO App View base class.

history:    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.seo;
                                       // imports --------------------------- //
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLDocument;
import elemental2.dom.HTMLHeadElement;
import elemental2.dom.HTMLMetaElement;
import elemental2.dom.HTMLScriptElement;
import elemental2.dom.HTMLTitleElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import io.reactjava.client.core.providers.http.HttpClient;
import io.reactjava.client.core.providers.http.HttpResponse;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.ReactJava;
                                       // View ===============================//
public class View extends Component
{
                                       // class constants ------------------- //
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

@name       seoCheck - check seo result
                                                                              */
                                                                             /**
            Check seo result.

@return     void

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void seoCheck()
{
   DomGlobal.setTimeout((e) ->
   {
      seoCheckHeadElements();
      seoCheckRobotsDotText();
      seoCheckSiteMap();
   }, 50);
}
/*------------------------------------------------------------------------------

@name       seoCheckHeadElements - check seo inserted head elements
                                                                              */
                                                                             /**
            Check seo inserted head elements.

@return     void

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void seoCheckHeadElements()
{
   String          sMeta       = null;
   String          sTitle      = null;
   String          sStructured = null;
   String          id          = null;
   HTMLDocument    doc         = DomGlobal.document;
   HTMLHeadElement head        = doc != null ? doc.head : null;
   NodeList        children    = head != null ? head.childNodes : null;
   for (int i = 0, iMax = children != null ? children.length : 0;
         i < iMax && (sMeta == null || sTitle == null || sStructured == null);
         i++)
   {
      Node child = (Node)children.item(i);
      if (child.nodeType == Node.ELEMENT_NODE)
      {
         String tagName = ((Element)child).tagName.toLowerCase();
         String childId = ((Element)child).getAttribute("id");
         switch (tagName)
         {
            case ReactJava.kHEAD_ELEM_TYPE_META:
            {
               if ("seometa".equals(childId))
               {
                  HTMLMetaElement meta = (HTMLMetaElement)child;
                  sMeta = meta.content;
                  id    = "seoDescription";
                  Element displayMeta = DomGlobal.document.getElementById(id);
                  if (displayMeta != null)
                  {
                     displayMeta.textContent = sMeta;
                  }
               }
               break;
            }
            case ReactJava.kHEAD_ELEM_TYPE_STRUCTURED:
            {
               HTMLScriptElement script = (HTMLScriptElement)child;
               sStructured = "script=" + script.text;
               break;
            }
            case ReactJava.kHEAD_ELEM_TYPE_TITLE:
            {
               if ("seotitle".equals(childId))
               {
                  HTMLTitleElement title = (HTMLTitleElement)child;
                  sTitle = title.text;
                  id     = "seoTitle";
                  Element displayTitle = DomGlobal.document.getElementById(id);
                  if (displayTitle != null)
                  {
                     displayTitle.textContent = sTitle;
                  }
               }
               break;
            }
         }
      }
   }
}
/*------------------------------------------------------------------------------

@name       seoCheckRobotDotText - check seo generated robots.txt
                                                                              */
                                                                             /**
            Check seo generated robots.txt.

@return     void

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void seoCheckRobotsDotText()
{
   HttpClient.get(
      "robots.txt")
      .subscribe(
         (HttpResponse rsp) ->
         {
            String content = rsp.getText();
            Element display = DomGlobal.document.getElementById("seoRobots");
            if (display != null)
            {
               display.innerHTML = content.replace("\n","<br>");
            }
         },
         (Throwable error) ->
         {
            DomGlobal.window.console.log(error.getMessage());
         });
}
/*------------------------------------------------------------------------------

@name       seoCheckSiteMap - check seo generated sitemeap
                                                                              */
                                                                             /**
            Check seo generated sitemeap.

@return     void

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void seoCheckSiteMap()
{
   HttpClient.get(
      "SEOReactJavaSitemap.xml")
      .subscribe(
         (HttpResponse rsp) ->
         {
            String  content = rsp.getText();
            Element display = DomGlobal.document.getElementById("seoSitemap");
            if (display != null)
            {
               display.textContent = content;
            }
         },
         (Throwable error) ->
         {
            DomGlobal.window.console.log(error.getMessage());
         });
}
}//====================================// end View ===========================//
