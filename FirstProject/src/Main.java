import java.io.*;

// Custom checked exception
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

// Custom unchecked  exception
class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}

public class Main {

    // Method that throws a checked exception
    static void checkAge(int age) throws CustomCheckedException {
        if (age < 18) {
            throw new CustomCheckedException("Age must be 18 or above!");
        } else {
            System.out.println("You are eligible!");
        }
    }

    public static void main(String[] args) {
        // Basic try-catch
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }

        //  Try with multiple catch blocks
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }

        //  Divide by zero exception
        try {
            int num = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception: Divide by zero is not allowed.");
        }

        //  ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index out of bound!");
        }

        //  FileNotFoundException
        try {
            FileReader fr = new FileReader("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found!");
        }

        //  IOException
        try {
            File file = new File("test.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("Hello");
            fw.close();
            FileReader fr = new FileReader(file);
            fr.close();
            throw new IOException("Manual IO Error for demo");
        } catch (IOException e) {
            System.out.println("Exception: IO Error - " + e.getMessage());
        }

        //  Custom Checked Exception
        try {
            checkAge(16);
        } catch (CustomCheckedException e) {
            System.out.println("Custom Checked Exception: " + e.getMessage());
        }

        // Custom Runtime Exception
        try {
            throw new CustomRuntimeException("This is a custom runtime exception!");
        } catch (CustomRuntimeException e) {
            System.out.println("Custom Runtime Exception: " + e.getMessage());
        }

        // throw and throws demonstration
        try {
            mayThrowException(true);
        } catch (Exception e) {
            System.out.println("Caught exception using throws: " + e.getMessage());
        }

        System.out.println("Program completed successfully.");
    }

    // Method demonstrating 'throws'
    static void mayThrowException(boolean shouldThrow) throws Exception {
        if (shouldThrow) {
            throw new Exception("Something went wrong inside mayThrowException()");
        }
    }
}
