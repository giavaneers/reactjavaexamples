/*==============================================================================

name:       App.java

purpose:    ReactJava website App.

history:    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                  This program was created by Giavaneers
        and is the confidential and proprietary product of Giavaneers Inc.
      Any unauthorized use, reproduction or transfer is strictly prohibited.

                     COPYRIGHT 2019 BY GIAVANEERS, INC.
      (Subject to limited distribution and restricted disclosure only).
                           All rights reserved.


==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.generalpage;
                                       // imports --------------------------- //
import io.reactjava.client.components.generalpage.Descriptors.FooterDsc;
import io.reactjava.client.components.generalpage.Descriptors.FooterDsc.FooterCreditDsc;
import io.reactjava.client.components.generalpage.Descriptors.PageDsc;
import io.reactjava.client.components.generalpage.GeneralPage;
import io.reactjava.client.core.react.AppComponentTemplate;
import java.util.ArrayList;
import java.util.List;
                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final String kIMAGE            = "images/ReactJava64px.png";
public static final String kTITLE_USER_GUIDE = "ReactJava Developer Guide";

                                       // footer                              //
public static final FooterDsc kFOOTER  =
   new FooterDsc(
      null,                            // no categories                       //
      new FooterCreditDsc(
         "<a href=\"http://www.giavaneers.com\" target=\"_blank\">"
       + "   <img src=\"images/GiavaneersMark.png\" class=\"logo\" />"
       + "</a>",
         "Website created with React and "
       + "<a href=\"http://www.reactjava.io\" target=\"_blank\">ReactJava</a>\"")
    );
                                       // page descriptor                     //
public static final PageDsc kPAGE_DSC =
   new PageDsc(
      kTITLE_USER_GUIDE,
      kIMAGE,
      true,                            // include a menu button               //
      null,                            // no other app bar buttons            //
      null,                            // no push paths                       //
      null,                            // no sections                         //
      kFOOTER);
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       getImportedNodeModules - get imported node modules
                                                                              */
                                                                             /**
            Get imported node modules.

@return     list of node module names.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
protected List<String> getImportedNodeModules()
{
   return(new ArrayList(GeneralPage.getImportedNodeModules()));
}
/*------------------------------------------------------------------------------

@name       getPageDsc - get page descriptor
                                                                              */
                                                                             /**
            Get page descriptor.

@return     page descriptor

@history    Sun Mar 31, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected PageDsc getPageDsc()
{
   return(kPAGE_DSC);
}
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public final void render()
{
   String manifest = props().getString("manifest");
   manifest = "manifests/" + (manifest != null ? manifest : "simple");
/*--
   <GeneralPage pagedsc={getPageDsc()} manifest={manifest}} displayhash={"false"}/>
--*/
}
}//====================================// end App ============================//
