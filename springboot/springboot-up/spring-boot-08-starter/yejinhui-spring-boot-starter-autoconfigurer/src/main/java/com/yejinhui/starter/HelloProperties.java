package com.yejinhui.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 15:53
 */
@ConfigurationProperties(value = "yejinhui.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
