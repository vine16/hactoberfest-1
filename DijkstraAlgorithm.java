package algorithms;

import java.util.Scanner;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int V = scn.nextInt();
		int E = scn.nextInt();

        int[][] matrix = new int[V][V];
        
        for(int i = 0; i < E; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int w = scn.nextInt();
            
            matrix[v1][v2] = w;
            matrix[v2][v1] = w;
        }
        
        dijkstra(matrix);
        scn.close();
	}

	public static void dijkstra(int[][] matrix)
    {
        int v = matrix.length;
        boolean visited[] = new boolean[v];
        int dist[] = new int[v];
        
        dist[0] = 0;
        for(int i = 1; i < dist.length; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        
        
        				//v - 1 is also true
        for(int i = 0; i < v; i++)
        {
            //unvisited adjacent vertex with minimum distance
            int minVertex = minDis(dist, visited);
            visited[minVertex] = true;
            
            for(int j = 0; j < v; j++)
            {
                if(matrix[minVertex][j] != 0 && !visited[j])
                {
                	int newDist = dist[minVertex] + matrix[minVertex][j];
                	if(newDist < dist[j])
                	{
                		dist[j]  = newDist;
                	}
                }
            }
        }
        
        for(int i = 0; i < v; i++)
        {
            System.out.println(i + " " + dist[i]);
        }
        
    }
    
    public static int minDis(int[] dist, boolean[] visited)
    {
        //vse to adjacent mein se dekte hain minDistance wali
        //but agr adjacent mein check kiya to utna hi time lag jaye ga
    	
    	
    	//phle se to pta hi ni hai, unvisited minDis wali
        int minVertex = -1;
        
        for(int i = 0; i < dist.length; i++)
        {
            if(!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex]))
            {
                minVertex = i;
            }
        }
        
        return minVertex;
    }

}
