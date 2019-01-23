package tags.subtags;

public class SraixTag implements Tag {
    String bot;
    String content;

    public SraixTag(String bot, String content) {
        this.bot = bot;
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sraixBuilder = new StringBuilder();
        sraixBuilder.append("<sraix bot=\"");
        sraixBuilder.append(bot);
        sraixBuilder.append("\">");
        sraixBuilder.append(content);
        sraixBuilder.append("</sraix>");
        return sraixBuilder.toString();
    }
}
