package lesson10DsaDanhSach.baiTap.arrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPCACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPCACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capaity " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity:" + minCapacity);
        }
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index : " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index : " + index);
        }
        if (index == size) {
            elements[index] = null;
        }
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) elements;
    }

    public boolean contains(E o) {
        return this.indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        int viTri = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                viTri = i;
            }
        }
        return viTri;
    }

    public E clone() {
        MyList<E> newlist = new MyList<>();
        newlist.elements = Arrays.copyOf(elements, size);
        newlist.size = this.size;
        return (E) newlist;
    }

    public E get(int i) {
        if (i > elements.length) {
            throw new IllegalArgumentException("index : " + i);
        }
        return (E) elements[i];
    }

}
