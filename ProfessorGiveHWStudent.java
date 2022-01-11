package ch04Ŭ����;
//���� ���� Ŭ���� �����ڿ��� ����ƮȨ��ũ�ް� ���� Ŭ�������� ��� �޼ҵ带 �����ڿ��� ������
//this.homework = homework �� this.homework�� ������ �Ű������� ������ ���� ���� Ŭ����������
//����ƮȨ��ũ Ŭ���� ��ü�� ��ӹ��� �޼ҵ忡 �������̵��ȴ�.
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
//HomeworkŬ�������� getGrade()�޼��尡 �ְ��ϰ� �л�Ŭ�������� int�� ��ȯ�Ǵ� �� �޼��带 ȣ���ؼ� 
//Ư�������� �����ϴ� �����̸�"ȯȣ"�� ��� �ƴϸ� "����"�� ����ϵ��� �ؿ�.
class Homework{	
	//�޼ҵ��� �迭 ����_ch03.sec05
	public int[] getGrade(int [] grade){
		return grade;
}
//������Ʈ�� ������ ����Ʈ�� ����ó�� ������ �ʿ��ϰ� ������ ������ ������� ������ �����Ƿ� ������Ʈ�� ������ ������ ������ ����ϵ��� �Ѵ�.
//����Ʈ�� ���� �Ű������޴� �����ڿ��� ������ �޵��� �ϰ� ������Ʈ�������� �����ڿ��� super(String homeworkname)���� �ϸ� �Ǵ°� ���صǽ���?
class ReportHomework extends Homework{
	String homeworkname;
	Student [] stud;
	int [] grade;
	Professor prof;
	public ReportHomework(String homeworkname){
		this.homeworkname = homeworkname;
	}
	//������ ������ ���� ������ ���� ������Ʈ�� ������ ���� ������ ���Ƿ� ����Ʈ�� ������ setGrade() �޼ҵ忡�� isGood ������ true�� false�ĸ� �޾ƾ��ؿ�.
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
	//�޼��� �������̵��ϴ� ������ ������Ʈ�� ������ �ÿ�(demo)�� �ؾ� �ؿ�. ������Ʈ�� ������ ���� ������ ���� ���� ������ ������ ���� �������� ��´ٴ� ������ �����Բ��� �߰��ϼż� ���� �߰��߾��.
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
