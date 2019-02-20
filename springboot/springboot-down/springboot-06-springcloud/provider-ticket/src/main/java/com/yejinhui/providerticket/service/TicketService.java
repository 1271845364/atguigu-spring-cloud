package com.yejinhui.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-06-springcloud
 * @description
 * @create 2018/11/7 19:28
 */
@Service
public class TicketService {
    public String getTicket() {
        System.out.println("8002");
        return "《厉害了，我的国》";
    }
}
