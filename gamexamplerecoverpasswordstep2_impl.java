package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexamplerecoverpasswordstep2_impl extends GXWebPanel
{
   public gamexamplerecoverpasswordstep2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexamplerecoverpasswordstep2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexamplerecoverpasswordstep2_impl.class ));
   }

   public gamexamplerecoverpasswordstep2_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "KeyToChangePassword") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "KeyToChangePassword") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "KeyToChangePassword") ;
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
            AV9KeyToChangePassword = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9KeyToChangePassword", AV9KeyToChangePassword);
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vKEYTOCHANGEPASSWORD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9KeyToChangePassword, ""))));
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
         pa0D2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0D2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0D2( ) ;
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
      httpContext.writeValue( "Recover Password") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20212261157109", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.identityprovider.gamexamplerecoverpasswordstep2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV9KeyToChangePassword))}, new String[] {"KeyToChangePassword"}) +"\">") ;
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
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERAUTHTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13UserAuthTypeName, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vKEYTOCHANGEPASSWORD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9KeyToChangePassword, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17UserRememberMe), "Z9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERAUTHTYPENAME", GXutil.rtrim( AV13UserAuthTypeName));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERAUTHTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13UserAuthTypeName, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vKEYTOCHANGEPASSWORD", GXutil.rtrim( AV9KeyToChangePassword));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vKEYTOCHANGEPASSWORD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9KeyToChangePassword, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV17UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17UserRememberMe), "Z9")));
   }

   public void renderHtmlCloseForm0D2( )
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
      return "GAMExampleRecoverPasswordStep2" ;
   }

   public String getPgmdesc( )
   {
      return "Recover Password" ;
   }

   public void wb0D0( )
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
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "LoginContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-10", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-sm-offset-4", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "RECOVER", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, "User Name", "col-sm-3 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV14UserName, GXutil.rtrim( localUtil.format( AV14UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Email or Username", edtavUsername_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavUserpasswordnew_Internalname, GXutil.rtrim( AV15UserPasswordNew), GXutil.rtrim( localUtil.format( AV15UserPasswordNew, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,23);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "New Password", edtavUserpasswordnew_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUserpasswordnew_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavUserpasswordnewconf_Internalname, GXutil.rtrim( AV16UserPasswordNewConf), GXutil.rtrim( localUtil.format( AV16UserPasswordNewConf, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Confirm Password", edtavUserpasswordnewconf_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUserpasswordnewconf_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-xs-offset-3 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_button_ctrl( httpContext, bttEnter_Internalname, "", "Confirm", bttEnter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableButtons", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, "BACK TO LOGIN", "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+"e110d1_client"+"'", "", "PagingText TextLikeLink", 7, "", 1, 1, 0, (short)(0), "HLP_GAMExampleRecoverPasswordStep2.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0D2( )
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
         Form.getMeta().addItem("description", "Recover Password", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0D0( ) ;
   }

   public void ws0D2( )
   {
      start0D2( ) ;
      evt0D2( ) ;
   }

   public void evt0D2( )
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
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                              /* Execute user event: Enter */
                              e120D2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e130D2 ();
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

   public void we0D2( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0D2( ) ;
         }
      }
   }

   public void pa0D2( )
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
            GX_FocusControl = edtavUsername_Internalname ;
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
      rf0D2( ) ;
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

   public void rf0D2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e130D2 ();
         wb0D0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0D2( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERAUTHTYPENAME", GXutil.rtrim( AV13UserAuthTypeName));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERAUTHTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13UserAuthTypeName, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vKEYTOCHANGEPASSWORD", GXutil.rtrim( AV9KeyToChangePassword));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vKEYTOCHANGEPASSWORD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9KeyToChangePassword, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV17UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17UserRememberMe), "Z9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV14UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14UserName", AV14UserName);
         AV15UserPasswordNew = httpContext.cgiGet( edtavUserpasswordnew_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15UserPasswordNew", AV15UserPasswordNew);
         AV16UserPasswordNewConf = httpContext.cgiGet( edtavUserpasswordnewconf_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16UserPasswordNewConf", AV16UserPasswordNewConf);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e120D2 ();
      if (returnInSub) return;
   }

   public void e120D2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15UserPasswordNew, AV16UserPasswordNewConf) == 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV8Errors ;
         AV12User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbylogin(AV13UserAuthTypeName, AV14UserName, GXv_objcol_SdtGAMError1);
         AV8Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV8Errors.size() == 0 )
         {
            GXv_objcol_SdtGAMError1[0] = AV8Errors ;
            AV6ChangePwdOK = AV12User.changepasswordbykey(AV9KeyToChangePassword, AV15UserPasswordNew, GXv_objcol_SdtGAMError1) ;
            AV8Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( AV6ChangePwdOK )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamexamplerecoverpasswordstep2");
               AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( AV17UserRememberMe );
               GXv_objcol_SdtGAMError1[0] = AV8Errors ;
               AV10LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV14UserName, AV15UserPasswordNew, AV5AdditionalParameter, GXv_objcol_SdtGAMError1) ;
               AV8Errors = GXv_objcol_SdtGAMError1[0] ;
               if ( AV10LoginOK )
               {
                  AV11URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
                  if ( (GXutil.strcmp("", AV11URL)==0) )
                  {
                     callWebObject(formatLink("com.identityprovider.gamhome", new String[] {}, new String[] {}) );
                     httpContext.wjLocDisableFrm = (byte)(1) ;
                  }
                  else
                  {
                     callWebObject(formatLink(AV11URL, new String[] {}, new String[] {}) );
                     httpContext.wjLocDisableFrm = (byte)(0) ;
                  }
               }
               else
               {
                  /* Execute user subroutine: 'DISPLAYMESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
            else
            {
               /* Execute user subroutine: 'DISPLAYMESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
         else
         {
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S112 ();
            if (returnInSub) return;
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("The new password and confirmation do not match.");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdditionalParameter", AV5AdditionalParameter);
   }

   public void S112( )
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

   protected void nextLoad( )
   {
   }

   protected void e130D2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9KeyToChangePassword = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9KeyToChangePassword", AV9KeyToChangePassword);
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vKEYTOCHANGEPASSWORD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9KeyToChangePassword, ""))));
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
      pa0D2( ) ;
      ws0D2( ) ;
      we0D2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202122611571567", true, true);
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
      httpContext.AddJavascriptSource("gamexamplerecoverpasswordstep2.js", "?202122611571575", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpasswordnew_Internalname = "vUSERPASSWORDNEW" ;
      edtavUserpasswordnewconf_Internalname = "vUSERPASSWORDNEWCONF" ;
      bttEnter_Internalname = "ENTER" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      divTable2_Internalname = "TABLE2" ;
      divTable1_Internalname = "TABLE1" ;
      divTable3_Internalname = "TABLE3" ;
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
      edtavUserpasswordnewconf_Jsonclick = "" ;
      edtavUserpasswordnewconf_Enabled = 1 ;
      edtavUserpasswordnew_Jsonclick = "" ;
      edtavUserpasswordnew_Enabled = 1 ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13UserAuthTypeName',fld:'vUSERAUTHTYPENAME',pic:'',hsh:true},{av:'AV17UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true},{av:'AV9KeyToChangePassword',fld:'vKEYTOCHANGEPASSWORD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e120D2',iparms:[{av:'AV15UserPasswordNew',fld:'vUSERPASSWORDNEW',pic:''},{av:'AV16UserPasswordNewConf',fld:'vUSERPASSWORDNEWCONF',pic:''},{av:'AV13UserAuthTypeName',fld:'vUSERAUTHTYPENAME',pic:'',hsh:true},{av:'AV14UserName',fld:'vUSERNAME',pic:''},{av:'AV9KeyToChangePassword',fld:'vKEYTOCHANGEPASSWORD',pic:'',hsh:true},{av:'AV17UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'LOGIN'","{handler:'e110D1',iparms:[]");
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
      wcpOAV9KeyToChangePassword = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV9KeyToChangePassword = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV13UserAuthTypeName = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      TempTags = "" ;
      AV14UserName = "" ;
      AV15UserPasswordNew = "" ;
      AV16UserPasswordNewConf = "" ;
      bttEnter_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV12User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV8Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV5AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV11URL = "" ;
      AV7Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.identityprovider.gamexamplerecoverpasswordstep2__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.identityprovider.gamexamplerecoverpasswordstep2__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV17UserRememberMe ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavUsername_Enabled ;
   private int edtavUserpasswordnew_Enabled ;
   private int edtavUserpasswordnewconf_Enabled ;
   private int AV20GXV1 ;
   private int idxLst ;
   private String wcpOAV9KeyToChangePassword ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV9KeyToChangePassword ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV13UserAuthTypeName ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable1_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String edtavUsername_Internalname ;
   private String TempTags ;
   private String edtavUsername_Jsonclick ;
   private String edtavUserpasswordnew_Internalname ;
   private String AV15UserPasswordNew ;
   private String edtavUserpasswordnew_Jsonclick ;
   private String edtavUserpasswordnewconf_Internalname ;
   private String AV16UserPasswordNewConf ;
   private String edtavUserpasswordnewconf_Jsonclick ;
   private String bttEnter_Internalname ;
   private String bttEnter_Jsonclick ;
   private String divTable2_Internalname ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV6ChangePwdOK ;
   private boolean AV10LoginOK ;
   private String AV14UserName ;
   private String AV11URL ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV5AdditionalParameter ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV8Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV7Error ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV12User ;
}

final  class gamexamplerecoverpasswordstep2__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamexamplerecoverpasswordstep2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

