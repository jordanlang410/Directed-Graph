/* Name: Lang, Jordan
 * Project Name: Project4Cmis350
 * Date: 04/27/2021
 * Description: This class is used to create the graph with the internal representation
 * being an adjacency list.  It then performs a depth first search of the graph.
*/
package Project4Cmis350;

import java.util.*;

public class Vertices {

	private String classPoint;

	// constructor
	public Vertices(String classPoint) {
		this.classPoint = classPoint;
	}

	// get method
	public String getClassPoint() {
		return classPoint;
	}

	// ensure hierarchy prints out as the strings
	@Override
	public String toString() {
		return getClassPoint();
	}

	public static class CreateGraph<neighbors> {

		Map<neighbors, ArrayList<neighbors>> adjacencyList = new HashMap<neighbors, ArrayList<neighbors>>();

		Hierarchy traveral1 = new Hierarchy();
		ParenthesizedList traversal2 = new ParenthesizedList();

		boolean performCycle = false;

		// use HashSet to keep list of discovered vertex
		HashSet<neighbors> discover = new HashSet<>();

		// use a HashSet to check and add vertex
		HashSet<neighbors> checkVisitedVertex = new HashSet<>();

		private void depthFirst(neighbors vertex) {

			// If vertex is discovered, detect cycle
			if (discover.contains(vertex)) {
				performCycle = true;

				traveral1.detectedCycle();
				traversal2.detectedCycle();
				return;
			}

			// Perform add vertex action
			traveral1.addAction((Vertices) vertex);
			traversal2.addAction((Vertices) vertex);

			// mark vertex as discovered
			discover.add(vertex);

			// Perform Descend action
			traveral1.descendAction((Vertices) vertex);
			traversal2.descendAction((Vertices) vertex);

			// for all adjacent vertices
			ArrayList<neighbors> neighbors = adjacencyList.get(vertex);
			if (neighbors != null) {
				for (neighbors adjV : neighbors)
					depthFirst(adjV);
			}

			// visited
			checkVisitedVertex.add(vertex);

			// Perform Ascend action
			traveral1.ascendAction((Vertices) vertex);
			traversal2.ascendAction((Vertices) vertex);

			// finished and remove
			discover.remove(vertex);

		}

		public void Unreachables() {
			// use .entry to get key/value
			for (Map.Entry<neighbors, ArrayList<neighbors>> entry : adjacencyList.entrySet()) {

				// Check the key to see if it is reachable
				if (!checkVisitedVertex.contains(entry.getKey())) {
					System.out.println(entry.getKey() + " is unreachable");
					checkVisitedVertex.add(entry.getKey());
				}

				// Check other adjacent values to see if they are reachable
				for (neighbors vertex : entry.getValue()) {
					if (!checkVisitedVertex.contains(vertex)) {
						System.out.println(vertex + " is unreachable");
						checkVisitedVertex.add(vertex);
					}
				}
			}
		}

		public neighbors startHead = null;

		// use Method depthFirst to implement the search of the graph already created
		public void depthFirstSearch() {

			depthFirst(startHead);
		}

		Map<String, neighbors> vertex = new HashMap<String, neighbors>();

		private neighbors mapVertex(String className) {
			return vertex.get(className);
		}
	}
}
