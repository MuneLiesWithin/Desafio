public class Teste {
	public static void main(String[] args) {
		LinkedStack<Integer> ls = new LinkedStack<>();
		LinkedQueue<Integer> lq = new LinkedQueue<>();
		
		//Testando LinkedStack
		ls.push(1);
		ls.push(2);
		ls.push(3);
		System.out.println(ls.toString());
		ls.pop();
		System.out.println(ls.toString());
		
		//Testando LinkedQueue
		lq.enqueue(1);
		lq.enqueue(2);
		lq.enqueue(3);
		System.out.println(lq.toString());
		lq.dequeue();
		System.out.println(lq.toString());
	}
}
