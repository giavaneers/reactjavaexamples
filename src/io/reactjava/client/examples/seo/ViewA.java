/*==============================================================================

name:       ViewA.java

purpose:    SEO App ViewA.

history:    Tue Dec 17, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.seo;
                                       // imports --------------------------- //
                                       // (none)                              //
                                       // ViewA ==============================//
public class ViewA extends View
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

@return     void

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
