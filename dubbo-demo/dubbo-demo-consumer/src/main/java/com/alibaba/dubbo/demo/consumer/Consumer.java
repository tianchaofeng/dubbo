package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        for(int i=0;i<30;i++){
        	
        	String hello = demoService.sayHello("world"+i); // 执行远程方法
        	
        	System.err.println("=======================");
        	System.err.println("=======================");
        	System.err.println(hello); // 显示调用结果
        	System.err.println("=======================");
        	System.err.println("=======================");
        }
    }
}
