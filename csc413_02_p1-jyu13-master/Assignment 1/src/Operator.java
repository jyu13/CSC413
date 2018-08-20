
import java.util.*;
/**
 * 
 * @author Arnold Jiadong Yu
 */
public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    //int priority;

    protected final static HashMap operators = new HashMap();
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    
    //private final static HashMap<String, Operator> operators1;
    static {
        //operators1 = new HashMap<>();
        //initialize stack, put each Operator and mapping them 
        operators.put( "+", new AdditionOperator() );
        operators.put( "-", new SubtractionOperator() );
        operators.put( "*", new MultiplicationOperator() );
        operators.put( "^", new ExponentialOperator() );
        operators.put( "/", new DivisionOperator() );
        operators.put( "#", new HashtagOperator() );
        operators.put( "!", new ExclamationOperator() );
        operators.put( "(", new leftParentheseoperator() );
        operators.put( ")", new rightParentheseoperator() );
    }

    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);

    public static boolean check(String token) {
        return operators.containsKey(token);
    }
}

//override abstract class by adding unique behavior.
class AdditionOperator extends Operator {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue() + op2.getValue());
    }
}

class SubtractionOperator extends Operator {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue() - op2.getValue());
    }
}

class MultiplicationOperator extends Operator {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue() * op2.getValue());
    }
}

class DivisionOperator extends Operator {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue() / op2.getValue());
    }
}

class ExponentialOperator extends Operator {

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int temp = op1.getValue();
        int loop = op2.getValue();
        int result = 1;
        for (int i = 0; i < loop; i++) {
            result = result * temp;
        }
        return new Operand(result);
    }
}
class HashtagOperator extends Operator {

    @Override
    public int priority() {
        return -1;
    }
    
    @Override
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}


class ExclamationOperator extends Operator {
    
    @Override
    public int priority() {
        return 1;
    }
    
    @Override
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}

class leftParentheseoperator extends Operator {
    
    @Override
    public int priority() {
        return 1;
    }
    
    @Override
    public Operand execute(Operand op1, Operand op2){
        return null;
    } 
    
}

class rightParentheseoperator extends Operator {
    
    @Override
    public int priority() {
        return 0;
    }
    
    @Override
    public Operand execute(Operand op1, Operand op2){
        return null;
    } 
}