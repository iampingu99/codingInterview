package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17425 {

    /**
     * 배수를 이용하여 자연수 N이 주어질 때마다 g(n)을 구하는 방법
     */
    public static int countMultiples(int number){
        int sum = 0;
        for(int i=1; i<=number; i++){
            sum += i * (number/i);
        }
        return sum;
    }
    public static void useCountMultiples() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            sb.append(countMultiples(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 배수를 이용하여 입력값의 최대인 1000000까지의 각각의 g(n)을 구해서 저장해 놓는 방법
     */
    static final int MAX = 1000000;

    public static void useDivisorSumDP() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long fx[] = new long[MAX+1];

        for(int i = 1; i<=MAX; i++){
            for(int j = 1; i*j<=MAX; j++){
                fx[i*j] += i;
            }
        }

        for(int i = 2; i<=MAX; i++){
            fx[i] += fx[i-1];
        }
        while(N-->0){
            sb.append(fx[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        useDivisorSumDP();
    }
}
