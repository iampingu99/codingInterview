package Math;

import java.io.*;
import java.util.ArrayList;

public class BOJ6588 {

    private static final int MAX = 1000000;
    private static boolean[] isPrime = new boolean[MAX + 1];
    private static int[] primeArray = new int[MAX+1];
    private static ArrayList<Integer> primeList = new ArrayList<>();

    /**
     * 에라토스테네스의 체
     */
    public static void sieveOfEratosthenes(){
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j <= MAX; j+=i) {
                isPrime[j] = false;
            }
        }
    }

    /**
     * 이진탐색 : N 탐색 실패시 N 보다 작은 값중 가장 큰 값 반환
     */
    public static int binarySearch(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(key == primeArray[mid]) {
                return mid;
            } else if(key < primeArray[mid]) {
                return binarySearch(key ,low, mid-1);
            } else {
                return binarySearch(key, mid+1, high);
            }
        }

        return low-1;
    }

    /**
     * 소수 배열에서 N보다 작은 수 중 가장 큰 소수를 이진탐색으로 찾아 two point 로 A B 찾는 방법
     */
    public static void useTwoPoint() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieveOfEratosthenes();

        int j = 0;
        for(int i = 2; i<=MAX; i++){
            if(isPrime[i]) primeArray[j++] = i;
        }

        int primeLength = j-1;

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;

            int end = binarySearch(num, 1, primeLength);
            int start = 1;

            while(start<=end){
                int sum = primeArray[start] + primeArray[end];
                if(sum == num) {
                    sb.append(num).append(" = ").append(primeArray[start]).append(" + ").append(primeArray[end]).append("\n");
                    break;
                }
                else if(sum < num) start++;
                else end--;
            }
        }
        System.out.println(sb);
    }

    /**
     * 소수 배열에서 가장 작은 홀수부터 A를 시작하여 N - A = B의 값이 소수인지 확인하는 방법
     */
    public static void useOnePoint() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sieveOfEratosthenes();

        int j = 0;
        for(int i = 2; i<=MAX; i++){
            if(isPrime[i]) primeList.add(i);
        }


        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;

            for(int i = 1; i <= primeList.size()/2; i++) {
                int a = primeList.get(i);
                //N - A = B가 소수인지 확인
                if(isPrime[num - a]) {
                    sb.append(num).append(" = ").append(a).append(" + ").append(num-a).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        useOnePoint();
    }
}
