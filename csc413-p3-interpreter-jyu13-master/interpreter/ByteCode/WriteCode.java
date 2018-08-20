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
public class WriteCode extends ByteCode{
    
    public void init(java.util.ArrayList args){
        
    }
    
    public void execute(VirtualMachine vm){
        System.out.println("Result is: ");
        System.out.println(vm.pop());       
    }
    
    public String toString(){
        return "WRITE";
    }
}
