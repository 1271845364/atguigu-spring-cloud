package com.yejinhui.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.servo.jsr166e.ThreadLocalRandom;

/**
 * 问题：依旧轮询策略，但是加上新需求，每个服务器要求被调用5次。也即
 * 以前是每天服务器一次，现在每台机器5次
 * 
 * @author ye.jinhui
 * @date 2018年11月16日
 */
public class RandomRule_YJH extends AbstractLoadBalancerRule {

    /**
     * total = 0;	//当total == 5以后，我们指针才往下走
     * currentIndex = 0;	//当前对外提供服务的服务器处理地址
     * total需要重新置为0，但是已经到达过一个5次，我们的currentIndex = 1
     * 分析：我们5次，但是微服务只有8001、8002、8003三台，OK？
     * 
     * Randomly choose from all living servers
     */
	
	private int total = 0;	//总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0;	//当前提供服务的机器号
	
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);

//            private int total = 0;	//总共被调用的次数，目前要求每台被调用5次
//        	  private int currentIndex = 0;	//当前提供服务的机器号
            if(total < 5) {
            	server = upList.get(currentIndex);
            	total++;
            }else{
            	total = 0;
            	currentIndex++;
            	if(currentIndex >= upList.size()) {
            		currentIndex = 0;
            	}
            }
            
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}