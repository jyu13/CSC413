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
public class LitCode extends ByteCode{
    
    protected String var = "";
    protected int n;
    
    public void init(java.util.ArrayList args){
        n = Integer.parseInt((String)args.get(0));
        if(args.size()>1){
            var = (String)args.get(1);
        }
    }
    
    public void execute(VirtualMachine vm){
        try{
            if(var.equals(""))
                vm.push(n);
            else
                vm.push(0);
        }catch(Exception e){
            System.out.println("Lit load error.");
        }
    }
    
    public String toString(){
        if(var.equals(""))
            return "LIT" + n;
        else
            return "LIT" + n + " " + var;
    }
}
