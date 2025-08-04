package com.edusphere.learning;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.edusphere.recommendation.CourseRecommendationImpl;
import com.edusphere.progress.ProgressTrackerImpl;

public class LearningActivityServer {

    public static void main(String[] args) throws Exception {
        int port = 50051;

        // 创建并启动 gRPC 服务器
        Server server = ServerBuilder.forPort(port)
                .addService(new LearningActivityImpl())
                .addService(new CourseRecommendationImpl())
                .addService(new ProgressTrackerImpl()) // 注册服务实现类
                .build()
                .start();

        System.out.println("服务器启动在端口 " + port);

        // 阻塞直到服务器终止
        server.awaitTermination();
    }
}
