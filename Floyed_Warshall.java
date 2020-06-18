
public class Floyed_Warshall
{

	public static void main(String[] args)
	{
		// Without path
		int m = 1;
		int n = 2;
		boolean[][] mat = BottleProblem.BottlesProblem1(m, n);
		
		//MyFunctions.printMatt(mat); Why does this generic func Dont work with boolean? need to fix
		//For now use specefied function
		MyFunctions.printMatt(mat);

	}
//TEST
}
