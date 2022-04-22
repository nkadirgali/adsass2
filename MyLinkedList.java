public class MyLinkedList<T extends Comparable<T>> implements MyList<Object> {
    private static class MyNode<Object>{
        Object data;
        MyNode<Object> next, prev;

        MyNode(Object data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<Object> head, tail;

    public MyLinkedList() {}

    public void add(Object item) {
        MyNode<Object> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Object get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<Object> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int i=0;
        MyNode<Object> node = head;
        while (node!=null){
            if(node.data.equals(o)) return i;
            i++;node=node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i=0,x = -1;
        MyNode<Object> node = head;
        while (node!=null){
            if(node.data.equals(o)) x=i;
            i++;node=node.next;
        }
        return x;
    }

    @Override
    public void sort() {
        MyNode<Object> nodei=head,nodej;
        Comparable<T> a,b;
        while (nodei!=null){
            nodej=nodei.next;
            a=(Comparable<T>) nodei.data;
            while (nodej!=null){
                b=(Comparable<T>) nodej.data;
                if(a.compareTo((T)b)>0) {
                    Object temp = nodei.data;
                    nodei.data = nodej.data;
                    nodej.data = temp;
                    a = (Comparable<T>) nodei.data;
                }
                nodej=nodej.next;
            }
            nodei=nodei.next;
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        int i=0;
        MyNode<Object> node = head;
        while (node!=null){
            if(node.data.equals(o)) return true;
            i++;node=node.next;
        }
        return false;
    }

    @Override
    public void add(Object item, int index) {
        if(index<0 || index>length){
            throw new IndexOutOfBoundsException(index);
        }
        if(index==length){
            add(item);
            return;
        }
        int i=0;
        MyNode<Object> node=head,x = new MyNode<>(item),prev;
        while (node!=null){
            if(i==index){
                prev=node.prev;
                x.prev=prev;
                if(prev!=null) prev.next=x;
                node.prev=x;
                x.next=node;
                length++;
                if(i==0) head=x;
                return;
            }
            node=node.next;i++;
        }
    }

    @Override
    public boolean remove(Object item) {
        MyNode<Object> node=head,prev,next;
        while(node!=null){
            if(node.data.equals(item)){
                prev=node.prev;
                next=node.next;
                prev.next=next;
                next.prev=prev;
                length--;
                return true;
            }
            node=node.next;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        if(index<0 || index>length){
            throw new IndexOutOfBoundsException(index);
        }
        int i=0;
        MyNode<Object> node=head,prev,next;
        Object x=node.data;
        if (index==0){
            head=head.next;
            length--;
            return x;
        }
        while (node!=null){
            if(i==index){
                prev=node.prev;
                next=node.next;
                prev.next=next;
                next.prev=prev;
                length--;
                return node.data;
            }
            node=node.next;i++;
        }
        return null;
    }

    @Override
    public void clear() {
        tail=null;
        head=null;
        length=0;
    }

}
