package pl.edu.pw.ee.aisd2023zlab7.graphsearch.dfs;

import pl.edu.pw.ee.aisd2023zlab7.data.input.Graph;
import pl.edu.pw.ee.aisd2023zlab7.data.outcome.GraphDfsResult;

import java.util.Arrays;


public class LabyrinthSolve {

    public boolean willItPass(Graph graph, int start, int end) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        GraphDfsResult result = dfs.searchGraphPaths(graph,start);

        return result.getOutputOrder()[start] > result.getOutputOrder()[end];
    }
}
