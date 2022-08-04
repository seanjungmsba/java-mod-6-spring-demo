package config;

import main.Dog;
import main.Human;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main")
// Spring will create the instance for us which means we can’t set the name property
// on the Dog instance during instantiation.
// Instead, we will get the Dog instance after Spring creates it and set the name property.
public class MyConfig {
    /* When a method in a configuration class returns an object instance and is annotated with @Bean,
       Spring calls the method and manages it in its context.

       The methods used for adding beans are named using nouns instead of verbs
       since these methods are used for representing the object instances Spring manages. */
    @Bean
    // The @Bean annotation tells Spring to call this method when it initializes the context and store the returned value in its context.
    public Dog dog() {
        Dog d = new Dog();
        d.setName("Luna");
        return d;
    }

    // We need to define the methods for creating the Human and Dog beans before we can create a relationship between them.
    /*
    @Bean
    public Human human() {
        Human h = new Human();
        h.setName("Lily");
        return h;
    }
     */

    // We will be calling the dog() method in the human() method and setting the dog property of the Human instance.
    /*
    @Bean
    public Human human() {
        Human h = new Human();
        h.setName("Lily");
        h.setDog(dog());
        return h;
    }
     */

    // We can also define a Dog parameter for the human() method which will cause Spring to
    // automatically reference the Dog bean in its context and assign it to the Human bean’s dog property.
    @Bean
    public Human human(Dog dog) {
        Human h = new Human();
        h.setName("Lily");
        h.setDog(dog);
        return h;
    }
    // when human() method is called, it sees that the method requires a Dog instance so it checks its context for one
    // and injects the Dog instance into the parameter of the human() method.
}