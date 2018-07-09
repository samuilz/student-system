package models;

public class Main {

	public static void main(String[] args) throws NoSuchStudentException, NoSuchSubjectException,
			NoSuchStudentClassException, NoSoMuchUnexcusedAbsences {
		Parent parent = new Parent("Ivan", "Ivanow", "0877314151", "joro@gmail.com");
		Parent parent2 = new Parent("Gosho", "Goshev", "0877314151", "goshaka@gmail.com");

		Student student = new Student("Georgi", "Dimitrow", parent, "0866435675", "gogo@gmail.com");
		Student student2 = new Student("Ivan", "Petrov", parent, "0866435675", "ivan@gmail.com");
		Student student3 = new Student("Rayko", "Raykov", parent2, "0866435675", "rayko@gmail.com");
		Student student4 = new Student("Miro", "Peev", parent2, "0866435675", "miro@gmail.com");

		Teacher teacher = new Teacher("Geno", "Uvardow", "0886112233", "hoho@gmail.com");
		Teacher teacher2 = new Teacher("Teodor", "Petrov", "0886112233", "tpetrov@gmail.com");
		Teacher teacher3 = new Teacher("Pesho", "Peshev", "0886112233", "ppeshev@gmail.com");

		StudentClass studentClass = new StudentClass("9A");
		StudentClass studentClass2 = new StudentClass("4B");

		studentClass.addStudent(student);
		studentClass.addStudent(student2);
		studentClass2.addStudent(student3);
		studentClass2.addStudent(student4);

		studentClass.addSubject(Subject.ART, teacher);
		studentClass.addSubject(Subject.MATH, teacher2);
		studentClass.addSubject(Subject.CHEMISTRY, teacher2);

		studentClass2.addSubject(Subject.MATH, teacher2);
		studentClass2.addSubject(Subject.LITERATURE, teacher3);

		teacher.examineStudent(student, Subject.ART, Grade.FAIR);
		teacher2.examineStudent(student, Subject.MATH, Grade.EXCELLENT);
		teacher2.examineStudent(student, Subject.MATH, Grade.EXCELLENT);
		teacher2.examineStudent(student2, Subject.MATH, Grade.EXCELLENT);
		teacher2.examineStudent(student2, Subject.MATH, Grade.VERY_GOOD);

		teacher3.examineStudent(student3, Subject.LITERATURE, Grade.VERY_GOOD);
		teacher3.examineStudent(student3, Subject.LITERATURE, Grade.POOR);
		teacher3.examineStudent(student3, Subject.LITERATURE, Grade.FAIR);

		teacher2.addUnexcusedAbsences(student3);
		teacher2.addUnexcusedAbsences(student4);
		teacher2.addUnexcusedAbsences(student4);
		teacher2.addExcusedAbsences(student4);
		teacher.addUnexcusedAbsences(student);

		student.showGrades();
		System.out.println();
		student4.showAbsences();
		System.out.println();

		parent.excuseAbsences(student, 1);
		System.out.println();

		student.showInfo();
		System.out.println();

		teacher.sendInvitation(studentClass);

		parent.showUnreadNotifications();

		System.out.println();
		teacher3.printGrades(studentClass2, Subject.LITERATURE);
	}
}
