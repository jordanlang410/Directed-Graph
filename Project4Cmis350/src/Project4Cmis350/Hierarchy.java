/* Name: Lang, Jordan
 * Project Name: Project4Cmis350
 * Date: 04/27/2021
 * Description: This class is used to create a hierarchical representation toString of
 *  the class dependencies while flagging the circular dependencies. 
*/
package Project4Cmis350;

import java.util.*;

public class Hierarchy implements DFSActions<Vertices> {

	Queue<String> dfsOrder = new LinkedList<String>();

	@Override
	public String toString() {
		// use count to adjust spacing when printed
		int count = 0;
		String whiteSpace = "";

		while (!dfsOrder.isEmpty()) {
			String peek = dfsOrder.peek();
			dfsOrder.poll();

			// Use peek to check what is next in line without removing it
			if (peek == "(") {
				// use poll to remove from line
				if (dfsOrder.peek() == "*") {
					whiteSpace += dfsOrder.peek();
					dfsOrder.poll();
					dfsOrder.poll();
					continue;
				}
				count++;
			} else if (peek == ")") {
				--count;
			}
			// Skip over the parenthesis
			if (peek == "(" || peek == ")") {
				continue;
			}
			if (peek != "*") {
				whiteSpace += "\n";
			}
			for (int i = 0; i < count; i++) {
				whiteSpace += "       ";
			}
			whiteSpace += peek + " ";
		}
		whiteSpace += "\n";

		return whiteSpace;
	}

	public void detectedCycle() {
		dfsOrder.add("*");
	}
	public void addAction(Vertices s) {
		dfsOrder.add(s.toString());
	}
	public void descendAction(Vertices s) {
		dfsOrder.add("(");
	}
	public void ascendAction(Vertices s) {
		dfsOrder.add(")");
	}
}
