package ch04Ŭ����;
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
			//ae.printStackTrace();//JVM�� ������ִ� ���
			throw new MyException("superŬ���� getMessage��ȯ��");
		}
		//�ٿ�ĳ������ �Ͼ�� MyExceptionŬ������ �޼���������̵��� �Լ���
		//getMessage�� toString�޼��尡 ����Ǽ�
		//Exception in thread "main" <toString��ȯ��>
		//		at ������Ʈ��.��Ű����.���ϸ�.�Լ���(���ܸ�: ���ι�ȣ) : line��ȣ�� ����� �ȴ�
		//<toString��ȯ��>�� ������Ʈ��.��Ű����.���ϸ�.�Լ���(���ܸ�: ���ι�ȣ) <getMessage��ȯ��>
	}
}
