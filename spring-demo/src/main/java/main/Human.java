package main;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {
    private String name;
    private final Dog dog;

    /*
    When Spring looks at the constructor it searches for a Dog bean in its scope and invokes the constructor with the Dog bean.
    Notice that we have also set the dog field to final since the value is injected during object creation.
    This is the most common way we will be using the @Autowired annotation.
     */
    @Autowired
    public Human(Dog dog) {
        this.dog = dog;
    }

    // We can annotate the field directly without using a constructor.
    // This will create a link between the Human and Dog beans in the context.
    // This approach is not preferred because we can’t set the dog to be final which would allow anyone to change the value.
    // It is also more difficult to manage the initial value.
    /*
    @Autowired
    private Dog dog;
     */

    // We can use the @Autowired annotation on the setter of the field.
    // This approach has the same issues as the field annotation method
    // while also being more difficult to read which is why it is not used in production.
    /*
    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }
     */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Human {" +
                "name = '" + name + '\'' +
                ", dog = " + dog +
                '}';
    }
}