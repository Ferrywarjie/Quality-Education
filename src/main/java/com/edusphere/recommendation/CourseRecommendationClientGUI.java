package com.edusphere.recommendation;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

/**
 * 课程推荐客户端图形界面
 * 通过用户输入兴趣标签，发送请求给 gRPC 服务，接收并展示推荐课程
 */
public class CourseRecommendationClientGUI extends JFrame {

    private JTextField interestsField;
    private JTextArea resultArea;
    private JButton sendButton;

    // 构造方法：创建界面和 gRPC 调用逻辑
    public CourseRecommendationClientGUI() {
        setTitle("课程推荐系统客户端");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 输入面板（上部）
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("请输入兴趣（用逗号分隔）："));
        interestsField = new JTextField(30);
        inputPanel.add(interestsField);

        // 结果展示区域（中部）
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // 按钮面板（下部）
        JPanel buttonPanel = new JPanel(new FlowLayout());
        sendButton = new JButton("获取推荐课程");
        buttonPanel.add(sendButton);

        // 添加各部分到界面
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 设置按钮点击逻辑（发送请求到 gRPC）
        sendButton.addActionListener((ActionEvent e) -> {
            // 从文本框获取用户输入的兴趣
            String interestText = interestsField.getText().trim();
            if (interestText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入至少一个兴趣！");
                return;
            }

            // 将兴趣字符串按逗号分割，生成列表
            List<String> interests = Arrays.asList(interestText.split("\\s*,\\s*"));

            // 创建 gRPC 渠道连接（连接到本地服务端）
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();

            // 创建 gRPC stub，用于发送请求
            CourseRecommendationServiceGrpc.CourseRecommendationServiceBlockingStub stub =
                    CourseRecommendationServiceGrpc.newBlockingStub(channel);

            // 构造请求对象
            RecommendationRequest request = RecommendationRequest.newBuilder()
                    .addAllInterests(interests)
                    .setStudentId("student123")  // 这里只是示例 ID
                    .build();

            // 发送请求并获取响应（同步调用）
            RecommendationResponse response = stub.getRecommendations(request);

            // 将返回的课程展示到文本框中
            resultArea.setText("推荐课程：\n");
            for (String course : response.getCoursesList()) {
                resultArea.append("• " + course + "\n");
            }

            // 关闭连接
            channel.shutdown();
        });
    }

    // 主方法：运行界面
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CourseRecommendationClientGUI gui = new CourseRecommendationClientGUI();
            gui.setVisible(true);
        });
    }
}
