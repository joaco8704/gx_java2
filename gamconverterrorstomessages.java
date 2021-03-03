package com.identityprovider ;
import com.identityprovider.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamconverterrorstomessages extends GXProcedure
{
   public gamconverterrorstomessages( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamconverterrorstomessages.class ), "" );
   }

   public gamconverterrorstomessages( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> aP0 )
   {
      gamconverterrorstomessages.this.AV9GAMErrorCollection = aP0;
      gamconverterrorstomessages.this.aP1 = aP1;
      gamconverterrorstomessages.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      initialize();
      privateExecute();
      return aP1[0];
   }

   public void execute( GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> aP0 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> aP0 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      gamconverterrorstomessages.this.AV9GAMErrorCollection = aP0;
      gamconverterrorstomessages.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXV1 = 1 ;
      while ( AV14GXV1 <= AV9GAMErrorCollection.size() )
      {
         AV8GAMError = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV9GAMErrorCollection.elementAt(-1+AV14GXV1));
         AV10Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV10Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV10Message.setgxTv_SdtMessages_Message_Description( AV8GAMError.getgxTv_SdtGAMError_Message() );
         AV10Message.setgxTv_SdtMessages_Message_Id( GXutil.format( "GAM%2", GXutil.ltrimstr( AV8GAMError.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", "", "") );
         AV11Messages.add(AV10Message, 0);
         AV14GXV1 = (int)(AV14GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamconverterrorstomessages.this.AV11Messages;
      CloseOpenCursors();
      exitApplication();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV8GAMError = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      AV10Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14GXV1 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV9GAMErrorCollection ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private com.genexus.SdtMessages_Message AV10Message ;
   private genexus.security.api.genexussecurity.SdtGAMError AV8GAMError ;
}

