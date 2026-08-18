class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    static void backtrack(int[] c, int t, int s,
                          List<Integer> temp,
                          List<List<Integer>> res) {

        if (t == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = s; i < c.length; i++) {

            if (c[i] > t) {
                break;
            }

           
            temp.add(c[i]);

            
            backtrack(c, t - c[i], i, temp, res);

            
            temp.remove(temp.size() - 1);
        }
    }
}