public class LC3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int n = s.length();
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        boolean alpha[] = new boolean[128];
        while (r < n) {
            if (alpha[s.charAt(r)] == false) {
                alpha[s.charAt(r)] = true;
                max = Math.max(max, r-l+1);
                r++;
            } else {
                alpha[s.charAt(l)] = false;
                l++;
            }
        }
        System.out.println(max);
    }
}
