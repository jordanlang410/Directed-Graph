/* Name: Lang, Jordan
 * Project Name: Project4Cmis350
 * Date: 04/27/2021
 * Description: This class is used to assist in the implementation of the depth first search
*/
package Project4Cmis350;

public interface DFSActions<vertex> {

	public void detectedCycle();

	public void addAction(vertex s);

	public void descendAction(vertex s);

	public void ascendAction(vertex s);
}
