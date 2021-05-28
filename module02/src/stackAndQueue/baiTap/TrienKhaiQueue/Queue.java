package stackAndQueue.baiTap.TrienKhaiQueue;

public class Queue {
    private Node front;
    private Node rear;
    public Queue(){
        front=null;
        rear=null;
    }
    public void enQueue(int key){
        Node temp=new Node(key);
        if(this.front==null){
            front=temp;
        }else {rear.link=temp;
        }
        rear=temp;
        rear.link=front;
    }
    public int dequeue() {
        if (front == null) {
            throw new NullPointerException("No element left");
        }
        Node temp = front;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.link;
            rear.link = front;
        }
        return temp.data;
    } public void displayQueue(){
        if (front == null){
            System.out.println("Queue is empty");
        }else{
            Node temp = front;
            while (temp.link !=front){
                System.out.print(temp.data + " ");
                temp = temp.link;
            }
            System.out.println(temp.data);
        }
    }
}
