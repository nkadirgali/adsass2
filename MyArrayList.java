public class MyArrayList<T extends Comparable<T>> implements MyList<Object> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public void add(Object item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(Object item, int index) {
        if(index<0 || index>length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        add(item);
        for(int i=length-1;i>index;i--){
            Object temp=arr[i];
            arr[i]=arr[i-1];
            arr[i-1]=temp;
        }
    }

    @Override
    public boolean remove(Object item) {
        int idx=indexOf(item);
        if(idx==-1) return false;
        remove(idx);
        return true;
    }

    @Override
    public Object remove(int index) {
        if(index<0 || index>=length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Object x=null;
        for(int j=index;j<length-1;j++){
            Object temp=arr[j+1];
            arr[j+1]=arr[j];
            arr[j]=temp;
        }
        x=arr[length-1];
        arr[length-1]=null;
        length--;
        return x;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            arr[i]=null;
        }
        length=0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        if(index<0 || index>=length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length-1; i >= 0; i--) {
            if(arr[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        Comparable<T> a,b;
        for (int i = 0; i < length; i++) {
            a= (Comparable<T>) arr[i];
            for (int j = i+1; j < length; j++) {
                b= (Comparable<T>) arr[j];
                if(a.compareTo((T) b)>0){
                    Object temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                    a=b;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++) {
            if(arr[i].equals(o)) return true;
        }
        return false;
    }
    private void set(int index,T data){
        arr[index]=data;
    }
    public void swap(int index1,int index2){
        T data = (T) arr[index1];
        set(index1, (T) arr[index2]);
        set(index2,data);
    }
}
