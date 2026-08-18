class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        gen(0, 0, "", n, res);

        return res;        
    }

    private void gen(int openP, int closeP, String s, int n, List<String> res) {
        if (openP == closeP && openP + closeP == n * 2) {
            res.add(s);
            return;
        }

        if (openP < n) {
            gen(openP + 1, closeP, s + "(", n, res);
        }

        if (closeP < openP) {
            gen(openP, closeP + 1, s + ")", n, res);
        }
    }    
}