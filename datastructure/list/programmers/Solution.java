import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

class Person {
    boolean isDelete;
    Person prev;
    Person next;
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Person> stack = new Stack<>();
        Person[] table = initTable(n);
        Person cur = table[k];
        for(String c : cmd) {
            cur = carryOutCmd(cur, c, stack);
        }
        return Arrays.stream(table)
                .map(t -> t.isDelete ? "X" : "O")
                .collect(Collectors.joining());
    }

    private Person[] initTable(int n) {
        Person[] table = new Person[n];
        for(int i = 0; i < n; i++) {
            table[i] = new Person();
        }
        for(int i = 1; i < n; i++) {
            table[i - 1].next = table[i];
            table[i].prev = table[i - 1];
        }
        return table;
    }

    private Person carryOutCmd(Person cur, String cmd, Stack<Person> stack) {
        if (cmd.charAt(0) == 'U') {
            int value = Integer.parseInt(cmd.substring(2));
            while (value-- > 0) {
                cur = cur.prev;
            }
        }
        else if (cmd.charAt(0) == 'D') {
            int value = Integer.parseInt(cmd.substring(2));
            while (value-- > 0) {
                cur = cur.next;
            }
        }
        else if (cmd.equals("C")) {
            cur.isDelete = true;
            stack.push(cur);
            Person prev = cur.prev;
            Person next = cur.next;
            if (prev != null && next == null) {
                prev.next = null;
                cur = prev;
            }
            else if (prev == null && next != null) {
                next.prev = null;
                cur = next;
            }
            else if (prev != null && next != null) {
                prev.next = next;
                next.prev = prev;
                cur = next;
            }
        }
        else if (cmd.equals("Z")) {
            Person p = stack.pop();
            p.isDelete = false;
            Person prev = p.prev;
            Person next = p.next;
            if (prev != null && next == null) {
                prev.next = p;
            }
            else if (prev == null && next != null) {
                next.prev = p;
            }
            else if (prev != null && next != null) {
                prev.next = p;
                next.prev = p;
            }
        }
        return cur;
    }
}
