
package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.internet.*;
import com.genexus.webpanels.*;

public final  class GxWebStd
{
   public static void gx_hidden_field( HttpContext httpContext ,
                                       String sCtrlName ,
                                       String sValue )
   {
      httpContext.ajax_rsp_assign_hidden(sCtrlName, sValue);
   }

   public static void gx_boolean_hidden_field( HttpContext httpContext ,
                                               String sCtrlName ,
                                               boolean bValue )
   {
      httpContext.ajax_rsp_assign_boolean_hidden(sCtrlName, bValue);
   }

   public static void gx_single_line_edit1( HttpContext httpContext ,
                                            String sCtrlName ,
                                            String sValue ,
                                            String sFormatedValue ,
                                            String sTags ,
                                            String sEventName ,
                                            String sLinkURL ,
                                            String sLinkTarget ,
                                            String sTooltipText ,
                                            String sPlaceholder ,
                                            String sUserOnClickCode ,
                                            int nJScriptCode ,
                                            String sClassString ,
                                            String sStyleString ,
                                            String sROClassString ,
                                            String sColumnClassString ,
                                            String sColumnHeaderClassString ,
                                            int nVisible ,
                                            int nEnabled ,
                                            int nRTEnabled ,
                                            String sType ,
                                            String sStep ,
                                            int nWidth ,
                                            String nWidthUnit ,
                                            int nHeight ,
                                            String nHeightUnit ,
                                            int nLength ,
                                            byte nIsPassword ,
                                            short nFormat ,
                                            int nParentId ,
                                            byte bHasTheme ,
                                            byte nAutoComplete ,
                                            byte nAutoCorrection ,
                                            boolean bSendHidden ,
                                            String sDomainType ,
                                            String sCallerPgm )
   {
      gx_single_line_edit( httpContext, sCtrlName, sValue, sFormatedValue, sTags, sEventName, sLinkURL, sLinkTarget, sTooltipText, sPlaceholder, sUserOnClickCode, nJScriptCode, sClassString, sStyleString, sROClassString, sColumnClassString, sColumnHeaderClassString, nVisible, nEnabled, nRTEnabled, sType, sStep, nWidth, nWidthUnit, nHeight, nHeightUnit, nLength, nIsPassword, nFormat, nParentId, bHasTheme, nAutoComplete, nAutoCorrection, bSendHidden, sDomainType, "", false, "", sCallerPgm) ;
   }

   public static void gx_single_line_edit( HttpContext httpContext ,
                                           String sCtrlName ,
                                           String sValue ,
                                           String sFormatedValue ,
                                           String sTags ,
                                           String sEventName ,
                                           String sLinkURL ,
                                           String sLinkTarget ,
                                           String sTooltipText ,
                                           String sPlaceholder ,
                                           String sUserOnClickCode ,
                                           int nJScriptCode ,
                                           String sClassString ,
                                           String sStyleString ,
                                           String sROClassString ,
                                           String sColumnClassString ,
                                           String sColumnHeaderClassString ,
                                           int nVisible ,
                                           int nEnabled ,
                                           int nRTEnabled ,
                                           String sType ,
                                           String sStep ,
                                           int nWidth ,
                                           String nWidthUnit ,
                                           int nHeight ,
                                           String nHeightUnit ,
                                           int nLength ,
                                           byte nIsPassword ,
                                           short nFormat ,
                                           int nParentId ,
                                           byte bHasTheme ,
                                           byte nAutoComplete ,
                                           byte nAutoCorrection ,
                                           boolean bSendHidden ,
                                           String sDomainType ,
                                           String sAlign ,
                                           boolean bIsTextEdit ,
                                           String rtPicture ,
                                           String sCallerPgm )
   {
      String sOStyle;
      String sEventJsCode;
      String ClassHTML;
      String sSize;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sCtrlName, "Invitemessage", sPlaceholder);
         httpContext.ajax_rsp_assign_prefixed_prop(sCtrlName, "Tooltiptext", sTooltipText);
      }
      sEventJsCode = "" ;
      sSize = "" ;
      if ( httpContext.getWrapped( ) || ( bIsTextEdit && ( ( nRTEnabled != 0 ) || ( nEnabled != 0 ) ) ) )
      {
         sFormatedValue = sValue ;
      }
      if ( nWidth > 0 )
      {
         if ( GXutil.strcmp(nWidthUnit, "chr") == 0 )
         {
            if ( ( GXutil.strcmp(sType, "number") != 0 ) && ( GXutil.strcmp(sType, "range") != 0 ) )
            {
               sSize = " size=\"" + nWidth + "\"" ;
            }
         }
         else
         {
            sStyleString += ";width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + nWidthUnit + ";" ;
         }
      }
      if ( ( nHeight > 0 ) && ( GXutil.strcmp(nHeightUnit, "row") != 0 ) )
      {
         sStyleString += ";height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + nHeightUnit + ";" ;
      }
      sOStyle = sStyleString ;
      sStyleString += ((nVisible==0)||((nEnabled==0)) ? ";display:none;" : "") ;
      if ( nVisible == 0 )
      {
         sClassString += " gx-invisible" ;
      }
      if ( ( httpContext.getWrapped( ) && ( ( nRTEnabled != 0 ) || ( nEnabled != 0 ) ) ) || ! httpContext.getWrapped( ) )
      {
         /* Control allows input */
         httpContext.writeText( "<input type=") ;
         if ( nIsPassword != 0 )
         {
            httpContext.writeText( "\"password\"") ;
         }
         else
         {
            httpContext.writeText( "\"") ;
            httpContext.writeValue( sType) ;
            httpContext.writeText( "\"") ;
         }
         httpContext.writeText( " id=\"") ;
         httpContext.writeValue( GXutil.trim( sCtrlName)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " name=\"") ;
         httpContext.writeValue( GXutil.trim( sCtrlName)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " value=\"") ;
         if ( ( nIsPassword == 0 ) && ( ! (GXutil.strcmp("", sStep)==0) && ( ( GXutil.strcmp(sType, "number") == 0 ) || ( GXutil.strcmp(sType, "range") == 0 ) ) ) )
         {
            httpContext.writeValue( GXutil.trim( sFormatedValue)) ;
            httpContext.writeText( "\"") ;
            httpContext.writeText( " min=\"-") ;
            httpContext.writeValue( GXutil.trim( GXutil.str( java.lang.Math.pow(10,nLength)-1, 10, 0))) ;
            httpContext.writeText( "\"") ;
            httpContext.writeText( " max=\"") ;
            httpContext.writeValue( GXutil.trim( GXutil.str( java.lang.Math.pow(10,nLength)-1, 10, 0))) ;
            httpContext.writeText( "\"") ;
            httpContext.writeText( " step=\"") ;
            httpContext.writeValue( sStep) ;
            if ( GXutil.strcmp(sType, "search") == 0 )
            {
               sTags += " onsearch=\"this.onchange();\"" ;
            }
         }
         else
         {
            httpContext.writeValue( sFormatedValue) ;
         }
         httpContext.writeText( "\"") ;
         httpContext.writeText( sSize) ;
         if ( ! (GXutil.strcmp("", sTooltipText)==0) )
         {
            httpContext.writeText( " title=\"") ;
            httpContext.writeValue( GXutil.trim( sTooltipText)) ;
            httpContext.writeText( "\"") ;
         }
         if ( ! (GXutil.strcmp("", sPlaceholder)==0) )
         {
            httpContext.writeText( " placeholder=\"") ;
            httpContext.writeValue( GXutil.trim( sPlaceholder)) ;
            httpContext.writeText( "\"") ;
         }
         if ( GXutil.len( rtPicture) > 0 )
         {
            httpContext.writeText( " data-gx-rt-picture=\""+rtPicture+"\" ") ;
         }
         httpContext.writeText( " spellcheck=") ;
         if ( nAutoCorrection == 0 )
         {
            httpContext.writeText( "\"false\"") ;
         }
         else
         {
            httpContext.writeText( "\"true\"") ;
         }
         if ( ( GXutil.strcmp(sType, "date") != 0 ) && ( GXutil.strcmp(sType, "datetime") != 0 ) && ( GXutil.strcmp(sType, "datetime-local") != 0 ) && ( GXutil.strcmp(sType, "number") != 0 ) )
         {
            httpContext.writeText( " maxlength=\"") ;
            httpContext.writeText( GXutil.formatLong( nLength)) ;
            httpContext.writeText( "\"") ;
         }
         com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
         if ( ! (GXutil.strcmp("", sAlign)==0) )
         {
            com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString+"text-align:"+sAlign);
         }
         else
         {
            com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
         }
         httpContext.writeText( sTags) ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      }
      if ( nEnabled == 0 )
      {
         /* Control is read only */
         if ( bHasTheme == 0 )
         {
            ClassHTML = sClassString ;
         }
         else
         {
            if ( nParentId == 0 )
            {
               if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
               {
                  ClassHTML = "Readonly" + sClassString ;
               }
               else
               {
                  ClassHTML = sClassString ;
               }
            }
            else
            {
               if ( ( GXutil.len( sROClassString) != 0 ) && ( GXutil.strSearch( sROClassString, "Readonly", 1) != 1 ) )
               {
                  ClassHTML = "Readonly" + sROClassString ;
               }
               else
               {
                  ClassHTML = sROClassString ;
               }
            }
         }
         if ( nFormat != 2 )
         {
            sOStyle += ((nVisible==0) ? ";display:none;" : "") ;
            httpContext.writeText( "<span") ;
            com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
            com.identityprovider.GxWebStd.styleAttribute( httpContext, sOStyle);
            httpContext.writeText( ((GXutil.len( sTooltipText)>0) ? " title=\""+sTooltipText+"\"" : "")+" id=\"span_"+sCtrlName+"\""+" data-name=\"span_"+sCtrlName+"\""+" data-gx-enabled-id=\""+sCtrlName+"\"") ;
            httpContext.writeText( ">") ;
            /* Initialize internal JScript code according to EventNo */
            if ( nJScriptCode == 1 )
            {
               sEventJsCode = "gx.fn.closeWindow();" ;
            }
            else if ( nJScriptCode == 3 )
            {
               sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" ;
            }
            else if ( nJScriptCode == 7 )
            {
               sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
            }
            else if ( nJScriptCode == 8 )
            {
               sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
            }
            else if ( nJScriptCode == 6 )
            {
               sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
            }
            else if ( nJScriptCode == 5 )
            {
               sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
            }
            else if ( nJScriptCode == 0 )
            {
               sEventJsCode = "" ;
            }
            else
            {
               sEventJsCode = "" ;
            }
            com.identityprovider.GxWebStd.gx_start_js_anchor( httpContext, nJScriptCode, sEventJsCode, sUserOnClickCode, sLinkURL, sLinkTarget, "");
         }
         if ( nIsPassword == 0 )
         {
            if ( nFormat == 0 )
            {
               /* Text */
               httpContext.writeValue( GXutil.trim( sFormatedValue)) ;
            }
            else
            {
               if ( nFormat == 3 )
               {
                  /* Text with meaningful spaces */
                  httpContext.writeValueSpace( sFormatedValue) ;
               }
               else
               {
                  httpContext.writeText( sFormatedValue) ;
               }
            }
         }
         else
         {
            httpContext.writeValue( GXutil.padr( "", nLength, "*")) ;
         }
         if ( nFormat != 2 )
         {
            com.identityprovider.GxWebStd.gx_end_js_anchor( httpContext, sEventJsCode, sUserOnClickCode, sLinkURL);
            httpContext.writeText( "</span>") ;
         }
      }
   }

   public static void gx_link_start( HttpContext httpContext ,
                                     String sLinkURL ,
                                     String sTargetWnd ,
                                     String sClassString )
   {
      if ( GXutil.strcmp("", GXutil.rtrim( sLinkURL)) != 0 )
      {
         httpContext.writeText( "<a href=\"") ;
         httpContext.writeText( GXutil.rtrim( sLinkURL)) ;
         httpContext.writeText( "\"") ;
         if ( GXutil.strcmp("", GXutil.rtrim( sTargetWnd)) != 0 )
         {
            httpContext.writeText( " target=\"") ;
            httpContext.writeText( GXutil.rtrim( sTargetWnd)) ;
            httpContext.writeText( "\"") ;
         }
         if ( ! (GXutil.strcmp("", sClassString)==0) )
         {
            httpContext.writeText( " class=\"") ;
            httpContext.writeText( sClassString) ;
            httpContext.writeText( "\"") ;
         }
         httpContext.writeText( ">") ;
      }
   }

   public static void gx_link_end( HttpContext httpContext ,
                                   String sLinkURL )
   {
      if ( GXutil.strcmp("", GXutil.rtrim( sLinkURL)) != 0 )
      {
         httpContext.writeText( "</a>") ;
      }
   }

   public static void gx_blob_field( HttpContext httpContext ,
                                     String sInternalName ,
                                     String sValue ,
                                     String sURL ,
                                     String sContenttype ,
                                     boolean bHasFiletypeatt ,
                                     String sLinktarget ,
                                     String sObjecttagparameters ,
                                     int nDisplay ,
                                     int nEnabled ,
                                     int nVisible ,
                                     String sAlternateText ,
                                     String sTooltipText ,
                                     int nBorderWidth ,
                                     int nAutoresize ,
                                     int nWidth ,
                                     String nWidthUnit ,
                                     int nHeight ,
                                     String nHeightUnit ,
                                     int nVerticalSpace ,
                                     int nHorizontalSpace ,
                                     int nJScriptCode ,
                                     String sUserOnClickCode ,
                                     String sEventName ,
                                     String sStyleString ,
                                     String sClassString ,
                                     String sColumnClassString ,
                                     String sColumnHeaderClassString ,
                                     String sInputTags ,
                                     String sDisplayTags ,
                                     String sJsDynCode ,
                                     String sCallerPgm )
   {
      String sEventJsCode;
      String ClassHTML;
      sEventJsCode = "" ;
      sStyleString += ((nVisible!=0) ? "" : ";display:none;") ;
      if ( nEnabled != 0 )
      {
         /* Initialize internal JScript code according to EventNo */
         if ( nJScriptCode == 4 )
         {
            sEventJsCode = sJsDynCode ;
         }
         else if ( nJScriptCode == 1 )
         {
            sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
         }
         else if ( nJScriptCode == 3 )
         {
            sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
         }
         else if ( nJScriptCode == 7 )
         {
            sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 8 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
         }
         else if ( nJScriptCode == 6 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 5 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 0 )
         {
            sEventJsCode = "" ;
         }
         else
         {
            sEventJsCode = "" ;
         }
      }
      httpContext.writeText( "<div class=\"gx-tbldsp-container\" style=\"") ;
      if ( ! (0==nWidth) && ( ( nAutoresize == 0 ) ) )
      {
         httpContext.writeText( " width:") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0)) ;
         httpContext.writeText( nWidthUnit+";") ;
      }
      if ( ! (0==nHeight) && ( ( nAutoresize == 0 ) ) )
      {
         httpContext.writeText( " height:") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0)) ;
         httpContext.writeText( nHeightUnit+";") ;
      }
      httpContext.writeText( "margin:") ;
      httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nVerticalSpace), 10, 0)) ;
      httpContext.writeText( "px ") ;
      httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nHorizontalSpace), 10, 0)) ;
      httpContext.writeText( "px;\"") ;
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( "><div>") ;
      if ( nDisplay == 0 )
      {
         if ( httpContext.checkContentType( "image", sContenttype, sURL) )
         {
            httpContext.writeText( "<img") ;
            httpContext.writeText( " alt=\"") ;
            httpContext.writeValue( ((GXutil.strcmp("", sAlternateText)==0) ? sTooltipText : sAlternateText)) ;
            httpContext.writeText( "\"") ;
            httpContext.writeText( " src=\"") ;
            if ( (GXutil.strcmp("", sURL)==0) )
            {
               sURL = httpContext.convertURL( httpContext.getImagePath( "blank.jpg", "", httpContext.getTheme( ))) ;
            }
         }
         else
         {
            httpContext.writeText( "<object ") ;
            httpContext.writeText( "type=\"") ;
            httpContext.writeText( com.genexus.internet.HttpResponse.getContentType(sContenttype)) ;
            httpContext.writeText( "\" data=\"") ;
            if ( (GXutil.strcmp("", sURL)==0) )
            {
               sURL = "about:blank" ;
            }
         }
         httpContext.writeText( httpContext.convertURL( sURL)) ;
         httpContext.writeText( "\" id=\"Object_") ;
         httpContext.writeText( sInternalName) ;
         httpContext.writeText( "\" style=\"display:block;") ;
         if ( ! (0==nWidth) && ( ( nAutoresize == 0 ) ) )
         {
            httpContext.writeText( " width:") ;
            httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0)) ;
            httpContext.writeText( nWidthUnit+";") ;
         }
         if ( ! (0==nHeight) && ( ( nAutoresize == 0 ) ) )
         {
            httpContext.writeText( " height:") ;
            httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0)) ;
            httpContext.writeText( nHeightUnit+";") ;
         }
         httpContext.writeValue( GXutil.CssPrettify( sStyleString)) ;
         if ( GXutil.len( sClassString) != 0 )
         {
            ClassHTML = "BlobContent" + sClassString ;
         }
         else
         {
            ClassHTML = sClassString ;
         }
         if ( ( nEnabled == 0 ) && ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            ClassHTML = "Readonly" + ClassHTML ;
         }
         httpContext.writeText( "\" ") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
         httpContext.writeText( sDisplayTags) ;
         if ( httpContext.checkContentType( "image", sContenttype, sURL) )
         {
            httpContext.writeText( httpContext.htmlEndTag( HTMLElement.IMG)) ;
         }
         else
         {
            httpContext.writeText( ">") ;
            httpContext.writeText( sObjecttagparameters) ;
            httpContext.writeText( "</object>") ;
         }
      }
      else
      {
         if ( nDisplay == 1 )
         {
            httpContext.writeText( "<a id=\"Link_") ;
            httpContext.writeText( sInternalName) ;
            httpContext.writeText( "\"") ;
            if ( GXutil.strcmp(sURL, "") != 0 )
            {
               com.identityprovider.GxWebStd.styleAttribute( httpContext, "display:block;"+sStyleString);
            }
            else
            {
               com.identityprovider.GxWebStd.styleAttribute( httpContext, "display:none;"+sStyleString);
            }
            httpContext.writeText( "href=\"") ;
            httpContext.writeText( httpContext.convertURL( sURL)) ;
            httpContext.writeText( "\" type=\"") ;
            httpContext.writeText( sContenttype) ;
            httpContext.writeText( "\"") ;
            if ( GXutil.len( sLinktarget) > 0 )
            {
               httpContext.writeText( " target=\"") ;
               httpContext.writeText( GXutil.rtrim( sLinktarget)) ;
               httpContext.writeText( "\"") ;
            }
            httpContext.writeText( "><img border=\"0\" src=\"") ;
            httpContext.writeText( httpContext.convertURL( httpContext.getImagePath( "download.gif", "", httpContext.getTheme( )))) ;
            httpContext.writeText( "\" alt=\"Download\""+httpContext.htmlEndTag( HTMLElement.IMG)) ;
            httpContext.writeText( "</a>") ;
         }
      }
      httpContext.writeText( "</div><div>") ;
      if ( nEnabled == 1 )
      {
         httpContext.writeText( "<script type=\"text/javascript\">document.forms[0].encoding=\"multipart/form-data\";</script>") ;
         httpContext.writeText( "<input type=\"file\" ") ;
         httpContext.writeText( " id=\"") ;
         httpContext.writeText( sInternalName) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " name=\"") ;
         httpContext.writeText( sInternalName) ;
         httpContext.writeText( "\"") ;
         sStyleString = "" ;
         if ( nVisible == 0 )
         {
            sStyleString = "display:none;" ;
         }
         if ( ! (0==nWidth) )
         {
            sStyleString += " width:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + nWidthUnit + ";" ;
         }
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
         httpContext.writeText( " value=\"") ;
         httpContext.writeValue( sValue) ;
         httpContext.writeText( "\" ") ;
         if ( GXutil.len( sClassString) != 0 )
         {
            ClassHTML = "BlobInput" + sClassString ;
         }
         else
         {
            ClassHTML = sClassString ;
         }
         if ( ( nEnabled == 0 ) && ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            ClassHTML = "Readonly" + ClassHTML ;
         }
         com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
         if ( httpContext.checkContentType( "image", sContenttype, sURL) )
         {
            httpContext.writeText( " accept=\"") ;
            httpContext.writeText( sContenttype) ;
            httpContext.writeText( "\" ") ;
         }
         httpContext.writeText( sInputTags) ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      }
      httpContext.writeText( "</div></div>") ;
   }

   public static void gx_button_ctrl( HttpContext httpContext ,
                                      String sCtrlName ,
                                      String sJsCode ,
                                      String sCaption ,
                                      String sUserOnClickCode ,
                                      int nJScriptCode ,
                                      String sTooltipText ,
                                      String sAccesskey ,
                                      String sStyleString ,
                                      String sClassString ,
                                      int nVisible ,
                                      int nEnabled ,
                                      String sBorderStyle ,
                                      String sEventName ,
                                      String sTags ,
                                      String sJsDynCode ,
                                      int nReset ,
                                      String sCallerPgm )
   {
      String sEventJsCode;
      String sCapAKey;
      String sClassRoundedBtn;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sCtrlName, "Tooltiptext", sTooltipText);
      }
      sStyleString += ((nVisible!=0) ? "" : ";display:none;") ;
      sClassRoundedBtn = "BaseRBtn " + "R" + sClassString ;
      if ( GXutil.strcmp(sBorderStyle, "rounded") == 0 )
      {
         sClassString = "BtnText" ;
         httpContext.writeText( "<span onclick=\"gx.evt.doClick(") ;
         httpContext.writeText( "'") ;
         httpContext.writeValue( GXutil.trim( sCtrlName)) ;
         httpContext.writeText( "', event") ;
         httpContext.writeText( ")\" ") ;
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
         com.identityprovider.GxWebStd.classAttribute( httpContext, sClassRoundedBtn);
         httpContext.writeText( "><span class=\"BtnLeft\"><span class=\"BtnRight\"><span class=\"BtnBackground\">") ;
      }
      httpContext.writeText( "<input type=") ;
      if ( nReset == 1 )
      {
         httpContext.writeText( "\"submit\"") ;
      }
      else if ( nReset == 0 )
      {
         httpContext.writeText( "\"reset\"") ;
      }
      else
      {
         httpContext.writeText( "\"button\"") ;
      }
      sCapAKey = GXutil.accessKey( sCaption) ;
      sCaption = GXutil.accessKeyCaption( sCaption) ;
      if ( (GXutil.strcmp("", sCapAKey)==0) )
      {
         sCapAKey = GXutil.accessKey( sTooltipText) ;
         sTooltipText = GXutil.accessKeyCaption( sTooltipText) ;
      }
      if ( ! (GXutil.strcmp("", sCapAKey)==0) )
      {
         sAccesskey = sCapAKey ;
      }
      httpContext.writeText( " data-gx-button") ;
      httpContext.writeText( " name=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sCaption)==0) )
      {
         httpContext.writeText( " value=\"") ;
         httpContext.writeValue( GXutil.trim( sCaption)) ;
         httpContext.writeText( "\"") ;
      }
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      if ( GXutil.len( sAccesskey) != 0 )
      {
         httpContext.writeText( " accesskey=\"") ;
         httpContext.writeValue( GXutil.trim( sAccesskey)) ;
         httpContext.writeText( "\"") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      if ( nEnabled == 0 )
      {
         httpContext.writeText( " disabled=\"disabled\"") ;
      }
      /* Initialize internal JScript code according to EventNo */
      if ( nJScriptCode == 4 )
      {
         sEventJsCode = sJsDynCode ;
      }
      else if ( nJScriptCode == 1 )
      {
         sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
      }
      else if ( nJScriptCode == 3 )
      {
         sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
      }
      else if ( nJScriptCode == 7 )
      {
         sEventJsCode = "gx.evt.checkCtrlFocus(this);" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 8 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
      }
      else if ( nJScriptCode == 6 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 5 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 0 )
      {
         sEventJsCode = "" ;
      }
      else
      {
         sEventJsCode = "" ;
      }
      sEventJsCode = sJsCode + sEventJsCode ;
      com.identityprovider.GxWebStd.gx_on_js_event( httpContext, nJScriptCode, sEventJsCode, sUserOnClickCode);
      httpContext.writeText( " ") ;
      httpContext.writeText( sTags) ;
      httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      if ( GXutil.strcmp(sBorderStyle, "rounded") == 0 )
      {
         httpContext.writeText( "</span></span></span></span>") ;
      }
   }

   public static void gx_on_js_event( HttpContext httpContext ,
                                      int nJScriptCode ,
                                      String sGXOnClickCode ,
                                      String sUserOnClickCode )
   {
      if ( ! (GXutil.strcmp("", sUserOnClickCode)==0) )
      {
         if ( ! (0==nJScriptCode) )
         {
            httpContext.writeText( " data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
         }
         else
         {
            httpContext.writeText( " data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
         }
         if ( ( nJScriptCode == 4 ) || ( nJScriptCode == 3 ) )
         {
            httpContext.writeText( " data-gx-evt-code=\"") ;
            httpContext.writeText( sGXOnClickCode) ;
            httpContext.writeText( "\"") ;
         }
         httpContext.writeText( " data-gx-evt-condition=\"") ;
         httpContext.writeText( sUserOnClickCode) ;
         httpContext.writeText( "\"") ;
      }
      else
      {
         if ( ! (0==nJScriptCode) )
         {
            httpContext.writeText( " data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
            if ( ( nJScriptCode == 4 ) || ( nJScriptCode == 3 ) )
            {
               httpContext.writeText( " data-gx-evt-code=\"") ;
               httpContext.writeText( sGXOnClickCode) ;
               httpContext.writeText( "\"") ;
            }
         }
      }
   }

   public static void gx_ctrl_attribute( HttpContext httpContext ,
                                         String sControlName ,
                                         String sAttName ,
                                         String sAttValue ,
                                         boolean bCustomEvent ,
                                         boolean bMaskedEvent )
   {
      if ( bCustomEvent )
      {
         httpContext.writeText( " ") ;
         httpContext.writeValue( sAttName) ;
         httpContext.writeText( "=\"") ;
         httpContext.writeText( "if(") ;
         if ( ! (GXutil.strcmp("", sAttValue)==0) )
         {
            httpContext.writeText( "gx.evt.jsEvent(this)") ;
            httpContext.writeText( ") {") ;
            httpContext.writeText( sAttValue) ;
            httpContext.writeText( "} else return false;\"") ;
         }
         else
         {
            httpContext.writeText( "!(") ;
            httpContext.writeText( "gx.evt.jsEvent(this)") ;
            httpContext.writeText( ")) return false;\"") ;
         }
      }
      else
      {
         if ( ! (GXutil.strcmp("", sAttValue)==0) )
         {
            if ( bMaskedEvent )
            {
               httpContext.writeText( " data-msk-att=\"") ;
               httpContext.writeValue( sAttName) ;
               httpContext.writeText( "\" data-") ;
            }
            else
            {
               httpContext.writeText( " ") ;
            }
            httpContext.writeValue( sAttName) ;
            httpContext.writeText( "=\"") ;
            httpContext.writeText( sAttValue) ;
            httpContext.writeText( "\" ") ;
         }
      }
   }

   public static void gx_msg_list( HttpContext httpContext ,
                                   String sCtrlName ,
                                   int nDisplayMode ,
                                   String sStyleString ,
                                   String sClassString ,
                                   String sCmpCtx ,
                                   String sInMaster )
   {
      int i;
      httpContext.writeText( "<div>") ;
      sClassString += " gx_ev" ;
      if ( nDisplayMode == 1 )
      {
         sClassString += " ErrorViewerBullet" ;
      }
      httpContext.writeText( "<span") ;
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      httpContext.writeText( " data-gx-id=\""+sCmpCtx+"gxErrorViewer\"") ;
      httpContext.writeText( ">") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         i = 1 ;
         while ( i <= httpContext.GX_msglist.getItemCount() )
         {
            httpContext.writeText( "<span") ;
            com.identityprovider.GxWebStd.classAttribute( httpContext, ((httpContext.GX_msglist.getItemType((short)(i))==1) ? "gx-error-message" : "gx-warning-message"));
            httpContext.writeText( ">") ;
            httpContext.writeText( WebUtils.htmlEncode( httpContext.GX_msglist.getItemText((short)(i)))) ;
            httpContext.writeText( "</span>") ;
            i = (int)(i+1) ;
         }
      }
      httpContext.writeText( "</span>") ;
      httpContext.writeText( "</div>") ;
   }

   public static void gx_combobox_ctrl( HttpContext httpContext ,
                                        com.genexus.webpanels.HTMLChoice CObjCtrl ,
                                        String sCtrlName ,
                                        String sValue ,
                                        int nRows ,
                                        String sUserOnClickCode ,
                                        int nJScriptCode ,
                                        String sEventName ,
                                        String sType ,
                                        String sTooltipText ,
                                        int nVisible ,
                                        int nEnabled ,
                                        int nRTEnabled ,
                                        short nFormat ,
                                        int nWidth ,
                                        String nWidthUnit ,
                                        int nHeight ,
                                        String nHeightUnit ,
                                        String sStyleString ,
                                        String sClassString ,
                                        String sColumnClassString ,
                                        String sColumnHeaderClassString ,
                                        String sTags ,
                                        String sFormatedValue ,
                                        String sCallerPgm )
   {
      gx_combobox_ctrl1( httpContext, CObjCtrl, sCtrlName, sValue, nRows, sUserOnClickCode, nJScriptCode, sEventName, sType, sTooltipText, nVisible, nEnabled, nRTEnabled, nFormat, nWidth, nWidthUnit, nHeight, nHeightUnit, sStyleString, sClassString, sColumnClassString, sColumnHeaderClassString, sTags, sFormatedValue, true, sCallerPgm) ;
   }

   public static void gx_combobox_ctrl1( HttpContext httpContext ,
                                         com.genexus.webpanels.HTMLChoice CObjCtrl ,
                                         String sCtrlName ,
                                         String sValue ,
                                         int nRows ,
                                         String sUserOnClickCode ,
                                         int nJScriptCode ,
                                         String sEventName ,
                                         String sType ,
                                         String sTooltipText ,
                                         int nVisible ,
                                         int nEnabled ,
                                         int nRTEnabled ,
                                         short nFormat ,
                                         int nWidth ,
                                         String nWidthUnit ,
                                         int nHeight ,
                                         String nHeightUnit ,
                                         String sStyleString ,
                                         String sClassString ,
                                         String sColumnClassString ,
                                         String sColumnHeaderClassString ,
                                         String sTags ,
                                         String sFormatedValue ,
                                         boolean bSendHidden ,
                                         String sCallerPgm )
   {
      String sOStyle;
      String sEventJsCode;
      int idxLst;
      String ClassHTML;
      idxLst = 1 ;
      if ( nWidth > 0 )
      {
         sStyleString += ";width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + nWidthUnit ;
      }
      if ( nHeight > 0 )
      {
         sStyleString += ";height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + nHeightUnit ;
      }
      sOStyle = sStyleString + " ;overflow:hidden;" ;
      sStyleString += ((nVisible==0)||(nEnabled==0) ? ";display:none;" : "") ;
      /* Initialize internal JScript code according to EventNo */
      if ( nJScriptCode == 1 )
      {
         sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
      }
      else if ( nJScriptCode == 3 )
      {
         sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
      }
      else if ( nJScriptCode == 7 )
      {
         sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 8 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
      }
      else if ( nJScriptCode == 6 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 5 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 0 )
      {
         sEventJsCode = "" ;
      }
      else
      {
         sEventJsCode = "" ;
      }
      httpContext.writeText( "<select") ;
      if ( nRows > 1 )
      {
         httpContext.writeText( " size=") ;
         httpContext.writeText( GXutil.ltrim( GXutil.formatLong( nRows))) ;
      }
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\" name=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nEnabled == 0 )
      {
         httpContext.writeText( " data-gx-disable=\""+sCtrlName+"\" ") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-jsevent", sUserOnClickCode, false, false);
      com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-gxoch0", sEventJsCode, true, false);
      httpContext.writeText( sTags) ;
      httpContext.writeTextNL( ">") ;
      while ( idxLst <= CObjCtrl.getItemCount() )
      {
         if ( GXutil.strcmp(sType, "int") == 0 )
         {
            httpContext.writeText( "<option value=\"") ;
            httpContext.writeValue( GXutil.alltrim( CObjCtrl.getItemValue((short)(idxLst)))) ;
         }
         else
         {
            httpContext.writeText( "<option value=\"") ;
            httpContext.writeValue( CObjCtrl.getItemValue((short)(idxLst))) ;
         }
         if ( GXutil.strcmp(GXutil.ltrim( CObjCtrl.getItemValue((short)(idxLst))), GXutil.ltrim( sValue)) == 0 )
         {
            httpContext.writeText( "\" selected=\"selected\" >") ;
         }
         else
         {
            httpContext.writeText( "\">") ;
         }
         if ( nFormat == 0 )
         {
            httpContext.writeValue( CObjCtrl.getItemText((short)(idxLst))) ;
         }
         else
         {
            if ( nFormat == 3 )
            {
               httpContext.writeValueSpace( CObjCtrl.getItemText((short)(idxLst))) ;
            }
            else
            {
               httpContext.writeText( CObjCtrl.getItemText((short)(idxLst))) ;
            }
         }
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.OPTION)) ;
         idxLst = (int)(idxLst+1) ;
      }
      httpContext.writeTextNL( "</select>") ;
      if ( nEnabled == 0 )
      {
         if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            ClassHTML = "Readonly" + sClassString ;
         }
         else
         {
            ClassHTML = sClassString ;
         }
         sOStyle += ((nVisible==0) ? ";display:none;" : "") ;
         idxLst = 1 ;
         httpContext.writeText( "<span") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sOStyle);
         httpContext.writeText( ((GXutil.len( sTooltipText)>0) ? " title=\""+sTooltipText+"\"" : "")+" id=\"span_"+sCtrlName+"\"") ;
         httpContext.writeText( ">") ;
         while ( idxLst <= CObjCtrl.getItemCount() )
         {
            if ( GXutil.strcmp(GXutil.ltrim( CObjCtrl.getItemValue((short)(idxLst))), GXutil.ltrim( sValue)) == 0 )
            {
               if ( nFormat == 0 )
               {
                  httpContext.writeValue( CObjCtrl.getItemText((short)(idxLst))) ;
               }
               else
               {
                  if ( nFormat == 3 )
                  {
                     httpContext.writeValueSpace( CObjCtrl.getItemText((short)(idxLst))) ;
                  }
                  else
                  {
                     httpContext.writeText( CObjCtrl.getItemText((short)(idxLst))) ;
                  }
               }
               if (true) break;
            }
            idxLst = (int)(idxLst+1) ;
         }
         httpContext.writeText( "</span>") ;
      }
   }

   public static void gx_listbox_ctrl( HttpContext httpContext ,
                                       com.genexus.webpanels.HTMLChoice LObjCtrl ,
                                       String sCtrlName ,
                                       String sValue ,
                                       int nRows ,
                                       String sUserOnClickCode ,
                                       int nJScriptCode ,
                                       String sEventName ,
                                       String sType ,
                                       String sTooltipText ,
                                       int nVisible ,
                                       int nEnabled ,
                                       int nRTEnabled ,
                                       short nFormat ,
                                       int nWidth ,
                                       String nWidthUnit ,
                                       int nHeight ,
                                       String nHeightUnit ,
                                       String sStyleString ,
                                       String sClassString ,
                                       String sColumnClassString ,
                                       String sColumnHeaderClassString ,
                                       String sTags ,
                                       String sFormatedValue ,
                                       String sCallerPgm )
   {
      gx_listbox_ctrl1( httpContext, LObjCtrl, sCtrlName, sValue, nRows, sUserOnClickCode, nJScriptCode, sEventName, sType, sTooltipText, nVisible, nEnabled, nRTEnabled, nFormat, nWidth, nWidthUnit, nHeight, nHeightUnit, sStyleString, sClassString, sColumnClassString, sColumnHeaderClassString, sTags, sFormatedValue, true, sCallerPgm) ;
   }

   public static void gx_listbox_ctrl1( HttpContext httpContext ,
                                        com.genexus.webpanels.HTMLChoice LObjCtrl ,
                                        String sCtrlName ,
                                        String sValue ,
                                        int nRows ,
                                        String sUserOnClickCode ,
                                        int nJScriptCode ,
                                        String sEventName ,
                                        String sType ,
                                        String sTooltipText ,
                                        int nVisible ,
                                        int nEnabled ,
                                        int nRTEnabled ,
                                        short nFormat ,
                                        int nWidth ,
                                        String nWidthUnit ,
                                        int nHeight ,
                                        String nHeightUnit ,
                                        String sStyleString ,
                                        String sClassString ,
                                        String sColumnClassString ,
                                        String sColumnHeaderClassString ,
                                        String sTags ,
                                        String sFormatedValue ,
                                        boolean bSendHidden ,
                                        String sCallerPgm )
   {
      String sOStyle;
      String sEventJsCode;
      int idxLst;
      String ClassHTML;
      idxLst = 1 ;
      if ( nWidth > 0 )
      {
         sStyleString += ";width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + nWidthUnit ;
      }
      if ( nHeight > 0 )
      {
         sStyleString += ";height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + nHeightUnit ;
      }
      sOStyle = sStyleString + " ;overflow:hidden;" ;
      sStyleString += ((nVisible==0)||(nEnabled==0) ? ";display:none;" : "") ;
      /* Initialize internal JScript code according to EventNo */
      if ( nJScriptCode == 1 )
      {
         sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
      }
      else if ( nJScriptCode == 3 )
      {
         sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
      }
      else if ( nJScriptCode == 7 )
      {
         sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 8 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
      }
      else if ( nJScriptCode == 6 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 5 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 0 )
      {
         sEventJsCode = "" ;
      }
      else
      {
         sEventJsCode = "" ;
      }
      httpContext.writeText( "<select") ;
      if ( nRows > 1 )
      {
         httpContext.writeText( " size=") ;
         httpContext.writeText( GXutil.ltrim( GXutil.formatLong( nRows))) ;
      }
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\" name=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nEnabled == 0 )
      {
         httpContext.writeText( " data-gx-disable=\""+sCtrlName+"\" ") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-jsevent", sUserOnClickCode, false, false);
      com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-gxoch0", sEventJsCode, true, false);
      httpContext.writeText( sTags) ;
      httpContext.writeTextNL( ">") ;
      while ( idxLst <= LObjCtrl.getItemCount() )
      {
         if ( GXutil.strcmp(sType, "int") == 0 )
         {
            httpContext.writeText( "<option value=\"") ;
            httpContext.writeValue( GXutil.alltrim( LObjCtrl.getItemValue((short)(idxLst)))) ;
         }
         else
         {
            httpContext.writeText( "<option value=\"") ;
            httpContext.writeValue( LObjCtrl.getItemValue((short)(idxLst))) ;
         }
         if ( GXutil.strcmp(GXutil.ltrim( LObjCtrl.getItemValue((short)(idxLst))), GXutil.ltrim( sValue)) == 0 )
         {
            httpContext.writeText( "\" selected=\"selected\" >") ;
         }
         else
         {
            httpContext.writeText( "\">") ;
         }
         if ( nFormat == 0 )
         {
            httpContext.writeValue( LObjCtrl.getItemText((short)(idxLst))) ;
         }
         else
         {
            if ( nFormat == 3 )
            {
               httpContext.writeValueSpace( LObjCtrl.getItemText((short)(idxLst))) ;
            }
            else
            {
               httpContext.writeText( LObjCtrl.getItemText((short)(idxLst))) ;
            }
         }
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.OPTION)) ;
         idxLst = (int)(idxLst+1) ;
      }
      httpContext.writeTextNL( "</select>") ;
      if ( nEnabled == 0 )
      {
         if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            ClassHTML = "Readonly" + sClassString ;
         }
         else
         {
            ClassHTML = sClassString ;
         }
         sOStyle += ((nVisible==0) ? ";display:none;" : "") ;
         idxLst = 1 ;
         httpContext.writeText( "<span") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sOStyle);
         httpContext.writeText( ((GXutil.len( sTooltipText)>0) ? " title=\""+sTooltipText+"\"" : "")+" id=\"span_"+sCtrlName+"\"") ;
         httpContext.writeText( ">") ;
         while ( idxLst <= LObjCtrl.getItemCount() )
         {
            if ( GXutil.strcmp(GXutil.ltrim( LObjCtrl.getItemValue((short)(idxLst))), GXutil.ltrim( sValue)) == 0 )
            {
               if ( nFormat == 0 )
               {
                  httpContext.writeValue( LObjCtrl.getItemText((short)(idxLst))) ;
               }
               else
               {
                  if ( nFormat == 3 )
                  {
                     httpContext.writeValueSpace( LObjCtrl.getItemText((short)(idxLst))) ;
                  }
                  else
                  {
                     httpContext.writeText( LObjCtrl.getItemText((short)(idxLst))) ;
                  }
               }
               if (true) break;
            }
            idxLst = (int)(idxLst+1) ;
         }
         httpContext.writeText( "</span>") ;
      }
   }

   public static void gx_radio_ctrl( HttpContext httpContext ,
                                     com.genexus.webpanels.HTMLChoice RObjCtrl ,
                                     String sCtrlName ,
                                     String sValue ,
                                     String sTooltipText ,
                                     int nVisible ,
                                     int nEnabled ,
                                     int nRadioColumns ,
                                     int nOrientation ,
                                     String sStyleString ,
                                     String sClassString ,
                                     String sColumnClassString ,
                                     String sColumnHeaderClassString ,
                                     int nJScriptCode ,
                                     String sUserOnClickCode ,
                                     String sEventName ,
                                     String sTags ,
                                     String sCallerPgm )
   {
      String sEventJsCode;
      int idxLst;
      int idxCol;
      String ClassHTML;
      String sCtrlId;
      if ( ( nEnabled == 0 ) && ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
      {
         ClassHTML = "Readonly" + sClassString ;
      }
      else
      {
         ClassHTML = sClassString ;
      }
      ClassHTML += " gx-radio-button" ;
      if ( nOrientation == 1 )
      {
         ClassHTML += " gx-radio-button-vertical" ;
      }
      /* Initialize internal JScript code according to EventNo */
      if ( nJScriptCode == 1 )
      {
         sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
      }
      else if ( nJScriptCode == 3 )
      {
         sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
      }
      else if ( nJScriptCode == 7 )
      {
         sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 8 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
      }
      else if ( nJScriptCode == 6 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 5 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 0 )
      {
         sEventJsCode = "" ;
      }
      else
      {
         sEventJsCode = "" ;
      }
      idxLst = 1 ;
      idxCol = 0 ;
      sStyleString += ((nVisible!=0) ? "" : ";display:none;") ;
      httpContext.writeText( "<span") ;
      com.identityprovider.GxWebStd.classAttribute( httpContext, ClassHTML);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      httpContext.writeText( ">") ;
      while ( idxLst <= RObjCtrl.getItemCount() )
      {
         sCtrlId = sCtrlName + idxLst ;
         httpContext.writeText( "<label for=\"") ;
         httpContext.writeValue( sCtrlId) ;
         httpContext.writeText( "\">") ;
         httpContext.skipLines( 1 );
         httpContext.writeText( "<input type=\"radio\"") ;
         httpContext.writeText( " name=\"") ;
         httpContext.writeValue( sCtrlName) ;
         httpContext.writeText( "\" id=\"") ;
         httpContext.writeValue( sCtrlId) ;
         httpContext.writeText( "\" value=\"") ;
         httpContext.writeText( RObjCtrl.getItemValue((short)(idxLst))) ;
         httpContext.writeText( "\"") ;
         if ( nEnabled == 0 )
         {
            httpContext.writeText( " data-gx-disable=\""+sCtrlName+"\" ") ;
         }
         if ( ! (GXutil.strcmp("", sTooltipText)==0) )
         {
            httpContext.writeText( " title=\"") ;
            httpContext.writeValue( sTooltipText) ;
            httpContext.writeText( "\"") ;
         }
         if ( GXutil.strcmp(GXutil.ltrim( sValue), RObjCtrl.getItemValue((short)(idxLst))) == 0 )
         {
            httpContext.writeText( " checked=\"checked\"") ;
         }
         httpContext.writeText( sTags) ;
         com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-gxoch0", sEventJsCode, true, false);
         com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "data-jsevent", sUserOnClickCode, false, false);
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
         httpContext.writeValue( RObjCtrl.getItemText((short)(idxLst))) ;
         httpContext.writeText( "</label>") ;
         idxLst = (int)(idxLst+1) ;
      }
      httpContext.writeText( "</span>") ;
   }

   public static void gx_checkbox_ctrl( HttpContext httpContext ,
                                        String sCtrlName ,
                                        String sValue ,
                                        String sTooltipText ,
                                        String sLabelCaption ,
                                        int nVisible ,
                                        int nEnabled ,
                                        String sCheked ,
                                        String sCaption ,
                                        String sStyleString ,
                                        String sClassString ,
                                        String sColumnClassString ,
                                        String sColumnHeaderClassString ,
                                        String sTags )
   {
      String ClassHTML;
      ClassHTML = sClassString ;
      sValue = GXutil.ltrim( sValue) ;
      sCheked = GXutil.ltrim( sCheked) ;
      if ( nEnabled == 0 )
      {
         if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            ClassHTML = "Readonly" + sClassString ;
         }
      }
      sStyleString += ((nVisible!=0) ? "" : ";display:none;") ;
      httpContext.writeText( "<span class=\""+ClassHTML+"\" style=\""+GXutil.CssPrettify( sStyleString)+"\">") ;
      httpContext.writeText( "<input type=\"checkbox\" "+((GXutil.strcmp(sValue, sCheked)==0) ? "checked=\"checked\"" : "")) ;
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\" name=\"") ;
      httpContext.writeValue( GXutil.trim( sCtrlName)) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " value=\""+((GXutil.strcmp(sValue, sCheked)==0) ? sCheked : "")+"\"") ;
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nEnabled == 0 )
      {
         httpContext.writeText( " data-gx-disable=\""+sCtrlName+"\" ") ;
      }
      httpContext.writeText( sTags+httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      httpContext.writeText( "<label data-gx-checkbox-title for=\"") ;
      httpContext.writeValue( sCtrlName) ;
      httpContext.writeText( "\"") ;
      if ( (GXutil.strcmp("", sCaption)==0) )
      {
         httpContext.writeText( " data-gx-sr-only>"+sLabelCaption+"_") ;
      }
      else
      {
         httpContext.writeText( ">"+sCaption) ;
      }
      httpContext.writeText( "</label></span>") ;
   }

   public static void gx_bitmap( HttpContext httpContext ,
                                 String sInternalName ,
                                 String sImageURL ,
                                 String sLinkURL ,
                                 String sLinkTarget ,
                                 String sAccesskey ,
                                 String sThemeName ,
                                 int nVisible ,
                                 int nEnabled ,
                                 String sAlternateText ,
                                 String sTooltipText ,
                                 int nBorderWidth ,
                                 int nAutoresize ,
                                 int nWidth ,
                                 String nWidthUnit ,
                                 int nHeight ,
                                 String nHeightUnit ,
                                 int nVerticalSpace ,
                                 int nHorizontalSpace ,
                                 int nJScriptCode ,
                                 String sUserOnClickCode ,
                                 String sEventName ,
                                 String sStyleString ,
                                 String sClassString ,
                                 String sColumnClassString ,
                                 String sColumnHeaderClassString ,
                                 String sAlign ,
                                 String sInputTags ,
                                 String sImageTags ,
                                 String sUseMap ,
                                 String sJsDynCode ,
                                 int nReadOnly ,
                                 boolean bIsBlob ,
                                 boolean bIsAttribute ,
                                 String sImgSrcSet ,
                                 String sCallerPgm )
   {
      String ClassHTML;
      ClassHTML = sClassString ;
      if ( bIsAttribute && ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
      {
         ClassHTML = "Readonly" + sClassString ;
      }
      if ( ( nReadOnly == 1 ) || ( nEnabled == 0 ) )
      {
         com.identityprovider.GxWebStd.gx_bitmap_readonly( httpContext, sInternalName, sImageURL, sLinkURL, sLinkTarget, sAccesskey, sThemeName, nVisible, nEnabled, sAlternateText, sTooltipText, nBorderWidth, nAutoresize, nWidth, nWidthUnit, nHeight, nHeightUnit, nVerticalSpace, nHorizontalSpace, nJScriptCode, sUserOnClickCode, sEventName, sStyleString, ClassHTML, sColumnClassString, sColumnHeaderClassString, sAlign, sImageTags, sUseMap, sJsDynCode, sCallerPgm, sImgSrcSet);
      }
      else
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_start( httpContext, sInternalName, nVisible, nWidth, sStyleString);
         httpContext.writeText( "<a class=\"action change-action\" gxfocusable=\"1\" href=\"\"") ;
         httpContext.writeText( sInputTags) ;
         httpContext.writeText( ">") ;
         httpContext.writeText( httpContext.getMessage( "GXM_multimediachange", "")) ;
         httpContext.writeText( "</a>") ;
         httpContext.writeText( "<a gxfocusable=\"1\" href=\"\" class=\"action clear-action\"></a>") ;
         httpContext.writeText( "<a target=\"_blank\">") ;
         httpContext.writeText( "<img id=\"Object_") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " class=\"") ;
         httpContext.writeValue( GXutil.trim( ClassHTML)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " alt=\"") ;
         httpContext.writeValue( GXutil.trim( ((GXutil.strcmp("", sAlternateText)==0) ? sTooltipText : sAlternateText))) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " src=\"") ;
         if ( ! (GXutil.strcmp("", sImageURL)==0) )
         {
            httpContext.writeText( httpContext.convertURL( sImageURL)) ;
         }
         httpContext.writeText( "\"") ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.IMG)) ;
         httpContext.writeText( "<span class=\"") ;
         httpContext.writeText( "gx-image-placeholder") ;
         httpContext.writeText( "\">") ;
         httpContext.writeText( "</span>") ;
         httpContext.writeText( "</a>") ;
         com.identityprovider.GxWebStd.gx_multimedia_upload_end( httpContext, sInternalName, sImageURL, sTooltipText, nWidth, nWidthUnit, nHeight, nHeightUnit, sUserOnClickCode, sEventName, sStyleString, sClassString, "", "", sAlign, sInputTags, nReadOnly, bIsBlob, "image/*", sCallerPgm);
      }
   }

   public static void gx_bitmap_readonly( HttpContext httpContext ,
                                          String sInternalName ,
                                          String sImageURL ,
                                          String sLinkURL ,
                                          String sLinkTarget ,
                                          String sAccesskey ,
                                          String sThemeName ,
                                          int nVisible ,
                                          int nEnabled ,
                                          String sAlternateText ,
                                          String sTooltipText ,
                                          int nBorderWidth ,
                                          int nAutoresize ,
                                          int nWidth ,
                                          String nWidthUnit ,
                                          int nHeight ,
                                          String nHeightUnit ,
                                          int nVerticalSpace ,
                                          int nHorizontalSpace ,
                                          int nJScriptCode ,
                                          String sUserOnClickCode ,
                                          String sEventName ,
                                          String sStyleString ,
                                          String sClassString ,
                                          String sColumnClassString ,
                                          String sColumnHeaderClassString ,
                                          String sAlign ,
                                          String sTags ,
                                          String sUseMap ,
                                          String sJsDynCode ,
                                          String sCallerPgm ,
                                          String sImgSrcSet )
   {
      String sEventJsCode;
      String sCapAKey;
      sEventJsCode = "" ;
      sCapAKey = GXutil.accessKey( sTooltipText) ;
      sTooltipText = GXutil.accessKeyCaption( sTooltipText) ;
      if ( ! (GXutil.strcmp("", sCapAKey)==0) )
      {
         sAccesskey = sCapAKey ;
      }
      sStyleString += ((nVisible!=0) ? "" : ";display:none;") ;
      /* Initialize internal JScript code according to EventNo */
      if ( nJScriptCode == 4 )
      {
         sEventJsCode = sJsDynCode ;
      }
      else if ( nJScriptCode == 1 )
      {
         sEventJsCode = "gx.fn.closeWindow();" + "return false;" ;
      }
      else if ( nJScriptCode == 3 )
      {
         sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" + "return false;" ;
      }
      else if ( nJScriptCode == 7 )
      {
         sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 8 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" + "return false;" ;
      }
      else if ( nJScriptCode == 6 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 5 )
      {
         sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
      }
      else if ( nJScriptCode == 0 )
      {
         sEventJsCode = "" ;
      }
      else
      {
         sEventJsCode = "" ;
      }
      if ( ( nEnabled != 0 ) && ( GXutil.strcmp(sLinkURL, "") != 0 ) )
      {
         com.identityprovider.GxWebStd.gx_start_js_anchor( httpContext, nJScriptCode, sEventJsCode, sUserOnClickCode, sLinkURL, sLinkTarget, "gx-image-link");
      }
      if ( ! (GXutil.strcmp("", sImageURL)==0) )
      {
         httpContext.writeText( "<img src=\""+httpContext.convertURL( sImageURL)+"\"") ;
      }
      else
      {
         httpContext.writeText( "<img ") ;
      }
      if ( nEnabled == 0 )
      {
         sClassString += " gx-disabled" ;
      }
      if ( ! (0==nJScriptCode) )
      {
         httpContext.writeText( " data-gx-evt=\"") ;
         httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
         httpContext.writeText( "\"") ;
      }
      if ( ( nJScriptCode == 4 ) || ( nJScriptCode == 3 ) )
      {
         httpContext.writeText( " data-gx-evt-code=\"") ;
         httpContext.writeText( sEventJsCode) ;
         httpContext.writeText( "\"") ;
      }
      if ( ! (GXutil.strcmp("", sUserOnClickCode)==0) )
      {
         httpContext.writeText( " data-gx-evt-condition=\"") ;
         httpContext.writeText( sUserOnClickCode) ;
         httpContext.writeText( "\"") ;
      }
      if ( ! (GXutil.strcmp("", sImgSrcSet)==0) )
      {
         httpContext.writeText( " srcset=\"") ;
         httpContext.writeText( sImgSrcSet) ;
         httpContext.writeText( "\"") ;
      }
      if ( GXutil.len( sAccesskey) != 0 )
      {
         httpContext.writeText( " accesskey=\"") ;
         httpContext.writeValue( GXutil.trim( sAccesskey)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "\"") ;
      if ( ! (0==nVerticalSpace) )
      {
         httpContext.writeText( " vspace=\"") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nVerticalSpace), 10, 0)) ;
         httpContext.writeText( "\"") ;
      }
      if ( ! (0==nHorizontalSpace) )
      {
         httpContext.writeText( " hspace=\"") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nHorizontalSpace), 10, 0)) ;
         httpContext.writeText( "\"") ;
      }
      if ( ! (GXutil.strcmp("", sAlign)==0) )
      {
         httpContext.writeText( " align=\"") ;
         httpContext.writeText( GXutil.ltrim( sAlign)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nBorderWidth > 0 )
      {
         sStyleString += ";border-width: " + GXutil.str( nBorderWidth, 3, 0) ;
      }
      httpContext.writeText( " alt=\"") ;
      httpContext.writeValue( ((GXutil.strcmp("", sAlternateText)==0) ? sTooltipText : sAlternateText)) ;
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sTooltipText)==0) )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltipText)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nWidth > 0 )
      {
         sStyleString += ";width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + nWidthUnit ;
      }
      if ( nHeight > 0 )
      {
         sStyleString += ";height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + nHeightUnit ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      httpContext.writeText( sTags) ;
      if ( ! (GXutil.strcmp("", sUseMap)==0) )
      {
         httpContext.writeText( " usemap=\"") ;
         httpContext.writeValue( GXutil.trim( sUseMap)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      if ( ( nEnabled != 0 ) && ( GXutil.strcmp(sLinkURL, "") != 0 ) && ( GXutil.strcmp(sEventJsCode, "") == 0 ) )
      {
         com.identityprovider.GxWebStd.gx_end_js_anchor( httpContext, sEventJsCode, sUserOnClickCode, sLinkURL);
      }
   }

   public static void gx_multimedia_upload_start( HttpContext httpContext ,
                                                  String sInternalName ,
                                                  int nVisible ,
                                                  int nWidth ,
                                                  String sStyleStringParm )
   {
      httpContext.writeText( "<div class=\"gx-multimedia-upload\"") ;
      httpContext.writeText( " id =\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "_ct\"") ;
      String sStyleString = sStyleStringParm;
      if ( nVisible == 0 )
      {
         sStyleString = "display:none;" ;
      }
      if ( nWidth > 0 )
      {
         sStyleString += " width:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + ";" ;
      }
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      httpContext.writeText( ">") ;
   }

   public static void gx_multimedia_upload_end( HttpContext httpContext ,
                                                String sInternalName ,
                                                String sMultimediaURL ,
                                                String sTooltipText ,
                                                int nWidth ,
                                                String nWidthUnit ,
                                                int nHeight ,
                                                String nHeightUnit ,
                                                String sUserOnClickCode ,
                                                String sEventName ,
                                                String sStyleString ,
                                                String sClassString ,
                                                String sColumnClassString ,
                                                String sColumnHeaderClassString ,
                                                String sAlign ,
                                                String sInputTags ,
                                                int nReadOnly ,
                                                boolean bIsBlob ,
                                                String sAccept ,
                                                String sCallerPgm )
   {
      String sURL;
      httpContext.writeText( "<div id=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "_ct_fields\" class=\"fields-ct \">") ;
      httpContext.writeText( "<label class=\"option\">") ;
      httpContext.writeText( "<input type=\"radio\" value=\"file\" name=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "Option\"") ;
      if ( bIsBlob )
      {
         httpContext.writeText( " checked") ;
      }
      httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      httpContext.writeText( httpContext.getMessage( "GXM_uploadfileoption", "")) ;
      httpContext.writeText( "</label>") ;
      httpContext.writeText( "<label class=\"option\">") ;
      httpContext.writeText( "<input type=\"radio\" value=\"uri\" name=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "Option\"") ;
      if ( ! bIsBlob )
      {
         httpContext.writeText( " checked") ;
      }
      httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      httpContext.writeText( httpContext.getMessage( "GXM_uploadurioption", "")) ;
      httpContext.writeText( "</label>") ;
      sURL = "" ;
      if ( ! bIsBlob )
      {
         sURL = sMultimediaURL ;
      }
      com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, sInternalName+"_GXI", sURL, sURL, sInputTags, sEventName, "", "", sTooltipText, "", sUserOnClickCode, 0, "field "+sClassString, sStyleString, "", "", "", 1, 1, 1, "text", "", nWidth, nWidthUnit, nHeight, nHeightUnit, 254, (byte)(0), (short)(2), 0, (byte)(1), (byte)(1), (byte)(0), true, "", sAlign, false, "", sCallerPgm);
      httpContext.writeText( "<input type=\"file\" class=\"field ") ;
      httpContext.writeValue( sClassString) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " id=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " name=\"") ;
      httpContext.writeValue( sInternalName) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " accept=\"") ;
      httpContext.writeText( sAccept) ;
      httpContext.writeText( "\" ") ;
      httpContext.writeText( sInputTags) ;
      httpContext.writeText( httpContext.htmlEndTag( HTMLElement.INPUT)) ;
      httpContext.writeText( "</div>") ;
      httpContext.writeText( "</div>") ;
   }

   public static void gx_video( HttpContext httpContext ,
                                String sInternalName ,
                                String sMultimediaURL ,
                                String sText ,
                                int nDisplay ,
                                int nVisible ,
                                int nEnabled ,
                                int nAutoresize ,
                                int nWidth ,
                                String nWidthUnit ,
                                int nHeight ,
                                String nHeightUnit ,
                                int nJScriptCode ,
                                String sUserOnClickCode ,
                                String sEventName ,
                                String sStyleString ,
                                String sClassString ,
                                String sColumnClassString ,
                                String sColumnHeaderClassString ,
                                String sInputTags ,
                                String sMultimediaTags ,
                                String sJsDynCode ,
                                int nReadOnly ,
                                boolean bIsBlob ,
                                String sCallerPgm )
   {
      String ClassHTML;
      ClassHTML = sClassString ;
      if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
      {
         ClassHTML = "Readonly" + sClassString ;
      }
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_start( httpContext, sInternalName, nVisible, nWidth, sStyleString);
         httpContext.writeText( "<a class=\"action change-action\" gxfocusable=\"1\" href=\"\"") ;
         httpContext.writeText( sInputTags) ;
         httpContext.writeText( ">") ;
         httpContext.writeText( httpContext.getMessage( "GXM_multimediachange", "")) ;
         httpContext.writeText( "</a>") ;
         httpContext.writeText( "<a gxfocusable=\"1\" href=\"\" class=\"action clear-action\"></a>") ;
      }
      httpContext.writeText( "<a class=\"gx-multimedia-ro\" target=\"_blank\"") ;
      if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( " href=\"") ;
         httpContext.writeValue( sMultimediaURL) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( ">") ;
      if ( httpContext.checkContentType( "image", "", sMultimediaURL) || (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( "<img id=\"Object_") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " class=\"") ;
         httpContext.writeValue( GXutil.trim( ClassHTML)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " src=\"") ;
         if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
         {
            httpContext.writeText( httpContext.convertURL( sMultimediaURL)) ;
         }
         httpContext.writeText( "\"") ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.IMG)) ;
      }
      httpContext.writeText( "<span") ;
      if ( ( nReadOnly == 1 ) || ( nEnabled == 0 ) )
      {
         httpContext.writeText( " id =\"") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " class=\"") ;
      httpContext.writeValue( ClassHTML) ;
      httpContext.writeText( " ") ;
      httpContext.writeText( "gx-video-placeholder") ;
      httpContext.writeText( "\" title=\"") ;
      httpContext.writeText( httpContext.getMessage( "GXM_multimediaalttext", "")) ;
      httpContext.writeText( "\">") ;
      httpContext.writeValue( sText) ;
      httpContext.writeText( "</span>") ;
      httpContext.writeText( "</a>") ;
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_end( httpContext, sInternalName, sMultimediaURL, "", nWidth, nWidthUnit, nHeight, nHeightUnit, sUserOnClickCode, sEventName, sStyleString, sClassString, "", "", "", sInputTags, nReadOnly, bIsBlob, "video/*", sCallerPgm);
      }
   }

   public static void gx_audio( HttpContext httpContext ,
                                String sInternalName ,
                                String sMultimediaURL ,
                                String sText ,
                                int nDisplay ,
                                int nVisible ,
                                int nEnabled ,
                                int nAutoresize ,
                                int nWidth ,
                                String nWidthUnit ,
                                int nHeight ,
                                String nHeightUnit ,
                                int nJScriptCode ,
                                String sUserOnClickCode ,
                                String sEventName ,
                                String sStyleString ,
                                String sClassString ,
                                String sColumnClassString ,
                                String sColumnHeaderClassString ,
                                String sInputTags ,
                                String sMultimediaTags ,
                                String sJsDynCode ,
                                int nReadOnly ,
                                boolean bIsBlob ,
                                String sCallerPgm )
   {
      String ClassHTML;
      ClassHTML = sClassString ;
      if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
      {
         ClassHTML = "Readonly" + sClassString ;
      }
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_start( httpContext, sInternalName, nVisible, nWidth, sStyleString);
         httpContext.writeText( "<a class=\"action change-action\" gxfocusable=\"1\" href=\"\"") ;
         httpContext.writeText( sInputTags) ;
         httpContext.writeText( ">") ;
         httpContext.writeText( httpContext.getMessage( "GXM_multimediachange", "")) ;
         httpContext.writeText( "</a>") ;
         httpContext.writeText( "<a gxfocusable=\"1\" href=\"\" class=\"action clear-action\"></a>") ;
      }
      httpContext.writeText( "<a class=\"gx-multimedia-ro\" target=\"_blank\"") ;
      if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( " href=\"") ;
         httpContext.writeValue( sMultimediaURL) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( ">") ;
      if ( httpContext.checkContentType( "image", "", sMultimediaURL) || (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( "<img id=\"Object_") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " class=\"") ;
         httpContext.writeValue( GXutil.trim( ClassHTML)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " src=\"") ;
         if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
         {
            httpContext.writeText( httpContext.convertURL( sMultimediaURL)) ;
         }
         httpContext.writeText( "\"") ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.IMG)) ;
      }
      httpContext.writeText( "<span") ;
      if ( ( nReadOnly == 1 ) || ( nEnabled == 0 ) )
      {
         httpContext.writeText( " id =\"") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " class=\"") ;
      httpContext.writeValue( ClassHTML) ;
      httpContext.writeText( " ") ;
      httpContext.writeText( "gx-audio-placeholder") ;
      httpContext.writeText( "\" title=\"") ;
      httpContext.writeText( httpContext.getMessage( "GXM_multimediaalttext", "")) ;
      httpContext.writeText( "\">") ;
      httpContext.writeValue( sText) ;
      httpContext.writeText( "</span>") ;
      httpContext.writeText( "</a>") ;
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_end( httpContext, sInternalName, sMultimediaURL, "", nWidth, nWidthUnit, nHeight, nHeightUnit, sUserOnClickCode, sEventName, sStyleString, sClassString, "", "", "", sInputTags, nReadOnly, bIsBlob, "audio/*", sCallerPgm);
      }
   }

   public static void gx_file( HttpContext httpContext ,
                               String sInternalName ,
                               String sMultimediaURL ,
                               String sText ,
                               int nDisplay ,
                               int nVisible ,
                               int nEnabled ,
                               int nAutoresize ,
                               int nWidth ,
                               String nWidthUnit ,
                               int nHeight ,
                               String nHeightUnit ,
                               int nJScriptCode ,
                               String sUserOnClickCode ,
                               String sEventName ,
                               String sStyleString ,
                               String sClassString ,
                               String sColumnClassString ,
                               String sColumnHeaderClassString ,
                               String sInputTags ,
                               String sMultimediaTags ,
                               String sJsDynCode ,
                               int nReadOnly ,
                               boolean bIsBlob ,
                               String sCallerPgm )
   {
      String ClassHTML;
      ClassHTML = sClassString ;
      if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
      {
         ClassHTML = "Readonly" + sClassString ;
      }
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_start( httpContext, sInternalName, nVisible, nWidth, sStyleString);
         httpContext.writeText( "<a class=\"action change-action\" gxfocusable=\"1\" href=\"\"") ;
         httpContext.writeText( sInputTags) ;
         httpContext.writeText( ">") ;
         httpContext.writeText( httpContext.getMessage( "GXM_multimediachange", "")) ;
         httpContext.writeText( "</a>") ;
         httpContext.writeText( "<a gxfocusable=\"1\" href=\"\" class=\"action clear-action\"></a>") ;
      }
      httpContext.writeText( "<a class=\"gx-multimedia-ro\" target=\"_blank\"") ;
      if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( " href=\"") ;
         httpContext.writeValue( sMultimediaURL) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( ">") ;
      if ( httpContext.checkContentType( "image", "", sMultimediaURL) || (GXutil.strcmp("", sMultimediaURL)==0) )
      {
         httpContext.writeText( "<img id=\"Object_") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " class=\"") ;
         httpContext.writeValue( GXutil.trim( ClassHTML)) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( " src=\"") ;
         if ( ! (GXutil.strcmp("", sMultimediaURL)==0) )
         {
            httpContext.writeText( httpContext.convertURL( sMultimediaURL)) ;
         }
         httpContext.writeText( "\"") ;
         httpContext.writeText( httpContext.htmlEndTag( HTMLElement.IMG)) ;
      }
      httpContext.writeText( "<span") ;
      if ( ( nReadOnly == 1 ) || ( nEnabled == 0 ) )
      {
         httpContext.writeText( " id =\"") ;
         httpContext.writeValue( sInternalName) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " class=\"") ;
      httpContext.writeValue( ClassHTML) ;
      httpContext.writeText( " ") ;
      httpContext.writeText( "gx-download-placeholder") ;
      httpContext.writeText( "\" title=\"") ;
      httpContext.writeText( httpContext.getMessage( "GXM_multimediaalttext", "")) ;
      httpContext.writeText( "\">") ;
      httpContext.writeValue( sText) ;
      httpContext.writeText( "</span>") ;
      httpContext.writeText( "</a>") ;
      if ( ( nReadOnly == 0 ) && ( nEnabled == 1 ) )
      {
         com.identityprovider.GxWebStd.gx_multimedia_upload_end( httpContext, sInternalName, sMultimediaURL, "", nWidth, nWidthUnit, nHeight, nHeightUnit, sUserOnClickCode, sEventName, sStyleString, sClassString, "", "", "", sInputTags, nReadOnly, bIsBlob, "*", sCallerPgm);
      }
   }

   public static void gx_label_ctrl( HttpContext httpContext ,
                                     String sInternalName ,
                                     String sCaption ,
                                     String sLinkURL ,
                                     String sLinkTarget ,
                                     String sUserOnClickCode ,
                                     String sEventName ,
                                     String sTags ,
                                     String sClassString ,
                                     int nJScriptCode ,
                                     String sTooltipText ,
                                     int nVisible ,
                                     int nEnabled ,
                                     int nRTEnabled ,
                                     short nFormat ,
                                     String sCallerPgm )
   {
      String sEventJsCode;
      String sDataLink;
      String sStyle;
      if ( ( nEnabled != 0 ) || ( nRTEnabled != 0 ) )
      {
         /* Initialize internal JScript code according to EventNo */
         if ( nJScriptCode == 1 )
         {
            sEventJsCode = "gx.fn.closeWindow();" ;
         }
         else if ( nJScriptCode == 3 )
         {
            sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" ;
         }
         else if ( nJScriptCode == 7 )
         {
            sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 8 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 6 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 5 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 0 )
         {
            sEventJsCode = "" ;
         }
         else
         {
            sEventJsCode = "" ;
         }
      }
      else
      {
         sEventJsCode = "" ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sInternalName, "Caption", sCaption);
         httpContext.ajax_rsp_assign_prefixed_prop(sInternalName, "Tooltiptext", sTooltipText);
      }
      sTooltipText = ((GXutil.strcmp(sTooltipText, "")==0) ? "" : " title=\""+WebUtils.htmlEncode( sTooltipText)+"\"") ;
      String gxDataAtt = " data-gxformat=\""+GXutil.str( nFormat, 1, 0)+"\" ";
      if ( ( nFormat == 1 ) && ( ! (GXutil.strcmp("", sEventJsCode)==0) || ! (GXutil.strcmp("", sUserOnClickCode)==0) || ! (GXutil.strcmp("", sLinkURL)==0) ) )
      {
         sDataLink = " data-gxlink=1 " ;
      }
      else
      {
         sDataLink = "" ;
      }
      if ( nEnabled == 0 )
      {
         sClassString += " gx-disabled" ;
      }
      if ( nFormat == 1 )
      {
         /* HTML Format */
         sStyle = ((nVisible!=0) ? ";display:inline;" : ";display:none;") + sTags ;
         httpContext.writeText( "<div") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyle);
         httpContext.writeText( " id=\""+sInternalName+"\" "+sTooltipText+gxDataAtt+sDataLink) ;
         httpContext.writeText( ">") ;
      }
      else if ( nFormat != 2 )
      {
         if ( ( nFormat == 0 ) || ( nFormat == 2 ) )
         {
            gxDataAtt = "" ;
         }
         sStyle = ((nVisible!=0) ? "" : ";display:none;") + sTags ;
         httpContext.writeText( "<span") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyle);
         httpContext.writeText( " id=\""+sInternalName+"\" "+sTooltipText+gxDataAtt+sDataLink) ;
         httpContext.writeText( ">") ;
      }
      if ( ( nEnabled != 0 ) || ( nRTEnabled != 0 ) )
      {
         com.identityprovider.GxWebStd.gx_start_js_anchor( httpContext, nJScriptCode, sEventJsCode, sUserOnClickCode, sLinkURL, sLinkTarget, "");
      }
      if ( nFormat == 0 )
      {
         /* Text Format */
         httpContext.writeValueEnter( sCaption) ;
      }
      else
      {
         if ( nFormat == 3 )
         {
            /* Text with meaningful spaces */
            httpContext.writeValueSpace( sCaption) ;
         }
         else if ( ( nFormat != 2 ) || ( nVisible != 0 ) )
         {
            httpContext.writeText( sCaption) ;
         }
      }
      if ( ( nEnabled != 0 ) || ( nRTEnabled != 0 ) )
      {
         com.identityprovider.GxWebStd.gx_end_js_anchor( httpContext, sEventJsCode, sUserOnClickCode, sLinkURL);
      }
      if ( nFormat == 1 )
      {
         httpContext.writeText( "</div>") ;
      }
      else if ( nFormat != 2 )
      {
         httpContext.writeText( "</span>") ;
      }
   }

   public static void gx_start_js_anchor( HttpContext httpContext ,
                                          int nJScriptCode ,
                                          String sGXOnClickCode ,
                                          String sUserOnClickCode ,
                                          String sLinkURL ,
                                          String sLinkTarget ,
                                          String sClassString )
   {
      if ( ! (GXutil.strcmp("", sUserOnClickCode)==0) )
      {
         if ( ! (0==nJScriptCode) )
         {
            httpContext.writeText( "<a href=\"#\" data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
         }
         else
         {
            httpContext.writeText( "<a href=\"#\" data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
         }
         if ( ( nJScriptCode == 4 ) || ( nJScriptCode == 3 ) )
         {
            httpContext.writeText( " data-gx-evt-code=\"") ;
            httpContext.writeText( sGXOnClickCode) ;
            httpContext.writeText( "\"") ;
         }
         if ( ! (GXutil.strcmp("", sClassString)==0) )
         {
            httpContext.writeText( " class=\"") ;
            httpContext.writeText( sClassString) ;
            httpContext.writeText( "\"") ;
         }
         httpContext.writeText( " data-gx-evt-condition=\"") ;
         httpContext.writeText( sUserOnClickCode) ;
         httpContext.writeText( "\"") ;
         httpContext.writeText( ">") ;
      }
      else
      {
         if ( ! (0==nJScriptCode) )
         {
            httpContext.writeText( "<a href=\"#\" data-gx-evt=\"") ;
            httpContext.writeText( GXutil.trim( GXutil.str( nJScriptCode, 10, 0))) ;
            httpContext.writeText( "\"") ;
            if ( ( nJScriptCode == 4 ) || ( nJScriptCode == 3 ) )
            {
               httpContext.writeText( " data-gx-evt-code=\"") ;
               httpContext.writeText( sGXOnClickCode) ;
               httpContext.writeText( "\"") ;
            }
            if ( ! (GXutil.strcmp("", sClassString)==0) )
            {
               httpContext.writeText( " class=\"") ;
               httpContext.writeText( sClassString) ;
               httpContext.writeText( "\"") ;
            }
            httpContext.writeText( ">") ;
         }
         else
         {
            com.identityprovider.GxWebStd.gx_link_start( httpContext, sLinkURL, sLinkTarget, sClassString);
         }
      }
   }

   public static void gx_end_js_anchor( HttpContext httpContext ,
                                        String sGXOnClickCode ,
                                        String sUserOnClickCode ,
                                        String sLinkURL )
   {
      if ( ! ( (GXutil.strcmp("", sGXOnClickCode)==0) && (GXutil.strcmp("", sUserOnClickCode)==0) ) )
      {
         httpContext.writeText( "</a>") ;
      }
      else
      {
         com.identityprovider.GxWebStd.gx_link_end( httpContext, sLinkURL);
      }
   }

   public static void gx_label_element( HttpContext httpContext ,
                                        String sReferencedControl ,
                                        String sLabelCaption ,
                                        String sLabelClass ,
                                        int nLabelPosition ,
                                        boolean bDataAttSupported ,
                                        String sExtraStyle )
   {
      if ( (GXutil.strcmp("", sReferencedControl)==0) )
      {
         httpContext.writeText( "<span ") ;
      }
      else
      {
         httpContext.writeText( "<label ") ;
      }
      httpContext.writeText( " class=\"gx-label ") ;
      httpContext.writeText( sLabelClass) ;
      httpContext.writeText( " control-label") ;
      if ( ( nLabelPosition == 0 ) && ! bDataAttSupported )
      {
         httpContext.writeText( " gx-sr-only ") ;
      }
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sReferencedControl)==0) )
      {
         httpContext.writeText( " for=\"") ;
         httpContext.writeText( sReferencedControl) ;
         httpContext.writeText( "\"") ;
      }
      if ( ( nLabelPosition == 0 ) && bDataAttSupported )
      {
         httpContext.writeTextNL( " data-gx-sr-only ") ;
      }
      if ( ! (GXutil.strcmp("", sExtraStyle)==0) )
      {
         com.identityprovider.GxWebStd.styleAttribute( httpContext, GXutil.CssPrettify( sExtraStyle));
      }
      httpContext.writeText( ">") ;
      httpContext.writeText( sLabelCaption) ;
      if ( (GXutil.strcmp("", sReferencedControl)==0) )
      {
         httpContext.writeText( "</span>") ;
      }
      else
      {
         httpContext.writeText( "</label>") ;
      }
   }

   public static boolean gx_redirect( HttpContext httpContext )
   {
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.dispatchAjaxCommands();
         return true ;
      }
      else if ( httpContext.nUserReturn == 1 )
      {
         if ( httpContext.isAjaxRequest( ) )
         {
            httpContext.ajax_rsp_command_close();
            httpContext.dispatchAjaxCommands();
         }
         else
         {
            if ( (GXutil.strcmp("", httpContext.getReferer( ))==0) || httpContext.isLocalStorageSupported( ) )
            {
               httpContext.setStream();
               if ( httpContext.isSpaRequest( true) )
               {
                  httpContext.setHeader("X-SPA-RETURN", httpContext.getWebReturnParmsJS( ));
                  httpContext.setHeader("X-SPA-RETURN-MD", httpContext.getWebReturnParmsMetadataJS( ));
               }
               else
               {
                  httpContext.writeText( httpContext.htmlDocType( )) ;
                  httpContext.writeText( "<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"><title>Close window</title>") ;
                  httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
                  httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2155100), false, true);
                  httpContext.writeText( "</head><body><script type=\"text/javascript\">") ;
                  httpContext.writeText( "gx.fn.closeWindowServerScript(") ;
                  httpContext.writeText( httpContext.getWebReturnParmsJS( )) ;
                  httpContext.writeText( ", ") ;
                  httpContext.writeText( httpContext.getWebReturnParmsMetadataJS( )) ;
                  if ( httpContext.isLocalStorageSupported( ) )
                  {
                     httpContext.writeText( ", true") ;
                  }
                  else
                  {
                     httpContext.writeText( ", false") ;
                  }
                  httpContext.writeText( ");</script></body></html>") ;
               }
            }
            else
            {
               httpContext.redirect( httpContext.getReferer( ) );
               httpContext.windowClosed();
            }
         }
         return true ;
      }
      else
      {
         return false ;
      }
   }

   public static void gx_table_start( HttpContext httpContext ,
                                      String sCtrlName ,
                                      String sHTMLid ,
                                      String sHTMLTags ,
                                      String sClassString ,
                                      int nBorder ,
                                      String sAlign ,
                                      String sTooltiptext ,
                                      int nCellpadding ,
                                      int nCellspacing ,
                                      String sStyleString ,
                                      String sRules ,
                                      String sCaption ,
                                      int nParentIsFreeStyle )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sCtrlName, "Tooltiptext", sTooltiptext);
      }
      httpContext.writeText( "<table") ;
      if ( ! (GXutil.strcmp("", sCtrlName)==0) )
      {
         httpContext.writeText( " id=\""+sHTMLid+"\"") ;
      }
      if ( ! (GXutil.strcmp("", sHTMLTags)==0) )
      {
         httpContext.writeText( sHTMLTags) ;
      }
      if ( GXutil.strcmp(sAlign, "") != 0 )
      {
         if ( GXutil.strcmp(sAlign, "left") == 0 )
         {
            sStyleString = "margin-right:auto;" + sStyleString ;
         }
         else
         {
            if ( GXutil.strcmp(sAlign, "center") == 0 )
            {
               sStyleString = "margin-left:auto; margin-right: auto;" + sStyleString ;
            }
            else
            {
               if ( GXutil.strcmp(sAlign, "right") == 0 )
               {
                  sStyleString = "margin-left:auto;" + sStyleString ;
               }
            }
         }
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      if ( ! (0==nBorder) )
      {
         httpContext.writeText( " border=\"") ;
         httpContext.writeText( GXutil.str( nBorder, 3, 0)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " data-cellpadding=\"") ;
      httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nCellpadding), 10, 0)) ;
      httpContext.writeText( "\"") ;
      httpContext.writeText( " data-cellspacing=\"") ;
      httpContext.writeText( GXutil.ltrim( GXutil.ltrimstr( DecimalUtil.doubleToDec(nCellspacing), 5, 0))) ;
      httpContext.writeText( "\"") ;
      if ( ( GXutil.strcmp(sRules, "") != 0 ) && ( GXutil.strcmp(sRules, "none") != 0 ) )
      {
         httpContext.writeText( " rules=\"") ;
         httpContext.writeText( sRules) ;
         httpContext.writeText( "\"") ;
      }
      if ( GXutil.strcmp(sTooltiptext, "") != 0 )
      {
         httpContext.writeText( " title=\"") ;
         httpContext.writeValue( GXutil.trim( sTooltiptext)) ;
         httpContext.writeText( "\"") ;
      }
      if ( nParentIsFreeStyle == 0 )
      {
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
      }
      httpContext.writeText( ">") ;
      if ( GXutil.strcmp(sCaption, "") != 0 )
      {
         httpContext.writeText( "<caption>"+sCaption+"</caption>") ;
      }
   }

   public static void gx_html_headers( HttpContext httpContext ,
                                       int nContentType ,
                                       String sCacheCtrl ,
                                       String sCacheExp ,
                                       com.genexus.webpanels.HTMLChoice rMeta ,
                                       com.genexus.webpanels.HTMLChoice rMetaequiv ,
                                       boolean bIsRwd )
   {
      byte wbTemp;
      byte idxLst;
      boolean addContentType;
      com.identityprovider.GxWebStd.set_html_headers( httpContext, nContentType, sCacheCtrl, sCacheExp);
      httpContext.setStream();
      if ( nContentType == 0 )
      {
         httpContext.writeTextNL( httpContext.htmlDocType( )) ;
         httpContext.writeTextNL( "<html lang=\"en\""+">") ;
         httpContext.writeTextNL( "<head>") ;
         if ( bIsRwd )
         {
            GXWebForm.addResponsiveMetaHeaders(rMeta);
         }
         idxLst = (byte)(1) ;
         while ( idxLst <= rMeta.getItemCount() )
         {
            httpContext.writeText( "<meta name=\""+GXutil.rtrim( rMeta.getItemValue(idxLst))+"\" content=\"") ;
            httpContext.writeValue( GXutil.rtrim( rMeta.getItemText(idxLst))) ;
            httpContext.writeTextNL( "\""+httpContext.htmlEndTag( HTMLElement.META)) ;
            idxLst = (byte)(idxLst+1) ;
         }
         httpContext.writeTextNL( "<!--[if IE]><meta http-equiv=\"page-enter\" content=\"blendTrans(Duration=0.1)\""+httpContext.htmlEndTag( HTMLElement.META)+"<![endif]-->") ;
         httpContext.writeTextNL( "<meta name=\"fragment\" content=\"!\""+httpContext.htmlEndTag( HTMLElement.META)) ;
         idxLst = (byte)(1) ;
         addContentType = true ;
         while ( idxLst <= rMetaequiv.getItemCount() )
         {
            if ( GXutil.strcmp(GXutil.lower( rMetaequiv.getItemValue(idxLst)), "content-type") == 0 )
            {
               addContentType = false ;
               wbTemp = httpContext.setContentType( rMetaequiv.getItemText(idxLst)) ;
            }
            idxLst = (byte)(idxLst+1) ;
         }
         if ( addContentType )
         {
            httpContext.writeTextNL( "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\""+httpContext.htmlEndTag( HTMLElement.META)) ;
         }
         idxLst = (byte)(1) ;
         while ( idxLst <= rMetaequiv.getItemCount() )
         {
            httpContext.writeText( "<meta http-equiv=\""+GXutil.rtrim( rMetaequiv.getItemValue(idxLst))+"\" content=\"") ;
            httpContext.writeValue( GXutil.rtrim( rMetaequiv.getItemText(idxLst))) ;
            httpContext.writeTextNL( "\""+httpContext.htmlEndTag( HTMLElement.META)) ;
            idxLst = (byte)(idxLst+1) ;
         }
      }
   }

   public static void set_html_headers( HttpContext httpContext ,
                                        int nContentType ,
                                        String sCacheCtrl ,
                                        String sCacheExp )
   {
      byte wbTemp;
      if ( nContentType != 1 )
      {
         if ( httpContext.isAjaxRequest( ) && ! httpContext.isMultipartContent( ) )
         {
            wbTemp = httpContext.setContentType( "application/json") ;
         }
         else
         {
            wbTemp = httpContext.setContentType( "text/html") ;
         }
      }
      if ( (GXutil.strcmp("", sCacheCtrl)==0) )
      {
         wbTemp = httpContext.setHeader( "pragma", "no-cache") ;
         wbTemp = httpContext.setHeader( "Cache-Control", "no-store") ;
      }
      else
      {
         wbTemp = httpContext.setHeader( "Cache-Control", sCacheCtrl) ;
         wbTemp = httpContext.setHeader( "Cache-Control", sCacheExp) ;
      }
   }

   public static void gx_html_textarea( HttpContext httpContext ,
                                        String sCtrlName ,
                                        String sValue ,
                                        String sLinkURL ,
                                        String sTags ,
                                        short nFormat ,
                                        int nVisible ,
                                        int nEnabled ,
                                        int nRTEnabled ,
                                        int nWidth ,
                                        String sWidthUnit ,
                                        int nHeight ,
                                        String sHeightUnit ,
                                        String sStyleString ,
                                        String sClassString ,
                                        String sColumnClassString ,
                                        String sColumnHeaderClassString ,
                                        String sLength ,
                                        int nAutoResize ,
                                        int nMaxNumberLines ,
                                        String sLinkTarget ,
                                        String sPlaceholder ,
                                        byte nAutoCorrection ,
                                        boolean bSendHidden ,
                                        String sDomainType ,
                                        String sEventName ,
                                        int nJScriptCode ,
                                        String sCallerPgm )
   {
      String sEventJsCode;
      String sTextAreaStyleString;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sCtrlName, "Invitemessage", sPlaceholder);
      }
      sEventJsCode = "" ;
      sTextAreaStyleString = sStyleString + ((nVisible==0)||((nEnabled==0)) ? ";display:none;" : "") ;
      httpContext.writeText( "<textarea ") ;
      if ( ! (GXutil.strcmp("", sPlaceholder)==0) )
      {
         httpContext.writeText( " placeholder=\"") ;
         httpContext.writeValue( GXutil.trim( sPlaceholder)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( " spellcheck=") ;
      if ( nAutoCorrection == 0 )
      {
         httpContext.writeText( "\"false\"") ;
      }
      else
      {
         httpContext.writeText( "\"true\"") ;
      }
      if ( GXutil.strcmp(sWidthUnit, "chr") == 0 )
      {
         httpContext.writeText( " cols=\""+nWidth+"\" ") ;
      }
      else
      {
         sTextAreaStyleString += ";width:" + nWidth + sWidthUnit ;
      }
      if ( GXutil.strcmp(sHeightUnit, "row") == 0 )
      {
         httpContext.writeText( " rows=\""+nHeight+"\" ") ;
      }
      else
      {
         sTextAreaStyleString += ";height:" + nHeight + sHeightUnit ;
      }
      httpContext.writeText( " name=\""+sCtrlName+"\""+" id=\""+sCtrlName+"\" "+sTags) ;
      if ( ( nMaxNumberLines > 1 ) && ( nEnabled != 0 ) )
      {
         httpContext.writeText( " data-gx-text-maxlines=\""+nMaxNumberLines+"\" ") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sTextAreaStyleString);
      httpContext.writeText( " onKeyDown=\"return gx.evt.checkMaxLength(this,"+sLength+",event);\" ") ;
      httpContext.writeText( " onKeyUp=\"return gx.evt.checkMaxLength(this,"+sLength+",event);\" ") ;
      com.identityprovider.GxWebStd.gx_ctrl_attribute( httpContext, sCtrlName, "maxlength", sLength, false, true);
      httpContext.writeTextNL( ">") ;
      httpContext.writeValue( sValue) ;
      httpContext.writeTextNL( "</textarea>") ;
      if ( nEnabled == 0 )
      {
         sStyleString += ((nAutoResize==0) ? ";overflow:hidden;" : "") + ((nVisible==0) ? ";display:none;" : "") ;
         if ( ( GXutil.len( sClassString) != 0 ) && ( GXutil.strSearch( sClassString, "Readonly", 1) != 1 ) )
         {
            sClassString = "Readonly" + sClassString ;
         }
         httpContext.writeText( "<span") ;
         com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
         com.identityprovider.GxWebStd.styleAttribute( httpContext, sStyleString);
         httpContext.writeText( " id=\"span_"+sCtrlName+"\"") ;
         httpContext.writeText( ">") ;
         /* Initialize internal JScript code according to EventNo */
         if ( nJScriptCode == 1 )
         {
            sEventJsCode = "gx.fn.closeWindow();" ;
         }
         else if ( nJScriptCode == 3 )
         {
            sEventJsCode = "gx.util.help(" + "'" + httpContext.convertURL( "Help/"+"English/"+GXutil.lower( sCallerPgm)) + "');" ;
         }
         else if ( nJScriptCode == 7 )
         {
            sEventJsCode = "" + "gx.evt.execCliEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 8 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 6 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 5 )
         {
            sEventJsCode = "gx.evt.execEvt(" + sEventName + ",this);" ;
         }
         else if ( nJScriptCode == 0 )
         {
            sEventJsCode = "" ;
         }
         else
         {
            sEventJsCode = "" ;
         }
         com.identityprovider.GxWebStd.gx_start_js_anchor( httpContext, nJScriptCode, sEventJsCode, "", sLinkURL, sLinkTarget, "");
         if ( nFormat == 0 )
         {
            httpContext.writeValueEnter( sValue) ;
         }
         else
         {
            if ( nFormat == 3 )
            {
               httpContext.writeValueComplete( sValue) ;
            }
            else
            {
               httpContext.writeText( sValue) ;
            }
         }
         com.identityprovider.GxWebStd.gx_end_js_anchor( httpContext, sEventJsCode, "", sLinkURL);
         httpContext.writeText( "</span>") ;
      }
   }

   public static void gx_geolocation( HttpContext httpContext ,
                                      String sCtrlName ,
                                      String sValue ,
                                      String sFormatedValue ,
                                      String sTags ,
                                      String sEventName ,
                                      String sLinkURL ,
                                      String sLinkTarget ,
                                      String sTooltipText ,
                                      String sPlaceholder ,
                                      String sUserOnClickCode ,
                                      int nJScriptCode ,
                                      String sClassString ,
                                      String sStyleString ,
                                      String sROClassString ,
                                      String sColumnClassString ,
                                      String sColumnHeaderClassString ,
                                      int nVisible ,
                                      int nEnabled ,
                                      int nRTEnabled ,
                                      String sType ,
                                      String sStep ,
                                      int nWidth ,
                                      String nWidthUnit ,
                                      int nHeight ,
                                      String nHeightUnit ,
                                      int nLength ,
                                      byte nIsPassword ,
                                      short nFormat ,
                                      int nParentId ,
                                      byte bHasTheme ,
                                      byte nAutoComplete ,
                                      byte nAutoCorrection ,
                                      boolean bSendHidden ,
                                      String sDomainType ,
                                      String sAlign ,
                                      boolean bIsTextEdit ,
                                      String rtPicture )
   {
      String sTagsLocal = " data-gx-geolocation";
      com.identityprovider.GxWebStd.gx_single_line_edit( httpContext, sCtrlName, sValue, sFormatedValue, sTagsLocal, sEventName, sLinkURL, sLinkTarget, sTooltipText, sPlaceholder, sUserOnClickCode, nJScriptCode, sClassString, sStyleString, sROClassString, sColumnClassString, sColumnHeaderClassString, nVisible, nEnabled, nRTEnabled, sType, sStep, nWidth, nWidthUnit, nHeight, nHeightUnit, nLength, nIsPassword, nFormat, nParentId, bHasTheme, nAutoComplete, nAutoCorrection, bSendHidden, sDomainType, "", false, "", "");
      if ( ( nRTEnabled != 0 ) || ( nEnabled != 0 ) )
      {
         com.identityprovider.GxWebStd.gx_bitmap_readonly( httpContext, sCtrlName+"_geoLocMe", httpContext.convertURL( "locateMe"), "", "", "", "", nVisible, 1, httpContext.getMessage( "GXM_locatemeoption", ""), httpContext.getMessage( "GXM_locatemeoption", ""), 0, 0, 0, nWidthUnit, 0, nHeightUnit, 0, 0, 4, sUserOnClickCode, sEventName, sStyleString, "GeoLocOption", "", "", "", "", "", "gx.geolocation.getMyPosition(this);", "", "");
      }
   }

   public static void gx_group_start( HttpContext httpContext ,
                                      String sInternalName ,
                                      String sCaption ,
                                      int nVisible ,
                                      int nWidth ,
                                      String sWidthUnit ,
                                      int nHeight ,
                                      String sHeightUnit ,
                                      String sClassString ,
                                      String sTags ,
                                      String sCallerPgm )
   {
      httpContext.writeText( "<fieldset ") ;
      if ( ! (GXutil.strcmp("", sInternalName)==0) )
      {
         httpContext.writeText( "id=\""+sInternalName+"\" ") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      httpContext.writeText( " style=\"") ;
      if ( nVisible == 0 )
      {
         httpContext.writeText( "display:none;") ;
      }
      if ( ! (0==nWidth) )
      {
         httpContext.writeText( " width:") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0)) ;
         httpContext.writeText( sWidthUnit+";") ;
      }
      if ( ! (0==nHeight) )
      {
         httpContext.writeText( " height:") ;
         httpContext.writeText( GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0)) ;
         httpContext.writeText( sHeightUnit+";") ;
      }
      httpContext.writeText( "\"") ;
      if ( ! (GXutil.strcmp("", sTags)==0) )
      {
         httpContext.writeText( sTags) ;
      }
      httpContext.writeText( ">") ;
      httpContext.writeText( "<legend ") ;
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString+"Title");
      httpContext.writeText( ">") ;
      httpContext.writeText( sCaption) ;
      httpContext.writeText( "</legend>") ;
   }

   public static void gx_div_start( HttpContext httpContext ,
                                    String sInternalName ,
                                    int nVisible ,
                                    int nWidth ,
                                    String sWidthUnit ,
                                    int nHeight ,
                                    String sHeightUnit ,
                                    String sClassString ,
                                    String sAlign ,
                                    String sVAlign ,
                                    String sTags ,
                                    String sExtraStyle ,
                                    String sHtmlTag )
   {
      String sOStyle;
      boolean bHAlignedVar;
      boolean bVAlignedVar;
      bHAlignedVar = (boolean)(!(GXutil.strcmp("", sAlign)==0)&&(GXutil.strcmp(GXutil.lower( sAlign), "left")!=0)) ;
      bVAlignedVar = (boolean)(!(GXutil.strcmp("", sVAlign)==0)&&(GXutil.strcmp(GXutil.lower( sVAlign), "top")!=0)) ;
      httpContext.writeText( "<"+sHtmlTag+" ") ;
      if ( ! (GXutil.strcmp("", sInternalName)==0) )
      {
         httpContext.writeText( "id=\""+sInternalName+"\" ") ;
      }
      com.identityprovider.GxWebStd.classAttribute( httpContext, sClassString);
      sOStyle = "" ;
      if ( nVisible == 0 )
      {
         sOStyle = "display:none;" ;
      }
      if ( ! (0==nWidth) )
      {
         sOStyle += " width:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + sWidthUnit + ";" ;
      }
      if ( ! (0==nHeight) )
      {
         sOStyle += " height:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + sHeightUnit + ";" ;
      }
      if ( ! (GXutil.strcmp("", sExtraStyle)==0) )
      {
         sOStyle += GXutil.CssPrettify( sExtraStyle+";") ;
      }
      com.identityprovider.GxWebStd.styleAttribute( httpContext, sOStyle);
      if ( ! (GXutil.strcmp("", sTags)==0) )
      {
         httpContext.writeText( sTags) ;
      }
      if ( bHAlignedVar )
      {
         httpContext.writeText( " data-align=\"") ;
         httpContext.writeText( GXutil.lower( sAlign)) ;
         httpContext.writeText( "\"") ;
      }
      if ( bVAlignedVar )
      {
         httpContext.writeText( " data-valign=\"") ;
         httpContext.writeText( GXutil.lower( sVAlign)) ;
         httpContext.writeText( "\"") ;
      }
      httpContext.writeText( ">") ;
      if ( bHAlignedVar || bVAlignedVar )
      {
         httpContext.writeText( "<div data-align-outer=\"\"><div data-align-inner=\"\">") ;
      }
   }

   public static void gx_div_end( HttpContext httpContext ,
                                  String sAlign ,
                                  String sVAlign ,
                                  String sHtmlTag )
   {
      boolean bHAlignedVar;
      boolean bVAlignedVar;
      bHAlignedVar = (boolean)(!(GXutil.strcmp("", sAlign)==0)&&(GXutil.strcmp(GXutil.lower( sAlign), "left")!=0)) ;
      bVAlignedVar = (boolean)(!(GXutil.strcmp("", sVAlign)==0)&&(GXutil.strcmp(GXutil.lower( sVAlign), "top")!=0)) ;
      if ( bHAlignedVar || bVAlignedVar )
      {
         httpContext.writeText( "</div></div>") ;
      }
      httpContext.writeText( "</"+sHtmlTag+">") ;
   }

   public static void gx_embedded_page( HttpContext httpContext ,
                                        String sInternalName ,
                                        String sSrc ,
                                        int nVisible ,
                                        int nWidth ,
                                        String sWidthUnit ,
                                        int nHeight ,
                                        String sHeightUnit ,
                                        int nBorderStyle ,
                                        String sAlign ,
                                        String sTooltipText ,
                                        String sScroll )
   {
      String sStyleString;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.ajax_rsp_assign_prefixed_prop(sInternalName, "Tooltiptext", sTooltipText);
      }
      if ( (GXutil.strcmp("", sSrc)==0) )
      {
         sSrc = "about:blank" ;
      }
      sStyleString = ((nVisible!=0) ? "" : ";display:none;") ;
      httpContext.writeText( "<IFRAME src=\""+sSrc+"\"") ;
      httpContext.writeText( " name=\""+sInternalName+"\"") ;
      if ( nWidth > 0 )
      {
         sStyleString += "width:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nWidth), 10, 0) + sWidthUnit + ";" ;
      }
      if ( nHeight > 0 )
      {
         sStyleString += "height:" + GXutil.ltrimstr( DecimalUtil.doubleToDec(nHeight), 10, 0) + sHeightUnit + ";" ;
      }
      if ( GXutil.strcmp(sScroll, "yes") == 0 )
      {
         sStyleString += "overflow-x:scroll;overflow-y:scroll;" ;
      }
      else
      {
         if ( GXutil.strcmp(sScroll, "no") == 0 )
         {
            sStyleString += "overflow-x:hidden;overflow-y:hidden;" ;
         }
         else
         {
            if ( GXutil.strcmp(sScroll, "auto") == 0 )
            {
               sStyleString += "overflow-x:auto;overflow-y:auto;" ;
            }
         }
      }
      if ( GXutil.strcmp(sAlign, "right") == 0 )
      {
         sStyleString += "float:right;" ;
      }
      else
      {
         if ( GXutil.strcmp(sAlign, "left") == 0 )
         {
            sStyleString += "float:left;" ;
         }
         else
         {
            if ( GXutil.strcmp(sAlign, "center") == 0 )
            {
               sStyleString += "display:block;margin:0 auto;" ;
            }
         }
      }
      if ( nBorderStyle == 0 )
      {
         sStyleString += "border:none;" ;
      }
      httpContext.writeText( " title=\""+sTooltipText+"\""+" style=\""+sStyleString+"\""+"></IFRAME>") ;
   }

   public static void gx_form_group_start( HttpContext httpContext ,
                                           int nLabelPosition )
   {
      if ( nLabelPosition != 0 )
      {
         httpContext.writeText( "<div class=\"form-group gx-form-group\">") ;
      }
   }

   public static void gx_form_group_end( HttpContext httpContext ,
                                         int nLabelPosition )
   {
      if ( nLabelPosition != 0 )
      {
         httpContext.writeText( "</div>") ;
      }
   }

   public static void styleAttribute( HttpContext httpContext ,
                                      String sStyle )
   {
      if ( ! (GXutil.strcmp("", sStyle)==0) )
      {
         httpContext.writeText( " style=\"") ;
         httpContext.writeValue( GXutil.ltrim( GXutil.CssPrettify( sStyle))) ;
         httpContext.writeText( "\" ") ;
      }
   }

   public static void classAttribute( HttpContext httpContext ,
                                      String sClass )
   {
      if ( ! (GXutil.strcmp("", sClass)==0) )
      {
         httpContext.writeText( " class=\"") ;
         httpContext.writeValue( GXutil.ltrim( sClass)) ;
         httpContext.writeText( "\" ") ;
      }
   }

}

