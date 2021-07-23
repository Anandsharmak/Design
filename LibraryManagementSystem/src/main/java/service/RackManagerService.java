package service;

import LibraryException.RackEmpty;
import model.BookCopy;

import java.util.Iterator;
import java.util.TreeSet;

public class RackManagerService {
    static TreeSet<Integer> iDList=new TreeSet<>();

//    public RackManagerService(int n) {
//        for(int i=1;i<=n;i++){
//            iDList.add(i);
//        }
//        this.iDList = iDList;
//    }


    public static void InitRack(int n) {
        for(int i=1;i<=n;i++){
            iDList.add(i);
        }
        System.out.println("Created Library with "+n+" racks");
    }

    public static void AddRackNoTolist(int i){
        iDList.add(i);
    }
    public static void RemoveRackNoTolist(int i){
        iDList.remove(i);
    }

    public static int getEmptyRackSlot() throws Exception {
        if (iDList.size() == 0)
            throw new RackEmpty();

        int ans = iDList.first();
        RemoveRackNoTolist(ans);
        return ans;

    }

    public static void print(){
        System.out.println("Rack Slots");
        Iterator<Integer> iterator = iDList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }
}
