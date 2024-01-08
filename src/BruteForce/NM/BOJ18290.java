package BruteForce.NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18290 {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M, K;
    public static int matrix[][];
    public static boolean visited[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int MAX = Integer.MIN_VALUE;

    public static void matrixPermutation(int row, int col, int sum, int k){
        if(k == K){
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = row; i<N; i++){
            for(int j = (i == row) ? col : 0; j<M; j++){
                if(isAdj(i, j)) continue;
                visited[i][j] = true;
                matrixPermutation(i, j+1,sum + matrix[i][j], k+1);
                visited[i][j] = false;
            }
        }
    }

    public static boolean isAdj(int row, int col){
        for(int i = 0; i<4; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(newRow >= N || newCol >= M || newRow < 0 || newCol < 0) continue;
            if(visited[newRow][newCol]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrixPermutation(0, 0, 0, 0);
        System.out.println(MAX);
    }
}
