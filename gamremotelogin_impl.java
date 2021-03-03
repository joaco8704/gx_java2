package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamremotelogin_impl extends GXWebPanel
{
   public gamremotelogin_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamremotelogin_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamremotelogin_impl.class ));
   }

   public gamremotelogin_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavLogonto = new HTMLChoice();
      chkavKeepmeloggedin = UIFactory.getCheckbox(this);
      chkavRememberme = UIFactory.getCheckbox(this);
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
            AV13IDP_State = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13IDP_State", AV13IDP_State);
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
         pa0F2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0F2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0F2( ) ;
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
      httpContext.writeValue( "Remote Login ") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?202122611572545", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.identityprovider.gamremotelogin", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13IDP_State))}, new String[] {"IDP_State"}) +"\">") ;
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
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18Language, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30UserRememberMe), "Z9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV13IDP_State));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV18Language));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18Language, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV30UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30UserRememberMe), "Z9")));
   }

   public void renderHtmlCloseForm0F2( )
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
      return "GAMRemoteLogin" ;
   }

   public String getPgmdesc( )
   {
      return "Remote Login " ;
   }

   public void wb0F0( )
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
         com.identityprovider.GxWebStd.gx_div_start( httpContext, divTbllogin_Internalname, divTbllogin_Visible, 0, "px", 0, "px", "TableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Identity provider", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, "", "Logo App Client", "col-sm-3 ImageLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "Image" ;
         StyleString = "" ;
         AV20LogoAppClient_IsBlob = (boolean)(((GXutil.strcmp("", AV20LogoAppClient)==0)&&(GXutil.strcmp("", AV36Logoappclient_GXI)==0))||!(GXutil.strcmp("", AV20LogoAppClient)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV20LogoAppClient)==0) ? AV36Logoappclient_GXI : httpContext.getResourceRelative(AV20LogoAppClient)) ;
         com.identityprovider.GxWebStd.gx_bitmap( httpContext, imgavLogoappclient_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV20LogoAppClient_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTbappname_Internalname, lblTbappname_Caption, "", "", lblTbappname_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", cmbavLogonto.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLogonto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, cmbavLogonto.getInternalname(), "Log on to", "col-sm-5 col-lg-3 LoginComboAttributeLabel", 1, true, "");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-7 col-lg-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         /* ComboBox */
         com.identityprovider.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLogonto, cmbavLogonto.getInternalname(), GXutil.rtrim( AV21LogOnTo), 1, cmbavLogonto.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavLogonto.getVisible(), cmbavLogonto.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "LoginComboAttribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "", true, "HLP_GAMRemoteLogin.htm");
         cmbavLogonto.setValue( GXutil.rtrim( AV21LogOnTo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, "User Name", "col-sm-3 col-lg-2 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV28UserName, GXutil.rtrim( localUtil.format( AV28UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "User name", edtavUsername_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 50, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.identityprovider.GxWebStd.gx_label_element( httpContext, edtavUserpassword_Internalname, "User Password", "col-sm-3 col-lg-2 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
         com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, edtavUserpassword_Internalname, GXutil.rtrim( AV29UserPassword), GXutil.rtrim( localUtil.format( AV29UserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Password", edtavUserpassword_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUserpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-7 col-xs-offset-3 col-sm-12 col-sm-offset-0 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", chkavKeepmeloggedin.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavKeepmeloggedin.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "CheckBox Label" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_checkbox_ctrl( httpContext, chkavKeepmeloggedin.getInternalname(), GXutil.booltostr( AV17KeepMeLoggedIn), "", "", chkavKeepmeloggedin.getVisible(), chkavKeepmeloggedin.getEnabled(), "true", "Keep me signed in", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(39, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-7 col-xs-offset-3 col-sm-12 col-sm-offset-0 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", chkavRememberme.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRememberme.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
         ClassString = "CheckBox Label" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRememberme.getInternalname(), GXutil.booltostr( AV22RememberMe), "", "", chkavRememberme.getVisible(), chkavRememberme.getEnabled(), "true", "Remember Me", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(44, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,44);\"");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.identityprovider.GxWebStd.gx_button_ctrl( httpContext, bttEnter_Internalname, "", "LOG IN", bttEnter_Jsonclick, 5, "LOG IN", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRemoteLogin.htm");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.identityprovider.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.identityprovider.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-12 col-sm-offset-0", "Center", "top", "", "", "div");
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTbforgotpwd_Internalname, "FORGOT YOUR PASSWORD?", "", "", lblTbforgotpwd_Jsonclick, "'"+""+"'"+",false,"+"'"+"e110f1_client"+"'", "", "PagingText TextLikeLink", 7, "", 1, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
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

   public void start0F2( )
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
         Form.getMeta().addItem("description", "Remote Login ", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0F0( ) ;
   }

   public void ws0F2( )
   {
      start0F2( ) ;
      evt0F2( ) ;
   }

   public void evt0F2( )
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
                        e120F2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Refresh */
                        e130F2 ();
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
                              e140F2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e150F2 ();
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

   public void we0F2( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0F2( ) ;
         }
      }
   }

   public void pa0F2( )
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
            GX_FocusControl = cmbavLogonto.getInternalname() ;
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
      if ( cmbavLogonto.getItemCount() > 0 )
      {
         AV21LogOnTo = cmbavLogonto.getValidValue(AV21LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LogOnTo", AV21LogOnTo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLogonto.setValue( GXutil.rtrim( AV21LogOnTo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
      }
      AV17KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV17KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17KeepMeLoggedIn", AV17KeepMeLoggedIn);
      AV22RememberMe = GXutil.strtobool( GXutil.booltostr( AV22RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22RememberMe", AV22RememberMe);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0F2( ) ;
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

   public void rf0F2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e130F2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e150F2 ();
         wb0F0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0F2( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV18Language));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18Language, ""))));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV30UserRememberMe, (byte)(2), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30UserRememberMe), "Z9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0F0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120F2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV13IDP_State = httpContext.cgiGet( "vIDP_STATE") ;
         /* Read variables values. */
         AV20LogoAppClient = httpContext.cgiGet( imgavLogoappclient_Internalname) ;
         cmbavLogonto.setValue( httpContext.cgiGet( cmbavLogonto.getInternalname()) );
         AV21LogOnTo = httpContext.cgiGet( cmbavLogonto.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LogOnTo", AV21LogOnTo);
         AV28UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28UserName", AV28UserName);
         AV29UserPassword = httpContext.cgiGet( edtavUserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29UserPassword", AV29UserPassword);
         AV17KeepMeLoggedIn = GXutil.strtobool( httpContext.cgiGet( chkavKeepmeloggedin.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17KeepMeLoggedIn", AV17KeepMeLoggedIn);
         AV22RememberMe = GXutil.strtobool( httpContext.cgiGet( chkavRememberme.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22RememberMe", AV22RememberMe);
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
      e120F2 ();
      if (returnInSub) return;
   }

   public void e120F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).checkconnection() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
      if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).ismultitenant() )
      {
         /* Execute user subroutine: 'ISMULTITENANTINSTALLATION' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         if ( ! AV14isConnectionOK )
         {
            AV8ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
            if ( AV8ConnectionInfoCollection.size() > 0 )
            {
               GXv_objcol_SdtGAMError1[0] = AV10Errors ;
               AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV8ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
               AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            }
         }
      }
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV31GAMApplication = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getremoteapplication(AV13IDP_State, GXv_objcol_SdtGAMError1);
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      lblTbappname_Caption = AV31GAMApplication.getgxTv_SdtGAMApplication_Name() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbappname_Internalname, "Caption", lblTbappname_Caption, true);
   }

   public void e130F2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      AV16isRedirect = false ;
      AV11ErrorsLogin = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
      if ( AV11ErrorsLogin.size() > 0 )
      {
         if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 1 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 104 ) )
         {
         }
         else if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 24 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 23 ) )
         {
            callWebObject(formatLink("com.identityprovider.gamexamplechangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13IDP_State))}, new String[] {"IDP_State"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
            AV16isRedirect = true ;
         }
         else if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
         {
            callWebObject(formatLink("com.identityprovider.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13IDP_State))}, new String[] {"IDP_State"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
            AV16isRedirect = true ;
         }
         else
         {
            AV29UserPassword = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29UserPassword", AV29UserPassword);
            AV10Errors = AV11ErrorsLogin ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S122 ();
            if (returnInSub) return;
            divTbllogin_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTbllogin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTbllogin_Visible), 5, 0), true);
         }
      }
      if ( ! AV16isRedirect )
      {
         GXv_SdtGAMSession2[0] = AV25Session;
         GXv_objcol_SdtGAMError1[0] = AV10Errors ;
         AV26SessionValid = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context).isvalid(GXv_SdtGAMSession2, GXv_objcol_SdtGAMError1) ;
         AV25Session = GXv_SdtGAMSession2[0] ;
         AV10Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV26SessionValid && ! AV25Session.getgxTv_SdtGAMSession_Isanonymous() )
         {
            if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isremoteauthentication(AV13IDP_State) )
            {
               new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).redirecttoremoteauthentication(AV13IDP_State) ;
            }
            else
            {
               AV27URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
               if ( (GXutil.strcmp("", AV27URL)==0) )
               {
                  new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context).gohome() ;
               }
               else
               {
                  callWebObject(formatLink(AV27URL, new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(0) ;
               }
            }
         }
         else
         {
            cmbavLogonto.removeAllItems();
            GXv_objcol_SdtGAMError1[0] = AV10Errors ;
            AV7AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV18Language, GXv_objcol_SdtGAMError1) ;
            AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            AV34GXV1 = 1 ;
            while ( AV34GXV1 <= AV7AuthenticationTypes.size() )
            {
               AV6AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+AV34GXV1));
               if ( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needusername() )
               {
                  cmbavLogonto.addItem(AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description(), (short)(0));
               }
               AV34GXV1 = (int)(AV34GXV1+1) ;
            }
            if ( cmbavLogonto.getItemCount() <= 1 )
            {
               cmbavLogonto.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLogonto.getVisible(), 5, 0), true);
            }
            GXv_char3[0] = AV21LogOnTo ;
            GXv_char4[0] = AV28UserName ;
            GXv_int5[0] = AV30UserRememberMe ;
            GXv_objcol_SdtGAMError1[0] = AV10Errors ;
            AV15isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getrememberlogin(GXv_char3, GXv_char4, GXv_int5, GXv_objcol_SdtGAMError1) ;
            gamremotelogin_impl.this.AV21LogOnTo = GXv_char3[0] ;
            gamremotelogin_impl.this.AV28UserName = GXv_char4[0] ;
            gamremotelogin_impl.this.AV30UserRememberMe = GXv_int5[0] ;
            AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( AV30UserRememberMe == 2 )
            {
               AV22RememberMe = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22RememberMe", AV22RememberMe);
            }
            AV23Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
            if ( cmbavLogonto.getItemCount() > 1 )
            {
               AV21LogOnTo = AV23Repository.getgxTv_SdtGAMRepository_Defaultauthenticationtypename() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21LogOnTo", AV21LogOnTo);
            }
            if ( GXutil.strcmp(AV23Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Login") == 0 )
            {
               chkavKeepmeloggedin.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
               chkavRememberme.setVisible( 1 );
               httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
            }
            else if ( GXutil.strcmp(AV23Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Auth") == 0 )
            {
               chkavKeepmeloggedin.setVisible( 1 );
               httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
               chkavRememberme.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
            }
            else if ( GXutil.strcmp(AV23Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Both") == 0 )
            {
               chkavKeepmeloggedin.setVisible( 1 );
               httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
               chkavRememberme.setVisible( 1 );
               httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
            }
            else
            {
               chkavRememberme.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
               chkavKeepmeloggedin.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavLogonto.setValue( GXutil.rtrim( AV21LogOnTo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e140F2 ();
      if (returnInSub) return;
   }

   public void e140F2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( AV17KeepMeLoggedIn )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(3) );
      }
      else if ( AV22RememberMe )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(2) );
      }
      else
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(1) );
      }
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV21LogOnTo );
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Idpstate( AV13IDP_State );
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV19LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV28UserName, AV29UserPassword, AV5AdditionalParameter, GXv_objcol_SdtGAMError1) ;
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV19LoginOK )
      {
      }
      else
      {
         if ( AV10Errors.size() > 0 )
         {
            if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 24 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 23 ) )
            {
               callWebObject(formatLink("com.identityprovider.gamexamplechangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
            {
               callWebObject(formatLink("com.identityprovider.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               AV29UserPassword = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29UserPassword", AV29UserPassword);
               /* Execute user subroutine: 'DISPLAYMESSAGES' */
               S122 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdditionalParameter", AV5AdditionalParameter);
   }

   public void S112( )
   {
      /* 'ISMULTITENANTINSTALLATION' Routine */
      returnInSub = false ;
      AV12GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( ! (0==AV12GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
      {
         GXv_objcol_SdtGAMError1[0] = AV10Errors ;
         AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV12GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
         AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      if ( ! AV14isConnectionOK )
      {
         GXv_char4[0] = AV24RepositoryGUID ;
         if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char4) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         gamremotelogin_impl.this.AV24RepositoryGUID = GXv_char4[0] ;
         if ( Cond_result )
         {
            GXv_objcol_SdtGAMError1[0] = AV10Errors ;
            AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryguid(AV24RepositoryGUID, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
            gamremotelogin_impl.this.AV24RepositoryGUID = GXv_char4[0] ;
         }
         else
         {
            AV8ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
            AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( AV8ConnectionInfoCollection.size() > 0 )
            {
               GXv_objcol_SdtGAMError1[0] = AV10Errors ;
               AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV8ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
               AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            }
         }
      }
      if ( AV14isConnectionOK )
      {
         AV12GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         if ( ! (0==AV12GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
         {
            GXv_objcol_SdtGAMError1[0] = AV10Errors ;
            AV14isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV12GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14isConnectionOK", AV14isConnectionOK);
            AV10Errors = GXv_objcol_SdtGAMError1[0] ;
            AV12GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         }
      }
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV35GXV2 = 1 ;
      while ( AV35GXV2 <= AV10Errors.size() )
      {
         AV9Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+AV35GXV2));
         if ( AV9Error.getgxTv_SdtGAMError_Code() != 13 )
         {
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV9Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV9Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         }
         AV35GXV2 = (int)(AV35GXV2+1) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e150F2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13IDP_State = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IDP_State", AV13IDP_State);
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
      pa0F2( ) ;
      ws0F2( ) ;
      we0F2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202122611575846", true, true);
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
      httpContext.AddJavascriptSource("gamremotelogin.js", "?202122611575853", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      imgavLogoappclient_Internalname = "vLOGOAPPCLIENT" ;
      lblTbappname_Internalname = "TBAPPNAME" ;
      cmbavLogonto.setInternalname( "vLOGONTO" );
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpassword_Internalname = "vUSERPASSWORD" ;
      chkavKeepmeloggedin.setInternalname( "vKEEPMELOGGEDIN" );
      chkavRememberme.setInternalname( "vREMEMBERME" );
      bttEnter_Internalname = "ENTER" ;
      lblTbforgotpwd_Internalname = "TBFORGOTPWD" ;
      divTbllogin_Internalname = "TBLLOGIN" ;
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
      chkavRememberme.setEnabled( 1 );
      chkavRememberme.setVisible( 1 );
      chkavKeepmeloggedin.setEnabled( 1 );
      chkavKeepmeloggedin.setVisible( 1 );
      edtavUserpassword_Jsonclick = "" ;
      edtavUserpassword_Enabled = 1 ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
      cmbavLogonto.setJsonclick( "" );
      cmbavLogonto.setEnabled( 1 );
      cmbavLogonto.setVisible( 1 );
      lblTbappname_Caption = "App Name" ;
      divTbllogin_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavLogonto.setName( "vLOGONTO" );
      cmbavLogonto.setWebtags( "" );
      if ( cmbavLogonto.getItemCount() > 0 )
      {
         AV21LogOnTo = cmbavLogonto.getValidValue(AV21LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LogOnTo", AV21LogOnTo);
      }
      chkavKeepmeloggedin.setName( "vKEEPMELOGGEDIN" );
      chkavKeepmeloggedin.setWebtags( "" );
      chkavKeepmeloggedin.setCaption( "Keep me signed in" );
      httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "TitleCaption", chkavKeepmeloggedin.getCaption(), true);
      chkavKeepmeloggedin.setCheckedValue( "false" );
      AV17KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV17KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17KeepMeLoggedIn", AV17KeepMeLoggedIn);
      chkavRememberme.setName( "vREMEMBERME" );
      chkavRememberme.setWebtags( "" );
      chkavRememberme.setCaption( "Remember Me" );
      httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "TitleCaption", chkavRememberme.getCaption(), true);
      chkavRememberme.setCheckedValue( "false" );
      AV22RememberMe = GXutil.strtobool( GXutil.booltostr( AV22RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22RememberMe", AV22RememberMe);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV28UserName',fld:'vUSERNAME',pic:''},{av:'AV18Language',fld:'vLANGUAGE',pic:'',hsh:true},{av:'AV30UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV29UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'divTbllogin_Visible',ctrl:'TBLLOGIN',prop:'Visible'},{av:'cmbavLogonto'},{av:'AV21LogOnTo',fld:'vLOGONTO',pic:''},{av:'chkavKeepmeloggedin.getVisible()',ctrl:'vKEEPMELOGGEDIN',prop:'Visible'},{av:'chkavRememberme.getVisible()',ctrl:'vREMEMBERME',prop:'Visible'},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e140F2',iparms:[{av:'cmbavLogonto'},{av:'AV21LogOnTo',fld:'vLOGONTO',pic:''},{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV28UserName',fld:'vUSERNAME',pic:''},{av:'AV29UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV29UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]}");
      setEventMetadata("'FORGOTPASSWORD'","{handler:'e110F1',iparms:[{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]");
      setEventMetadata("'FORGOTPASSWORD'",",oparms:[{av:'AV13IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV17KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV22RememberMe',fld:'vREMEMBERME',pic:''}]}");
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
      wcpOAV13IDP_State = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13IDP_State = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV18Language = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      AV20LogoAppClient = "" ;
      AV36Logoappclient_GXI = "" ;
      sImgUrl = "" ;
      lblTbappname_Jsonclick = "" ;
      TempTags = "" ;
      AV21LogOnTo = "" ;
      AV28UserName = "" ;
      AV29UserPassword = "" ;
      bttEnter_Jsonclick = "" ;
      lblTbforgotpwd_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8ConnectionInfoCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo>(genexus.security.api.genexussecurity.SdtGAMConnectionInfo.class, "GAMConnectionInfo", "http://tempuri.org/", remoteHandle);
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV31GAMApplication = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV11ErrorsLogin = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV25Session = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context);
      GXv_SdtGAMSession2 = new genexus.security.api.genexussecurity.SdtGAMSession[1] ;
      AV27URL = "" ;
      AV7AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple>(genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple.class, "GAMAuthenticationTypeSimple", "http://tempuri.org/", remoteHandle);
      AV6AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple(remoteHandle, context);
      GXv_char3 = new String[1] ;
      GXv_int5 = new byte[1] ;
      AV23Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV5AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      AV12GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV24RepositoryGUID = "" ;
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV9Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV30UserRememberMe ;
   private byte nDonePA ;
   private byte GXv_int5[] ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int divTbllogin_Visible ;
   private int edtavUsername_Enabled ;
   private int edtavUserpassword_Enabled ;
   private int AV34GXV1 ;
   private int AV35GXV2 ;
   private int idxLst ;
   private String wcpOAV13IDP_State ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV13IDP_State ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV18Language ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTbllogin_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String sImgUrl ;
   private String imgavLogoappclient_Internalname ;
   private String lblTbappname_Internalname ;
   private String lblTbappname_Caption ;
   private String lblTbappname_Jsonclick ;
   private String TempTags ;
   private String AV21LogOnTo ;
   private String edtavUsername_Internalname ;
   private String edtavUsername_Jsonclick ;
   private String edtavUserpassword_Internalname ;
   private String AV29UserPassword ;
   private String edtavUserpassword_Jsonclick ;
   private String bttEnter_Internalname ;
   private String bttEnter_Jsonclick ;
   private String lblTbforgotpwd_Internalname ;
   private String lblTbforgotpwd_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXv_char3[] ;
   private String AV24RepositoryGUID ;
   private String GXv_char4[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV20LogoAppClient_IsBlob ;
   private boolean AV17KeepMeLoggedIn ;
   private boolean AV22RememberMe ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14isConnectionOK ;
   private boolean AV16isRedirect ;
   private boolean AV26SessionValid ;
   private boolean AV15isOK ;
   private boolean AV19LoginOK ;
   private boolean Cond_result ;
   private String AV36Logoappclient_GXI ;
   private String AV28UserName ;
   private String AV27URL ;
   private String AV20LogoAppClient ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV5AdditionalParameter ;
   private HTMLChoice cmbavLogonto ;
   private ICheckbox chkavKeepmeloggedin ;
   private ICheckbox chkavRememberme ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple> AV7AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo> AV8ConnectionInfoCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11ErrorsLogin ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple AV6AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV9Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV23Repository ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV12GAMRepository ;
   private genexus.security.api.genexussecurity.SdtGAMSession AV25Session ;
   private genexus.security.api.genexussecurity.SdtGAMSession GXv_SdtGAMSession2[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV31GAMApplication ;
}

