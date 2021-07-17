import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import CacheData.CacheData;
import CacheLinkedList.CacheLinkedList;
import CacheMap.CacheMap;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		
		File file = new File("test.txt");
		
		CacheLinkedList linkedList=new CacheLinkedList(3);
		CacheMap cacheMap=new CacheMap(linkedList);
		boolean x=true;
		while(x) {
			System.out.println("1 for put & 2 for get");
			Scanner sc=new Scanner(new FileReader(file));
			String choice=sc.nextLine();

			if(Integer.parseInt(choice)==1) {
				System.out.println("Enter id and name");
				String string2=sc.nextLine();

				String strings[]=string2.split(" ");
				Integer idInteger=Integer.parseInt(strings[0]);
				String nameString=strings[1];

				CacheData cacheData =new CacheData(idInteger, nameString);
				cacheMap.put(idInteger, cacheData);
				System.out.println("Inserted at "+idInteger);
			}else {
				System.out.println("Enter id");
				String string2=sc.nextLine();
				Integer id=Integer.parseInt(string2);

				System.out.println("id "+id+" name "+ cacheMap.get(id).getName());
			}
			System.out.println(linkedList.toString()+cacheMap.toString());
			System.out.println("Wanna continue");
			
		}
	}
}
