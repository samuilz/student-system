package models;

import java.util.*;

public class Teacher extends Person implements Evaluation {
    private static final int ABSENCE = 1;
    private HashSet<StudentClass> listOfClasses;
    private ArrayList<Subject> listOfSubjects;

    Teacher(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
        listOfClasses = new HashSet<>();
        listOfSubjects = new ArrayList<>();
    }

    HashSet<StudentClass> getListOfClasses() {
        return listOfClasses;
    }

    ArrayList<Subject> getListOfSubjects() {
        return listOfSubjects;
    }

    void printGrades(StudentClass studentClass, Subject subject) {
        if (this.listOfClasses.contains(studentClass) && this.listOfSubjects.contains(subject)) {
            System.out.println("Subject: " + subject);
            System.out.println("Showing grades for " + studentClass.getName() + ":");
            for (Student student : studentClass.getStudents()) {
                System.out.print(student.toString() + " ");
                System.out.println(student.getSubjectGrade().get(subject).toString());

            }
        } else {
            System.out.println("Information for " + studentClass + " and " + subject + " is not available.");
        }
    }


    void sendInvitation(StudentClass studentClass) {
        for (Student student : studentClass.getStudents()) {
            Parent currentParent = student.getParent();
            String message = String.format(
                    "Hello, Mr/Ms %s. I want to invite you at our school for parent meeting on Friday.",
                    currentParent.getLastName());

            if (!currentParent.getUnreadNotification().contains(message)) {
                currentParent.getUnreadNotification().push(message);
            }
        }
    }

    @Override
    public void showInfo() {
        System.out.printf("Full name: %s %s\n", super.getFirstName(), super.getLastName());
        System.out.printf("Phone number: %s\n", super.getPhoneNumber());
        System.out.printf("Email: %s\n", super.getEmail());
        System.out.println("List of all classes: ");

        listOfClasses.forEach(System.out::println);

        System.out.println("\nList of all subjects: ");

        listOfSubjects.forEach(System.out::println);
    }

    public void remarkStudent(Student student, String remark) {
        student.getRemarks().add(remark);
    }

    void addExcusedAbsences(Student student) {
        int currentAbsences = student.getExcusedAbsences();
        student.setExcusedAbsences(currentAbsences + ABSENCE);
    }

    void addUnexcusedAbsences(Student student) {
        int currentAbsences = student.getUnexcusedAbsences();
        student.setUnexcusedAbsences(currentAbsences + ABSENCE);
    }

    public List<Person> arrangeGraduation(StudentClass studentClass) {
        List<Person> attendants = new ArrayList<>(studentClass.getStudents());
        studentClass.getStudents().forEach(s -> attendants.add(s.getParent()));

        return attendants;
    }


    @Override
    public void examineClass(StudentClass studentClass, Subject subject) throws NoSuchStudentClassException {
        if (this.listOfClasses.contains(studentClass)) {
            if (this.listOfSubjects.contains(subject) && studentClass.inSubjects(subject, this)) {
                studentClass.getStudents().forEach(s -> s.getSubjectGrade().get(subject).add(Grade.randomLetter()));
            }
        } else {
            throw new NoSuchStudentClassException();
        }
    }


    @Override
    public void examineStudent(Student student, Subject subject, Grade grade) throws NoSuchStudentException, NoSuchSubjectException {
        if (this.getListOfClasses().contains(student.getStudentClass())) {
            if (this.getListOfSubjects().contains(subject) && student.getStudentClass().inSubjects(subject, this)) {
                student.getSubjectGrade().get(subject).add(grade);
            } else {
                throw new NoSuchSubjectException();
            }
        } else {
            throw new NoSuchStudentException();
        }
    }

    @Override
    public String toString() {
        return super.getFirstName().charAt(0) + ". " + super.getLastName();
    }
}



