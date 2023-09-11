/* https://leetcode.com/problems/minimum-window-substring/description/
   Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
   If there is no such substring, return the empty string "".
*/

class MinimumWindowSubstring.java {
  // Solution using sliding window
  
  
  // When count is 0, compute length of substring. Also increment the char array till count becomes > 0
  public String minWindow(String s, String t) {
    if(s.length()==0 || t.length()==0 || s.length()<t.length()){
      return new String();
    }
    
    int[] map = new int[128];
    int left = 0;
    int right=0;
    int count = t.length();
    int minStart = 0;
    int minLength=Integer.MAX_VALUE;

    // First create a char array to keep track of count of characters in t
    for(int i =0; i<t.length(); i++){
        map[t.charAt(i)]++;
    }
    
    while(right<s.length()){

      // As you traverse s, decrement count, if count of character at right in char array is greater than 1.
      if(map[s.charAt(right)] > 0){
          count--;
      }
      
      map[s.charAt(right)]--;

      while(count==0){
        
        if(right-left+1 < minLength){
          minLength = right-left+1;
          minStart = left;
        }
        
        map[s.charAt(left)]++;
        
        if(map[s.charAt(left)] > 0){
          count++;
        }
        
        left++;
      }
      right++;
    }
    
    if(minLength > s.length()){
      return new String();
    }
    else
    {
      return s.substring(minStart, minStart+minLength);
    }

  }

  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(minWindow(s, t));
    }
}
