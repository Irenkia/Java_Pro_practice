package com.example.practice81;
@MyContainerScan
@MyComponent
public class MyBeanConsumer {
    public MyBeanConsumer(MyBean myBean) {
        System.out.println("MyBeanConsumer created");
        System.out.println("myBean hashcode = " + myBean.hashCode());
    }
}
