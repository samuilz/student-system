package models;

class NoSuchStudentClassException extends Exception {
    NoSuchStudentClassException() {
        super("The student class does not exist.");
    }
}
