class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> smap= new HashMap<>();
        HashMap<Character,Integer> tmap= new HashMap<>();
        int formed=0;
        int needed=t.length();
        String ans="";
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int start=0;
        int end=0;
        while(end<s.length()){
            char enter = s.charAt(end);
            if(tmap.containsKey(enter)){
                smap.put(enter,smap.getOrDefault(enter,0)+1);
                if(smap.get(enter)<=tmap.get(enter))
                formed++;
            }
            while(formed==needed){
                int curlen=end-start+1;
                if(curlen<minlen){
                    minlen=curlen;
                    ans=s.substring(start,end+1);
                }
                char del =s.charAt(start);
                if(smap.containsKey(del)){
                if(smap.get(del)<=tmap.get(del)){
                    formed--;

                }
                smap.put(del,smap.getOrDefault(del,0)-1);}
                start++;
            }
        
        end++;
        }
        return ans;
    }
}