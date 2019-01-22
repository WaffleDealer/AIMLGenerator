package tags;

import tags.subtags.Tag;

public class Template {
    Tag data;

    public Template(Tag data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "<template>" + '\n' + data.toString()+ '\n' + "</template>";
    }
}
