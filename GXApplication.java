package com.identityprovider ;
import com.identityprovider.*;
import java.util.*;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.genexus.ws.GXRestException;
import com.genexus.util.GXServices;
import com.genexus.webpanels.WebUtils;

public final  class GXApplication extends Application
{
   public Set<Class<?>> getClasses( )
   {
      Set<Class<?>> rrcs = new HashSet<Class<?>>();
      rrcs.add(GXRestException.class);
      rrcs.add(JacksonJaxbJsonProvider.class);
      rrcs.add(JacksonFeature.class);
      WebUtils.getGXApplicationClasses( getClass(), rrcs);
      WebUtils.AddExternalServices( getClass(), rrcs);
      return rrcs ;
   }

}

