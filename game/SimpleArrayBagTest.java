package game;

import student.TestableRandom;

/**
 * Test class for SimpleArrayBag
 * 
 * @author usmana
 * @version 9/23/2016
 */
public class SimpleArrayBagTest extends student.TestCase
{
    @SuppressWarnings("rawtypes")
    private SimpleArrayBag bagArray;
    @SuppressWarnings("rawtypes")
    private SimpleArrayBag bagArray2;
    @SuppressWarnings("rawtypes")
    private SimpleArrayBag bagArray3;
    private Object         obj = null;


    /**
     * sets up the tests
     */

    public void setUp()
    {
        bagArray = new SimpleArrayBag<>();
        bagArray2 = new SimpleArrayBag<>();
        bagArray3 = new SimpleArrayBag<>();

    }


    /**
     * tests adding to a bag
     */
    @SuppressWarnings("unchecked")
    public void testadd()
    {
        bagArray.add(1);
        bagArray.add(2);
        bagArray.add(3);
        assertTrue(bagArray.add(4));
        assertFalse(bagArray.add(obj));
        for (int i = 0; i < 25; i++)
        {

            bagArray3.add(i);
        }
        assertFalse(bagArray3.add(25));

    }


    /**
     * tests the current size of the bag
     */
    @SuppressWarnings("unchecked")
    public void testgetCurrentSize()
    {
        bagArray.add(1);
        bagArray.add(2);
        bagArray.add(3);
        assertEquals(3, bagArray.getCurrentSize(), 0.01);

    }


    /**
     * tests the private method indexOf through remove()
     */
    @SuppressWarnings("unchecked")
    public void testgetIndexOf()
    {
        bagArray.add(1);
        bagArray.add(2);
        bagArray.add(3);
        assertTrue(bagArray.remove(2));

    }


    /**
     * tests to see if bag is empty
     */
    @SuppressWarnings("unchecked")
    public void testisEmpty()
    {
        bagArray.add(1);
        assertTrue(bagArray2.isEmpty());
        assertFalse(bagArray.isEmpty());

    }


    /**
     * tests a random index from the bag and returns a type T
     */
    @SuppressWarnings("unchecked")
    public void testpick()
    {
        bagArray.add(1);
        bagArray.add(2);
        bagArray.add(3);
        TestableRandom.setNextInts(3);
        assertEquals(1, bagArray.pick());
        assertNull(bagArray2.pick());

    }


    /**
     * tests to see if something is removed
     */
    @SuppressWarnings("unchecked")
    public void testremove()
    {
        bagArray.add(1);
        bagArray.add(2);
        bagArray.add(3);
        assertFalse(bagArray.remove(9));
        assertTrue(bagArray.remove(3));
    }

}
