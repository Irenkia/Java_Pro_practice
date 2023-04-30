package com.example.practice81;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

@Configuration
public class MyConfiguration {
    private Map<Class, Object> beans;
//    @Autowired
//    private MyBean myBean;
//
//    @Autowired
//    public MyConfiguration setMyBean(MyBean myBean) {
//        this.myBean = myBean;
//    }

    public MyConfiguration() {
        Annotation a = MyConfiguration.class.getAnnotation(Configuration.class);
        System.out.println(a);

        Annotation a1 = MyBean.class.getDeclaredAnnotation(MyContainerScan.class);
        System.out.println(a1);
        Annotation b1 = MyBean.class.getDeclaredAnnotation(MyComponent.class);
        System.out.println(b1);

        Annotation a2 = MyBeanConsumer.class.getDeclaredAnnotation(MyContainerScan.class);
        System.out.println(a2);
        Annotation b2 = MyBeanConsumer.class.getDeclaredAnnotation(MyComponent.class);
        System.out.println(b2);

        Annotation a3 = TimeService.class.getDeclaredAnnotation(MyContainerScan.class);
        System.out.println(a3);
        Annotation b3 = TimeService.class.getDeclaredAnnotation(MyComponent.class);
        System.out.println(b3);

        Annotation a4 = Student.class.getDeclaredAnnotation(MyContainerScan.class);
        System.out.println(a4);

        Annotation a5 = Person.class.getDeclaredAnnotation(MyContainerScan.class);
        System.out.println(a5);
    }


    public static MyConfiguration createContext(Class clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Class c1 = Class.forName("MyBean");
            Object obj1 = c1.newInstance();
            Class c2 = Class.forName("MyBeanConsumer");
            Object obj2 = c1.newInstance();
            Class c3 = Class.forName("Student");
            Object obj3 = c1.newInstance();
            Class c4 = Class.forName("Person");
            Object obj4 = c1.newInstance();
            var context = new MyConfiguration();
            context.beans.put(c1, obj1);
            context.beans.put(c2, obj2);
            context.beans.put(c3, obj3);
            context.beans.put(c4, obj4);
            return context;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return null;
        }catch (InstantiationException e){
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBeanConsumer myBeanConsumer() {
        MyBeanConsumer myBeanConsumer = new MyBeanConsumer(myBean());
        return myBeanConsumer;
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Person person() {
        Person person = new Person(student());
        return person;
    }

}
