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
public class ReturnCode extends ByteCode{
    
    protected String label;
    protected int address;
    
    public void init(java.util.ArrayList args){
        if(args.isEmpty())
            label = null;
        else
            label = (String)args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
        vm.setProgramCounter(vm.popReturnAddrs());
        vm.popFrame();
        address = vm.peek();
    }
    
    public String toString(){
        if(label == null)
            return "LABEL";
        else 
            return "LABEL" + label;
    }
}
