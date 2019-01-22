package tags;

import java.util.List;

public class Topic {
    String topicName;
    List<Category> cats;

    public Topic(String topicName, List<Category> cats) {
        this.topicName = topicName;
        this.cats = cats;
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
