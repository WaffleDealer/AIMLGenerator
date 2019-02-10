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
        room.addTag(new StringTag("You can see which rooms are available on the floorplan or in the list. The rooms which are available are not coloured red. Make sure that \\\"bezet\\\" is turned on in the settings."));
        room.addTag(new Delay(3));
        room.addTag(new StringTag("do you want to see a picture?"));
        room.addTag(new ButtonTag("yes","xshowroompic",null));
        room.addTag(new ButtonTag("no","xdonothing",null));
        Category roomv1 = new Category(new Pattern("How can i see which rooms are available?"),room);
        output.addCategory(roomv1);

        //Room v2
        Template roomv2 = new Template();
        roomv2.addTag(new SraiTag("How can i see which rooms are available?"));
        Category roomc2 = new Category(new Pattern("available rooms?"),roomv2);
        output.addCategory(roomc2);

        //Room v3
        Template roomv3 = new Template();
        roomv3.addTag(new SraiTag("How can i see which rooms are available?"));
        Category roomc3 = new Category(new Pattern("Which rooms are available?"),roomv3);
        output.addCategory(roomc3);

        //Room answer 'yes'
        Template xshowroompic = new Template();
        xshowroompic.addTag(new ImageTag("https://i.imgur.com/738g1W0.png"));
        Category roomanswer = new Category(new Pattern("xshowroompic"),xshowroompic);
        output.addCategory(roomanswer);
        //do nothing
        Template empty = new Template();
        Category donothingcat = new Category(new Pattern("xdonothing"),empty);
        output.addCategory(donothingcat);

        //Roomdetails
        Template roomDetailsBase = new Template();
        roomDetailsBase.addTag(new StringTag("You can see the roomdetails by first clicking on a room and then clicking on the info button."));
        Category roomDetailsBaseCat = new Category(new Pattern("How to see the roomdetails?"),roomDetailsBase);
        output.addCategory(roomDetailsBaseCat);

        //RDSRAI1
        Template RDSRAI1 = new Template();
        RDSRAI1.addTag(new SraiTag("How to see the roomdetails?"));
        Category RDSRAIC1 = new Category(new Pattern("How to change the roomdetails?"),RDSRAI1);
        output.addCategory(RDSRAIC1);

        //RDSRAI2
        Template RDSRAI2 = new Template();
        RDSRAI2.addTag(new SraiTag("How to see the roomdetails?"));
        Category RDSRAIC2 = new Category(new Pattern("How can i change the details of a room?"),RDSRAI2);
        output.addCategory(RDSRAIC2);

        //RSPECFIC
        Template RSPECIFIC = new Template();
        RSPECIFIC.addTag(new CardTag(Star.value, "details of " + Star.value,new ButtonTag(Star.value,null,"localhost:4200")));
        Category RSPECIFICC = new Category(new Pattern("I want to change *"),RSPECIFIC);
        output.addCategory(RSPECIFICC);

        //SRAITOSPECIFIC
        Template RSPECIFIC2 = new Template();
        RSPECIFIC2.addTag(new SraiTag("I want to change " + Star.value));
        Category RPSECIFIC2C = new Category(new Pattern("Show me the details of *"),RSPECIFIC2);
        output.addCategory(RPSECIFIC2C);

        FileCreator.createAIMLFile(output);
    }
}

