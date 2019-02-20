package com.yejinhui.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yejinhui.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-06-dubbo
 * @description
 * @create 2018/11/6 11:16
 */
@Service
public class UserService {


    @Reference  //全类名引用
    private TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了：" + ticket);
    }
}
