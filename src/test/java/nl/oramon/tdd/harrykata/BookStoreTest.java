package nl.oramon.tdd.harrykata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The unit test suite for the {@link BookStore} class.
 *
 * @author <a href="mailto:artur.rozalski@oramon.nl">Artur Rozalski</a>
 */
public class BookStoreTest {

    /**
     * @see BookStore
     */
    private BookStore bookStore = new BookStore();

    @Test
    public void buy_NullInput_ShouldReturn0Price() {
        assertThat(bookStore.calculatePrice(null)).isEqualTo(0.0);
    }

    @Test
    public void buy_EmptyInput_ShouldReturn0Price() {
        int[] inputBooks = new int[]{};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(0.0);
    }

    @Test
    public void buy_OneFirstBook_ShouldReturn8EuroPrice() {
        int inputBook = 1;

        assertThat(bookStore.calculatePrice(inputBook)).isEqualTo(8.0);
    }

    @Test
    public void buy_OneThirdBook_ShouldReturn8EuroPrice() {
        int inputBook = 3;

        assertThat(bookStore.calculatePrice(inputBook)).isEqualTo(8.0);
    }

    @Test
    public void but_TwoFirstBooks_ShouldReturn16EuroPrice() {
        int[] inputBooks = {1, 1};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(16.0);
    }

    @Test
    public void buy_TwoThirdBooks_ShouldReturn16EuroPrice() {
        int[] inputBooks = {3, 3};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(16.0);
    }

    @Test
    public void buy_OneFirstAndOneSecondBook_ShouldReturn15EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 2};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(15.20);
    }

    @Test
    public void buy_OneThirdsAndOneFourthBook_ShouldReturn15EuroAnd20CentsPrice() {
        int[] inputBooks = {3, 4};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(15.20);
    }

    @Test
    public void buy_OneFirstAndTwoSecondBooks_ShouldReturn23EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 2, 2};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(23.20);
    }

    @Test
    public void buy_TwoSetsOfTwoDifferentBooks_ShouldReturn30EuroAnd40CentsPrice() {
        int[] inputBooks = {3, 3, 4, 4};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(30.40);
    }

    @Test
    public void buy_ThreeSecondBooksAndTwoThirdBooks() {
        int[] inputBooks = {3, 3, 2, 2, 2};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(38.40);
    }

    @Test
    public void buy_ThreeDifferentBooks_ShouldReturn21EuroAnd60CentsPrice() {
        int[] inputBooks = {1, 2, 3};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(21.60);
    }

    @Test
    public void buy_TwoSetsOfThreeDifferentBooks_ShouldReturn43EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 1, 2, 2, 3, 3};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(43.20);
    }

    @Test
    public void buy_FourDifferentBooks_ShouldReturn25EuroAnd60CentsPrice() {
        int[] inputBooks = {1, 2, 3, 4};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(25.60);
    }

    @Test
    public void buy_TwoSetsOfFourDifferentBooks_ShouldReturn51EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 1, 2, 2, 3, 3, 4, 4};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(51.20);
    }

    @Test
    public void buy_FiveDifferentBooks_ShouldReturn30EuroPrice() {
        int[] inputBooks = {1, 2, 3, 4, 5};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(30.00);
    }

    @Test
    public void buy_TwoSetsOfFiveDifferentBooks_ShouldReturn60EuroPrice() {
        int[] inputBooks = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(60.00);
    }

    @Test
    public void buy_TwoFirstOneSecondBook_ShouldReturn23EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 1, 2};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(23.20);
    }

    @Test
    public void buy_OneSetOfFiveBooksAndOneSetOfThreeBooks_ShouldReturn51EuroAnd20CentsPrice() {
        int[] inputBooks = {1, 1, 2, 2, 3, 3, 4, 5};

        assertThat(bookStore.calculatePrice(inputBooks)).isEqualTo(51.20);
    }

}
