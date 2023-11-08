import org.example.other.Algorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OtherAlgorithmsTest {

    @Test
    @DisplayName("Нелинейное возведение в степень")
    void powTest() {
        Assertions.assertEquals((int)Math.pow(2,7), Algorithms.pow(2,7));
        Assertions.assertEquals((int)Math.pow(2,0), Algorithms.pow(2,0));
        Assertions.assertEquals((long) Math.pow(2,8), Algorithms.pow(2,8));
        Assertions.assertEquals((long) Math.pow(7,3), Algorithms.pow(7,3));
        Assertions.assertEquals((long) Math.pow(2,44), Algorithms.pow(2,44));
    }
}
