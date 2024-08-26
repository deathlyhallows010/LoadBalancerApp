package main.java.com.legion.algorithms;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.ArrayList;
import java.util.List;

public class HashLoadBalancing implements LoadBalancingStrategy {
    private List<Integer> hashServer;
    private int currentClientIndex = 0;

    public HashLoadBalancing(List<String> clientIp){
        this.hashServer = new ArrayList<>();
        for(String s: clientIp){
            hashServer.add(s.hashCode());
        }
    }
    @Override
    public String selectServer(List<String> servers){
        int serverIndex = Math.abs(hashServer.get(currentClientIndex))%servers.size();
        currentClientIndex = (currentClientIndex+1)% hashServer.size();
        return servers.get(serverIndex);

    }

}
