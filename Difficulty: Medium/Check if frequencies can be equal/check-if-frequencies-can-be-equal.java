class Solution {
    boolean sameFreq(String s) {
        // code here
         Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : mp.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        if (freqCount.size() == 1)
            return true;
        if (freqCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = freqCount.entrySet().iterator();
            Map.Entry<Integer, Integer> entry1 = it.next();
            Map.Entry<Integer, Integer> entry2 = it.next();
            int freq1 = entry1.getKey(), count1 = entry1.getValue();
            int freq2 = entry2.getKey(), count2 = entry2.getValue();
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1))
                return true;
            if (Math.abs(freq1 - freq2) == 1) {
                if ((freq1 > freq2 && count1 == 1) || (freq2 > freq1 && count2 == 1))
                    return true;
            }
        }
        return false;
    }
}