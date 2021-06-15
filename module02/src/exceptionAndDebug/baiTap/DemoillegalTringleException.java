package exceptionAndDebug.baiTap;

public class DemoillegalTringleException {
    public static void main(String[] args) throws IllegalTringleException {
        Tringle tringle = new Tringle(-1, 5, 7);
        if (tringle.getA() < 0 || tringle.getB() < 0 || tringle.getC() < 0 || tringle.getA() + tringle.getB() < tringle.getC() || tringle.getC() + tringle.getA() < tringle.getB() || tringle.getB() + tringle.getC() < tringle.getA()) {
            throw new IllegalTringleException();
        }
    }
}

