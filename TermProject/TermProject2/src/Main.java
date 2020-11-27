import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static int[] data;
	static int N, a, b;
	
	public static int max() { // �ִ밪 ���ϴ� �Լ� ����
		int value=0;
		for(int i=a-1; i<b; i++) {
			if(data[i]>value) value=data[i];
		}
		return value;
	}
	public static int min() { // �ּҰ� ���ϴ� �Լ� ����
		int value=100000;
		for(int i=a-1; i<b; i++) {
			if(data[i]<value) value=data[i];
		}
		return value;
	}
	public static int sum() { // �հ� ���ϴ� �Լ� ����
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
		
		System.out.print("������ ���� N�� ���� ���� k�Է�> ");
		N = scan.nextInt();
		int k = scan.nextInt();
		
		long t1 = System.currentTimeMillis();
		
		data = new int[N];
		for(int i=0; i<N; i++) { // N���� �����͸� �����Լ��� ����
			data[i]=rand.nextInt(1000);
		}
	
		for(int i=0; i<k; i++) { // k�� ������ ���� �ּ�, �ִ�, �հ� ���ϱ�
			b = rand.nextInt(N)+1;
			a = rand.nextInt(b)+1;
			System.out.println((i+1)+"���� ("+a+","+b+") : �ּҰ� = "+min()+" �ִ밪 = "+max()+" �հ� = "+sum());
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println("Elasped time is "+(t2-t1)+"ms.");
		scan.close();
	}
}