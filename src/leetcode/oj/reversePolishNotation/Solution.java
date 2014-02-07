/**
 * 
 */
package leetcode.oj.reversePolishNotation;

import java.util.Stack;

/**
 * @author mark
 *
 */

//http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/

public class Solution {
	
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		int end = tokens.length - 1;
		for (;end > -1;end--) {
			stack.push(tokens[end]);
		}
		
		
		while (stack.size() > 1) {
            int[] values = new int[stack.size()];
            int i = 0;
            while (true) {
                String token = stack.pop();
                if (token.equals("+")) {
                    int a = values[i-2];
                    int b = values[i-1];
                    int v = a+b;
                    stack.push(String.valueOf(v));
                    for(int j = i-3;j>-1;j--) {
                        stack.push(String.valueOf(values[j]));
                    }
                    break;
                } else if (token.equals("*")) {
                    int a = values[i-2];
                    int b = values[i-1];
                    int v = a*b;
                    stack.push(String.valueOf(v));
                    for(int j = i-3;j>-1;j--) {
                        stack.push(String.valueOf(values[j]));
                    }
                    break;
                } else if (token.equals("-")) {
                    int a = values[i-2];
                    int b = values[i-1];
                    int v = a-b;
                    stack.push(String.valueOf(v));
                    for(int j = i-3;j>-1;j--) {
                        stack.push(String.valueOf(values[j]));
                    }
                    break;
                } else if (token.equals("/")) {
                    int a = values[i-2];
                    int b = values[i-1];
                    int v = a/b;
                    stack.push(String.valueOf(v));
                    for(int j = i-3;j>-1;j--) {
                        stack.push(String.valueOf(values[j]));
                    }
                    break;
                } else {
                    values[i] = Integer.valueOf(token);
                    i++;
                }
            }    
        }
        
        return Integer.valueOf(stack.pop().toString());
	}

}
