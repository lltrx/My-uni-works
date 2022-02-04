package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private int id;
    private List<Node> neighbours;

    public Node(int id) {
        this.id = id;
        neighbours = new ArrayList<>();
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Node))
            return false;
        Node node = (Node) o;
        return getId() == node.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
