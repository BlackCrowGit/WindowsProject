#include <stdio.h>
#include <ctype.h>
FILE * source;
typedef enum {PLUS,MINUS,TIMES,OVER,LPAREN,RPAREN,SEMI,ASSIGN,NUM,ID,DOLLAR} tokentype;
typedef enum {START,INASSIGN,INCOMMENT,INNUM,INID,INSEMI,INDOLLAR,DONE} statetype;

tokentype token[40];
char tokenstring[40][30];
int wordindex = 0;
int back = 0;
int c;