package io.shardingjdbc.example.spring.namespace.mybatis.service;

import cn.hutool.core.date.DateUtil;
import io.shardingjdbc.example.spring.namespace.mybatis.entity.*;
import io.shardingjdbc.example.spring.namespace.mybatis.repository.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DemoService {
    
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderItemRepository orderItemRepository;
    @Resource
    private SncGlucoseDataRepository glucoseDataRepository;
    @Resource
    private SncUserGlucoseDataRepository userGlucoseDataRepository;
    @Resource
    private SncDeviceGlucoseDataRepository deviceGlucoseDataRepository;

    public void demo() {
        orderRepository.createIfNotExistsTable();
        orderItemRepository.createIfNotExistsTable();

        orderRepository.truncateTable();
        orderItemRepository.truncateTable();

        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            order.setSn("2AH4A0R0039");
            order.setUserCode("wx_oIp5uws6l-8VnhoKzreg_5gJNjYI");
            order.setTestTime(new Date());
            orderRepository.insert(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            item.setStatus("INSERT_TEST");
            order.setSn("2AH4A0R0039");
            order.setUserCode("wx_oIp5uws6l-8VnhoKzreg_5gJNjYI");
            order.setTestTime(new Date());
            orderItemRepository.insert(item);
        }
        List<OrderItem> orderList = orderItemRepository.selectAll();
        orderList.forEach(System.out::println);

        System.out.println("2.Delete--------------");
        for (Long each : orderIds) {
            orderRepository.delete(each);
            orderItemRepository.delete(each);
        }
        System.out.println(orderItemRepository.selectAll());
        orderItemRepository.dropTable();
        orderRepository.dropTable();
    }


    public void glucoseData() {
        glucoseDataRepository.createIfNotExistsTable();
        glucoseDataRepository.truncateTable();

        List<Long> ids = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 100; i++) {
            SncGlucoseData glucoseData = new SncGlucoseData();
            glucoseData.setSn("2AH4A0R0039");
            glucoseData.setUserCode("wx_oIp5uws6l-8VnhoKzreg_5gJNjYI");
            String dateStr = "2014-01-01 22:33:23";
            Date date = DateUtil.parse(dateStr);
            glucoseData.setTestTime(DateUtil.offsetMonth(date, i));
            glucoseDataRepository.insert(glucoseData);
            long id = glucoseData.getId();
            ids.add(id);

        }
        List<SncGlucoseData> glucoseDataList = glucoseDataRepository.selectAll();
        glucoseDataList.forEach(System.out::println);
//
//        System.out.println("2.Delete--------------");
//        for (Long each : ids) {
//            glucoseDataRepository.delete(each);
//        }
//        System.out.println(glucoseDataRepository.selectAll());
//        glucoseDataRepository.dropTable();
    }

    public void userGlucoseData() {
        userGlucoseDataRepository.createIfNotExistsTable();
        userGlucoseDataRepository.truncateTable();

        List<Long> ids = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10000; i++) {
            SncUserGlucoseData glucoseData = new SncUserGlucoseData();
            glucoseData.setSn("2AH4A0R0039");
            glucoseData.setUserCode("wx_oIp5uws6l-8VnhoKzreg_5g" + i);
            glucoseData.setTestTime(new Date());
            userGlucoseDataRepository.insert(glucoseData);
            long id = glucoseData.getId();
            ids.add(id);

        }
        List<SncUserGlucoseData> glucoseDataList = userGlucoseDataRepository.selectAll();
        glucoseDataList.forEach(System.out::println);

//        System.out.println("2.Delete--------------");
//        for (Long each : ids) {
//            userGlucoseDataRepository.delete(each);
//        }
//        System.out.println(userGlucoseDataRepository.selectAll());
//        userGlucoseDataRepository.dropTable();
    }

    public void deviceGlucoseData() {
        deviceGlucoseDataRepository.createIfNotExistsTable();
        deviceGlucoseDataRepository.truncateTable();

        List<Long> ids = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 999; i++) {
            SncDeviceGlucoseData glucoseData = new SncDeviceGlucoseData();
            glucoseData.setSn("2AH4A0R0" + i);
            glucoseData.setUserCode("wx_oIp5uws6l-8VnhoKzreg_5gJNjYI");
            glucoseData.setTestTime(new Date());
            deviceGlucoseDataRepository.insert(glucoseData);
            long id = glucoseData.getId();
            ids.add(id);

        }
        List<SncDeviceGlucoseData> glucoseDataList = deviceGlucoseDataRepository.selectAll();
        glucoseDataList.forEach(System.out::println);

//        System.out.println("2.Delete--------------");
//        for (Long each : ids) {
//            deviceGlucoseDataRepository.delete(each);
//        }
//        System.out.println(deviceGlucoseDataRepository.selectAll());
//        deviceGlucoseDataRepository.dropTable();
    }
}
