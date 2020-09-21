package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fishawd
 * @date 2020/9/21 23:08
 * @description 图的广度优先搜索(邻接矩阵)
 */
public class BFS {

    //广度优先搜索
    //1. 访问首节点并入队
    //2. 若队不空，弹出该队头元素，访问队头元素的所有未被访问的邻接顶点并入队
    //3. 重复2
    int[] visit;
    public void bfs(int[][] matrix, int index) {
        Queue<Integer> queue = new LinkedList<>();
        visit[index] = 1;
        System.out.println(index);
        queue.add(index);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            //访问cur的所有未被访问的邻接顶点
            for (int i = 0; i < matrix.length; i++) {
                if (visit[i] == 0 && matrix[cur][i] == 1) {
                    visit[i] = 1;
                    System.out.println(i);
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        //结点数量
        int n = 8;
        //构造邻接矩阵
        int[][] matrix = new int[n][n];
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 1;
        matrix[2][0] = 1;
        matrix[2][3] = 1;
        matrix[2][6] = 1;
        matrix[3][1] = 1;
        matrix[3][2] = 1;
        matrix[3][5] = 1;
        matrix[4][1] = 1;
        matrix[5][3] = 1;
        matrix[6][2] = 1;
        matrix[6][7] = 1;
        matrix[7][6] = 1;
        BFS bfs = new BFS();
        bfs.visit = new int[n];
        bfs.bfs(matrix, 0);
    }
}
