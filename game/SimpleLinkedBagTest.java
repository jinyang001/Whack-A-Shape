package game;

import student.TestableRandom;

/**
 * Test class for SimpleLinkedBag
 * @author usmana
 * @version 9/23/2016
 */
public class SimpleLinkedBagTest extends student.TestCase
{

    @SuppressWarnings("rawtypes")
    private SimpleLinkedBag linkedBag;

    @SuppressWarnings("rawtypes")
    private SimpleLinkedBag linkedBag2;


    /**
     * sets up the linkedBag
     */
    @SuppressWarnings({ "rawtypes" })
    public void setUp()
    {
        linkedBag = new SimpleLinkedBag();
        linkedBag2 = new SimpleLinkedBag();

    }


    /**
     * tests to see if something is added to the list
     */
    @SuppressWarnings("unchecked")
    public void testadd()
    {
        linkedBag.add(1);
        assertTrue(linkedBag.add(2));
        assertFalse(linkedBag.add(null));

    }


    /**
     * checks to see the current size of the linkedBag
     */
    @SuppressWarnings("unchecked")
    public void testgetCurrentSize()
    {
        linkedBag.add(1);
        assertEquals(1, linkedBag.getCurrentSize());
    }


    /**
     * checks to see if the linked bag is empty
     */
    public void testisEmpty()
    {
        assertTrue(linkedBag2.isEmpty());

    }


    /**
     * picks a random node in the linked bag
     */
    @SuppressWarnings("unchecked")
    public void testpick()
    {
        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);
        TestableRandom.setNextInts(3, 1, 2);
        assertNull(linkedBag2.pick());
        assertEquals(3, linkedBag.pick());
        assertEquals(2, linkedBag.pick());

    }


    /**
     * removes a specific node in a linked bag
     */
    @SuppressWarnings("unchecked")
    public void testremove()
    {
        linkedBag.add(1);
        linkedBag.add(2);
        linkedBag.add(3);
        assertTrue(linkedBag.remove(2));
        assertFalse(linkedBag.remove(null));
        assertFalse(linkedBag.remove(4));

    }

}
