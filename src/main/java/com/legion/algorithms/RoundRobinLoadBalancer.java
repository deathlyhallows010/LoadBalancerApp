package main.java.com.legion.algorithms;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.List;

public class RoundRobinLoadBalancer implements LoadBalancingStrategy {
    private int currentIndex = 0;

    @Override
    public String selectServer(List<String> servers){
        if (servers.isEmpty()){
            return null;
        }
        String server = servers.get(currentIndex);
        currentIndex = (currentIndex+1)%servers.size();
        return server;
    }
}
