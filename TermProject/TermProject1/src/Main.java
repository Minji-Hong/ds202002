
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static int[] data;
	static int N, a, b;
	
	public static int max() { // 최대값 구하는 함수 선언
		int value=0;
		for(int i=a-1; i<b; i++) {
			if(data[i]>value) value=data[i];
		}
		return value;
	}
	public static int min() { // 최소값 구하는 함수 선언
		int value=100000;
		for(int i=a-1; i<b; i++) {
			if(data[i]<value) value=data[i];
		}
		return value;
	}
	public static int sum() { // 합계 구하는 함수 선언
		int value=0;
		for(int i=a-1; i<b; i++) {
			value+=data[i];
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("데이터 개수 N과 구간 a,b를 입력> ");
		N = scan.nextInt();
		a = scan.nextInt();
		b = scan.nextInt();
		
		data = new int[N];
		for(int i=0; i<N; i++) { // N개의 데이터를 랜덤함수로 생성
			data[i]=rand.nextInt(100);
		}
		
		System.out.print(N+"개의 데이터: ");
		for(int k=0; k<N; k++) {
			System.out.print(data[k]+ " ");
		}
		System.out.println();
		
		System.out.println("최소값 = "+min()+" 최대값 = "+max()+" 합계 = "+sum());
		
		scan.close();
	}
}
