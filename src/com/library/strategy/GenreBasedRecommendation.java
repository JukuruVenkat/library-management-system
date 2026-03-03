package com.library.strategy;

import com.library.model.Book;
import com.library.model.Patron;
import java.util.List;

public class GenreBasedRecommendation implements RecommendationStrategy {

    @Override
    public List<Book> recommend(Patron patron, List<Book> books) {
        return books.stream()
                .filter(Book::isAvailable)
                .limit(2)
                .toList();
    }
}