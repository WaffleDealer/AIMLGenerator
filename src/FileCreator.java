import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void createAIMLFile(AIML output) throws IOException {
        //pas de File pad aan
        File file = new File("c://users//waffl//Desktop//test.txt");
        if (file.createNewFile()) {
            System.out.println("file Created");
        } else {
            file.delete();
            file.createNewFile();
            System.out.println("file has been deleted and recreated.");
        }

        try (
                FileWriter writer = new FileWriter(file)) {
            writer.write(output.toString());
        }
    }
}
