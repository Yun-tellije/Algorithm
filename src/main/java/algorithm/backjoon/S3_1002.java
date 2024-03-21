package algorithm.backjoon;

import java.util.Scanner;

public class S3_1002 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        for (int i=0; i<num; i++) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int r1 = s.nextInt();

            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int r2 = s.nextInt();

            turret(x1,x2,r1,y1,y2,r2);
        }
    }

    private static void turret(int x1, int x2, int r1, int y1, int y2, int r2) {
        int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (distance == 0 && r1 == r2) { // 동일
            System.out.println(-1);
        }
        else if (distance > Math.pow(r2 + r1, 2)) { // 교점이 없을 때
            System.out.println(0);
        }
        else if (distance < Math.pow(r2 - r1, 2)) { // 원 내부에 원이 존재(내접x)
            System.out.println(0);
        }
        else if (distance == Math.pow(r2 - r1, 2)) { // 교점이 하나일 때
            System.out.println(1);
        }
        else if (distance == Math.pow(r2 + r1, 2)) { // 교점이 하나일 때
            System.out.println(1);
        }
        else {
            System.out.println(2);
        }
    }


}
