import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class mainclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String path = sc.nextLine();
        File file = new File(path);
        readNcreate_file(path, file);

    }

    public static void readNcreate_file(String path, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] item = line.split(",");
                write_file(file, item[0], Double.parseDouble(item[1]) * Double.parseDouble(item[2]));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void write_file(File file, String product, Double price) {
        String new_path = file.getParent() + "\\summary.csv";
        File check_file = new File(new_path);
        if (check_file.exists()) {
            String[] lines = new String[] { product, ", ", price.toString() + "\n" };

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new_path, true))) {
                for (String line : lines) {
                    bw.write(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            String[] lines = new String[] { product, ", ", price.toString() };

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new_path))) {
                for (String line : lines) {
                    bw.write(line);
                }
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}