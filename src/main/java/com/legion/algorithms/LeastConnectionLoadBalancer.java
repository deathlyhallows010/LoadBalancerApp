package main.java.com.legion.algorithms;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastConnectionLoadBalancer implements LoadBalancingStrategy {
    private Map<String, Integer> serverConnections;

    public LeastConnectionLoadBalancer(List<String> servers){
        serverConnections = new HashMap<>();
        for (String server: servers){
            serverConnections.put(server,0);
        }
    }

    @Override
    public String selectServer(List<String> servers){
        return serverConnections.entrySet().stream().min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

}
