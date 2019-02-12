package tags;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String topicName;
    List<Category> cats;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.cats = new ArrayList<>();
    }

    public void addCategory(Category c) {
        cats.add(c);
    }

    @Override
    public String toString() {
        StringBuilder topicBuilder = new StringBuilder();
        topicBuilder.append("<topic name=\"" + topicName + "\">");
        for (Category cat : cats) {
            topicBuilder.append(cat.toString());
        }
        topicBuilder.append("</topic>");
        return topicBuilder.toString();
    }
}
