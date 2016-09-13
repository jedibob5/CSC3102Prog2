// Programming Project 2
// Robert Anderson <rande59@lsu.edu>
import java.util.ArrayList;

public class GraphADT
{
	private ArrayList<Vertex> vertices;
	
	private class Vertex
	{
		public char key;
		public ArrayList<Character> edges = new ArrayList<Character>();
		public Vertex(char k) {key = k;}
	}
	
	public GraphADT()
	{
		vertices = new ArrayList<Vertex>();
	}
	
	//Ensures both vertices are in the graph, then creates an edge starting at x pointing to y.
	public void add(char x, char y)
	{
		if(getVertex(x) == null)
			vertices.add(new Vertex(x));
		if(getVertex(y) == null)
			vertices.add(new Vertex(y));
		getVertex(x).edges.add(y);
	}
	
	//Removes an edge between vertices, if one exists. Does not remove the actual vertices.
	public void remove(char x, char y)
	{
		if(getVertex(x) != null)
			getVertex(x).edges.remove(getVertex(x).edges.indexOf(y));
	}
	
	//Private method that returns vertex with the given key within the list of vertices.
	//Returns null if vertex is not present.
	private Vertex getVertex(char x)
	{
		for(int i = 0; i < vertices.size(); i++)
		{
			if(vertices.get(i).key == x)
				return vertices.get(i);
		}
		return null;
	}
	
	//Wrapper method for recursively performing and printing a breadth-first traversal of the graph
	public void breadth(char x)
	{
		//If given vertex does not exist, traversal cannot be performed
		if(getVertex(x) == null)
			return;
		
		ArrayList<Character> q = new ArrayList<Character>();
		ArrayList<Character> visited = new ArrayList<Character>();
		q.add(x);
		breadth(getVertex(x), q, visited);
		
		for(int i = 0; i < q.size(); i++)
		{
			System.out.print(q.get(i) + " ");
		}
		System.out.println();
	}
	
	private void breadth(Vertex x, ArrayList<Character> q, ArrayList<Character> visited)
	{
		visited.add(x.key);
		
		//if any children have not already been visited, add to queue
		for(int i = 0; i < x.edges.size(); i++)
		{
			if(q.indexOf(x.edges.get(i)) == -1)
				q.add(x.edges.get(i));
		}
		//after additions, recursively visit children
		for(int i = 0; i < x.edges.size(); i++)
		{
			if(visited.indexOf(x.edges.get(i)) == -1)
				breadth(getVertex(x.edges.get(i)), q, visited);
		}
	}
	
	//Wrapper method for recursively performing and printing a depth-first traversal of the graph
	public void depth(char x)
	{
		//If given vertex does not exist, traversal cannot be performed
		if(getVertex(x) == null)
			return;
		
		ArrayList<Character> s = new ArrayList<Character>();
		ArrayList<Character> visited = new ArrayList<Character>();
		depth(getVertex(x), s, visited);
		
		for(int i = s.size() - 1; i >= 0; i--)
		{
			System.out.print(s.get(i) + " ");
		}
		System.out.println();
	}
	
	private void depth(Vertex x, ArrayList<Character> s, ArrayList<Character> visited)
	{
		visited.add(x.key);
		
		//traverse all children recursively
		for(int i = 0; i < x.edges.size(); i++)
		{
			if(visited.indexOf(x.edges.get(i)) == -1)
				depth(getVertex(x.edges.get(i)), s, visited);
		}
		
		//once no more unvisited children remain, add key to stack and recursion moves up the tree
		s.add(x.key);
	}
}