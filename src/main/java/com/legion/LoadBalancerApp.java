package main.java.com.legion;
import main.java.com.legion.algorithms.RoundRobinLoadBalancer;
import main.java.com.legion.context.LoadBalancerContext;
import main.java.com.legion.strategy.LoadBalancingStrategy;

import java.util.List;

public class LoadBalancerApp {
    public static void main(String args[]){

        List<String> servers = List.of("Server1", "Server2", "Server3");

        LoadBalancingStrategy strategy = new RoundRobinLoadBalancer();
        LoadBalancerContext context = new LoadBalancerContext(servers, strategy);

        for(int i = 0;i<10;i++){
            String server = context.getNextServer();
            System.out.println("Request sent to: " + server);
        }

    }
}
