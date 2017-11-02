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

    @Test fun second(){
        val hashTable = HashTable<Int, Int>(4)
        for (element in 1..2){
            hashTable.put(element,element*11)
        }
        println(hashTable.toString())
        var removed = hashTable.remove(3)
        println("removed: " + removed)
        println(hashTable.toString())
        removed = hashTable.remove(2)
        println("removed: " + removed)
        println(hashTable.toString())
    }

}