public class DynamicArray<J extends Object>
{
    J[] dynamicArray;
    int maxCapacity;
    int size;
    public DynamicArray(Class<J> object)
    {
        maxCapacity = 5;
        dynamicArray = (J[]) new Object[maxCapacity];
        size = 0;
    }

    private void extend()
    {
        maxCapacity *= 2;
        J[] temp = (J[]) new Object[maxCapacity];
        for (int i = 0; i < size; i++)
        {
            temp[i] = dynamicArray[i];
        }
        dynamicArray = temp;
    }

    public int size()
    {
        return size;
    }

    public void add(J i)
    {
        size++;
        if (size >= maxCapacity)
        {
            extend();
        }
        dynamicArray[size-1] = i;
    }

    public void add(int i, J j)
    {
        if (i > size || i < 0)
        {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }
        size++;
        if (size >= maxCapacity)
        {
            extend();
        }
        for (int index = size-1; index > i; index--)
        {
            dynamicArray[index] = dynamicArray[index-1];
        }
        dynamicArray[i] = j;
    }

    public J remove(int i)
    {
        if (i >= size || i < 0)
        {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }

        J toRemove = dynamicArray[i];
        for(int j = i; j < size ; j++)
        {
            dynamicArray[j] = dynamicArray[j+1];
        }
        size--;
        return toRemove;
    }

    public J remove(J i)
    {
        int index = -1;
        for (int j = 0; j < size; j++)
        {
            if(dynamicArray[j].equals(i))
            {
                index = j;
                break;
            }
        }

        if (index == -1)
        {
            return i;
        }

        for(int j = index; j < size ; j++)
        {
            dynamicArray[j] = dynamicArray[j+1];
        }
        size--;
        return i;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public J get(int i)
    {
        if (i >= size || i < 0)
        {
            return null;
        }
        return dynamicArray[i];
    }

    public void set(int i, J j)
    {
        if (i >= size || i < 0)
        {
            throw new IllegalArgumentException("Array Index out of Bounds!");
        }
        dynamicArray[i] = j;
    }

    public boolean contains(J part)
    {
        for (int i = 0; i < size; i++)
        {
            if (dynamicArray[i].equals(part))
            {
                return true;
            }
        }
        return false;
    }

    public J removeAll(J part)
    {
        for (int i = size-1; i >= 0; i--)
        {
            if (dynamicArray[i].equals(part))
            {
                remove(i);
            }
        }
        return part;
    }


    public void clear()
    {
        size = 0;
    }
}