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
public class CallCode extends BranchCode{
    
    private int address;
    private String label;
    
    public void init(java.util.ArrayList args){
        label = (String)args.get(0);
    }
    
    public void execute(VirtualMachine vm){ 
 
        vm.pushReturnAddrs(vm.getProgramCounter());
        vm.setProgramCounter(address);
    }
    
    public String getArgs(){
        return label;
    }
    
    public int getAddress(){
        return address;
    }
    
    public void setAddress(int index){
        address = index;
    }
    
    public String toString(){
        return "CALL" + label + " jump to address" + address;
    }
}
