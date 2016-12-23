package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Class for creating a SimpleArrayBag
 * 
 * @author usmana
 * @version 9/24/2016 *
 * @param <T>
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T>
{
    private T[]              bag;
    private static final int MAX = 25;
    private int              numberOfEntries;


    /**
     * constructor for SimpleArrayBag
     */
    public SimpleArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;

    }


    /**
     * adds to bag
     * 
     * @return true if added, else false
     */
    @Override
    public boolean add(T newEntry)
    {

        boolean tmp = true;
        if (newEntry == null)
        {
            return false;
        }

        if (numberOfEntries >= MAX)
        {
            tmp = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }

        return tmp;

    }


    /**
     * gets the current size of the Bag
     * 
     * @return current size of the bag
     */
    @Override
    public int getCurrentSize()
    {
        int size = 0;
        for (int i = 0; i < bag.length; i++)
        {
            if (bag[i] != null)
            {
                size++;
            }
        }
        return size;
    }


    /**
     * checks if the bag is empty
     * 
     * @return true if empty, else false
     */
    @Override
    public boolean isEmpty()
    {
        boolean temp = false;
        if (numberOfEntries == 0)

        {
            temp = true;
        }

        return temp;
    }


    /**
     * picks a random index value in bag
     * 
     * @return <T> the object picked
     */
    @Override
    public T pick()
    {
        T temp;
        TestableRandom generator = new TestableRandom();
        if (isEmpty())
        {
            temp = null;
        }
        else
        {
            int index = generator.nextInt(numberOfEntries);
            temp = bag[index];
        }

        return (T)temp;

    }


    /**
     * gets the index of an entry
     * 
     * @param anEntry
     * @return the index value of anEntry
     */
    private int getIndexOf(T anEntry)
    {
        int temp = -1;
        boolean tempboo = false;
        int index = 0;
        while (!tempboo && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {

                tempboo = true;
                temp = index;
            }
            {
                index++;
            }
        }

        return temp;

    }


    /**
     * Removes and entry from the back
     * 
     * @return true if removed, else false
     */
    @Override
    public boolean remove(T newEntry)
    {
        boolean temp = false;
        if (this.getIndexOf(newEntry) == -1)
        {
            return temp;
        }
        else
        {
            bag[this.getIndexOf(newEntry)] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            temp = true;

        }
        return temp;

    }

}
