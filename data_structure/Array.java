package data_structure;
import java.util.Arrays;
public class Array{
	private final int CAPACITY = 50;
	private int size;
	Object[] arr;
	
	public Array(){
		arr = new Object[CAPACITY];
		this.size = 0;
	}
	
	public Array(int length){
		this.size = 0;
		if(length <= 0) {
			arr = new Object[CAPACITY];
		}else {
			arr = new Object[length];
		}
	}
	
	//삽입
	void add(Object value) {
		if(isFull()) resize();
		arr[size++] = value;
		return;
	}
	
	void add(int idx, Object value) {
		if(idx < 0 || idx > size) throw new IndexOutOfBoundsException();
		else {
			if(idx == size) {
				add(value);
				return;
			}
		
			if(isFull()) resize();
		
			for(int i = size ; i > idx ; i--) {
				arr[i] = arr[i-1];
			}
			arr[idx] = value;
			size++;
			return;
		}
	}
	
	
	
	
	Object deleteIdx(int idx) {
		if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
		
		
		Object del = arr[idx];
		for(int i = idx; i < size - 1 ; i++ ) {
			arr[i] = arr[i + 1];
		}
		arr[size - 1] = null;
		size--;
		resize();
		return del;
		
	}
	
	
	Object delete(Object value) {
		int idx = search(value);
		if(idx > 0) {
			deleteIdx(idx);
			return value;
		}else {
			return false;
		}
		
	}
	
	//배열 크기 조정
	void resize() {
		int capacity = arr.length;
		if(isFull()) {
			arr = Arrays.copyOf(arr, capacity * 2);
			return;
		}
		
		if(size < capacity / 2) {
			arr = Arrays.copyOf(arr, Math.max(capacity / 2, CAPACITY));
			return;
		}
		
	}
	
	
	//원소 찾기 없으면 -1 반환
	int search(Object value) {
		for(int i = 0; i < size ; i++) {
			if(arr[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	Object get(int idx) {
		if(idx < 0 || idx > size) throw new IndexOutOfBoundsException();
		else return arr[idx];
	}
	
	void set(int idx, Object value) {
		if(idx < 0 || idx > size) throw new IndexOutOfBoundsException();
		else arr[idx] = value;
	}
	
	// 비어있으면 true
	boolean isEmpty() {
		return size == 0;
	}
	
	// 꽉 차있으면 true
	boolean isFull() {
		return size == arr.length;
	}
	
	int getSize() {
		return size;
	}
	
	
	void clear() {
		for(int i = 0 ; i < size ; i++) {
			arr[i] = null;
		}
		size = 0;
	}
	
	void show() {
		for(Object i : arr) {
			if(i == null) break;
			System.out.printf("%4s", i);
		}
		System.out.println();
	}
}