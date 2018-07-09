package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentClass {
	private List<Student> students;

	private Map<Subject, Teacher> subjects;
	private String name;

	StudentClass(String name) {
		setName(name);
		students = new ArrayList<>();
		subjects = new HashMap<>();
	}

	String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	List<Student> getStudents() {
		return students;
	}

	private Map<Subject, Teacher> getSubjects() {
		return subjects;
	}

	void addStudent(Student student) {
		getStudents().add(student);
		student.setStudentClass(this);
	}

	boolean inSubjects(Subject subject, Teacher teacher) {
		final Teacher value = subjects.get(subject);
		return value != null && value.equals(teacher);
	}

	void addSubject(Subject subject, Teacher teacher) {
		getSubjects().put(subject, teacher);

		this.getStudents().forEach(s -> s.getSubjectGrade().put(subject, new ArrayList<>()));
		teacher.getListOfSubjects().add(subject);
		teacher.getListOfClasses().add(this);
	}
}
