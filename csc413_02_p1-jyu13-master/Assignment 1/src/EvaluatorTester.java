/**
 * 
 * @author Arnold Jiadong Yu
 */

public class EvaluatorTester {

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        
        String[] test = {"6+3+2-4/2", //9
                        "5+3*8",      //29
                        "5^4+3-5*2+10/5", //620
                        "(5+2)+10",//17
                        "5+(2+10)",//17
                        "2^(2+1)",//8
                        "((20/2+(13-2^3)+2*3)-15)", //6
                        "3+5-(4*2+2^2)+((20/2+(13-2^3)+2*3)-15)" //2
        }; 
        for (String arg : test) {
            System.out.format("%s = %d\n", arg, evaluator.eval(arg));
            //System.out.println( arg + " = " + evaluator.eval( arg ) );
        }
    }
}
