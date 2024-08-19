import java.util.*;
class User {
    private int level;
    private String name;

    public User(int level, String name) {
        this.level = level;
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int m = scanner.nextInt();
        User room[][] = new User[p][m];
        User player[] = new User[p];
        int index[] = new int[p];
        int order = 0;

        for(int i=0; i<p; i++) {
            int level = scanner.nextInt();
            String name = scanner.next();
            player[i] = new User(level, name);

            if(order == 0) {
                room[order][index[order]] = player[i];
                index[order]++;
                order++;
            }
            else {
                int count = 0;
                for(int j=0; j<order; j++) {
                    if(room[j][0].getLevel()-10 <= level && room[j][0].getLevel()+10 >= level && index[j] < m) {
                        room[j][index[j]] = player[i];
                        index[j]++;
                        count++;
                        break;
                    }
                }
                if(count == 0) {
                    room[order][index[order]] = player[i];
                    index[order]++;
                    order++;
                }
            }
        }
        for(int i=0; i<order; i++) {
            if(index[i] == m) {
                System.out.println("Started!");
            }
            else {
                System.out.println("Waiting!");
            }

            User tmp[] = new User[index[i]];

            for(int j=0; j<index[i]; j++) {
                tmp[j] = new User(room[i][j].getLevel(), room[i][j].getName());
            }
            List<User> sorting = Arrays.asList(tmp);
            sorting.sort(Comparator.comparing(User::getName));

            for(int j=0; j<index[i]; j++) {
                System.out.println(tmp[j].getLevel() + " " + tmp[j].getName());
            }
        }
        scanner.close();
    }
}