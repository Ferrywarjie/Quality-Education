package com.edusphere.learning;
/**
 *
 * @author Tan Wei Jie
 */

import com.edusphere.learning.ActivityAck;
import com.edusphere.learning.ActivityData;
import com.edusphere.learning.ActivityRequest;
import com.edusphere.learning.LearningActivityServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现 gRPC 的 LearningActivity 服务逻辑
 */
public class LearningActivityImpl extends LearningActivityServiceGrpc.LearningActivityServiceImplBase {

    // 存储用户学习记录的内存数据库（Map<studentId, List<ActivityData>>）
    private final Map<String, List<ActivityData>> activityStore = new HashMap<>();

    /**
     * 处理 reportActivity 请求：将用户提交的活动存储到内存中
     */
    @Override
    public void reportActivity(ActivityData request, StreamObserver<ActivityAck> responseObserver) {
        String studentId = request.getStudentId();

        // 获取或创建该学生的活动记录列表
        activityStore.putIfAbsent(studentId, new ArrayList<>());
        activityStore.get(studentId).add(request);

        // 构造返回消息
        ActivityAck ack = ActivityAck.newBuilder()
                .setMessage("学习活动记录成功！")
                .build();

        // 返回响应
        responseObserver.onNext(ack);
        responseObserver.onCompleted();
    }

    /**
     * 处理 getRecentActivity 请求：以流方式返回该学生的所有活动记录
     */
    @Override
    public void getRecentActivity(ActivityRequest request, StreamObserver<ActivityData> responseObserver) {
        String studentId = request.getStudentId();

        List<ActivityData> records = activityStore.getOrDefault(studentId, new ArrayList<>());

        for (ActivityData data : records) {
            responseObserver.onNext(data);
        }

        responseObserver.onCompleted();
    }
}
