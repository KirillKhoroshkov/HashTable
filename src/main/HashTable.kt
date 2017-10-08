package main

class HashTable<K, V>(val sizeOfHashCode: Int){

    inner class Pair<T, U>(val key: T, var value: U?)

    private var size = 0
    get() = size
    private val hashArray = ArrayList<ArrayList<Pair<K, V>>>(sizeOfHashCode)

    fun put(key: K, value: V?): V?{
        val lastValue: V?
        val cell = getCell(key)
        for (element in cell){
            if (element.key == key){
                lastValue = element.value
                element.value = value
                size++
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

    private fun getCell(key: K): ArrayList<Pair<K, V>>{
        val hash = key!!.hashCode() % sizeOfHashCode
        return hashArray[hash]
    }
}