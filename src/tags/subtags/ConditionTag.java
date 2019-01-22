package tags.subtags;

import java.util.List;

/**
 * @author Chuck Fon Lee
 */
public class ConditionTag implements Tag{
    private String conditionValue;
    private List<LiTag> triggers;

    public ConditionTag(List<LiTag> triggers) {
        this.triggers = triggers;
    }

    @Override
    public String toString() {
        StringBuilder conditionBuilder = new StringBuilder();
        conditionBuilder.append("<condition name=\"").append(conditionValue).append("\">");
        for (LiTag trigger : triggers) {
            conditionBuilder.append("\n");
            conditionBuilder.append(trigger.toString());
        }
        conditionBuilder.append("</condition>");
        return conditionBuilder.toString();
    }
}
