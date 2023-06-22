import java.io.*;
import java.util.*;

public class UpdateCaptions {
    public static void main(String[] args) throws IOException {
        String inputFile = "input/captions.sbv"; // input caption file
        String outputFile = "output/captions.sbv"; // output caption file
        String updatedTextFile = "input/updatedText.txt"; // updated text file

        // Read updated text from file
        String updated = new Scanner(new File(updatedTextFile)).useDelimiter("\\Z").next();
        List<String> lines = new ArrayList<>();

        // Read captions from SBV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            StringBuilder caption = new StringBuilder();
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    // Empty line indicates the end of a caption slot
                    String original = caption.toString().trim();
                    String[] words = original.split("\\s");
                    if (words.length >= 2) {
                        String firstWord = words[0];
                        String lastWord = words[words.length - 1];
                        if (updated.startsWith(firstWord) && updated.endsWith(lastWord)) {
                            // Extract updated text
                            int endIndex = updated.lastIndexOf(lastWord) + lastWord.length();
                            String newText = updated.substring(0, endIndex);
                            // Replace original text with updated text
                            line = line.replace(original, "\"" + newText.replace("\"", "\"\"") + "\"");
                            // Remove updated part from updated text
                            updated = updated.substring(endIndex);
                        }
                    }
                    caption.setLength(0);
                } else {
                    caption.append(line).append(" ");
                }
                lines.add(line);
            }
        }

        // Write updated captions to new SBV file
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                pw.println(line);
            }
        }
    }
}
