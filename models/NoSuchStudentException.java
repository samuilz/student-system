package models;

class NoSuchStudentException extends Exception {
    NoSuchStudentException() {
        super("The student does not exist.");
    }
    //public NoSuchStudentException () {
        //super("The student does not exist.");
    //}
}
