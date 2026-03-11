import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && a < 0 && stack.peek() > 0) {

                if (Math.abs(a) > stack.peek()) {
                    stack.pop(); // stack asteroid explodes
                }
                else if (Math.abs(a) == stack.peek()) {
                    stack.pop(); // both explode
                    alive = false;
                }
                else {
                    alive = false; // current asteroid explodes
                }
            }

            if (alive) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}