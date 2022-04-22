public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list;
    public MyStack(){
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

    public T push(T item){
        list.add(item,0);
        return item;
    }

    public T pop(){
        T removingItem = (T) list.get(0);
        list.remove(0);
        return removingItem;
    }
}
