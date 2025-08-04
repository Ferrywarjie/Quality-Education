package com.edusphere.progress;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * GUI 客户端：用于测试 ProgressTrackerService 的功能
 * 包含三种操作：
 * - 添加课程完成记录
 * - 查询课程是否完成
 * - 获取全部已完成课程列表
 */
public class ProgressTrackerClientGUI extends JFrame {

    private final JTextField userIdField = new JTextField(15);
    private final JTextField courseField = new JTextField(15);
    private final JTextArea outputArea = new JTextArea(8, 30);

    // gRPC 通信通道和服务 stub
    private final ManagedChannel channel;
    private final ProgressTrackerServiceGrpc.ProgressTrackerServiceBlockingStub blockingStub;

    public ProgressTrackerClientGUI() {
        super("学习进度跟踪客户端");

        // 初始化 gRPC 通道（端口要与你服务端对应）
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        blockingStub = ProgressTrackerServiceGrpc.newBlockingStub(channel);

        // GUI 布局配置
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("用户 ID："));
        inputPanel.add(userIdField);
        inputPanel.add(new JLabel("课程名称："));
        inputPanel.add(courseField);

        JButton recordButton = new JButton("记录进度");
        JButton checkButton = new JButton("检查课程是否完成");
        JButton listButton = new JButton("列出已完成课程");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(recordButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(listButton);

        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // 绑定按钮点击事件：记录进度
        recordButton.addActionListener(e -> {
            String userId = userIdField.getText().trim();
            String course = courseField.getText().trim();

            if (userId.isEmpty() || course.isEmpty()) {
                outputArea.setText("请填写用户 ID 和课程名");
                return;
            }

            ProgressRequest request = ProgressRequest.newBuilder()
                    .setUserId(userId)
                    .setCourseName(course)
                    .build();

            ProgressResponse response = blockingStub.recordProgress(request);
            outputArea.setText("记录结果：" + response.getMessage());
        });

        // 查询课程是否已完成
        checkButton.addActionListener(e -> {
            String userId = userIdField.getText().trim();
            String course = courseField.getText().trim();

            if (userId.isEmpty() || course.isEmpty()) {
                outputArea.setText("请填写用户 ID 和课程名");
                return;
            }

            ProgressQuery query = ProgressQuery.newBuilder()
                    .setUserId(userId)
                    .setCourseName(course)
                    .build();

            ProgressStatus status = blockingStub.checkProgress(query);
            outputArea.setText("课程 \"" + course + "\" 完成状态：" + (status.getCompleted() ? "✅ 已完成" : "❌ 未完成"));
        });

        // 列出已完成课程
        listButton.addActionListener(e -> {
            String userId = userIdField.getText().trim();
            if (userId.isEmpty()) {
                outputArea.setText("请填写用户 ID");
                return;
            }

            UserRequest req = UserRequest.newBuilder()
                    .setUserId(userId)
                    .build();

            CourseList result = blockingStub.listCompletedCourses(req);

            StringBuilder sb = new StringBuilder("已完成课程列表：\n");
            for (String course : result.getCourseNamesList()) {
                sb.append("✔ ").append(course).append("\n");
            }

            outputArea.setText(sb.toString());
        });

        // 基本窗口设置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // 主函数入口
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressTrackerClientGUI::new);
    }
}

