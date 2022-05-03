public class MyBST<K extends Comparable<K>, V> {
    private MyNode<K,V> root;
    private class MyNode<K,V>{
        private K key;
        private V value;
        private MyNode left,right;
        public MyNode(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    public void put(K key,V value){
        root=insert(new MyNode<>(key, value),root);
    }
    private MyNode<K,V> insert(MyNode<K,V> newNode,MyNode<K,V> node){
        if (node==null) return newNode;
        if(newNode.key.compareTo(node.key)<0){
            node.left=insert(newNode,node.left);
        }else if(newNode.key.compareTo(node.key)>0){
            node.right=insert(newNode,node.right);
        }
        return node;
    }
    public V get(K key){
        if(isEmpty()) return null;
        MyNode<K,V> node=root;
        while (node!=null){
            if(key.compareTo(node.key)==0) break;
            if(key.compareTo(node.key)<0) node=node.left;
            else node=node.right;
        }
        return node.value;
    }
    public void delete(K key){
        root=delete(key,root);
    }
    private MyNode<K,V> delete(K key,MyNode<K,V> node){
        if(node==null) return null;
        if(key.compareTo(node.key)<0){
            node.left=delete(key,node.left);
        }else if(key.compareTo(node.key)>0){
            node.right=delete(key,node.right);
        }else{
            if(node.left==null){
                return node.right;
            }else if(node.right==null){
                return node.left;
            }
            node=getMax(node.left);
            node.left=delete(node.key,node.left);
        }
        return node;
    }
    public MyQueue<K> keys(){
        MyQueue<K> q = new MyQueue<>();
        inorder(root,q);
        return q;
    }
    private void inorder(MyNode<K,V> node,MyQueue<K> q){
        if(node!=null){
            inorder(node.left,q);
            q.enqueue(node.key);
            inorder(node.right,q);
        }
    }
//    public Iterable<K> iterator(){
//
//    }
    public boolean isEmpty(){return root==null;}
    public V getMin(){
        if(isEmpty()){
            return null;
        }
        return getMin(root).value;
    }
    private MyNode<K,V> getMin(MyNode<K,V> root){
        if(root == null){
            return null;
        }
        MyNode<K,V> node=root;
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
    public V getMax(){
        if(isEmpty()){
            return null;
        }
        return getMax(root).value;
    }
    private MyNode<K,V> getMax(MyNode<K,V> root){
        if(root == null){
            return null;
        }
        MyNode<K,V> node=root;
        while (node.right!=null){
            node=node.right;
        }
        return node;
    }
}
