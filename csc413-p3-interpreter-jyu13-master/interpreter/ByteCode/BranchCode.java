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
public abstract class BranchCode extends ByteCode{
    @Override
    public abstract void init(java.util.ArrayList args);
    @Override
    public abstract void execute(VirtualMachine vm);
    
    public abstract String getArgs();
    
    public abstract int getAddress();
    
    public abstract void setAddress(int index);
    
}
