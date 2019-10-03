package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stack636 {

    public static void main(String[] args) {
        int n = 1;

        List logs = Arrays.asList(new String[] {
                "0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"
        });
        exclusiveTime(n, logs);
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<String> stack = new Stack<>();
        for (String log:logs) {
            if (isEnd(log)) {
                int endTime = getTime(log);
                int otherTime = 0;
                while (!stack.isEmpty() && !isStart(stack.peek())) {
                    otherTime += getTime(stack.pop());
                }
                int useTime = endTime - getTime(stack.pop()) + 1;
                result[getFunction(log)] += useTime - otherTime;
                stack.push(getFunction(log) + ":use:" + useTime);
                System.out.println(result[0]);
                System.out.println(stack);
            } else {
                stack.push(log);
            }
        }
        return result;
    }

    public static int getTime(String log) {
        return Integer.parseInt(log.split(":")[2]);
    }
    public static int getFunction(String log) {
        return Integer.parseInt(log.split(":")[0]);
    }

    public static boolean isStart(String log) {
        return log.split(":")[1].equals("start");
    }

    public static boolean isEnd(String log) {
        return log.split(":")[1].equals("end");
    }
}
