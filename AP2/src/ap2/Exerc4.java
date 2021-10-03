package ap2;

public class Exerc4 {
    
    public static void main(String[] args) {
        
        decParaBin(72);
        System.out.println("\n");
        
    }
    
    private static void decParaBin(int n) {
        if (n > 0) {
            decParaBin(n / 2);
            System.out.print(n % 2);
        }
    }
    
}
