package algorithm.minspanningtree;

public class DisjointSetUnion {
    private int[] parent;
    private int[] rank;

    public DisjointSetUnion(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    int find(int i) {
        if (this.parent[i] == i) {
            return i;
        }
        return this.parent[i] = this.find(this.parent[i]);
    }

    void unite(int x, int y) {
        int root1 = this.find(x);
        int root2 = this.find(y);
        if (root1 != root2) {
            if (this.rank[root1] > this.rank[root2]) {
                int temp = root1;
                root1 = root2;
                root2 = temp;
            }
            parent[root1] = root2;
            if (rank[root1] == rank[root2]) {
                rank[root2]++;
            }
        }
    }
}
