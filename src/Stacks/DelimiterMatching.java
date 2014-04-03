package Stacks;

/**
 * Created by Dhana on 4/2/2014.
 */
public class DelimiterMatching {
    public static void main(String[] args){
        //String toParse = "c[d]";
        //String toParse = "a{b[c]d}e"; // correct
        //String toParse = "a{b(c]d}e"; // not correct; ] doesn’t match (
        //String toParse = "a[b{c}d]e}"; // not correct; nothing matches final }
        String toParse = "a{b(c)"; // not correct; nothing matches opening {
        ArrayStack arr = new ArrayStack(toParse.length());

        for(int i = 0; i < toParse.length(); i++){
            char item = toParse.charAt(i);
            switch(item){
                case '[':
                case '{':
                case '(':
                    arr.push(item);
                    break;
                case ']':
                case '}':
                case ')':
                    if(!arr.isEmpty()) {
                        char popped = arr.pop();
                        if (!((item == ']' && popped == '[') ||
                                (item == '}' && popped == '{') ||
                                (item == ')' && popped == '('))) {
                            System.out.println("ERROR");
                            return;
                        }
                    }
                    else{
                        System.out.println("ERROR");
                        return;
                    }
                    break;
            }

        }

        if(!arr.isEmpty()){
            System.out.println("ERROR");
        }
        else{
            System.out.println("CORRECT");
        }


    }
}
