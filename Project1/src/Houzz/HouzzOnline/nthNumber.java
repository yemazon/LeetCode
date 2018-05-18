//public static String nthNumber(int n){
//        int base = 9;
//        char[] digits = new char[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        StringBuilder str = new StringBuilder("");
//        if(0==n){
//            str.append(digits.charAt(0));
//        }else{
//            Stack<Character> s = new Stack<Character>();
//            while(n != 0){
//                s.push(digits.charAt(n%base));
//                n/=base;
//            }
//            while(!s.isEmpty()){
//                str.append(s.pop());
//            }
//        }
//        return str.toString();
//    }