package ch04클래스;
class Personss{
	String name;
	boolean isGood;
	public Personss(String name, boolean isGood) {
		this.name = name;
		this.isGood = isGood;
	}
	public boolean isGood() {
		return isGood;
	}
}
class Professorss extends Personss{
	Studentss[] stud;
	Homeworkss homework;
	public Professorss(String name, boolean isGood) {
		super(name, isGood);
	}
	public void assign(Homeworkss homework)
	{
		this.homework = homework;
	}
	public void assignTo(Studentss[] stud) {
		this.stud = stud;
	}
}
class GoodProfessorss extends Professorss{
	//디폴트 생성자가 슈퍼클래스에 없기 때문에 생성자 호출문이 들어가야 한다
	public GoodProfessorss(String name, boolean isGood) {
		super(name, isGood);
	}
	public void assign(Homeworkss homework) {
		super.assign((ReportHomeworkss)homework);
	}
}
class Studentss extends Personss{
	public Studentss(String name, boolean isGood) {
		super(name, isGood);
	}
}
class Homeworkss{
	String homeworkname;
	Professorss prof;
	public Homeworkss(String homeworkname, Professorss prof) {
		this.homeworkname = homeworkname;
		this.prof = prof;
	}
	public String setProf() {
		if(prof.isGood()) {//this.prof에서 this가 생략
			return "착한";
		}
		else {
			return "나쁜";
		}
	}
	public void homeworkclassprint() {
		System.out.println("이 숙제는"+setProf()+"교수가 낸 숙제입니다.");
	}
	public int[] getGrade(int[] grade) {
		return grade;
	}
}
class ReportHomeworkss extends Homeworkss{
	Studentss[] stud;
	int[] grade;
	public ReportHomeworkss(String homeworkname, Professorss prof) {
		super(homeworkname, prof);
	}
	public void setGrade() {
		grade = new int[stud.length];
		for(int i=0;i<stud.length;i++) {
			if(prof.isGood) {//Math.random()반환범위: 0에서 1사이 소수로(1미포함)
				grade[i] = (int)(Math.random()*5+5);
			}else {
				grade[i] = (int)(Math.random()*10);
			}
		}
	}
}
class ProjectHomeworkss extends ReportHomeworkss{
	public ProjectHomeworkss(String homeworkname, Professorss prof) {
		super(homeworkname, prof);
	}
	public void setGrade() {
		grade = new int[stud.length];
		for(int i=0;i<stud.length;i++) {
			if(prof.isGood) {
				grade[i] += (int)(Math.random()*5+5);
			}
			else {
				grade[i] -= (int)(Math.random()*10);
			}
		}
	}
}
public class JAVAHW04_Vers2 {
	public static void main(String[] args)
	{
		Professorss goodprof = new GoodProfessorss("주니온", true);//다운캐스팅
		goodprof.assign(new ReportHomeworkss("레포트형숙제", goodprof));
		if(goodprof.homework instanceof ReportHomeworkss) { 
			System.out.println("착한교수가 낸 숙제라서 출력해요!");
		}
		
	}
}
