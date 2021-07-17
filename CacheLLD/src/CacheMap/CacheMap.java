package CacheMap;

import java.util.HashMap;
import java.util.Map;

import CacheData.CacheData;
import CacheLinkedList.CacheLinkedList;
public class CacheMap {
	Map<Integer, CacheData> mp;
	CacheLinkedList ll;
	
	public CacheMap(CacheLinkedList ll){
		mp=new HashMap<Integer, CacheData>();
		this.ll=ll;
	}
	@Override
	public String toString() {
		for (Integer name: mp.keySet()) {
		    String key = name.toString();
		    String value = mp.get(name).getName();
		    System.out.println(key + " " + value);
		}
		return "";
	}
	public CacheData get(int index) {
		return mp.get(index);
	}

	public void put(Integer index,CacheData newData) {
		if(mp.getOrDefault(index, null)==null) {
			mp.put(index, newData);
			if(ll.whatSize()==ll.n) {
				mp.remove(ll.get(0));
			}
		}
		ll.put(newData);
	}
	
	public CacheData get(Integer index) {
		return mp.get(index);
	}
}
