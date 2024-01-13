// 1. order와 stack 맨위 값이 같은 경우, stack 맨위 제거, order 1 증가

// 2. order와 현재 상자가 같은 경우, order 1 증가, 현재 상자 1 증가

// 3. order가 현재 상자보다 큰 경우, 현재 상자 스택에 넣기, 현재 상자 1 증가

// 4. 나머지 경우 반복문 종료

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int orderIndex = 0;
        int currentBox = 1;
        while(orderIndex < order.length) {
            if (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                stack.pop();
                orderIndex++;
            }
            else if(order[orderIndex] == currentBox) {
                orderIndex++;
                currentBox++;
            }
            else if (order[orderIndex] > currentBox){
                stack.push(currentBox++);
            }
            else {
                break;
            }
        }
        return orderIndex;
    }
}