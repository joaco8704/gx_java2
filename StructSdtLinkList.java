package com.identityprovider ;
import com.genexus.*;

public final  class StructSdtLinkList implements Cloneable, java.io.Serializable
{
   public StructSdtLinkList( )
   {
   }

   public  StructSdtLinkList( java.util.Vector<StructSdtLinkList_LinkItem> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @XmlElement(name= "LinkItem" ,namespace= "GeneXus" )
   public java.util.Vector<StructSdtLinkList_LinkItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtLinkList_LinkItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtLinkList_LinkItem> item;
}

