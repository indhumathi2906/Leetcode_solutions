/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    private class ListNode {
        private TreeNode treeNode;
        private ListNode next; 

        public ListNode() {} 
        public ListNode(TreeNode treeNode) {this.treeNode = treeNode;} 
    } 

    private TreeNode root;
    private ListNode head1, head2;
    private ListNode cur1, cur2;
    private boolean goLeft;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.head1 = new ListNode(root);
        this.head2 = new ListNode(new TreeNode(-1));
        this.cur1 = head1;
        this.cur2 = head2;
        this.goLeft = true;
    }
    
    public int insert(int val) {

        while (head1 != null) {

            while (cur1 != null) {
                TreeNode now = cur1.treeNode;

                if (goLeft) {
                    goLeft = false;

                    if (now.left == null) {
                        now.left = new TreeNode(val);

                        cur2.next = new ListNode(now.left);
                        cur2 = cur2.next;

                        return now.val;
                    } else {
                        cur2.next = new ListNode(now.left);
                        cur2 = cur2.next;
                    }
                } 
                
                if (!goLeft) {
                    goLeft = true;
                    if (now.right == null) {
                        now.right = new TreeNode(val);

                        cur2.next = new ListNode(now.right);
                        cur2 = cur2.next;

                        cur1 = cur1.next;

                        return now.val;
                    } else {
                        cur2.next = new ListNode(now.right);
                        cur2 = cur2.next;
                    }
                } 
                
                cur1 = cur1.next;
            } 

            head1 = head2.next;
            cur1 = head1;
            head2 = new ListNode(new TreeNode(-1));
            cur2 = head2;
        }

        return 0;
    }
    
    public TreeNode get_root() {
        
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
