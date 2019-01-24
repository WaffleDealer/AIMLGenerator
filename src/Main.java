import tags.Category;
import tags.Pattern;
import tags.Template;
import tags.subtags.ButtonTag;
import tags.subtags.ImageTag;
import tags.subtags.StringTag;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AIML output = new AIML();
        //Greetings
        Template t = new Template();
        t.addTag(new StringTag("Welkom op de site, Mijn naam is Axle"));
        output.addCategory(new Category(new Pattern("Hallo"),t));

        //Reservatie
        Template reservatieTemplate = new Template();
        reservatieTemplate.addTag(new StringTag("U kunt een kamer reserveren door op een kamer te klikken en dan op één van de drie reservatieknoppen te drukken. De kamer zal automatisch worden gereserveerd."));
        reservatieTemplate.addTag(new ImageTag("https://s3.amazonaws.com/tinycards/image/60cacd94bfbd3795f72912ec254efb38"));
        //File pad aanpassen
        FileCreator.createAIMLFile(output);
    }
}

