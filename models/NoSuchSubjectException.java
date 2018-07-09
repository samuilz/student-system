package models;

class NoSuchSubjectException extends Exception {
    NoSuchSubjectException() {
        super("The subject does not exist.");
    }
}
