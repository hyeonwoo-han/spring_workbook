import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < N; i++){
            if(Main.isHansu(i + 1)) sum += 1;
        }

        System.out.println(sum);
    }

    public static boolean isHansu(int n) {

        if(n < 100){
            return true;
        }else{
            int hundred = n / 100;
            int ten = (n % 100) / 10;
            int one = (n % 10);

            return (hundred - ten) == (ten - one) ? true : false;
        }
    }
}