package main.java.com.legion.algorithms;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.ArrayList;
import java.util.List;

public class LeastResponseTImeLoadBalancer implements LoadBalancingStrategy {
    private List<Double> responseTime;

    public LeastResponseTImeLoadBalancer(List<Double> responseTimeWeights){
        this.responseTime = new ArrayList<>(responseTimeWeights.size());
        responseTime.addAll(responseTimeWeights);
    }
    @Override
    public String selectServer(List<String> servers){
        double minResponseTime = 0.0;
        int minIndex = 0;
        for (int i=1;i<responseTime.size();i++){
            if(responseTime.get(i)<minResponseTime){
                minResponseTime = responseTime.get(i);
                minIndex = i;
            }
        }
        return servers.get(minIndex);
    }
}
