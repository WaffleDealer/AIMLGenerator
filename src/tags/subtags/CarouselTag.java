package tags.subtags;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Chuck Fon Lee
 */
public class CarouselTag implements Tag {
    private List<CardTag> cards;

    public CarouselTag() {
        this.cards = new ArrayList<>();
    }

    public void addCard(CardTag ct) {
        cards.add(ct);
    }

    @Override
    public String toString() {
        StringBuilder carouselBuilder = new StringBuilder();
        carouselBuilder.append("<carousel>\n");
        for (CardTag card : cards) {
            carouselBuilder.append("\n");
            carouselBuilder.append(card.toString());
        }
        carouselBuilder.append("\n</carousel>");
        return carouselBuilder.toString();
    }
}
