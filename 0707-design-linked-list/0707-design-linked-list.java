class MyLinkedList {
    private static class Node{
        int val;
        Node next, prev;

        public Node(int val){
            this.val = val;
        }

    }

    private Node head = null;
    private Node tail = null;
    int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public int get(int index) {
        if(index >= size) return -1;

        Node ptr = head;
        while(index-- > 0){
            ptr = ptr.next;
        }

        return ptr.val;
    }

    public void addAtHead(int val) {
        Node ptr = new Node(val);
        if(head == null){
            head = tail = ptr;
        }else{
            ptr.next = head;
            head.prev = ptr;
            head = ptr;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node ptr = new Node(val);
        if(head == null){
            head = tail = ptr;
        }else{
            tail.next = ptr;
            ptr.prev = tail;
            tail = ptr;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index > size) return;

        Node prev = head;
        while (index-- > 1){
            prev = prev.next;
        }

        Node ptr = new Node(val);
        
        ptr.prev = prev;
        ptr.next = prev.next;
        
        prev.next = ptr;
        ptr.next.prev = ptr;

        size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size) return;
        
        if(size == 1){
            head = tail = null;
            size = 0;
            return;
        }
        if(index == 0){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            
            size--;
            return;
        }
        if(index == size-1){
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            
            size--;
            return;
        }
        
        Node prev = head;
        while(index-- > 1){
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        prev.next.prev.prev = null;
        prev.next.prev.next = null;
        prev.next.prev = prev;
        
        size--;
        
    }
}