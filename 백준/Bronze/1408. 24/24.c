#include <stdio.h>

int main()
{
	int sh, sm, ss, eh, em, es;
	int rh, rm, rs;
	char c;

	scanf(" %d%c%d%c%d", &sh, &c, &sm, &c, &ss);
	scanf(" %d%c%d%c%d", &eh, &c, &em, &c, &es);

	if (es < ss)
	{
		sm++;
		rs = (100 + es - ss);
		rs = rs - 40;
	}
	else
	{
		rs = es - ss;
	}

	if (em < sm)
	{
		sh++;
		rm = (100 + em - sm);
		rm = rm - 40;
	}
	else
	{
		rm = em - sm;
	}

	if (eh < sh)
	{
		rh = (eh - sh) + 24;
	}
	else
	{
		rh = eh - sh;
	}

	if (rh < 10)
	{
		printf("0%d:",rh);
	}
	else
	{
		printf("%d:", rh);
	}

	if (rm < 10)
	{
		printf("0%d:", rm);
	}
	else
	{
		printf("%d:", rm);
	}

	if (rs < 10)
	{
		printf("0%d\n", rs);
	}
	else
	{
		printf("%d\n", rs);
	}

	return 0;
}