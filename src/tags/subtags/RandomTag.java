package tags.subtags;
import java.util.List;

public class RandomTag implements Tag{
    private List<LiTag> triggers;

    public RandomTag(List<LiTag> triggers) {
        this.triggers = triggers;
    }

    /**
     *  <random>
     *     <li>What was that?</li>
     *     <li>I don't understand.</li>
     *     <li>Can you say that in a different way?</li>
     *   </random>
     * @return
     */
    @Override
    public String toString() {
        StringBuilder randomBuilder = new StringBuilder();
        randomBuilder.append("<random>");
        for (LiTag trigger : triggers) {
            trigger.toString();
        }
        randomBuilder.append("</random>");
        return randomBuilder.toString();
    }

}
