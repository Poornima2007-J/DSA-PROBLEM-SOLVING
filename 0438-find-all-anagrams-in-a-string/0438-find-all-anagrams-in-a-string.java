class Solution {
    public List<Integer> findAnagrams(String s, String p) {
                      
        List<Integer> ans=new ArrayList<>();

        HashMap<Character,Integer> pmap=new HashMap<>();
        HashMap<Character,Integer> smap=new HashMap<>();

        for(int i=0;i<p.length();i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }

        int l=0;
        for(int r=0;r<s.length();r++){
            smap.put(s.charAt(r),smap.getOrDefault(s.charAt(r),0)+1);

            //if the window length is greater than the pmap length
            if(r-l+1>p.length()){
                char del=s.charAt(l);
                smap.put(del,smap.get(del)-1);
                if(smap.get(del)==0){
                    smap.remove(del);
                    
                }
                l++;
            }
            // if window size==pmap size
            if(r-l+1==p.length()){
                if(smap.equals(pmap)){
                    ans.add(l);
                }
            }
        }

      return ans;
                      
    }
}