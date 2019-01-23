package tags.subtags;

public class SraiTag implements Tag{
    String convertTo;

    public SraiTag(String convertTo) {
        this.convertTo = convertTo;
    }

    @Override
    public String toString() {
        return "<srai>" + convertTo + "</srai>";
    }
}
