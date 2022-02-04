package graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GraphReader {

    public static Node[] readGraph(Path path) throws IOException {
        List<String> graphFile;

        try {
            graphFile = Files.readAllLines(path.getFileName());
        } catch (Exception e) {
            throw new IOException("Error reading file " + path.getFileName());
        }
        Node[] nodes = new Node[Integer.parseInt(graphFile.get(0))];
        int[][] edges = new int[Integer.parseInt(graphFile.get(1))][2];
        for (int i = 2; i < graphFile.size(); i++) {
            String[] edgeStr = graphFile.get(i).split(" ");
            int[] edge = new int[2];
            edge[0] = Integer.parseInt(edgeStr[0]);
            edge[1] = Integer.parseInt(edgeStr[1]);
            edges[i - 2] = edge;
        }

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0] - 1].addNeighbour(nodes[edges[i][1] - 1]);
        }

        return nodes;
    }
}
