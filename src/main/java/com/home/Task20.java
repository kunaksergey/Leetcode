package com.home;

public class Task20 {
    public static void main(String[] args) {
        Task20 test = new Task20();
        System.err.println(test.isValid("(])"));
    }
    public boolean isValid(String s) {

        if(s.length()==0){
            return false;
        }
        String tmp = "";
        for (int i = 0; i <s.length() ; i++) {
            char charAt= s.charAt(i);
            if(charAt == '{' || charAt == '(' || charAt == '['){
                tmp += charAt;
            }else{
                if(tmp.length()==0){
                    return false;
                }
                char lastChar = tmp.charAt(tmp.length()-1);
             switch (charAt) {
                 case '}':
                     if(lastChar =='{'){
                         tmp = tmp.substring(0,tmp.length()-1);
                     }else{
                         return false;
                     }
                     break;
                 case ')':
                     if(lastChar =='('){
                         tmp = tmp.substring(0,tmp.length()-1);
                     }else{
                         return false;
                     }
                     break;
                 case ']':
                     if(lastChar =='['){
                         tmp = tmp.substring(0,tmp.length()-1);
                     }else{
                         return false;
                     }
                     break;
                 default:
                    return false;
             }
            }
        }
        return tmp.length()==0 ?true:false;
    }
}
