package vn.codegym.managerbook.exception;

public class ErrorCodeBook extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Error code book");
    }
}
