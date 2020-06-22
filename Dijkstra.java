import java.util.ArrayList;

public class Dijkstra
{

	
	// Init Parameter inf 
	
	static int inf = 1000000;
	
	// Dijkstra Helper functions
	
	/**
	 * A method to find neighbor of a vertex with the minimum distance
	 * 
	 * @param dist : a Array of vertices
	 * @param visited : a corresponding boolean array of to dist , which marks visited vertecies.
	 * @return The vertex index with the smallest dist , that we haven't visited
	 */
	private static int extractMin(int [] dist , boolean[] visited)
	{
		int minIndex = Integer.MAX_VALUE;
		int minValue = Integer.MAX_VALUE;
		int V = visited.length;
		
		for( int i = 0 ; i < V ; i++)
		{
			if ( ( visited[i] == false ) && (dist[i] < minValue) )
			{
				minIndex = i ; 
				minValue = dist[i];
				
			}
		}
		return minIndex;
		
	}
	
	public static void Dijkstra(ArrayList<ArrayList<Integer>> graph , int s ,int t ,int[][] weightMatrix )
	{

		/////////\\\\\\\Initialization ///////\\\\\\\\\
	
		int V = graph.size(); // Size of Graph
		
		// Creating three helping arrays of vertecies, dist and prev and visited
		int dist[] = new int[V];
		int prev[] = new int[V];
		boolean[] visited = new boolean[V];
		
		// Init the arrays such as distance between any two vertecies is infinity , no previous vertex and no one is visited
		
		for( int i = 0 ; i < V ; i++)
		{
			dist[i] = inf;
			prev[i] = -1;
			visited[i] = false;
		}
		
		dist[s] = 0; // Starting node distance is set to 0;
		int v; // Represents an index of a vertex we gonna work on
		while( (v = extractMin(dist,visited) ) != -1)
			{
				for(int u : graph.get(v))
				{
					if( (visited[u] == false) && (dist[u] > dist[v] + weightMatrix[v][u]) ) // If u wasn't visited ,  and we found a better path to u from v
					{
						// Update vertex "u" as we found a shorter way to it.
						dist[u] = dist[v] + weightMatrix[u][v];
						prev[u] = v;
					}
					visited[v] = true; // We finished with the current vertex "v".
					if( v == t) // If "v" was out target vertex ,  break the loop
						break;
				}
	
			}
		System.out.println("dist = " + dist[t]);
		int k = t ;
		String path = "";
		while(prev[k] != -1)
		{
			path = "->" + path;
			k = prev[k];
		}
		path = k + path;
		System.out.println("===============");
		for( int i = 0 ; i < V ; i++)
		{
			if( i == s)
				continue;
			PrintPath(prev,i);
			System.out.println();
		}
	}
	
	private static void PrintPath(int[] prev , int i)
	{
		if(prev[i] == -1)
			System.out.println(i);
		else
		{
			PrintPath(prev , prev[i]);
			System.out.println("-"+i);
		}
	}
	
	
	public static ArrayList<ArrayList<Integer>> InitializeGraph()
	{
		ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		int numOfVertices = 8;

		for (int i = 0; i < numOfVertices; i++) {
			G.add(new ArrayList<Integer>());
		}

		G.get(0).add(1);
		G.get(0).add(2);

		G.get(1).add(0);
		G.get(1).add(2);
		G.get(1).add(4);

		G.get(2).add(0);
		G.get(2).add(1);
		G.get(2).add(3);
		G.get(2).add(5);

		G.get(3).add(2);
		G.get(3).add(4);
		G.get(3).add(5);

		G.get(4).add(1);
		G.get(4).add(3);
		G.get(4).add(7);

		G.get(5).add(2);
		G.get(5).add(3);
		G.get(5).add(6);

		G.get(6).add(4);
		G.get(6).add(5);
		G.get(6).add(7);

		G.get(7).add(4);
		G.get(7).add(6);

		return G;
	}
	
	public static void main(String[] args)
	{
		int[][] mat = {{0 ,1 ,2 ,inf ,inf ,inf ,inf ,inf },
				{1 ,0 ,4 ,inf ,5 ,inf ,inf ,inf },
				{2 ,4 ,0 ,7 ,inf ,3 ,inf ,inf },
				{inf ,inf ,7 ,0 ,3 ,8 ,inf ,inf },
				{inf ,5 ,inf ,3 ,0 ,inf ,1 ,4 },
				{inf ,inf ,3 ,8 ,inf ,0 ,2 ,inf },
				{inf ,inf ,inf ,inf ,1 ,2 ,0 ,5 },
				{inf ,inf ,inf ,inf ,4 ,inf ,5 ,0 }};
		ArrayList<ArrayList<Integer>> G = InitializeGraph();
		Dijkstra(G, 0, 7, mat);
		

	}

}
