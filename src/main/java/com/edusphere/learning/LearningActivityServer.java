package com.edusphere.learning;

/**
 *
 * @author Tan Wei Jie
 */

import com.edusphere.jmdns.jmDNS;
import com.edusphere.progress.ProgressTrackerImpl;
import com.edusphere.recommendation.CourseRecommendationImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class LearningActivityServer {

    public static void main(String[] args) throws Exception {
    int port = 50051;

     // 创建 gRPC Server 并注册多个服务
     Server server = ServerBuilder.forPort(port)
         .addService(new LearningActivityImpl())          // 学习活动服务
         .addService(new CourseRecommendationImpl())      // 课程推荐服务
         .addService(new ProgressTrackerImpl())           // 学习进度跟踪服务
         .build();

      // 启动服务器
      server.start();
      System.out.println("gRPC 服务器已启动，监听端口: " + port);

       // 使用 jmDNS 工具类注册服务，便于客户端发现
       jmDNS.registerService(
                "_grpc._tcp.local.",             // 服务类型（mDNS）
                 "QualityEducationSystem",        // 服务名称
                 port,                            // 服务端口
                "gRPC 服务（学习活动 + 推荐 + 进度跟踪）" // 可选描述
         );

        // 阻塞主线程，直到服务器被关闭
        server.awaitTermination();

  }
}
