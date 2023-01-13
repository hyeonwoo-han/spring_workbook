import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[28];
        for(int i = 0; i < 28; i++){
            arr[i] = sc.nextInt();
            String newLine = sc.nextLine();
        }

        for(int i = 1; i <= 30; i++){
            for(int j = 1; j <= 30; j++){
                if(arr[i] == j){
                    break; // j for문 탈출
                }else{
                    System.out.println(j);
                }
            }
        }



    }
}
