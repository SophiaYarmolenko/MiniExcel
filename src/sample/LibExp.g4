grammar LibExp;

INT    : [0-9]+;
DOUBLE : [0-9]+'.'[0-9]+;
PI     : 'pi';
E      : 'e';
POW    : '^';
NL     : '\n';
WS     : [ \t\r]+ -> skip;
ID     : [a-zA-Z_][a-zA-Z_0-9]*;

PLUS        : '+';
EQUAL       : '=';
MINUS       : '-';
MULT        : '*';
DIV         : '/';
MOD         : '%';
LPAR        : '(';
RPAR        : ')';
INTDIV      : ':';

LESSEQUAL   : '<=';
BIGGEREQUAL : '>=';
BIGGER      : '>';
LESS        : '<';
NOT         : '!';
NOTEQUAL    : '!=';

input
    : setVar NL input     # ToSetVar
    | logicalOperation NL? EOF # Calculate
    ;

setVar
    : ID EQUAL logicalOperation # SetVariable
    ;

logicalOperation
    : logicalOperation NOTEQUAL plusOrMinus  # NoteEqual
    | logicalOperation NOT plusOrMinus # Not
    | logicalOperation LESSEQUAL plusOrMinus # LessEqual
    | logicalOperation LESS plusOrMinus # Less
    | logicalOperation BIGGEREQUAL plusOrMinus # BiggerEqual
    | logicalOperation BIGGER plusOrMinus # Bigger
    | plusOrMinus                # ToPlusOrMinus
    ;

plusOrMinus
    : plusOrMinus PLUS multOrDivOrMod  # Plus
    | plusOrMinus MINUS multOrDivOrMod # Minus
    | multOrDivOrMod                # ToMultOrDiv
    ;

multOrDivOrMod
    : multOrDivOrMod MULT pow # Multiplication
    | multOrDivOrMod DIV pow  # Division
    | multOrDivOrMod MOD pow # Mod
    | multOrDivOrMod INTDIV pow # DivInt
    | pow                # ToPow
    ;

pow
    : unaryMinus (POW pow)? # Power
    ;

unaryMinus
    : MINUS unaryMinus # ChangeSign
    | atom             # ToAtom
    ;

atom
    : PI                    # ConstantPI
    | E                     # ConstantE
    | DOUBLE                # Double
    | INT                   # Int
    | ID                    # Variable
    | LPAR logicalOperation RPAR # Braces
    ;