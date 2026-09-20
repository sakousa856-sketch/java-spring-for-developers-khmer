package com.example.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("databaseConnection")) {
            System.out.println("[BPP] 4. postProcessBeforeInitialization for: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("databaseConnection")) {
            System.out.println("[BPP] 7. postProcessAfterInitialization for: " + beanName + " (Proxy wrapping stage)");
        }
        return bean;
    }
}
