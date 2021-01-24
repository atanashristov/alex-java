package com.hristov.alex.javaLessons.dataStructures;

/**
 * HashTable class
 * @author  Alex Hristov
 * @version 1.0
 * @since 2021-01-23
 */
public class HashTable_V1 {
	
	// Holds the capacity
	private int _cap;
	private Entry[] _entries;
	
	/**
	 * Constructs an empty HashTable with default size of 101.
	 */
	public HashTable_V1() {
		this(101);
	}
	
	/**
	 * Constructs an empty HashTable with default size of `initCap`.
	 * @param initCap The size to initialize with. 
	 */
	public HashTable_V1(int initCap) {
		_cap = initCap;
		_entries = new Entry[initCap];
	}
	
	/**
	 * Adds new element to the hash table.
	 * @param key     Key for the new key/value pair.
	 * @param value   The value for the key/value pair.
	 * @return        The previous value associated with the key
	 *                    or null if there was no mapping for key.
	 */
	public Object put(Object key, Object value) {
		// Calculate a hash index
		// The hash index will point to where in the array list to store the entry,
		//     it is an index of the array.
		int idx = hashIndex(key);

		// Get a copy of existing entry, so that we can return the old value.
		// NOTE: It can be a null if this bucket is still empty.
		Entry existingEntry = _entries[idx];
		
		// Create new entry and store at the bucket index.
		Entry newEntry = new Entry(key, value);
		_entries[idx] = newEntry;
		
		// Return the value of the existing old entry. 
		return existingEntry != null 
				? existingEntry.getValue()
				: null;
	}
	
	/**
	 * Returns the value to which the specified key is mapped,
	 *      or null if this map contains no mapping for the key.
	 *  
	 * @param key The key to search for.
	 * @return value The value of the data entry or null if it did not find one in the list.
	 */
	public Object get(Object key) {
		// Calculate a hash index
		// The hash index will point to where in the array list to store the entry,
		//     it is an index of the array.
		int idx = hashIndex(key);
		
		// Get a copy of existing entry, so that we can return the old value.
		// NOTE: It can be a null if this bucket is still empty.
		Entry existingEntry = _entries[idx];

		// Return the value of the existing old entry. 
		return existingEntry != null 
				? existingEntry.getValue()
				: null;
	}
	
	/**
	 * Returns a formatted multi-line string, ordered by bucket index.
	 * 
	 * @return Formatted multi-line string.
	 */
	public String toString() {
		String res = "";
		
		for (int i=0; i<_cap; i++) {
			Entry entry = _entries[i];
			if (entry != null)
			{
				res += String.format("%03d", i) + " : " + entry.toString() + "\n";
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
	 * @author Alex Hristov
	 */
	private class Entry
	{
		// Holds the key
		private Object _key;
		
		// Holds the value
		private Object _value;

		/**
		 * Constructs an empty Entry object, where both key and value are null.  
		 */
		public Entry() {
			this(null, null);
		}
		
		/**
		 * Constructs an Entry object with the specified key and value.
		 * @param key The key to the entry.
		 * @param value The value of the entry.
		 */
		public Entry(Object key, Object value) {
			_key = key;
			_value = value;
		}

		/**
		 * Returns the key of the entry.
		 * @return The key.
		 */
		public Object getKey() {
			return _key;
		}
		
		/**
		 * Returns the value of the object.
		 * @return the value.
		 */
		public Object getValue() {
			return _value;
		}

		public String toString() {
			return _key + " " + _value;
		}
	}
}
