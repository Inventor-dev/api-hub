grammar ConfigSqlParser;
import ConfigSqlLexer;

entry :	expression+ EOF;

expression : exprComposite
		   | ifExpr
		   | caseExpr
		   | returnExpr
		   | variableAssign
		   ;

exprComposite : expr 										#singleExprComposite
			  | ternaryExpr									#ternaryExprComposite
			  | LeftParen exprComposite RightParen 			#parenExprComposite
			  | exprComposite Operator exprComposite		#complexExprComposite
			  ;

ternaryExpr : ifCondition (join ifCondition)* '?' block ':' block ;



caseExpr : 'case' '{' casePart (',' casePart)* '}' ;

casePart : ifCondition (join ifCondition)* ':'? block ;

ifExpr: ifPart elseIfPart* elsePart? ;

ifPart : 'if' '(' ifCondition (join ifCondition)* ')' '{' block '}';

elseIfPart : 'else' 'if' '(' ifCondition (join ifCondition)* ')' '{' block '}' ;

elsePart : 'else' '{' block '}' ;

block : exprBlock* returnExpr? ;

exprBlock : variableAssign
		 | ifExpr
		 | caseExpr
		 ;

returnExpr : 'return'? expr ';'?;

expr : item (ArithmeticOperator item)* ;

ifCondition : expr LogicalOperator expr ;

variableAssign : 'var'? variable '=' item ';'?;

item : unit (ArithmeticOperator unit)*							#simpleJoin
	 | LeftParen item RightParen						        #singleParenJoin
     | LeftParen item (ArithmeticOperator item)+ RightParen		#parenJoin
     ;

unit : dataset
	 | function
	 | set
	 | variable
	 | INTEGER
	 | BOOLEAN
	 | STRING
	 | NUMBER
	 | NULL
	 ;

variable : Identifier ;

dataset : Identifier '.' aggregate '(' property? (',' conditions )? (',' ORDER)? ')';

function : Identifier '(' functionParameter? ')' ;

functionParameter : item (','? item)* ;

set : simpleValue										#simpleData
	| set 'to' set										#range
	;

conditions : condition (join condition)* ;

condition : property LogicalOperator expr			#propertyCondition
		  | currentValue LogicalOperator expr		#currentValueCondition
		  | expr LogicalOperator expr				#exprCondition
		  ;

property : Identifier
		 | property '.' property
		 ;

currentValue : '@' ;

simpleValue : INTEGER|NUMBER|STRING|BOOLEAN|NULL;

join : AND | OR ;

aggregate : Identifier;