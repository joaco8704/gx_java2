package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class appmasterpage_impl extends GXMasterPage
{
   public appmasterpage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public appmasterpage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( appmasterpage_impl.class ));
   }

   public appmasterpage_impl( int remoteHandle ,
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
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa012( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws012( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we012( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
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
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
      com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
   }

   public void renderHtmlCloseForm012( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! ( WebComp_Wcrecentlinks == null ) )
      {
         WebComp_Wcrecentlinks.componentjscripts();
      }
      httpContext.AddJavascriptSource("appmasterpage.js", "?202122611562527", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "AppMasterPage" ;
   }

   public String getPgmdesc( )
   {
      return "Application Master Page " ;
   }

   public void wb010( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            com.identityprovider.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
         }
         wb_table1_2_012( true) ;
      }
      else
      {
         wb_table1_2_012( false) ;
      }
      return  ;
   }

   public void wb_table1_2_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "<p></p>") ;
      }
      wbLoad = true ;
   }

   public void start012( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup010( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void ws012( )
   {
      start012( ) ;
      evt012( ) ;
   }

   public void evt012( )
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
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Refresh */
                        e12012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e13012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                           }
                           dynload_actions( ) ;
                        }
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
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 34 )
                  {
                     OldWcrecentlinks = httpContext.cgiGet( "MPW0034") ;
                     if ( ( GXutil.len( OldWcrecentlinks) == 0 ) || ( GXutil.strcmp(OldWcrecentlinks, WebComp_Wcrecentlinks_Component) != 0 ) )
                     {
                        WebComp_Wcrecentlinks = WebUtils.getWebComponent(getClass(), "com.identityprovider." + OldWcrecentlinks + "_impl", remoteHandle, context);
                        WebComp_Wcrecentlinks_Component = OldWcrecentlinks ;
                     }
                     if ( GXutil.len( WebComp_Wcrecentlinks_Component) != 0 )
                     {
                        WebComp_Wcrecentlinks.componentprocess("MPW0034", "", sEvt);
                     }
                     WebComp_Wcrecentlinks_Component = OldWcrecentlinks ;
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we012( )
   {
      if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.identityprovider.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm012( ) ;
         }
      }
   }

   public void pa012( )
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
      rf012( ) ;
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

   public void rf012( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         /* Execute user event: Refresh */
         e12012 ();
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( 1 != 0 )
            {
               if ( GXutil.len( WebComp_Wcrecentlinks_Component) != 0 )
               {
                  WebComp_Wcrecentlinks.componentstart();
               }
            }
         }
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13012 ();
         wb010( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
   }

   public void send_integrity_lvl_hashes012( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup010( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( httpContext.cgiGet( "FORM_MPAGE_Caption") );
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
      e11012 ();
      if (returnInSub) return;
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      lblPipe_Caption = "|" ;
      httpContext.ajax_rsp_assign_prop("", true, lblPipe_Internalname, "Caption", lblPipe_Caption, true);
      lblPipe2_Caption = "|" ;
      httpContext.ajax_rsp_assign_prop("", true, lblPipe2_Internalname, "Caption", lblPipe2_Caption, true);
   }

   public void e12012( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Wcrecentlinks = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Wcrecentlinks_Component), GXutil.lower( "RecentLinks")) != 0 )
      {
         WebComp_Wcrecentlinks = WebUtils.getWebComponent(getClass(), "com.identityprovider.recentlinks_impl", remoteHandle, context);
         WebComp_Wcrecentlinks_Component = "RecentLinks" ;
      }
      if ( GXutil.len( WebComp_Wcrecentlinks_Component) != 0 )
      {
         WebComp_Wcrecentlinks.setjustcreated();
         WebComp_Wcrecentlinks.componentprepare(new Object[] {"MPW0034","",(getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption(),Contentholder.getPgmname()});
         WebComp_Wcrecentlinks.componentbind(new Object[] {"",""});
      }
      if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wcrecentlinks )
      {
         httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0034"+"");
         WebComp_Wcrecentlinks.componentdraw();
         httpContext.ajax_rspEndCmp();
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e13012( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_2_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable1_Internalname, tblTable1_Internalname, "", "Table960", 0, "center", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_5_012( true) ;
      }
      else
      {
         wb_table2_5_012( false) ;
      }
      return  ;
   }

   public void wb_table2_5_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table3_22_012( true) ;
      }
      else
      {
         wb_table3_22_012( false) ;
      }
      return  ;
   }

   public void wb_table3_22_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td colspan=\"2\" >") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.identityprovider.GxWebStd.gx_hidden_field( httpContext, "MPW0034"+"", GXutil.rtrim( WebComp_Wcrecentlinks_Component));
            httpContext.writeText( "<div") ;
            com.identityprovider.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0034"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wcrecentlinks_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWcrecentlinks), GXutil.lower( WebComp_Wcrecentlinks_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0034"+"");
               }
               WebComp_Wcrecentlinks.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWcrecentlinks), GXutil.lower( WebComp_Wcrecentlinks_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "height:14px;width:100%")+"\">") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "height:15px")+"\">") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td colspan=\"2\" >") ;
         wb_table4_42_012( true) ;
      }
      else
      {
         wb_table4_42_012( false) ;
      }
      return  ;
   }

   public void wb_table4_42_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td colspan=\"2\" >") ;
         wb_table5_47_012( true) ;
      }
      else
      {
         wb_table5_47_012( false) ;
      }
      return  ;
   }

   public void wb_table5_47_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_012e( true) ;
      }
      else
      {
         wb_table1_2_012e( false) ;
      }
   }

   public void wb_table5_47_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable7_Internalname, tblTable7_Internalname, "", "TableGreyFooter", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Footer Info", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "FooterText", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_47_012e( true) ;
      }
      else
      {
         wb_table5_47_012e( false) ;
      }
   }

   public void wb_table4_42_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable6_Internalname, tblTable6_Internalname, "", "TableBlackFooter", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "<p></p>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_42_012e( true) ;
      }
      else
      {
         wb_table4_42_012e( false) ;
      }
   }

   public void wb_table3_22_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable4_Internalname, tblTable4_Internalname, "", "TableBlackHeader", 0, "", "", 1, 2, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblFirsttext_Internalname, "First Option", "", "", lblFirsttext_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "MenuOption", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "&nbsp; ") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblSecondtext_Internalname, "Second Option", "", "", lblSecondtext_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "MenuOption", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblThirdtext_Internalname, "Third Option", "", "", lblThirdtext_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "MenuOption", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "&nbsp; ") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblFourthtext_Internalname, "Fourth Option", "", "", lblFourthtext_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "MenuOption", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_22_012e( true) ;
      }
      else
      {
         wb_table3_22_012e( false) ;
      }
   }

   public void wb_table2_5_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(63), 10, 0) + "px" + ";" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable2_Internalname, tblTable2_Internalname, "", "TableTop", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "&nbsp; ") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblApplicationheader_Internalname, "Application Header", "", "", lblApplicationheader_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlockHeader", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-right;text-align:-moz-right;text-align:-webkit-right")+"\">") ;
         httpContext.writeText( "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ") ;
         wb_table6_10_012( true) ;
      }
      else
      {
         wb_table6_10_012( false) ;
      }
      return  ;
   }

   public void wb_table6_10_012e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_5_012e( true) ;
      }
      else
      {
         wb_table2_5_012e( false) ;
      }
   }

   public void wb_table6_10_012( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += "background-color: " + "Transparent;" ;
         com.identityprovider.GxWebStd.gx_table_start( httpContext, tblTable3_Internalname, tblTable3_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td colspan=\"3\" >") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblEnglish_Internalname, "English", "", "", lblEnglish_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "SmallText", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblPipe_Internalname, lblPipe_Caption, "", "", lblPipe_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblSpanish_Internalname, "Español", "", "", lblSpanish_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "SmallText", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblPipe2_Internalname, lblPipe2_Caption, "", "", lblPipe2_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.identityprovider.GxWebStd.gx_label_ctrl( httpContext, lblPortuguese_Internalname, "Português", "", "", lblPortuguese_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "SmallText", 0, "", 1, 1, 0, (short)(0), "HLP_AppMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_10_012e( true) ;
      }
      else
      {
         wb_table6_10_012e( false) ;
      }
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
      pa012( ) ;
      ws012( ) ;
      we012( ) ;
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

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wcrecentlinks == null ) )
      {
         if ( GXutil.len( WebComp_Wcrecentlinks_Component) != 0 )
         {
            WebComp_Wcrecentlinks.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?202122611562559", true, true);
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
      httpContext.AddJavascriptSource("appmasterpage.js", "?202122611562559", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblApplicationheader_Internalname = "APPLICATIONHEADER_MPAGE" ;
      lblEnglish_Internalname = "ENGLISH_MPAGE" ;
      lblPipe_Internalname = "PIPE_MPAGE" ;
      lblSpanish_Internalname = "SPANISH_MPAGE" ;
      lblPipe2_Internalname = "PIPE2_MPAGE" ;
      lblPortuguese_Internalname = "PORTUGUESE_MPAGE" ;
      tblTable3_Internalname = "TABLE3_MPAGE" ;
      tblTable2_Internalname = "TABLE2_MPAGE" ;
      lblFirsttext_Internalname = "FIRSTTEXT_MPAGE" ;
      lblSecondtext_Internalname = "SECONDTEXT_MPAGE" ;
      lblThirdtext_Internalname = "THIRDTEXT_MPAGE" ;
      lblFourthtext_Internalname = "FOURTHTEXT_MPAGE" ;
      tblTable4_Internalname = "TABLE4_MPAGE" ;
      tblTable6_Internalname = "TABLE6_MPAGE" ;
      lblTextblock1_Internalname = "TEXTBLOCK1_MPAGE" ;
      tblTable7_Internalname = "TABLE7_MPAGE" ;
      tblTable1_Internalname = "TABLE1_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      lblEnglish_Jsonclick = "" ;
      lblPipe2_Caption = "" ;
      lblPipe_Caption = "" ;
      Contentholder.setDataArea(getDataAreaObject());
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
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[{ctrl:'FORM_MPAGE',prop:'Caption'}]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{ctrl:'WCRECENTLINKS_MPAGE'}]}");
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
      Contentholder = new com.genexus.webpanels.GXDataAreaControl();
      Form = new com.genexus.webpanels.GXWebForm();
      GXKey = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldWcrecentlinks = "" ;
      WebComp_Wcrecentlinks_Component = "" ;
      sStyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblFirsttext_Jsonclick = "" ;
      lblSecondtext_Jsonclick = "" ;
      lblThirdtext_Jsonclick = "" ;
      lblFourthtext_Jsonclick = "" ;
      lblApplicationheader_Jsonclick = "" ;
      lblPipe_Jsonclick = "" ;
      lblSpanish_Jsonclick = "" ;
      lblPipe2_Jsonclick = "" ;
      lblPortuguese_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Wcrecentlinks = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int idxLst ;
   private String GXKey ;
   private String sPrefix ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldWcrecentlinks ;
   private String WebComp_Wcrecentlinks_Component ;
   private String lblPipe_Caption ;
   private String lblPipe_Internalname ;
   private String lblPipe2_Caption ;
   private String lblPipe2_Internalname ;
   private String sStyleString ;
   private String tblTable1_Internalname ;
   private String tblTable7_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String tblTable6_Internalname ;
   private String tblTable4_Internalname ;
   private String lblFirsttext_Internalname ;
   private String lblFirsttext_Jsonclick ;
   private String lblSecondtext_Internalname ;
   private String lblSecondtext_Jsonclick ;
   private String lblThirdtext_Internalname ;
   private String lblThirdtext_Jsonclick ;
   private String lblFourthtext_Internalname ;
   private String lblFourthtext_Jsonclick ;
   private String tblTable2_Internalname ;
   private String lblApplicationheader_Internalname ;
   private String lblApplicationheader_Jsonclick ;
   private String tblTable3_Internalname ;
   private String lblEnglish_Internalname ;
   private String lblEnglish_Jsonclick ;
   private String lblPipe_Jsonclick ;
   private String lblSpanish_Internalname ;
   private String lblSpanish_Jsonclick ;
   private String lblPipe2_Jsonclick ;
   private String lblPortuguese_Internalname ;
   private String lblPortuguese_Jsonclick ;
   private String sDynURL ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Wcrecentlinks ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wcrecentlinks ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private com.genexus.webpanels.GXWebForm Form ;
}

