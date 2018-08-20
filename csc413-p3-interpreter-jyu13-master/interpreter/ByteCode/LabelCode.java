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
public class LabelCode extends ByteCode{
    
    private String label;
    
    public void init(java.util.ArrayList args){
        label = (String)args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
    }
    
    public String getArgs(){
        return label;
    }
    
    public String toString(){
        return "LABEL"+label;
    }
}
