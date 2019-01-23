package tags.subtags;

public class ResponseTag implements Tag {
    int index;

    public ResponseTag(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "<response index=\""+index+"\" />";
    }
}
