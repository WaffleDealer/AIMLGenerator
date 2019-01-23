package tags.subtags;

public class VideoTag implements Tag {
    String url;

    public VideoTag(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "<video>" + url + "</video>";
    }
}
