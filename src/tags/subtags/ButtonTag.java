package tags.subtags;

/**
 * @author Chuck Fon Lee
 */
public class ButtonTag implements Tag {
    private String text;
    private String postback;
    private String someUrl;

    public ButtonTag(String text, String postback,String someUrl) {
        this.text = text;
        this.postback = postback;
        this.someUrl = someUrl;
    }

    private String getText() {
        return "\n<text>\n" + text + "\n</text>";
    }

    private String getPostback() {
        return "\n<postback>\n" + postback+ "\n</postback>";
    }

    private String getSomeUrl() {
        return "\n<url>\n" + someUrl + "\n</url>";
    }

    @Override
    public String toString() {
        return "\n<button>\n" + getText() + getPostback() + getSomeUrl() + "\n</button>";
    }
}
