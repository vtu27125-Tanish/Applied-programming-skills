import java.util.*;

class TreeNode {
    int val;
        TreeNode left, right;

            TreeNode(int val) {
                    this.val = val;
                        }
                        }

                        class Solution {

                            class NodeInfo {
                                    int row, col, val;

                                            NodeInfo(int row, int col, int val) {
                                                        this.row = row;
                                                                    this.col = col;
                                                                                this.val = val;
                                                                                        }
                                                                                            }

                                                                                                public List<List<Integer>> verticalTraversal(TreeNode root) {
                                                                                                        List<NodeInfo> list = new ArrayList<>();

                                                                                                                // BFS traversal
                                                                                                                        Queue<Object[]> queue = new LinkedList<>();
                                                                                                                                queue.offer(new Object[]{root, 0, 0}); // node, row, col

                                                                                                                                        while (!queue.isEmpty()) {
                                                                                                                                                    Object[] arr = queue.poll();
                                                                                                                                                                TreeNode node = (TreeNode) arr[0];
                                                                                                                                                                            int row = (int) arr[1];
                                                                                                                                                                                        int col = (int) arr[2];

                                                                                                                                                                                                    list.add(new NodeInfo(row, col, node.val));

                                                                                                                                                                                                                if (node.left != null)
                                                                                                                                                                                                                                queue.offer(new Object[]{node.left, row + 1, col - 1});

                                                                                                                                                                                                                                            if (node.right != null)
                                                                                                                                                                                                                                                            queue.offer(new Object[]{node.right, row + 1, col + 1});
                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                            // Sort based on col, then row, then value
                                                                                                                                                                                                                                                                                    Collections.sort(list, (a, b) -> {
                                                                                                                                                                                                                                                                                                if (a.col != b.col)
                                                                                                                                                                                                                                                                                                                return a.col - b.col;
                                                                                                                                                                                                                                                                                                                            if (a.row != b.row)
                                                                                                                                                                                                                                                                                                                                            return a.row - b.row;
                                                                                                                                                                                                                                                                                                                                                        return a.val - b.val;
                                                                                                                                                                                                                                                                                                                                                                });

                                                                                                                                                                                                                                                                                                                                                                        // Group by column
                                                                                                                                                                                                                                                                                                                                                                                List<List<Integer>> result = new ArrayList<>();
                                                                                                                                                                                                                                                                                                                                                                                        int prevCol = Integer.MIN_VALUE;

                                                                                                                                                                                                                                                                                                                                                                                                for (NodeInfo n : list) {
                                                                                                                                                                                                                                                                                                                                                                                                            if (n.col != prevCol) {
                                                                                                                                                                                                                                                                                                                                                                                                                            result.add(new ArrayList<>());
                                                                                                                                                                                                                                                                                                                                                                                                                                            prevCol = n.col;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    result.get(result.size() - 1).add(n.val);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return result;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }