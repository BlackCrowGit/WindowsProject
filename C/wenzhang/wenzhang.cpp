#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct essay
{
	char *line;			//��̬������ַ�����
	struct essay *next;	//�ṹ��ָ��
}ESS;
//�����ṹ��,������֮�����������ʽ

/*******************************************************
 *������:Display()
 *��  ��:��ʾ����
 *��  ��:��
 *����ֵ:��
 */
void Display()
{
	printf("*******************��ѡ�����:*****************\n");
	printf("**********1.ͳ�����������ָ���*****************\n");
	printf("**********2.ͳ����������ĸ����*****************\n");
	printf("**********3.ͳ�����������ĸ���*****************\n");
    printf("**********4.ͳ�������пո����*****************\n");
	printf("**********5.ͳ��������ָ���ַ������ִ���*******\n");
	printf("**********6.ͳ�����������ַ���*****************\n");
	printf("**********7.ɾ��������ָ���ַ���***************\n");
    printf("**********8.�������***************************\n");
    printf("***********************************************\n");
}

/*******************************************************
 *������: Create(ESS*)
 *��  ��: ��������
 *��  ��: ESS* &h
 *����ֵ: ��
 */
void Create(ESS* &h)
{
	char m[1000];
	ESS *p;
	p = (ESS*)malloc(sizeof(ESS));
	h = p;
	int i,k;

	FILE *fp;
	fp = fopen("./text.txt","w");//��������ı��������ڵ�ǰ�ļ��е��ı��ĵ���
	printf("��������,��Ctrl+B��������:\n");//��Ctrl+B(^B)����������

	while (true)
	{
		gets(m);

		if (strlen(m) > 1000)
		{
			printf("���볬��1000�ַ�\n");
			break;
		}

		if (m[0] == 2)
			break;

		p = p->next = (ESS*)malloc(sizeof(ESS));
		p->line = (char*)malloc(sizeof(char) * strlen(m + 1));
		strcpy(p->line, m);	//���ַ���m���Ƶ�p��ָ����ַ�����
		for (i = 0; i < (k = strlen(m)) && (p->line[i] != 2); i++)
			fwrite(&p->line[i], sizeof(char), 1, fp);	//д���ı��ĵ���
		fputc('\n',fp);
		if (m[strlen(m) - 1] == 2)		//ȥ�����һ�����Ʒ�^B
		{
			p->line[strlen(m) - 1] = '\0';
			break;
		}
	}

	p->next = NULL;		//���һ��ָ��Ϊ��
	h = h->next;		//����һ���ڵ㸳��ͷ���
	
	Display();
}

/*******************************************************
 *������:Out(ESS*)
 *��  ��:�����ƪ����
 *��  ��:ESS*
 *����ֵ:��
 */
void Out(ESS* &h)
{
	ESS* p = h;
	printf("��������:\n");
	do
	{
		printf("%s\n",p->line);		//ѭ�����ÿ��
	} while ((p = p->next) != NULL);
	printf("\n");
}

/*******************************************************
 *������: CountNumber(ESS*)
 *��  ��; ����count����,ͳ������
 *��  ��; ESS* h
 *����ֵ; ��
 */
void CountNumber(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//���㵱ǰline�������Ԫ�صĸ���
		for (i = 0; i < Lenght; i++)
			if (p->line[i] >= 48 && p->line[i] <= 57)	//ASCII����48��57֮���Ϊ����
				co++;
	} while ((p = p->next) != NULL);	//���� ����Ϊ��
	printf("�����������ֵĸ���Ϊ:%d.\n",co);
	Display();
}

/*******************************************************
 *������:CountLetter(ESS*)
 *��  ��:ͳ����������ĸ�ĸ���
 *��  ��:ESS* h
 *����ֵ:��
 */
void CountLetter(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//���㵱ǰline���Ԫ�ظ���
		for (i = 0; i < Lenght; i++)
			if ((p->line[i] >= 'a' && p->line[i] <= 'z') || (p->line[i] >= 'A' && p->line[i] <= 'Z'))
				co++;
	} while ((p = p->next) != NULL);
	printf("����������ĸ������Ϊ:%d.\n",co);
	Display();
}

/*******************************************************
 *������:CountChinese(ESS*)
 *��  ��:ͳ�����������ĵĸ���
 *��  ��:ESS *h
 *����ֵ:��
 */
void CountChinese(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//���㵱ǰline���Ԫ�ظ���
		for (i = 0; i < Lenght; i++)
			if ((p->line[i] >= 1 && p->line[i] <= 254))	//
				co ++;
	} while ((p = p->next) != NULL);
	printf("�����������ĵ�����Ϊ:%d.\n",co/2);
	Display();
}

/*******************************************************
 *������:CountSpace(ESS*)
 *��  ��:ͳ�������пո�ĸ���
 *��  ��:ESS *h
 *����ֵ:��
 */
void CountSpace(ESS* h)
{
	ESS *p = h;
	int co = 0;
	int i;
	int Lenght;

	do
	{
		Lenght = strlen(p->line);	//���㵱ǰline���Ԫ�ظ���
		for (i = 0; i <Lenght; i ++)
			if (p->line[i] == 32)	//�ո��ASCII��Ϊ32
				co ++;
	} while ((p = p->next) != NULL);
	printf("�������пո������Ϊ:%d.\n",co);
	
	Display();
}

/*******************************************************
 *������:CountAll(ESS*)
 *��  ��:ͳ������������
 *��  ��:ESS* h
 *����ֵ:��
 */
void CountAll(ESS* h)
{
	ESS* p = h;
	int co = 0;
	
	do
	{
		co += strlen(p->line);		//ÿ�г����ۼ�Ϊ�����ܳ���
	} while ((p = p->next) != NULL);
	printf("������������Ϊ:%d.\n",co);
	Display();
}

/*******************************************************
 *������:FindString(ESS*)
 *��  ��:ͳ��������ָ���ַ������ֵĴ���
 *��  ��:ESS* h
 *����ֵ:��
 */
void FindString(ESS* h)
{
	ESS* p = h;
	int co = 0;
	int len1 = 0;			//���浱ǰline�����ַ���
	int len2;	//��ͳ���ַ����ĳ���
	int i,j,q;
	char str[20];
	printf("������Ҫͳ�Ƶ��ַ���:");
	getchar();
	gets(str);
	len2 = strlen(str);
	
	do
	{
		len1 = strlen(p->line);		//��ǰline���ַ���
		for (i = 0; i < len1; i++)	//�ַ�ƥ��
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
	printf("��������\"%s\"���ֵĴ���Ϊ:%d.\n",co);
	
	Display();
}

/*******************************************************
 *������:delstringword(char*, char*)
 *��  ��:�ڲ����ú���,��������ַ�����ɾ��ָ���ַ�
 *��  ��:char* s, char* str
 *����ֵ:��
 */
void delstringword(char* s, char* str)
{
	char *p = strstr(s, str);	//���ַ���s��Ѱ��str��һ�γ��ֵ�λ��
	char m[80];
	int len = strlen(s);
	int i = len - strlen(p);	//�Ƚ����ַ���֮����ַ�����
	int j = i + strlen(str);
	int k,n;
	int co = 0;

	for (k = 0; k < i; k ++)
		m[co ++] = s[k];
	for (n = j; n < len; n ++)
		m[co ++] = s[n];
	m[co] = '\0';
	strcpy(s,m);				//��ɾ������ַ�������ԭ�ַ���
}

/*******************************************************
 *������:DelString(ESS*, char*)
 *��  ��:����delstringword����,��ȫ�ĵ�ÿһ��ɾ��ָ���ַ���
 *��  ��:ESS* h, char* str
 *����ֵ:��
 */
void DelString(ESS* h)
{
	ESS *p = h;
	char str[20];
	printf("������Ҫɾ�����ַ���:");
	scanf("%s",str);
	do
	{
		if (strstr(p->line, str) != NULL)
			delstringword(p->line, str);	//����delstringword����ɾ��ÿ���ַ�,ֻɾһ��
	} while ((p = p->next) != NULL);
	printf("ɾ��%s�������Ϊ:\n",str);
	Out(p);
	
	Display();
}


/*******************************************************
 *������:main()
 *��  ��:������
 *��  ��:��
 *����ֵ:(int) 0
 */
int main()
{
	ESS* h;
	int opt;
	Create(h);
	while (true)
	{
		printf("ִ��ָ��:");
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
			printf("ָ���������\n\n");
			break;
		}
	}
		

	return 0;
}