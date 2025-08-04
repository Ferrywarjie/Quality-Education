package com.edusphere.jmdns;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * jmDNS 工具类：用于服务注册与发现
 */
public class jmDNS {

    /**
     * 注册 gRPC 服务到本地局域网（通过 Bonjour/mDNS）
     *
     * @param serviceType "_grpc._tcp.local."
     * @param serviceName 服务名称
     * @param port        服务端口
     * @param description 服务描述
     */
    public static void registerService(String serviceType, String serviceName, int port, String description) {
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = ServiceInfo.create(
                    serviceType,
                    serviceName,
                    port,
                    description != null ? description : "No description"
            );

            jmdns.registerService(serviceInfo);

            System.out.printf("服务已注册：%s (%s:%d)\n",
                    serviceName,
                    InetAddress.getLocalHost().getHostAddress(),
                    port);
        } catch (IOException e) {
            System.err.println("服务注册失败：" + e.getMessage());
        }
    }

    /**
     * 客户端查找指定类型的 gRPC 服务（第一个找到的）
     *
     * @param serviceType "_grpc._tcp.local."
     * @param timeoutSec  超时时间（秒）
     * @return ServiceInfo，失败返回 null
     */
    public static ServiceInfo discoverService(String serviceType, int timeoutSec) {
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            final ServiceInfo[] foundService = new ServiceInfo[1];
            CountDownLatch latch = new CountDownLatch(1);

            jmdns.addServiceListener(serviceType, new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    jmdns.requestServiceInfo(event.getType(), event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {}

                @Override
                public void serviceResolved(ServiceEvent event) {
                    foundService[0] = event.getInfo();
                    latch.countDown();
                }
            });

            latch.await(timeoutSec, TimeUnit.SECONDS);
            jmdns.close();

            if (foundService[0] != null) {
                System.out.printf("发现服务：%s:%d\n",
                        foundService[0].getHostAddresses()[0],
                        foundService[0].getPort());
            } else {
                System.out.println("服务发现超时或失败。");
            }

            return foundService[0];
        } catch (Exception e) {
            System.err.println("服务发现异常：" + e.getMessage());
            return null;
        }
    }
}
