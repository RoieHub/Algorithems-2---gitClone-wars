
public class MyFunctions
{
	
	public static < T > void printMatt( T [][] mat)
	{
		int row_size = mat.length;
		int col_size = mat[0].length;
		for( int r = 0 ; r <= row_size ; r++)
		{
			for( int c = 0 ; c <= col_size ; c++)
			{
				System.out.print(mat[r][c]);
				System.out.print("  ,  ");
				
			}
			System.out.println(); // line down
		}
		
	}

	public static void printMatt(boolean[][] mat) 
	{
		int row_size = mat.length;
		int col_size = mat[0].length;
		for( int r = 0 ; r <= row_size ; r++)
		{
			for( int c = 0 ; c <= col_size ; c++)
			{
				System.out.print(mat[r][c]);
				System.out.print("  ,  ");
				
			}
			System.out.println(); // line down
		}
		
	}

}
