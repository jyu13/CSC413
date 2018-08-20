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
public class DumpCode extends ByteCode{
    
    protected String label;
    @Override
    public void init(java.util.ArrayList args){
        label = (String)args.get(0);
    }
    @Override
    public void execute(VirtualMachine vm){
        if(label.equals("ON")){
            vm.setDump(true);
        }
        else if(label.equals("OFF")){
            vm.setDump(false);
        }
    }
    
    public String toString(){
        return "DUMP" + label;
    }
}
