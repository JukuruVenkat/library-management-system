package com.library.factory;

import com.library.strategy.*;

public class RecommendationFactory {

    public static RecommendationStrategy getStrategy(RecommendationType type) {
        return switch (type) {
            case HISTORY -> new HistoryBasedRecommendation();
            case GENRE -> new GenreBasedRecommendation();
        };
    }
}