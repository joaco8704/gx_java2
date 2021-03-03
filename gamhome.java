package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.identityprovider.gamhome", "/com.identityprovider.gamhome"})
public final  class gamhome extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamhome_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamhome_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "GAM Home";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_LOW;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

}

