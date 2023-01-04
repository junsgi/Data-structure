package data_structure;
class Node{
	Object data;
	Node next;
	Node prev;
	
	Node(Object value){
		this.data = value;
		this.next = null;
		this.prev = null;
	}
	
	void clear() {
		this.data = null;
		this.next = null;
		this.prev = null;
	}
}
public class LinkedList {
	Node head;
	Node tail;
}
