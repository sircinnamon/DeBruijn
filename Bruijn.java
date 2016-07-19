import java.util.LinkedList;
public class Bruijn
{
	//dailyprogrammer challenge 274 intermediate
	//De Bruijn sequences - B(k,n)
	//cyclyical loops of k characters that include every possible substring on length n
	public static void main(String[] args)
	{
		if(args.length != 2){System.exit(0);}
		String alphabet = "";
		int n = 0;
		if(args[0].matches("[0-9]+"))
		{
			int k = Integer.parseInt(args[0]);
			if(k>26){k=26;}
			for(int i = 65; i < 65+k; i++)
			{
				alphabet = alphabet + ""+ (char)i;
			}
		}
		else{alphabet = args[0];}
		//System.out.println(alphabet);
		n = Integer.parseInt(args[1]);
		//duval(alphabet, n);
		System.out.println(bruijn(alphabet, n));
	}

	public static String bruijn(String k, int n)
	{
		int length = (int)Math.pow(k.length(), n);
		LinkedList<String> lyndon = duval(k,n);
		String sequence = "";
		for(int i = 0; i < lyndon.size(); i++)
		{
			sequence = sequence+lyndon.get(i);
		}
		return sequence;
	}
	
	public static LinkedList<String> duval(String alphabet, int n)
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add(""+alphabet.charAt(0));
		return duval(alphabet, n, list.get(0), list);
	}
	public static LinkedList<String> duval(String alphabet, int n, String prev, LinkedList<String> list)
	{
		//Uses duval to generate length n (or length of a factor of n) lyndon words
		String current = "";
		//1. Reapeat symbols from prev to form length n word
		while(current.length() < n){current = current + prev;}
		current = current.substring(0, n);
		//2. while last char is final char of alphabet, remove it
		while(current.length() > 0 && current.charAt(current.length()-1) == alphabet.charAt(alphabet.length()-1))
		{
			current = current.substring(0, current.length()-1);
		}
		//If there is nothing left, end is reached
		if(current.length() == 0){return list;}
		//3.Increment last char along the alphabet
		String lastChar;
		lastChar = ""+current.charAt(current.length()-1);
		current = current.substring(0, current.length()-1);
		current = current + alphabet.charAt(alphabet.indexOf(lastChar) + 1);
		//If n is divisible by current.length, add it to list, else continue on
		if(n % current.length() == 0)
		{
			list.add(current);
		}
		//System.out.println(current);
		return duval(alphabet, n, current, list);
	}
}