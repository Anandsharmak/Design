package service;

import java.util.TreeSet;

public class RackManagerService {
    TreeSet<Integer> iDList;

    public RackManagerService(int n) {
        for(int i=1;i<=n;i++){
            iDList.add(i);
        }
        this.iDList = iDList;
    }

    public void AddRackNoTolist(int i){
        iDList.add(i);
    }
    public void RemoveRackNoTolist(int i){
        iDList.remove(i);
    }

    public int getEmptyRackSlot(){
       int ans= iDList.first();
        RemoveRackNoTolist(ans);
        return ans;
    }
}
