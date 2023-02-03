package com.geekbrains.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertExample() {
        assertThat(Functions.isPalindrome("1235412")).isFalse();
        assertThat(6).isLessThan(10).isGreaterThan(0);
    }
}