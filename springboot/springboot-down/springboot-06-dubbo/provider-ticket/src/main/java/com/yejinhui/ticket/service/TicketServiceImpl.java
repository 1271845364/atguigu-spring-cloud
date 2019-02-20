package com.yejinhui.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author ye.jinhui
 * @project springboot-06-dubbo
 * @description
 * @create 2018/11/6 11:13
 */
@Component
@Service    //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
