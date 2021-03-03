package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexampleregisteruser_impl extends GXWebPanel
{
   public gamexampleregisteruser_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexampleregisteruser_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexampleregisteruser_impl.class ));
   }

   public gamexampleregisteruser_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         pa0C2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0C2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0C2( ) ;
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
      httpContext.writeValue( "Register user ") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?202122611565066", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.identityprovider.gamexampleregisteruser", new String[] {}, new String[] {}) +"\">") ;
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
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBIRTHDAY", getSecureSignedToken( "", AV6Birthday));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGENDER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11Gender, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21UserRememberMe), "Z9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vBIRTHDAY", localUtil.dtoc( AV6Birthday, 0, "/"));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBIRTHDAY", getSecureSignedToken( "", AV6Birthday));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vGENDER", GXutil.rtrim( AV11Gender));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGENDER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11Gender, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV21UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21UserRememberMe), "Z9")));
   }

   public void renderHtmlCloseForm0C2( )
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
      return "GAMExampleRegisterUser" ;
   }

   public String getPgmdesc( )
   {
      return "Register user " ;
   }

   public void wb0C0( )
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
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "LoginContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "LargeTableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "REGISTRATION", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-xs-offset-1", "Right", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTbaccount_Internalname, "HAVE AN ACCOUNT?", "", "", lblTbaccount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SpecialText", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-5 col-sm-1", "left", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTblogin_Internalname, "LOGIN", "", "", lblTblogin_Jsonclick, "'"+""+"'"+",false,"+"'"+"e110c1_client"+"'", "", "PagingText TextLikeLink", 7, "", 1, 1, 0, (short)(0), "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, "USERNAME", "col-sm-3 RegistrationAttributeLabel RequiredAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV16Name, GXutil.rtrim( localUtil.format( AV16Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "RegistrationAttribute RequiredAttribute", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavEmail_Internalname, "EMAIL", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavEmail_Internalname, AV7EMail, GXutil.rtrim( localUtil.format( AV7EMail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmail_Jsonclick, 0, edtavEmail_Class, "", "", "", "", 1, edtavEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEMail", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavPassword_Internalname, "PASSWORD", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavPassword_Internalname, GXutil.rtrim( AV17Password), GXutil.rtrim( localUtil.format( AV17Password, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPassword_Jsonclick, 0, edtavPassword_Class, "", "", "", "", 1, edtavPassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPasswordconf_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavPasswordconf_Internalname, "PASSWORD CONFIRMATION", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavPasswordconf_Internalname, GXutil.rtrim( AV18PasswordConf), GXutil.rtrim( localUtil.format( AV18PasswordConf, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPasswordconf_Jsonclick, 0, edtavPasswordconf_Class, "", "", "", "", 1, edtavPasswordconf_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFirstname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavFirstname_Internalname, "FIRST NAME", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavFirstname_Internalname, GXutil.rtrim( AV10FirstName), GXutil.rtrim( localUtil.format( AV10FirstName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFirstname_Jsonclick, 0, edtavFirstname_Class, "", "", "", "", 1, edtavFirstname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavLastname_Internalname, "LAST NAME", "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavLastname_Internalname, GXutil.rtrim( AV12LastName), GXutil.rtrim( localUtil.format( AV12LastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLastname_Jsonclick, 0, edtavLastname_Class, "", "", "", "", 1, edtavLastname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_button_ctrl( httpContext, bttLogin_Internalname, "", "CREATE ACCOUNT", bttLogin_Jsonclick, 5, "CREATE ACCOUNT", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleRegisterUser.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0C2( )
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
         Form.getMeta().addItem("description", "Register user ", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0C0( ) ;
   }

   public void ws0C2( )
   {
      start0C2( ) ;
      evt0C2( ) ;
   }

   public void evt0C2( )
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
                        e120C2 ();
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
                              e130C2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e140C2 ();
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

   public void we0C2( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0C2( ) ;
         }
      }
   }

   public void pa0C2( )
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0C2( ) ;
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

   public void rf0C2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e140C2 ();
         wb0C0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0C2( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vBIRTHDAY", localUtil.dtoc( AV6Birthday, 0, "/"));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBIRTHDAY", getSecureSignedToken( "", AV6Birthday));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vGENDER", GXutil.rtrim( AV11Gender));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGENDER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11Gender, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV21UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21UserRememberMe), "Z9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0C0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV16Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Name", AV16Name);
         AV7EMail = httpContext.cgiGet( edtavEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EMail", AV7EMail);
         AV17Password = httpContext.cgiGet( edtavPassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Password", AV17Password);
         AV18PasswordConf = httpContext.cgiGet( edtavPasswordconf_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18PasswordConf", AV18PasswordConf);
         AV10FirstName = httpContext.cgiGet( edtavFirstname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10FirstName", AV10FirstName);
         AV12LastName = httpContext.cgiGet( edtavLastname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12LastName", AV12LastName);
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
      e120C2 ();
      if (returnInSub) return;
   }

   public void e120C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'MARKREQUIEREDUSERDATA' */
      S112 ();
      if (returnInSub) return;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e130C2 ();
      if (returnInSub) return;
   }

   public void e130C2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV19Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( GXutil.strcmp(AV17Password, AV18PasswordConf) == 0 )
      {
         AV20User.setgxTv_SdtGAMUser_Name( AV16Name );
         AV20User.setgxTv_SdtGAMUser_Email( AV7EMail );
         AV20User.setgxTv_SdtGAMUser_Firstname( AV10FirstName );
         AV20User.setgxTv_SdtGAMUser_Lastname( AV12LastName );
         AV20User.setgxTv_SdtGAMUser_Birthday( AV6Birthday );
         AV20User.setgxTv_SdtGAMUser_Gender( AV11Gender );
         AV20User.setgxTv_SdtGAMUser_Password( AV17Password );
         AV20User.save();
         if ( AV20User.success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamexampleregisteruser");
            if ( GXutil.strcmp(AV19Repository.getgxTv_SdtGAMRepository_Useractivationmethod(), "A") == 0 )
            {
               AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( AV21UserRememberMe );
               GXv_objcol_SdtGAMError1[0] = AV9Errors ;
               AV13LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV16Name, AV17Password, AV5AdditionalParameter, GXv_objcol_SdtGAMError1) ;
               AV9Errors = GXv_objcol_SdtGAMError1[0] ;
               if ( AV13LoginOK )
               {
                  callWebObject(formatLink("com.identityprovider.gamhome", new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(1) ;
               }
               else
               {
                  /* Execute user subroutine: 'DISPLAYMESSAGES' */
                  S122 ();
                  if (returnInSub) return;
               }
            }
            else
            {
               GXv_objcol_SdtMessages_Message2[0] = AV15Messages ;
               new com.identityprovider.gamcheckuseractivationmethod(remoteHandle, context).execute( AV20User.getgxTv_SdtGAMUser_Guid(), GXv_objcol_SdtMessages_Message2) ;
               AV15Messages = GXv_objcol_SdtMessages_Message2[0] ;
               AV24GXV1 = 1 ;
               while ( AV24GXV1 <= AV15Messages.size() )
               {
                  AV14Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV15Messages.elementAt(-1+AV24GXV1));
                  httpContext.GX_msglist.addItem(AV14Message.getgxTv_SdtMessages_Message_Description());
                  AV24GXV1 = (int)(AV24GXV1+1) ;
               }
            }
         }
         else
         {
            AV9Errors = AV20User.geterrors() ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S122 ();
            if (returnInSub) return;
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("The password and confirmation password do not match.");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20User", AV20User);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdditionalParameter", AV5AdditionalParameter);
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV25GXV2 = 1 ;
      while ( AV25GXV2 <= AV9Errors.size() )
      {
         AV8Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV9Errors.elementAt(-1+AV25GXV2));
         httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV8Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV8Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         AV25GXV2 = (int)(AV25GXV2+1) ;
      }
   }

   public void S112( )
   {
      /* 'MARKREQUIEREDUSERDATA' Routine */
      returnInSub = false ;
      AV19Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredemail() )
      {
         edtavEmail_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmail_Internalname, "Class", edtavEmail_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredfirstname() )
      {
         edtavFirstname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Class", edtavFirstname_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredlastname() )
      {
         edtavLastname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Class", edtavLastname_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredpassword() )
      {
         edtavPassword_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Class", edtavPassword_Class, true);
         edtavPasswordconf_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPasswordconf_Internalname, "Class", edtavPasswordconf_Class, true);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e140C2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa0C2( ) ;
      ws0C2( ) ;
      we0C2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2021226115756", true, true);
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
      httpContext.AddJavascriptSource("gamexampleregisteruser.js", "?20212261157511", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      lblTbaccount_Internalname = "TBACCOUNT" ;
      lblTblogin_Internalname = "TBLOGIN" ;
      edtavName_Internalname = "vNAME" ;
      edtavEmail_Internalname = "vEMAIL" ;
      edtavPassword_Internalname = "vPASSWORD" ;
      edtavPasswordconf_Internalname = "vPASSWORDCONF" ;
      edtavFirstname_Internalname = "vFIRSTNAME" ;
      edtavLastname_Internalname = "vLASTNAME" ;
      bttLogin_Internalname = "LOGIN" ;
      divTable2_Internalname = "TABLE2" ;
      divTable1_Internalname = "TABLE1" ;
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
      edtavLastname_Jsonclick = "" ;
      edtavLastname_Class = "RegistrationAttribute" ;
      edtavLastname_Enabled = 1 ;
      edtavFirstname_Jsonclick = "" ;
      edtavFirstname_Class = "RegistrationAttribute" ;
      edtavFirstname_Enabled = 1 ;
      edtavPasswordconf_Jsonclick = "" ;
      edtavPasswordconf_Class = "RegistrationAttribute" ;
      edtavPasswordconf_Enabled = 1 ;
      edtavPassword_Jsonclick = "" ;
      edtavPassword_Class = "RegistrationAttribute" ;
      edtavPassword_Enabled = 1 ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV6Birthday',fld:'vBIRTHDAY',pic:'',hsh:true},{av:'AV11Gender',fld:'vGENDER',pic:'',hsh:true},{av:'AV21UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e130C2',iparms:[{av:'AV17Password',fld:'vPASSWORD',pic:''},{av:'AV18PasswordConf',fld:'vPASSWORDCONF',pic:''},{av:'AV16Name',fld:'vNAME',pic:''},{av:'AV7EMail',fld:'vEMAIL',pic:''},{av:'AV10FirstName',fld:'vFIRSTNAME',pic:''},{av:'AV12LastName',fld:'vLASTNAME',pic:''},{av:'AV6Birthday',fld:'vBIRTHDAY',pic:'',hsh:true},{av:'AV11Gender',fld:'vGENDER',pic:'',hsh:true},{av:'AV21UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'LOGIN'","{handler:'e110C1',iparms:[]");
      setEventMetadata("'LOGIN'",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV6Birthday = GXutil.nullDate() ;
      AV11Gender = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblTbaccount_Jsonclick = "" ;
      lblTblogin_Jsonclick = "" ;
      TempTags = "" ;
      AV16Name = "" ;
      AV7EMail = "" ;
      AV17Password = "" ;
      AV18PasswordConf = "" ;
      AV10FirstName = "" ;
      AV12LastName = "" ;
      bttLogin_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV19Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV20User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV5AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      AV9Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV15Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      AV14Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV8Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.identityprovider.gamexampleregisteruser__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.identityprovider.gamexampleregisteruser__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV21UserRememberMe ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavName_Enabled ;
   private int edtavEmail_Enabled ;
   private int edtavPassword_Enabled ;
   private int edtavPasswordconf_Enabled ;
   private int edtavFirstname_Enabled ;
   private int edtavLastname_Enabled ;
   private int AV24GXV1 ;
   private int AV25GXV2 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV11Gender ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable2_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String lblTbaccount_Internalname ;
   private String lblTbaccount_Jsonclick ;
   private String lblTblogin_Internalname ;
   private String lblTblogin_Jsonclick ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String edtavEmail_Internalname ;
   private String edtavEmail_Jsonclick ;
   private String edtavEmail_Class ;
   private String edtavPassword_Internalname ;
   private String AV17Password ;
   private String edtavPassword_Jsonclick ;
   private String edtavPassword_Class ;
   private String edtavPasswordconf_Internalname ;
   private String AV18PasswordConf ;
   private String edtavPasswordconf_Jsonclick ;
   private String edtavPasswordconf_Class ;
   private String edtavFirstname_Internalname ;
   private String AV10FirstName ;
   private String edtavFirstname_Jsonclick ;
   private String edtavFirstname_Class ;
   private String edtavLastname_Internalname ;
   private String AV12LastName ;
   private String edtavLastname_Jsonclick ;
   private String edtavLastname_Class ;
   private String bttLogin_Internalname ;
   private String bttLogin_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private java.util.Date AV6Birthday ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13LoginOK ;
   private String AV16Name ;
   private String AV7EMail ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV5AdditionalParameter ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV20User ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV9Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private com.genexus.SdtMessages_Message AV14Message ;
   private genexus.security.api.genexussecurity.SdtGAMError AV8Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV19Repository ;
}

final  class gamexampleregisteruser__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class gamexampleregisteruser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

