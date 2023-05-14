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

        }

