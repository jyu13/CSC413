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
public class FalseBranchCode extends BranchCode{
 
    private String label;
    private int address;
    
    public void init(java.util.ArrayList args){
        label = (String)args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
        int temp = vm.pop();
        if(temp == 0){
            vm.setProgramCounter(address); //false then branch to label            
        }
    }
    
    public String getArgs(){
        return label;
    }
    
    public void setAddress(int index){
        address = index;
    }
    
    public int getAddress(){
        return address;
    }
    
    public String toString(){
        return "FALSEBRANCH" + label + " jump to address: " + address;
    }
    
    
}
