package BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {

    public static int N;
    public static int W[][];
    public static boolean visited[];
    public static int arr[];
    public static int MIN = Integer.MAX_VALUE;

    public static void TSP(int depth, int sum){
        if(depth == N){
            //처음으로 되돌아 오는 비용
            if(W[arr[depth-1]][0] != 0) {
                MIN = Math.min(MIN, sum + W[arr[depth-1]][arr[0]]);
            }
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            if (W[arr[depth-1]][i] != 0) {
                visited[i] = true;
                arr[depth] = i;
                TSP(depth + 1, sum + W[arr[depth-1]][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        arr = new int[N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //첫 번째 도시 선택 : W[i][i]는 항상 0
        for(int i = 0; i<N; i++){
            visited[i] = true;
            TSP(1, 0);
        }

        System.out.println(MIN);
    }
}
