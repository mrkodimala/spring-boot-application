package com.mrkodimala;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

/**
 * @SpringBootApplication will inturn adds the below Annotations
 * @Configuration
 * @EnableAutoConfiguration
 * @EnableWebMvc
 * @ComponentScan
 *
 * Read about the above tags and update the docs for it.
 */
@SpringBootApplication
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }

    /**
     * This is just for printing the beans loaded, there is particular functionality
     * for the below bean
     * @param context
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context){
        return args -> {
            String []beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
