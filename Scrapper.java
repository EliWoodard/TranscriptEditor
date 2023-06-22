import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Scrapper {
    public static void main(String[] args) {

        String inputFilePath = "input/input.txt";
        String outputFilePath = "output/output.txt";

        try {
            String content = readFile(inputFilePath);
            String modifiedContent = removeBracketsAndNewlines(content);
            writeFile(outputFilePath, modifiedContent);
            System.out.println("Modified content has been written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    private static String removeBracketsAndNewlines(String content) {
        // Remove brackets and their contents using regex
        content = content.replaceAll("\\{[^\\}]*\\}", "");
        content = content.replaceAll("\\([^\\)]*\\)", "");
        content = content.replaceAll("\\[[^\\]]*\\]", "");

        // Remove newlines
        content = content.replace("\n", "");

        return content;
    }
}
