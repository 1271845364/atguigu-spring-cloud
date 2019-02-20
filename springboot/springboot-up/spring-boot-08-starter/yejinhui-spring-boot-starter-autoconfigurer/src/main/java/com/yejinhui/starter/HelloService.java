package com.yejinhui.starter;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 15:52
 */
public class HelloService {

    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloYejinhui(String name) {
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }

}
