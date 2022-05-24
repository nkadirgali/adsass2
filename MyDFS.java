public class MyDFS<V> extends MySearch<V> {
    public MyDFS(MyWeightedGraph<V> graph,V source){
        super(source);
        dfs(graph,source);
    }
    private void dfs(MyWeightedGraph<V> graph,V current){
        marked.add(current);
        count++;
        for(V v: graph.adjacencyList(current)){
            if(!marked.contains(v)){
                edgeTo.put(v,current);
                dfs(graph,v);
            }
        }
    }
}
