package com.edusphere.progress;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: progress_tracker.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProgressTrackerServiceGrpc {

  private ProgressTrackerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ProgressTrackerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.edusphere.progress.ProgressRequest,
      com.edusphere.progress.ProgressResponse> getRecordProgressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecordProgress",
      requestType = com.edusphere.progress.ProgressRequest.class,
      responseType = com.edusphere.progress.ProgressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.edusphere.progress.ProgressRequest,
      com.edusphere.progress.ProgressResponse> getRecordProgressMethod() {
    io.grpc.MethodDescriptor<com.edusphere.progress.ProgressRequest, com.edusphere.progress.ProgressResponse> getRecordProgressMethod;
    if ((getRecordProgressMethod = ProgressTrackerServiceGrpc.getRecordProgressMethod) == null) {
      synchronized (ProgressTrackerServiceGrpc.class) {
        if ((getRecordProgressMethod = ProgressTrackerServiceGrpc.getRecordProgressMethod) == null) {
          ProgressTrackerServiceGrpc.getRecordProgressMethod = getRecordProgressMethod =
              io.grpc.MethodDescriptor.<com.edusphere.progress.ProgressRequest, com.edusphere.progress.ProgressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecordProgress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.ProgressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.ProgressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProgressTrackerServiceMethodDescriptorSupplier("RecordProgress"))
              .build();
        }
      }
    }
    return getRecordProgressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.edusphere.progress.ProgressQuery,
      com.edusphere.progress.ProgressStatus> getCheckProgressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckProgress",
      requestType = com.edusphere.progress.ProgressQuery.class,
      responseType = com.edusphere.progress.ProgressStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.edusphere.progress.ProgressQuery,
      com.edusphere.progress.ProgressStatus> getCheckProgressMethod() {
    io.grpc.MethodDescriptor<com.edusphere.progress.ProgressQuery, com.edusphere.progress.ProgressStatus> getCheckProgressMethod;
    if ((getCheckProgressMethod = ProgressTrackerServiceGrpc.getCheckProgressMethod) == null) {
      synchronized (ProgressTrackerServiceGrpc.class) {
        if ((getCheckProgressMethod = ProgressTrackerServiceGrpc.getCheckProgressMethod) == null) {
          ProgressTrackerServiceGrpc.getCheckProgressMethod = getCheckProgressMethod =
              io.grpc.MethodDescriptor.<com.edusphere.progress.ProgressQuery, com.edusphere.progress.ProgressStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckProgress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.ProgressQuery.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.ProgressStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ProgressTrackerServiceMethodDescriptorSupplier("CheckProgress"))
              .build();
        }
      }
    }
    return getCheckProgressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.edusphere.progress.UserRequest,
      com.edusphere.progress.CourseList> getListCompletedCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCompletedCourses",
      requestType = com.edusphere.progress.UserRequest.class,
      responseType = com.edusphere.progress.CourseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.edusphere.progress.UserRequest,
      com.edusphere.progress.CourseList> getListCompletedCoursesMethod() {
    io.grpc.MethodDescriptor<com.edusphere.progress.UserRequest, com.edusphere.progress.CourseList> getListCompletedCoursesMethod;
    if ((getListCompletedCoursesMethod = ProgressTrackerServiceGrpc.getListCompletedCoursesMethod) == null) {
      synchronized (ProgressTrackerServiceGrpc.class) {
        if ((getListCompletedCoursesMethod = ProgressTrackerServiceGrpc.getListCompletedCoursesMethod) == null) {
          ProgressTrackerServiceGrpc.getListCompletedCoursesMethod = getListCompletedCoursesMethod =
              io.grpc.MethodDescriptor.<com.edusphere.progress.UserRequest, com.edusphere.progress.CourseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCompletedCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.edusphere.progress.CourseList.getDefaultInstance()))
              .setSchemaDescriptor(new ProgressTrackerServiceMethodDescriptorSupplier("ListCompletedCourses"))
              .build();
        }
      }
    }
    return getListCompletedCoursesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProgressTrackerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceStub>() {
        @java.lang.Override
        public ProgressTrackerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProgressTrackerServiceStub(channel, callOptions);
        }
      };
    return ProgressTrackerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProgressTrackerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceBlockingStub>() {
        @java.lang.Override
        public ProgressTrackerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProgressTrackerServiceBlockingStub(channel, callOptions);
        }
      };
    return ProgressTrackerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProgressTrackerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProgressTrackerServiceFutureStub>() {
        @java.lang.Override
        public ProgressTrackerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProgressTrackerServiceFutureStub(channel, callOptions);
        }
      };
    return ProgressTrackerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 用于记录用户完成了某门课程
     * </pre>
     */
    default void recordProgress(com.edusphere.progress.ProgressRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecordProgressMethod(), responseObserver);
    }

    /**
     * <pre>
     * 检查某门课程是否已完成
     * </pre>
     */
    default void checkProgress(com.edusphere.progress.ProgressQuery request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckProgressMethod(), responseObserver);
    }

    /**
     * <pre>
     * 列出所有已完成的课程
     * </pre>
     */
    default void listCompletedCourses(com.edusphere.progress.UserRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.CourseList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCompletedCoursesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProgressTrackerService.
   * <pre>
   * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
   * </pre>
   */
  public static abstract class ProgressTrackerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProgressTrackerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProgressTrackerService.
   * <pre>
   * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
   * </pre>
   */
  public static final class ProgressTrackerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProgressTrackerServiceStub> {
    private ProgressTrackerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressTrackerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgressTrackerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 用于记录用户完成了某门课程
     * </pre>
     */
    public void recordProgress(com.edusphere.progress.ProgressRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecordProgressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 检查某门课程是否已完成
     * </pre>
     */
    public void checkProgress(com.edusphere.progress.ProgressQuery request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckProgressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 列出所有已完成的课程
     * </pre>
     */
    public void listCompletedCourses(com.edusphere.progress.UserRequest request,
        io.grpc.stub.StreamObserver<com.edusphere.progress.CourseList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCompletedCoursesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProgressTrackerService.
   * <pre>
   * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
   * </pre>
   */
  public static final class ProgressTrackerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProgressTrackerServiceBlockingStub> {
    private ProgressTrackerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressTrackerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgressTrackerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 用于记录用户完成了某门课程
     * </pre>
     */
    public com.edusphere.progress.ProgressResponse recordProgress(com.edusphere.progress.ProgressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecordProgressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 检查某门课程是否已完成
     * </pre>
     */
    public com.edusphere.progress.ProgressStatus checkProgress(com.edusphere.progress.ProgressQuery request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckProgressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 列出所有已完成的课程
     * </pre>
     */
    public com.edusphere.progress.CourseList listCompletedCourses(com.edusphere.progress.UserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCompletedCoursesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProgressTrackerService.
   * <pre>
   * ProgressTrackerService 服务：用于跟踪用户完成课程的进度
   * </pre>
   */
  public static final class ProgressTrackerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProgressTrackerServiceFutureStub> {
    private ProgressTrackerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressTrackerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgressTrackerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 用于记录用户完成了某门课程
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.edusphere.progress.ProgressResponse> recordProgress(
        com.edusphere.progress.ProgressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecordProgressMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 检查某门课程是否已完成
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.edusphere.progress.ProgressStatus> checkProgress(
        com.edusphere.progress.ProgressQuery request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckProgressMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 列出所有已完成的课程
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.edusphere.progress.CourseList> listCompletedCourses(
        com.edusphere.progress.UserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCompletedCoursesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECORD_PROGRESS = 0;
  private static final int METHODID_CHECK_PROGRESS = 1;
  private static final int METHODID_LIST_COMPLETED_COURSES = 2;

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
        case METHODID_RECORD_PROGRESS:
          serviceImpl.recordProgress((com.edusphere.progress.ProgressRequest) request,
              (io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressResponse>) responseObserver);
          break;
        case METHODID_CHECK_PROGRESS:
          serviceImpl.checkProgress((com.edusphere.progress.ProgressQuery) request,
              (io.grpc.stub.StreamObserver<com.edusphere.progress.ProgressStatus>) responseObserver);
          break;
        case METHODID_LIST_COMPLETED_COURSES:
          serviceImpl.listCompletedCourses((com.edusphere.progress.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.edusphere.progress.CourseList>) responseObserver);
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
          getRecordProgressMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.edusphere.progress.ProgressRequest,
              com.edusphere.progress.ProgressResponse>(
                service, METHODID_RECORD_PROGRESS)))
        .addMethod(
          getCheckProgressMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.edusphere.progress.ProgressQuery,
              com.edusphere.progress.ProgressStatus>(
                service, METHODID_CHECK_PROGRESS)))
        .addMethod(
          getListCompletedCoursesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.edusphere.progress.UserRequest,
              com.edusphere.progress.CourseList>(
                service, METHODID_LIST_COMPLETED_COURSES)))
        .build();
  }

  private static abstract class ProgressTrackerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProgressTrackerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.edusphere.progress.ProgressTrackerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProgressTrackerService");
    }
  }

  private static final class ProgressTrackerServiceFileDescriptorSupplier
      extends ProgressTrackerServiceBaseDescriptorSupplier {
    ProgressTrackerServiceFileDescriptorSupplier() {}
  }

  private static final class ProgressTrackerServiceMethodDescriptorSupplier
      extends ProgressTrackerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProgressTrackerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProgressTrackerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProgressTrackerServiceFileDescriptorSupplier())
              .addMethod(getRecordProgressMethod())
              .addMethod(getCheckProgressMethod())
              .addMethod(getListCompletedCoursesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
