package interpreter;

import java.util.Stack;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;
    private Stack returnAddrs;
    private boolean isRunning;
    private boolean dump;
    private Program program;

    protected VirtualMachine(Program program) {
        this.program = program;

    }
    /**This function get each bytecode from program and execute them according to each
     * execute function. 
     */
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        dump = false;
        while(isRunning){
            ByteCode bytecode = program.getCode(pc);
            bytecode.execute(this);
            if(dump && !(bytecode instanceof DumpCode)){
                System.out.println(bytecode.toString());
                runStack.dump();
            }
            pc++;
        }
    }
    
    public int maxToPop(){
        return runStack.maxToPop();
    }
    /**
     * Set program counter to i
     * @param i 
     */
    public void setProgramCounter(int i){
        pc = i;
    }
    /**
     * 
     * @return program counter
     */
    public int getProgramCounter(){
        return pc;
    }
    
    public int peek(){
        return runStack.peek();
    }
    
    public int pop(){
        return runStack.pop();
    }
    
    public int push(int i){
        return runStack.push(i);
    }
    
    public int store(int offset){
        return runStack.store(offset);
    }
    public int load(int offset){
        return runStack.load(offset);
    }
    
    public void newFrameAt(int n){
        runStack.newFrameAt(n);
    }
    
    public void popFrame(){
        runStack.popFrame();
    }
    
    public void pushReturnAddrs(int n){
        returnAddrs.push(n);
    }
    
    public int popReturnAddrs(){
        return (Integer)returnAddrs.pop();
    }
    
    public void setDump(boolean flag){
        dump = flag;
    }
    
    public void exit(){
        isRunning = false;
    }
}
