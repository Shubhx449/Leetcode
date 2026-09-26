class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> map = new HashMap<>();

        for(List<String> ele : knowledge){
            map.put(ele.get(0), ele.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while(n > i){
            char ch = s.charAt(i);
            
            if(ch == '(') {
                i++;
                StringBuilder temp = new StringBuilder();
                while(s.charAt(i) != ')'){
                    temp.append(s.charAt(i++));
                }
                
                ans.append(map.getOrDefault(temp.toString(), "?"));
            }else{
                ans.append(ch);
            }
            i++;
        }

        return ans.toString();
    }
}