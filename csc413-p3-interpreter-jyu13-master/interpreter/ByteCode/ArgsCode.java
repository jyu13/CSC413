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
public class ArgsCode extends ByteCode{
    
    private int numOfArgs;
    
    public void init(java.util.ArrayList args){
        numOfArgs = Integer.parseInt((String)args.get(0));
    }
    
    public void execute(VirtualMachine vm){
        vm.newFrameAt(numOfArgs); //virtualMachine method to set up a new frame with how many args
    }
    
    public String toString(){
        return "ARGS" + numOfArgs ;
    }
}
