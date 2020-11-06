
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
		
		System.out.print("������ ���� N�� ���� a,b�� �Է�> ");
		N = scan.nextInt();
		a = scan.nextInt();
		b = scan.nextInt();
		
		data = new int[N];
		for(int i=0; i<N; i++) { // N���� �����͸� �����Լ��� ����
			data[i]=rand.nextInt(100);
		}
		
		System.out.print(N+"���� ������: ");
		for(int k=0; k<N; k++) {
			System.out.print(data[k]+ " ");
		}
		System.out.println();
		
		System.out.println("�ּҰ� = "+min()+" �ִ밪 = "+max()+" �հ� = "+sum());
		
		scan.close();
	}
}
