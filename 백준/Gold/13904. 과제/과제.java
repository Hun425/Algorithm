import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static List<int[]> tasks = new ArrayList<>();
    static List<Integer> usableTasks = new ArrayList<>();
    static int maxDeadline = 0;
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();

            if (maxDeadline < d) {
                maxDeadline = d;
            }

            tasks.add(new int[]{d, w});
        }

        solve();
        System.out.println(maxScore);
    }

    public static void solve() {
        for (int currentDay = maxDeadline; currentDay > 0; currentDay--) {
            updateUsableTasks(currentDay);
            assignMaxScoreTask();
        }
    }

    private static void updateUsableTasks(int currentDay) {
        List<int[]> remainingTasks = new ArrayList<>();
        for (int[] task : tasks) {
            if (task[0] >= currentDay) {
                usableTasks.add(task[1]);
            } else {
                remainingTasks.add(task);
            }
        }
        tasks = remainingTasks;
    }

    private static void assignMaxScoreTask() {
        if (!usableTasks.isEmpty()) {
            Integer maxValue = usableTasks.stream()
                    .max(Comparator.comparingInt(x -> x))
                    .orElseThrow(NoSuchElementException::new);

            usableTasks.remove(maxValue);
            maxScore += maxValue;
        }
    }
}