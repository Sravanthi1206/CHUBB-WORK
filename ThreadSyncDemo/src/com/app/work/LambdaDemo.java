package com.app.work;

import java.util.Optional;

@FunctionalInterface
interface Greet {
    void sayHello(String name);
    // You could also add a default method if needed
    // default void sayHello1(String name) {
    //     System.out.println("Hi " + name);
    // }
}

@FunctionalInterface
interface Calculation {
    int add(int i, int j);
}

public class LambdaDemo {
    public static void main(String[] args) {

        //  Lambda for Greet interface
        Greet greet = (name) -> {
            System.out.println("Hello " + name + "!");
        };
        greet.sayHello("Aashish");

        //  Lambdas for Calculation interface
        Calculation add = (i, j) -> i + j;
        Calculation multiply = (i, j) -> i * j;

        LambdaDemo obj = new LambdaDemo();

        //  Pass lambda as parameter
        obj.print(multiply);

        //  Optional handling
        obj.checkOption();

        //  Using Optional with getName()
        Optional<String> name = Optional.ofNullable(obj.getName());

        // Safe check
        name.ifPresentOrElse(
            n -> System.out.println("Name: " + n),
            () -> System.out.println("No name present")
        );
    }

    public void print(Calculation cobj) {
        System.out.println("Calculation result: " + cobj.add(3, 4));
    }

    public void checkOption() {
        Optional<String> name = Optional.ofNullable(null);

        System.out.println("Is Present: " + name.isPresent());

        String result = name.orElse("Default Name");
        System.out.println("Result: " + result);

        name.ifPresent(n -> System.out.println("Hello " + n));

        Optional<String> city = Optional.of("Mumbai");
        System.out.println(city.orElseGet(() -> "Unknown City"));
        System.out.println(city.orElseThrow(() -> new RuntimeException("No city found")));
    }

    public String getName() {
        return null; // simulate no name found
    }
}
