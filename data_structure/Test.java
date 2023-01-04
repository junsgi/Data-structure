package data_structure;

public class Test {

	public static void main(String[] args) {
		Array test = new Array();
		for(int i = 0; i < 10 ; i++) {
			test.add(i+1);
		}
		
		
		test.add(1, 2);
		
		for(int i = 1; i < test.getSize() ; i++) {
			test.set(i, i+1);
		}
		
		test.add(1, 0.5);
		test.add(3, 2.5);
		test.show();
		System.out.println(test.arr[11]);
		System.out.println(test.getSize());
	}

}
