import java.util.Random;
import java.util.Scanner;

class Stack<E>{ // 스택 구현
	E[] data; // 배열 변수 선언
	int top;  
	
	Stack(){
		data= (E[])new Object[1024];
		top= -1;
	}
	
	public void push(E v) {
		data[++top]=v;
	}
	public void pop() {
		data[top--]=null; // 데이터 삭제
	}
	public E top() {
		return data[top];
	}
	public boolean empty(){
		return top == -1; // ==은 값이 같은가?
	}
	public int size() {
		return top+1;
	}
}

class Queue<E>{ // 배열을 이용한 큐 클래스
	int front, rear, size;
	E[] data;
	
	Queue(){
		front=0;
		rear=0;
		size=1000;
		data=(E[])new Object[size]; // 배열 1000개 할당
	}
	// 큐에 데이터를 추가하는 함수
	public void add(E v) {
		data[rear]=v;
		rear=(rear+1)%size; //size가 1000이되면, 0!
	}
	public void remove() {
		data[front]=null;
		front=(front+1)%size;
	}
	public E peek() {
		return data[front];
	}
	public boolean empty() {
		return front==rear; // 값이 같으면 비어있는 것
	}
	public int size() { // 데이터 개수
		return (rear-front+size)%size;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack(); 
		Queue<Integer> que = new Queue();

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("n 입력> ");
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {  // c
			que.add(rand.nextInt(10000));
		}
		
		while(que.empty() != true) {   // h
			int num = que.peek(); // d
			que.remove();
			while(stack.empty()!=true && stack.top()<num) { // f
				if(stack.top()<num) {  
					que.add(stack.top());  // e
					stack.pop();
				}
			}
			stack.push(num);
		}
		
		for(int i=0; i<n; i++) {  // i
			System.out.print(stack.top()+" ");  
			stack.pop();
		}
		
		scan.close();
	}

}