package ch04클래스;
import java.util.*;
class MyException extends Exception{
	public MyException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		//return super.getMessage();
		return "dhflsfsdf";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return "dhlel";
	}
	
}
public class ExceptionTest {
	public static void main(String[] args) throws Exception{

		int [] arr = new int[9];
		try {
			System.out.println(arr[arr.length]);
		}catch(ArrayIndexOutOfBoundsException ae) {
			//System.out.println("1. "+ae.getMessage());
			//System.out.println();
			//ae.printStackTrace();//JVM이 출력해주는 방식
			throw new MyException("super클래스 getMessage반환값");
		}
		//다운캐스팅이 일어나서 MyException클래스의 메서드오버라이딩한 함수인
		//getMessage와 toString메서드가 실행되서
		//Exception in thread "main" <toString반환값>
		//		at 프로젝트명.패키지명.파일명.함수명(예외명: 라인번호) : line번호로 출력이 된다
		//<toString반환값>은 프로젝트명.패키지명.파일명.함수명(예외명: 라인번호) <getMessage반환값>
	}
}
