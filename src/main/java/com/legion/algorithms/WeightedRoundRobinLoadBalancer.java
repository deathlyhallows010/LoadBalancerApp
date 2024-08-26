package main.java.com.legion.algorithms;

import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.List;

public class WeightedRoundRobinLoadBalancer implements LoadBalancingStrategy {
    private List<Integer> weights ;
    private int currentIndex;
    private int currentWeight;

    public WeightedRoundRobinLoadBalancer(List<Integer> weights) {
        this.currentWeight = 0;
        this.currentIndex = -1;
        this.weights = weights;
    }

    @Override
    public String selectServer(List<String> servers){
        while(true){
            currentIndex = (currentIndex+1)%servers.size();
            if(currentIndex ==0){
                currentWeight--;
                if (currentWeight <=0){
                    currentWeight = getMaxWeight();
                }
            }
            if (weights.get(currentIndex) >= currentWeight){
                return servers.get(currentIndex);
            }
        }
    }

    private int getMaxWeight() {
        return weights.stream().max(Integer::compare).orElse(0);
    }
}
