package com.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmptyBox {
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

        @Test
        void whereDeleteBallThenExeption() {
            Assertions.assertThrows(BoxIsEmptyException.class, () -> box.deleteBall());
        }


        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void deleteBall() throws BoxIsEmptyException {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallsCount());
            }
        }
        }

        @Nested
    class TestCl {

        }

}
