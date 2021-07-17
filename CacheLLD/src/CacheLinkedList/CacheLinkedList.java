package CacheLinkedList;
import java.util.LinkedList;

import CacheData.CacheData;
import CacheMap.CacheMap;

public class CacheLinkedList {
	LinkedList<CacheData> ll;
	public int n;
	
	
	public CacheLinkedList(int n) {
		this.n=n;
		ll= new LinkedList<CacheData>();
		
	}
	@Override
	public String toString() {
		String string2="";
		for(int i=0;i<ll.size();i++)
			string2+=ll.get(i).getName()+" ";
		return "CacheLinkedList [ll= " + string2 + ", n=" + n + "]";
	}
	public CacheData get(Integer index) {
		return ll.get(index);
	}

	public void put(CacheData newData) {
			if(ll.size()>n) {
				ll.remove(0);
			}
			ll.add(newData);
	}
	
	public Integer whatSize() {
		return ll.size();
	}
	
	
}
