package ch04Ŭ����;
class A{
	void Eat() {
		System.out.println("A");
	}
}
class B extends A{

	@Override
	void Eat() {
		// TODO Auto-generated method stub
		super.Eat();
		System.out.println("B");
	}
	
}
class C extends B{

	@Override
	void Eat() {
		// TODO Auto-generated method stub
		super.Eat();
		System.out.println("C");
	}
	
}
public class DownCastingTest {
	public static void draw(A a) {
		a.Eat();
	}
	public static void main(String[] args) {
		draw(new A());
		draw(new B());
		draw(new C());
		//ù��° ���� A���
		//�ι�° ���� AB���
		//����° ���� ABC���
		A a = new C();
		a.Eat();//ABC���
	}
}
