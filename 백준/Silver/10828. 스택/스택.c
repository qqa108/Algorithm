#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 10000

typedef struct
{
  int data[MAX_STACK_SIZE];
  int top;
} StackType;

void init_stack(StackType *s)
{
  s->top = -1;
}
int is_empty(StackType *s)
{
  if(s->top==-1)
  {
    return 1;
  }
  else
  {
    return 0;
  }
  //return (s->top == -1);
}
int is_full(StackType *s)
{
  return (s->top == (MAX_STACK_SIZE - 1));
}
int size(StackType *s)
{
  return s->top+1;
}
void push(StackType *s, int item)
{
  if (is_full(s))
  {
    printf("스택 포화 에러\n");
    //return 0;
  }
  else
    s->data[++(s->top)] = item;
}
int pop(StackType *s)
{
  if (is_empty(s))
  {
    /*printf("스택 공백 에러\n");
    exit(1);*/
    return -1;
  }
  else
    return s->data[(s->top)--];
}
int peek(StackType *s)
{
  if (is_empty(s))
  {
    /*printf("스택 공백 에러\n");
    exit(1);*/
    return -1;
  }
  else
    return s->data[s->top];
}

int main()
{
  StackType s;
  char command[10];
  int *arr;
  int n;
  int i;
  int j=0;
  int k;

  init_stack(&s);
  scanf("%d", &n);
  arr = (int *)malloc(sizeof(int) * n);


  for(i=0; i<n; i++)
  {
    scanf("%s", command);

    if(strcmp(command, "push")==0)
    {
      scanf("%d", &k);
      push(&s,k);
    }
    else if(strcmp(command, "pop")==0)
    {
      arr[j++]=pop(&s);
    }
    else if(strcmp(command, "size")==0)
    {
      arr[j++]=size(&s);
    }
    else if(strcmp(command, "empty")==0)
    {
      arr[j++]=is_empty(&s);
    }
    else if(strcmp(command, "top")==0)
    {
      arr[j++]=peek(&s);
    }
    else
    {
      return 0;
    }
  }
  
  for (i = 0; i < j; i++)
  {
    printf("%d\n", arr[i]);
  }

  return 0;
}