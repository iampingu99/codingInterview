package Math;

import java.io.*;
import java.math.BigInteger;

public class BOJ4375 {

    /**
     * BigInteger 사용하여 계산 범위를 늘리는 방법
     */
    public void useBigInteger() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            BigInteger A = new BigInteger(line);
            BigInteger base = BigInteger.ONE;
            for(int i = 1; ; base = base.multiply(BigInteger.TEN).add(BigInteger.ONE), i++){
                if(base.remainder(A).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    /**
     * 나머지 연산 규칙 (A+B)%C = A%C + B%C
     * 앞선 나머지 계산 결과를 활용하는 방법
     */
    public void useModuloRule() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int A = Integer.parseInt(line);
            int base = 1;
            for(int i =1; ;i++){
                base = base*10+1;
                if((base%=A) == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new BOJ4375().useModuloRule();
    }
}
