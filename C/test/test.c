#include "stdio.h"

int i;
void prt()
{
	for(i = 5; i < 8; i++) printf("%c",'*');
	printf("\t");
}

main()
{
	for(i = 5; i <= 8; i++) prt();
}