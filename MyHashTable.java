public class MyHashTable<K extends Comparable<K>, V extends Comparable<V>> {
    private static class MyNode<K,V>{
        K key;
        V value;
        MyNode<K, V> next;
        MyNode(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity = 10;
    private int length = 0;
    private float loadFactor=0.5f;
    private MyNode<K, V>[] buckets;

    public MyHashTable(){
        buckets = new MyNode[capacity];
    }
    public MyHashTable(int initialCapacity){
        capacity = (int)(initialCapacity*loadFactor);
        buckets = new MyNode[capacity];
    }
    public MyHashTable(int initialCapacity,float loadFactor){
        this.loadFactor=loadFactor;
        capacity= (int) (initialCapacity*loadFactor);
        buckets=new MyNode[capacity];
    }
    public void put(K key, V value){
        int index=hash(key.hashCode());
        MyNode<K,V> newNode = new MyNode<>(key,value);
//        System.out.println("Index = "+index+" Value = "+value+" Key hashCode = " + key.hashCode());
        if(buckets[index]!=null){
            newNode.next=buckets[index];
        }
        buckets[index]=newNode;
        length++;
    }
    public V get(K key){
        int index=hash(key.hashCode());
        MyNode<K,V> node = buckets[index];
        while (node!=null){
            if(node.key.compareTo(key)==0) return node.value;
            node=node.next;
        }
        return null;
/*        MyNode<K, V> node;
        for(int i=0;i<capacity;i++){
            node=buckets[i];
            while(node!=null){
                if(node.key==key) return node.value;
                node=node.next;
            }
        }
        return null;*/
    }
    public V remove(K key){
        int index=hash(key.hashCode());
        MyNode<K,V> node = buckets[index],prev = null;
        while (node!=null){
            if(node.key.compareTo(key)==0){
                if(buckets[index]==node){
                    buckets[index]=node.next;
                }else{
                    prev.next=node.next;
                }
                length--;
                return node.value;
            }
            prev=node;
            node=node.next;
        }
        return null;
/*        MyNode<K, V> node,prev = null;
        V returnValue;
        for(int i=0;i<capacity;i++){
            node=buckets[i];
            while(node!=null){
                if(node.key==key){
                    returnValue=node.value;
                    if(buckets[i]==node){
                        buckets[i]=node.next;
                    }else {
                        prev.next=node.next;
                    }
                    length--;
                    return returnValue;
                }
                prev=node;
                node=node.next;
            }
        }
        return null;*/
    }
    public boolean contains(V value){
        MyNode<K, V> node;
        for(int i=0;i<capacity;i++){
            node=buckets[i];
            while(node!=null){
                if(node.value==value) return true;
                node=node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        MyNode<K, V> node;
        for(int i=0;i<capacity;i++){
            node=buckets[i];
            while(node!=null){
                if(node.value==value) return node.key;
                node=node.next;
            }
        }
        return null;
    }
    public void print(){
        MyNode<K,V> it;
        for(int i=0;i<capacity;i++){
            System.out.print(i+" - ");
            for(it=buckets[i];it!=null;it=it.next){
                System.out.print(it.key);
                if(it.next!=null) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    private int hash(int hashCode){
        return (hashCode & 0x7fffffff)%capacity;
    }
}
