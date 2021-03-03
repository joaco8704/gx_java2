package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexampleupdateregisteruser_impl extends GXWebPanel
{
   public gamexampleupdateregisteruser_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexampleupdateregisteruser_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexampleupdateregisteruser_impl.class ));
   }

   public gamexampleupdateregisteruser_impl( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavGender = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV11IDP_State = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11IDP_State", AV11IDP_State);
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11IDP_State, ""))));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa0A2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0A2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0A2( ) ;
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.identityprovider.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( "Update register user") ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?202122611565030", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("calendar-en.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.identityprovider.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11IDP_State))}, new String[] {"IDP_State"}) +"\">") ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11IDP_State, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV11IDP_State));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11IDP_State, ""))));
   }

   public void renderHtmlCloseForm0A2( )
   {
      sendCloseFormHiddens( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "GAMExampleUpdateRegisterUser" ;
   }

   public String getPgmdesc( )
   {
      return "Update register user" ;
   }

   public void wb0A0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "BodyContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-10 col-md-offset-1 col-lg-11", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTbtitle_Internalname, "UPDATE REGISTRATION", "", "", lblTbtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, "USERNAME", "col-sm-3 RegistrationAttributeLabel RequiredAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV14Name, GXutil.rtrim( localUtil.format( AV14Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "RegistrationAttribute RequiredAttribute", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavEmail_Internalname, "EMAIL", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavEmail_Internalname, AV6EMail, GXutil.rtrim( localUtil.format( AV6EMail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmail_Jsonclick, 0, edtavEmail_Class, "", "", "", "", 1, edtavEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEMail", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFirstname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavFirstname_Internalname, "FIRST NAME", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavFirstname_Internalname, GXutil.rtrim( AV9FirstName), GXutil.rtrim( localUtil.format( AV9FirstName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFirstname_Jsonclick, 0, edtavFirstname_Class, "", "", "", "", 1, edtavFirstname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavLastname_Internalname, "LAST NAME", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavLastname_Internalname, GXutil.rtrim( AV13LastName), GXutil.rtrim( localUtil.format( AV13LastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLastname_Jsonclick, 0, edtavLastname_Class, "", "", "", "", 1, edtavLastname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavBirthday_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavBirthday_Internalname, "BIRTHDAY", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavBirthday_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavBirthday_Internalname, localUtil.format(AV5Birthday, "99/99/9999"), localUtil.format( AV5Birthday, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'MDY',0,12,'eng',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'MDY',0,12,'eng',false,0);"+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBirthday_Jsonclick, 0, edtavBirthday_Class, "", "", "", "", 1, edtavBirthday_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDate", "right", false, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_bitmap( httpContext, edtavBirthday_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavBirthday_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         httpContext.writeTextNL( "</div>") ;
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavGender.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, cmbavGender.getInternalname(), "GENDER", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         /* ComboBox */
         com.identityprovider.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavGender, cmbavGender.getInternalname(), GXutil.rtrim( AV10Gender), 1, cmbavGender.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavGender.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", cmbavGender.getThemeClass(), "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "", true, "HLP_GAMExampleUpdateRegisterUser.htm");
         cmbavGender.setValue( GXutil.rtrim( AV10Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "BtnCancel" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_button_ctrl( httpContext, bttButton1_Internalname, "", "Go to Login", bttButton1_Jsonclick, 5, "Go to Login", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'RETURNTOLOGIN\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         ClassString = "BtnEnter" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_button_ctrl( httpContext, bttButton2_Internalname, "", "Confirm", bttButton2_Jsonclick, 5, "Confirm", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0A2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_2-148375", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Update register user", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0A0( ) ;
   }

   public void ws0A2( )
   {
      start0A2( ) ;
      evt0A2( ) ;
   }

   public void evt0A2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e110A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                              /* Execute user event: Enter */
                              e120A2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "'RETURNTOLOGIN'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'ReturnToLogin' */
                        e130A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e140A2 ();
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we0A2( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0A2( ) ;
         }
      }
   }

   public void pa0A2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(0)) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavName_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV10Gender = cmbavGender.getValidValue(AV10Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Gender", AV10Gender);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavGender.setValue( GXutil.rtrim( AV10Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0A2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf0A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e140A2 ();
         wb0A0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0A2( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV11IDP_State));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11IDP_State, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV14Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Name", AV14Name);
         AV6EMail = httpContext.cgiGet( edtavEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6EMail", AV6EMail);
         AV9FirstName = httpContext.cgiGet( edtavFirstname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9FirstName", AV9FirstName);
         AV13LastName = httpContext.cgiGet( edtavLastname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13LastName", AV13LastName);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavBirthday_Internalname), (byte)(2)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vBIRTHDAY");
            GX_FocusControl = edtavBirthday_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV5Birthday = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         }
         else
         {
            AV5Birthday = localUtil.ctod( httpContext.cgiGet( edtavBirthday_Internalname), 2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         }
         cmbavGender.setValue( httpContext.cgiGet( cmbavGender.getInternalname()) );
         AV10Gender = httpContext.cgiGet( cmbavGender.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Gender", AV10Gender);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e110A2 ();
      if (returnInSub) return;
   }

   public void e110A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'MARKREQUIEREDUSERDATA' */
      S112 ();
      if (returnInSub) return;
      GXv_objcol_SdtGAMError1[0] = AV8Errors ;
      AV17User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbykeytocompleteuserdata(GXv_objcol_SdtGAMError1);
      AV8Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV8Errors.size() > 0 )
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
      }
      else
      {
         AV8Errors = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
         AV14Name = AV17User.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Name", AV14Name);
         AV6EMail = AV17User.getgxTv_SdtGAMUser_Email() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6EMail", AV6EMail);
         AV9FirstName = AV17User.getgxTv_SdtGAMUser_Firstname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9FirstName", AV9FirstName);
         AV13LastName = AV17User.getgxTv_SdtGAMUser_Lastname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13LastName", AV13LastName);
         AV5Birthday = AV17User.getgxTv_SdtGAMUser_Birthday() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         AV10Gender = AV17User.getgxTv_SdtGAMUser_Gender() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Gender", AV10Gender);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e120A2 ();
      if (returnInSub) return;
   }

   public void e120A2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV8Errors ;
      AV17User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbykeytocompleteuserdata(GXv_objcol_SdtGAMError1);
      AV8Errors = GXv_objcol_SdtGAMError1[0] ;
      AV17User.setgxTv_SdtGAMUser_Name( AV14Name );
      AV17User.setgxTv_SdtGAMUser_Email( AV6EMail );
      AV17User.setgxTv_SdtGAMUser_Firstname( AV9FirstName );
      AV17User.setgxTv_SdtGAMUser_Lastname( AV13LastName );
      AV17User.setgxTv_SdtGAMUser_Birthday( AV5Birthday );
      AV17User.setgxTv_SdtGAMUser_Gender( AV10Gender );
      GXv_objcol_SdtGAMError1[0] = AV8Errors ;
      AV12isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).updateuserbykeytocompleteuserdata(AV17User, GXv_objcol_SdtGAMError1) ;
      AV8Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV12isOK )
      {
         if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isremoteauthentication(AV11IDP_State) )
         {
            new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).redirecttoremoteauthentication(AV11IDP_State) ;
         }
         else
         {
            AV16URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
            if ( (GXutil.strcmp("", AV16URL)==0) )
            {
               callWebObject(formatLink("com.identityprovider.gamhome", new String[] {}, new String[] {}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               callWebObject(formatLink(AV16URL, new String[] {}, new String[] {}) );
               httpContext.wjLocDisableFrm = (byte)(0) ;
            }
         }
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
      }
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV8Errors.size() )
      {
         AV7Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV8Errors.elementAt(-1+AV20GXV1));
         httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV7Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV7Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
   }

   public void S112( )
   {
      /* 'MARKREQUIEREDUSERDATA' Routine */
      returnInSub = false ;
      AV15Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( AV15Repository.getgxTv_SdtGAMRepository_Requiredemail() )
      {
         edtavEmail_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmail_Internalname, "Class", edtavEmail_Class, true);
      }
      if ( AV15Repository.getgxTv_SdtGAMRepository_Requiredfirstname() )
      {
         edtavFirstname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Class", edtavFirstname_Class, true);
      }
      if ( AV15Repository.getgxTv_SdtGAMRepository_Requiredlastname() )
      {
         edtavLastname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Class", edtavLastname_Class, true);
      }
      if ( AV15Repository.getgxTv_SdtGAMRepository_Requiredbirthday() )
      {
         edtavBirthday_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBirthday_Internalname, "Class", edtavBirthday_Class, true);
      }
      if ( AV15Repository.getgxTv_SdtGAMRepository_Requiredgender() )
      {
         cmbavGender.setThemeClass( "RequiredAttribute"+" "+"RegistrationAttribute" );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Class", cmbavGender.getThemeClass(), true);
      }
   }

   public void e130A2( )
   {
      /* 'ReturnToLogin' Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV8Errors ;
      AV12isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).logout(GXv_objcol_SdtGAMError1) ;
      AV8Errors = GXv_objcol_SdtGAMError1[0] ;
      callWebObject(formatLink("com.identityprovider.gamexamplelogin", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e140A2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11IDP_State = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IDP_State", AV11IDP_State);
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11IDP_State, ""))));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa0A2( ) ;
      ws0A2( ) ;
      we0A2( ) ;
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20212261157519", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.eng.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("gamexampleupdateregisteruser.js", "?20212261157524", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      divTable3_Internalname = "TABLE3" ;
      lblTbtitle_Internalname = "TBTITLE" ;
      edtavName_Internalname = "vNAME" ;
      edtavEmail_Internalname = "vEMAIL" ;
      edtavFirstname_Internalname = "vFIRSTNAME" ;
      edtavLastname_Internalname = "vLASTNAME" ;
      edtavBirthday_Internalname = "vBIRTHDAY" ;
      cmbavGender.setInternalname( "vGENDER" );
      divTable2_Internalname = "TABLE2" ;
      bttButton1_Internalname = "BUTTON1" ;
      bttButton2_Internalname = "BUTTON2" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("Carmine");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      cmbavGender.setJsonclick( "" );
      cmbavGender.setEnabled( 1 );
      cmbavGender.setThemeClass( "Attribute" );
      edtavBirthday_Jsonclick = "" ;
      edtavBirthday_Class = "Attribute" ;
      edtavBirthday_Enabled = 1 ;
      edtavLastname_Jsonclick = "" ;
      edtavLastname_Class = "RegistrationAttribute" ;
      edtavLastname_Enabled = 1 ;
      edtavFirstname_Jsonclick = "" ;
      edtavFirstname_Class = "RegistrationAttribute" ;
      edtavFirstname_Enabled = 1 ;
      edtavEmail_Jsonclick = "" ;
      edtavEmail_Class = "RegistrationAttribute" ;
      edtavEmail_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavGender.setName( "vGENDER" );
      cmbavGender.setWebtags( "" );
      cmbavGender.addItem("N", "Not Specified", (short)(0));
      cmbavGender.addItem("F", "Female", (short)(0));
      cmbavGender.addItem("M", "Male", (short)(0));
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV10Gender = cmbavGender.getValidValue(AV10Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Gender", AV10Gender);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV11IDP_State',fld:'vIDP_STATE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e120A2',iparms:[{av:'AV14Name',fld:'vNAME',pic:''},{av:'AV6EMail',fld:'vEMAIL',pic:''},{av:'AV9FirstName',fld:'vFIRSTNAME',pic:''},{av:'AV13LastName',fld:'vLASTNAME',pic:''},{av:'AV5Birthday',fld:'vBIRTHDAY',pic:''},{av:'cmbavGender'},{av:'AV10Gender',fld:'vGENDER',pic:''},{av:'AV11IDP_State',fld:'vIDP_STATE',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'RETURNTOLOGIN'","{handler:'e130A2',iparms:[]");
      setEventMetadata("'RETURNTOLOGIN'",",oparms:[]}");
      setEventMetadata("VALIDV_BIRTHDAY","{handler:'validv_Birthday',iparms:[]");
      setEventMetadata("VALIDV_BIRTHDAY",",oparms:[]}");
      setEventMetadata("VALIDV_GENDER","{handler:'validv_Gender',iparms:[]");
      setEventMetadata("VALIDV_GENDER",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV11IDP_State = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV11IDP_State = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTbtitle_Jsonclick = "" ;
      TempTags = "" ;
      AV14Name = "" ;
      AV6EMail = "" ;
      AV9FirstName = "" ;
      AV13LastName = "" ;
      AV5Birthday = GXutil.nullDate() ;
      AV10Gender = "" ;
      bttButton1_Jsonclick = "" ;
      bttButton2_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV8Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV16URL = "" ;
      AV7Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      AV15Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavName_Enabled ;
   private int edtavEmail_Enabled ;
   private int edtavFirstname_Enabled ;
   private int edtavLastname_Enabled ;
   private int edtavBirthday_Enabled ;
   private int AV20GXV1 ;
   private int idxLst ;
   private String wcpOAV11IDP_State ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV11IDP_State ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable2_Internalname ;
   private String lblTbtitle_Internalname ;
   private String lblTbtitle_Jsonclick ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String edtavEmail_Internalname ;
   private String edtavEmail_Jsonclick ;
   private String edtavEmail_Class ;
   private String edtavFirstname_Internalname ;
   private String AV9FirstName ;
   private String edtavFirstname_Jsonclick ;
   private String edtavFirstname_Class ;
   private String edtavLastname_Internalname ;
   private String AV13LastName ;
   private String edtavLastname_Jsonclick ;
   private String edtavLastname_Class ;
   private String edtavBirthday_Internalname ;
   private String edtavBirthday_Jsonclick ;
   private String edtavBirthday_Class ;
   private String AV10Gender ;
   private String bttButton1_Internalname ;
   private String bttButton1_Jsonclick ;
   private String bttButton2_Internalname ;
   private String bttButton2_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private java.util.Date AV5Birthday ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12isOK ;
   private String AV14Name ;
   private String AV6EMail ;
   private String AV16URL ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice cmbavGender ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV8Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV7Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV15Repository ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17User ;
}

