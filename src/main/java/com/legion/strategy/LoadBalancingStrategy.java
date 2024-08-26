package main.java.com.legion.strategy;

import java.util.List;

public interface LoadBalancingStrategy {
    public String selectServer(List<String> servers);
}
