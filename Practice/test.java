package Practice;

import java.util.*;

public class test {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,1));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for (int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (isCycleUtil(graph, vis, e.dest, curr)) {
                        return true;
                }
            } else if (vis[curr] && e.dest != parent) {
                return true;
            }
        }
        return false;
    }


    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // source node

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph,vis,i);
            }
        }
    }

    private static void dfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,vis,e.dest);
            }
        }
    }



    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int minDepth(Node root){
        // base case
        if(root==null){
            return 0;
        }

        // case when leaf node is found;
        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left==null){
           return minDepth(root.right)+1;
        }else if (root.right == null){
            return minDepth(root.left);
        }

        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }




    static int r = 3;
    static int c = 5;
    public static boolean canRot(int[][] arr){

        int no = 2;

        for (int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(arr[i][j] == no){

                    if(isSafe(i+1,j) && arr[i+1][j] == 1){
                        arr[i+1][j] = 2;
                    }
                    if(isSafe(i-1,j) && arr[i-1][j] == 1){
                        arr[i-1][j] = 2;
                    }
                    if(isSafe(i,j+1) && arr[i][j+1] == 1){
                        arr[i][j+1] = 2;
                    }
                    if(isSafe(i,j-1) && arr[i][j-1] == 1){
                        arr[i][j-1] = 2;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(arr[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(int x,int y){
        return x >= 0 && x < r && y >= 0 && y < c;
    }




    static int row,col,count;
    public static int largestRegion(int[][] arr){
        boolean[][] vis = new boolean[row][col];

        int result = Integer.MIN_VALUE;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == 1 && !vis[i][j]){
                    count = 1;
                    dfsLargest(arr,vis,i,j);

                    result = Math.max(result,count);
                }
            }
        }
        return result;
    }

    private static void dfsLargest(int[][] arr,boolean[][] vis, int x,int y){
        int[] rowNbr = {-1,-1,-1,0,0,1,1,1};
        int[] colNbr = {-1,0,1,-1,1,-1,0,1};

        vis[x][y] = true;
        for(int i=0; i<8; i++){
            if(isSafe(arr,vis, x+rowNbr[i], y+colNbr[i]) ){
                count++;
                dfsLargest(arr,vis, x+rowNbr[i], y+colNbr[i]);
            }
        }
    }

    private static boolean isSafe(int[][] arr, boolean[][] vis, int x,int y){
        return x>=0 && x<row && y>=0 && y<col && (!vis[x][y] && arr[x][y] == 1);
    }




    public static int minPalindrome(int[] arr){
        int n = arr.length;
        int s = 0;
        int e = n-1;

        int count = 0;
        if(arr.length == 3 && arr[s] == arr[e]){
            return count;
        }else if(arr[s] == arr[e]){
            s++;
            e--;
            while(s<e){
                count++;
                s++;
                e--;
            }
        }else{
            // as we have to merge extra at last
            count = 1;
            while(s<e){
                s++;
                e--;
                count++;
            }
        }

        return count;
    }




    public static void possibleCombinations(int[] arr,int r){
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(arr[i]);
        }
        if(r==n){
            while (!q.isEmpty()){
                System.out.print(q.remove() + " ");
            }
            return;
        }

        for(int i=1; i<n; i++){
            int curr = q.remove();

        }
    }


    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

//        System.out.println(isCycle(graph));


        Node root = new Node(1);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(9);

//        preOrder(root);

//        System.out.println(minDepth(root));



        int[][] arr =  {{2,1,0,2,1},
                        {0,0,1,2,1},
                        {1,0,0,2,1}};

//        if(canRot(arr)){
//            System.out.println("Can be rotten");
//        }else {
//            System.out.println("Cannot be rotten");
//        }

        int[][] region = {{0,0,1,1,0},
                          {0,0,1,1,0},
                          {0,0,0,0,0},
                          {0,0,0,0,1}};
        row = arr.length;
        col = arr[0].length;

//        System.out.println(largestRegion(region));

        int[] pal = {15, 4, 15};
//        System.out.println(minPalindrome(pal));


        int[] comb = {1,2,3,4};
        int r = 2;



    }
}
