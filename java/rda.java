import java.io.IOException;

/*
<start> -> `lecture` <block>
<block> -> `{` <stmt> `}` $<end>
<stmt> -> <assignment> | <looping> | <expr>
<assignment> -> `$` <expr> `;`
<looping> -> <ha_stmt> | <during_stmt>
<expr> -> `$$` <term> { (+ | - | =) <term> }
<term> -> `$$$` <factor> { (* | / | %) <factor> }
<factor> -> 'id' | 'int_lit' | 'float_int' | `(` <expr> `)`
<end> -> `hahaha`

<ha_stmt> -> `ha` `(` <bool_expr> `)` <stmt> [ `lol` <stmt> ]      ha = if stmt
<during_stmt> -> `during` `(` <bool_expr> `)` <stmt>                during = while stmt

<bool_expr> -> <and> { `ehh` <and> }    ehh = or
<and> -> <eq> { `uhh` <eq> }            uhh = and
<eq> -> <rel> { ( `==` | `!=` ) <rel> }
<rel> -> <expr> { ( `<=` | `<` | `>=` | `>` ) <expr> }
<expr> -> <term> { ( `+` | `-` ) <term> }
<term> -> <not> { ( `*` | `/` | `%` ) <not> }
<not> -> [!]<fact>

ignore this below line please
<bfact> -> `id` | `int_lit` | `float_int` | `(` <expr `)`
*/

public class rda extends idk4 {
    public static void main(String[] args) throws IOException {
       start();
    }
    public static void start() throws IOException {
        System.out.println("Start <start>: ");
        while (nextToken == (int)myMap.get("START")) {
            block();
        }
    }
    public static void block() throws IOException {
        System.out.println("Start <block>: ");
        if (nextToken == (int)myMap.get("LEFT_CURLY")) {
            lex();
            stmt(nextToken);
            if (nextToken == (int)myMap.get("RIGHT_CURLY")) {
                lex();
                if (nextToken == (int)myMap.get("END")) {
                    end();
                } else {
                    error();
                }
            } else {
                error();
            }
        } else {
            error();
        }
        System.out.println("End <block> ");
    }
    public static void stmt(int ch) throws IOException {
        System.out.println("Start <stmt>: ");
        switch(ch) {
            case 45:
                assignment();
                break;
            case 40:
                looping();
                break;
            case 42:
                looping();
                break;
            case 46: 
                expr();
                break;
        }
        System.out.println("End <stmt> ");
    }
    public static void assignment() throws IOException {
        System.out.println("Start <assignment>: ");
        if (nextToken == (int)myMap.get("DOLLARS")) {
            lex();
            expr();
            if (nextToken == (int)myMap.get("SEMICOL")) {
                lex();
            } else {
                error();
            }
        } else {
            error();
        }
        System.out.println("End <assignment>");
    }
    public static void looping() throws IOException {
        System.out.println("Start <looping>: ");
        if (nextToken == (int)myMap.get("HA_STMT")) {
            lex();
            ha_stmt(); 
        } else if (nextToken == (int)myMap.get("DURING_STMT")) {
            lex();
            during_stmt();
        }
        System.out.println("End <looping> ");
    }
    public static void expr() throws IOException {
        System.out.println("Start <expr>: ");
        if (nextToken == (int)myMap.get("DOLLARSS")) {
            lex();
            term();
            while (nextToken == (int)myMap.get("ADD_OP") || nextToken == (int)myMap.get("SUB_OP") || nextToken == (int)myMap.get("ASSIGN_OP")) {
                lex();
                term();
            }
        } else {
            error();
        }
        System.out.println("End <term> ");
    }
    public static void term() throws IOException {
        System.out.println("Start <term>: ");
        if (nextToken == (int)myMap.get("DOLLARSSS")) {
            lex();
            factor();
            while (nextToken == (int)myMap.get("MULT_OP") || nextToken == (int)myMap.get("DIV_OP") || nextToken == (int)myMap.get("MODU")) {
                lex();
                factor();
            } 
        } else {
            error();
        }
        System.out.println("End <term>");
    }
    public static void factor() throws IOException {
        if (nextToken == (int)myMap.get("IDENT")) {
            lex();
        } else if (nextToken == (int)myMap.get("INT_LIT")) {
            lex();
        } else if (nextToken == (int)myMap.get("FLOAT_LIT")) {
            lex();
        } else if (nextToken == (int)myMap.get("LEFT_PAREN")) {
            lex();
            expr();
            if (nextToken == (int)myMap.get("RIGHT_PAREN")) {
                lex();
            } else {
                error();
            }
        } else {
            error();
        }
    }
    public static void ha_stmt() throws IOException {
        System.out.println("Start <ha_stmt>: ");
        if (nextToken == (int)myMap.get("HA_STMT")) { //edit
            lex();
            if (nextToken == (int)myMap.get("LEFT_PAREN")) {
                lex();
                bool_expr();
                if (nextToken == (int)myMap.get("RIGHT_PAREN")) {
                    lex();
                    stmt(nextToken);
                } else {
                    error();
                }
            } else {
                error();
            }
        } else {
            error();
        }
        System.out.println("End <ha_stmt> ");
    }
    public static void during_stmt() throws IOException {
        System.out.println("Start <during_stmt>: ");
        if (nextToken == (int)myMap.get("DURING_STMT")) { // edit
            lex();
            if (nextToken == (int)myMap.get("LEFT_PAREN")) {
                lex();
                bool_expr();
                if (nextToken == (int)myMap.get("RIGHT_PAREN")) {
                    lex();
                    stmt(nextToken);
                } else {
                    error();
                }
            } 
        } else {
            error();
        }
        System.out.println("End <during_stmt> ");
    }
    public static void bool_expr() throws IOException {
        System.out.println("Enter <bool_expr>: ");
        and();
        if (nextToken == (int)myMap.get("OOR")) {
            lex();
            and();
        }
        System.out.println("End <bool_expr> ");
    }
    public static void and() throws IOException {
        System.out.println("Enter <and>: ");
        eq();
        if (nextToken == (int)myMap.get("AAND")) {
            lex();
            eq();
        } else {
            error();
        }
        System.out.println("End <and> ");
    }
    public static void eq() throws IOException {
        System.out.println("Enter <eq>: ");
        rel();
        while (nextToken == (int)myMap.get("EQ") || nextToken == (int)myMap.get("NOT_EQ")) {
            lex();
            rel();
        }
        System.out.println("End <eq>");
    }
    public static void rel() throws IOException {
        System.out.println("Enter <rel>: ");
        b_expr();
        while (nextToken == (int)myMap.get("LESS_EQ") || nextToken == (int)myMap.get("LESSTH") || nextToken == (int)myMap.get("GRE_EQ") || nextToken == (int)myMap.get("GRE")) {
            lex();
            b_expr();
        }
        System.out.println("End <rel> ");
    }
    public static void b_expr() throws IOException {
        System.out.println("Enter <b_expr>: ");
        b_term();
        while (nextToken == (int)myMap.get("ADD_OP") || nextToken == (int)myMap.get("SUB_OP")) {
            lex();
            b_term();
        }
        System.out.println("End <b_expr> ");
    }
    public static void b_term() throws IOException {
        System.out.println("Enter <b_term>: ");
        b_not();
        while (nextToken == (int)myMap.get("MULT_OP") || nextToken == (int)myMap.get("DIV_OP") || nextToken == (int)myMap.get("MODU")) {
            lex();
            b_not();
        }
        System.out.println("End <b_term> ");
    }
    public static void b_not() throws IOException {
        if (nextToken == (int)myMap.get("NO")) {
            lex();
            b_fact();
        } else {
            lex();
            b_fact();
        }
    }
    public static void b_fact() throws IOException {
        if (nextToken == (int)myMap.get("IDENT")) {
            lex();
        } else if (nextToken == (int)myMap.get("INT_LIT")) {
            lex();
        } else if (nextToken == (int)myMap.get("FLOAT_LIT")) {
            lex();
        } else if (nextToken == (int)myMap.get("LEFT_PAREN")) {
            lex();
            expr();
            if (nextToken == (int)myMap.get("RIGHT_PAREN")) {
                lex();
            } else {
                error();
            }
        }
    }
    public static void end() {
        if (nextToken == (int)myMap.get("END")) {
            System.out.println("Program <END>");
        }
    }
    public static void error() {

    }
}
