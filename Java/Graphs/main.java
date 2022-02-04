import java.nio.file.Path;

import graphExploration.GraphExplorer;
import graphs.GraphReader;
import graphs.Node;

public class main {
    public static void main(String[] args) {
        Path graphPath = Path.of("./graph1.txt");
        Path treePath = Path.of("tree.txt");
        try {
            Node[] nodes = GraphReader.readGraph(graphPath);
            GraphExplorer.writeTree(nodes, treePath);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
