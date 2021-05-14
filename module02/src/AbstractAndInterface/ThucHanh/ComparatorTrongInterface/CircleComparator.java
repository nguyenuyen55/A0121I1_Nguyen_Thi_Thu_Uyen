package AbstractAndInterface.ThucHanh.ComparatorTrongInterface;

import KeThua.BaiTap.LopCircleVaLopCylinder.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        return (int) (o2.getRadius()-o1.getRadius());
    }
}
