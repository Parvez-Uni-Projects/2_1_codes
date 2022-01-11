#include <iostream>
using namespace std;

struct node
{
    int data;
    node* next;

    node(int val)
    {
        data  = val;
        next = NULL;
    }
};

node* head;
int size;

void INSERT_F(int val)
{
    node* n = new node (val);
    n->next = head;
    head = n;
    size ++;

}
 
void INSERT_N(int pos, int val)
{
    //write your code from below this line with proper indentation
    if (pos <1 || pos > size +1 )
    {
        cout << "Invalid"
    }

    size ++;
}
void INSERT_L(int val)
{
    node* n = new node(val);

    if (head == NULL)
    {
        INSERT_F(val);
    }
    else 
    {
        node* temp = head;

        while (temp->next != NULL)
        {
        temp = temp-> next;
        }
        temp-> next = n;

    }
    size ++;


}

void DELETE_F()
{
    //write your code from below this line with proper indentation
    node* to_delete= head;
    head = head->next;
    delete to_delete;
}
void DELETE_N(int position)
{
    //write your code from below this line with proper indentation
    node* temp = head;
    int i =1;

    if (head == NULL)
    {
        return;
    }
    else if (head->next == NULL)
    {
        DELETE_F();
        return;
    }

    while( i +1 != position)
    {
        temp = temp->next;
        i++;
    }
    node* to_delete = temp->next;
    temp->next = temp->next->next;

    delete to_delete;

}
void DELETE_L()
{
    //write your code from below this line with proper indentation

    if (head == NULL)
    {
        return;
    }
    else if (head->next == NULL)
    {
        delete head;
        return;
    }

    node* temp = head;

    while(temp->next->next != NULL)
    {
        temp = temp->next;
    }
    delete temp->next;
    temp->next = NULL;

}
int SEARCH(int val)
{
    node* temp = head;
    int i = 1;

    while(temp != NULL)
    {   
      
        if (temp->data == val)
        {
            return i;
        }
        temp = temp->next;
          i++;
    }

    return -1;
    
}
void PRINT()
{
    //write your code from below this line with proper indentation

    node* temp = head;

    while ( temp != NULL)
    {
        cout << temp ->data << "->";
        temp= temp->next;
    }

}
int main()
{
    
    head = NULL;

    INSERT_L(1);
    INSERT_L(2);
    INSERT_L(3);
    INSERT_F(4);
    INSERT_F(5);


    PRINT();
    int position = SEARCH(2);

    cout<< "The position is 1 is found at " << position << endl; 
    //DELETE_N(3);
    DELETE_F();
    DELETE_L();
    PRINT();
    


   // int x,n;

    // while(true)
    // {
      
      

    //     cout << "1. Insert First\n2. Insert N\n3. Insert Last\n4. Delete First\n5. Delete N\n6. Delete Last\n7. Print\n8. Search\n9. Exit\n"<<endl;

    //     cout << "Enter Choice: "<<endl;
    //     int ch;
    //     cin >> ch;
        

    //     switch(ch)
    //     {
    //     case 1:
    
    //         cout <<"\n Enter value: "<<endl;
    //         cin>>x;

    //         INSERT_F(x);
    //         PRINT(node);
    //         break;
    //     case 2:
            
            
    //         cout <<"\n Enter value, position: "<<endl;
    //         cin>>x;
    //         cin>>n;

    //         INSERT_N(x,n);
    //         break;
    //     case 3:
    //          cout <<"\n Enter value: "<<endl;
    //          cin>>x;

    //         INSERT_L(x);
    //         break;
    //     case 4:
    //         DELETE_F();
    //         break;
    //     case 5:
            
    //         cout << "\nEnter a position: " <<endl;
    //         cin >> n;
    //         DELETE_N(n);
    //         break;
    //     case 6:
    //         DELETE_L();
    //         break;
    //     case 7:
    //         PRINT();
    //         break;
    //     case 8:
    //         cout <<"\n Enter value: "<<endl;
    //         cin>>x;
    //         cout << "\n Value found at position " << SEARCH(x);
    //         break;

    //     case 9:
    //         return 0;
    //         break;
    //     default:
    //         continue;
    //     }
    // }

    return 0;
}
