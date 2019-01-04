public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> chardeque = new ArrayDeque<Character>();
        for (Character c : word.toCharArray()) {
            chardeque.addLast(c);
        }
    return chardeque;
    }
    private boolean Palindromeindicator = true;
    private boolean Palindromeindicatorby1 = true;

    private boolean comparison(Deque deque) {
        if (deque.removeFirst() != deque.removeLast()) {Palindromeindicator = false;}
        if (deque.size() > 1 && Palindromeindicator == true) {return comparison(deque);}
        else return Palindromeindicator;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> chardeque = wordToDeque(word);
        if (chardeque.size() <= 1) {return true;}
        else return comparison(chardeque);
    }

    private boolean comparisonby1(Deque deque, CharacterComparator cc) {
        if (!cc.equalChars((Character) deque.removeFirst(), (Character) deque.removeLast())) {Palindromeindicatorby1 = false;}
        if (deque.size() > 1 && Palindromeindicatorby1 == true) {return comparisonby1(deque, cc);}
        else return Palindromeindicatorby1;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> chardeque = wordToDeque(word);
        if (chardeque.size() <= 1) {return true;}
        else return comparisonby1(chardeque, cc);
    }
}
