import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] bits = {1, 0, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }

    private static boolean isOneBitCharacter(int[] bits) {
        if (bits.length > 1 && bits[bits.length - 2] == 0) { // if last two bits are "00" -> return true
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();           // could be LinkedList as well, but Deque should be faster
        for (int bit : bits) {                               // need to remove from front in constant time
            deque.add(bit);
        }
        return isOneBitCharacterList(deque);
    }

    private static boolean isOneBitCharacterList(Deque<Integer> deque) {
        if (deque.size() == 1) {
            return true;                // last bit can only be 0
        } else if (deque.isEmpty()) {
            return false;               // last time we removed two (as we passed (deque.size() == 1) => therefore false
        }

        int bit = deque.removeFirst();
        if (bit == 0) {                              // if removed bit is "0" proceed with recursion
            return isOneBitCharacterList(deque);
        } else {
            deque.removeFirst();                     // if the bit is "1" remove one more (dont care if it is 0 or 1) and proceed
            return isOneBitCharacterList(deque);
        }
    }
}
