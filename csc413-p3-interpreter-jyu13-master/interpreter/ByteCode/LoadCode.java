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
public class LoadCode extends ByteCode{
    
    protected String id="";
    protected int offset;
    
    public void init(java.util.ArrayList args){
        offset = Integer.parseInt((String)args.get(0));
        if(args.size()>1)
            id = (String)args.get(1);
    }
    
    public void execute(VirtualMachine vm){
        vm.load(offset);
    }
    
    public String toString(){
        if(id.equals(""))
            return "LOAD" + offset;
        else
            return "LOAD" + offset + " " + id;
    }
}
