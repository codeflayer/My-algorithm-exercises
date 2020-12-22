package skipList;

public class SkipListNode<T> {
    public SkipListNode<T>[] next;
    public T key;
    public int val;

    public SkipListNode(T key, int i) {
        this.key = key;
        this.val = i;
    }
}
