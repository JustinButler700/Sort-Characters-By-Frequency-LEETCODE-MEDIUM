class Solution {
    
    public String frequencySort(String s) 
    {
        //1. We will map all characters in the string
        // Key = Character being mapped
        // Value = frequency of the character
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            if(hm.containsKey(curr))
            {
                hm.put(curr, hm.get(curr)+1);
            }
            else
            {
                hm.put(curr, 1);
            }
        }
    
        return HashMapToString(hm);
    }
    //Helper Method.
    // HashMapToString will build the string based on descending order of frequency
    public String HashMapToString(HashMap<Character, Integer> hm)
    {
        StringBuilder bldr = new StringBuilder();
        while(!hm.isEmpty())
        {
            char max = getMax(hm); // get the next max freq char.
            int count = hm.get(max);
            for(int i = 0; i < count; i++)
            {
                bldr.append(max);
            }
            hm.remove(max); // pop the max frequency char
        }
        return bldr.toString();
        
    }
    //Helper method
    //GetMax will return the max frequency char
    public char getMax(HashMap<Character, Integer> hm)
    {
        char key = '0';
        int max = 0;
        for(Map.Entry<Character,Integer> entry : hm.entrySet())
        {
            if((int)entry.getValue() > max) // linear sort by max freq
            {
                max = (int)entry.getValue();
                key = (char)entry.getKey();
            }
        }
        return key;
    }

}
