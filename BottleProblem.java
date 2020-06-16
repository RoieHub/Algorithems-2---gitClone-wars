/**
 * 
 * @author Roie Malykin
 *This introductionary Algorithem is revolving around two bottles of water.
 * Let the First bottle volume be an integer "m" Litres , and the other "n"
 * Note!: a bottle with max volume of m, can hold only whole number of Liters (from 0 to m [0,1,2....m-1,m]) 
 */
public class BottleProblem 
{
	///// Index getters
	public static int getIndex(int i , int j , int n)
	{
		return ( n + 1 ) * i + j ; // This is k = (n+1)*(rowIndex) + (Column index)
	}
	
	public static int getI(int k , int n)
	{
		return k / ( n + 1 );
	}
	
	public static int getJ (int k , int n)
	{
		return k % ( n + 1 );
	}
	
	
	public static boolean[][] BottlesProblem(int m,int n)
	{
		int size = ( m + 1 ) * ( n + 1 ) ;
		boolean[][] mat = new boolean[size][size];
		System.out.println("This is test");
		//First Method
		int k;
		for( int i = 0 ; i < m+1 ; i++)
		{
			for( int j = 0 ; j < n+1 ; j++)
			{
				k = getIndex(i,j,n);
				// Now all six possiable Steps
				mat[k][getIndex(0, j, n)] = true; // Throw away all the water from first bottle
				mat[k][getIndex(i , 0 , n)] = true; // Throw away all the water from the second bottle
				mat[k][getIndex(m,j,n)] = true; // Fill First bottle 
				mat[k][getIndex(i, n, n)] = true; // Fill Second bottle
				/**
				 * TO pour from one bottle to another we should consider:
				 * if the second bottle volume is high inuf to contain all the bottle
				 */
				mat[k][getIndex(i + j - (Math.min(i + j, n)),Math.min( i + j  , n),n)] = true; // Pour first bottle to second bottle
				mat[k][getIndex(Math.min( i + j , m),( i + j - Math.min( i + j , m)) , n )] = true; // Pour second bottle to first bottle
			}
		}
		
		return mat;
		
	}
	

	public static void main(String[] args) 
	{
		int m = 1 ; // First bottle
		int n = 2 ; // Second bottle
		boolean[][] mat = BottlesProblem(m,n);//First Method

	}

}
