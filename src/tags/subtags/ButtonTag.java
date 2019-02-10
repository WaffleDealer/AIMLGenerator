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
        if (text == null) {
            return "";
        }
        return "\n<text>\n" + text + "\n</text>";
    }

    private String getPostback() {
        if (postback == null) {
            return "";
        }
        return "\n<postback>\n" + postback+ "\n</postback>";
    }

    private String getSomeUrl() {
        if (someUrl == null) {
            return "";
        }
        return "\n<url>\n" + someUrl + "\n</url>";
    }

    @Override
    public String toString() {
        return "\n<button>\n" + getText() + getPostback() + getSomeUrl() + "\n</button>";
    }
}
