package com.hristov.alex.javaLessons.dataStructures;

/**
 * HashTable class
 * 
 * Changes:
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
public class HashTable {
	
	// Holds the capacity
	private int _size;
	private int _cap;
	private Entry[] _entries;
	
	/**
	 * Constructs an empty HashTable with default size of 101.
	 */
	public HashTable() {
		this(101);
	}
	
	/**
	 * Constructs an empty HashTable with default size of `initCap`.
	 * 
	 * @param initCap The size to initialize with. 
	 */
	public HashTable(int initCap) {
		_cap = initCap;
		_entries = new Entry[initCap];
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
		
		if (_size >= _cap) {
			throw new IllegalStateException();
		}
		
		Entry newEntry = new Entry(key, value);
		Boolean placed = false;
		
		for (int i = hashIndex(key); i < _cap; i++ ) {
			if (_entries[i] == null) {
				if (placed == false) {
					_entries[i] = newEntry;
					_size++;
				}
				return null;
			}

			if (placed == false) {
				if (_entries[i].getRemoved() 
						|| _entries[i].getKey().equals(key)) {
					_entries[i] = newEntry;
					placed = true;
				}
			} else {
				if (_entries[i].getKey().equals(key)) {
					_entries[i].markAsRemoved();
				}
				
			}
			
		}
		
		return null;
	}
	
	/**
	 * Returns the value to which the specified key is mapped,
	 *      or null if this map contains no mapping for the key.
	 *  
	 * @param key The key to search for.
	 * @return value The value of the data entry or null if it did not find one in the list.
	 */
	public Object get(Object key) {
		
		for (int i = hashIndex(key); i < _cap; i++ ) {
			if (_entries[i] != null 
					&& _entries[i].getRemoved() == false
					&& _entries[i].getKey().equals(key)) {
				return _entries[i].getValue();
			}
		}
		
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

		for (int i = hashIndex(key); i < _cap; i++ ) {
			if (_entries[i] != null 
					&& _entries[i].getRemoved() == false
					&& _entries[i].getKey().equals(key)) {
				_entries[i].markAsRemoved();
				_size--;
				return _entries[i].getValue();
			}
		}

		return null;
	} 
	
	/**
	 * Returns a formatted multi-line string, ordered by bucket index.
	 * 
	 * @return Formatted multi-line string.
	 */
	public String toString() {
		String res = "";
		
		for (int i=0; i<_cap; i++) {
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
		return key.hashCode() % _cap;
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
