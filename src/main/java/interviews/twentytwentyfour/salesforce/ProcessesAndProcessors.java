package interviews.twentytwentyfour.salesforce;

import java.util.*;

public class ProcessesAndProcessors {
    /*
    * Problem Statement: Given n processes that need to be executed. Among these n processes, k are high-priority
    * processes.
    *
    * An OS scheduler is responsible for overseeing the execution of all processes. When a scheduler assigns a set of
    * processes to a processor it has 2 options:
    * 1. if total processes are >1 and even, it can divide the array of processes, denoted as p, into contiguous
    * sub-arrays of equal length, p1 & p2, such that p = [p1, p2]. The scheduler will then allocate p1 to one processor
    * and p2 to another.
    * 2. Alternatively, the scheduler can choose to execute the assigned array of processes, p.
    *
    * The time required for process execution is determined based on the following criteria:
    * 1. If the assigned processes do not include any high-priority processes then the scheduler will take normal_time
    * seconds to complete all the assigned processes.
    * 2. If there are high-priority processes among the assigned tasks(denoted as X),
    * it will take (priority_time * X * l) seconds to complete them, where l is total no. of assigned processes.
    *
    * The total time required to execute all the processes is the sum of the time taken by all the processors for their
    * assigned tasks. The task is to minimize the total execution time by optimizing the assignment of processes
    * to processors within the OS and this minimum possible execution time.
    *
    * Input 1: n=4, high_priority=[1], normal_time=2, priority_time=2
    * Output 1: 6
    * Explanation:
    *   assign processes [1,2] to processor p1-> total_time= (2 * 1 * 2) = 4 secs
    *   assign processes [3,4] to processor p2-> total_time= 2 seconds
    *
    *   Total time = 4 + 2 = 6 secs
    *
    * Input 2: n=4, high_priority=[1, 4], normal_time=1, priority_time=5
    * Output 2: 12
    * Explanation:
    *   assign processes [1] to processor p1-> total_time= (5 * 1 * 1) = 5 secs
    *   assign processes [2] to processor p2-> total_time= 1 sec
    *   assign processes [3] to processor p3-> total_time= 1 sec
    *   assign processes [4] to processor p4-> total_time= (5 * 1 * 1) = 5 secs
    *
    *   Total time = 5 + 1 + 1 + 5 = 12 secs
    *
    * Input 1: n=1, high_priority=[1], normal_time=5, priority_time=100
     * Output 1: 100
     * Explanation: there is only 1 option
     *   assign processes [1] to processor p1-> total_time= (100 * 1 * 1) = 100 secs
     *
     *   Total time = 100 secs
    * */

    public int calcTime(List<Integer> processes, Set<Integer> highPriority, int normal_time, int priority_time) {
        int countOfHighPriorityProcesses = 0;

        for (int process: processes) {
            if (highPriority.contains(process))
                countOfHighPriorityProcesses++;
        }

        if (countOfHighPriorityProcesses == 0)
            return normal_time;
        else
            return priority_time * countOfHighPriorityProcesses * processes.size();
    }

    /*Below is wrong algo given by chatGPT*/
    /*public int assignProcesses(List<Integer> processes, Set<Integer> highPriority, int normal_time, int priority_time, int current_time) {
        if (processes.isEmpty())
            return current_time;
        if (processes.size() == 1)
            return current_time + calcTime(processes, highPriority, normal_time, priority_time);

        int minTime = Integer.MAX_VALUE;
        if (processes.size() % 2 == 0) {
            int mid = processes.size() / 2;
            List<Integer> left = processes.subList(0, mid);
            List<Integer> right = processes.subList(mid, processes.size());

            int leftTime = calcTime(left, highPriority, normal_time, priority_time);
            int rightTime = calcTime(right, highPriority, normal_time, priority_time);

            minTime = Math.min(minTime, assignProcesses(left, highPriority, normal_time, priority_time, current_time + rightTime));
            minTime = Math.min(minTime, assignProcesses(right, highPriority, normal_time, priority_time, current_time + leftTime));
        } else {
            minTime = Math.min(minTime, calcTime(processes, highPriority, normal_time, priority_time) + current_time);
        }

        return minTime;
    }*/

    /*Below is correct algo*/
    public int assignProcesses(List<Integer> processes, Set<Integer> highPriority, int normal_time, int priority_time, int parts) {
        if (parts > processes.size())
            return Integer.MAX_VALUE;
        int totalTime = 0;
        int partSize = processes.size() / parts;
        int start = 0 , end = partSize;


        for (int i=0; i<parts; i++) {
            totalTime += calcTime(processes.subList(start, end), highPriority, normal_time, priority_time);

            start = end;
            end += partSize;
        }

        return Math.min(totalTime, assignProcesses(processes, highPriority, normal_time, priority_time, parts * 2));
    }

    public int assignProcesses(int n, List<Integer> highPriority, int normal_time, int priority_time) {
        List<Integer> processes = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            processes.add(i);
        }

        return assignProcesses(processes, new HashSet<>(highPriority), normal_time, priority_time, 1);
    }

    public static void main(String[] args) {
        ProcessesAndProcessors pp = new ProcessesAndProcessors();

        System.out.println(pp.assignProcesses(4, Arrays.asList(1), 2, 2));
        System.out.println(pp.assignProcesses(4, Arrays.asList(1, 4), 1, 5));
        System.out.println(pp.assignProcesses(1, Arrays.asList(1), 5, 100));
    }
}