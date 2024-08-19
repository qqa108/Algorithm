import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int timeline[] = new int[n+2];

        timeline[0] = 0;
        timeline[n+1] = 2880;

        int scoreA = 0;
        int scoreB = 0;
        int lead = 0;
        int alead = 0;
        int blead = 0;
        int scorechange = 0;

        for(int i=1; i<=n; i++) {
            int goal = scanner.nextInt();
            String s = scanner.next();
            int min = Integer.valueOf((s.charAt(0)-48)*10 + s.charAt(1)-48);
            int sec = Integer.valueOf((s.charAt(3)-48)*10 + s.charAt(4)-48);

            if(goal == 1) {
                timeline[i] = min*60 + sec;
                scoreA++;
            }
            else {
                timeline[i] = min*60 + sec;
                scoreB++;
            }

            if(scoreA - scoreB == 1 && lead != 1) {
                scorechange = timeline[i];
                lead = 1;
            }
            else if(scoreA - scoreB == -1 && lead != -1) {
                scorechange = timeline[i];
                lead = -1;
            }

            if(lead == 1 && scoreA == scoreB) {
                alead = alead + (timeline[i] - scorechange);
                lead = 0;
            }
            else if(lead == -1 && scoreA == scoreB) {
                blead = blead + (timeline[i] - scorechange);
                lead = 0;
            }
        }
        if(scoreA > scoreB) {
            alead = alead + timeline[n+1] - scorechange;
        }
        else if(scoreA < scoreB) {
            blead = blead + timeline[n+1] - scorechange;
        }

        if(alead/60 < 10) {
            if(alead%60 < 10) {
                System.out.println("0" + alead/60 + ":0" + alead%60);
            }
            else {
                System.out.println("0" + alead/60 + ":" + alead%60);
            }
        }
        else {
            if(alead%60 < 10) {
                System.out.println(alead/60 + ":0" + alead%60);
            }
            else {
                System.out.println(alead/60 + ":" + alead%60);
            }
        }

        if(blead/60 < 10) {
            if(blead%60 < 10) {
                System.out.println("0" + blead/60 + ":0" + blead%60);
            }
            else {
                System.out.println("0" + blead/60 + ":" + blead%60);
            }
        }
        else {
            if(blead%60 < 10) {
                System.out.println(blead/60 + ":0" + blead%60);
            }
            else {
                System.out.println(blead/60 + ":" + blead%60);
            }
        }

        scanner.close();
    }
}