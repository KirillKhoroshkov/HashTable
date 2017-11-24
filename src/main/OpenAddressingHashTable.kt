package main

class OpenAddressingHashTable<K, V>(private val sizeOfHashCode: Int) {

    private val hashArray = Array<Cell<K, V>?>(sizeOfHashCode, {null})

    private class Cell<P, U>(val key: P, val value: U){
        var isDeleted = false

        override fun toString(): String {
            return key.toString() + "=" + value.toString() +
                    if (isDeleted) {
                        " (deleted)"
                    } else {""}
        }
    }

    fun put(key: K, value: V): V? {
        var index = Math.abs(key!!.hashCode()) % sizeOfHashCode
        var oldValue: V? = null
        while (index < sizeOfHashCode && hashArray[index] != null && !hashArray[index]!!.isDeleted) {
            if (hashArray[index]!!.key == key) {
                oldValue = hashArray[index]!!.value
                hashArray[index] = Cell(key, value)
                return oldValue
            }
            index++////////////////////////////////////////////////////////////////////////////////////////////
        }
        if (index >= sizeOfHashCode) {
            throw IndexOutOfBoundsException()
        } else {
            hashArray[index] = Cell(key, value)
            index++
            while (index < sizeOfHashCode && hashArray[index] != null) {
                if (hashArray[index]!!.key == key) {
                    oldValue = hashArray[index]!!.value
                    hashArray[index]!!.isDeleted = true
                }
                index++
            }
        }
        return oldValue
    }

    fun get(key: K): V?{
        var index = Math.abs(key!!.hashCode()) % sizeOfHashCode
        var value: V? = null
        while(index < sizeOfHashCode && hashArray[index] != null){
            if (hashArray[index]!!.key == key && !hashArray[index]!!.isDeleted){
                value = hashArray[index]!!.value
                break
            }
            index++
        }
        return value
    }

    fun remove(key: K): V?{
        var index = Math.abs(key!!.hashCode()) % sizeOfHashCode
        var value: V? = null
        while(index < sizeOfHashCode && hashArray[index] != null){
            if (hashArray[index]!!.key == key && !hashArray[index]!!.isDeleted){
                value = hashArray[index]!!.value
                hashArray[index]!!.isDeleted = true
            }
            index++
        }
        return value
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for ((index, element) in hashArray.withIndex()){
            sb.append(index.toString() +
                    ": " +
                    if (element != null) {
                        "[" +
                                element.key!!.hashCode() % sizeOfHashCode +
                                "] " +
                                element.toString() + "\n"
                    } else {
                        element.toString() + "\n"
                    }
            )
        }
        return sb.toString()
    }
}