public class MyHashTable<K, V> { //Hash table is created with two parameters(K and V).
    private class HashNode<K, V>{ //K represents the key type. V represents the value type
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M]; //default size M
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M]; //specified size M
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % M; // this method computes hash code for specified key
    }
    public void put(K key, V value){ //this method adds key-value pair to the hash table
        int index = hash(key); //calc index for given key
        HashNode<K, V> node = new HashNode<>(key, value); //create a new HashNode with given key and value
        if (chainArray[index] == null){
            chainArray[index] = node;
        }
        else {
            HashNode<K, V> current = chainArray[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            chainArray[index] = node;
            node.next = current;
        }
        size++;
            }
    public V get(K key){ //get the value stored in hash table associated with provided key
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        while(curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
        }
    public V remove(K key){ //used to remove a pair of key and value from hash table
        int index = hash(key);
        HashNode<K, V > curr = chainArray[index];
        HashNode<K, V > prev = null;

        while (curr != null){
            if(curr.key.equals(key)){
                if(prev == null){
                    chainArray[index] = curr.next;
                }
                else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
    public boolean contains(V value){ // check whether a given value is present in the hash table or not
        for(int i=0; i<M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
            }
    public K getKey(V value){ //this method retrieve key that associated with spec value from hash table
        for (int i=0; i<M; i ++){
            HashNode<K,V> curr = chainArray[i];
            while (curr != null){
                if(curr.value.equals(value)){
                    return curr.key;
                }
                curr = curr.next;
            }
        }
        return null;
        }
    public void printBucketSizes(){ //print size
        int[] bucSize = new int[M];
        for(int i= 0; i<M; i++){
            HashNode<K,V> curr = chainArray[i];
            while(curr != null){
                bucSize[i]++;
                curr = curr.next;
            }
        }
        for (int i=0; i<M; i++){
            System.out.println("Bucket" + i + " : " + bucSize[i]);
        }
    }

    }





