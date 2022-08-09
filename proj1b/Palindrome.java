import javax.security.auth.callback.ChoiceCallback;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> queue=new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i ++)
            queue.addLast(word.charAt(i));
        return queue;
    }

    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> queue = (LinkedListDeque<Character>) wordToDeque(word);
        while (queue.size() > 1) {
            if(queue.removeFirst() != queue.removeLast())
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        LinkedListDeque<Character> queue = (LinkedListDeque<Character>) wordToDeque(word);
        while (queue.size() > 1) {
            if(!cc.equalChars(queue.removeFirst(), queue.removeLast()))
                return false;
        }
        return true;
    }
}
