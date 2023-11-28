package pl.edu.pw.ee;

import java.io.File;
import java.io.IOException;

public class Huffman {
    public static void main(String[] args) {
        String filePath = "AiSD2023ZLab5/src/main/resources/niemanie.txt";

        try {
            ReadFromFile reader = new ReadFromFile(new File(filePath));
            Tree tree = new Tree();
            tree.addNodesToPriorityQueue(reader.getCharactersQuantity());
            tree.buildTree();
            Node root = tree.getRoot();

            tree.dfs(root,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}