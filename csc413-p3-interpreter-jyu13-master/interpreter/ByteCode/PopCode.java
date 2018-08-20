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
public class PopCode extends ByteCode{
    
    protected int numberOfPop;
    
    public void init(java.util.ArrayList args){
        numberOfPop = Integer.parseInt((String)args.get(0));
    }
    
    public void execute(VirtualMachine vm){
        int size = vm.maxToPop()-1;
        if (size >= numberOfPop)
            size = numberOfPop-1;
        
        try{
            
            
            for(int i = 0 ; i < size; i++){
            vm.pop();
            }
        }catch(Exception e){
           System.out.println("pop error.");
        }
    }
    
    public String toString(){
        return "POP" + numberOfPop;
    }
       
}
