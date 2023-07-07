
public class MyLinkedList {
	
	public class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = null;
		}
		
	}
	private Node head = null;
	private int size = 0;
	
	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	
	
	public String toString() {
		String ret = "";
		if (head == null) return ret;
		
		Node tmp = head;
		while(tmp != null) {
			ret += ", " + tmp.data;
			tmp = tmp.next;
		}
		return ret.substring(2);
	}
	
}
