package Lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);

    @Test
    @DisplayName("Нормальный треугольник")
    void triangleOk() {
        assertEquals(6, TriangleArea.areaBySides(3,4,5));
    }

    @Test
    @DisplayName("Сторона длиной 0")
    void sideZero() {
        assertNull(TriangleArea.areaBySides(0, 4, 5));
    }

    @Test
    @DisplayName("Короткие стороны")
    void shortSide() {
        assertNull(TriangleArea.areaBySides(1, 4, 5));
    }
}
