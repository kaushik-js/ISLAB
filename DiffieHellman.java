import java.util.*;
class DiffieHellman {
   public static void main(String[] args)
   {
       long n, g, a, x, b, y, Nx, Ny;
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter value for public key N: ");
       n = sc.nextLong();
       System.out.print("Enter value for public key G: ");
       g = sc.nextLong();
       System.out.print("Enter value for private key x selected by user 1: ");
       x = sc.nextLong();
       System.out.print("Enter value for private key y selected by user 2: ");
       y = sc.nextLong();
       a = calculatePower(g, x, n);
       b = calculatePower(g, y, n);
       Nx = calculatePower(b, x, n);
       Ny = calculatePower(a, y, n);
       System.out.println("Secret key for User 1 is: " + Nx);
       System.out.println("Secret key for User 2 is: " + Ny);
       sc.close();
   }
   private static long calculatePower(long a, long b, long D)
   {
       long result = 0;
       if (b == 1){
           return a;
       }
       else{
           result = ((long)Math.pow(a, b)) % D;
           return result;
       }
   }
}
