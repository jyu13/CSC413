package interpreter;

import interpreter.ByteCode.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String,Integer> table;

    public Program() {
        program = new ArrayList<>();
        table = new HashMap<String,Integer>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    /**This function identify if the bytecode is the LabelCode, then
     * store the line of the labelcode in the hashmap
     * @param bytecode 
     */
    public void addByteCode(ByteCode bytecode){
        if(bytecode instanceof LabelCode){
            LabelCode label = (LabelCode)bytecode;
            table.put(label.getArgs(), (program.size()));
        }
        program.add(bytecode);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        int jumpAddress;
        int size = program.getSize();
        for(int i = 0; i < size; i ++){
            if(program.getCode(i) instanceof BranchCode){
                BranchCode temp = (BranchCode)program.getCode(i);
                jumpAddress = (Integer)table.get(temp.getArgs()); //get the address that matches
                temp.setAddress(jumpAddress);
                
            }
        }
    }




}
