package com.bishi._28;

public class Main {
    // 树的前序遍历, value children[]
    static class TreeNode {
        int val;
        TreeNode[] childrens;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, int size) {
            this.val = val;
            this.childrens = new TreeNode[size];
        }
        public TreeNode(int val, TreeNode[] childrens) {
            this.val = val;
            this.childrens = childrens;
        }
    }
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        if(root.childrens != null) {
            for(TreeNode child : root.childrens) {
                preOrder(child);
            }
        }

    }
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1, 4);

        for(int i = 0; i < 4; i ++) {
            if(i == 0) {
                TreeNode tmp = new TreeNode(i + 2, 3);
                for(int j = 0; j < 3; j ++) {
                    tmp.childrens[j] = new TreeNode(j + 6);
                    System.out.print(tmp.childrens[j]);
                }
                root.childrens[i] = tmp;
            }

            root.childrens[i] = new TreeNode(i+2);
        }

        return root;
    }
    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.print(root.childrens[0].childrens);
        preOrder(root);
    }
}
