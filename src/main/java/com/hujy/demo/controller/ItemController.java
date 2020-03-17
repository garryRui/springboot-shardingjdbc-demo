package com.hujy.demo.controller;

import com.hujy.demo.entity.OrderItem;
import com.hujy.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ItemController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/test")
    public String test(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId("10".hashCode());
        orderItem.setRemark("tes1t");
        orderItem.setCreateTime(new Date());
       orderService.saveOrderItem(orderItem,1);

        return "ss";
    }

    @RequestMapping("/get")
    public OrderItem getOrderItem(){
       return  orderService.selectByOrderId(1);
    }

    public static void main(String[] args) {
        System.out.println(Math.abs("10aacc1323dfdfsdfsdf".hashCode()));
    }
}
