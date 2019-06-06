import static org.junit.Assert.*;
import org.junit.Test;

public class DogTest {    
    @Test
    public void testSmall() {
        Dog d = new Dog(3);
        System.out.println(d.noise());
        assertEquals("yip", d.noise());
    }

    @Test
    public void testLarge() {
        Dog d = new Dog(20);
        System.out.println(d.noise());
        assertEquals("bark", d.noise());

    }

    //update
}
