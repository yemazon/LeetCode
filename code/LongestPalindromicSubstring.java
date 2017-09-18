/**
 * 5.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String res = longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");
        System.out.println(res);
    }

    //brute force
    public static String longestPalindrome(String s) {
        int length = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <=  s.length(); j++) {
                String temp = s.substring(i,j);
                if(isPalindrome(temp)) {
                    if(temp.length() >= length) {
                        result = temp;
                        length = temp.length();
                    }
                }
            }
        }
        return result;
    }

    public static Boolean isPalindrome(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length/2; i++) {
            if(charArray[i] != charArray[length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
