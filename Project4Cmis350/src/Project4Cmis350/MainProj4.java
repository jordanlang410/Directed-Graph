/* Name: Lang, Jordan
 * Project Name: Project4Cmis350
 * Date: 04/27/2021
 * Description: This class creates the GUI for the user to select a file from.
 * It then implements the Vertices, DFS Actions, DirectedGraph, Hierarchy, and
 * ParenthesizedList classes to output.
*/
package Project4Cmis350;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class MainProj4 {

	static DirectedGraph creGraph = new DirectedGraph();

	public static void infoFromText() {

		// Use JFileChooser to allow user to select file
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File(".")); // use current directory
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = new File(fc.getSelectedFile().getAbsolutePath());

			try {
				// Read in string from file
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String information = sc.nextLine();
					String[] info = information.split(" ");

					if (creGraph.startHead == null)
						creGraph.startHead = creGraph.mapVertex(info[0]);

					// create edges
					for (int i = 1; i < info.length; i++) {
						creGraph.edges(info[0], info[i]);
					}
				}
				sc.close();

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Could not find file.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		infoFromText();
		creGraph.depthFirstSearch();

		// Hierarchy
		System.out.println(creGraph.traveral1.toString());

		// Parenthesized List
		System.out.println(creGraph.traversal2.toString());

		creGraph.Unreachables();
	}
}
