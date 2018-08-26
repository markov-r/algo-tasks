import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String positions = in.readLine();
        String pathStr[] = in.readLine().split(" ");
        int path[] = new int [pathStr.length];
        for (int i = 0; i < pathStr.length; i++)
        {
            path[i] = Integer.parseInt(pathStr[i]);
        }

        int souls = 0;
        int food = 0;
        int deadlock = 0;
        boolean isDeadlocked = false;
        StringBuilder positionsSb = new StringBuilder(positions);

        if (positionsSb.charAt(0) == '@')
        {
            souls++;
            positionsSb.setCharAt(0, 'U');
        }
        if (positionsSb.charAt(0) == '*')
        {
            food++;
            positionsSb.setCharAt(0, 'U');
        }
        if (positionsSb.charAt(0) == 'x')
        {
            deadlock++;
            positionsSb.setCharAt(0, 'U');
            isDeadlocked = true;
        }

        int currentPos = 0;
        int numOfJumps = 0;

        if (!isDeadlocked)                                      // if 0 position is not a deadlock
        {
            for (int i = 0; i < path.length; i++)
            {
                numOfJumps++;
                currentPos += path[i];
                if (currentPos > positions.length() - 1)
                {
                    currentPos = currentPos % positions.length();
                }
                if (currentPos < 0)
                {
                    while (currentPos < 0)
                    {
                        currentPos += positions.length();
                    }
                }
                if (positionsSb.charAt(currentPos) == '@')
                {
                    souls++;
                    positionsSb.setCharAt(currentPos, 'U');
                }
                if (positionsSb.charAt(currentPos) == '*')
                {
                    food++;
                    positionsSb.setCharAt(currentPos, 'U');
                }
                if (positionsSb.charAt(currentPos) == 'x')
                {
                    deadlock++;
                    if (currentPos % 2 == 0)
                    {
                        souls--;
                        positionsSb.setCharAt(currentPos, '@');
                    }
                    else
                        {
                        food--;
                        positionsSb.setCharAt(currentPos, '*');
                        }
                }
                if (souls < 0 || food < 0)
                {
                    isDeadlocked = true;
                    break;
                }
            }
        }
        if (isDeadlocked)
        {
            System.out.println("You are deadlocked, you greedy kitty!");
            System.out.println("Jumps before deadlock: " + numOfJumps);
        }
        else
        {
            System.out.println("Coder souls collected: " + souls);
            System.out.println("Food collected: " + food);
            System.out.println("Deadlocks: " + deadlock);
        }
    }
}