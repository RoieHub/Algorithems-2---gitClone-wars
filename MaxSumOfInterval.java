/**
 * @author RoieJinx
 * This class will solve a problem of Max sum Subinterval of an interval
 */

public class MaxSumOfInterval
{
/**
 * 
 * @param array of integers
 * @return a int array of size two ,  where statring index is ans[0] , ending index is ans[1]; 
 */
	public static int[] maxSumOfSubArray(int[]array)
	{
		int arrSize = array.length;
		// 1. Create a matrix for dynamic programing algo
		int [][] matrix = new int[arrSize][arrSize];
		
	
		
		for(int r = 1 ; r < arrSize ; r++)
		{
			for(int c = r ; c < arrSize ; c++)
			{
				matrix[r][c] = matrix[r][c-1] + array[c]; // adding the previous resualt to  to the next cell;
			}
		}
		// 2. find max value of matrix
		// 3. set ans[0] = r of max value , ans[1] = c of max value;
		
		
		
		
		return null;
	}
	/**
	 * Calculates very efficiently the max value in each row
	 * @param matRow
	 * @return int[] ans ,  where ans[0] is the max value found in the row , ans[1] the index in the row where we found max value;
	 */
	private static int[] maxOfArray(int matRow[] , int startingPos)
	{
		int min = matRow[startingPos];
		int max = matRow[startingPos+1];
		if(min > max) {min = matRow[startingPos+1]; max = matRow[startingPos]; }
		for( int i = startingPos+2 ; i < matRow.length-1 ; i=  i +2)
		{
			
		}
		return null;
	}
	
	
	public static void main(String[] args) 
	{
		//int[] array = new int[] {3,-2,5,1}; // This max sub interval is the whole array
		
		//int [] result = maxSumOfSubArray(array);
	}

}
