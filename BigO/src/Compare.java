
public class Compare {
 
    public static void main(String[] args) {
        tid(100000000L);
        tid(1000000000L);
        tid(10000000000L);
    }
   
    public static void tid(long n) {
        float start = System.nanoTime();
        long k = 0;
        for(long i = 1; i <= n; i++) {
            k = k+5;
        }
        float slutt = System.nanoTime();
       
        System.out.println((slutt - start)/1000000);
    }

}