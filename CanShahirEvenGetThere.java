import java.util.*;

public class CanShahirevengetthere {
    //bfs to find if there is connection or not.
    static int nodes;
    static boolean[][] connections;
    static boolean[] visited;
    public static void main(String[] args) {
        //https://dmoj.ca/problem/vmss7wc16c3p2
        Scanner s = new Scanner(System.in);
        int houses = s.nextInt(), roads = s.nextInt(); nodes = houses;
        int og = s.nextInt(), target = s.nextInt();
        connections = new boolean[houses][houses];
        for(int i=0;i<roads;i++){
            int x = s.nextInt()-1, y = s.nextInt()-1;
            connections[x][y]=connections[y][x]=true; //connection between the two houses
        }
        BFS(og-1);
        if(visited[target-1]) System.out.println("GO SHAHIR!");
        else System.out.println("NO SHAHIR!");
    }
    static void BFS(int start){
        visited = new boolean[nodes];
        Arrays.fill(visited, false);
        List<Integer> q = new ArrayList<>();
        q.add(start);
        visited[start] = true;
        int vis;
        while(!q.isEmpty()){
            vis = q.get(0);
            q.remove(q.get(0));
            for(int i=0;i<nodes;i++){
                if(connections[vis][i] == true && (!visited[i])){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
