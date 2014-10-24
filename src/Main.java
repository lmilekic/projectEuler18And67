import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {

	public static void main(String[] args)
	{
		Scanner input = null;
		try {
			input = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Integer[]> numbers = new ArrayList<Integer[]>();
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			//get each number as a string
			String[] splitLine = line.split("\\s+");
			Integer[] intLine = new Integer[splitLine.length];
			//turn that string into a number
			for(int i = 0; i < splitLine.length; i++)
			{
				String num = splitLine[i];
				intLine[i] = Integer.parseInt(num);
			}
			//store it all in our friendly number array
			numbers.add(intLine);
		}
		System.out.println(maxPath(numbers));
	}

	private static int maxPath(ArrayList<Integer[]> numbers) {
		int max = 0;
		for(int i = numbers.size() - 1; i > 0; i--)
		{
			//go from bottom up calculating max
			Integer[] bottomLine = numbers.get(i);
			Integer[] topLine = numbers.get(i-1);
			maxPath(bottomLine, topLine);
		}
		max = numbers.get(0)[0];
		return max;
	}

	private static void maxPath(Integer[] bottomLine, Integer[] topLine) {
		for(int i = 0; i < topLine.length; i++)
		{
			int parent = topLine[i];
			int leftChild = bottomLine[i];
			int rightChild = bottomLine[i + 1];
			topLine[i] = topLine[i] + Math.max(leftChild, rightChild);
		}
		
	}
}
