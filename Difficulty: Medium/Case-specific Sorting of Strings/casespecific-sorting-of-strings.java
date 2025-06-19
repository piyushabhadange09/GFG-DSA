class Solution {
    public static String caseSort(String s) {
        // code here
        List <Character> upper=new ArrayList<>();
        List <Character> lower=new ArrayList<>();
        
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                upper.add(c);
            }else{
                lower.add(c);
            }
        }
        Collections.sort(upper);
        Collections.sort(lower);
        
        StringBuilder sb=new StringBuilder();
        int upperIndex=0,lowerIndex=0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(upper.get(upperIndex++));
            } else {
                sb.append(lower.get(lowerIndex++));
            }
        }
        return sb.toString();
    }
}