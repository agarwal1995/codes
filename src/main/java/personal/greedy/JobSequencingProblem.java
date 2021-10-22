package personal.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {

    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, ((o1, o2) -> o2.profit - o1.profit));
        // System.out.println(Arrays.toString(arr));

        int[] sol = new int[2];
        int[] slot = new int[arr.length];
        for(Job job: arr) {
            for(int j=Math.min(job.deadline-1, n-1);j>=0;j--) {
                if(slot[j]==0) {
                    sol[0]++;
                    sol[1]+=job.profit;
                    slot[j] = job.id;
                    break;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        Job job1 = new Job(1,4,20);
        Job job2 = new Job(2,1,10);
        Job job3 = new Job(3,1,40);
        Job job4 = new Job(4,1,30);
        Job[] arr = new Job[4];
        arr[0]=job1;arr[1]=job2;arr[2]=job3;arr[3]=job4;
        System.out.println(Arrays.toString(new JobSequencingProblem().JobScheduling(arr, 4)));
    }
}

@ToString
@Data
@AllArgsConstructor
class Job {
    int id;
    int deadline;
    int profit;
}