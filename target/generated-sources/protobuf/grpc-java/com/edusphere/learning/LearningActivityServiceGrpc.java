package com.edusphere.learning;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 学习活动服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: learning_activity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LearningActivityServiceGrpc {

  private LearningActivityServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "LearningActivityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.edusphere.learning.ActivityData,
      com.edusphere.learning.ActivityAck> getReportActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportActivity",
      requestType = com.edusphere.learning.ActivityData.class,
      responseType = com.edusphere.learning.ActivityAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.edusphere.learning.ActivityData,
      com.edusphere.learning.ActivityAck> getReportActivityMethod() {
    io.grpc.MethodDescriptor<com.edusphere.learning.ActivityData, com.edusphere.learning.ActivityAck> getReportActivityMethod;
    if ((getReportActivityMethod = LearningActivityServiceGrpc.getReportActivityMethod) == null) {
      synchronized (LearningActivityServiceGrpc.class) {
        if ((getReportActivityMethod = LearningActivityServiceGrpc.getReportActivityMethod) == null) {
          LearningActivityServiceGrpc.getReportActivityMethod = getReportActivityMethod =
              io.grpc.MethodDescriptor.<com.edusphere.learning.ActivityData, com.edusphere.learning.ActivityAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.learning.ActivityData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.learning.ActivityAck.getDefaultInstance()))
              .setSchemaDescriptor(new LearningActivityServiceMethodDescriptorSupplier("ReportActivity"))
              .build();
        }
      }
    }
    return getReportActivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.edusphere.learning.ActivityRequest,
      com.edusphere.learning.ActivityData> getGetRecentActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecentActivity",
      requestType = com.edusphere.learning.ActivityRequest.class,
      responseType = com.edusphere.learning.ActivityData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.edusphere.learning.ActivityRequest,
      com.edusphere.learning.ActivityData> getGetRecentActivityMethod() {
    io.grpc.MethodDescriptor<com.edusphere.learning.ActivityRequest, com.edusphere.learning.ActivityData> getGetRecentActivityMethod;
    if ((getGetRecentActivityMethod = LearningActivityServiceGrpc.getGetRecentActivityMethod) == null) {
      synchronized (LearningActivityServiceGrpc.class) {
        if ((getGetRecentActivityMethod = LearningActivityServiceGrpc.getGetRecentActivityMethod) == null) {
          LearningActivityServiceGrpc.getGetRecentActivityMethod = getGetRecentActivityMethod =
              io.grpc.MethodDescriptor.<com.edusphere.learning.ActivityRequest, com.edusphere.learning.ActivityData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecentActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.learning.ActivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.learning.ActivityData.getDefaultInstance()))
              .setSchemaDescriptor(new LearningActivityServiceMethodDescriptorSupplier("GetRecentActivity"))
              .build();
        }
      }
    }
    return getGetRecentActivityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LearningActivityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceStub>() {
        @java.lang.Override
        public LearningActivityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LearningActivityServiceStub(channel, callOptions);
        }
      };
    return LearningActivityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LearningActivityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceBlockingStub>() {
        @java.lang.Override
        public LearningActivityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LearningActivityServiceBlockingStub(channel, callOptions);
        }
      };
    return LearningActivityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LearningActivityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LearningActivityServiceFutureStub>() {
        @java.lang.Override
        public LearningActivityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LearningActivityServiceFutureStub(channel, callOptions);
        }
      };
    return LearningActivityServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 学习活动服务定义
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC：客户端上传一条学习记录
     * </pre>
     */
    default void reportActivity(com.edusphere.learning.ActivityData request,
        io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportActivityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC：服务器返回学生最近的学习记录
     * </pre>
     */
    default void getRecentActivity(com.edusphere.learning.ActivityRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecentActivityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LearningActivityService.
   * <pre>
   * 学习活动服务定义
   * </pre>
   */
  public static abstract class LearningActivityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LearningActivityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LearningActivityService.
   * <pre>
   * 学习活动服务定义
   * </pre>
   */
  public static final class LearningActivityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LearningActivityServiceStub> {
    private LearningActivityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LearningActivityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LearningActivityServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC：客户端上传一条学习记录
     * </pre>
     */
    public void reportActivity(com.edusphere.learning.ActivityData request,
        io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportActivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC：服务器返回学生最近的学习记录
     * </pre>
     */
    public void getRecentActivity(com.edusphere.learning.ActivityRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetRecentActivityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LearningActivityService.
   * <pre>
   * 学习活动服务定义
   * </pre>
   */
  public static final class LearningActivityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LearningActivityServiceBlockingStub> {
    private LearningActivityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LearningActivityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LearningActivityServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC：客户端上传一条学习记录
     * </pre>
     */
    public com.edusphere.learning.ActivityAck reportActivity(com.edusphere.learning.ActivityData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportActivityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming RPC：服务器返回学生最近的学习记录
     * </pre>
     */
    public java.util.Iterator<com.edusphere.learning.ActivityData> getRecentActivity(
        com.edusphere.learning.ActivityRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetRecentActivityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LearningActivityService.
   * <pre>
   * 学习活动服务定义
   * </pre>
   */
  public static final class LearningActivityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LearningActivityServiceFutureStub> {
    private LearningActivityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LearningActivityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LearningActivityServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC：客户端上传一条学习记录
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.edusphere.learning.ActivityAck> reportActivity(
        com.edusphere.learning.ActivityData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportActivityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_ACTIVITY = 0;
  private static final int METHODID_GET_RECENT_ACTIVITY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_ACTIVITY:
          serviceImpl.reportActivity((com.edusphere.learning.ActivityData) request,
              (io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityAck>) responseObserver);
          break;
        case METHODID_GET_RECENT_ACTIVITY:
          serviceImpl.getRecentActivity((com.edusphere.learning.ActivityRequest) request,
              (io.grpc.stub.StreamObserver<com.edusphere.learning.ActivityData>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReportActivityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.edusphere.learning.ActivityData,
              com.edusphere.learning.ActivityAck>(
                service, METHODID_REPORT_ACTIVITY)))
        .addMethod(
          getGetRecentActivityMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.edusphere.learning.ActivityRequest,
              com.edusphere.learning.ActivityData>(
                service, METHODID_GET_RECENT_ACTIVITY)))
        .build();
  }

  private static abstract class LearningActivityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LearningActivityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.edusphere.learning.LearningActivityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LearningActivityService");
    }
  }

  private static final class LearningActivityServiceFileDescriptorSupplier
      extends LearningActivityServiceBaseDescriptorSupplier {
    LearningActivityServiceFileDescriptorSupplier() {}
  }

  private static final class LearningActivityServiceMethodDescriptorSupplier
      extends LearningActivityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LearningActivityServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LearningActivityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LearningActivityServiceFileDescriptorSupplier())
              .addMethod(getReportActivityMethod())
              .addMethod(getGetRecentActivityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
