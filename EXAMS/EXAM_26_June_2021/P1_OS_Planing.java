package ADVANCED.EXAMS.EXAM_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_OS_Planing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> tasksList = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> threadsList = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int taskToKill = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        for (Integer integer : tasksList) {
            taskStack.push(integer);
        }
        for (Integer integer : threadsList) {
            threadQueue.offer(integer);
        }

        while (!taskStack.isEmpty() && !threadQueue.isEmpty()) {
            int currTask = taskStack.peek();
            int currThread = threadQueue.peek();

            if (taskToKill == currTask) {
                System.out.printf("Thread with value %d killed task %d\n", currThread, taskToKill);
                break;
            }

            if (currThread >= currTask) {
                taskStack.pop();
                threadQueue.poll();
            }
            if (currThread < currTask) {
                threadQueue.poll();
            }
        }
        System.out.println(threadQueue.toString().replaceAll("[\\[\\],]", ""));
    }
}
