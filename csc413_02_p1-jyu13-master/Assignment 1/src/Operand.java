/**
 * 
 * @author Arnold Jiadong Yu
 */
public class Operand {
    int value;
    
    public Operand(String token) {
        this.value = Integer.parseInt(token);
    }

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean check(String token) {
        try{
            Integer.parseInt(token);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}