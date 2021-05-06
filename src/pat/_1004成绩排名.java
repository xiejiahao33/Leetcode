package pat;


import java.util.Scanner;

class People{
    String name;
    String ID;
    int score;
    public People(){}
}


public class _1004成绩排名 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        People[] people = new People[n];

        int high = 0, low = 100;
        for (int i = 0; i < n; i++) {
            people[i] = new People();
            people[i].name = sc.next();
            people[i].ID = sc.next();
            people[i].score = sc.nextInt();

            high = high > people[i].score ? high : people[i].score;
            low = low < people[i].score ? low : people[i].score;
        }

        for (int i = 0; i < n; i++) {
            if (people[i].score == high) {
                System.out.println(people[i].name + " " + people[i].ID);
            }
        }
        for (int i = 0; i < n; i++) {
            if (people[i].score == low) {
                System.out.println(people[i].name + " " + people[i].ID);
            }

        }

    }
}
