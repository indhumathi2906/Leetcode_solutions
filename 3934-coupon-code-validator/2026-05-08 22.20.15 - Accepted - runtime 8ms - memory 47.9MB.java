class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> list = new ArrayList<>();

        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        for (int i = 0; i < code.length; i++) {

            // active check
            if (!isActive[i]) continue;

            // business line check
            if (!order.containsKey(businessLine[i])) continue;

            // code check
            if (code[i].length() == 0) continue;

            boolean valid = true;

            for (char c : code[i].toCharArray()) {

                if (!(Character.isLetterOrDigit(c) || c == '_')) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                list.add(new String[]{businessLine[i], code[i]});
            }
        }

        // sorting
        Collections.sort(list, (a, b) -> {

            int x = order.get(a[0]);
            int y = order.get(b[0]);

            if (x != y) return x - y;

            return a[1].compareTo(b[1]);
        });

        List<String> ans = new ArrayList<>();

        for (String[] x : list) {
            ans.add(x[1]);
        }

        return ans;
        
    }
}