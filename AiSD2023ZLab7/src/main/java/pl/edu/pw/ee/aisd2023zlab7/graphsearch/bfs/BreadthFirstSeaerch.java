package pl.edu.pw.ee.aisd2023zlab7.graphsearch.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import pl.edu.pw.ee.aisd2023zlab7.data.input.Graph;
import pl.edu.pw.ee.aisd2023zlab7.data.outcome.GraphBfsResult;
import pl.edu.pw.ee.aisd2023zlab7.graphsearch.Color;
import pl.edu.pw.ee.aisd2023zlab7.graphsearch.services.GraphSearch;

public class BreadthFirstSeaerch implements GraphSearch {
    private final int initVal = -1;

    private Deque<Integer> queue;
    private Color[] color;
    private int[] prev;
    private int[] dist;

    private Graph graph;

    @Override
    public GraphBfsResult searchGraphPaths(Graph graph, int startId) {
        initData(graph);

        processFirstVertice(startId);

        processAllRestVertices();

        GraphBfsResult result = new GraphBfsResult(startId, prev, dist);

        return result;
    }

    private void initData(Graph graph) {
        this.graph = graph;

        initColors();
        initPrevVertices();
        initDist();
    }

    private void initColors() {
        int nVertices = graph.getNumOfVertices();

        color = new Color[nVertices];

        for (int i = 0; i < nVertices; i++) {
            color[i] = Color.WHITE;
        }
    }

    private void initPrevVertices() {
        int nVertices = graph.getNumOfVertices();

        prev = new int[nVertices];

        for (int i = 0; i < nVertices; i++) {
            prev[i] = initVal;
        }
    }

    private void initDist() {
        int nVertices = graph.getNumOfVertices();

        dist = new int[nVertices];

        for (int i = 0; i < nVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    private void processFirstVertice(int startId) {
        color[startId] = Color.GRAY;
        dist[startId] = 0;
        queue = new ArrayDeque<>();

        queue.add(startId);
    }

    private void processAllRestVertices() {
        int currentVertice;

        while (!queue.isEmpty()) {
            currentVertice = queue.removeFirst();

            int[] neighbours = graph.getNeighbours(currentVertice);

            for (int neighbourId : neighbours) {

                if (isWhite(neighbourId)) {

                    dist[neighbourId] = dist[currentVertice] + 1;
                    prev[neighbourId] = currentVertice;
                    color[neighbourId] = Color.GRAY;

                    queue.add(neighbourId);
                }
            }

            color[currentVertice] = Color.BLACK;
        }
    }

    private boolean isWhite(int verticeId) {
        return color[verticeId] == Color.WHITE;
    }

}
