package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;


public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    /**This function return the size used by a function in the runTimeStack
     * purpose is to ensure that pop method will not pop more then its function 
     * owned even if the args followed by pop is more than the size of its owned.
     * @return size used by a function in the runTimeStack;
     */
    
    public int maxToPop(){
        Iterator iterator = framePointer.iterator();
        int pointToNextFrame = 0, pointToCurrentFrame = (Integer)iterator.next();
        int sizeOfFunction = 0;
        if(pointToCurrentFrame == 0)
            sizeOfFunction = 0;       
        else if(iterator.hasNext()){
            pointToNextFrame = (Integer)iterator.next();
            sizeOfFunction = pointToCurrentFrame - pointToNextFrame;
        }
        return sizeOfFunction;
    }
    
    public void dump(){
        Iterator iterator = framePointer.iterator();
        int pointToNextFrame, pointToCurrentFrame = (Integer) iterator.next();
      
        for (int i = 0; i < framePointer.size(); i++) {
            if (iterator.hasNext()) {
                pointToNextFrame = (Integer) iterator.next();
            } else {
                pointToNextFrame = runTimeStack.size();
            }
            if(i != 0)
                System.out.print("[");
            for (int j = pointToCurrentFrame; j < pointToNextFrame; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != pointToNextFrame - 1) {
                    System.out.print(",");
                }
            }
            if(i != 0)
                System.out.print("]");
            pointToCurrentFrame = pointToNextFrame;
        }
        System.out.println("\n");
        
    }
    public int size(){
        return runTimeStack.size();
    }
    
    /**
     * 
     * @return the last element on the runTimeStack
     */
    public int peek(){
        return (Integer)runTimeStack.get(runTimeStack.size()-1);  
    }
    
    /**
     * remove the last element on the runTimeStack
     * @return the last element just removed on the runTimeStack 
     */
    
    public int pop(){
        int temp = (Integer)runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        return temp;             
    }
    
    /**
     * add an element to the runTimeStack
     * @param i
     * @return element just added to the runTimeStack
     */
    public int push(int i){
        runTimeStack.add(i);
        return this.peek();
    }
    
    /**
     * 
     * @param offset
     * @return 
     */
    public int store(int offset){
        int temp = (Integer)runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, temp);
        return temp;
    }
    
    public int load(int offset){
        int temp = (Integer)runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(temp);
        return temp;
    }
    
    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size() - offset);
    }
    
    public void popFrame(){
        int temp = this.peek();
        int temp2 = framePointer.pop();
        for(int i = runTimeStack.size()-1 ; i>=temp2; i--){
            runTimeStack.remove(i);
        }
        runTimeStack.add(temp);
        
    }
    
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return this.peek();
    }
}
