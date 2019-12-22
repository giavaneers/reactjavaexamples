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
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.SEOInfo;
import io.reactjava.client.core.react.SEOInfo.SEOPageInfo;
import java.util.ArrayList;
import java.util.Arrays;
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

@return     void

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
   SEOInfo seoInfo =
      new SEOInfo(
         kSEO_DEPLOY_PATH,
         kPATH_A,
         new ArrayList<>(
            Arrays.asList(
               new SEOPageInfo(
                  kPATH_A,
                  kTITLE_LANDING,
                  kDESCRIPTION_LANDING),
               new SEOPageInfo(
                  kPATH_B,
                  kTITLE_USER_GUIDE,
                  kDESCRIPTION_USER_GUIDE)
            )));

   return(seoInfo);
}
}//====================================// end App ============================//
