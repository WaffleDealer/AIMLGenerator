package tags;

public class Pattern {
    private String userInput;

    public Pattern(String userInput) {
        this.userInput = userInput.toUpperCase();
    }

    public String getUserInput() {
        return userInput;
    }

    @Override
    public String toString() {
        return "<pattern>" + '\n' + getUserInput() + '\n' + "</pattern>";
    }
}
