import java.util.*;
import java.io.*;
/* best version so far... */
public class lexi {
    public static int charClass;
    public static char[] lexeme = new char[100];
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    public static int countLex = 0;
    public static int x = 0;
    public static File myFile = new File("sample.txt");
    public static HashMap<String, Integer> myMap = new HashMap<String, Integer>();
    public static ArrayList<Character> arrList = new ArrayList<>();
    public static int indexxx = 0;
    public static void main(String[] args) throws IOException {
        mapping();
                listing();
                do {
                    lex();
                } while (nextToken != -1);
    }

    public static void mapping() {
        myMap.put("LETTER", 0);
        myMap.put("DIGIT", 1);
        myMap.put("UNKNOWN", 99);
        myMap.put("INT_FLOAT", 10);
        myMap.put("FLOAT_INT", 11);
        myMap.put("IDENT", 12);
        myMap.put("ASSIGN_OP", 20);
        myMap.put("ADD_OP", 21);
        myMap.put("SUB_OP", 22);
        myMap.put("MULT_OP", 23);
        myMap.put("DIV_OP", 24);
        myMap.put("MODU", 25);
        myMap.put("LEFT_PAREN", 26);
        myMap.put("RIGHT_PAREN", 27);
        myMap.put("LEFT_CURLY", 28);
        myMap.put("RIGHT_CURLY", 29);
        myMap.put("SEMICO", 30);
        myMap.put("EQ", 31);
        myMap.put("NOT_EQ", 32);
        myMap.put("LESS_EQ", 33);
        myMap.put("LESSTH", 34);
        myMap.put("GRE_EQ", 35);
        myMap.put("GRE", 36);
        myMap.put("NO", 37);
        myMap.put("START", 38);
        myMap.put("END", 39);
        myMap.put("IF_STMT", 40);
        myMap.put("ELSE_STMT", 41);
        myMap.put("WHILE_STMT", 42);
        myMap.put("AAND", 43);
        myMap.put("OOR", 44);
        myMap.put("DOLLARS", 45);
        myMap.put("DOLLARSS", 46);
        myMap.put("DOLLARSSS", 47);
    }
    public static int lookup(String ch) {
        if (ch == "lecture") {
            addChar();
            nextToken = (int)myMap.get("START");
        } else if (ch == "haha") {
            addChar(); 
            nextToken = (int)myMap.get("END");
        } else if (ch == "ha") {
            addChar();
            nextToken = (int)myMap.get("IF_STMT");   
        } else if (ch == "during") {
            addChar();
            nextToken = (int)myMap.get("WHILE_STMT");
        } else if (ch == "ehh") {
            addChar();
            nextToken = (int)myMap.get("AAND");
        } else if (ch == "uhh") {
            addChar();
            nextToken = (int)myMap.get("OOR");
        } else if (ch == "lol") {
            addChar();
            nextToken = (int)myMap.get("ELSE_STMT");
        } else if (ch == "$") {
            addChar();
            nextToken = (int)myMap.get("DOLLARS");
        } else if (ch == "$$") {
            addChar();
            nextToken = (int)myMap.get("DOLLARSS");
        } else if (ch == "$$$") {
            addChar();
            nextToken = (int)myMap.get("DOLLARSSS");
        } else if (ch == "!=") {
            addChar();
            nextToken = (int)myMap.get("NOT_EQ");
        } else if (ch == "==") {
            addChar(); 
            nextToken = (int)myMap.get("EQ");
        } else if (ch == "<=") {
            addChar();
            nextToken = (int)myMap.get("LESS_EQ");
        } else if (ch == "<") {
            addChar();
            nextToken = (int)myMap.get("LESS");
        } else if (ch == ">=") {
            addChar();
            nextToken = (int)myMap.get("GRE_EQ");
        } else if (ch == ">") {
            addChar();
            nextToken = (int)myMap.get("GRE");
        } else {
            switch(ch.charAt(0)) {
                case '(': 
                    addChar();
                    nextToken = (int)myMap.get("LEFT_PAREN");
                    break;
                case ')':
                    addChar();
                    nextToken = (int)myMap.get("RIGHT_PAREN");
                    break;
                case '=':
                    addChar();
                    nextToken = (int)myMap.get("ASSIGN_OP");
                    break;
                case '+': 
                    addChar();
                    nextToken = (int)myMap.get("ADD_OP");
                    break;
                case '-':
                    addChar();
                    nextToken = (int)myMap.get("SUB_OP");
                    break;
                case '*':
                    addChar();
                    nextToken = (int)myMap.get("MULT_OP");
                    break;
                case '/':
                    addChar();
                    nextToken = (int)myMap.get("DIV_OP");
                    break;
                case '%':
                    addChar();
                    nextToken = (int)myMap.get("MODU");
                    break;
                case '{':
                    addChar();
                    nextToken = (int)myMap.get("LEFT_CURLY");
                    break;
                case '}':
                    addChar();
                    nextToken = (int)myMap.get("RIGHT_CURLY");
                    break;
                case ';':
                    addChar();
                    nextToken = (int)myMap.get("SEMICO");
                    break;
            }
        }
        return nextToken;
    }
    public static void addChar(){
        if (lexLen <= 98) {
            arrList.add(nextChar);
        } else {
            System.out.println("Error - lexeme is too long");
        }
    }
    public static void listing() throws IOException {
            FileReader fRead2 = new FileReader(myFile);   //Creation of File Reader object
            BufferedReader bRead2 = new BufferedReader(fRead2);
            for (int i = 0; i < myFile.length(); i++) {
            
                x = bRead2.read();
                nextChar = (char) x;
                arrList.add(nextChar);
            }
    }

    public static void getCharac() throws IOException {
        nextChar = arrList.get(indexxx);
        if(Character.isAlphabetic(nextChar)) {
            charClass = (int)myMap.get("LETTER");
        } else if (Character.isDigit(nextChar)) {
            charClass = (int)myMap.get("DIGIT");
        } else if (Character.isDefined(nextChar)) {
            charClass = (int)myMap.get("UNKNOWN");
        } else {
            charClass = -1;
        }
        indexxx++;
    }

    public static void getNonBlank() throws IOException {
        while(Character.isSpaceChar(nextChar)) {
            getCharac();
        }
    }

    public static int lex() throws IOException {
        lexLen = 0;
        int letter = (int)myMap.get("LETTER");
        int dig = myMap.get("DIGIT");
        int not_know = myMap.get("UNKNOWN");
        getNonBlank();
        
        if (charClass == letter) {
            addChar();
            getCharac();
            while (charClass == letter || charClass == dig) {
                addChar();
                getCharac();
            }
            nextToken = (int)myMap.get("IDENT");
        } else if (charClass == dig) {
            addChar();
            getCharac();
            while (charClass == dig) {
                addChar();
                getCharac();
            }
            nextToken = (int)myMap.get("INT_FLOAT");
        } else if (charClass == not_know) {
            lookup(Character.toString(nextChar));
            getCharac();
        } else if (charClass == -1) {  //might have to edit cause EOF 
            nextToken = -1;
            lexeme[0] = 'E';
            lexeme[1] = 'O';
            lexeme[2] = 'F';
            lexeme[3] = '\0';
        } 
        /* 
        switch(charClass) {
            case 0:
                addChar();
                getCharac();
                while (charClass == letter || charClass == dig) {
                    addChar();
                    getCharac();
                } nextToken = (int)myMap.get("IDENT");
                break;

            case 1:
                addChar();
                getCharac();
                while (charClass == dig) {
                    addChar();
                    getCharac();
                }
                nextToken = (int)myMap.get("INT_LIT");
                break;
                
            case 99:
                lookup(Character.toString(nextChar));
                getCharac();
                break;
            
            case -1:
                nextToken = -1;
                lexeme[0] = 'E';
                lexeme[1] = 'O';
                lexeme[2] = 'F';
                lexeme[3] = '\0';
                break;       
        } */
        countLex++;
        System.out.println("Your program has " + countLex + " lexemes!");
        System.out.println("Next token is: " + nextToken + ", Next lexeme is " + arrList.get(indexxx)); // edit this
        return nextToken;
        
    }
}




