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
public class BopCode extends ByteCode{
    
    private String operator;
    
    public void init(java.util.ArrayList args){
        operator = (String)args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
        int top_lvl = vm.pop();
        int second_lvl = vm.pop();
        int result = 0;
        if(operator.equals("+")){
            result = second_lvl + top_lvl;
        }
        else if(operator.equals("-")){
            result = second_lvl - top_lvl;
        }
        else if(operator.equals("*")){
            result = second_lvl * top_lvl;
        }
        else if(operator.equals("/")){
            result = second_lvl / top_lvl;
        }
        else if(operator.equals("==")){
            if(second_lvl == top_lvl)
                result = 1;
            else result = 0;
        }
        else if(operator.equals("!=")){
            if(second_lvl == top_lvl)
                result = 0;
            else result = 1;
        }
        else if(operator.equals("<=")){
            if(second_lvl <= top_lvl)
                result = 1;
            else result = 0;
        }
        else if(operator.equals(">=")){
            if(second_lvl >= top_lvl)
                result = 1;
            else result = 0;
        }
        else if(operator.equals("<")){
            if(second_lvl < top_lvl)
                result = 1;
            else result = 0;
        }
        else if(operator.equals(">")){
            if(second_lvl > top_lvl)
                result = 1;
            else result = 0;
        }
        else if(operator.equals("|")){ 
            if(second_lvl == 0 && top_lvl == 0)
                result = 0;
            else result = 1;
        }
        else if(operator.equals("&")){
            if(second_lvl ==1 && top_lvl == 1)
                result = 1;
            else result = 0;
        }
        
        vm.push(result); //put back to the stack
        
    }
    public String toString(){
        return "BOP" + operator;
    }
}
