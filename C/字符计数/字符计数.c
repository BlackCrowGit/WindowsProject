#include <stdio.h>
#include <string.h>

int	main() {
	char str[80],c;
	int i,n,num = 0;
	gets(str);
	scanf("%c",&c);
	n = sizeof(str);
	for(i=0;i<n;i++) {
		if(str[i] == c) {
			num++;
		}
	}
	printf("%d\n",num);

	return 0;
}
