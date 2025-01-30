// Question:

import java.util.*;

class SortingAStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        Stack<Integer> helperStack = new Stack<>();
        boolean isTest = true;
        while (!input.isEmpty()) {
            int toBeAdded = input.peek();
            if (isTest) {
                System.out.println("toBeAdded: " + toBeAdded);
                System.out.println("input so far: " + input);
                System.out.println("tmpStack so far: " + tmpStack);
            }
            if (tmpStack.isEmpty()) {
                tmpStack.push(toBeAdded);
                input.pop();
            } else {
                // 1. move all elements > to be added to helper until top of tmpStack
                // is an element <= toBeAdded is encountered.
                // Hence, range of all elements in helperStack: [toBeAdded + 1, Integer.MAX_VALUE]
                while (!tmpStack.isEmpty() && tmpStack.peek() > toBeAdded) {
                    helperStack.push(tmpStack.pop());
                }
                // 2. add toBeAdded into tmpStack. Currently, tmpStack contains values in descending order up to toBeAdded
                // meaning range of values in stack: [-Integer.MIN_VALUE, toBeAdded]
                tmpStack.push(toBeAdded);

                // 3. Move all elements > toBeAdded into the tmpStack.
                // Hence, the stack is in descending order,
                while (!helperStack.isEmpty()) {
                    tmpStack.push(helperStack.pop());
                }
            }
        }
        return tmpStack;
    }
}
