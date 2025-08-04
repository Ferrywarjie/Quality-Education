package com.edusphere.learning;

/**
 *
 * @author Tan Wei Jie
 */

// LearningActivityClientGUI.java

// LearningActivityClientGUI.java

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * 学习活动客户端 GUI：允许学生提交学习记录至 gRPC 服务端。
 *
 */
public class LearningActivityClientGUI extends JFrame {

    // 用户界面输入控件
    private final JTextField studentIdField = new JTextField(10);
    private final JTextField activityTypeField = new JTextField(10);
    private final JTextField minutesField = new JTextField(10);
    private final JTextField dateField = new JTextField(10);
    private final JTextArea outputArea = new JTextArea(8, 30);

    // gRPC 通信相关
    private final ManagedChannel channel;
    private final LearningActivityServiceGrpc.LearningActivityServiceBlockingStub blockingStub;

    public LearningActivityClientGUI() {
        super("学习活动客户端");

         // 初始化 gRPC 通道（连接服务器 localhost:50051）
         channel = ManagedChannelBuilder.forAddress("localhost", 50051)
         .usePlaintext()
         .build();

         // 创建阻塞式 stub，设置调用超时为 300秒
         blockingStub = LearningActivityServiceGrpc.newBlockingStub(channel)
          .withDeadlineAfter(300, TimeUnit.SECONDS);

         // 构建图形界面
         JPanel panel = new JPanel(new GridLayout(5, 2));
         panel.add(new JLabel("学生 ID:"));
         panel.add(studentIdField);
         panel.add(new JLabel("活动类型:"));
         panel.add(activityTypeField);
         panel.add(new JLabel("分钟数:"));
         panel.add(minutesField);
         panel.add(new JLabel("日期 (yyyy-MM-dd):"));
         panel.add(dateField);

         JButton sendButton = new JButton("提交学习记录");
         panel.add(sendButton);

         // 按钮点击事件：提交数据至服务器
         sendButton.addActionListener(e -> {
         String studentId = studentIdField.getText().trim();
         String type = activityTypeField.getText().trim();
         String minutesRaw = minutesField.getText().trim();
         String date = dateField.getText().trim();

         // 简单字段检查
         if (studentId.isEmpty() || type.isEmpty() || minutesRaw.isEmpty()) {
             outputArea.setText("请完整填写学生 ID、活动类型和分钟数。");
             return;
         }

         try {
             int minutes = Integer.parseInt(minutesRaw);
             if (minutes <= 0) {
                 outputArea.setText("分钟数必须为正整数。");
                 return;
             }

             // 若未填写日期则默认使用当前日期
             if (date.isEmpty()) {
                 date = LocalDate.now().toString();
             }
 
             // 构造请求消息对象
             ActivityData request = ActivityData.newBuilder()
                 .setStudentId(studentId)
                 .setActivityType(type)
                 .setMinutes(minutes)
                 .setDate(date)
                 .build();

             // 调用服务方法 reportActivity
             ActivityAck response = blockingStub.reportActivity(request);

             // 显示返回结果
             outputArea.setText("结果：\n" + response.getMessage());

         } catch (NumberFormatException ex) {
             outputArea.setText("请输入有效的分钟数（正整数）。");
         } catch (StatusRuntimeException ex) {
             outputArea.setText("gRPC 通信错误：\n" +
                 ex.getStatus().getCode() + "\n" +
                 (ex.getStatus().getDescription() != null ? ex.getStatus().getDescription() : "未知错误"));
         } catch (Exception ex) {
             outputArea.setText("发生未知错误：" + ex.getMessage());
     }
 });

       // 窗口设置
       add(panel, BorderLayout.NORTH);
       add(new JScrollPane(outputArea), BorderLayout.CENTER);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
       setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LearningActivityClientGUI::new);
    }
}

