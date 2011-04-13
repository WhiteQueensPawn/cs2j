/*
   Copyright 2010,2011 Kevin Glynn (kevin.glynn@twigletsoftware.com)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   Author(s):

   Kevin Glynn (kevin.glynn@twigletsoftware.com)
*/
package CS2JNet.JavaSupport.Collections.Generic;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.NullArgumentException;

import CS2JNet.JavaSupport.CS2JRunTimeException;
import CS2JNet.System.ArgumentException;
import CS2JNet.System.Collections.Generic.ICollectionSupport;
import CS2JNet.System.Collections.Generic.IEnumeratorSupport;

/**
 * A concrete implementation of .Net's ICollection that wraps a Collection
 * 
 * @author keving
 *
 * @param <T>
 */
public class CollectionSupport<T> implements ICollectionSupport<T> {

	private Collection<T> myCollection = null;
	
	public CollectionSupport(Collection<T> inColl) {
		myCollection = inColl;
	}

	public static <S> CollectionSupport<S> mk(Collection<S> inColl) {
		return new CollectionSupport<S>(inColl);
	}

	
	public Iterator<T> iterator() {
		return myCollection.iterator();
	}


	@Override
	public boolean add(T arg0) {
		return myCollection.add(arg0);
	}


	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		return myCollection.addAll(arg0);
	}


	@Override
	public void clear() {
		myCollection.clear();
	}


	@Override
	public boolean contains(Object arg0) {
		return myCollection.contains(arg0);
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		return myCollection.containsAll(arg0);
	}


	@Override
	public boolean isEmpty() {
		return myCollection.isEmpty();
	}


	@Override
	public boolean remove(Object arg0) {
		return myCollection.remove(arg0);
	}


	@Override
	public boolean removeAll(Collection<?> arg0) {
		return myCollection.removeAll(arg0);
	}


	@Override
	public boolean retainAll(Collection<?> arg0) {
		return myCollection.retainAll(arg0);
	}


	@Override
	public int size() {
		return myCollection.size();
	}


	@Override
	public Object[] toArray() {
		return myCollection.toArray();
	}


	@Override
	public <S> S[] toArray(S[] arg0) {
		return myCollection.toArray(arg0);
	}


	@Override
	public boolean Contains(T x) throws Exception {
		return myCollection.contains(x);
	}


	@Override
	public void Add(T x) throws Exception {
		myCollection.add(x);
		
	}


	@Override
	public boolean Remove(T x) throws Exception {
		return myCollection.remove(x);
	}


	@Override
	public void Clear() throws Exception {
		myCollection.clear();
		
	}


	@Override
	public IEnumeratorSupport<T> GetEnumerator() throws Exception {
		return new EnumeratorSupport<T>(myCollection.iterator());
	}


	@Override
	public void CopyTo(T[] arr, int i) throws Exception {
		if (arr == null) {
			throw new NullArgumentException("arr");
		}
		if (i < 0 || i + myCollection.size() > arr.length) {
			throw new ArgumentException("i");
		}
		int idx = 0;
		for (T e : this) {
			arr[i+idx] = e;
		}
		
	}
	
}
