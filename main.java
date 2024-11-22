import java.util.*;

public class main {
    
   
    public static boolean Permutation(String pattern, String text) {
        int a = text.length();
        int b = pattern.length();
        
        if (b > a) {
            return false;
        }

        int[] Pcount = new int[26];
        int[] Wcount = new int[26];

        for (char change : pattern.toCharArray()) {
            Pcount[change - 'a']++;
        }

        for (int i = 0; i < b; i++) {
            Wcount[text.charAt(i) - 'a']++;
        }

        if (Arrays.equals(Pcount, Wcount)) {
            return true;
        }

        for (int i = b; i < a; i++) {
           
            Wcount[text.charAt(i) - 'a']++;
           
            Wcount[text.charAt(i - b) - 'a']--;
             
            if (Arrays.equals(Pcount, Wcount)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt(); 
        
        for (int d = 0; d < Test; d++) {
            String pattern = sc.next(); 
            String text = sc.next();    
            
       if (Permutation(pattern, text)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
