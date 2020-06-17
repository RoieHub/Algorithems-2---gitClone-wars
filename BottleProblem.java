/**
 * 
 * @author Roie Malykin
 * @Idea: This introductionary algorithem is an example for a proper use of adjacency 2D matrix to find if two nodes are connected.
 * 		  And also how to think about vectors as indexes.
 * 
 * @ The Problem:   
 * 				Let their be a two bottles of water.
 * 			    The max volume of the first bottle is noted by "m and the other "n" , while m,n are both integers for expamle (3L,5L)
 * 				Note!: a bottle with max volume of m, can hold only whole number of Liters (from 0 to m [0,1,2....m-1,m]) 
 *
 * 				the problem starts with those two bottles are filled with "aL" and "bL" (  0 <= a <= m , 0<= b <= n)
 * 				there are 6 operations possible:
 * 												1) Empty First bottle.
 * 												2) Empty Second bottle.
 * 												3) Completely fill the first bottle.
 * 												4) Completely fill the second bottle.
 * 												5) Pour water from the first bottle to the second bottle (leaving any reminder of water in the first bottle).
 * 												6) Pour water from the second bottle to the first bottle (leaving any reminder of water in the second bottle).
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
	
	
	public static boolean[][] BottlesProblem1(int m,int n)
	{
		int size = ( m + 1 ) * ( n + 1 ) ;
		boolean[][] mat = new boolean[size][size];
		//First Method Nested Loop
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
	
	public static boolean[][] BottlesProblem2(int m,int n)
	{
		int size = ( m + 1 ) * ( n + 1 ) ;
		boolean[][] mat = new boolean[size][size];
		
		//Second Method regular loop
		int i , j;
				for(int k = 0 ; k < size ; k++)
				{
					i = getI(k, n);
					j = getJ(k,n);
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
		
		return mat;
		
	}
	

	public static void main(String[] args) 
	{
		int m = 1 ; // First bottle
		int n = 2 ; // Second bottle
		boolean[][] mat = BottlesProblem2(m,n);//First Method

	}

}
