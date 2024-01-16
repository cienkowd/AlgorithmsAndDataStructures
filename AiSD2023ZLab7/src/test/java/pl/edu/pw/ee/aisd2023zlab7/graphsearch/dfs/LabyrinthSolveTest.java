package pl.edu.pw.ee.aisd2023zlab7.graphsearch.dfs;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2023zlab7.data.input.AdjacencyMatrix;
import pl.edu.pw.ee.aisd2023zlab7.data.input.Graph;

import static pl.edu.pw.ee.aisd2023zlab7.utils.ConstPathsToFiles.PATH_GRAPH_5_5;

public class LabyrinthSolveTest {

    private LabyrinthSolve labyrinthSolve;

    @BeforeEach
    public void setUp() {
        labyrinthSolve = new LabyrinthSolve();
    }

    @Test
    public void should_ReturnTrue_When_FindEnd() {
        //given
        Graph graph = new AdjacencyMatrix(PATH_GRAPH_5_5);
        int start = 0;
        int end = 2;

        //when
        boolean willItPass = labyrinthSolve.willItPass(graph,start,end);

        //then
        assertThat(willItPass).isTrue();
    }

    @Test
    public void should_ReturnFalse_When_NotFindEnd() {
        //given
        Graph graph = new AdjacencyMatrix(PATH_GRAPH_5_5);
        int start = 0;
        int end = 3;

        //when
        boolean willItPass = labyrinthSolve.willItPass(graph,start,end);

        //then
        assertThat(willItPass).isFalse();
    }
}
