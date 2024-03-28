package xyz.shi.shop.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GoodsApp {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class);
    }
}
