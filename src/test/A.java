package test;

public class A {

	public void paint() {
		System.out.println("A");
		draw();
	}
	public void draw() {
		System.out.println("B");
		draw();
	}
	
	public static void main(String[] args) {
		A b = new B();
		b.paint();
		b.draw();
	}

}
