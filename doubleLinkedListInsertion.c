#include "stdio.h"
#include "stdlib.h"

struct node{
	struct node *prev;
	int data;
	struct node *next;
};

struct node *head=NULL,*tail=NULL;

void addNode(int n){
	struct node *newnode=(struct node*) malloc(sizeof(struct node));
	newnode->data=n;
	newnode->next=NULL;
	if(head==NULL){
		head=newnode;
		tail=newnode;
		newnode->prev=NULL;
	}
	else{
		tail->next=newnode;
		newnode->prev=tail;
		tail=newnode;
	}
}
void insertAtTheBeginning(int n){
	struct node *newnode=(struct node*) malloc(sizeof(struct node));
	newnode->data=n;
	newnode->next=head;
	head->prev=newnode;
	newnode->prev=NULL;
	head=newnode;
}

void displayList(){
	struct node *p=head;
	printf("\n The data in the linked list is : ");
	while(p->next!=NULL){
		printf("%d ",p->data);
		p=p->next;
	}
	printf("%d ",p->data);
	printf("\n");
}

void insertAtIndex(int n,int index){
	struct node *p=head;
	index-=1;
	while (index--){
		p=p->next;
	}
	struct node *newnode=(struct node*) malloc(sizeof(struct node));
	p->next->prev=newnode;
	newnode->next=p->next;
	p->next=newnode;
	newnode->data=n;
	newnode->prev=p;
}

int main(){
	int choice,n,index;
    while (1==1){
        printf("Choose from the following\n");
        printf("1 : Insert At The End\n");
        printf("2 : Insert At The Beginning\n");
        printf("3 : Insert At an index\n");
        printf("4 : Display The LinkedList\n");
        printf("5 : To Quit\n");
        scanf("%d",&choice);
        if(choice==1 || choice==2 || choice==3){
        	printf("Enter the data : ");
        	scanf("%d",&n);
        	if(choice==1){
        		addNode(n);
        	}
        	else if(choice==2){
        		insertAtTheBeginning(n);
        	}
        	else if(choice==3){
        		printf("Enter the index to insert the node at : ");
        		scanf("%d",&index);
        		if(index==0)
        			insertAtTheBeginning(n);
        		else
        			insertAtIndex(n,index);
        	}
        }
        else if(choice==4){
        	displayList();
        }
        else if(choice==5){
        	break;
        }
        else{
        	printf("Enter a valid input\n");
        }
            
        printf("-------------------------------\n");
    }
    return 0;
}
