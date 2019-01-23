package tags.subtags;

public class ImageTag implements Tag {
    String url;

    public ImageTag(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "<image>" + url + "</image>";
    }
}
