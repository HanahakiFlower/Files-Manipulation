import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mainclass {
    public static void main(String[] args) {
        String path = "C:\\Users\\rober\\OneDrive\\Documentos\\FACULDADE\\original-file.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] item = line.split(",");
                line = br.readLine();
                System.out.println("Produto: " + item[0] );
                System.out.println("Preço: " + item[1] );
                System.out.println("Quantidade: " + item[2] );
                System.out.println("Total: " + Double.parseDouble(item[1]) * Double.parseDouble(item[2]));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
