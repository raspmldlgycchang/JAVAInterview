package ch04클래스;
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
		//첫번째 경우는 A출력
		//두번째 경우는 AB출력
		//세번째 경우는 ABC출력
		A a = new C();
		a.Eat();//ABC출력
	}
}
