import java.util.*;

class Medal {
    int num;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Medal(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
    public int getNum() {
        return num;
    }
    public int getGold() {
        return gold;
    }
    public int getSilver() {
        return silver;
    }
    public int getBronze() {
        return bronze;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getRank() {
        return rank;
    }
    public boolean isSame(Medal m) {
        if(this.gold == m.gold && this.silver == m.silver && this.bronze == m.bronze) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int who = scanner.nextInt();
        Medal country[] = new Medal[n];

        for(int i=0; i<n; i++) {
            int num = scanner.nextInt();
            int gold = scanner.nextInt();
            int silver = scanner.nextInt();
            int bronze = scanner.nextInt();
            country[i] = new Medal(num, gold, silver, bronze);
        }
        List<Medal> medalsort = Arrays.asList(country);
        medalsort.sort(Comparator.comparing(Medal::getGold)
                .thenComparing(Medal::getSilver)
                .thenComparing(Medal::getBronze)
        );
        
        int answer = 0;
        country[n-1].setRank(1);
        if(country[n-1].getNum() == who) {
            answer++;
            System.out.println(country[n-1].getRank());
        }
        int i=n-2;

        while(true) {
            if(i==-1 || answer != 0) {
                break;
            }
            if(country[i].isSame(country[i+1])) {
                country[i].setRank(country[i+1].getRank());
            }
            else {
                country[i].setRank(n-i);
            }
            if(country[i].getNum() == who) {
                System.out.println(country[i].getRank());
                break;
            }
            i--;
        }
        scanner.close();
    }
}