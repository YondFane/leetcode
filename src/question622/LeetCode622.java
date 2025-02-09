package src.question622;

/**
 622. 设计循环队列
 中等
 相关标签
 相关企业
 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。

 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

 你的实现应该支持如下操作：

 MyCircularQueue(k): 构造器，设置队列长度为 k 。
 Front: 从队首获取元素。如果队列为空，返回 -1 。
 Rear: 获取队尾元素。如果队列为空，返回 -1 。
 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 isEmpty(): 检查循环队列是否为空。
 isFull(): 检查循环队列是否已满。


 示例：

 MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 circularQueue.enQueue(1);  // 返回 true
 circularQueue.enQueue(2);  // 返回 true
 circularQueue.enQueue(3);  // 返回 true
 circularQueue.enQueue(4);  // 返回 false，队列已满
 circularQueue.Rear();  // 返回 3
 circularQueue.isFull();  // 返回 true
 circularQueue.deQueue();  // 返回 true
 circularQueue.enQueue(4);  // 返回 true
 circularQueue.Rear();  // 返回 4


 提示：

 所有的值都在 0 至 1000 的范围内；
 操作数将在 1 至 1000 的范围内；
 请不要使用内置的队列库。
 */
public class LeetCode622 {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        System.out.println(circularQueue.enQueue(4)); // false, queue is full
        System.out.println(circularQueue.Rear()); // 3
        System.out.println(circularQueue.isFull()); // true
        System.out.println(circularQueue.deQueue()); // true
        System.out.println(circularQueue.enQueue(4)); // true
        System.out.println(circularQueue.Rear()); // 4
    }
}
class MyCircularQueue {

    static class CustomLink {
        public int val;
        private CustomLink pre;
        private CustomLink next;
        public CustomLink(int val) {
            this.val = val;
        }
    }

    private CustomLink head;

    private CustomLink rear;

    private int size;

    private int count;

    public MyCircularQueue(int k) {
        size = k;
        count = 0;
    }

    public boolean enQueue(int value) {
        // 队列已满
        if (count >= size) {
            return false;
        }
        // 队列初始化
        if (head == null) {
            head = new CustomLink(value);
            count++;
            rear = head;
            return true;
        }
        // 插入链表
        CustomLink temp = head;
        // 1、找到倒数第一个
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new CustomLink(value);
        count++;
        rear = temp.next;
        return true;
    }

    public boolean deQueue() {
        if (head != null) {
            head = head.next;
            count--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        if (head != null) {
            return head.val;
        }
        return -1;
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        if (rear != null) {
            return rear.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}


/**
 * 优解
 */
class MyCircularQueue2 {

    private int[] data;
    private int front;
    private int rear;
    private int capacity;
    private int length;

    public MyCircularQueue2(int k) {
        data = new int[k];
        capacity = k;
        front = rear = 0;
        length = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        length--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        int head = (front + 1) % capacity;
        return data[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[rear];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }
}