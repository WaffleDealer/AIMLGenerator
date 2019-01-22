package tags.subtags;

public class SetTag implements Tag{
    String lookup;
    String value;


    public SetTag(String variable, String value) {
        lookup = variable;
        this.value = value;
    }

    public SetTag(String setName) {
        lookup = setName;
    }

    @Override
    public String toString() {
        StringBuilder setBuilder = new StringBuilder();
        if (value.isEmpty()) {
            setBuilder.append("<set>" + lookup + "</set>");
        } else {
            setBuilder.append("<set name=\"" + lookup + "\">" + value + "</set>");
        }

        return setBuilder.toString();
    }
}
