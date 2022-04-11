import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    BST<Integer, String> bst;

    @BeforeEach
    void setup() {
        bst = new BST<>();

        bst.add(3, "three");
        bst.add(1, "one");
        bst.add(4, "four");
        bst.add(2, "two");
        bst.add(8, "eight");
        bst.add(5, "five");
        bst.add(6, "six");
        bst.add(7, "seven");
    }

    @Test
    void add() {
        assertEquals(8, bst.size());

        assertEquals("one", bst.get(1));
        assertEquals("two", bst.get(2));
        assertEquals("three", bst.get(3));
        assertEquals("four", bst.get(4));
        assertEquals("five", bst.get(5));
        assertEquals("six", bst.get(6));
        assertEquals("seven", bst.get(7));
        assertEquals("eight", bst.get(8));
    }

    @Test
    void getMin() {
        assertEquals("one", bst.getMin());
    }

    @Test
    void getMax() {
        assertEquals("eight", bst.getMax());
    }

    @Test
    void getFloor() {
        assertEquals("eight", bst.getFloor(10));
        assertEquals("one", bst.getFloor(1));
        assertNull(bst.getFloor(0));
    }
}