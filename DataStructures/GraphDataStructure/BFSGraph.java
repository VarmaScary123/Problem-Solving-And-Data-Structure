import java.util.*;

public class BFSGraph {
    private int V;
    private static List<List<Integer>> adj;

    public BFSGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int V, int W) {
        adj.get(V).add(W);
        adj.get(W).add(V);
    }

    public void BFS(int S) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[S] = true;
        queue.add(S);

        while(!queue.isEmpty()) {
            S = queue.poll();
            System.out.print(S+" ");

            for(int N : adj.get(S)) {
                if(!visited[N]) {
                    visited[N] = true;
                    queue.add(N);
                }
            }
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        BFSGraph bfs = new BFSGraph(V);

        for(int i=0;i<E;i++)
            bfs.addEdge(sc.nextInt(), sc.nextInt());

        sc.close();
        bfs.BFS(0);
    }
}
