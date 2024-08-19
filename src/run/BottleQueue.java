public class BottleQueue
{
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public BottleQueue()
    {
        this.capacity = 5;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enqueue(int element)
    {
        if (isFull())
        {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        return true;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int ret = queue[front];
        front = (front + 1) % capacity;
        size--;
        return ret;
    }

    public boolean isFull()
    {
        return size == capacity;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    public int pushFifo(int element)
    {
        int ret = 0;
        if (this.size >= this.capacity)
        {
            ret = this.dequeue();
        }

        this.enqueue(element);

        return ret;
    }

    public void moveToNext()
    {
        rear = (rear + 1) % capacity;
        front = (front + 1) % capacity;
    }

}
