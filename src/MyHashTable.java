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
}
