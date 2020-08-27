/*==============================================================================

name:       AppBase.java

purpose:    App base class.

history:    Sat Oct 27, 2018 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
               LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.appbase;
                                       // imports --------------------------- //
import com.giavaneers.util.gwt.Logger;
import io.reactjava.client.core.react.AppComponentTemplate;

                                       // App ================================//
public class AppBase extends AppComponentTemplate
{
                                       // class constants --------------------//
protected static final Logger kLOGGER = Logger.newInstance();
                                       // class variables ------------------- //
                                       // (none)                              //
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
            Initialize. This method is invoked in the constructor prior to
            initial rendering. This is the initialize method typically
            overridden by subclasses.

@history    Mon May 21, 2018 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
protected void initialize()
{
   kLOGGER.logInfo("AppBase.initialize() entered");
}
}//====================================// end App ============================//
