package main.java.com.legion.context;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.List;

public class LoadBalancerContext {
    private List<String> serverPool;
    private LoadBalancingStrategy strategy;

    public LoadBalancerContext(List<String> serverPool, LoadBalancingStrategy strategy){
        this.serverPool = serverPool;
        this. strategy = strategy;
    }

    public String getNextServer(){
        return strategy.selectServer(serverPool);
    }
}
