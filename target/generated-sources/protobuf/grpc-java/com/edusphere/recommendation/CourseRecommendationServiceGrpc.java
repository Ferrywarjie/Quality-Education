package com.edusphere.recommendation;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义服务：课程推荐
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: course_recommendation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CourseRecommendationServiceGrpc {

  private CourseRecommendationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CourseRecommendationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.edusphere.recommendation.RecommendationRequest,
      com.edusphere.recommendation.RecommendationResponse> getGetRecommendationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendations",
      requestType = com.edusphere.recommendation.RecommendationRequest.class,
      responseType = com.edusphere.recommendation.RecommendationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.edusphere.recommendation.RecommendationRequest,
      com.edusphere.recommendation.RecommendationResponse> getGetRecommendationsMethod() {
    io.grpc.MethodDescriptor<com.edusphere.recommendation.RecommendationRequest, com.edusphere.recommendation.RecommendationResponse> getGetRecommendationsMethod;
    if ((getGetRecommendationsMethod = CourseRecommendationServiceGrpc.getGetRecommendationsMethod) == null) {
      synchronized (CourseRecommendationServiceGrpc.class) {
        if ((getGetRecommendationsMethod = CourseRecommendationServiceGrpc.getGetRecommendationsMethod) == null) {
          CourseRecommendationServiceGrpc.getGetRecommendationsMethod = getGetRecommendationsMethod =
              io.grpc.MethodDescriptor.<com.edusphere.recommendation.RecommendationRequest, com.edusphere.recommendation.RecommendationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.recommendation.RecommendationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.recommendation.RecommendationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseRecommendationServiceMethodDescriptorSupplier("GetRecommendations"))
              .build();
        }
      }
    }
    return getGetRecommendationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseRecommendationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceStub>() {
        @java.lang.Override
        public CourseRecommendationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseRecommendationServiceStub(channel, callOptions);
        }
      };
    return CourseRecommendationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseRecommendationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceBlockingStub>() {
        @java.lang.Override
        public CourseRecommendationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseRecommendationServiceBlockingStub(channel, callOptions);
        }
      };
    return CourseRecommendationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseRecommendationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseRecommendationServiceFutureStub>() {
        @java.lang.Override
        public CourseRecommendationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseRecommendationServiceFutureStub(channel, callOptions);
        }
      };
    return CourseRecommendationServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义服务：课程推荐
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 单次请求响应：客户端发送兴趣列表，服务端返回课程推荐
     * </pre>
     */
    default void getRecommendations(com.edusphere.recommendation.RecommendationRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.recommendation.RecommendationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CourseRecommendationService.
   * <pre>
   * 定义服务：课程推荐
   * </pre>
   */
  public static abstract class CourseRecommendationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CourseRecommendationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CourseRecommendationService.
   * <pre>
   * 定义服务：课程推荐
   * </pre>
   */
  public static final class CourseRecommendationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CourseRecommendationServiceStub> {
    private CourseRecommendationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseRecommendationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseRecommendationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 单次请求响应：客户端发送兴趣列表，服务端返回课程推荐
     * </pre>
     */
    public void getRecommendations(com.edusphere.recommendation.RecommendationRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.recommendation.RecommendationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommendationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CourseRecommendationService.
   * <pre>
   * 定义服务：课程推荐
   * </pre>
   */
  public static final class CourseRecommendationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CourseRecommendationServiceBlockingStub> {
    private CourseRecommendationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseRecommendationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseRecommendationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 单次请求响应：客户端发送兴趣列表，服务端返回课程推荐
     * </pre>
     */
    public com.edusphere.recommendation.RecommendationResponse getRecommendations(com.edusphere.recommendation.RecommendationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommendationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CourseRecommendationService.
   * <pre>
   * 定义服务：课程推荐
   * </pre>
   */
  public static final class CourseRecommendationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CourseRecommendationServiceFutureStub> {
    private CourseRecommendationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseRecommendationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseRecommendationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 单次请求响应：客户端发送兴趣列表，服务端返回课程推荐
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.edusphere.recommendation.RecommendationResponse> getRecommendations(
        com.edusphere.recommendation.RecommendationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommendationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RECOMMENDATIONS = 0;

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
        case METHODID_GET_RECOMMENDATIONS:
          serviceImpl.getRecommendations((com.edusphere.recommendation.RecommendationRequest) request,
              (io.grpc.stub.StreamObserver<com.edusphere.recommendation.RecommendationResponse>) responseObserver);
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
          getGetRecommendationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.edusphere.recommendation.RecommendationRequest,
              com.edusphere.recommendation.RecommendationResponse>(
                service, METHODID_GET_RECOMMENDATIONS)))
        .build();
  }

  private static abstract class CourseRecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseRecommendationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.edusphere.recommendation.CourseRecommendationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseRecommendationService");
    }
  }

  private static final class CourseRecommendationServiceFileDescriptorSupplier
      extends CourseRecommendationServiceBaseDescriptorSupplier {
    CourseRecommendationServiceFileDescriptorSupplier() {}
  }

  private static final class CourseRecommendationServiceMethodDescriptorSupplier
      extends CourseRecommendationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CourseRecommendationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CourseRecommendationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseRecommendationServiceFileDescriptorSupplier())
              .addMethod(getGetRecommendationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
