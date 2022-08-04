package main;

/*
 * Spring provides class-level annotations in the org.springframework.stereotype package for configuring applications.
 * We will be using @Component annotation to add a bean to the Spring context.
 * */

import org.springframework.stereotype.Component;

@Component // Annotate the class for which the instance needs to be added to the context. In this case, we will annotate the Dog class.
public class Dog {

    // TODO: Use the @ComponentScan annotation over the configuration class and tell it where to look for classes annotated with stereotype annotations.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog {" +
                "name = '" + name + '\'' +
                '}';
    }
}