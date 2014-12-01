/**
 * Jose Sandoval
 * CIS-18C: Java Programming
 * November 24, 2014
 * Description:
 */

public class Main
{
    public static void main(String[] args)
    {
        // Instantiate a Graph object.
        Graph graph = new Graph();

        // Add edges to the graph.
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("D", "G");
        graph.addEdge("E", "G");

        // Add a single vertex to the graph,
        // that connects to no other vertex.
        graph.addVertex("H");


        System.out.println(graph.escapedVersion("Bacon, Kevin"));

        // Print out graph.
       // System.out.println(graph);

        // print out graph again by iterating over vertices and edges.
        for (Vertex v : graph.getVertices())
        {
            System.out.print(v + ": ");

            for (Vertex w : graph.adjacentTo(v.name))
                System.out.print(w + " ");

            System.out.println();
        }

        graph.outputGDF("graph.gdf");

        graph.printBFT("A");
    }
}