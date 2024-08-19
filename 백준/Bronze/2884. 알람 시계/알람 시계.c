#include <stdio.h>

int main()
{
	int h = 23, m = 40;
	int sum = 0;

	scanf("%d %d", &h, &m);

	sum = 60 * h + m;
	sum = sum - 45;

	if (sum < 0)
	{
		sum = sum + 24 * 60;
	}
	h = sum / 60;
	m = sum % 60;

	printf("%d %d", h, m);

	return 0;
}