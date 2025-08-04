package com.edusphere.progress;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.stub.StreamObserver;
import java.util.*;

/**
 * ProgressTrackerService 的服务端实现类
 * 提供用户进度记录与查询功能
 */
public class ProgressTrackerImpl extends ProgressTrackerServiceGrpc.ProgressTrackerServiceImplBase {

    /**
     * 使用内存中的 Map 模拟数据库存储用户完成课程的信息
     * key：user_id，value：Set<String> 表示完成的课程名集合
     */
    private final Map<String, Set<String>> userProgressMap = new HashMap<>();

    /**
     * 记录进度：将某个用户完成的课程添加到内存数据库中
     */
    @Override
    public void recordProgress(ProgressRequest request, StreamObserver<ProgressResponse> responseObserver) {
        String userId = request.getUserId();
        String courseName = request.getCourseName();

        // 获取该用户的课程集合，如果不存在则初始化
        userProgressMap.putIfAbsent(userId, new HashSet<>());
        Set<String> completedCourses = userProgressMap.get(userId);

        boolean alreadyCompleted = completedCourses.contains(courseName);
        String message;

        if (alreadyCompleted) {
            message = "你已经完成过这门课程：" + courseName;
        } else {
            completedCourses.add(courseName);
            message = "课程已成功记录：" + courseName;
        }

        ProgressResponse response = ProgressResponse.newBuilder()
                .setSuccess(true)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 查询进度：检查某门课程是否已完成
     */
    @Override
    public void checkProgress(ProgressQuery request, StreamObserver<ProgressStatus> responseObserver) {
        String userId = request.getUserId();
        String courseName = request.getCourseName();

        boolean completed = userProgressMap.getOrDefault(userId, Collections.emptySet())
                .contains(courseName);

        ProgressStatus status = ProgressStatus.newBuilder()
                .setCompleted(completed)
                .build();

        responseObserver.onNext(status);
        responseObserver.onCompleted();
    }

    /**
     * 获取已完成的全部课程列表
     */
    @Override
    public void listCompletedCourses(UserRequest request, StreamObserver<CourseList> responseObserver) {
        String userId = request.getUserId();

        Set<String> completed = userProgressMap.getOrDefault(userId, Collections.emptySet());

        CourseList courseList = CourseList.newBuilder()
                .addAllCourseNames(completed)
                .build();

        responseObserver.onNext(courseList);
        responseObserver.onCompleted();
    }
}
