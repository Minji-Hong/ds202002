import java.util.Scanner;

public class Main {
	
	static char[] stack;
	static int top;
	static boolean[] result;
	static int result_index;
	
	public static void isValid(String string) {
		for(int i=0; i<string.length(); i++) {
			if (string.charAt(i)=='(') {
				stack[++top]='(';
			}
			else if(string.charAt(i)==')') {
				if(top==-1||stack[top]!='(') {
					result[result_index]=false;
					break;
				}
				else if(stack[top]=='(') top--;
			}
		}
		if(top!=-1) result[result_index]=false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		result = new boolean[100]; result_index=0;
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트할 괄호 문자열 개수
		
		for(int i=0; i<T; i++) {
			top = -1; stack = new char[100];
			result[result_index]=true;
			String string = sc.next();
			isValid(string);
			result_index++;
		}
		
		for(int k=0; k<T; k++) {
			if(result[k]) System.out.println("YES");
			else System.out.println("NO");
		}
		
		sc.close();
	}

}
