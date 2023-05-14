# algorithms

This code is a Java implementation of a hash table data structure that allows adding,
retrieving and removing key and value pairs. It uses separate chaining to handle collisions, 
where each index in the hash table stores a linked list of key and value pairs.

The MyHashTable class is the main class that contains the implementation of the hash table. 
It uses a nested class HashNode to represent each node in the linked list.
The MyHashTable class has several methods to manipulate the hash table, which include:

put(K key, V value): Adds a key-value pair to the hash table.
get(K key): Gets the value stored in hash table associated with provided key.
remove(K key): Removes the key-value pair associated with given key from hash table.
contains(V value): Check whether the given value is present in the hash table or not.
getKey(V value): Retrieves the key associated with the given value from the hash table.
printBucketSizes(): Prints the size of each bucket in the hash table.

The MyTestingClass class is a sample testing class that contains a phone number and a full name. 
It implements the hashCode() and equals() methods to allow its instances to be used as keys in the hash table.

The main() method creates a MyHashTable instance and adds 10,000 key-value pairs to it,
where each key is a MyTestingClass instance and each value is a Student instance. It then prints the size of each bucket in the hash table.
