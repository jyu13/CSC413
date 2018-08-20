
package interpreter;

import interpreter.ByteCode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new Program();

    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given bytecode from CodeTable
     *      create an instance of the bytecode class name returned from code table.
     *      Parse any additional arguments for the given bytecode and send them to
     *      the newly created bytecode instance via the init function.
     */
    public Program loadCodes() {
        
        String hashKey,hashValue;
        String nextLine;
        ByteCode bytecode;
        ArrayList<String> tokenList = new ArrayList<String>();
        
        
        try{
            nextLine = byteSource.readLine();
            
            while(nextLine != null ){
            
                StringTokenizer tokenzier = new StringTokenizer(nextLine);
                
                hashKey = tokenzier.nextToken();
                hashValue = CodeTable.getClassName(hashKey);
            
                bytecode = (ByteCode)(Class.forName("interpreter.ByteCode." + hashValue).newInstance());
                
                while(tokenzier.hasMoreTokens()){
                    tokenList.add(tokenzier.nextToken());
                }
                //initialize the bytecode instance with arguments.
                bytecode.init(tokenList);
                //add the bytecode to the program arraylist 
                program.addByteCode(bytecode);

                //clear the tokens list for this turn
                tokenList.clear();
                
                nextLine = byteSource.readLine();//read nextline
          
            }
        }catch (Exception e){
            System.out.println("file readline doesn't work.");
        }
        
        //resolve for branching 
        try{
            program.resolveAddrs(program);
        }catch(Exception e){
            System.out.println("resolveAddress error in ByteCodeLoader.java.");
        }

        return program;
    }
}