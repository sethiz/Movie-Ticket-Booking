package operations;

public class Validations {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }

    public static boolean isNumeric(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
    
    public static boolean validContactno(String value){
        if(value==null){
            return false;
        }
        if(value.trim().length() != 10 ){
            return false;
        }
        value = value.trim();
        for( int i = 0; i < value.length();i++){
            if(!Character.isDigit(value.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isEmail(String value){
        if(value!=null){
            return value.trim().matches("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        }
        return false;
    }
    
    public static boolean onlyCharacter(String value){
        if(value!=null){
            return value.trim().matches("^([a-zA-z.'\\s]{2,30})$");
        }
        return false;
    }
}
