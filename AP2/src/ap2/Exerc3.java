package ap2;

import java.util.Scanner;

public class Exerc3 {

    public static void main(String[] args) {
        System.out.print(potencia(3, 4) + "\n");
    }

    // método recursivo 
    public static int potencia(int a, int n) {

        if (n == 0) {

            return 1;

        } else {

            return a * potencia(a, n - 1);
        }
    }
}
