package stackAndQueue.thucHanh.genericStack;

public class GenericStackClient {
    public static void stackOfStrings() {
        MyGenericStack<String> stringStack = new MyGenericStack<>();
        //stringStack.pop();
        stringStack.push("uyen đẹp gái");
        stringStack.push("uyên pro IT");

        System.out.println("stack after push element " + stringStack.size());
        while (!stringStack.isEmpty()) {
            stringStack.pop();
        }
        System.out.println("stack after beforce element " + stringStack.size());


    }
    public static void stackOfIntegers() {
        MyGenericStack<Integer> integerStack = new MyGenericStack<>();
        //stringStack.pop();
        integerStack.push(1);
        integerStack.push(10);
        integerStack.push(4);
        System.out.println("stack after push element " + integerStack.size());
        while (!integerStack.isEmpty()) {
            integerStack.pop();
        }
        System.out.println("stack after beforce element " + integerStack.size());
    }
    public static void main(String[] args) {
        stackOfStrings();
        stackOfIntegers();
    }

}
