package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.identityprovider.rwdrecentlinks", "/com.identityprovider.rwdrecentlinks"})
public final  class rwdrecentlinks extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rwdrecentlinks_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rwdrecentlinks_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Responsive Recent Links";
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

