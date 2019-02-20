package com.yejinhui.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-04-task
 * @description
 * @create 2018/10/18 10:26
 */
@Service
public class ScheduleService {

    /**
     * second（秒），minute（分）, hour（时）, day of month（日）, month（月），day of week（周几）
     * 示例：0 * * * * MON-FRI
     *
     * cron表达式：
     * 字段 允许值 允许的特殊字符
     * 秒 0-59 , - * /
     * 分 0-59 , - * /
     * 小时 0-23 , - * /
     * 日期 1-31 , - * ? / L W C
     * 月份 1-12 , - * /
     * 星期 0-7或SUN-SAT 0,7是SUN , - * ? / L C #
     *
     * 特殊字符 代表含义
     * , 枚举
     * - 区间
     * * 任意
     * / 步长
     * ? 日/星期冲突匹配
     * L 最后
     * W 工作日
     * C 和calendar联系后计算过的值
     * # 星期， 4#2，第2个星期四
     *
     *
     * 【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     * 【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     * 【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     * 【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     *
     */
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/5 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello...");
    }

}
