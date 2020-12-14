import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static int[] data;
	static long[] sumdata;
	static int N, a, b;
	
	public static int max() { // 최대값 구하는 함수 선언
		int value=data[a-1];
		for(int i=a; i<b; i++) {
			if(data[i]>value) value=data[i];
		}
		return value;
	}
	public static int min() { // 최소값 구하는 함수 선언
		int value=data[a-1];
		for(int i=a; i<b; i++) {
			if(data[i]<value) value=data[i];
		}
		return value;
	}
	public static long sum() { // 합계 구하는 함수 선언
		if(a==1) return sumdata[b-1];
		return sumdata[b-1]-sumdata[a-2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random(100);
		
		System.out.print("데이터 개수 N과 구간 개수 k입력> ");
		N = scan.nextInt();
		int k = scan.nextInt();
		
		long t1 = System.currentTimeMillis();
		
		data = new int[N];
		sumdata = new long[N];
		
		for(int i=0; i<N; i++) { // N개의 데이터를 랜덤함수로 생성
			data[i]=rand.nextInt(100000000);
		}
		
		sumdata[0]=data[0];
		for(int i=1; i<N; i++) {
			sumdata[i] = sumdata[i-1]+ data[i];
		}
		for(int i=0; i<k; i++) { // k개 구간에 대해 최소, 최대, 합계 구하기
			b = rand.nextInt(N)+1;
			a = rand.nextInt(b)+1;
			System.out.println((i+1)+"구간 ("+a+","+b+") : 최소값 = "+min()+" 최대값 = "+max()+" 합계 = "+sum());
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println("Elasped time is "+(t2-t1)+"ms.");
		scan.close();
	}
}
