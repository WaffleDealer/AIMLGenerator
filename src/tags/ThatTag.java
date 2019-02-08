package tags;

import tags.subtags.Tag;

public class ThatTag implements Tag {
    String context;

    public ThatTag(String context) {
        this.context = context.toUpperCase();
    }

    @Override
    public String toString() {
        return "<that>" + context.replaceAll("[?.!:&]","") + "</that>";
    }
}
