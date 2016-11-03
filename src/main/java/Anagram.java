import java.util.*;

public class Anagram {
  private Map<Character, Integer> letterCounts;
  private String baseString;

  public Anagram(String baseString) {
    this.baseString = baseString.toLowerCase();
    this.letterCounts = countLetters(this.baseString);
  }

  public List<String> match(List wordList) {
    List<String> result = new ArrayList<String>();
    for(Object o: wordList) {
      String word = (String)o;
      if(isAnagram(word)) result.add(word);
    }

    return result;
  }

  private boolean isAnagram(String word) {
    word = word.toLowerCase();
    if (this.baseString.equals(word)) return false;
    Map<Character, Integer> letterCounts = countLetters(word);
    return this.letterCounts.equals(letterCounts);
    
  }

  private static Map<Character, Integer> countLetters(String string) {
    Map<Character, Integer> letterCounts = new HashMap<Character, Integer>();
    char[] letterArray = string.toCharArray();
    for(char letter : letterArray) {
      if(letterCounts.get(letter) == null) {
        letterCounts.put(letter, 1);
      } else {
        letterCounts.put(letter, letterCounts.get(letter) + 1);
      }
    }

    return letterCounts;
  }
}
