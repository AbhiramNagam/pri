#include "stdio.h"
#include "stdlib.h"

struct node{
    struct node *left;
    int data;
    struct node *right;
};

void in_order(struct node *root){
    if(root->left==NULL && root->right==NULL){
        printf("%d ",root->data);
        return;
    }
    in_order(root->left);
    printf("%d ",root->data);
    in_order(root->right);
}

struct node *addNode(int data){
    struct node *new_node=(struct node*) malloc(sizeof(struct node));
    new_node->left=NULL;
    new_node->data=data;
    new_node->right=NULL;
    
    return new_node;
}

void post_order(struct node *root){
    if(root==NULL){
        return;
    }
    post_order(root->left);
    post_order(root->right);
    printf("%d ",root->data);
}

void pre_order(struct node *root){
    if(root->left==NULL && root->right==NULL){
        printf("%d ",root->data);
        return;
    }
    else{
        printf("%d ",root->data);
    }
    pre_order(root->left);
    pre_order(root->right);
}

void left_tree(struct node *root,int data){
    root->left=addNode(data);
}

void right_tree(struct node *root,int data){
    root->right=addNode(data);
}



int main(){
    struct node *root;
    root=addNode(1);
    left_tree(root,2);
    right_tree(root,3);
    
    left_tree(root->left,4);
    right_tree(root->left,5);
    
    left_tree(root->right,6);
    right_tree(root->right,7);
    
    printf("Pre order : ");
    pre_order(root);
    printf("\n");
    
    printf("Inorder : ");
    in_order(root);
    printf("\n");
    
    printf("Post order : ");
    post_order(root);
    printf("\n");
    
    return 0;
}
