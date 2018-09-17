import java.util.*;

public class Main {

    public static void main(String[] args) {

        StaticQueue queue = new StaticQueue();
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.size);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
        System.out.println("-----------------");
        queue.offer(10);
        queue.printQueue();
        queue.offer(20);  //TODO -> bug - when queue empties does not work
        queue.printQueue();
//        queue.poll();
        queue.offer(30);
        queue.offer(40);
        queue.printQueueArr();
        System.out.println("==================");


        queue.printQueue();
    }





    public static class StaticQueue {
        int[] data;
        int head;
        int tail;
        int size;

        public StaticQueue() {
            head = tail = -1;
            data = new int[20];
            size = 0;
        }

        public void offer(int x) {
            tail++;
            if (size == 0) {
                head = tail;
           }
            if (tail == data.length) {
                resizeData();
            }
            data[tail] = x;
            size++;
        }

        public int poll() throws EmptyStackException {
            if (!isEmpty()) {
                size--;
                head++;
                return data[head-1];
            }
            else {
                throw new EmptyStackException();
            }
        }

        public int peek() throws EmptyStackException{
            if (!isEmpty()) {
                return data[head];
            }
            else {
                throw new EmptyStackException();
            }
        }

        public boolean isEmpty() {
            return (size == 0);
        }

        private void resizeData() {
            data = Arrays.copyOf(data, data.length * 2);
        }

        private void printQueueArr() {
            System.out.println(Arrays.toString(data));
        }

        private void printQueue() {
            while (!isEmpty()) {
                System.out.print(poll() + " ");
            }
            System.out.println();
        }
    }
}
