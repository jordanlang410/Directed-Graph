/* Name: Lang, Jordan
 * Project Name: Project4Cmis350
 * Date: 04/27/2021
 * Description: This class is used to create edges for the "directed graph"
*/
package Project4Cmis350;

import java.util.*;

public class DirectedGraph extends Vertices.CreateGraph<Vertices> {

	public Vertices mapVertex(String node) {
		// put node with vertex
		if (!vertex.containsKey(node)) {
			vertex.put(node, new Vertices(node));
		}
		return vertex.get(node);
	}

	public void edges(String start, String end) {
		ArrayList<Vertices> vertices = adjacencyList.get(mapVertex(start));
		// edges?
		if (vertices == null) {
			vertices = new ArrayList<>();
		}

		vertices.add(mapVertex(end));
		// put in adjacencyList
		adjacencyList.put(mapVertex(start), vertices);
	}
}
