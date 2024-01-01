package BruteForce;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {

    public static boolean flag = false;
    public static void combination(int arr[], boolean[] visited, int depth, int n, int r, int sum){
        //결과가 출력된 경우
        if(flag) return;
        //다 뽑은 경우
        if(r == 0) {
            //합이 100이 된 경우
            if(sum == 100){
                for(int i = 0; i< visited.length; i++){
                    if(visited[i]) System.out.println(arr[i]);
                }
                flag = true;
                return;
            }
            if(sum > 100) return;
        }

        //뽑아야 하지만 그렇지 못하는 경우
        if(n - depth < r || n == depth) return;

        //현재 인덱스를 뽑는 경우
        visited[depth] = true;
        combination(arr, visited, depth+1, n, r-1, sum + arr[depth]);

        //현재 인덱스를 뽑지 않는 경우
        visited[depth] = false;
        combination(arr, visited, depth+1, n, r, sum);
    }

    public static void useCombination()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        combination(arr, visited, 0, N, 7, 0);
    }

    public static void selectTwo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        int sum = 0;
        boolean flag = false;
        int[] arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i<N && !flag; i++){
            for(int j = i+1; j<N; j++){
                if(sum - (arr[i] + arr[j]) == 100){
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for(int k = 2; k<N; k++){
                        System.out.println(arr[k]);
                    }
                    flag = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        selectTwo();
    }
}
