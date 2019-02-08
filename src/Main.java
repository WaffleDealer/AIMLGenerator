import tags.Category;
import tags.Pattern;
import tags.Template;
import tags.ThatTag;
import tags.subtags.*;

import java.io.IOException;
import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) throws IOException {

        AIML output = new AIML();
        //Greetings
//        Template t = new Template();
//        t.addTag(new StringTag("Welkom op de site, Mijn naam is Axle"));
//        output.addCategory(new Category(new Pattern("Hallo"),t));

        //Greetings
        Template t = new Template();
        t.addTag(new StringTag("Hallo, wat is uw naam?"));
        Category c = new Category(new Pattern("Hallo"),t);
        output.addCategory(c);

        //Greetings reduction
        Template t2 = new Template();
        t2.addTag(new SraiTag("Hallo"));
        Category c2 = new Category(new Pattern("Yo"),t2);
        output.addCategory(c2);

        //My name is
        Template naam = new Template();
        naam.addTag(new StringTag("Hallo" + new SetTag("userName",Star.value).toString() + "Wat kan ik voor u doen?"));
        Category nameReaction = new Category(new Pattern("*"),naam);
        nameReaction.setThat(new ThatTag("Hallo, wat is uw naam?"));
        output.addCategory(nameReaction);

        //Room
        Template room = new Template();
        //room
        // image url = https://firebasestorage.googleapis.com/v0/b/ticonference.appspot.com/o/Knipsel.PNG?alt=media&token=8ebd7743-f938-4f31-bae9-2c35cb0d581d



//        //Reservatie
//        Template reservatieTemplate = new Template();
//        reservatieTemplate.addTag(new StringTag("U kunt een kamer reserveren door op een kamer te klikken en dan op één van de drie reservatieknoppen te drukken. De kamer zal automatisch worden gereserveerd."));
//        reservatieTemplate.addTag(new ImageTag("https://s3.amazonaws.com/tinycards/image/60cacd94bfbd3795f72912ec254efb38"));
//        output.addCategory(new Category(new Pattern("Hoe kan ik een kamer reserveren?"),reservatieTemplate));
//
//        //General Card
//        Template cardTemp = new Template();
//        cardTemp.addTag(new CardTag("someTitle","https://s3.amazonaws.com/tinycards/image/60cacd94bfbd3795f72912ec254efb38",new ButtonTag("This is a button","Shit",)));

        //
        //File pad aanpassen
        FileCreator.createAIMLFile(output);
    }
}

