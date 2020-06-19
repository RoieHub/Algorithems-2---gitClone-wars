import java.util.ArrayList;

public class Floyed_Warshall
{

	public static void main(String[] args)
	{
		/*
		 * Without path int m = 1; int n = 2; boolean[][] mat =
		 * BottleProblem.BottlesProblem1(m, n); floyed_warshall(mat);
		 * 
		 * MyFunctions.printMatt(mat); Why does this generic func Dont work with
		 * boolean? need to fix For now use specefied function
		 * MyFunctions.printMatt(mat);
		 */
		
		int m = 3;
		int n = 5;
		boolean[][] mat = BottleProblem.BottlesProblem1(m, n);
		int size = mat.length;
		String[][] path = InitPath(size , mat , n);
		floyd_warshall(mat,path);
		FixPath(path , n);
		System.out.println( "Bottle 1 = "+ m +" , Bottle 2 = "+n);
		
		IsExist(0,0,0,4,mat,path,n);
		
		System.out.println("\nAll paths : \n");
		
		

	}
	
	public static void floyed_warshall(boolean[][] mat)
	{
		int size = mat.length;
		for(int k = 0 ; k < size ; k++)
		{
			for(int i = 0 ; i < size ; i++)
			{
				for( int j = 0 ; j < size ; j++)
				{
					mat[i][j] = (mat[i][k] && mat[k][j] || mat[i][j]);
				}
			}
		}
	}
	
	public static void floyd_warshall(boolean[][] mat , String[][] paths)
	{
		int size = mat.length;
		for( int k = 0 ; k < size ; k++)
		{
			for( int i = 0 ; i < size ; i++)
			{
				for( int j = 0 ; j < size ; j++)
				{
					if(mat[i][j] == false && ((mat[i][k] && mat[k][j]) == true))
					{
						paths[i][j] = paths[i][k] + "->"+ paths[k][j];
					}
					mat[i][j] = (mat[i][k] && mat[k][j])||mat[i][j];
				}
			}
		}
	}
	
	
	private static void FixPath(String[][] path , int n)
	{
		for(int i = 0 ; i < path.length ; i++)
		{
			for(int j = 0 ; j < path.length ; i++)
			{
				path[i][j] += "->("+BottleProblem.getI(j, n) + " , " + BottleProblem.getJ(j, n)+")";
			}
		}
	}
	
	
	private static String[][] InitPath( int size , boolean[][] mat ,int n)
	{
		String[][] path = new String[size][size];
		for(int i = 0 ; i < path.length ; i++)
		{
			for( int j = 0 ; j < path.length ; i++)
			{
				if(mat[i][j] = true)
				{
					path[i][j] = "(" + BottleProblem.getI(i, n) + " , "+BottleProblem.getJ(i , n)+")";
				}
			}
		}
		
		return path;
	}
	
	public static void IsExist(int i1 , int j1 , int i2 , int j2 , boolean[][] mat , String[][]path , int n)
	{
		int i = BottleProblem.getIndex(i1, j1, n);
		int j = BottleProblem.getIndex(i2, j2, n);
		System.out.println("Is Exist path from ( "+i1+","+j1+" ) to ( "+i2+","+j2+ " )");
		if(mat[i][j] == true)
				System.out.println(path[i][j]);
		else
			System.out.println("No path");
	}
	
	/**
	 * A Simple method to check a graph connectivity , we check in the first vertex is connected to all the other verticies.
	 * mat[0][0] is not checked! because we dont care.
	 * @param mat
	 * @return
	 */
	public static boolean isConnected( boolean[][] mat)
	{
		for (int i = 1 ; i < mat.length ; i++) // does not check connectivity with itself!
		{
			if( mat[0][i] == false)
				return false;
		}
		return true;
	}
	
	public static int NumberOfComponents (boolean[][] mat)
	{
		int size = mat.length;
		ArrayList<Integer> seen = new ArrayList<Integer>();
		ArrayList<Integer> unSeen = new ArrayList<Integer>();
		for (int i = 0 ; i < size ; i++) // Put all nodes to "unSeen"
		{
			unSeen.add(i);
		}
		int counter = 0;
		while(unSeen.isEmpty() == false)
		{
			int vertex = unSeen.get(0);
			counter++;
			for( int j = 0 ; j < size ; j++)
			{
				if(mat[vertex][j] == true)
				{
					seen.add(j);
				}
			}
			unSeen = Substract(unSeen,seen);
		}
		
		return counter;
	}

	private static ArrayList<Integer> Substract(ArrayList<Integer> unSeen, ArrayList<Integer> seen) 
	{
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0 ; i < unSeen.size() ; i++)
		{
			if( seen.contains(unSeen.get(i))== false)
			{
				ans.add(unSeen.get(i));
			}
		}
		return ans;
	}
	
	
	
	
	

}
