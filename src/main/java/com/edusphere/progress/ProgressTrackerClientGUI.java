package com.edusphere.progress;

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
import java.util.concurrent.TimeUnit;

/**
 * ProgressTrackerClientGUI
 * 学习进度跟踪服务的 GUI 客户端实现，用于测试并互动访问 ProgressTrackerService
 * 支持操作:
 * ✓ 记录进度
 * ✓ 查询进度
 * ✓ 列出所有完成的课程
 */
public class ProgressTrackerClientGUI extends JFrame {

    // 用户输入组件
    private final JTextField userIdField = new JTextField(15);
    private final JTextField courseField = new JTextField(15);
    private final JTextArea outputArea = new JTextArea(8, 30);

    // gRPC 通信通道和 stub
    private final ManagedChannel channel;

    public ProgressTrackerClientGUI() {
        super("学习进度跟踪客户端");

         // 初始化 gRPC 通道：连接 localhost:50051
 channel = ManagedChannelBuilder.forAddress("localhost", 50051)
         .usePlaintext()
         .build();

         // 构造界面布局
         setLayout(new BorderLayout());

         JPanel inputPanel = new JPanel(new GridLayout(3, 2));
         inputPanel.add(new JLabel("用户 ID："));
         inputPanel.add(userIdField);
         inputPanel.add(new JLabel("课程名称："));
         inputPanel.add(courseField);

         JButton recordButton = new JButton("记录进度");
         JButton checkButton = new JButton("查询课程是否完成");
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

         // 1. 记录进度操作
         recordButton.addActionListener(e -> {
         String userId = userIdField.getText().trim();
         String course = courseField.getText().trim();

         if (userId.isEmpty() || course.isEmpty()) {
           outputArea.setText("请填写用户 ID 和课程名");
            return;
         }

         try {
           ProgressRequest request = ProgressRequest.newBuilder()
                 .setUserId(userId)
                 .setCourseName(course)
                 .build();

            ProgressTrackerServiceGrpc.ProgressTrackerServiceBlockingStub stub =
                 ProgressTrackerServiceGrpc.newBlockingStub(channel).withDeadlineAfter(3, TimeUnit.SECONDS);

            ProgressResponse response = stub.recordProgress(request);
              outputArea.setText("记录结果：" + response.getMessage());
               } catch (StatusRuntimeException ex) {
                 outputArea.setText("通信错误：" + ex.getStatus().getCode());
               } catch (Exception ex) {
                   outputArea.setText("发生异常：" + ex.getMessage());
              }
     });

     // 2. 查询课程是否完成
     checkButton.addActionListener(e -> {
     String userId = userIdField.getText().trim();
     String course = courseField.getText().trim();

     if (userId.isEmpty() || course.isEmpty()) {
         outputArea.setText("请填写用户 ID 和课程名");
         return;
     }

     try {
         ProgressQuery query = ProgressQuery.newBuilder()
                 .setUserId(userId)
                 .setCourseName(course)
                 .build();

         ProgressTrackerServiceGrpc.ProgressTrackerServiceBlockingStub stub =
                 ProgressTrackerServiceGrpc.newBlockingStub(channel).withDeadlineAfter(3, TimeUnit.SECONDS);

         ProgressStatus status = stub.checkProgress(query);
         outputArea.setText("课程 \"" + course + "\" 完成状态：" + (status.getCompleted() ? "已完成" : "未完成"));
         } catch (StatusRuntimeException ex) {
             outputArea.setText("通信错误：" + ex.getStatus().getCode());
          } catch (Exception ex) {
               outputArea.setText("异常错误：" + ex.getMessage());
       }
     });

          // 3. 列出所有完成课程
         listButton.addActionListener(e -> {
          String userId = userIdField.getText().trim();
           if (userId.isEmpty()) {
            outputArea.setText("请填写用户 ID");
              return;
         }

         try {
           UserRequest req = UserRequest.newBuilder()
                 .setUserId(userId)
                 .build();

            ProgressTrackerServiceGrpc.ProgressTrackerServiceBlockingStub stub =
                 ProgressTrackerServiceGrpc.newBlockingStub(channel).withDeadlineAfter(3, TimeUnit.SECONDS);

            CourseList result = stub.listCompletedCourses(req);

             if (result.getCourseNamesCount() == 0) {
                  outputArea.setText("没有完成的课程。");
             } else {
                  StringBuilder sb = new StringBuilder("已完成课程列表：\n");
                     for (String course : result.getCourseNamesList()) {
                       sb.append(" - ").append(course).append("\n");
                   }
                outputArea.setText(sb.toString());
             }
           } 
               catch (StatusRuntimeException ex) {
                 outputArea.setText("通信错误：" + ex.getStatus().getCode());
               } catch (Exception ex) {
         outputArea.setText("异常错误：" + ex.getMessage());
       }
     });

      // 基本窗口设置
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressTrackerClientGUI::new);
    }
}
