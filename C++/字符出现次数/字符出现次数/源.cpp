#include <iostream>

using namespace std;
/**

* @auther BlackCrow

* @date 2014-3-21 11:16:42

**/ 
int	main() {
	char str[80],c;
	cin >> str;
	cin >> c;
	int i,n,num = 0;
	n = strlen(str);
	for(i=0;i<n;i++) {
		if(str[i] == c) {
			num++;
		}
	}
	cout << num << endl;

	system ("pause");
	return 0;
}
