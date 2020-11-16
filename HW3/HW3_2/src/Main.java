import java.util.Scanner;

class Queue<E>{ // 배열을 이용한 큐 클래스
	int front, rear, size;
	E[] data;
	
	Queue(){
		front=0;
		rear=0;
		size=1000;
		data=(E[])new Object[size];
	}
	// 큐에 데이터를 추가하는 함수
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
		return front==rear; // 값이 같으면 비어있는 것
	}
	public int size() { // 데이터 개수
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
		// System.out.print("N(1~10000) 입력> ");
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
