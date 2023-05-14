import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> hashTable = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            int phnumber = random.nextInt(10000);
            String fullname = "name" + i;
            MyTestingClass key = new MyTestingClass(phnumber,fullname);
            Student value = new Student();
            hashTable.put(key,value);
        }
        hashTable.printBucketSizes();
    }
    private static class Student {
    }
}