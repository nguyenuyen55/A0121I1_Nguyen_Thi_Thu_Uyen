package exceptionAndDebug.baiTap;

public class IllegalTringleException extends Exception {
    @Override
    public String getMessage() {
        return "nhap cac acnh khong hop le";
    }
}
