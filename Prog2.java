// Programming Project 2
// Robert Anderson <rande59@lsu.edu>
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Prog2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		GraphADT graph = new GraphADT();
		File input = new File("input.txt");
		Scanner fileReader = new Scanner(input);

		while(fileReader.hasNextLine())
		{
			String command = fileReader.next();
			if(command.equals("add"))
				graph.add(fileReader.next().charAt(0), fileReader.next().charAt(0));
			else if(command.equals("remove"))
				graph.remove(fileReader.next().charAt(0), fileReader.next().charAt(0));
			else if(command.equals("breadth"))
				graph.breadth(fileReader.next().charAt(0));
			else if(command.equals("depth"))
				graph.depth(fileReader.next().charAt(0));
			else
				System.out.println("If you're seeing this, either the input file wasn't correct or my fileReader screwed up. Probably the latter.");
			if(fileReader.hasNextLine())	//if statement keeps fileReader from trying to grab a line that isn't there
				fileReader.nextLine();		//consumes new line character
		}
		fileReader.close();
	}

}
