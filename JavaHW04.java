package ch04클래스;
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
		if(isGood()){//슈퍼 클래스(상속관계에 있죠) 메서드와 멤버변수는 객체 생성안하고 바로 사용가능하죠.->이거 ㅇㅖ제는 제 책 맨앞에 모아뒀는데 나중에 한번에 같이 올릴께요.
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
		System.out.println("나는 착한교수입니다.");
	}
}
class Homework{
	public Homework(Professor prof){
		this.prof = prof;
	}
	public String setProf(){
		if(prof.isGood()){
			return "착한";
		}else{
			return "나쁜";
		}
	}
	
	public void homeworkclassprint(){
		System.out.println("이 숙제는"+ setProf() + "교수가 낸 숙제입니다.");
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
		//homework라는 객체명을 가진 ReportHomework class 객체가 생성되었습니다.이제 확인해보기위해 레포트홈워크 클래스가 상속받은 homework.homeworkclassprint()메서드를 사용해서 
		homework.homeworkclassprint();
	}

}
