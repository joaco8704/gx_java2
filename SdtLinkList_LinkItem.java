package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLinkList_LinkItem extends GXXMLSerializable implements Cloneable, java.io.Serializable
{
   public SdtLinkList_LinkItem( )
   {
      this(  new ModelContext(SdtLinkList_LinkItem.class));
   }

   public SdtLinkList_LinkItem( ModelContext context )
   {
      super( context, "SdtLinkList_LinkItem");
   }

   public SdtLinkList_LinkItem( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtLinkList_LinkItem");
   }

   public SdtLinkList_LinkItem( StructSdtLinkList_LinkItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "Caption") )
            {
               gxTv_SdtLinkList_LinkItem_Caption = oReader.getValue() ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "URL") )
            {
               gxTv_SdtLinkList_LinkItem_Url = oReader.getValue() ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "LinkList.LinkItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("Caption", GXutil.rtrim( gxTv_SdtLinkList_LinkItem_Caption));
      if ( GXutil.strcmp(sNameSpace, "GeneXus") != 0 )
      {
         oWriter.writeAttribute("xmlns", "GeneXus");
      }
      oWriter.writeElement("URL", GXutil.rtrim( gxTv_SdtLinkList_LinkItem_Url));
      if ( GXutil.strcmp(sNameSpace, "GeneXus") != 0 )
      {
         oWriter.writeAttribute("xmlns", "GeneXus");
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("Caption", gxTv_SdtLinkList_LinkItem_Caption, false, false);
      AddObjectProperty("URL", gxTv_SdtLinkList_LinkItem_Url, false, false);
   }

   public String getgxTv_SdtLinkList_LinkItem_Caption( )
   {
      return gxTv_SdtLinkList_LinkItem_Caption ;
   }

   public void setgxTv_SdtLinkList_LinkItem_Caption( String value )
   {
      gxTv_SdtLinkList_LinkItem_Caption = value ;
   }

   public String getgxTv_SdtLinkList_LinkItem_Url( )
   {
      return gxTv_SdtLinkList_LinkItem_Url ;
   }

   public void setgxTv_SdtLinkList_LinkItem_Url( String value )
   {
      gxTv_SdtLinkList_LinkItem_Url = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLinkList_LinkItem_Caption = "" ;
      gxTv_SdtLinkList_LinkItem_Url = "" ;
      sTagName = "" ;
   }

   public com.identityprovider.SdtLinkList_LinkItem Clone( )
   {
      return (com.identityprovider.SdtLinkList_LinkItem)(clone()) ;
   }

   public void setStruct( com.identityprovider.StructSdtLinkList_LinkItem struct )
   {
      setgxTv_SdtLinkList_LinkItem_Caption(struct.getCaption());
      setgxTv_SdtLinkList_LinkItem_Url(struct.getUrl());
   }

   @SuppressWarnings("unchecked")
   public com.identityprovider.StructSdtLinkList_LinkItem getStruct( )
   {
      com.identityprovider.StructSdtLinkList_LinkItem struct = new com.identityprovider.StructSdtLinkList_LinkItem ();
      struct.setCaption(getgxTv_SdtLinkList_LinkItem_Caption());
      struct.setUrl(getgxTv_SdtLinkList_LinkItem_Url());
      return struct ;
   }

   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean formatError ;
   protected String gxTv_SdtLinkList_LinkItem_Caption ;
   protected String gxTv_SdtLinkList_LinkItem_Url ;
}

