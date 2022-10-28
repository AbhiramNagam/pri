void deleteFromBeginning(){
	struct node *p=head;
	struct node *del=p;
	p=p->next;
	free(del);
}

void deleteFromTheEnd(){
	struct node *p=tail;
	tail=p->prev;
	free(p);
	tail->next=NULL;
}
