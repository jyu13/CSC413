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
public class HaltCode extends ByteCode{
    
    
    public void init(java.util.ArrayList args){
        
    }
    
    public void execute(VirtualMachine vm){
        vm.exit();
    }
    
    public String toString(){
        return "HALT";
    }
}
