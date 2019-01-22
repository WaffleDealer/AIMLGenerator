package tags;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Category {
    Pattern userInput;
    Template botAnswer;
    ThatTag that;

    public Category(Pattern userInput, Template botAnswer) {
        this.userInput = userInput;
        this.botAnswer = botAnswer;
    }

    public Category(Pattern userInput, Template botAnswer, ThatTag that) {
        this.userInput = userInput;
        this.botAnswer = botAnswer;
        this.that = that;
    }

    @Override
    public String toString() {
        StringBuilder categoryBuilder = new StringBuilder();
        categoryBuilder.append("<category>");
        categoryBuilder.append(userInput.toString());
        if (that != null) {
            categoryBuilder.append(that.toString());
        }
        categoryBuilder.append(botAnswer.toString());
        categoryBuilder.append("</category>");
        return categoryBuilder.toString();
    }
}
