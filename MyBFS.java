import java.util.LinkedList;
import java.util.Queue;

public class MyBFS <V> extends MySearch<V>{
    public MyBFS(MyWeightedGraph<V> graph, V source){
        super(source);
        bfs(graph,source);
    }
    private void bfs(MyWeightedGraph<V> graph, V current){
        marked.add(current);
        Queue<V> queue=new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()){
            V v = queue.remove();
            for(V vertex : graph.adjacencyList(v)){
                if(!marked.contains(vertex)){
                    marked.add(vertex);
                    edgeTo.put(vertex,v);
                    queue.add(vertex);
                }
            }
        }
    }
}
