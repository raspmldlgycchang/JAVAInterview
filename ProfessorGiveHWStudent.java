package ch04클래스;
//착한 교수 클래스 생성자에서 레포트홈워크받고 교수 클래스에서 모든 메소드를 생성자에서 선언한
//this.homework = homework 의 this.homework를 변수나 매개변수로 받으면 착한 교수 클래스에서는
//레포트홈워크 클래스 객체가 상속받은 메소드에 오버라이딩된다.
class Person{
	String name;
	boolean isGood;
	public Person(String name, boolean isGood){
		this.name = name;
		this.isGood = isGood;
	}
}
class Professor extends Person{
	Homework homework;
	Student [] stud;
	Professor prof = new Professor(name, isGood);
	public Professor(String name, boolean isGood){
		super(name, isGood);
	}
	public void assign(Homework homework){
		this.homework = homework;
	}
	public void assignTo(Student [] stud){
		this.stud = stud;
	}
}
class GoodProfessor extends Professor{
	public GoodProfessor(String name, boolean isGood){
		super(name, isGood);
	}
	public void assign(Homework homework){
		super((ReportHomework)homework);
	}
}	
class Student extends Person{
	public Student(String name, boolean isGood){
		super(name, isGood);
	}
}
//Homework클래스에서 getGrade()메서드가 있게하고 학생클래스에서 int로 반환되는 이 메서드를 호출해서 
//특정조건을 만족하는 점수이면"환호"를 출력 아니면 "좌절"을 출력하도록 해요.
class Homework{	
	//메소드의 배열 리턴_ch03.sec05
	public int[] getGrade(int [] grade){
		return grade;
}
//프로젝트형 숙제도 레포트형 숙제처럼 제목이 필요하고 보고서에 제목을 적으라는 조건이 있으므로 프로젝트형 숙제가 보고서형 숙제를 상속하도록 한다.
//레포트형 숙제 매개변수받는 생성자에서 제목을 받도록 하고 프로젝트형에서는 생성자에서 super(String homeworkname)으로 하면 되는거 이해되시죠?
class ReportHomework extends Homework{
	String homeworkname;
	Student [] stud;
	int [] grade;
	Professor prof;
	public ReportHomework(String homeworkname){
		this.homeworkname = homeworkname;
	}
	//보고서형 숙제는 착한 교수가 내고 프로젝트형 숙제는 나쁜 교수가 내므로 레포트형 숙제의 setGrade() 메소드에서 isGood 변수가 true냐 false냐를 받아야해요.
	public void setGrade(){
		grade = new int[stud.length];
		for(int i=0;i<stud.length;i++){
			if(prof.isGood){
				grade[i] = (int)(Math.random()*5 + 5);
			}
			else{
				grade[i] = (int)(Math.random()*10);
			}
		}
	}
}
class ProjectHomework extends ReportHomework{
	public ProjectHomework(String homeworkname){
		super(homeworkname);
	}
	//메서드 오버라이딩하는 이유는 프로젝트형 숙제는 시연(demo)을 해야 해요. 프로젝트형 숙제는 나쁜 교수가 내고 나쁜 교수는 점수를 보고서 점수에서 깎는다는 조건을 교수님께서 추가하셔서 저도 추가했어요.
	public void setGrade(){
		for(int i=0;i<stud.length;i++){
			if(prof.isGood){
				grade[i] += (int)(Math.random()*5 + 5);
			}
			else{
				grade[i] -= (int)(Math.random()*10);
			}
		}
	}
}
