package main.java.com.legion.strategy;

import java.util.List;

public interface LoadBalancingStrategy {
    String selectServer(List<String> servers);
}
