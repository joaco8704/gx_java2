package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.identityprovider.recentlinks", "/com.identityprovider.recentlinks"})
public final  class recentlinks extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new recentlinks_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new recentlinks_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Recent Links web component";
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

}

