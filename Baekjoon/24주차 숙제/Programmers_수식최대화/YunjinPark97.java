import java.util.*;

class Solution {
    static int[] opers = new int[] {-3, -2, -1};
    static boolean[] visited = new boolean[3];
    static int[] order = new int[3];
    static long ans = 0;
    
    public long solution(String expression) {
        List<Long> list = new ArrayList<>();
        long cur = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (isNum(expression.charAt(i))) {
                cur *= 10;
                cur += expression.charAt(i) - '0';
            }
            else {
                list.add(cur);
                if (expression.charAt(i) == '+') {
                    list.add((long) -1);
                } else if (expression.charAt(i) == '-') {
                    list.add((long) -2);
                } else {
                    list.add((long) -3);
                }
                cur = 0;
            }
        }
        list.add(cur);
        System.out.println(list.toString());
        perm(0, list);
        return ans;
    }
    
    static boolean isNum(char a) {
        return (a >= '0' && a <= '9');
    }

    static void perm(int cnt, List<Long> list) {
        if (cnt == 3) {
            calc(list);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            order[cnt] = opers[i];
            perm(cnt+1, list);
            visited[i] = false;
        }
    }

    static void calc(List<Long> list) {
        System.out.println("TEST");
        System.out.println(Arrays.toString(order));
        Queue<Long> queue = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        Queue<Long> queue2 = new ArrayDeque<>();
        System.out.println(queue.toString());
        for (int i = 0; i < 3; i++) {
            long cur = queue.poll();
            int oper = order[i]; // 현재 우선하는 operation
            while (!queue.isEmpty()) {
                long curOper = queue.poll();
                long nxt = queue.poll();
                if (oper == curOper) {
                    if (oper == -1) {
                        cur += nxt;
                    } else if (curOper == -2) {
                        cur -= nxt;
                    } else {
                        cur *= nxt;
                    }
                } else {
                    queue2.offer(cur);
                    queue2.offer(curOper);
                    cur = nxt;
                }
            }
            queue2.offer(cur);
            while (!queue2.isEmpty()) {
                queue.add(queue2.poll());
            }
            System.out.println(queue.toString());
        }

        long temp = queue.poll();
        if (Math.abs(temp) > ans) {
            ans = Math.abs(temp);
        }
    }
}

