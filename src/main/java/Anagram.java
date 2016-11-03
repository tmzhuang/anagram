import java.util.*;

public class Anagram {
  private Map<Character, Integer> letterCounts;

  public Anagram(String baseString) {
    this.letterCounts = countLetters(baseString);
  }

  public List<String> match(List wordList) {
    List<String> result = new ArrayList<String>();
    for(Object o: wordList) {
      String word = (String)o;
      Map<Character, Integer> letterCounts = countLetters(word);
      if(this.letterCounts.equals(letterCounts)) result.add(word);
    }

    return result;
  }

  private static Map<Character, Integer> countLetters(String string) {
    Map<Character, Integer> letterCounts = new HashMap<Character, Integer>();
    char[] letterArray = string.toCharArray();
    for(char letter : letterArray) {
      if(letterCounts.get(letter) == null) {
        letterCounts.put(letter, 0);
      } else {
        letterCounts.put(letter, letterCounts.get(letter) + 1);
      }
    }

    return letterCounts;
  }
}
