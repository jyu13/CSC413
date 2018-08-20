/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;

/**
 *
 * @author Arnold
 */
public class StoreCode extends ByteCode{
    
    private int n, storeVal;
    private String id;
    
    public void init(java.util.ArrayList args){
        n = Integer.parseInt((String)args.get(0));
        id = (String)args.get(1);
    }
    
    public void execute(VirtualMachine vm){
        storeVal = vm.peek();
        vm.store(n);
    }
    
    public String toString(){
        return "STORE" + n + " " + id + " " + id + " = " + storeVal;
    }
}
