package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recentlinks_impl extends GXWebComponent
{
   public recentlinks_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public recentlinks_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recentlinks_impl.class ));
   }

   public recentlinks_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "FormCaption") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV6FormCaption = httpContext.GetPar( "FormCaption") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FormCaption", AV6FormCaption);
               AV7FormPgmName = httpContext.GetPar( "FormPgmName") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FormPgmName", AV7FormPgmName);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV6FormCaption,AV7FormPgmName});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "FormCaption") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "FormCaption") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Links") == 0 )
            {
               nRC_GXsfl_7 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_7"))) ;
               nGXsfl_7_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_7_idx"))) ;
               sGXsfl_7_idx = httpContext.GetPar( "sGXsfl_7_idx") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxnrlinks_newrow( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Links") == 0 )
            {
               AV6FormCaption = httpContext.GetPar( "FormCaption") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               init_default_properties( ) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxgrlinks_refresh( AV6FormCaption, sPrefix) ;
               addString( httpContext.getJSONResponse( )) ;
               return  ;
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa022( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
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
      com.identityprovider.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), false);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Recent Links web component") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?202122611562584", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"Form\" data-gx-class=\"Form\" novalidate action=\""+formatLink("com.identityprovider.recentlinks", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6FormCaption)),GXutil.URLEncode(GXutil.rtrim(AV7FormPgmName))}, new String[] {"FormCaption","FormPgmName"}) +"\">") ;
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "Form", true);
         }
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_7", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_7, (byte)(8), (byte)(0), ".", "")));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6FormCaption", GXutil.rtrim( wcpOAV6FormCaption));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7FormPgmName", wcpOAV7FormPgmName);
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFORMCAPTION", GXutil.rtrim( AV6FormCaption));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFORMPGMNAME", AV7FormPgmName);
   }

   public void renderHtmlCloseForm022( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
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
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "RecentLinks" ;
   }

   public String getPgmdesc( )
   {
      return "Recent Links web component" ;
   }

   public void wb020( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.identityprovider.recentlinks");
         }
         com.identityprovider.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         wb_table1_2_022( true) ;
      }
      else
      {
         wb_table1_2_022( false) ;
      }
      return  ;
   }

   public void wb_table1_2_022e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table2_14_022( true) ;
      }
      else
      {
         wb_table2_14_022( false) ;
      }
      return  ;
   }

   public void wb_table2_14_022e( boolean wbgen )
   {
      if ( wbgen )
      {
      }
      if ( wbEnd == 7 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( LinksContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"LinksContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Links", LinksContainer);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LinksContainerData", LinksContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LinksContainerData"+"V", LinksContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"LinksContainerData"+"V"+"\" value='"+LinksContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start022( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_2-148375", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "Recent Links web component", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup020( ) ;
         }
      }
   }

   public void ws022( )
   {
      start022( ) ;
      evt022( ) ;
   }

   public void evt022( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
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
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup020( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup020( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "LINKS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup020( ) ;
                           }
                           nGXsfl_7_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_7_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_7_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_72( ) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e11022 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LINKS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e12022 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup020( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we022( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm022( ) ;
         }
      }
   }

   public void pa022( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(0)) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrlinks_newrow( )
   {
      com.identityprovider.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_72( ) ;
      while ( nGXsfl_7_idx <= nRC_GXsfl_7 )
      {
         sendrow_72( ) ;
         nGXsfl_7_idx = ((subLinks_Islastpage==1)&&(nGXsfl_7_idx+1>sublinks_fnc_recordsperpage( )) ? 1 : nGXsfl_7_idx+1) ;
         sGXsfl_7_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_7_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_72( ) ;
      }
      addString( httpContext.getJSONContainerResponse( LinksContainer)) ;
      /* End function gxnrLinks_newrow */
   }

   public void gxgrlinks_refresh( String AV6FormCaption ,
                                  String sPrefix )
   {
      initialize_formulas( ) ;
      com.identityprovider.GxWebStd.set_html_headers( httpContext, 0, "", "");
      LINKS_nCurrentRecord = 0 ;
      rf022( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrLinks_refresh */
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
      rf022( ) ;
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

   public void rf022( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         LinksContainer.ClearRows();
      }
      wbStart = (short)(7) ;
      nGXsfl_7_idx = 1 ;
      sGXsfl_7_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_7_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_72( ) ;
      bGXsfl_7_Refreshing = true ;
      LinksContainer.AddObjectProperty("GridName", "Links");
      LinksContainer.AddObjectProperty("CmpContext", sPrefix);
      LinksContainer.AddObjectProperty("InMasterPage", "false");
      LinksContainer.AddObjectProperty("Class", GXutil.rtrim( "RecentLinksTable"));
      LinksContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      LinksContainer.AddObjectProperty("Rules", GXutil.rtrim( "none"));
      LinksContainer.AddObjectProperty("Class", "RecentLinksTable");
      LinksContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      LinksContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      LinksContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subLinks_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      LinksContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( subLinks_Borderwidth, (byte)(4), (byte)(0), ".", "")));
      LinksContainer.setPageSize( sublinks_fnc_recordsperpage( ) );
      if ( subLinks_Islastpage != 0 )
      {
         LINKS_nFirstRecordOnPage = (long)(sublinks_fnc_recordcount( )-sublinks_fnc_recordsperpage( )) ;
         com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LINKS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( LINKS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         LinksContainer.AddObjectProperty("LINKS_nFirstRecordOnPage", LINKS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_72( ) ;
         e12022 ();
         wbEnd = (short)(7) ;
         wb020( ) ;
      }
      bGXsfl_7_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes022( )
   {
   }

   public int sublinks_fnc_pagecount( )
   {
      return -1 ;
   }

   public int sublinks_fnc_recordcount( )
   {
      return -1 ;
   }

   public int sublinks_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int sublinks_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup020( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11022 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_7 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_7"), ".", ",")) ;
         wcpOAV6FormCaption = httpContext.cgiGet( sPrefix+"wcpOAV6FormCaption") ;
         wcpOAV7FormPgmName = httpContext.cgiGet( sPrefix+"wcpOAV7FormPgmName") ;
         /* Read variables values. */
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
      e11022 ();
      if (returnInSub) return;
   }

   public void e11022( )
   {
      /* Start Routine */
      returnInSub = false ;
      lblPipe_Caption = "|" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblPipe_Internalname, "Caption", lblPipe_Caption, !bGXsfl_7_Refreshing);
   }

   private void e12022( )
   {
      /* Links_Load Routine */
      returnInSub = false ;
      AV11RecentLinksItems.fromxml(AV8Session.getValue("RecentLinks"), null, null);
      AV9i = 1 ;
      while ( AV9i <= AV11RecentLinksItems.size() )
      {
         AV12RecentLinksItem = (com.identityprovider.SdtLinkList_LinkItem)((com.identityprovider.SdtLinkList_LinkItem)AV11RecentLinksItems.elementAt(-1+AV9i));
         if ( GXutil.strcmp(GXutil.trim( AV12RecentLinksItem.getgxTv_SdtLinkList_LinkItem_Caption()), GXutil.trim( AV6FormCaption)) == 0 )
         {
            AV11RecentLinksItems.removeItem(AV9i);
         }
         else
         {
            AV9i = (int)(AV9i+1) ;
         }
      }
      while ( AV11RecentLinksItems.size() > 8 - 1 )
      {
         AV11RecentLinksItems.removeItem(1);
      }
      AV12RecentLinksItem = (com.identityprovider.SdtLinkList_LinkItem)new com.identityprovider.SdtLinkList_LinkItem(remoteHandle, context);
      AV12RecentLinksItem.setgxTv_SdtLinkList_LinkItem_Caption( GXutil.trim( AV6FormCaption) );
      AV12RecentLinksItem.setgxTv_SdtLinkList_LinkItem_Url( AV10Request.getScriptName()+"?"+AV10Request.getQuerystring() );
      AV11RecentLinksItems.add(AV12RecentLinksItem, 0);
      AV8Session.setValue("RecentLinks", AV11RecentLinksItems.toxml(false, true, "LinkList", "GeneXus"));
      AV9i = 1 ;
      while ( AV9i <= AV11RecentLinksItems.size() )
      {
         AV12RecentLinksItem = (com.identityprovider.SdtLinkList_LinkItem)((com.identityprovider.SdtLinkList_LinkItem)AV11RecentLinksItems.elementAt(-1+AV9i));
         AV13PlaceCaption = AV12RecentLinksItem.getgxTv_SdtLinkList_LinkItem_Caption() ;
         if ( GXutil.len( AV13PlaceCaption) > 20 )
         {
            AV13PlaceCaption = GXutil.format( "%1...", GXutil.substring( AV13PlaceCaption, 1, 18), "", "", "", "", "", "", "", "") ;
         }
         lblPlace_Caption = AV13PlaceCaption ;
         if ( AV9i < AV11RecentLinksItems.size() )
         {
            lblPlace_Link = formatLink(AV12RecentLinksItem.getgxTv_SdtLinkList_LinkItem_Url(), new String[] {}, new String[] {})  ;
         }
         else
         {
            lblPlace_Link = "" ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(7) ;
         }
         sendrow_72( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_7_Refreshing )
         {
            httpContext.doAjaxLoad(7, LinksRow);
         }
         AV9i = (int)(AV9i+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table2_14_022( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblBottomline_Internalname, tblBottomline_Internalname, "", "TableHorizontalLine", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_14_022e( true) ;
      }
      else
      {
         wb_table2_14_022e( false) ;
      }
   }

   public void wb_table1_2_022( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable_Internalname, tblTable_Internalname, "", "RecentLinksTable", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "width:1%")+"\">") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblRecenttext_Internalname, "Recents: ", "", "", lblRecenttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "RecentLink", 0, "", 1, 1, 0, (short)(0), "HLP_RecentLinks.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /*  Grid Control  */
         LinksContainer.SetIsFreestyle(true);
         LinksContainer.SetWrapped(nGXWrapped);
         if ( LinksContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+sPrefix+"LinksContainer"+"DivS\" data-gxgridid=\"7\">") ;
            sStyleString = "" ;
            com.identityprovider.GxWebStd.gx_table_start( httpContext, subLinks_Internalname, subLinks_Internalname, "", "RecentLinksTable", 0, "", "", 1, 2, sStyleString, "none", "", 0);
            LinksContainer.AddObjectProperty("GridName", "Links");
         }
         else
         {
            LinksContainer.AddObjectProperty("GridName", "Links");
            LinksContainer.AddObjectProperty("Header", subLinks_Header);
            LinksContainer.AddObjectProperty("Class", GXutil.rtrim( "RecentLinksTable"));
            LinksContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Rules", GXutil.rtrim( "none"));
            LinksContainer.AddObjectProperty("Class", "RecentLinksTable");
            LinksContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subLinks_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( subLinks_Borderwidth, (byte)(4), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("CmpContext", sPrefix);
            LinksContainer.AddObjectProperty("InMasterPage", "false");
            LinksColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            LinksContainer.AddColumnProperties(LinksColumn);
            LinksColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            LinksContainer.AddColumnProperties(LinksColumn);
            LinksColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            LinksColumn.AddObjectProperty("Value", lblPlace_Caption);
            LinksContainer.AddColumnProperties(LinksColumn);
            LinksColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            LinksContainer.AddColumnProperties(LinksColumn);
            LinksColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            LinksColumn.AddObjectProperty("Value", lblPipe_Caption);
            LinksContainer.AddColumnProperties(LinksColumn);
            LinksContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subLinks_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subLinks_Allowselection, (byte)(1), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subLinks_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subLinks_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subLinks_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subLinks_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            LinksContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subLinks_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 7 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_7 = (int)(nGXsfl_7_idx-1) ;
         if ( LinksContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"LinksContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Links", LinksContainer);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LinksContainerData", LinksContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LinksContainerData"+"V", LinksContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"LinksContainerData"+"V"+"\" value='"+LinksContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='td100'>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_022e( true) ;
      }
      else
      {
         wb_table1_2_022e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6FormCaption = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FormCaption", AV6FormCaption);
      AV7FormPgmName = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FormPgmName", AV7FormPgmName);
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
      pa022( ) ;
      ws022( ) ;
      we022( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV6FormCaption = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7FormPgmName = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa022( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "recentlinks", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa022( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV6FormCaption = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FormCaption", AV6FormCaption);
         AV7FormPgmName = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FormPgmName", AV7FormPgmName);
      }
      wcpOAV6FormCaption = httpContext.cgiGet( sPrefix+"wcpOAV6FormCaption") ;
      wcpOAV7FormPgmName = httpContext.cgiGet( sPrefix+"wcpOAV7FormPgmName") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6FormCaption, wcpOAV6FormCaption) != 0 ) || ( GXutil.strcmp(AV7FormPgmName, wcpOAV7FormPgmName) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV6FormCaption = AV6FormCaption ;
      wcpOAV7FormPgmName = AV7FormPgmName ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV6FormCaption = httpContext.cgiGet( sPrefix+"AV6FormCaption_CTRL") ;
      if ( GXutil.len( sCtrlAV6FormCaption) > 0 )
      {
         AV6FormCaption = httpContext.cgiGet( sCtrlAV6FormCaption) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FormCaption", AV6FormCaption);
      }
      else
      {
         AV6FormCaption = httpContext.cgiGet( sPrefix+"AV6FormCaption_PARM") ;
      }
      sCtrlAV7FormPgmName = httpContext.cgiGet( sPrefix+"AV7FormPgmName_CTRL") ;
      if ( GXutil.len( sCtrlAV7FormPgmName) > 0 )
      {
         AV7FormPgmName = httpContext.cgiGet( sCtrlAV7FormPgmName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FormPgmName", AV7FormPgmName);
      }
      else
      {
         AV7FormPgmName = httpContext.cgiGet( sPrefix+"AV7FormPgmName_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa022( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws022( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws022( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6FormCaption_PARM", GXutil.rtrim( AV6FormCaption));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6FormCaption)) > 0 )
      {
         com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6FormCaption_CTRL", GXutil.rtrim( sCtrlAV6FormCaption));
      }
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7FormPgmName_PARM", AV7FormPgmName);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7FormPgmName)) > 0 )
      {
         com.identityprovider.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7FormPgmName_CTRL", GXutil.rtrim( sCtrlAV7FormPgmName));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we022( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202122611562622", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("recentlinks.js", "?202122611562622", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_72( )
   {
      lblPlace_Internalname = sPrefix+"PLACE_"+sGXsfl_7_idx ;
      lblPipe_Internalname = sPrefix+"PIPE_"+sGXsfl_7_idx ;
   }

   public void subsflControlProps_fel_72( )
   {
      lblPlace_Internalname = sPrefix+"PLACE_"+sGXsfl_7_fel_idx ;
      lblPipe_Internalname = sPrefix+"PIPE_"+sGXsfl_7_fel_idx ;
   }

   public void sendrow_72( )
   {
      subsflControlProps_72( ) ;
      wb020( ) ;
      LinksRow = GXWebRow.GetNew(context,LinksContainer) ;
      if ( subLinks_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subLinks_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subLinks_Class, "") != 0 )
         {
            subLinks_Linesclass = subLinks_Class+"Odd" ;
         }
      }
      else if ( subLinks_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subLinks_Backstyle = (byte)(0) ;
         subLinks_Backcolor = subLinks_Allbackcolor ;
         if ( GXutil.strcmp(subLinks_Class, "") != 0 )
         {
            subLinks_Linesclass = subLinks_Class+"Uniform" ;
         }
      }
      else if ( subLinks_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subLinks_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subLinks_Class, "") != 0 )
         {
            subLinks_Linesclass = subLinks_Class+"Odd" ;
         }
         subLinks_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subLinks_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subLinks_Backstyle = (byte)(1) ;
         subLinks_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subLinks_Class, "") != 0 )
         {
            subLinks_Linesclass = subLinks_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      LinksRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"",subLinks_Linesclass,""});
      LinksRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      LinksRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblPlace_Internalname,lblPlace_Caption,lblPlace_Link,"",lblPlace_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","RecentLinkItem",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      if ( LinksContainer.GetWrapped() == 1 )
      {
         LinksContainer.CloseTag("cell");
      }
      LinksRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"",""+" style=\""+GXutil.CssPrettify( "width:4px")+"\"","td100"});
      /* Text block */
      LinksRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblPipe_Internalname,lblPipe_Caption,"","",lblPipe_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","RecentLinkItem",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      if ( LinksContainer.GetWrapped() == 1 )
      {
         LinksContainer.CloseTag("cell");
      }
      if ( LinksContainer.GetWrapped() == 1 )
      {
         LinksContainer.CloseTag("row");
      }
      send_integrity_lvl_hashes022( ) ;
      /* End of Columns property logic. */
      LinksContainer.AddRow(LinksRow);
      nGXsfl_7_idx = ((subLinks_Islastpage==1)&&(nGXsfl_7_idx+1>sublinks_fnc_recordsperpage( )) ? 1 : nGXsfl_7_idx+1) ;
      sGXsfl_7_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_7_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_72( ) ;
      /* End function sendrow_72 */
   }

   public void init_default_properties( )
   {
      lblRecenttext_Internalname = sPrefix+"RECENTTEXT" ;
      lblPlace_Internalname = sPrefix+"PLACE" ;
      lblPipe_Internalname = sPrefix+"PIPE" ;
      tblTable_Internalname = sPrefix+"TABLE" ;
      tblBottomline_Internalname = sPrefix+"BOTTOMLINE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subLinks_Internalname = sPrefix+"LINKS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("Carmine");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      lblPlace_Jsonclick = "" ;
      lblPlace_Link = "" ;
      subLinks_Class = "RecentLinksTable" ;
      subLinks_Allowcollapsing = (byte)(0) ;
      lblPipe_Caption = "" ;
      lblPlace_Caption = "Place" ;
      lblPipe_Caption = "" ;
      subLinks_Borderwidth = (short)(0) ;
      subLinks_Backcolorstyle = (byte)(0) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'LINKS_nFirstRecordOnPage'},{av:'LINKS_nEOF'},{av:'AV6FormCaption',fld:'vFORMCAPTION',pic:''},{av:'sPrefix'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("LINKS.LOAD","{handler:'e12022',iparms:[{av:'AV6FormCaption',fld:'vFORMCAPTION',pic:''}]");
      setEventMetadata("LINKS.LOAD",",oparms:[{av:'lblPlace_Caption',ctrl:'PLACE',prop:'Caption'},{av:'lblPlace_Link',ctrl:'PLACE',prop:'Link'}]}");
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
      wcpOAV6FormCaption = "" ;
      wcpOAV7FormPgmName = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6FormCaption = "" ;
      AV7FormPgmName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      LinksContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV11RecentLinksItems = new GXBaseCollection<com.identityprovider.SdtLinkList_LinkItem>(com.identityprovider.SdtLinkList_LinkItem.class, "LinkItem", "GeneXus", remoteHandle);
      AV8Session = httpContext.getWebSession();
      AV12RecentLinksItem = new com.identityprovider.SdtLinkList_LinkItem(remoteHandle, context);
      AV10Request = httpContext.getHttpRequest();
      AV13PlaceCaption = "" ;
      LinksRow = new com.genexus.webpanels.GXWebRow();
      lblRecenttext_Jsonclick = "" ;
      subLinks_Header = "" ;
      LinksColumn = new com.genexus.webpanels.GXWebColumn();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6FormCaption = "" ;
      sCtrlAV7FormPgmName = "" ;
      subLinks_Linesclass = "" ;
      lblPipe_Jsonclick = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subLinks_Backcolorstyle ;
   private byte subLinks_Allowselection ;
   private byte subLinks_Allowhovering ;
   private byte subLinks_Allowcollapsing ;
   private byte subLinks_Collapsed ;
   private byte subLinks_Backstyle ;
   private byte LINKS_nEOF ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short subLinks_Borderwidth ;
   private int nRC_GXsfl_7 ;
   private int nGXsfl_7_idx=1 ;
   private int subLinks_Islastpage ;
   private int AV9i ;
   private int subLinks_Selectedindex ;
   private int subLinks_Selectioncolor ;
   private int subLinks_Hoveringcolor ;
   private int idxLst ;
   private int subLinks_Backcolor ;
   private int subLinks_Allbackcolor ;
   private long LINKS_nCurrentRecord ;
   private long LINKS_nFirstRecordOnPage ;
   private String wcpOAV6FormCaption ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV6FormCaption ;
   private String sGXsfl_7_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sStyleString ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String lblPipe_Caption ;
   private String lblPipe_Internalname ;
   private String lblPlace_Caption ;
   private String lblPlace_Link ;
   private String tblBottomline_Internalname ;
   private String tblTable_Internalname ;
   private String lblRecenttext_Internalname ;
   private String lblRecenttext_Jsonclick ;
   private String subLinks_Internalname ;
   private String subLinks_Header ;
   private String sCtrlAV6FormCaption ;
   private String sCtrlAV7FormPgmName ;
   private String lblPlace_Internalname ;
   private String sGXsfl_7_fel_idx="0001" ;
   private String subLinks_Class ;
   private String subLinks_Linesclass ;
   private String lblPlace_Jsonclick ;
   private String lblPipe_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_7_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV7FormPgmName ;
   private String AV7FormPgmName ;
   private String AV13PlaceCaption ;
   private com.genexus.webpanels.GXWebGrid LinksContainer ;
   private com.genexus.webpanels.GXWebRow LinksRow ;
   private com.genexus.webpanels.GXWebColumn LinksColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10Request ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private GXBaseCollection<com.identityprovider.SdtLinkList_LinkItem> AV11RecentLinksItems ;
   private com.identityprovider.SdtLinkList_LinkItem AV12RecentLinksItem ;
}

