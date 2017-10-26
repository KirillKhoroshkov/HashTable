package test

import main.HashTable
import org.testng.annotations.Test

class Tests {

    @Test fun first(){
        val hashTable = HashTable<Int, Int>(4)
        for (element in 0..10){
            hashTable.put(element,element)
        }
        println(hashTable.toString())

        println("get(1,7):")
        println(hashTable.get(1))
        println(hashTable.get(7))

        println("remove(5,3):")
        hashTable.remove(5)
        hashTable.remove(3)
        println(hashTable.toString())
    }
}