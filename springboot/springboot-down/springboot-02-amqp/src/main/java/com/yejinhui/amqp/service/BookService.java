package com.yejinhui.amqp.service;

import com.yejinhui.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-02-amqp
 * @description
 * @create 2018/10/16 19:27
 */
@Service
public class BookService {

    @RabbitListener(queues = {"yejinhui.news"})
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = {"yejinhui"})
    public void receive(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
