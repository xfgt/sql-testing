import java.util.Scanner;

public class miroZadacha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Table size [N, M]:");
        System.out.print("N: ");int N = Integer.parseInt(sc.nextLine());
        System.out.print("M: ");int M = Integer.parseInt(sc.nextLine());

        System.out.println("Player coordinates [x, y]:");
        System.out.print("x: ");int x = Integer.parseInt(sc.nextLine());
        System.out.print("y: ");int y = Integer.parseInt(sc.nextLine());

        boolean hasPrintedFig = false;

//top row

//symbols cols
        if (y <= M && x <= N) {
            System.out.print(" ");
            for (int i = 0; i < N; i++) {
                System.out.printf(" %d", i);
            }

            for (int x_j = 1; x_j <= M; x_j++) {
                System.out.println();
//symbols rows
                for (int y_k = 1; y_k <= N; y_k++) {

//cols numbers
                    if (!hasPrintedFig) {
                        if (y_k < 2)
                            System.out.print(x_j - 1);

//symbols on a row
                        if (y == x_j - 1) {
                            if (x == y_k - 1)
                                System.out.print(" o");
                            else
                                System.out.print(" .");
                        } else {
                            System.out.print(" .");

                        }
                    } else {
                        if (y_k < 2)
                            System.out.print(x_j - 1);
                        System.out.print(" .");
                    }


                }
            }
            System.out.println();


        }
        else {
            System.out.printf("\n== Invalid input ==\n\n");
        }
    }
}
