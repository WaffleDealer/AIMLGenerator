package tags.subtags;
/**
 * @author Chuck Fon Lee
 */
public class CardTag implements Tag {
    private String title;
    private String subtitle;
    private String imageURL;
    private ButtonTag button;

    public CardTag(String title, String subtitle, String imageURL, ButtonTag button) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageURL = imageURL;
        this.button = button;
    }

    public CardTag(String title, String imageURL, ButtonTag button) {
        this.title = title;
        this.imageURL = imageURL;
        this.button = button;
    }

    public String getTitle() {
        return "\n<title>\n" + title + "\n</title>";
    }

    public String getSubtitle() {
        return "\n<subtitle>\n" + subtitle + "\n</subtitle>";
    }

    public String getImageURL() {
        return "\n<image>\n" + imageURL + "\n</image>";
    }

    public String getButton() {
        return button.toString();
    }

    @Override
    public String toString() {
        StringBuilder cardBuilder = new StringBuilder();
        cardBuilder.append("<card> \n");
        cardBuilder.append(getTitle());
        cardBuilder.append(getSubtitle());
        cardBuilder.append(getImageURL());
        cardBuilder.append(getButton());
        cardBuilder.append("</card>");
        return cardBuilder.toString();
    }
}
