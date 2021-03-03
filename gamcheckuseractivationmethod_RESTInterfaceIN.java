package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name =  "gamcheckuseractivationmethod_RESTInterfaceIN" , namespace = "http://tempuri.org/" , propOrder={  })
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gamcheckuseractivationmethod_RESTInterfaceIN
{
   String AV10UserGUID;
   @XmlElement(name="UserGUID")
   @JsonProperty("UserGUID")
   public String getUserGUID( )
   {
      if ( GXutil.strcmp(AV10UserGUID, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10UserGUID ;
      }
   }

   @JsonProperty("UserGUID")
   public void setUserGUID(  String Value )
   {
      if ( Value == null )
      {
         AV10UserGUID = "" ;
      }
      else
      {
         AV10UserGUID= Value;
      }
   }


}

