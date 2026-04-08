import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            boolean alive = true;
            
            while (alive && !stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int top = stack.peek();
                if (top < -a) {
                    stack.pop(); // top explodes
                } else if (top == -a) {
                    stack.pop(); // both explode
                    alive = false;
                } else {
                    alive = false; // incoming asteroid explodes
                }
            }
            
            if (alive) {
                stack.push(a);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}