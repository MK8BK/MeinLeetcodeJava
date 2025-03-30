import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution230 {
    public static void main(String[] args) {
        TreeNode example1 = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2, null, null)),
                new TreeNode(4, null, null));
        TreeNode example2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null, null));
        System.out.println(kthSmallest(example1, 1));
        System.out.println(kthSmallest(example2, 3));
        System.out.println(kthSmallestV2(example1, 1));
        System.out.println(kthSmallestV2(example2, 3));
    }


    public static void countOrMark(TreeNode root, int k, Integer[] c) {
        if (c[1] != null) return;
        if (root == null) return;
        countOrMark(root.left, k, c);
        if (c[1] != null) return;
        c[0]++;
        if (c[0] == k) {
            c[1] = root.val;
            return;
        }
        countOrMark(root.right, k, c);
    }

    public static int kthSmallestV2(TreeNode root, int k) {
        Integer[] cache = new Integer[2];
        cache[0] = 0;
        cache[1] = null;
        countOrMark(root, k, cache);
        return cache[1];
    }

    public static void inOrder(TreeNode root, List<Integer> l, int k) {
        if (root == null) return;
        if (l.size() == k) return;
        inOrder(root.left, l, k);
        if (l.size() == k) return;
        l.add(root.val);
        if (l.size() == k) return;
        inOrder(root.right, l, k);
    }

    public static int kthSmallest(TreeNode root, int k) {
        // assuming tree has at least 1 node
        List<Integer> l = new ArrayList<>();
        inOrder(root, l, k);
        return l.getLast();
    }
}
