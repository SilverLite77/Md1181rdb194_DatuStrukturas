import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Md1181rdb194 {
    public static void main(String[] args) {
        int searchNum, notZero = 0, vectorCounter = 0;
        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
                if (arr[i][j] != 0) notZero++;
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ņikita Kikiņovs 12 181RDB194\n");
        System.out.println("Izveidotā matrica:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j <= i) System.out.printf("%5d", arr[i][j]);
                else System.out.printf("%5d", 0);
            }
            System.out.println("");
        }

        System.out.println("\nIzveidotais vektors:");
        int[] vector = new int[notZero];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] != 0) {
                    vector[vectorCounter] = arr[i][j];
                    System.out.printf("%5d", vector[vectorCounter]);
                    vectorCounter++;
                }
            }
        }
        System.out.print("\n\nIevadiet meklējamu vērtību: ");
        if (sc.hasNextInt()) {
            searchNum = sc.nextInt();
        } else {
            System.out.println("Ievades kļūda!");
            sc.close();
            return;
        }

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] == searchNum) {
                indexes.add(i);
            }
        }

        int size = indexes.size();
        if (size == 1) {
            System.out.println("Meklējamā vērtībā " + searchNum + " atrasta vektora elementā ar indeksu: " + (indexes.get(0) + 1));
        } else if (size > 1) {
            System.out.print("Meklējamā vērtībā " + searchNum + " atrasta vektora elementos ar indeksiem: ");
            for (int i : indexes) {
                System.out.print((i + 1) + " ");
            }
        } else {
            System.out.print("Meklējamā vērtībā " + searchNum + " nav atrasta!");
        }

        boolean flag = true;

        while (flag) {
            flag = false;
            for (int j = 0; j < vector.length - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("\nSakārtots vektors, izmantojot „burbuļa” metodi: ");
        for (int i = 0; i < vector.length - 1; i++) {
            System.out.printf("%5d", vector[i]);
        }


    }
}