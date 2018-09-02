import java.util.*;

public class Main {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

//  int[] asteroids = {-2, -1, 5, -7, 2, -3, 4};
//	int [] asteroids = {5, 10, -5};
//	int [] asteroids = {8, -8};
//	int [] asteroids = {-2, -1, 1, 2};
//	int [] asteroids = {-2, 1, 5, 7};
//	int [] asteroids = {1,-1,-2,-2};
//  int[] asteroids = {10, 2, -5};
//  int[] asteroids = {-2,-1,1,-2};
        int[] asteroids = {1, 1, 1, -2};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        stack.push(asteroids[0]);                       // push first item in stack
        for (int i = 1; i < asteroids.length; i++) {
            if (stack.isEmpty()) {                      // peek() will fail if stack is empty
                stack.push(asteroids[i]);               // so push an item to stack and proceed with loop
                continue;
            }
            int left = stack.peek();                    // left is stack top
            int right = asteroids[i];                   // right is next array item
            switch (collisionCheck(left, right)) {
                case 0:
                    stack.push(right);                  // if no collision -> push the new item (right)
                    break;
                case 1:
                    break;                              // if right (array item) dies - nothing happens, proceed with loop
                case 2:
                    stack.pop();                        // if left (stack top) dies - pop it out, then
                    stack.push(right);                  // push right (array item) to stack, then
                    checkStack();                       // run a check if the newly pushed item collides with the next stack item
                    break;
                case 3:
                    stack.pop();                        // if both items die remove top of stack and proceed with loop
                    break;
            }
        }
        int[] result = new int[stack.size()];
        int len = stack.size();
        for (int i = len - 1; i > -1; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    // As a new item was put in stack, run a check to see if it collides with next stack item
    // If it collides, proceed recursively until you reach no collision, or stack has < 2 items (no check possible).
    public static void checkStack() {
        if (stack.size() > 1) {
            int second = stack.pop();
            int first = stack.pop();
            switch (collisionCheck(first, second)) {
                case 0:
                    stack.push(first);
                    stack.push(second);
                    break;
                case 1:
                    stack.push(first);
                    break;
                case 2:
                    stack.push(second);
                    checkStack();
                    break;
                case 3:
                    break;
            }
        }
    }

    // Check the two ints for a possible collision
    public static int collisionCheck(int first, int second) {
        if ((first < 0 && second > 0)                                       // if first goes left, second goes right -> no collision
                || haveSameSign(first, second)) {                           // if have same sign -> no collision
            return 0;                                                       // 0 -> no collision
        } else if (Math.abs(first) > Math.abs(second)) {
            return 1;                                                   // 1 -> right dies
        } else if (Math.abs(first) < Math.abs(second)) {
            return 2;                                                   // 2 -> left dies
        } else { // case -> Math.abs(first) == Math.abs(second)
            return 3;                                                   // 3 -> both die
        }
}

    public static boolean haveSameSign(int first, int second) {
        return (first < 0 == second < 0);
    }
}
