package stackAndQueue.thucHanh.queueLinkedlist;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;
    public MyLinkedListQueue(){
        this.head=null;
        this.tail=null;
    }
    public void enqueue(int key){
        Node temp=new Node(key);
        if(this.tail==null){
            this.head=this.tail=temp;
            return;
        }
        this.tail.link=temp;
        this.tail=temp;
    }
    public Node dequeue(){
        if(this.head==null){
            return null;
        }
        Node temp=this.head;
        this.head=this.head.link;
        if(this.head==null){
            this.tail=null;
        }
        return temp;
    }
}
