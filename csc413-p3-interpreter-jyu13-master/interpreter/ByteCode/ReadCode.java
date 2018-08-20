/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author Arnold
 */
public class ReadCode extends ByteCode{
    
    private String input;
    
    public void init(java.util.ArrayList args){
        
    }
    
    public void execute(VirtualMachine vm){
        //user input
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter an Integer.");
            input = in.readLine();
            int n = Integer.parseInt(input);
            vm.push(n);
        }catch(Exception e){
            System.out.println("Integer enter error.");
        }
    }
    
    public String toString(){
        return "READ" + input;
    }
}
