public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int sumx = 0;
        while (x < 10) {
            sumx += x;
            System.out.print( sumx + " ");
            x = x + 1;
        }
    }
}