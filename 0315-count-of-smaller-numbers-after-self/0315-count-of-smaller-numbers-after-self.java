class Solution {
    
    class Pair {
        int val, index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int c : count) {
            result.add(c);
        }

        return result;
    }

    private void mergeSort(Pair[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {
        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i].val > arr[j].val) {
                rightCount++;
                temp.add(arr[j++]);
            } else {
                count[arr[i].index] += rightCount;
                temp.add(arr[i++]);
            }
        }

        while (i <= mid) {
            count[arr[i].index] += rightCount;
            temp.add(arr[i++]);
        }

        while (j <= right) {
            temp.add(arr[j++]);
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}