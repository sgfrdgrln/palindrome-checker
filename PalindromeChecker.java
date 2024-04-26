import java.util.*;


    public class PalindromeChecker {

        static final Scanner input = new Scanner(System.in);
        static final String regEx = "[a-zA-Z]+";
        public static void main(String[] args) {

            boolean validator = false;
            int option;

            

            while(!validator) {
                System.out.println("\n--- Palindrome Checker ---");    
                try {
                    do {
                System.out.println("\n1. Number Palindrome Checker \n\n2. Word Palindrome Checker\n\n3. Stop the Program");
                System.out.print("\nEnter a number: ");
                option = input.nextInt();
                
                
                    }while(option > 3 || option <= 0);

                    switch (option) {
                        case 1:
                            numberPalindrome();
                            break;

                         case 2:
                            wordPalindrome();
                            break;

                         case 3:
                          System.out.println("\nProgram stopped.");
                          validator = true;  
                            break;
                    
                        default:
                            System.out.println("\nInvalid option.");
                            break;
                    }
                
                }
                catch(InputMismatchException e) {
                    System.out.println("\nNot a number, Try again.");
                    input.nextLine();    
                }
            }


        }

        private static void numberPalindrome() {

            boolean checker = false;
            int num;
            System.out.println("\nCheck if the number is a palindrome");
            while(!checker) {

                try {
                System.out.print("\nEnter a number: ");
                num = input.nextInt();
                checker = true;

                int originalNum = num, remainder, reversedNum = 0;

                while (num != 0) {
                    remainder = num % 10;
                    reversedNum = reversedNum * 10 + remainder;
                    num /= 10;
                }
                System.out.println("\nYour number: "+originalNum);
                System.out.println("\nReversed number: "+reversedNum);
                if(originalNum == reversedNum) {
                    System.out.println("\n"+originalNum+" is a palindrome");
                }    
                else {
                    System.out.println("\n"+originalNum+" is not a palindrome");
                    
                }
                
                
                } catch (InputMismatchException e) {
                    System.out.println("\nNot a number.");
                    input.nextLine();
                }
                

            }
           
           
            

        }

        private static void wordPalindrome() {
            
            boolean checker = false;
            String str;
            String revStr = "";
            int strLength;
            

            input.nextLine();
            System.out.println("\nCheck if the word is palindrome");
            while(!checker) {

                try {
                do {
                System.out.print("\nEnter a word: ");
                str = input.nextLine().trim().toLowerCase();

                if(str.isEmpty()) {
                    System.out.println("\nDo not input an empty string.");
                }
                if(!str.matches(regEx)) {
                    throw new Exception();
                }
               

                
                checker = true;
                strLength = str.length();
                }while(str.isEmpty());
                
                for(int i = strLength - 1; i >= 0; i--) {
                    revStr = revStr + str.charAt(i);
                }

                System.out.println("\nYour word: "+str);
                System.out.println("\nReversed word: "+revStr);

                if(str.equals(revStr)) {
                    System.out.println("\n"+str+" is a palindrome ");
                }
                else {
                    System.out.println("\n"+str+" is not a palindrome ");
                }
                
                
                } catch (Exception e) {
                    System.out.println("\nNot a word.");
                    System.out.println("\nWhitespace not allowed.");
                    
                }


        }

    }
}