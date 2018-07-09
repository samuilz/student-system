package models;

public interface Evaluation {
	public void examineClass(StudentClass studentClass, Subject subject) throws NoSuchStudentClassException;

	public void examineStudent(Student student, Subject subject, Grade grade) throws NoSuchStudentException, NoSuchSubjectException;
}
