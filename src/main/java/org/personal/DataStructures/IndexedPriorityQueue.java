package org.personal.DataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class IndexedPriorityQueue <K, V extends Comparable<V>> {
//    private BidiMap<K,Integer> map;
    private HashMap<K,Integer> map; // TODO: Replace with BidiMap
    private V[] values;
    private int[] pm;  // ki -> heapIndex
    private int[] im;  // heapIndex -> ki
    private int length = 0;
    private int maxLimit = 1000;
    private int minFlag = 1;

    public IndexedPriorityQueue() {
        values = (V[]) new Comparable[maxLimit];
//        map = new DualHashBidiMap<>();
        map = new HashMap<>(); // TODO: Replace with BidiMap
        pm = new int[maxLimit];
        im = new int[maxLimit];
        Arrays.fill(pm, -1);
        Arrays.fill(im, -1);
    }
    public IndexedPriorityQueue(int n, Integer minFlag) {
        values = (V[]) new Comparable[n];
//        map = new DualHashBidiMap<>(); // TODO: Replace with BidiMap
        map = new HashMap<>();
        pm = new int[n];
        im = new int[n];
        this.maxLimit = n;
        this.minFlag = minFlag;
        Arrays.fill(pm, -1);
        Arrays.fill(im, -1);
    }

    private void swap(int childIndex, int parentIndex){
        pm[im[childIndex]] = parentIndex;
        pm[im[parentIndex]] = childIndex;
        int temp = im[childIndex];
        im[childIndex] = im[parentIndex];
        im[parentIndex] = temp;
    }

    /**
     * Compares the values at the specified child and parent indices.
     *
     * @param  childIndex   the index of the child
     * @param  parentIndex  the index of the parent
     * @return              MIN_HEAP (minFlag == 1) : true if child's value < parent's value else false
     *                      MAX_HEAP (minFlag == -1) : true if child's value > parent's value else false
     */
    private boolean compare(int childIndex, int parentIndex) {
        return minFlag*(values[im[childIndex]].compareTo(values[im[parentIndex]])) < 0;
    }

    private void increaseLength() {
        values = Arrays.copyOf(values, maxLimit*2);
        pm = Arrays.copyOf(pm, maxLimit*2);
        Arrays.fill(pm, maxLimit, pm.length, -1);
        im = Arrays.copyOf(im, maxLimit*2);
        Arrays.fill(im, maxLimit, im.length, -1);
        maxLimit *= 2;
    }
    public void insert(K key, V value) {
        int ki = length;
        map.put(key, ki);
        values[ki] = value;
        im[ki] = ki;
        pm[ki] = ki;
        swim(length);
        length++;
        if(length == maxLimit)
            increaseLength();
    }

    public boolean remove(K key) {
        if(!map.containsKey(key))
            return false;
        int ki = map.get(key);
        int hi = pm[ki];
        swap(length-1,hi);
        length--;
        swim(hi);
        sink(hi);
        return true;
    }

    public boolean update(K key, V value) {
        if(!map.containsKey(key))
            return false;
        int ki = map.get(key);
        values[ki] = value;
        int hi = pm[ki];
        swim(hi);
        sink(hi);
        return true;
    }

    public Map.Entry<K, V> peek() {
        if(isEmpty())
            return null;
        int ki = im[0];
//        return new HashMap.SimpleEntry<>(map.getKey(ki), values[ki]);
        return new HashMap.SimpleEntry<>((K) map.keySet().toArray()[ki], values[ki]); // TODO: Replace with BidiMap
    }

    public Map.Entry<K, V> poll() {
        if(isEmpty())
            return null;
        int ki = im[0];
//        if(!remove(map.getKey(ki)))
        if(!remove((K) map.keySet().toArray()[ki])) // TODO: Replace with BidiMap
            return null;
//        return new HashMap.SimpleEntry<>(map.getKey(ki), values[ki]);
        return new HashMap.SimpleEntry<>((K) map.keySet().toArray()[ki], values[ki]); // TODO: Replace with BidiMap
    }


    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }
    
    
    private void swim(int hi) {
        int parentIndex = (hi-1)/2;
        while(hi > 0 && compare(hi, parentIndex)){
            swap(hi, parentIndex);
            hi = parentIndex;
            parentIndex = (hi-1)/2;
        }
    }

    private void sink(int hi) {
        int leftChildIndex = 2*hi+1;
        int rightChildIndex = 2*hi+2;

        while (leftChildIndex < length) {
            int chosenChildIndex = (rightChildIndex >= length || compare(leftChildIndex, rightChildIndex)) ? leftChildIndex : rightChildIndex;

            if (!compare(chosenChildIndex, hi))
                break;

            swap(chosenChildIndex, hi);
            hi = chosenChildIndex;
            leftChildIndex = 2*hi+1;
            rightChildIndex = 2*hi+2;
        }
    }

    public static void main(String[] args) {
        IndexedPriorityQueue<String, Integer> ipq = new IndexedPriorityQueue<>(1, -1);
        ipq.insert("A", 5);
        ipq.insert("B", 4);
        ipq.insert("C", 3);
        ipq.insert("D", 2);
        ipq.insert("E", 1);
        ipq.insert("F", 6);
        ipq.update("A", 1100);
        ipq.remove("B");
        while(!ipq.isEmpty())
            System.out.println(ipq.poll());
        System.out.println(ipq.size());
        System.out.println(ipq.isEmpty());
    }
    
}
