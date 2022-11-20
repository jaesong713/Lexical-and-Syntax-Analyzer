# Lexical-and-Syntax-Analyzer

## A. 
## Grammar Rules for the Language
- START -> lecture BLOCK
- BLOCK -> { STMT } $END
- STMT -> ASSIGNMENT | LOOPING | EXPR
- ASSIGNMENT -> $ EXPR ;
- LOOPING -> HA_STMT | DURING_STMT
- EXPR -> $$ TERM { ( + | - | = ) TERM }
- TERM -> $$$ FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> id | int_lit | float_int | ( EXPR )
- END -> hahaha

- HA_STMT -> ha ( BOOL_EXPR ) STMT [ lol STMT ]     
- DURING_STMT -> during ( BOOL_EXPR ) STMT                

- BOOL_EXPR -> AND { ehh AND }  
- AND -> EQ { uhh EQ }          
- EQ -> REL { ( == | != ) REL }
- REL -> B_EXPR { ( <= | < | >= | > ) B_EXPR }
- B_EXPR -> B_TERM { ( + | - ) B_TERM }
- B_TERM -> NOT { ( * | / | % ) NOT }
- NOT -> [ ! ]B_FACT
- B_FACT -> id | int_lit | float_int | ( EXPR )

## Grammar Syntax Notation:
-START: lecture BLOCK
- BLOCK: { STMT } $END
- STMT: ASSIGNMENT | LOOPING | EXPR
- ASSIGNMENT: `$` EXPR `;`
- LOOPING: HA_STMT | DURING_STMT
- EXPR -> `$$` TERM { ( + | - | = ) TERM }
- TERM -> `$$$` FACTOR { ( * | / | % ) FACTOR }
- FACTOR -> `id` | `int_lit` | `float_int` | `(` EXPR `)`
- END -> hahaha

- HA_STMT -> `ha` `(` BOOL_EXPR `)` STMT [ `lol` STMT ]     
- DURING_STMT -> `during` `(` BOOL_EXPR `)` STMT                

- BOOL_EXPR -> AND { `ehh` AND }  
- AND -> EQ { `uhh` EQ }          
- EQ -> REL { ( `==` | `!=` ) REL }
- REL -> B_EXPR { ( `<=` | `<` | `>=` | `>` ) B_EXPR }
- B_EXPR -> B_TERM { ( `+` | `-` ) B_TERM }
- TERM -> NOT { ( `*` | `/` | `%` ) NOT }
- NOT -> [ `!` ]B_FACT
- B_FACT -> `id` | `int_lit` | `float_int` | `(` EXPR `)`

## Legend: 
```
ha = if in if statement
lol = else in else statement
during = while in while statement
ehh = or 
uhh = and
`...` = (`) to indicate character literal to detect for each rule
```
## B. 


## C. 
- FIRST(START) -> {'lecture'}
- FIRST(BLOCK) -> {'{'}
- FIRST(STMT) -> {'$'} | {'HA', 'DURING'} | {'$$'}
- FIRST(ASSIGN) -> {'$'}
- FIRST(LOOP) -> {'HA'} | {'DURING'}
- FIRST(EXPR) -> {'$$'}
- FIRST(TERM) -> {'$$$'}
- FIRST(FACTOR) -> {'id'} | {'int_lit'} | {'float_int'} | {'('}

- FIRST(HA_STMT) -> {'HA'}
- FIRST(DURING_STMT) -> {'DURING'}

- FIRST(BOOL) ->  {'('}}
- FIRST(AND) -> {'UHH'}
- FIRST(EQ) ->  {'!=', '=='}
- FIRST(REL) -> {'>=', '>', '<='. '<'}
- FIRST(B_EXPR) -> {'+', '-'}
- FIRST(B_TERM) -> {'*', '/', '%'}
- FIRST(NOT) -> {'!'}

## Proof for LL Grammar: 
This grammar proves to be pairwise disjoint because no first character of each rule replicates another.

## D.

## E.
Please refer to the java folder and open the lexi.java file and the optimal scenario is to return the corresponding tokens along with the recognized lexeme. One can test on the files within the folder and also develop or write his/her own code to test. The process to test one's own file is to simply create a test file and edit line 13 to link his/her file.


## F.
Please refer to the java folder and open the rda.java file. One can test on different documents that I have provided and also, develop his/her own file to test 
and edit the 

## G. 
The test files will be in the Java folder as well. The files will be the ones that are named kobe.txt, brisket.txt, sample.txt and hello.txt. 
```
kobe.txt will be an ideal and correct file
brisket.txt will be an ideal and correct file
sample.txt will have syntax error(s)
hello.txt will have lexical and syntax error(s)
```

## H. 
Please refer to parseTable.docx




