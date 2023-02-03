class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl < tl || sl == 0 || tl == 0)
            return "";
        //hashmap to store frequencies of t string characters
        HashMap<Character,Integer> tfreq = new HashMap<>();
        for(char c : t.toCharArray()){
            if(tfreq.containsKey(c))
                tfreq.put(c,tfreq.get(c)+1);
            else
                tfreq.put(c,1);
        }
        //two pointers
        int i = 0, j = 0, matched = 0;
        int start = -1,end = -1; //for storing first and last indices of substring
        int minlen = -1;
        HashMap<Character,Integer> resfreq = new HashMap<>();
        while(j < sl){
            char c = s.charAt(j);
            if(resfreq.containsKey(c))
                resfreq.put(c,resfreq.get(c)+1);
            else
                resfreq.put(c,1);
            if(tfreq.containsKey(c) && tfreq.get(c) == resfreq.get(c))
                matched += 1;

            //following loop executes when we get all the characters of t in the substring
            while(i <= j && matched == tfreq.size()){
                if(minlen == -1 || j-i+1 < minlen){
                    start = i;
                    end = j;
                    minlen = j-i+1;
                }

                c = s.charAt(i);
                resfreq.put(c,resfreq.get(c)-1);

                if(tfreq.containsKey(c) && tfreq.get(c) > resfreq.get(c))
                    matched -= 1;
                i++;
            }
            j++;
        }
        //System.out.println(i+" "+j);
        if(minlen == -1)
            return "";
        else
            return s.substring(start, end+1);

    }
}
