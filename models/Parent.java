package models;

import java.util.*;

public class Parent extends Person {
	private List<Student> children;
	private List<String> readNotifications;
	private Deque<String> unreadNotification;

	Parent(String firstName, String lastName, String phoneNumber, String email) {
		super(firstName, lastName, phoneNumber, email);
		children = new ArrayList<>();
		readNotifications = new ArrayList<>();
		unreadNotification = new ArrayDeque<>();
	}

	Deque<String> getUnreadNotification() {
		return unreadNotification;
	}

	List<Student> getChildren() {
		return children;
	}

	@Override
	public void showInfo() {
		System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
		System.out.printf("Phone number: %s\n", super.getPhoneNumber());
		System.out.printf("Email: %s\n", super.getEmail());

		System.out.println("Student children:");

		for (Student child : children) {
			System.out.printf("-%s %s in student class %s.\n", child.getFirstName(), child.getLastName(),
					child.getStudentClass().getName());
		}
	}

	void showStudentInfo(Student student) {
		student.showAll();
	}

	void excuseAbsences(Student student, int numberAbsences) throws NoSoMuchUnexcusedAbsences {
		if (student.getUnexcusedAbsences() >= numberAbsences) {
			student.setExcusedAbsences(student.getExcusedAbsences() + numberAbsences);
			student.setUnexcusedAbsences(student.getUnexcusedAbsences() - numberAbsences);
			System.out.println("Current Unexcused Absences: " + student.getUnexcusedAbsences());
		} else {
			throw new NoSoMuchUnexcusedAbsences();
		}
	}

	void showUnreadNotifications() {
		while (!unreadNotification.isEmpty()) {
			String currentNotification = unreadNotification.pop();
			System.out.println(currentNotification);
			readNotifications.add(currentNotification);
		}
	}

	public void showReadNotifications() {
		readNotifications.forEach(System.out::println);
	}
}
