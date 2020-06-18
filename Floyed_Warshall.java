
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
		
		IsExist(0,0,0,4,path,n);
		
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
	

}
