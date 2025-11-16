import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int count = 0;
        int idx = 0;

        Arrays.sort(jobs, (e1, e2) -> e1[0] - e2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        
        while (count < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] arr = pq.poll();
                answer += time + arr[1] - arr[0];
                time += arr[1];
                count++;
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}