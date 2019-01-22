package tags.subtags;

public class GetTag implements Tag{
    String variableName;

    public GetTag(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public String toString() {
        return "<get name=\""+variableName+"\" />";
    }
}
