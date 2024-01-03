package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    public static int[][] paper;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int N;
    public static int M;
    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                figure(i, j, paper[i][j], 3);
                visited[i][j] = false;
            }
        }

        System.out.println(MAX);
    }

    public static void figure(int row, int col, int sum, int move) {

        if (move == 0) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curRow = row + dy[i];
            int curCol = col + dx[i];

            if (curRow < 0 || curRow >= N || curCol < 0 || curCol >= M) continue;

            if (!visited[curRow][curCol]) {
                //ㅗ 모양 : 옮기지 않고 탐색
                if(move == 2){
                    visited[curRow][curCol] = true;
                    figure(row, col, sum + paper[curRow][curCol], move-1);
                    visited[curRow][curCol] = false;
                }
                //옮겨가고 탐색
                visited[curRow][curCol] = true;
                figure(curRow, curCol, sum + paper[curRow][curCol], move-1);
                visited[curRow][curCol] = false;
            }
        }
    }
}
