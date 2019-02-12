import tags.*;
import tags.subtags.*;

import java.io.IOException;
import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) throws IOException {

        AIML output = new AIML();

        ThatTag languageChoice = new ThatTag("Press 1 for english and 2 for dutch");

        Template language = new Template();
        language.addTag(new StringTag("Press 1 for english and 2 for dutch"));
        output.addCategory(new Category(new Pattern("*"),language));

        Template switchToEnlish = new Template();
        switchToEnlish.addTag(new ThinkTag(new SetTag("topic","en")));
        switchToEnlish.addTag(new StringTag("Hello, what can I do for you?"));
        output.addCategory(new Category(new Pattern("1"),switchToEnlish, languageChoice));

        Template switchToDutch = new Template();
        switchToDutch.addTag(new ThinkTag(new SetTag("topic","nl")));
        switchToDutch.addTag(new StringTag("Hallo, wat kan ik doen voor u?"));
        output.addCategory(new Category(new Pattern("2"),switchToDutch, languageChoice));

        Topic english = new Topic("en");
        //Greetings
        Template t = new Template();
        t.addTag(new StringTag("Hello, what is your name?"));
        Category c = new Category(new Pattern("Hello"),t);
        english.addCategory(c);

        //Greetings reduction
        Template t2 = new Template();
        t2.addTag(new SraiTag("Hello"));
        Category c2 = new Category(new Pattern("Yo"),t2);
        english.addCategory(c2);

        //My name is
        Template naam = new Template();
        naam.addTag(new StringTag("Hello" + new SetTag("userName",Star.value).toString() + "What can I do for you?"));
        Category nameReaction = new Category(new Pattern("*"),naam);
        nameReaction.setThat(new ThatTag("Hello, what is your name?"));
        english.addCategory(nameReaction);

        //Room
        Template room = new Template();
        room.addTag(new StringTag("You can see which rooms are available on the floorplan or in the list. The rooms which are available are not coloured red. Make sure that \\\"bezet\\\" is turned on in the settings."));
        room.addTag(new Delay(3));
        room.addTag(new StringTag("do you want to see a picture?"));
        room.addTag(new ButtonTag("yes","xshowroompic",null));
        room.addTag(new ButtonTag("no","xdonothing",null));
        Category roomv1 = new Category(new Pattern("How can i see which rooms are available?"),room);
        english.addCategory(roomv1);

        //Room v2
        Template roomv2 = new Template();
        roomv2.addTag(new SraiTag("How can i see which rooms are available?"));
        Category roomc2 = new Category(new Pattern("available rooms?"),roomv2);
        english.addCategory(roomc2);

        //Room v3
        Template roomv3 = new Template();
        roomv3.addTag(new SraiTag("How can i see which rooms are available?"));
        Category roomc3 = new Category(new Pattern("Which rooms are available?"),roomv3);
        english.addCategory(roomc3);

        //Room answer 'yes'
        Template xshowroompic = new Template();
        xshowroompic.addTag(new ImageTag("https://i.imgur.com/738g1W0.png"));
        Category roomanswer = new Category(new Pattern("xshowroompic"),xshowroompic);
        english.addCategory(roomanswer);
        //do nothing
        Template empty = new Template();
        Category donothingcat = new Category(new Pattern("xdonothing"),empty);
        english.addCategory(donothingcat);

        //Roomdetails
        Template roomDetailsBase = new Template();
        roomDetailsBase.addTag(new StringTag("You can see the roomdetails by first clicking on a room and then clicking on the info button."));
        Category roomDetailsBaseCat = new Category(new Pattern("How to see the roomdetails?"),roomDetailsBase);
        english.addCategory(roomDetailsBaseCat);

        //RDSRAI1
        Template RDSRAI1 = new Template();
        RDSRAI1.addTag(new SraiTag("How to see the roomdetails?"));
        Category RDSRAIC1 = new Category(new Pattern("How to change the roomdetails?"),RDSRAI1);
        english.addCategory(RDSRAIC1);

        //RDSRAI2
        Template RDSRAI2 = new Template();
        RDSRAI2.addTag(new SraiTag("How to see the roomdetails?"));
        Category RDSRAIC2 = new Category(new Pattern("How can i change the details of a room?"),RDSRAI2);
        english.addCategory(RDSRAIC2);

        //RSPECFIC
        Template RSPECIFIC = new Template();
        RSPECIFIC.addTag(new CardTag(Star.value, "details of " + Star.value,null,new ButtonTag(Star.value,null,"localhost:4200")));
        Category RSPECIFICC = new Category(new Pattern("I want to change *"),RSPECIFIC);
        english.addCategory(RSPECIFICC);

        //SRAITOSPECIFIC
        Template RSPECIFIC2 = new Template();
        RSPECIFIC2.addTag(new SraiTag("I want to change " + Star.value));
        Category RPSECIFIC2C = new Category(new Pattern("Show me the details of *"),RSPECIFIC2);
        english.addCategory(RPSECIFIC2C);

        Topic dutch = new Topic("nl");

        //Greetings
        Template tNL = new Template();
        tNL.addTag(new StringTag("Hallo, wat is uw naam?"));
        Category cNL = new Category(new Pattern("Hallo"),tNL);
        dutch.addCategory(cNL);

        //Greetings reduction
        Template t2NL = new Template();
        t2NL.addTag(new SraiTag("Hallo"));
        Category c2NL = new Category(new Pattern("gegroet"),t2);
        dutch.addCategory(c2NL);

        //My name is
        Template naamNL = new Template();
        naamNL.addTag(new StringTag("Hallo " + new SetTag("userName",Star.value).toString() + " Wat kan ik voor u doen?"));
        Category nameReactionNL = new Category(new Pattern("*"),naamNL);
        nameReactionNL.setThat(new ThatTag("Hallo, wat is uw naam?"));
        dutch.addCategory(nameReactionNL);

        //Room
        Template roomNL = new Template();
        //u kunt zien welke kamers vrij zijn op de plattegrond of in de lijst. Diegenen die vrij zijn zijn niet rood. Vergeet ook niet om "bezet" aan te zetten in de instellingen
        roomNL.addTag(new StringTag("u kunt zien welke kamers vrij zijn op de plattegrond of in de lijst. Diegenen die vrij zijn zijn niet rood. Vergeet ook niet om \"bezet\" aan te zetten in de instellingen"));
        roomNL.addTag(new Delay(3));
        roomNL.addTag(new StringTag("Wilt u hiervan een foto zien?"));
        roomNL.addTag(new ButtonTag("ja","xshowroompicNL",null));
        roomNL.addTag(new ButtonTag("nee","xdonothingNL",null));
        Category roomvlNL = new Category(new Pattern("Hoe kan ik zien welke kamers vrij zijn?"),roomNL);
        dutch.addCategory(roomvlNL);

        //Room v2
        Template roomv2NL = new Template();
        roomv2NL.addTag(new SraiTag("Hoe kan ik zien welke kamers vrij zijn?"));
        Category roomc2NL = new Category(new Pattern("vrije kamers?"),roomv2NL);
        dutch.addCategory(roomc2NL);

        //Room v3
        Template roomv3NL = new Template();
        roomv3NL.addTag(new SraiTag("Hoe kan ik zien welke kamers vrij zijn?"));
        Category roomc3NL = new Category(new Pattern("Welke kamers zijn vrij?"),roomv3NL);
        dutch.addCategory(roomc3NL);

        //Room answer 'yes'
        Template xshowroompicNL = new Template();
        xshowroompicNL.addTag(new ImageTag("https://i.imgur.com/738g1W0.png"));
        Category roomanswerNL = new Category(new Pattern("xshowroompicNL"),xshowroompicNL);
        dutch.addCategory(roomanswerNL);

        //do nothing
        Template emptyNL = new Template();
        Category donothingcatNL = new Category(new Pattern("xdonothingNL"),emptyNL);
        dutch.addCategory(donothingcatNL);

        //Roomdetails
        Template roomDetailsBaseNL = new Template();
        // u kune de roomdetails zien door eerst op een kamer te drukken en dan de info knop.
        roomDetailsBaseNL.addTag(new StringTag("u kunt de roomdetails zien door eerst op een kamer te drukken en dan de info knop."));
        Category roomDetailsBaseCatNL = new Category(new Pattern("Hoe kan ik een kamer aanpassen?"),roomDetailsBaseNL);
        dutch.addCategory(roomDetailsBaseCatNL);

        //RDSRAI1
        Template RDSRAI1NL = new Template();
        RDSRAI1NL.addTag(new SraiTag("Hoe kan ik een kamer aanpassen?"));
        Category RDSRAIC1NL = new Category(new Pattern("Hoe kan ik de details van een kamer bekijken?"),RDSRAI1NL);
        dutch.addCategory(RDSRAIC1NL);

//        //RDSRAI2
//        Template RDSRAI2NL = new Template();
//        RDSRAI2NL.addTag(new SraiTag("Hoe kan ik een kamer aanpassen?"));
//        Category RDSRAIC2NL = new Category(new Pattern("How can I change the details of a room?"),RDSRAI2NL);
//        dutch.addCategory(RDSRAIC2NL);

        //RSPECFIC
        Template RSPECIFICNL = new Template();
        RSPECIFICNL.addTag(new CardTag(Star.value, "Dee details van " + Star.value,null,new ButtonTag(Star.value,null,"localhost:4200/" + Star.value)));
        Category RSPECIFICCNL = new Category(new Pattern("Toon mij de details van *"),RSPECIFICNL);
        dutch.addCategory(RSPECIFICCNL);

        //SRAITOSPECIFIC
        Template RSPECIFIC2NL = new Template();
        RSPECIFIC2NL.addTag(new SraiTag("Toon mij de details van" + Star.value));
        Category RPSECIFIC2CNL = new Category(new Pattern("Ik wil * aanpassen"),RSPECIFIC2NL);
        dutch.addCategory(RPSECIFIC2CNL);


        output.addTopic(english);
        output.addTopic(dutch);
        FileCreator.createAIMLFile(output);
    }
}