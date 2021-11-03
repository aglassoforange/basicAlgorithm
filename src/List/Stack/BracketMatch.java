package List.Stack;

public class BracketMatch {

    public static boolean brackMatcher(String str){
        Stack<Character> stack = new Stack();
        for(int i = 0; i < str.length(); i++){
            char cha = str.charAt(i);
            if(cha - '(' == 0){
                stack.push(cha);
            }else{
                if(cha - ')' == 0 && stack.size()>0){
                    stack.pop();
                }
                if(cha - ')' == 0 && stack.size()<=0){
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
            String adc = "((((acdx)xxx))";
        System.out.println(brackMatcher(adc));
    }

}
