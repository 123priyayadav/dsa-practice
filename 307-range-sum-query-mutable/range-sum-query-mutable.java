class NumArray {
    int[] tree;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }
    private void build(int i, int l, int r) {
        if (l == r) {
            tree[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * i + 1, l, mid);
        build(2 * i + 2, mid + 1, r);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }
    private void update(int i, int l, int r, int idx, int val) {
        if (l == r) {
            nums[idx] = val;
            tree[i] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * i + 1, l, mid, idx, val);
        } else {
            update(2 * i + 2, mid + 1, r, idx, val);
        }
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
    private int query(int i, int l, int r, int qs, int qe) {
        if (qs <= l && r <= qe) {
            return tree[i];
        }
        if (r < qs || l > qe) {
            return 0;
        }
        int mid = (l + r) / 2;
        int leftSum = query(2 * i + 1, l, mid, qs, qe);
        int rightSum = query(2 * i + 2, mid + 1, r, qs, qe);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */