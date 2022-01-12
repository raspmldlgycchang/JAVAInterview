package ch04Ŭ����;
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
	//����Ʈ �����ڰ� ����Ŭ������ ���� ������ ������ ȣ�⹮�� ���� �Ѵ�
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
		if(prof.isGood()) {//this.prof���� this�� ����
			return "����";
		}
		else {
			return "����";
		}
	}
	public void homeworkclassprint() {
		System.out.println("�� ������"+setProf()+"������ �� �����Դϴ�.");
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
			if(prof.isGood) {//Math.random()��ȯ����: 0���� 1���� �Ҽ���(1������)
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
		Professorss goodprof = new GoodProfessorss("�ִϿ�", true);//�ٿ�ĳ����
		goodprof.assign(new ReportHomeworkss("����Ʈ������", goodprof));
		if(goodprof.homework instanceof ReportHomeworkss) { 
			System.out.println("���ѱ����� �� ������ ����ؿ�!");
		}
		
	}
}
