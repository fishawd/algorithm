package graph;

import java.util.Stack;

/**
 * @author fishawd
 * @date 2020/9/21 20:44
 * @description 图的深度优先搜索(邻接矩阵)
 */
public class DFS {
    //深度优先搜索， 递归写法
    //1. 从点v出发，在所有与v邻接的点中任意找一个点w
    //2. 若w未被访问，则访问w，重复步骤1， 若w已经被访问，则寻找下一个未被访问的顶点
    //   若v的邻接顶点w全部被访问，则回溯至v的上一个顶点，重复步骤1
    int[] visit;
    public void dfs(int[][] matrix, int index) {
        visit[index] = 1;
        System.out.println(index);
        for (int i = 0; i < matrix.length; i++) {
            // 寻找顶点index未被访问过的邻接顶点
            if (visit[i] == 0 && matrix[index][i] == 1) {
                dfs(matrix, i);
            }
        }
    }


    //DFS非递归写法
    //1. 访问首节点并入栈
    //2. 若栈不空，取栈顶结点，寻找栈顶结点未被访问过的邻接顶点
    //3. 若找到，则访问并入栈，重复2， 否则说明栈顶结点的所有邻接顶点都被访问过，则弹出栈顶结点
    public void dfsNoRecur(int[][] matrix, int index) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        visit[index] = 1;
        System.out.println(index);
        while (!stack.isEmpty()) {
            int cur = stack.peek();
            //寻找cur的未被访问过的邻接顶点
            int flag = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (visit[i] == 0 && matrix[cur][i] == 1){
                    visit[i] = 1;
                    System.out.println(i);
                    stack.push(i);
                    flag = 1;
                    break;
                }
            }
            // cur的所有邻接顶点都已经访问过，则弹出该结点
            if (flag == 0){
                stack.pop();
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
        DFS dfs = new DFS();
        // 访问标识
        dfs.visit = new int[n];
        // 从顶点0开始遍历
        dfs.dfs(matrix, 3);

        //DFS非递归遍历
        System.out.println("----");
        dfs.visit = new int[n];
        dfs.dfsNoRecur(matrix, 3);
    }
}
