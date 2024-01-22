package BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10973 {

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int result[];

    public static void swap(int i, int j){
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

    public static boolean prevPermutation(){
        //수열에서의 가장 긴 오름차순의 마지막 인덱스를 찾기
        int i, j;
        for(i = N-1; i>0; i--){
            if(result[i] < result[i-1]) break;
        }

        if(i == 0) return false;

        //오름차순 수열에서 마지막 인덱스 -1 보다 크면서 가장 작은 숫자찾기
        j = N-1;
        while(result[i-1] < result[j]){
            j--;
        }

        //두 수의 위치를 바꿔 주기
        swap(i-1, j);

        //오름차순 순열을 뒤집기
        j = N-1;
        while(i < j){
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        result = new int[N];
        for(int i = 0; i<N; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }

        if(prevPermutation()){
            for(int val : result){
                sb.append(val).append(' ');
            }
        } else sb.append("-1");
        System.out.println(sb);
    }
}
