package com.geekbrains.homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void triangleTest() throws Exception {
        Assertions.assertEquals(TriangleArea.calculateArea(2, 2, 2), 1.73285, 0.001);
    }

    @Test
    void triangleNegativeTest() {
        Assertions.assertThrows(Exception.class, () -> TriangleArea.calculateArea(2,2,2));
    }
}
