package test

import main.OpenAddressingHashTable
import main.SeparateChainingHashTable
import org.testng.annotations.Test

class Tests {

    @Test fun SeparateChaining1(){
        val hashTable = SeparateChainingHashTable<Int, Int>(4)
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

    @Test fun SeparateChaining2(){
        val hashTable = SeparateChainingHashTable<Int, Int>(4)
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

    @Test fun OpenAddressing1(){
        val hashTable = OpenAddressingHashTable<Char, Char>(8)
        hashTable.put('a', 'b')
        println(hashTable.put('a', 'c'))
        println(hashTable.get('a'))
        hashTable.remove('a')
        hashTable.put('b', 'b')
        hashTable.put('g', 't')
        hashTable.put('j', 't')
        println(hashTable.remove('g'))
        hashTable.put('n', 'k')
        println(hashTable)
    }

    @Test fun OpenAddressing2(){
        val hashTable = OpenAddressingHashTable<Int, String>(2)
        hashTable.put(1, "111")
        hashTable.put(2, "222")
        /*hashTable.put(3, "333")
        println(hashTable.put('a', 'c'))
        println(hashTable.get('a'))
        hashTable.remove('a')
        hashTable.put('g', 't')
        hashTable.put('j', 't')
        println(hashTable.remove('g'))
        hashTable.put('n', 'k')*/
        println(hashTable)
        hashTable.put(1, "555")
        println(hashTable)
        hashTable.remove(1)
        println(hashTable)
        hashTable.put(4, "444")
        println(hashTable)
    }
}