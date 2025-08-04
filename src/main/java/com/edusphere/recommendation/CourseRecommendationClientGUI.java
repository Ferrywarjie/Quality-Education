package com.edusphere.recommendation;

/**
 *
 * @author Tan Wei Jie
 */
// CourseRecommendationClientGUI.java


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 课程推荐客户端 GUI：允许学生输入兴趣列表和学号，从服务器获取推荐课程列表。
 * 与 course_recommendation.proto 文件中的定义一致：使用 GetRecommendations 方法并传入 RecommendationRequest（包含 student_id 和 repeated interests）
 */
public class CourseRecommendationClientGUI extends JFrame {

    // 用户输入组件：学号和兴趣（支持多个兴趣，用英文逗号隔开）
    private final JTextField studentIdField = new JTextField(10);
    private final JTextField interestsField = new JTextField(20);
    private final JTextArea outputArea = new JTextArea(8, 30);

    // gRPC 通信通道与 stub
    private final ManagedChannel channel;
    private final CourseRecommendationServiceGrpc.CourseRecommendationServiceBlockingStub blockingStub;

    public CourseRecommendationClientGUI() {
        super("课程推荐客户端");

        // 建立 gRPC 连接，连接本地 50051 端口
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // 创建阻塞式 stub，并设置调用超时（3 秒）
        blockingStub = CourseRecommendationServiceGrpc.newBlockingStub(channel)
                .withDeadlineAfter(300, TimeUnit.SECONDS);

        // 构建 Swing 界面
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("学生 ID:"));
        inputPanel.add(studentIdField);
        inputPanel.add(new JLabel("兴趣（用逗号分隔）:"));
        inputPanel.add(interestsField);
        JButton sendButton = new JButton("获取推荐课程");
        inputPanel.add(sendButton);

        // 点击按钮时执行调用逻辑
        sendButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String interestsRaw = interestsField.getText().trim();

            if (studentId.isEmpty() || interestsRaw.isEmpty()) {
                outputArea.setText("请输入学生 ID 和至少一个兴趣。");
                return;
            }

            // 解析兴趣字符串为列表（通过逗号）
            List<String> interests = Arrays.stream(interestsRaw.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();

            // 构造请求对象
            RecommendationRequest request = RecommendationRequest.newBuilder()
                    .setStudentId(studentId)
                    .addAllInterests(interests)
                    .build();

            try {
                // 发起 RPC 请求
                RecommendationResponse response = blockingStub.getRecommendations(request);
                List<String> courses = response.getCoursesList();

                // 显示返回结果
                if (courses.isEmpty()) {
                    outputArea.setText("未找到匹配课程。");
                } else {
                    outputArea.setText("推荐课程:\n" + String.join("\n", courses));
                }
            } catch (StatusRuntimeException ex) {
                outputArea.setText("通信错误: " + ex.getStatus().getCode() + "\n" + ex.getStatus().getDescription());
            }
        });

        // 添加界面元素
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseRecommendationClientGUI::new);
    }
}


