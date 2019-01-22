package tags.subtags;

public class Delay implements Tag{
    private int delay;

    public Delay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "<delay>" + delay + "</delay>";
    }
}
