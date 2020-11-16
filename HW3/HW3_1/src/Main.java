import java.util.Random;
import java.util.Scanner;

class Stack<E>{ // ���� ����
	E[] data; // �迭 ���� ����
	int top;  
	
	Stack(){
		data= (E[])new Object[1024];
		top= -1;
	}
	
	public void push(E v) {
		data[++top]=v;
	}
	public void pop() {
		data[top--]=null; // ������ ����
	}
	public E top() {
		return data[top];
	}
	public boolean empty(){
		return top == -1; // ==�� ���� ������?
	}
	public int size() {
		return top+1;
	}
}

class Queue<E>{ // �迭�� �̿��� ť Ŭ����
	int front, rear, size;
	E[] data;
	
	Queue(){
		front=0;
		rear=0;
		size=1000;
		data=(E[])new Object[size]; // �迭 1000�� �Ҵ�
	}
	// ť�� �����͸� �߰��ϴ� �Լ�
	public void add(E v) {
		data[rear]=v;
		rear=(rear+1)%size; //size�� 1000�̵Ǹ�, 0!
	}
	public void remove() {
		data[front]=null;
		front=(front+1)%size;
	}
	public E peek() {
		return data[front];
	}
	public boolean empty() {
		return front==rear; // ���� ������ ����ִ� ��
	}
	public int size() { // ������ ����
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
		System.out.print("n �Է�> ");
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