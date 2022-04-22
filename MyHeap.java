public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;
    public MyHeap(){
        list=new MyArrayList<>();
    }

    public void printAll(){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public boolean empty(){
        if(list.size()==0) return true;
        else return false;
    }
    public int size(){
        return list.size();
    }
    public T getMax(){return  list.get(0);}
    public T extractMax(){
        T item = list.get(0);
        swap(0,list.size()-1);
        list.remove(list.size()-1);
        heapify(0);
        return item;
    }
    public void insert(T item){
        list.add(item);
        traverseUp(list.size()-1);
    }
    private void heapify(int index){
        int k=index;
        int l=leftChildOf(k);
        while (l<list.size()){
            int max=l, r=l+1;
            if(r< list.size()){
                if(list.get(r).compareTo(list.get(l))>0){
                    max++;
                }
            }
            if(list.get(k).compareTo(list.get(max))<0){
                swap(k,max);
                k=max;
                l=leftChildOf(k);
            }else break;
        }
    }
    private void traverseUp(int index){
        int k=index;
        while (k>0){
            int p=parentOf(k);
            if(list.get(k).compareTo(list.get(p))>0){
                swap(k,p);
                k=p;
            }else break;
        }
    }
    private int leftChildOf(int index){return 2*index+1;}
    private int rightChildOf(int index){
        return 2*index+2;
    }
    private int parentOf(int index){
        return (index-1)/2;
    }
    private void swap(int index1,int index2){
        list.swap(index1,index2);
    }
}
