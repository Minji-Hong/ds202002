import java.util.Scanner;

class Queue<E>{ // �迭�� �̿��� ť Ŭ����
	int front, rear, size;
	E[] data;
	
	Queue(){
		front=0;
		rear=0;
		size=1000;
		data=(E[])new Object[size];
	}
	// ť�� �����͸� �߰��ϴ� �Լ�
	public void add(E v) {
		data[rear]=v;
		rear=(rear+1)%size;
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
	public E back() {
		return data[(rear-1+size)%size];
	}
}
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> que = new Queue();
		Scanner scan = new Scanner(System.in);
		// System.out.print("N(1~10000) �Է�> ");
		int N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			String str = scan.next();
			if(str.equals("push")) {
				int x = scan.nextInt();
				que.add(x);
			}
			else if(str.equals("pop")) {
				if(que.empty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(que.peek());
					que.remove();
				}
			}
			else if(str.equals("size")) {
				System.out.println(que.size());
			}
			else if(str.equals("empty")) {
				if(que.empty()) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
			}
			else if(str.equals("front")) {
				if(que.empty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(que.peek());
				}
			}
			else if(str.equals("back")) {
				if(que.empty()) {
					System.out.println("-1");
				}
				else {
					System.out.println(que.back());
				}
			}
		}
		scan.close();
	}
}
