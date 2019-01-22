import tags.Category;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AIML {
    List<Category> cats;

    public AIML() {
        cats = new ArrayList<>();
    }

    public void addCategory(Category c) {
        cats.add(c);
    }

    @Override
    public String toString() {
        StringBuilder aimlBuilder = new StringBuilder();
        aimlBuilder.append("<aiml version=\"2.0\">");
        for (Category cat : cats) {
            aimlBuilder.append('\n');
            aimlBuilder.append(cat.toString());
            aimlBuilder.append('\n');
        }
        aimlBuilder.append("</aiml>");

        return aimlBuilder.toString();
    }


}
