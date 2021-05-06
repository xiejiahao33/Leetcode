package 设计;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个题目说的是，你要实现一个 LRU 缓存，提供 get 和 put 两个操作，并
 * 且要求两个操作的时间复杂度都是 O(1)。另外为了简单起见，在这个题目中，
 * key 和 value 都是整数值，
 * 并且 value 只为正整数。因此在 get 操作中，当 key 不存在时，返回 -1 即可。
 */
public class LRUCache {


    private class Node{

        int key,val;

        Node prev,next;

        //构造函数
        Node(int key,int val,Node prev,Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    //初始化的head节点
    private Node head = new Node(-1,-1,null,null);
    //存储key指向的函数
    private Map<Integer, Node> map = new HashMap<>();

    //移动到头节点
    private void move2Head(Node cur){
        if(cur==head){
            head = head.prev; //比如最后访问最后一个节点了，则倒数第二个就是最后的
            return;
        }

        //断开当前节点的前后连接
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        //连接head节点
        cur.next = head.next;
        cur.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }

    public LRUCache(int capacity) {
        Node cur = head;
        for (int i = 0; i < capacity-1; i++) {
            cur.next = new Node(-1,-1,cur,null);
            cur = cur.next;
        }
        cur.next = head;
        head.prev= cur;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        move2Head(cur);


        return cur.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            move2Head(cur);
        }else {
            if(head.val != -1) map.remove(head.key);
            head.key = key;
            head.val = value;
            map.put(key,head);
            head = head.prev;
        }
    }
}
