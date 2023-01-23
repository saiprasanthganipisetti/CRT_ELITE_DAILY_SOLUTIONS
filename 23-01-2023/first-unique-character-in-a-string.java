class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int i = 0; i < s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
    return -1;
}
}
