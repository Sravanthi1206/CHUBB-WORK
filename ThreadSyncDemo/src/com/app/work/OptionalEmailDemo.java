package com.app.work;

import java.util.Optional;

public class OptionalEmailDemo {

    //  Email field wrapped with Optional
    private Optional<String> email;

    // Constructor
    public OptionalEmailDemo(String email) {
        // Wrap email in Optional (handles null safely)
        this.email = Optional.ofNullable(email);
    }

    // Method to print email if present, else default
    public void printEmail() {
        // Option 1: using orElse()
        System.out.println("Email: " + email.orElse("No email provided"));

        // Option 2: using ifPresentOrElse (Java 9+)
        email.ifPresentOrElse(
            e -> System.out.println("Verified Email: " + e),
            () -> System.out.println("Default: No email found")
        );
    }

    // Getter (returns Optional)
    public Optional<String> getEmail() {
        return email;
    }

    // Setter (also accepts String safely)
    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    // Test main method
    public static void main(String[] args) {
        // Case 1: Email present
        OptionalEmailDemo user1 = new OptionalEmailDemo("user@example.com");
        user1.printEmail();

        // Case 2: Email missing (null)
        OptionalEmailDemo user2 = new OptionalEmailDemo(null);
        user2.printEmail();
    }
}
