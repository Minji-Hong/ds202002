import java.util.Scanner;

public class Main {
	static long histo(int[] v, int a, int b) {
		if(a==b) return v[a]; // ������ �ϳ��� �װ��� ���̰� �ִ����
		int c = (a+b)/2, r=2;
		long min = (v[c]<v[c+1])?v[c]:v[c+1]; // ���� �� ����
		long max = min*r;
		int i = c-1, j = c+2;
		while(i>=a && j<=b) {
			if(v[i]>v[j]) {
				if(v[i]<min) min=v[i];
				i--;
			} else {
				if(v[j]<min) min=v[j];
				j++;
			}
			if(max<min*(++r)) max = min*r;
		}
		while(i>=a) {
			if(v[i]<min) min=v[i];
			if(max<min*(++r)) max = min*r;
			i--;
		}
		while(j<=b) {
			if(v[j]<min) min=v[j];
			if(max<min*(++r)) max = min*r;
			j++;
		}
		long left = histo(v, a, c);
		long right = histo(v, c+1, b);
		if(max<left) max=left;
		if(max<right) max=right;
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("���� ���� >");
		int n = scan.nextInt();
		int[] v = new int[n];
		
		System.out.print("�� ���� �� �Է� > ");
		for(int i=0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		System.out.println(histo(v,0,n-1));
	}
}
