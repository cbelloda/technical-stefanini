import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoneyParts {
    static List<Double[]> result;
    static long[] DENOMNATIONS_NORMALIZE = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000 };
    static int LIMITS_COIN = 10000;
    static int NORM=100;

    public List<Double[]> build(double input) {
        result = new ArrayList<Double[]>();
        int inputnormalize=(int)(input*(double)NORM);
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(0);
        fillTree(DENOMNATIONS_NORMALIZE, DENOMNATIONS_NORMALIZE.length, inputnormalize, tree.root);
        long path[] = new long[LIMITS_COIN];
        fillPaths(tree.root, path, 0);
        for(Double[] values:result){
            printArray(values);
        }
        return result;
    }

    static int fillTree(long S[], int m, long n, Node node) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (m <= 0 && n >= 1) {
            return 0;
        }
        if (n - S[m - 1] < 0 || m - 1 < 0) {
            node.left = new Node(-1);
            node.right = new Node(0);
        } else {
            node.left = new Node(S[m - 1]);
            node.right = new Node(0);
        }
        if (m - 1 == 0 && n > 0) {
            node.right = new Node(-1);
        }

        return fillTree(S, m - 1, n, node.right) + fillTree(S, m, n - S[m - 1], node.left);
    }

    public static void main(String[] args) {
        List<Double[]>combinationsCoin=new MoneyParts().build(0.5);
        System.out.println("Se encontraron: "+combinationsCoin.size()+" combinaciones");       
    }

    static class Node {
        long value;
        Node left, right;

        public Node(long value) {
            this.value = value;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree(long key) {
            root = new Node(key);
        }

        BinaryTree() {
            root = null;
        }
    }

    static void fillPaths(Node node, long[] path, int pathLen) {
        if (node == null)
            return;
        path[pathLen] = node.value;
        pathLen++;
        if (node.left == null && node.right == null && !contains(path, -1)) {
            List<Double> combinationCoin= new ArrayList<Double>();
            for (int i = 0; i < pathLen; i++) {
                if(path[i]!=0){
                    combinationCoin.add(new BigDecimal(path[i]).divide(new BigDecimal(NORM)).doubleValue());
                }
            }
            Double[] valuesCoin=new Double[combinationCoin.size()];
            result.add(combinationCoin.toArray(valuesCoin));
        }

        else {
            fillPaths(node.left, path, pathLen);
            fillPaths(node.right, path, pathLen);
        }
    }

    static void printArray(Double values[]) {
        System.out.print("[");
        for(Double value:values){
            System.out.print(value+" , ");
        }
        System.out.println("]");
    }

    public static boolean contains(long[] array, long v) {
        for (long i : array) {
            if (i == v) {
                return true;
            }
        }
        return false;

    }

}