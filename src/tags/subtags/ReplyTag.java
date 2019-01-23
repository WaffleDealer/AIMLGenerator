package tags.subtags;

public class ReplyTag implements Tag {
    String text;
    String postback;

    public ReplyTag(String text, String postback) {
        this.text = text;
        this.postback = postback;
    }

    @Override
    public String toString() {
        StringBuilder replyBuilder = new StringBuilder();
        replyBuilder.append("<reply>");
        if (text != null) {
            replyBuilder.append("<text>").append(text).append("</text>");
        }
        if (postback != null) {
            replyBuilder.append("<postback>").append(postback).append("</postback>");
        }
        replyBuilder.append("</reply>");

        return replyBuilder.toString();
    }
}
