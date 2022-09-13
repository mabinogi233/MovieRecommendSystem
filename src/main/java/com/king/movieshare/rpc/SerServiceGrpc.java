package com.king.movieshare.rpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.15.0)",
    comments = "Source: msg.proto")
public class SerServiceGrpc {

  private SerServiceGrpc() {}

  public static final String SERVICE_NAME = "SerService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Msg.inMsg,
      Msg.outMsg> METHOD_REC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "SerService", "rec"),
          io.grpc.protobuf.ProtoUtils.marshaller(Msg.inMsg.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Msg.outMsg.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SerServiceStub newStub(io.grpc.Channel channel) {
    return new SerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SerServiceFutureStub(channel);
  }

  /**
   */
  @Deprecated public static interface SerService {

    /**
     */
    public void rec(Msg.inMsg request,
                    io.grpc.stub.StreamObserver<Msg.outMsg> responseObserver);
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
  public static abstract class SerServiceImplBase implements SerService, io.grpc.BindableService {

    @Override
    public void rec(Msg.inMsg request,
                    io.grpc.stub.StreamObserver<Msg.outMsg> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REC, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return SerServiceGrpc.bindService(this);
    }
  }

  /**
   */
  @Deprecated public static interface SerServiceBlockingClient {

    /**
     */
    public Msg.outMsg rec(Msg.inMsg request);
  }

  /**
   */
  @Deprecated public static interface SerServiceFutureClient {

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Msg.outMsg> rec(
            Msg.inMsg request);
  }

  public static class SerServiceStub extends io.grpc.stub.AbstractStub<SerServiceStub>
      implements SerService {
    private SerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerServiceStub(channel, callOptions);
    }

    @Override
    public void rec(Msg.inMsg request,
                    io.grpc.stub.StreamObserver<Msg.outMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REC, getCallOptions()), request, responseObserver);
    }
  }

  public static class SerServiceBlockingStub extends io.grpc.stub.AbstractStub<SerServiceBlockingStub>
      implements SerServiceBlockingClient {
    private SerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerServiceBlockingStub(channel, callOptions);
    }

    @Override
    public Msg.outMsg rec(Msg.inMsg request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REC, getCallOptions(), request);
    }
  }

  public static class SerServiceFutureStub extends io.grpc.stub.AbstractStub<SerServiceFutureStub>
      implements SerServiceFutureClient {
    private SerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SerServiceFutureStub(channel, callOptions);
    }

    @Override
    public com.google.common.util.concurrent.ListenableFuture<Msg.outMsg> rec(
        Msg.inMsg request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REC, getCallOptions()), request);
    }
  }

  @Deprecated public static abstract class AbstractSerService extends SerServiceImplBase {}

  private static final int METHODID_REC = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SerService serviceImpl;
    private final int methodId;

    public MethodHandlers(SerService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REC:
          serviceImpl.rec((Msg.inMsg) request,
              (io.grpc.stub.StreamObserver<Msg.outMsg>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_REC);
  }

  @Deprecated public static io.grpc.ServerServiceDefinition bindService(
      final SerService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          METHOD_REC,
          asyncUnaryCall(
            new MethodHandlers<
              Msg.inMsg,
              Msg.outMsg>(
                serviceImpl, METHODID_REC)))
        .build();
  }
}
