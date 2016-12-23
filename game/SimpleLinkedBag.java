package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Creates a Bag from a LinkedList
 * 
 * @author usmana
 * @version 9/23/2016
 * @param <T>
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T>
{

    private Node<T> firstNode;
    private int     numberOfEntries;


    /**
     * Constructor for SimpleLinkedBag
     */
    public SimpleLinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * adds and entry to the linkedBag
     * 
     * @return true if added, else false
     */
    @Override
    public boolean add(T newEntry)
    {
        boolean temp = false;
        Node<T> newNode = new Node<>(newEntry);
        if (newEntry == null)
        {
            return false;
        }

        if (isEmpty())
        {
            firstNode = newNode;
            temp = true;
            numberOfEntries++;

        }
        else
        {

            newNode.setNext(firstNode);
            firstNode = newNode;

            numberOfEntries++;
            temp = true;
        }

        return temp;

    }


    /**
     * @return the current number of entries in the linkedbag
     */
    @Override
    public int getCurrentSize()
    {

        return numberOfEntries;
    }


    /**
     * checks to see if LinkedBag is empty
     * 
     * @return true if empty, else false
     */
    @Override
    public boolean isEmpty()
    {
        boolean temp = false;
        if (firstNode == null)
        {
            temp = true;
        }
        return temp;

    }


    /**
     * @return <T> data picks a random node and return the data
     */

    @Override
    public T pick()
    {
        if (isEmpty())
        {

            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        Node<T> temp;
        temp = firstNode;

        for (int i = 0; i < index; i++)
        {
            temp = temp.next();

        }

        return (T)temp.data();
    }


    /**
     * gets the refrence to an entry
     * 
     * @param anEntry
     * @return gets reference to the node and returns the Node
     */
    @SuppressWarnings("unchecked")
    private T getReferenceTo(T anEntry)
    {

        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals((currentNode.data())))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next();
            }
        }
        return (T)currentNode;

    }


    /**
     * removes and entry from the linked list
     * 
     * @return true if removed, else false
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean remove(T anEntry)
    {
        boolean temp = false;
        if (anEntry == null)
        {
            return temp;
        }
        else
        {

            Node<T> foundEntry = (Node)getReferenceTo(anEntry);
            if (foundEntry != null)
            {
                foundEntry.setData((T)firstNode.data());
                firstNode = firstNode.next();
                temp = true;
                numberOfEntries--;
            }
        }

        return temp;

    }

}
