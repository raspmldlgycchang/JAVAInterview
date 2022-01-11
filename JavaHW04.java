package ch04Ŭ����;
class Person{
	String name;
	boolean isGood;
	public boolean isGood(){
		return isGood;
	}
}
class Professor extends Person{
	public Professor(boolean isGood){
		super.isGood = isGood;
	}
	public void assign(Homework homework){
		if(isGood()){//���� Ŭ����(��Ӱ��迡 ����) �޼���� ��������� ��ü �������ϰ� �ٷ� ��밡������.->�̰� �������� �� å �Ǿտ� ��Ƶ״µ� ���߿� �ѹ��� ���� �ø�����.
			homework = new ReportHomework(this);
		}else{
			homework = new ProjectHomework(this);
		}
	}
}
class GoodProfessor extends Professor{
	public GoodProfessor(boolean isGood){
		super(isGood);
	}
	public void print(){
		System.out.println("���� ���ѱ����Դϴ�.");
	}
}
class Homework{
	public Homework(Professor prof){
		this.prof = prof;
	}
	public String setProf(){
		if(prof.isGood()){
			return "����";
		}else{
			return "����";
		}
	}
	
	public void homeworkclassprint(){
		System.out.println("�� ������"+ setProf() + "������ �� �����Դϴ�.");
	}
}
class ReportHomework extends Homework{
	public ReportHomework(Professor prof){
		super(prof);
	}
}
class ProjectHomework extends Homework{
	public ProjectHomework(Professor prof){
		super(prof);
	}
}
public class JavaHW04 {
	public static void main(String [] args){
		Professor goodProf = new GoodProfessor(true);
		goodProf.assign(Homework homework);
		//homework��� ��ü���� ���� ReportHomework class ��ü�� �����Ǿ����ϴ�.���� Ȯ���غ������� ����ƮȨ��ũ Ŭ������ ��ӹ��� homework.homeworkclassprint()�޼��带 ����ؼ� 
		homework.homeworkclassprint();
	}

}
