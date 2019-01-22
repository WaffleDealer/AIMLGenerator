package tags.subtags;
/**
 * @author Chuck Fon Lee
 */
public class StringTag implements Tag {
    private String data;

    public StringTag(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
