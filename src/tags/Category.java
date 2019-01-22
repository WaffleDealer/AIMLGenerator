package tags;

public class Category {
    Pattern userInput;
    Template botAnswer;

    public Category(Pattern userInput, Template botAnswer) {
        this.userInput = userInput;
        this.botAnswer = botAnswer;
    }

    @Override
    public String toString() {
        return "<category>" + '\n' + userInput.toString() + '\n' +botAnswer.toString() + '\n' + "</category>";
    }
}
