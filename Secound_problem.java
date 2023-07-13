import java.util.Arrays;

public class Secound_problem {
 public static int findMinimumTime(int[] speeds) {
  int n = speeds.length;

  Arrays.sort(speeds);

  int[][] dp = new int[n + 1][n + 1];

  for (int i = 0; i <= n; i++) {
   Arrays.fill(dp[i], -1);
  }

  dp[0][0] = 0;

  for (int i = 0; i <= n; i++) {
   for (int j = 0; j <= n; j++) {
    // Skip the invalid states
    if (i < j || i > n || j > n) {
     continue;
    }


    if (i > 1 && j > 1) {
     int time = Math.max(speeds[i - 1], speeds[j - 1]) + dp[i - 2][j - 2];
     if (dp[i][j] == -1 || time < dp[i][j]) {
      dp[i][j] = time;
     }
    }

    if (i > 0) {
     int time = speeds[i - 1] + dp[i - 1][j];
     if (dp[i][j] == -1 || time < dp[i][j]) {
      dp[i][j] = time;
     }
    }

    if (j > 0) {
     int time = speeds[j - 1] + dp[i][j - 1];
     if (dp[i][j] == -1 || time < dp[i][j]) {
      dp[i][j] = time;
     }
    }
   }
  }

  return dp[n][n];
 }

 public static void main(String[] args) {
  int[] speeds = {1, 2, 5, 10};
  int minimumTime = findMinimumTime(speeds);
  System.out.println("Minimum time to cross the bridge: " + minimumTime + " minutes");
 }
}
