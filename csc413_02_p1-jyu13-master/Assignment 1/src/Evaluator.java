
import java.util.*;

/**
 * 
 * @author Arnold Jiadong Yu
 */
public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/#!() "; //add parentheses

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();

    }

    public int eval(String expression) {
        String token;
        expression = expression + "!";
        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators
        // TODO Operator is abstract - this will need to be fixed:
        // operatorStack.push( new Operator( "#" ));
        // When is it a good time to add the "!" operator?
        operatorStack.push(new HashtagOperator());

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        System.exit(1);
                    }
                    // TODO Operator is abstract - these two lines will need to be fixed:
                    // The Operator class should contain an instance of a HashMap,
                    // and values will be instances of the Operators.  See Operator class
                    // skeleton for an example.
                    Operator newOperator = (Operator) Operator.operators.get(token);
                    if(newOperator.equals(Operator.operators.get("("))){
                        operatorStack.push(newOperator);
                    }
                    else if(newOperator.equals(Operator.operators.get(")"))){
                        while (!operatorStack.peek().equals(Operator.operators.get("(")) && !operandStack.empty()) {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
                            }
                        if (!operatorStack.peek().equals(Operator.operators.get("#")) && operatorStack.peek().equals(Operator.operators.get("("))) {
                            operatorStack.pop();
                        }
                    }
                    else if(operatorStack.peek().priority() >= newOperator.priority() && !operatorStack.peek().equals(Operator.operators.get("#"))){
                        while(operatorStack.peek().priority() >= newOperator.priority() && !operatorStack.peek().equals(Operator.operators.get("#"))){
                            Operator oldOpr = operatorStack.pop();                       
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                        operatorStack.push(newOperator);
                    }
                    else{
                        operatorStack.push(newOperator);
                    }
                    
                    
                    
                    //this one doesn't work very well, it only works for (5+2)+10, not for 5+(2+10)
                    /*Operator newOperator = (Operator) Operator.operators.get(token);  //concurrency

                    while (operatorStack.peek().priority() >= newOperator.priority() && !newOperator.equals(Operator.operators.get("("))){
                        // note that when we eval the expression 1 - 2 we will
                        // push the 1 then the 2 and then do the subtraction operation
                        // This means that the first number to be popped is the
                        // second operand, not the first operand - see the following code
                        if (newOperator.equals(Operator.operators.get(")"))) {
                            
                            while (!operatorStack.peek().equals(Operator.operators.get("("))) {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
                            }
                            if (!operatorStack.peek().equals(Operator.operators.get("#")) && operatorStack.peek().equals(Operator.operators.get("("))) {
                                operatorStack.pop();
                            }
                            
                        } 
                        else {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                            //operand res = oldOpr.exexcute(op1,op2);
                            //if res == null && operator instanceof DivisionOperator
                            //this.failedExpression = true;
                            //operandSack.push(res)
                        }
                    }
                    if (!newOperator.equals(Operator.operators.get(")"))) {
                        operatorStack.push(newOperator);
                    }*/
                }
            }
        }

        // Control gets here when we've picked up all of the tokens; you must add
        // code to complete the evaluation - consider how the code given here
        // will evaluate the expression 1+2*3
        // When we have no more tokens to scan, the operand stack will contain 1 2
        // and the operator stack will have + * with 2 and * on the top;
        // In order to complete the evaluation we must empty the stacks (except
        // the init operator on the operator stack); that is, we should keep
        // evaluating the operator stack until it only contains the init operator;
        // Suggestion: create a method that takes an operator as argument and
        // then executes the while loop; also, move the stacks out of the main
        // method
        
        //in case the calculation is not finished
        /*while(operatorStack.size() > 1 && operandStack.size() >= 2){
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push(oldOpr.execute(op1, op2));
        }*/
        operatorStack.clear();
        return (operandStack.pop().getValue());
    }
}
