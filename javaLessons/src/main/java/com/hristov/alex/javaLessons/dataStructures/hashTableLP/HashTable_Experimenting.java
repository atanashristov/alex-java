package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

/**
 * HashTable class
 * 
 * Changes:
 * - 3.0: Optimizations
 * - 2.0: Does linear probing to handle collision.
 *        See: 
 *             - https://en.wikipedia.org/wiki/Linear_probing
 *             - https://www.geeksforgeeks.org/implementing-hash-table-open-addressing-linear-probing-cpp/?ref=rp
 *             - https://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html
 * 
 * @author  Alex Hristov
 * @version 2.0
 * @since 2021-01-23
 */
public class HashTable_Experimenting {
	
	// The count of elements added to the hashtable.
	private int _size;

	// An array that holds all the elements.
	private Entry[] _entries;
	
	/**
	 * Constructs an empty HashTable with default size of 101.
	 */
	public HashTable_Experimenting() {
		this(101);
	}
	
	/**
	 * Constructs an empty HashTable with default size of `initCap`.
	 * 
	 * @param capacity The size to initialize with.
	 */
	public HashTable_Experimenting(int capacity) {
		_entries = new Entry[capacity];
		_size = 0;
	}
	
	/**
	 * Adds new element to the hash table.
	 * 
	 * @param key     Key for the new key/value pair.
	 * @param value   The value for the key/value pair.
	 * @return        The previous value associated with the key
	 *                    or null if there was no mapping for key.
	 */
	public Object put(Object key, Object value) {
		
		if (_size >= _entries.length) {
			throw new IllegalStateException();
		}
		
		int hashedKey = hashIndex(key);

		if (occupied(hashedKey)) {
			// The position is occupied.
			// We start looking for unoccupied position from the next element onwards.
			// If we reached end of array, we start looking for unoccupied position
			//   from the beginning of the array.

			// We need a stop index. This is if we start looking for unoccupied position
			//   from the beginning, then we have to stop at the hashedKey position.
			int stopIndex = hashedKey;

			// Implement wrapping around the array.
			// If the array is full, we wrap from the beginning.
			if (hashedKey == _entries.length - 1) {
				hashedKey = 0;
			}
			else {
				hashedKey++;
			}

			while(occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % _entries.length;
			}
		}

		if (occupied(hashedKey)) {
			System.out.println("Sorry, there's already element at position " + hashedKey);
			return null;
		}
		else {
			_entries[hashedKey] = new Entry(key, value);
			return null;
		}
	}
	
	/**
	 * Returns the value to which the specified key is mapped,
	 *      or null if this map contains no mapping for the key.
	 *  
	 * @param key The key to search for.
	 * @return value The value of the data entry or null if it did not find one in the list.
	 */
	public Object get(Object key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}
		else {
			return _entries[hashedKey];
		}
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
		int hashKey = findKey(key);
		if (hashKey == -1) {
			return null;
		}

		// Keep a copy to return.
		Object res = _entries[hashKey];

		// We cannot just set as `null`, because we may end up
		//   when looking for a key we may hit a `null` between the hashKey
		//   and the actual index where the element is stored.
		// Instead, we mark the items as "removed".
		// _hashtable[hashKey].markAsRemoved();

		// Another option would be to utilize rehash the hash table
		//   every time we remove:

		Entry[] oldHashTable = _entries;
		_entries = new Entry[_entries.length];
		for (int i = 0; i<oldHashTable.length; i++) {
			if (oldHashTable[i] != null) {
				put(oldHashTable[i].getKey(), oldHashTable[i].getValue());
			}
		}



		return res;
	}
	
	/**
	 * Returns a formatted multi-line string, ordered by bucket index.
	 * 
	 * @return Formatted multi-line string.
	 */
	public String toString() {
		String res = "";
		
		for (int i = 0; i < _entries.length; i++) {
			if (_entries[i] != null) {
				if (_entries[i].getRemoved()==false) {
					res += String.format("%03d", i) + " : " + _entries[i].toString() + "\n";
				} else {
					res += String.format("%03d", i) + " : dummy\n";
				}
			} else {
				res += String.format("%03d", i) + "\n";
			}
		}
		return res;
	}
	
	/**
	 * Calculate the hash index (bucket index) by the key.
	 * The hash index is a calculated by calling the `hashCode` Java method of the key, the modulus by the table capacity. 
	 * NOTE: We assume the table capacity is always a prime number.
	 * 
	 * @return Hash index.
	 */
	private int hashIndex(Object key) {
		return key.hashCode() % _entries.length;
	}

	/**
	 * Check if the element at index in the array is occupied.
	 * @param index Index to check is occupied.
	 * @return If the element at index is occupied.
	 */
	private boolean occupied(int index) {
		return _entries[index] != null;
	}

	/**
	 * Find at what index is the element with key.
	 * @param key Key to search for.
	 * @return Index where is found.
	 */
	private int findKey(Object key) {
		int hashedKey = hashIndex(key);
		if (_entries[hashedKey] != null
				&& _entries[hashedKey].getKey() .equals(key)) {
			return hashedKey;
		}

		// At this position, there is no element with same key.
		// We start looking next element onwards.
		// If we reached end of array, we start looking for the key
		//   from the beginning of the array.

		// We need a stop index. This is if we start looking for the key
		//   from the beginning, then we have to stop at the hashedKey position.
		int stopIndex = hashedKey;

		// Implement wrapping around the array.
		// If the array is full, we wrap from the beginning.
		if (hashedKey == _entries.length - 1) {
			hashedKey = 0;
		}
		else {
			hashedKey++;
		}

		while(hashedKey != stopIndex
				&& _entries[hashedKey] != null
				&& _entries[hashedKey].getKey().equals(key)) {
			hashedKey = (hashedKey + 1) % _entries.length;
		}

		if (_entries[hashedKey] != null
				&& _entries[hashedKey].getKey().equals(key)) {
			return hashedKey;
		}
		else {
			return -1;
		}
	}

	// --------------------------------------------------------------------------------
	
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
