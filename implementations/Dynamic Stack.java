import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {

    }


    public class DynamicStack {
        Node top;
        int size;

        public DynamicStack(){
            top = null;
            size = 0;
        }

        public void push(int x) {
            Node newElement = new Node(x);
            if (isEmpty()) {
                top = newElement;
            }
            else {
                top.next = newElement;
                top = newElement;
            }
            size++;
        }

        public int pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            if (size == 1) {
                Node lastNode = top;
                top = null;
                top.next = null;
                return lastNode.value;
            }
            else {
                int result = top.value;
                top = top.next;
                return result;
            }
        }


        public int peek() {

        }

        private boolean isEmpty() {
            return (size == 0);
        }



    }



    public class Node {
        int value;
        Node next;

        Node(int x) {
        value = x;
        next = null;
        }
    }
}
