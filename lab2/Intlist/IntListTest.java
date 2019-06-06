import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3); // new flavour
//        IntList myList = new IntList(1, null);
//        myList.rest = new IntList(2, null);
//        myList.rest.rest = new IntList(3, null);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    @Test
    public void testSquareListIterative(){
        IntList L = IntList.of(5, 6, 7);
        IntList L1 = IntList.squareListIterative(L);
        assertEquals(IntList.of(25,36,49), L1);
        assertEquals(IntList.of(5, 6, 7), L);
    }


    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty of, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3); // A is a class, a reference type, so it is passed by address
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
        /* Q1 */
        // however the IntList returned by IntList.catenate(A, B) has a pointer to B.
        // which means if we change B then the new IntList will also change. Is this correct?

//        IntList A2 = IntList.of(); // A2 is null, a primitive data type, so it is passed by value
//        IntList B2 = IntList.of(4, 5, 6);
//        assertEquals(IntList.of(4, 5, 6),IntList.dcatenate(A2, B2));
//        assertEquals(IntList.of(4, 5, 6),A2); // Always wrong --> A2 will be null forever ??? How to solve that?
//        /* Q2 */
//        // A2 is null, a primitive data type, so it is passed by value
//        // Always wrong <-- A2 will be null forever ??? How to solve that?

    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);

    }

}
