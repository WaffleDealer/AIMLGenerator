import tags.Category;
import tags.Pattern;
import tags.Template;
import tags.subtags.StringTag;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AIML output = new AIML();

        output.addCategory(new Category(new Pattern("Hallo"),new Template(new StringTag("NOOOO"))));
        //File pad aanpassen
        FileCreator.createAIMLFile(output);
    }
}

