/**
 * HashTable class
 *
 * Changes:
 * - 3.0: Wrap around the array when end of array reached
 * - 2.0: Does linear probing to handle collision.
 *        See:
 *             - https://en.wikipedia.org/wiki/Linear_probing
 *             - https://www.geeksforgeeks.org/implementing-hash-table-open-addressing-linear-probing-cpp/?ref=rp
 *             - https://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html
 *
 * @author  Alex Hristov
 * @version 3.0
 * @since 2021-01-23
 */

package com.hristov.alex.javaLessons.dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Hashtable implementation using array and linear probing:
 *   - Open addressing: all elements are stored inside same array.
 *   - Buckets: a hash function calculates element index by key.
 *   - Linear probing: Collusion is resolved via linear probing.
 */
public class HashTable {

    // Instance variables
    // ------------------------------------------------------------------

    /**
     * Count of elements currently in the hashtable.
     * Initial value is 0 (zero). Increments on puts. Decrements on removes.
     * Note: It excludes marked as removed, only counts current elements.
     */
    private int _size;

    /**
     * An array to store all the elements into.
     * Note: some entries will be occupied, some will be empty (null),
     *   some will contain elements marked as removed.
     */
    private Entry[] _entries;


    // Constructors
    // ------------------------------------------------------------------

    /**
     * Constructs an empty HashTable with default size of 101.
     */
    public HashTable() {
        this(101);
    }

    /**
     * Constructs an empty HashTable with default size of `initCap`.
     *
     * @param capacity The size to initialize with.
     *                 The capacity should be a prime number.
     */
    public HashTable(int capacity) {
        _entries = new Entry[capacity];
        _size = 0;
    }

    // Stats
    // ------------------------------------------------------------------

    /**
     * Count probe on put.
     */
    private long _statsProbesPut;

    /**
     * Count probe on get.
     */
    private long _statsProbesGet;

    public long get_statsProbesPut() {
        return _statsProbesPut;
    }

    public long get_statsProbesGet() {
        return _statsProbesGet;
    }

    public void resetStats() {
        _statsProbesPut = 0;
        _statsProbesGet = 0;
    }

    // Public methods
    // ------------------------------------------------------------------

    /**
     * Adds new element to the hash table.
     *
     * @param key     Key for the new key/value pair.
     * @param value   The value for the key/value pair.
     * @return        The previous value associated with the key
     *                    or null if there was no mapping for key.
     * @throws IllegalStateException The hash table array is full.
     */
    public Object put(Object key, Object value) {
        if (_size >= _entries.length) {
            throw new IllegalStateException();
        }

        Entry newEntry = new Entry(key, value);
        Entry oldEntry = null;
        int hashedKey = hashIndex(key);

        // We need a stop index. This is if we start looking for unoccupied position
        //   from the beginning of the array, then we have to stop at the hashedKey position.
        int stopIndex = hashedKey;

        // If we placed the new entry somewhere,
        //   we still need to mark remaining entries of same key as re,oved.
        Boolean placed = false;

        do {
            if (placed == false) {
                if (_entries[hashedKey] == null) {
                    _entries[hashedKey] = newEntry;
                    _size++;
                    break;
                }
                else if (_entries[hashedKey].getKey().equals(key)
                        && _entries[hashedKey].getRemoved() == false) {
                    oldEntry = _entries[hashedKey];
                    _entries[hashedKey] = newEntry;
                    placed = true;
                } else if (_entries[hashedKey].getKey().equals(key)
                        || _entries[hashedKey].getRemoved()) {
                    _entries[hashedKey] = newEntry;
                    placed = true;
                }

            } else {
                if (_entries[hashedKey] == null) {
                    break;
                }
                if (_entries[hashedKey].getKey().equals(key)) {
                    _entries[hashedKey].markAsRemoved();
                }
            }

            // Move to next element or reset to beginning or array.
            hashedKey = (hashedKey + 1) % _entries.length;

            if (placed == false
                    && hashedKey != stopIndex) {
                _statsProbesPut++;
            }
        } while (hashedKey != stopIndex);

        Object res = oldEntry != null ? oldEntry.getValue() : null;
        return res;
    }

    /**
     * Returns the value to which the specified key is mapped,
     *      or null if this map contains no mapping for the key.
     *
     * @param key The key to search for.
     * @return value The value of the data entry or null if it did not find one in the list.
     */
    public Object get(Object key) {

        int hashedKey = hashIndex(key);
        int stopIndex = hashedKey;

        do {
            if (_entries[hashedKey] == null) {
                return null;
            }

            if ( _entries[hashedKey].getRemoved() == false
                    && _entries[hashedKey].getKey().equals((key))) {
                Object res = _entries[hashedKey].getValue();
                return res;
            }

            hashedKey = (hashedKey + 1) % _entries.length;
            if (hashedKey != stopIndex) {
                _statsProbesGet++;
            }
        } while (hashedKey != stopIndex);

        return null;
    }

    /**
     * Removes object by key.
     *
     * NOTE: If it finds object with the same key,
     *             it marks as removed rather than physically delete the entry.
     *
     * @param key The key of the object to search for.
     * @return The value of the object
     *             or null or object with this key does not exist.
     */
    public Object remove(Object key) {

        int hashedKey = hashIndex(key);
        int stopIndex = hashedKey;

        do {
            if (_entries[hashedKey] == null) {
                return null;
            }

            if ( _entries[hashedKey].getRemoved() == false
                    && _entries[hashedKey].getKey().equals((key))) {
                _size--;
                _entries[hashedKey].markAsRemoved();
                Object res = _entries[hashedKey].getValue();
                return res;
            }

            hashedKey = (hashedKey + 1) % _entries.length;
        } while (hashedKey != stopIndex);

        return null;
    }


    /**
     * Returns a formatted multi-line string, ordered by bucket index.
     *
     * @return Formatted multi-line string.
     */
    public String toString() {
        String res = "";
        List<String> list = this.toListOfString();

        for(int i=0; i<list.stream().count(); i++) {
            res += list.get(i) + "\n";
        }

        return res;
    }

    /**
     * Returns a formatted multi-line string, ordered by bucket index.
     *
     * @return Formatted multi-line string.
     */
    public List<String> toListOfString() {
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < _entries.length; i++) {
            if (_entries[i] != null) {
                if (_entries[i].getRemoved()==false) {
                    res.add(String.format("%03d", i) + " : " + _entries[i].toString());
                } else {
                    res.add(String.format("%03d", i) + " : dummy");
                }
            } else {
                res.add(String.format("%03d", i));
            }
        }

        return res;
    }


    // Private methods
    // ------------------------------------------------------------------

    /**
     * Calculate the hash index (bucket index) by the key.
     * The hash index is a calculated by calling the `hashCode` Java method of the key,
     *   the modulus by the table capacity.
     * NOTE: We assume the table capacity is always a prime number.
     *
     * @return Hash index.
     */
    private int hashIndex(Object key) {
        int res = Math.abs(key.hashCode()) % _entries.length;
        return res;
    }

    // Inner classes
    // ------------------------------------------------------------------

    /**
     * Holds the data for the HashTable, as a key/value pair.
     *
     * @author Alex Hristov
     */
    private class Entry
    {
        // Holds the key
        private Object _key;

        // Holds the value
        private Object _value;

        // Holds removed flag
        private Boolean _removed;

        /**
         * Constructs an empty Entry object, where both key and value are null.
         */
        public Entry() {
            this(null, null);
        }

        /**
         * Constructs an Entry object with the specified key and value.
         *
         * @param key The key to the entry.
         * @param value The value of the entry.
         */
        public Entry(Object key, Object value) {
            _key = key;
            _value = value;
            _removed = false;
        }

        /**
         * Returns the key of the entry.
         *
         * @return The key.
         */
        public Object getKey() {
            return _key;
        }

        /**
         * Returns the value of the object.
         *
         * @return the value.
         */
        public Object getValue() {
            return _value;
        }

        public Boolean getRemoved() {
            return _removed;
        }

        public void markAsRemoved() {
            _removed = true;
        }

        public String toString() {
            return _key + " " + _value;
        }
    }
}
