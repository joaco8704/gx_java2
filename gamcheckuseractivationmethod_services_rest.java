package com.identityprovider ;
import com.identityprovider.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;
import javax.servlet.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;

@Path("/GAMCheckUserActivationMethod")
public final  class gamcheckuseractivationmethod_services_rest extends GxRestService
{
   @Context
   private ServletContext myContext;
   @Context
   private javax.servlet.http.HttpServletRequest myServletRequest;
   @Context
   private javax.servlet.http.HttpServletResponse myServletResponse;
   @POST
   @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public Response execute( com.identityprovider.gamcheckuseractivationmethod_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" , myServletRequest, myServletResponse, myContext);
      ApplicationContext.getInstance().setServletEngineDefaultPath(myContext.getRealPath("/"));
      Response.ResponseBuilder builder = null;
      String AV10UserGUID;
      AV10UserGUID = entity.getUserGUID() ;
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexus.SdtMessages_Message> [] AV12Messages = new GXBaseCollection[] { new GXBaseCollection<com.genexus.SdtMessages_Message>() };
      permissionPrefix = "";
      if ( ! isAuthenticated(myServletRequest) )
      {
         if ( forbidden )
         {
            builder = Response.status(Response.Status.FORBIDDEN);
         }
         else
         {
            setWWWAuthHeader(myServletRequest, myServletResponse);
            builder = Response.status(Response.Status.UNAUTHORIZED);
         }
         builder.type("application/json");
         builder.entity(errorJson.toString());
         cleanup();
         return builder.build() ;
      }
      if ( ! processHeaders("gamcheckuseractivationmethod",myServletRequest,myServletResponse) )
      {
         builder = Response.notModified();
         cleanup();
         return builder.build();
      }
      try
      {
         com.identityprovider.gamcheckuseractivationmethod worker = new com.identityprovider.gamcheckuseractivationmethod(remoteHandle, context);
         worker.execute(AV10UserGUID,AV12Messages );
         com.identityprovider.gamcheckuseractivationmethod_RESTInterfaceOUT data = new com.identityprovider.gamcheckuseractivationmethod_RESTInterfaceOUT();
         data.setMessages(SdtMessages_Message_RESTInterfacefromGXObjectCollection(AV12Messages[0]));
         builder = Response.ok(data);
         cleanup();
         return builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   private Vector<com.genexus.SdtMessages_Message_RESTInterface> SdtMessages_Message_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexus.SdtMessages_Message> collection )
   {
      Vector<com.genexus.SdtMessages_Message_RESTInterface> result = new Vector<com.genexus.SdtMessages_Message_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexus.SdtMessages_Message_RESTInterface((com.genexus.SdtMessages_Message)collection.elementAt(i)));
      }
      return result ;
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_LOW;
   }

}

