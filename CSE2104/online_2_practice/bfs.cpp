#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int graph[5][5];
int status[5];

struct node
{
    int val;
    node *next;

    node(int x)
    {
        val = x;
        next = NULL;
    }
};
node *head;
bool isEmpty()
{
    if (head == NULL)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void enqueue(int val)
{
    node *n = new node(val);

    if (isEmpty()) // if the node is empty
    {
        // n->next = head;
        head = n;
        // cout << "Step 2 done" << endl;
    }
    else
    {
        // cout << "Step 3 done" << endl;
        node *temp = head;
        // finding the address of the last node which is saved in the second last node and adding the new node
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = n;
    }
}

int dequeue()
{
    int store = 0;
    node *newNode = head;
    if (head == NULL)
    {
        // printf("Empty Queue\n");
        return store;
    }
    else
    {

        store = newNode->val;
        head = newNode->next;
        delete newNode;
        return store;
    }
}

void inputGraph(int number_of_node, int number_of_edge)
{
    int source, destination, weight;
    weight = 1; // weight =1 as we are considering unweighted graph

    cout << "Enter the edges " << endl;
    for (int i = 1; i <= number_of_edge; i++)
    {
        cin >> source >> destination; // no need to scan weight as it is unweighted graph
        graph[source][destination] = weight;
        // graph[destination][source] = weight; // if directed graph there will be no need to add this line because edges will traverse in both direction
    }
}
void printAM(int N)
{
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cout << graph[i][j] << " ";
        }
        cout << endl;
    }
    cout << "\n\n";
}

void initStatus(int number_of_node)
{
    for (int i = 1; i <= number_of_node; i++)
    {
        status[i] = 1;
    }
}

void addNeighbors(int nodeN, int n)
{
    for (int i = 1; i <= n; i++)
    {
        if (graph[nodeN][i] == 1 && status[i] == 1)
        {
            enqueue(i);
            status[i] = 2;
        }
        
    }
}

void bfs(int source_node, int number_of_node)
{

    // cout << "BFS function"<< source<<n << endl;
    //! step 1
    initStatus(number_of_node);
    // cout << "Step 1 done" << endl;

    //! step 2
    head = NULL;
    //cout << "Value of is empty" << isEmpty() << endl;
    enqueue(source_node);
    status[source_node] = 2;

    // step 3
    while (!isEmpty())
    {
        // step 4
        int N; // do necessary things
        N = dequeue();
        cout << N << ">";
        status[N] = 3;

        // step 5
        addNeighbors(N, number_of_node);
    }
}

int main()
{

    int number_of_node, number_of_edge, source_node;

    cout << "Enter no of Node: " << endl;
    cin >> number_of_node;

    cout << "Enter no of Edge: " << endl;
    cin >> number_of_edge;

    cout << "Enter Source: " << endl;
    cin >> source_node;

    inputGraph(number_of_node, number_of_edge); // takes graph input
    //  printAM(number_of_node);                    // prints adjecency matrix
    bfs(source_node, number_of_node);

    return 0;
}

/*
1 4
1 5
4 2
5 2
2 3

*/

// status update
//  1 - unvisited
//  2 - visiting
//  3 - visited and in queue