import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOperations {
    public static void main(String[] args) throws IOException {

        String filePath = "Sample.txt";

        //Using Non-Functional Programming
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int indiaCountNF = 0;
        String line;

        while ((line = br.readLine()) != null) {
            String lower = line.toLowerCase();
            int index = 0;

            while ((index = lower.indexOf("india", index)) != -1) {
                indiaCountNF++;
                index += "india".length();
            }
        }
        br.close();

        System.out.println("Using Non Functional Programming");
        System.out.println("India is repeated " + indiaCountNF + " times");


        //Using Functional Programming 
        List<String> allLines = Files.readAllLines(Paths.get(filePath));

        long indiaCountFP = allLines.stream()
                .map(String::toLowerCase)
                .mapToLong(l -> l.split("india", -1).length - 1)
                .sum();

        System.out.println("Using Functional Programming");
        System.out.println("India is repeated " + indiaCountFP + " times");
    }
}
