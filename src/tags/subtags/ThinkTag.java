package tags.subtags;

public class ThinkTag implements Tag {
    Tag action;

    public ThinkTag(Tag action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return "<think>" + action.toString() + "</think>";
    }
}
