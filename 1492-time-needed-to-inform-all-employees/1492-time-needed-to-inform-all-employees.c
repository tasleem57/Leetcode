struct node{
    int data;
    struct node *next;
};

struct graph{
    struct node *head;
};

struct node *create(int data){
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = data;
    newnode->next = NULL;
    return newnode; 
}

void addEdge(struct graph **g, int src, int dest){
    struct node *temp=g[src]->head;
    struct node *newnode = create(dest);
    
    if(!temp)
        g[src]->head = newnode;
    else{
        while(temp->next){
            temp = temp->next;
        }
        
        temp->next = newnode;
    }
    
}//addEdge

int max(int a, int b){
    return a>b?a:b;
}//max

void dfs(struct graph **g, int start, int *visited, int *informTime,int size, int ans, int *countTime){
    if(!g[start]->head || start>=size)
        return;
    
    visited[start] = 1;    
    (*countTime) = max(ans, *countTime);
    
    struct node *temp = g[start]->head;
    while(temp){
        if(visited[temp->data]==0){
            dfs(g, temp->data, visited, informTime, size, ans+informTime[temp->data], countTime);
        }
        temp = temp->next;
    }
    
}

int numOfMinutes(int n, int headID, int* manager, int managerSize, int* informTime, int informTimeSize){
	
	int *visited = (int *)malloc(sizeof(int) * n);
	memset(visited, 0, sizeof(int) * n);
	
	struct graph **g = (struct graph **)malloc(sizeof(struct graph *) * n);
    for(int i=0; i<n; i++){
        g[i] = (struct graph *)malloc(sizeof(struct graph));
        g[i]->head = NULL;
    }
    
	for(int i=0;i<managerSize;i++){
	    if(manager[i]!=-1){
	        addEdge(g, manager[i], i);
	    }
	}
	
	// print(g, n);
    int countTime=0;
	dfs(g, headID, visited, informTime, informTimeSize, informTime[headID], &countTime);
	return countTime;
}