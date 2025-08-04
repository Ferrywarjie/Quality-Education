package com.edusphere.learning;

/**
 *
 * @author Tan Wei Jie
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class LearningActivityClientGUI extends JFrame {

    private JTextField studentIdField;
    private JTextField activityTypeField;
    private JTextField minutesField;
    private JTextArea outputArea;

    private final ManagedChannel channel;
    private final LearningActivityServiceGrpc.LearningActivityServiceStub asyncStub;
    private final LearningActivityServiceGrpc.LearningActivityServiceBlockingStub blockingStub;

    public LearningActivityClientGUI() {
        // 建立连接到 gRPC 服务器
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        asyncStub = LearningActivityServiceGrpc.newStub(channel);
        blockingStub = LearningActivityServiceGrpc.newBlockingStub(channel);

        initUI();
    }

    private void initUI() {
        setTitle("学习活动客户端");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("学生 ID:"));
        studentIdField = new JTextField();
        inputPanel.add(studentIdField);

        inputPanel.add(new JLabel("活动类型:"));
        activityTypeField = new JTextField();
        inputPanel.add(activityTypeField);

        inputPanel.add(new JLabel("学习分钟:"));
        minutesField = new JTextField();
        inputPanel.add(minutesField);

        JButton submitButton = new JButton("提交活动");
        submitButton.addActionListener(e -> sendActivity());
        inputPanel.add(submitButton);

        JButton fetchButton = new JButton("获取记录");
        fetchButton.addActionListener(e -> fetchActivity());
        inputPanel.add(fetchButton);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void sendActivity() {
        String id = studentIdField.getText();
        String type = activityTypeField.getText();
        int minutes = Integer.parseInt(minutesField.getText());

        ActivityData data = ActivityData.newBuilder()
                .setStudentId(id)
                .setActivityType(type)
                .setMinutes(minutes)
                .setDate(LocalDate.now().toString())
                .build();

        asyncStub.reportActivity(data, new StreamObserver<ActivityAck>() {
            @Override
            public void onNext(ActivityAck value) {
                outputArea.append("服务器回应: " + value.getMessage() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                outputArea.append("错误: " + t.getMessage() + "\n");
            }

            @Override
            public void onCompleted() {
                outputArea.append("提交完成。\n");
            }
        });
    }

    private void fetchActivity() {
        String id = studentIdField.getText();
        ActivityRequest request = ActivityRequest.newBuilder()
                .setStudentId(id)
                .build();

        outputArea.append("获取记录中...\n");

        try {
            blockingStub.getRecentActivity(request).forEachRemaining(activity -> {
                outputArea.append("" + activity.getActivityType()
                        + " - " + activity.getMinutes()
                        + "分钟 - " + activity.getDate() + "\n");
            });
        } catch (Exception e) {
            outputArea.append("查询失败: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LearningActivityClientGUI client = new LearningActivityClientGUI();
            client.setVisible(true);
        });
    }
}
