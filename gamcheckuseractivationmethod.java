package com.identityprovider ;
import com.identityprovider.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamcheckuseractivationmethod extends GXProcedure
{
   public gamcheckuseractivationmethod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamcheckuseractivationmethod.class ), "" );
   }

   public gamcheckuseractivationmethod( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 )
   {
      gamcheckuseractivationmethod.this.AV10UserGUID = aP0;
      gamcheckuseractivationmethod.this.aP1 = aP1;
      gamcheckuseractivationmethod.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      initialize();
      privateExecute();
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      gamcheckuseractivationmethod.this.AV10UserGUID = aP0;
      gamcheckuseractivationmethod.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( GXutil.strcmp(AV9Repository.getgxTv_SdtGAMRepository_Useractivationmethod(), "U") == 0 )
      {
         AV14Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV14Message.setgxTv_SdtMessages_Message_Type( (byte)(0) );
         AV14Message.setgxTv_SdtMessages_Message_Description( "The user was created successfully!!, you must confirm the account, check your email, you will receive an email with a link to activate your account." );
         AV12Messages.add(AV14Message, 0);
         AV11User.load(AV10UserGUID);
         GXv_objcol_SdtGAMError1[0] = AV13Errors ;
         AV15ActivactionKey = AV11User.getactivationkey(GXv_objcol_SdtGAMError1) ;
         AV13Errors = GXv_objcol_SdtGAMError1[0] ;
         GXv_objcol_SdtGAMError1[0] = AV13Errors ;
         AV8isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).activateuser(AV15ActivactionKey, true, GXv_objcol_SdtGAMError1) ;
         AV13Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV8isOK )
         {
            AV14Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
            AV14Message.setgxTv_SdtMessages_Message_Type( (byte)(0) );
            AV14Message.setgxTv_SdtMessages_Message_Description( "Your user account was successfully activated !!" );
            AV12Messages.add(AV14Message, 0);
         }
         else
         {
            GXt_objcol_SdtMessages_Message2 = AV12Messages ;
            GXv_objcol_SdtMessages_Message3[0] = GXt_objcol_SdtMessages_Message2 ;
            new com.identityprovider.gamconverterrorstomessages(remoteHandle, context).execute( AV13Errors, GXv_objcol_SdtMessages_Message3) ;
            GXt_objcol_SdtMessages_Message2 = GXv_objcol_SdtMessages_Message3[0] ;
            AV12Messages = GXt_objcol_SdtMessages_Message2 ;
         }
      }
      else if ( GXutil.strcmp(AV9Repository.getgxTv_SdtGAMRepository_Useractivationmethod(), "D") == 0 )
      {
         AV14Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV14Message.setgxTv_SdtMessages_Message_Type( (byte)(0) );
         AV14Message.setgxTv_SdtMessages_Message_Description( "The user was created successfully!!, you must wait for confirmation from the administrator." );
         AV12Messages.add(AV14Message, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamcheckuseractivationmethod.this.AV12Messages;
      CloseOpenCursors();
      exitApplication();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV9Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV14Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV11User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV15ActivactionKey = "" ;
      AV13Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      GXt_objcol_SdtMessages_Message2 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10UserGUID ;
   private String AV15ActivactionKey ;
   private boolean AV8isOK ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV13Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV12Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXt_objcol_SdtMessages_Message2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private com.genexus.SdtMessages_Message AV14Message ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV9Repository ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV11User ;
}

