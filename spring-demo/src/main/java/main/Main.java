package main;

import config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    /*
     * We will be using the AnnotationConfigApplicationContext class to create the Spring context instance
     * since we are using annotations for configurations.
     * */
    public static void main(String[] args) {
        // create Spring context instance
        // We instantiate AnnotationConfigApplicationContext class with the MyConfig class.
        // This causes Spring to initialize the Dog instance and add it to its context which makes it a bean (any object managed by Spring).
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        // access the bean
        // The getBean method gets an instance of the Dog class from the Spring context.
        // Since there is a single Dog instance in the context we only need to specify the class of the instance we want to access.
        Human lily = context.getBean(Human.class);
        Dog luna = context.getBean(Dog.class);
        lily.setName("Lily");
        luna.setName("Luna");
        System.out.println(lily);
        System.out.println(luna);
    }
}
