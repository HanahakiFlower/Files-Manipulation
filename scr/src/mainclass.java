import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainclass {
    public static void main(String[] args) {

        File filePath = new File("C:\\Users\\rober\\OneDrive\\Documentos\\FACULDADE\\original-file.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line.split(","));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
