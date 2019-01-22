package tags.subtags;
/**
 * @author Chuck Fon Lee
 */
public class LiTag implements Tag{
    private String compareValue;
    private Tag action;
    private boolean loop;

    public LiTag(String compareValue, Tag action) {
        this.compareValue = compareValue;
        this.action = action;
    }

    public LiTag(String compareValue, Tag action, boolean loop) {
        this.compareValue = compareValue;
        this.action = action;
        this.loop = loop;
    }

    @Override
    public String toString() {
        StringBuilder liBuilder = new StringBuilder();

        if (compareValue.equals("")) {
            liBuilder.append("<li>");
        } else {
            liBuilder.append("<li value=\"").append(compareValue).append("\">");
        }

        liBuilder.append(action.toString());
        if (loop) {
            liBuilder.append("<loop/>");
        }
        liBuilder.append("</li>");

        return liBuilder.toString();
    }
}
