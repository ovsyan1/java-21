package copyFile;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        new FileUtils().copyTextFile("src/copyFile/source.txt", "src/copyFile/copy.txt");
    }

    void copyTextFile(String source, String fileName) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }

        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

}
