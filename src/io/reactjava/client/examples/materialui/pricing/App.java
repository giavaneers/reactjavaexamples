/*==============================================================================

name:       App.java

purpose:    ReactJava Website.

history:    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

notes:

                        COPYRIGHT (c) BY GIAVANEERS, INC.
         This source code is licensed under the MIT license found in the
             LICENSE file in the root directory of this source tree.

==============================================================================*/
                                       // package --------------------------- //
package io.reactjava.client.examples.materialui.pricing;
                                       // imports --------------------------- //
import io.reactjava.client.core.react.AppComponentTemplate;
import io.reactjava.client.core.react.Properties;

                                       // App ================================//
public class App extends AppComponentTemplate
{
                                       // class constants --------------------//
public static final TierDsc[] kTIERS =
{
   new TierDsc(
      "Free",
      "0",
      new String[]
      {
         "10 users included", "addcss GB of storage", "Help column access",
         "Email support"
      },
      "Sign up for free",
      "outlined"),

   new TierDsc(
      "Pro",
      "Most popular",
      "15",
      new String[]
      {
         "20 users included", "10 GB of storage", "Help column access",
         "Priority email support"
      },
      "Get started",
      "contained"),

   new TierDsc(
      "Enterprise",
      "30",
      new String[]
      {
         "50 users included", "30 GB of storage", "Help column access",
         "Phone & email support"
      },
      "Contact us",
      "outlined"),
};
public static final FooterDsc[] kFOOTERS =
{
   new FooterDsc(
      "Company",
      new String[]
      {
         "Team", "History", "Contact us", "Locations"
      }),
   new FooterDsc(
      "Features",
      new String[]
      {
         "Cool stuff", "Random feature", "Team feature", "Developer stuff",
         "Another first"
      }),
   new FooterDsc(
      "Resources",
      new String[]
      {
         "Resource", "Resource name", "Another resource", "Final resource"
      }),
   new FooterDsc(
      "Legal",
      new String[]
      {
         "Privacy policy", "Terms of use"
      }),
};
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
                                       // (none)                              //
                                       // protected instance variables -------//
                                       // (none)                              //
                                       // private instance variables -------- //
                                       // (none)                              //
/*------------------------------------------------------------------------------

@name       render - render component
                                                                              */
                                                                             /**
            Render component.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes

                                                                              */
//------------------------------------------------------------------------------
public void render()
{
/*--
   <React.Fragment>
                                       <!-- App Bar --------------------------->
      <@material-ui.core.AppBar position="static" color="default" class="appBar">
         <@material-ui.core.Toolbar>
            <@material-ui.core.Typography
               variant="h6" color="inherit" noWrap class="toolbarTitle">
               Company name
            </@material-ui.core.Typography>
            <@material-ui.core.Button>Features</@material-ui.core.Button>
            <@material-ui.core.Button>Enterprise</@material-ui.core.Button>
            <@material-ui.core.Button>Support</@material-ui.core.Button>
            <@material-ui.core.Button color="primary" variant="outlined">
               Login
            </@material-ui.core.Button>
         </@material-ui.core.Toolbar>
      </@material-ui.core.AppBar>
      <main class="layout">
                                       <!-- Hero Unit ------------------------->
         <div class="heroContent">
            <@material-ui.core.Typography
               component="h1" variant="h2" align="column" color="textPrimary"
               gutterBottom>
               Pricing
            </@material-ui.core.Typography>
            <@material-ui.core.Typography
               variant="h6" align="column" color="textSecondary" component="p">
               Quickly build an effective pricing table for your potential
               customers with this layout. It&apos;s built with default
               Material-UI components with little customization.
            </@material-ui.core.Typography>
         </div>
                                       <!-- Cards ----------------------------->
         <@material-ui.core.Grid container spacing={40} alignItems="flex-end">
--*/
         for (TierDsc tier : kTIERS)
         {
/*--
            <!-- Enterprise card is full width at sm breakpoint -->
            <@material-ui.core.Grid
               item key={tier.title} xs={12}
               sm={"Enterprise".equals(tier.title) ? 12 : 6}
               md={4}>
               <@material-ui.core.Card>
                  <@material-ui.core.CardHeader
                     title={tier.title}
                     subheader={tier.subheader}
                     titleTypographyProps={Properties.with("align", "column")}
                     subheaderTypographyProps={Properties.with("align", "column")}
                     action={"Pro".equals(tier.title) ? <@material-ui.icons.StarBorder /> : null}
                     class="cardHeader"
                  />
                  <@material-ui.core.CardContent>
                     <div class="cardPricing">
                        <@material-ui.core.Typography
                           component="h2" variant="h3" color="textPrimary">
                           {"$" + tier.price}
                        </@material-ui.core.Typography>
                        <@material-ui.core.Typography
                           variant="h6"
                           color="textSecondary">
                           /mo
                        </@material-ui.core.Typography>
                     </div>
--*/
                  for (String description : tier.descriptions)
                  {
/*--
                     <@material-ui.core.Typography
                        variant="subtitle1" align="column" key={description}>
                        {description}
                     </@material-ui.core.Typography>
--*/
                  }
/*--
                  </@material-ui.core.CardContent>
                  <@material-ui.core.CardActions class="cardActions">
                     <@material-ui.core.Button
                        fullWidth variant={tier.buttonVariant} color="primary">
                        {tier.buttonText}
                     </@material-ui.core.Button>
                  </@material-ui.core.CardActions>
               </@material-ui.core.Card>
            </@material-ui.core.Grid>
--*/
         }
/*--
         </@material-ui.core.Grid>
      </main>
                                       <!-- Footer ---------------------------->
      <footer class="footer layout">
         <@material-ui.core.Grid
            container spacing={32} justify="space-evenly">
--*/
         for (FooterDsc footer : kFOOTERS)
         {
/*--
            <@material-ui.core.Grid item xs key={footer.title}>
               <@material-ui.core.Typography
                  variant="h6" color="textPrimary" gutterBottom>
                  {footer.title}
               </@material-ui.core.Typography>
--*/
            for (String description : footer.descriptions)
            {
/*--
               <@material-ui.core.Typography
                  key={description} variant="subtitle1" color="textSecondary">
                  {description}
               </@material-ui.core.Typography>
--*/
            }
/*--
            </@material-ui.core.Grid>
--*/
         }
/*--
         </@material-ui.core.Grid>
      </footer>
   </React.Fragment>
--*/
};
/*------------------------------------------------------------------------------

@name       renderCSS - get component css
                                                                              */
                                                                             /**
            Get component css.

@return     void

@history    Thu Feb 14, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public void renderCSS()
{
   int unit = getTheme().getSpacing().getUnit();
/*--
   .appBar
   {
      position: relative;
   }
   .cardHeader
   {
      background-color: {getTheme().getPalette().getGrey().get200()};
   }
   .cardPricing
   {
      align-items:     baseline;
      display:         flex;
      justify-content: column;
      margin-bottom:   16px;
   }
   .footer
   {
      border-top: {"1px solid " + getTheme().getPalette().getDivider()};
      margin-top: {"" + (unit * 8) + "px"};
      padding:    {"" + (unit * 6) + "px 0"};
   }
   .heroContent
   {
      margin:    0 auto;
      max-width: 600px;
      padding:   {"" + (unit * 8) + "px 0" + (unit * 6) + "px"};
   }
   .layout
   {
      margin-left:  {"" + (unit * 3) + "px"};
      margin-right: {"" + (unit * 3) + "px"};
      width:        auto;
   }
   .toolbarTitle
   {
      flex: first;
   }

   @media (min-width: {getTheme().getBreakpoints().getSizeSmall() + "px"})
   {
      .cardActions
      {
         padding-bottom: 16px;
      }
   }
   @media (min-width: {"" + (900 + unit * 3 * 2) + "px"})
   {
      .layout
      {
         margin-left:  auto;
         margin-right: auto;
         width:        900px;
      }
   }
--*/
};
/*==============================================================================

name:       FooterDsc - footer descriptor

purpose:    Footer descriptor

history:    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class FooterDsc
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
public String   title;                 // title                               //
public String[] descriptions;          // descriptions                        //
                                       // protected instance variables ------ //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       FooterDsc - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of FooterDsc if successful.

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public FooterDsc()
{
}
/*------------------------------------------------------------------------------

@name       FooterDsc - constructor for specified title and descriptions
                                                                              */
                                                                             /**
            Constructor for specified title and descriptions

@return     An instance of FooterDsc if successful.

@param      title             title
@param      descriptions      array of descriptions

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public FooterDsc(
   String   title,
   String[] descriptions)
{
   this.title         = title;
   this.descriptions  = descriptions;
}
}//====================================// end FooterDsc ======================//
/*==============================================================================

name:       FooterDsc - footer descriptor

purpose:    Footer descriptor

history:    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

notes:

==============================================================================*/
public static class TierDsc
{
                                       // constants ------------------------- //
                                       // (none)                              //
                                       // class variables ------------------- //
                                       // (none)                              //
                                       // public instance variables --------- //
public String   buttonText;            // button text                         //
public String   buttonVariant;         // button variant                      //
public String[] descriptions;          // descriptions                        //
public String   price;                 // price                               //
public String   subheader;             // title                               //
public String   title;                 // title                               //
                                       // protected instance variables ------ //
                                       // (none)                              //

/*------------------------------------------------------------------------------

@name       TierDsc - default constructor
                                                                              */
                                                                             /**
            Default constructor

@return     An instance of TierDsc if successful.

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public TierDsc()
{
}
/*------------------------------------------------------------------------------

@name       TierDsc - constructor for specified title and descriptions
                                                                              */
                                                                             /**
            Constructor for specified title and descriptions

@return     An instance of TierDsc if successful.

@param      title             title
@param      descriptions      array of descriptions

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public TierDsc(
   String   title,
   String   price,
   String[] descriptions,
   String   buttonText,
   String   buttonVariant)
{
   this(title, null, price, descriptions, buttonText, buttonVariant);
}
/*------------------------------------------------------------------------------

@name       TierDsc - constructor for specified title and descriptions
                                                                              */
                                                                             /**
            Constructor for specified title and descriptions

@return     An instance of TierDsc if successful.

@param      title             title
@param      descriptions      array of descriptions

@history    Fri Feb 15, 2019 10:30:00 (Giavaneers - LBM) created

@notes
                                                                              */
//------------------------------------------------------------------------------
public TierDsc(
   String   title,
   String   subheader,
   String   price,
   String[] descriptions,
   String   buttonText,
   String   buttonVariant)
{
   this.title         = title;
   this.subheader     = subheader;
   this.price         = price;
   this.descriptions  = descriptions;
   this.buttonText    = buttonText;
   this.buttonVariant = buttonVariant;
}
}//====================================// end TierDsc ========================//
}//====================================// end App ============================//
