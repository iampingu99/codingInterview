package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {

    public static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            max = Math.max(max, rowCheck(i)); //변경 전 행
            for(int j = 0; j < N; j++){
                max = Math.max(max, colCheck(j)); //변경 전 열
                //오른쪽 원소와 교환
                if(j+1 < N && arr[i][j] != arr[i][j+1]){
                    colSwap(i, j); //교환
                    max = Math.max(max, rowCheck(i)); //교환 후 행
                    max = Math.max(max, colCheck(j)); //교환 후 열
                    max = Math.max(max, colCheck(j+1)); //교환 후 오른쪽 열
                    colSwap(i, j); //복구
                }
                //아래쪽 원소와 교환
                if(i+1 < N && arr[i][j] != arr[i+1][j]){
                    rowSwap(i, j); //교환
                    max = Math.max(max, colCheck(j)); //교환 후 열
                    max = Math.max(max, rowCheck(i)); //교환 후 행
                    max = Math.max(max, rowCheck(i+1)); //교환 후 아래쪽 행
                    rowSwap(i, j); //복구
                }
            }
        }
        System.out.println(max);
    }

    public static void rowSwap(int row, int col){
        char temp = arr[row][col];
        arr[row][col] = arr[row+1][col];
        arr[row+1][col] = temp;
    }

    public static void colSwap(int row, int col){
        char temp = arr[row][col];
        arr[row][col] = arr[row][col+1];
        arr[row][col+1] = temp;
    }

    /**
     * 2차원 배열의 행에서 같은 문자의 최대길이를 찾는 함수
     */
    public static int rowCheck(int row){
        int max = 0;
        int count = 1;

        for(int i = 1; i<arr.length; i++){
            if(arr[row][i-1] == arr[row][i]) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    /**
     * 2차원 배열의 열에서 같은 문자의 최대길이를 찾는 함수
     */
    public static int colCheck(int col){
        int max = 0;
        int count = 1;

        for(int i = 1; i<arr.length; i++){
            if(arr[i-1][col] == arr[i][col]) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}