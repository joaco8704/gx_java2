package com.identityprovider ;
import com.identityprovider.*;
import com.genexus.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name =  "gamcheckuseractivationmethod_RESTInterfaceOUT" , namespace = "http://tempuri.org/" , propOrder={  })
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gamcheckuseractivationmethod_RESTInterfaceOUT
{
   Vector<com.genexus.SdtMessages_Message_RESTInterface> AV12Messages ;
   @XmlElement(name="Messages")
   @JsonProperty("Messages")
   public Vector<com.genexus.SdtMessages_Message_RESTInterface> getMessages( )
   {
      return AV12Messages ;
   }

   @JsonProperty("Messages")
   public void setMessages(  Vector<com.genexus.SdtMessages_Message_RESTInterface> Value )
   {
      AV12Messages= Value;
   }


}

