package com.king.movieshare.rpc;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg.proto

public final class Msg {
  private Msg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface inMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:inMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string phonenumber = 1;</code>
     */
    String getPhonenumber();
    /**
     * <code>optional string phonenumber = 1;</code>
     */
    com.google.protobuf.ByteString
        getPhonenumberBytes();

    /**
     * <code>optional int32 num = 2;</code>
     */
    int getNum();
  }
  /**
   * Protobuf type {@code inMsg}
   */
  public  static final class inMsg extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:inMsg)
      inMsgOrBuilder {
    // Use inMsg.newBuilder() to construct.
    private inMsg(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private inMsg() {
      phonenumber_ = "";
      num_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private inMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              phonenumber_ = s;
              break;
            }
            case 16: {

              num_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Msg.internal_static_inMsg_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Msg.internal_static_inMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              inMsg.class, Builder.class);
    }

    public static final int PHONENUMBER_FIELD_NUMBER = 1;
    private volatile Object phonenumber_;
    /**
     * <code>optional string phonenumber = 1;</code>
     */
    public String getPhonenumber() {
      Object ref = phonenumber_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        phonenumber_ = s;
        return s;
      }
    }
    /**
     * <code>optional string phonenumber = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPhonenumberBytes() {
      Object ref = phonenumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        phonenumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NUM_FIELD_NUMBER = 2;
    private int num_;
    /**
     * <code>optional int32 num = 2;</code>
     */
    public int getNum() {
      return num_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getPhonenumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 1, phonenumber_);
      }
      if (num_ != 0) {
        output.writeInt32(2, num_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getPhonenumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(1, phonenumber_);
      }
      if (num_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, num_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof inMsg)) {
        return super.equals(obj);
      }
      inMsg other = (inMsg) obj;

      boolean result = true;
      result = result && getPhonenumber()
          .equals(other.getPhonenumber());
      result = result && (getNum()
          == other.getNum());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + PHONENUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getPhonenumber().hashCode();
      hash = (37 * hash) + NUM_FIELD_NUMBER;
      hash = (53 * hash) + getNum();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static inMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static inMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static inMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static inMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static inMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static inMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static inMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static inMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static inMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static inMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(inMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code inMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:inMsg)
        inMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Msg.internal_static_inMsg_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Msg.internal_static_inMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                inMsg.class, Builder.class);
      }

      // Construct using Msg.inMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        phonenumber_ = "";

        num_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Msg.internal_static_inMsg_descriptor;
      }

      public inMsg getDefaultInstanceForType() {
        return inMsg.getDefaultInstance();
      }

      public inMsg build() {
        inMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public inMsg buildPartial() {
        inMsg result = new inMsg(this);
        result.phonenumber_ = phonenumber_;
        result.num_ = num_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof inMsg) {
          return mergeFrom((inMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(inMsg other) {
        if (other == inMsg.getDefaultInstance()) return this;
        if (!other.getPhonenumber().isEmpty()) {
          phonenumber_ = other.phonenumber_;
          onChanged();
        }
        if (other.getNum() != 0) {
          setNum(other.getNum());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        inMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (inMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object phonenumber_ = "";
      /**
       * <code>optional string phonenumber = 1;</code>
       */
      public String getPhonenumber() {
        Object ref = phonenumber_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          phonenumber_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string phonenumber = 1;</code>
       */
      public com.google.protobuf.ByteString
          getPhonenumberBytes() {
        Object ref = phonenumber_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          phonenumber_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string phonenumber = 1;</code>
       */
      public Builder setPhonenumber(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        phonenumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string phonenumber = 1;</code>
       */
      public Builder clearPhonenumber() {
        
        phonenumber_ = getDefaultInstance().getPhonenumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional string phonenumber = 1;</code>
       */
      public Builder setPhonenumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        phonenumber_ = value;
        onChanged();
        return this;
      }

      private int num_ ;
      /**
       * <code>optional int32 num = 2;</code>
       */
      public int getNum() {
        return num_;
      }
      /**
       * <code>optional int32 num = 2;</code>
       */
      public Builder setNum(int value) {
        
        num_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 num = 2;</code>
       */
      public Builder clearNum() {
        
        num_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:inMsg)
    }

    // @@protoc_insertion_point(class_scope:inMsg)
    private static final inMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new inMsg();
    }

    public static inMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<inMsg>
        PARSER = new com.google.protobuf.AbstractParser<inMsg>() {
      public inMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new inMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<inMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<inMsg> getParserForType() {
      return PARSER;
    }

    public inMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface outMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:outMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string msg = 1;</code>
     */
    String getMsg();
    /**
     * <code>optional string msg = 1;</code>
     */
    com.google.protobuf.ByteString
        getMsgBytes();
  }
  /**
   * Protobuf type {@code outMsg}
   */
  public  static final class outMsg extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:outMsg)
      outMsgOrBuilder {
    // Use outMsg.newBuilder() to construct.
    private outMsg(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private outMsg() {
      msg_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private outMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              msg_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Msg.internal_static_outMsg_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Msg.internal_static_outMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              outMsg.class, Builder.class);
    }

    public static final int MSG_FIELD_NUMBER = 1;
    private volatile Object msg_;
    /**
     * <code>optional string msg = 1;</code>
     */
    public String getMsg() {
      Object ref = msg_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        msg_ = s;
        return s;
      }
    }
    /**
     * <code>optional string msg = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMsgBytes() {
      Object ref = msg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        msg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMsgBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 1, msg_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMsgBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(1, msg_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof outMsg)) {
        return super.equals(obj);
      }
      outMsg other = (outMsg) obj;

      boolean result = true;
      result = result && getMsg()
          .equals(other.getMsg());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + MSG_FIELD_NUMBER;
      hash = (53 * hash) + getMsg().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static outMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static outMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static outMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static outMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static outMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static outMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static outMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static outMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static outMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static outMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(outMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code outMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:outMsg)
        outMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Msg.internal_static_outMsg_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Msg.internal_static_outMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                outMsg.class, Builder.class);
      }

      // Construct using Msg.outMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        msg_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Msg.internal_static_outMsg_descriptor;
      }

      public outMsg getDefaultInstanceForType() {
        return outMsg.getDefaultInstance();
      }

      public outMsg build() {
        outMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public outMsg buildPartial() {
        outMsg result = new outMsg(this);
        result.msg_ = msg_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof outMsg) {
          return mergeFrom((outMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(outMsg other) {
        if (other == outMsg.getDefaultInstance()) return this;
        if (!other.getMsg().isEmpty()) {
          msg_ = other.msg_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        outMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (outMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object msg_ = "";
      /**
       * <code>optional string msg = 1;</code>
       */
      public String getMsg() {
        Object ref = msg_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          msg_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string msg = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMsgBytes() {
        Object ref = msg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          msg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string msg = 1;</code>
       */
      public Builder setMsg(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        msg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string msg = 1;</code>
       */
      public Builder clearMsg() {
        
        msg_ = getDefaultInstance().getMsg();
        onChanged();
        return this;
      }
      /**
       * <code>optional string msg = 1;</code>
       */
      public Builder setMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        msg_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:outMsg)
    }

    // @@protoc_insertion_point(class_scope:outMsg)
    private static final outMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new outMsg();
    }

    public static outMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<outMsg>
        PARSER = new com.google.protobuf.AbstractParser<outMsg>() {
      public outMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new outMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<outMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<outMsg> getParserForType() {
      return PARSER;
    }

    public outMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_inMsg_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_outMsg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_outMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\tmsg.proto\")\n\005inMsg\022\023\n\013phonenumber\030\001 \001(" +
      "\t\022\013\n\003num\030\002 \001(\005\"\025\n\006outMsg\022\013\n\003msg\030\001 \001(\t2$\n" +
      "\nSerService\022\026\n\003rec\022\006.inMsg\032\007.outMsgb\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_inMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_inMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_inMsg_descriptor,
        new String[] { "Phonenumber", "Num", });
    internal_static_outMsg_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_outMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_outMsg_descriptor,
        new String[] { "Msg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}