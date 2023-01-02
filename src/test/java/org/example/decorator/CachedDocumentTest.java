package org.example.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CachedDocumentTest {
    private Document doc;

    @BeforeEach
    void setUp() {
        doc = new CachedDocument("gs://my_oop/algo.png");
    }

    @Test
    void parse() {
        String res = doc.parse();
        assert !res.isEmpty();
    }


}