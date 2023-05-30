import javax.management.openmbean.KeyAlreadyExistsException;

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
    private static final double L_Factor =0.75;
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
    public void put(K key, V value) throws IllegalArgumentException, KeyAlreadyExistsException { //this method adds key-value pair to the hash table
        if (key == null || value == null) { // check key and value if they are null or not
            throw new IllegalArgumentException("Can not be null");
        }
        //check if load factor of hash table exceeds a certain threshold, if yes increase the capacity of the hash table
        if (M * 4 <size ){
            increaseBucket();
        }
        if((double) size / M > L_Factor){
            reSize(M * 2);
        }

        int index = hash(key); //calc index for given key
        HashNode<K, V> node = new HashNode<>(key, value); //create a new HashNode with given key and value
        if (chainArray[index] == null){
            chainArray[index] = node;
        }
        else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)){
                current.value = value;
            }
            else {
                current.next = node;
            }
        }
        size++;
            }

    private void increaseBucket() throws KeyAlreadyExistsException{
        //this method increase capacity of hash table by doubling number of buckets, and then rehash all
        //exist entries and redistributing them in new bucket
        int prevM = M;
        M = M * 2;
        size = 0;
        HashNode<K, V>[] prevChainArray = chainArray;
        chainArray = new HashNode[M];
        for (int i=0; i<prevM; i++){
            HashNode<K, V> node = prevChainArray[i];
            while (node != null){
                HashNode<K,V> next = node.next;
                node.next = null;
                put(node.key, node.value);
                node = next;
            }
        }
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
            System.out.println("Bucket" + "\t" + i + "\t" + bucSize[i]);
        }

    }
    private void reSize(int newCapacity){ // defence 4 assignment
        //// Rehash all existing elements and put them into new buckets
        HashNode<K,V>[] newChainArray = new HashNode[newCapacity];
        for (int i=0; i<M; i++){
            HashNode<K,V> node = chainArray[i];
            while(node != null){
                HashNode<K,V> next = node.next;
                int newInd = hash(node.key);
                node.next = newChainArray[newInd];
                newChainArray[newInd]= node;
                node = next;
            }
        }
    }
}





