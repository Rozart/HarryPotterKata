package nl.oramon.tdd.harrykata;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The solution class for Harry Potter TDD Kata.
 *
 * @author <a href="mailto:artur.rozalski@oramon.nl">Artur Rozalski</a>
 */
public class BookStore {

    /**
     * The base price of the book.
     */
    private static final double BASE_PRICE = 8.0;

    /**
     * The price of one set of five different books.
     */
    private static final double PRICE_FOR_SET_OF_FIVE = 5 * BASE_PRICE * 0.75;

    /**
     * The price of one set of four different books.
     */
    private static final double PRICE_FOR_SET_OF_FOUR = 4 * BASE_PRICE * 0.8;

    /**
     * The price of one set of three different books.
     */
    private static final double PRICE_FOR_SET_OF_THREE = 3 * BASE_PRICE * 0.9;

    /**
     * The price of one set of two different books.
     */
    private static final double PRICE_FOR_SET_OF_TWO = 2 * BASE_PRICE * 0.95;


    /**
     * Calculates the lowest possible price of buying specified books.
     *
     * @param inputBooks the array of books to have the price checked.
     * @return lowest possible price of buying specified books.
     */
    public double calculatePrice(int... inputBooks) {
        if (ArrayUtils.isEmpty(inputBooks)) {
            return 0.0;
        }

        Map<Integer, Integer> categorizedBooks = categorizeBooks(inputBooks);
        return findLowestPrice(categorizedBooks);
    }

    /**
     * Finds the lowest possible price for provided map of categorized books.
     *
     * @param categorizedBooks the map of categorized books.
     * @return the lowest possible price of buying the books.
     */
    private double findLowestPrice(Map<Integer, Integer> categorizedBooks) {
        double lowestPrice = Double.MAX_VALUE;
        for (int i = 5; i > 0; i--) {
            double tempPrice = calculatePriceForSetSize(categorizedBooks, i);
            if (tempPrice < lowestPrice) {
                lowestPrice = tempPrice;
            }
        }
        return lowestPrice;
    }

    /**
     * Calculates the price for books in provided map of categorized books, depending on the provided maximum set size.
     *
     * @param categorizedBooks the map of categorized books.
     * @param setSize          the maximum size of the set to check.
     * @return the calculated price for specified books and max set size.
     */
    private double calculatePriceForSetSize(Map<Integer, Integer> categorizedBooks, int setSize) {
        Map<Integer, Integer> categorizedBooksClone = new HashMap<>(categorizedBooks);

        int[] sets = {0, 0, 0, 0, 0};

        for (int i = setSize; i > 1; i--) {
            sets[i - 1] = countNumberOfSets(categorizedBooksClone, i);
        }

        sets[0] = countBooksLeft(categorizedBooksClone);

        double finalPrice = 0.0;

        finalPrice += sets[4] * PRICE_FOR_SET_OF_FIVE;
        finalPrice += sets[3] * PRICE_FOR_SET_OF_FOUR;
        finalPrice += sets[2] * PRICE_FOR_SET_OF_THREE;
        finalPrice += sets[1] * PRICE_FOR_SET_OF_TWO;
        finalPrice += sets[0] * 8;

        return finalPrice;
    }

    /**
     * @param books
     * @param setSize
     * @return
     */
    private int countNumberOfSets(Map<Integer, Integer> books, int setSize) {
        int counter = 0;
        while (books.size() >= setSize) {
            decreaseQuantityOfBooks(books, setSize);
            counter++;
        }
        return counter;
    }

    /**
     * Decreases the number of occurrences for provided number of titles in provided categorized books map.
     *
     * @param categorizedBooks the map of categorized books.
     * @param numberOfTitles   number of titles to have quantity decreased.
     */
    private void decreaseQuantityOfBooks(Map<Integer, Integer> categorizedBooks, int numberOfTitles) {
        Iterator<Map.Entry<Integer, Integer>> iterator = categorizedBooks.entrySet().iterator();
        int counter = 0;
        while (iterator.hasNext() && counter < numberOfTitles) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() < 1) {
                iterator.remove();
            }
            counter++;
        }
    }

    /**
     * Counts the books left in the map after removing all sets.
     *
     * @param books the categorized books map.
     * @return number of books left.
     */
    private int countBooksLeft(Map<Integer, Integer> books) {
        return books.values().stream().mapToInt(Number::intValue).sum();
    }

    /**
     * Counts occurrences of each book type in a provided array.
     *
     * @param booksArray the books array.
     * @return map with type of book as a key and number of occurrences as a value.
     */
    private Map<Integer, Integer> categorizeBooks(int[] booksArray) {
        Map<Integer, Integer> categorizedBooks = new HashMap<>();
        for (int i : booksArray) {
            if (categorizedBooks.containsKey(i)) {
                categorizedBooks.put(i, categorizedBooks.get(i) + 1);
            } else {
                categorizedBooks.put(i, 1);
            }
        }
        return categorizedBooks;
    }

}
