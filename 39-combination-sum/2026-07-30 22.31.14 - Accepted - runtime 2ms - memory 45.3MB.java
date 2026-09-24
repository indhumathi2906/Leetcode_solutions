class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       solve(candidates, target, 0, new ArrayList<>());
       return ans; 
        
    }
    private void solve(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index==candidates.length){
            return;
        }
        list.add(candidates[index]);
        solve(candidates,target-candidates[index],index,list);
        list.remove(list.size()-1);
        solve(candidates,target,index+1,list);
    }
}