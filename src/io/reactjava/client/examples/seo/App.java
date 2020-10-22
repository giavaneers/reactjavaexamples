/*==============================================================================

name:       App.java

purpose:    SEO App.

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
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Component;
import io.reactjava.client.core.react.ReactJava;
import io.reactjava.client.core.react.SEOInfo;
import io.reactjava.client.core.react.StringLiteralList;
import io.reactjava.client.providers.http.HttpClient;
import io.reactjava.client.providers.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
                                       // route paths                         //
public static final String kPATH_A       = "ViewA";
public static final String kPATH_B       = "ViewB";
public static final String kPATH_DEFAULT = "";

                                       // component class                     //
public static final Map<String,Class> kAPP_ROUTES =
   Collections.unmodifiableMap(
      new HashMap<String,Class>()
      {
         {
            put(kPATH_A,       ViewA.class);
            put(kPATH_B,       ViewB.class);
            put(kPATH_DEFAULT, ViewA.class);
         }
      });

public static final String kSEO_DEPLOY_PATH     = "http://www.reactjava.io";

public static final String kTITLE_LANDING       = "ReactJava";
public static final String kTITLE_USER_GUIDE    = "ReactJava User Guide";

public static final String kDESCRIPTION_LANDING =
   "Use Java to build the same great applications for mobile and the desktop "
 + "as you do with React and React Native. The same powerful features of React "
 + "you expect: lightweight, declarative, performant, component-based "
 + "programming that is simple to write and easy to debug; packaged in a way "
 + "that naturally combines the structure, familiarity, and reach of Java. "
 + "And targeting native mobile environments is often right out of the box. "
 + "In most cases, ReactJava automatically translates your ReactJava "
 + "components to React Native equivalents.";

public static final String kDESCRIPTION_USER_GUIDE =
   "The ReactJava User Guide includes a simple tutorial that is a step by step "
 + "illustration of how ReactJava works and how you can use it to build a "
 + "React app using Java.";
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       getNavRoutes - get navigation routes for application
                                                                              */
                                                                             /**
            Get map of component classname by route path.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected Map<String,Class> getNavRoutes()
{
   return(kAPP_ROUTES);
}
/*------------------------------------------------------------------------------

@name       getSEOInfo - get seo information
                                                                              */
                                                                             /**
            Get SEO info. This method is typically invoked at compile time.

            The intention is to provide a title, description, and base url for
            the app deployment in order to create a redirect target for each
            hash, along with an associated sitemap.

@return     SEOInfo string

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
@Override
protected SEOInfo getSEOInfo()
{
   return(SEOInfo.newInstance(
      StringLiteralList.newInstance(
         kSEO_DEPLOY_PATH, kPATH_A),
      StringLiteralList.newInstance(
         kPATH_A, kTITLE_LANDING, kDESCRIPTION_LANDING),
      StringLiteralList.newInstance(
         kPATH_B, kTITLE_USER_GUIDE, kDESCRIPTION_USER_GUIDE)));
}
/*==============================================================================

name:       View

purpose:    SEO App View base class.

history:    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class View extends Component
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
   HTMLDocument doc         = DomGlobal.document;
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
/*==============================================================================

name:       ViewA

purpose:    App view A

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class ViewA extends View
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

@name       render - render markup
                                                                              */
                                                                             /**
            Render markup.

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <div>
      View A
      <br><br>
      The intention is to display the SEO information rendered for the current
      view and to see it change when switching between the views.
      <br><br>
      SEO Head Title:
      <br><br>
      <div id="seoTitle"></div>
      <br>
      SEO Head Description:
      <br><br>
      <div id="seoDescription"></div>
      <br>
      SEO robots.txt:
      <br><br>
      <div id="seoRobots"></div>
      <br>
      SEO Sitemap:
      <br><br>
      <div id="seoSitemap"></div>
      <br><br>
      <a href="SEOReactJava.html#ViewB">
         Go to view B.
      </a>
   </div>
--*/
   seoCheck();
}
}//====================================// end ViewA ==========================//
/*==============================================================================

name:       ViewB

purpose:    App view B

history:    Mon Jun 26, 2017 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class ViewB extends View
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

@name       render - render markup
                                                                              */
                                                                             /**
            Render markup.

@history    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
/*--
   <div>
      View B
      <br><br>
      The intention is to display the SEO information rendered for the current
      view and to see it change when switching between the views.
      <br><br>
      SEO Head Title:
      <br><br>
      <div id="seoTitle"></div>
      <br>
      SEO Head Description:
      <br><br>
      <div id="seoDescription"></div>
      <br>
      SEO robots.txt:
      <br><br>
      <div id="seoRobots"></div>
      <br>
      SEO Sitemap:
      <br><br>
      <div id="seoSitemap"></div>
      <br><br>
      <a href="SEOReactJava.html#ViewA">
         Go to view A.
      </a>
   </div>
--*/
   seoCheck();
}
}//====================================// end ViewB ==========================//
}//====================================// end App ============================//
