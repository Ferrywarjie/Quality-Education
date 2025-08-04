package com.edusphere.recommendation;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.stub.StreamObserver;
import java.util.*;

/**
 * 课程推荐服务的实现类
 * 本类继承自动生成的 gRPC 基类，实现课程推荐逻辑
 */
public class CourseRecommendationImpl extends CourseRecommendationServiceGrpc.CourseRecommendationServiceImplBase {

    // 使用 Map 模拟一份兴趣和推荐课程的映射关系
// 实际项目中可以替换为从数据库或外部系统中读取
private static final Map<String, List<String>> interestToCourses = new HashMap<>();

   static {
    // 数学类兴趣课程
    interestToCourses.put("math", Arrays.asList(
        "Algebra I",
        "Calculus Basics",
        "Statistics",
        "Discrete Mathematics"
    ));

    // 科学类兴趣课程
    interestToCourses.put("science", Arrays.asList(
        "Introduction to Physics",
        "Basic Chemistry",
        "Biology for Beginners",
        "Astronomy Fundamentals"
    ));

    // 编程类兴趣课程
    interestToCourses.put("programming", Arrays.asList(
        "Java for Beginners",
        "Python Programming",
        "Data Structures in C++",
        "Web Development"
    ));

    // 设计类兴趣课程
    interestToCourses.put("design", Arrays.asList(
        "Graphic Design Basics",
        "UX Fundamentals",
        "Intro to Figma",
        "Color Theory in Design"
    ));

    // 商业类兴趣课程
    interestToCourses.put("business", Arrays.asList(
        "Introduction to Marketing",
        "Entrepreneurship",
        "Business Strategy",
        "Financial Accounting Basics"
    ));

    // 语言学习类兴趣课程
    interestToCourses.put("language", Arrays.asList(
        "English Grammar Essentials",
        "Japanese for Beginners",
        "Spanish Conversation",
        "TOEFL Preparation"
    ));

    // 音乐类兴趣课程
    interestToCourses.put("music", Arrays.asList(
        "Piano Basics",
        "Music Theory I",
        "Digital Music Production",
        "Guitar for Beginners"
    ));

    // 体育类兴趣课程
    interestToCourses.put("sports", Arrays.asList(
        "Sports Nutrition",
        "Football Strategy",
        "Fitness & Strength Training",
        "Intro to Basketball Coaching"
    ));

    // 人工智能兴趣课程
    interestToCourses.put("ai", Arrays.asList(
        "Introduction to AI",
        "Machine Learning Basics",
        "Neural Networks for Beginners",
        "AI Ethics and Society"
    ));

    // 网络与通信兴趣课程
    interestToCourses.put("networking", Arrays.asList(
        "Computer Networks 101",
        "Network Security Fundamentals",
        "Cisco Routing & Switching",
        "Wireless Networking Concepts"
    ));
  }


    @Override
    public void getRecommendations(RecommendationRequest request, StreamObserver<RecommendationResponse> responseObserver) {

        // 用 Set 防止重复课程
        Set<String> recommendedCourses = new HashSet<>();

        // 获取兴趣列表
        for (String interest : request.getInterestsList()) {
            List<String> matched = interestToCourses.getOrDefault(interest.toLowerCase(), new ArrayList<>());
            recommendedCourses.addAll(matched);
        }

        // 构造响应对象
        RecommendationResponse response = RecommendationResponse.newBuilder()
                .addAllCourses(recommendedCourses)
                .build();

        // 返回响应结果给客户端
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
