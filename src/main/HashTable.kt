package main

import java.lang.StringBuilder

class HashTable<K, V>(private val sizeOfHashCode: Int){

    inner class Pair<T, U>(val key: T, var value: U?){
        override fun toString(): String {
            return key.toString() + ", " + value.toString()
        }
    }

    private var size = 0
    private val hashArray = ArrayList<ArrayList<Pair<K, V>>>(sizeOfHashCode)
    init {
        var i = 0
        while (i < sizeOfHashCode) {
            hashArray.add(ArrayList())
            hashArray.add(ArrayList())
            i++
        }
    }

    fun put(key: K, value: V?): V?{
        val lastValue: V?
        val cell = getCell(key)
        for (element in cell){
            if (element.key == key){
                lastValue = element.value
                element.value = value
                return lastValue
            }
        }
        cell.add(Pair(key, value))
        size++
        return null
    }

    fun get(key: K): V?{
        val cell = getCell(key)
        for (element in cell){
            if (element.key == key){
                return element.value
            }
        }
        return null
    }

    fun remove(key: K): V?{
        val cell = getCell(key)
        for (element in cell){
            if (element.key == key){
                cell.remove(element)
                size--
                return element.value
            }
        }
        return null
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for ((index, element) in hashArray.withIndex()){
            sb.appendln(index.toString() + ":")
            element.forEach{ sb.appendln(it.toString())}
        }
        return sb.toString()
    }

    private fun getCell(key: K?): ArrayList<Pair<K, V>>{
        val hash = key!!.hashCode() % sizeOfHashCode
        return hashArray[hash]
    }
}