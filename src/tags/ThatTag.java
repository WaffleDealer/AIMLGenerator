package tags;

import tags.subtags.Tag;

public class ThatTag implements Tag {
    String context;

    public ThatTag(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "<that>" + context + "</that>";
    }
}
