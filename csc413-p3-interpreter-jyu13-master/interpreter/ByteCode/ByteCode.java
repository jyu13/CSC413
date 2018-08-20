package interpreter.ByteCode;

import interpreter.VirtualMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arnold
 */
public abstract class ByteCode {
    
    public abstract void init(java.util.ArrayList args);
    
    public abstract void execute(VirtualMachine vm);
}
