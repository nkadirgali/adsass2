public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;
    public MyQueue(){
        list=new MyLinkedList<>();
    }

    public boolean empty(){
        if(list.size()==0) return true;
        else return false;
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        return (T) list.get(0);
    }

    public T enqueue(T item){
        list.add(item);
        return item;
    }

    public T dequeue(){
        T removingItem = (T) list.get(0);
        list.remove(0);
        return removingItem;
    }
}
