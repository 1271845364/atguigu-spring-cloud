package com.yejinhui.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * SpringBoot默认支持两种技术来和ES交互
 * 1、Jest（默认不生效）
 *      需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2、SpringData Elasticsearch【es版本不合适】
 *     版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *     spring data elasticsearch	elasticsearch
 *          3.1.x	                    6.2.2
 *          3.0.x	                    5.5.0
 *          2.1.x	                    2.4.0
 *          2.0.x	                    2.2.0
 *          1.3.x	                    1.5.2
 *     如果版本不适配：2.4.6
 *          a）、升级SpringBoot版本
 *          b）、安装对应版本的es
 *
 *     1）、Client 节点信息：clusterName clusterNodes
 *     2）、ElasticsearchTemplate 操作 es
 *     3）、编写一个 ElasticsearchRepository 的子接口来操作 es
 *两种用法：https://github.com/spring-projects/spring-data-elasticsearch
 * 1、编写一个 ElasticsearchRepository 的子接口
 * 2、
 *
 * @author ye.jinhui
 * @project springboot-03-elastic
 * @description
 * @create 2018/10/17 15:27
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
