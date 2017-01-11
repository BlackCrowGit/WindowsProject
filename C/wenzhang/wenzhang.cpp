#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct essay
{
	char *line;			//动态分配的字符数组
	struct essay *next;	//结构体指针
}ESS;
//创建结构体,行与行之间用链表的形式

/*******************************************************
 *函数名:Display()
 *功  能:显示界面
 *参  数:无
 *返回值:无
 */
void Display()
{
	printf("*******************请选择操作:*****************\n");
	printf("**********1.统计文章中数字个数*****************\n");
	printf("**********2.统计文章中字母个数*****************\n");
	printf("**********3.统计文章中中文个数*****************\n");
    printf("**********4.统计文章中空格个数*****************\n");
	printf("**********5.统计文章中指定字符串出现次数*******\n");
	printf("**********6.统计文章中总字符数*****************\n");
	printf("**********7.删除文章中指定字符串***************\n");
    printf("**********8.输出文章***************************\n");
    printf("***********************************************\n");
}

/*******************************************************
 *函数名: Create(ESS*)
 *功  能: 创建链表
 *参  数: ESS* &h
 *返回值: 无
 */
void Create(ESS* &h)
{
	char m[1000];
	ESS *p;
	p = (ESS*)malloc(sizeof(ESS));
	h = p;
	int i,k;

	FILE *fp;
	fp = fopen("./text.txt","w");//所输入的文本将保存在当前文件夹的文本文档中
	printf("输入文章,用Ctrl+B结束输入:\n");//按Ctrl+B(^B)将结束输入

	while (true)
	{
		gets(m);

		if (strlen(m) > 1000)
		{
			printf("输入超过1000字符\n");
			break;
		}

		if (m[0] == 2)
			break;

		p = p->next = (ESS*)malloc(sizeof(ESS));
		p->line = (char*)malloc(sizeof(char) * strlen(m + 1));
		strcpy(p->line, m);	//将字符串m复制到p所指向的字符串中
		for (i = 0; i < (k = strlen(m)) && (p->line[i] != 2); i++)
			fwrite(&p->line[i], sizeof(char), 1, fp);	//写入文本文档中
		fputc('\n',fp);
		if (m[strlen(m) - 1] == 2)		//去除最后一个控制符^B
		{
			p->line[strlen(m) - 1] = '\0';
			break;
		}
	}

	p->next = NULL;		//最后一个指针为空
	h = h->next;		//讲下一个节点赋给头结点
	
	Display();
}

/*******************************************************
 *函数名:Out(ESS*)
 *功  能:输出整篇文章
 *参  数:ESS*
 *返回值:无
 */
void Out(ESS* &h)
{
	ESS* p = h;
	printf("文章如下:\n");
	do
	{
		printf("%s\n",p->line);		//循环输出每行
	} while ((p = p->next) != NULL);
	printf("\n");
}

/*******************************************************
 *函数名: CountNumber(ESS*)
 *功  能; 调用count函数,统计数字
 *参  数; ESS* h
 *返回值; 无
 */
void CountNumber(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//计算当前line里的数组元素的个数
		for (i = 0; i < Lenght; i++)
			if (p->line[i] >= 48 && p->line[i] <= 57)	//ASCII码在48到57之间的为数字
				co++;
	} while ((p = p->next) != NULL);	//遍历 链表不为空
	printf("此文章中数字的个数为:%d.\n",co);
	Display();
}

/*******************************************************
 *函数名:CountLetter(ESS*)
 *功  能:统计文章中字母的个数
 *参  数:ESS* h
 *返回值:无
 */
void CountLetter(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//计算当前line里的元素个数
		for (i = 0; i < Lenght; i++)
			if ((p->line[i] >= 'a' && p->line[i] <= 'z') || (p->line[i] >= 'A' && p->line[i] <= 'Z'))
				co++;
	} while ((p = p->next) != NULL);
	printf("此文章中字母的数量为:%d.\n",co);
	Display();
}

/*******************************************************
 *函数名:CountChinese(ESS*)
 *功  能:统计文章中中文的个数
 *参  数:ESS *h
 *返回值:无
 */
void CountChinese(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//计算当前line里的元素个数
		for (i = 0; i < Lenght; i++)
			if ((p->line[i] >= 1 && p->line[i] <= 254))	//
				co ++;
	} while ((p = p->next) != NULL);
	printf("此文章中中文的数量为:%d.\n",co/2);
	Display();
}

/*******************************************************
 *函数名:CountSpace(ESS*)
 *功  能:统计文章中空格的个数
 *参  数:ESS *h
 *返回值:无
 */
void CountSpace(ESS* h)
{
	ESS *p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//计算当前line里的元素个数
		for (i = 0; i <Lenght; i ++)
			if (p->line[i] == 32)	//空格的ASCII码为32
				co ++;
	} while ((p = p->next) != NULL);
	printf("此文章中空格的数量为:%d.\n",co);
	
	Display();
}

/*******************************************************
 *函数名:CountAll(ESS*)
 *功  能:统计文章总字数
 *参  数:ESS* h
 *返回值:无
 */
void CountAll(ESS* h)
{
	ESS* p = h;
	int co = 0;
	
	do
	{
		co += strlen(p->line);		//每行长度累加为文章总长度
	} while ((p = p->next) != NULL);
	printf("此文章总字数为:%d.\n",co);
	Display();
}

/*******************************************************
 *函数名:FindString(ESS*)
 *功  能:统计文章中指定字符串出现的次数
 *参  数:ESS* h
 *返回值:无
 */
void FindString(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int len1 = 0;			//保存当前line的总字符数
	int len2;	//待统计字符串的长度
	int i,j,q;
	char str[20];
	printf("请输入要统计的字符串:");
	getchar();
	gets(str);
	len2 = strlen(str);
	
	do
	{
		len1 = strlen(p->line);		//当前line的字符数
		for (i = 0; i < len1; i++)	//字符匹配
		{
			if (p->line[i] == str[0])
			{
				q = 0;
				for (j = 0; j < len2; j ++)
					if (p->line[j + i] == str[j])
						q ++;
				if (q == len2)
				{
					co ++;
					i = i + q - 1;
				}
			}
		}
	} while ((p = p->next) != NULL);
	printf("此文章中\"%s\"出现的次数为:%d.\n",co);
	
	Display();
}

/*******************************************************
 *函数名:delstringword(char*, char*)
 *功  能:内部调用函数,从输入的字符串中删除指定字符
 *参  数:char* s, char* str
 *返回值:无
 */
void delstringword(char* s, char* str)
{
	char *p = strstr(s, str);	//从字符串s中寻找str第一次出现的位置
	char m[80];
	int len = strlen(s);
	int i = len - strlen(p);	//比较两字符串之间的字符个数
	int j = i + strlen(str);
	int k,n;
	int co = 0;

	for (k = 0; k < i; k ++)
		m[co ++] = s[k];
	for (n = j; n < len; n ++)
		m[co ++] = s[n];
	m[co] = '\0';
	strcpy(s,m);				//把删除后的字符串赋给原字符串
}

/*******************************************************
 *函数名:DelString(ESS*, char*)
 *功  能:调用delstringword函数,从全文的每一行删除指定字符串
 *参  数:ESS* h, char* str
 *返回值:无
 */
void DelString(ESS* h)
{
	ESS *p = h;
	char str[20];
	printf("请输入要删除的字符串:");
	scanf("%s",str);
	do
	{
		if (strstr(p->line, str) != NULL)
			delstringword(p->line, str);	//调用delstringword函数删除每个字符,只删一次
	} while ((p = p->next) != NULL);
	printf("删除%s后的文章为:\n",str);
	Out(p);
	
	Display();
}


/*******************************************************
 *函数名:main()
 *功  能:主函数
 *参  数:无
 *返回值:(int) 0
 */
int main()
{
	ESS* h;
	int opt;
	Create(h);
	while (true)
	{
		printf("执行指令:");
		scanf("%d",&opt);
		switch (opt)
		{
		case 1:
			CountNumber(h);
			break;
		case 2:
			CountLetter(h);
			break;
		case 3:
			CountChinese(h);
			break;
		case 4:
			CountSpace(h);
			break;
		case 5:
			FindString(h);
			break;
		case 6:
			CountAll(h);
			break;
		case 7:
			DelString(h);
			break;
		case 8:
			Out(h);
			break;
		default:
			printf("指令输入错误\n\n");
			break;
		}
	}
		

	return 0;
}