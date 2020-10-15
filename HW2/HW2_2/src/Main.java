import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] stack;
	static int push_n; // stack배열에 넣을 숫자
	static int top;
	static boolean stop; // NO 처리하기 위한 변수
	static char[] output; // +,- 결과 넣을 배열
	static int output_index;
	
	public static void calc(int k) {
		while(true) {
			if(k>stack[top]) {
				push();
			}
			else if(k==stack[top]) {
				pop();
				break;
			}
			else if(k<stack[top]) {
				stop=true;
				break;
			}
		}
	}
	
	public static void push() {
		stack[++top]=push_n++;
		output[output_index++]='+';
	}
	public static void pop() {
		top--;
		output[output_index++]='-';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		stack = new int[N+1]; output = new char[2*N];
		push_n=0; top = 0; stop=false; output_index=0;
		stack[top]= push_n++; // stack[0]=0;
		
		for(int i=0; i<N; i++) {
			if(stop==false) {
				int n =sc.nextInt();
				calc(n);
			}
			else break;
		}
		
		if (stop==false) {
			for(int i=0; i<output_index; i++) {
				System.out.println(output[i]);
			}
		}
		else System.out.println("NO");
		
		sc.close();
	}

}
