package tags;

import tags.subtags.Tag;

import java.util.ArrayList;
import java.util.List;

public class Template {
    List<Tag> data;

    public Template() {
        this.data = new ArrayList<>();
    }

    public void addTag(Tag t) {
        data.add(t);
    }

    @Override
    public String toString() {
        StringBuilder templateBuilder = new StringBuilder();
        templateBuilder.append("<template>");
        for (Tag datum : data) {
            templateBuilder.append(datum.toString());
        }
        templateBuilder.append("</template>");
        return templateBuilder.toString();
    }
}
