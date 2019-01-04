public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> chardeque = new ArrayDeque<Character>();
        for (Character c : word.toCharArray()) {
            chardeque.addLast(c);
        }
    return chardeque;
    }

    private boolean comparison(Deque deque) {
        if (deque.removeFirst() != deque.removeLast()) {return false;}
        if (deque.size() > 1) {return comparison(deque);}
        else return true;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> chardeque = wordToDeque(word);
        if (chardeque.size() <= 1) {return true;}
        else return comparison(chardeque);
    }

    private boolean comparisonby1(Deque deque, CharacterComparator cc) {
        if (!cc.equalChars((Character) deque.removeFirst(), (Character) deque.removeLast())) {return false;}
        if (deque.size() > 1) {return comparisonby1(deque, cc);}
        else return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> chardeque = wordToDeque(word);
        if (chardeque.size() <= 1) {return true;}
        else return comparisonby1(chardeque, cc);
    }
}
