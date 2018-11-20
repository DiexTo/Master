/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diijkstra;
    import java.util.Scanner;

/**
 *
 * @author dtorres9
 */
public class Dijkstra extends Graph{
	int e;//no of edges
	int[][] weight;
	
	public Dijkstra(int v, int e){
		super(v);
		weight = new int[v+1][v+1];
	}
	
	void relax(int u, int v, int w){
		if(vertex[v].distance > vertex[u].distance+w){
			vertex[v].distance = vertex[u].distance+w;
			vertex[v].parent = vertex[u];
		}
	}
	
	void dijkstra(int start){
		initialize();
		vertex[start].extracted=true;
		vertex[start].distance = 0;
		int u = start;
		while(u!=-1){
			for(Vertex ver : vertex[u].adj){
				relax(u,ver.data,weight[u][ver.data]);
			}
			u = extractMin();
		}
				
	}
	
	void initialize(){
		for(int i = 0; i<v; i++){
			vertex[i].distance = Integer.MAX_VALUE;
		}
	}
	
	void addEdge(int u, int v, int w){//directed
		vertex[u].adj.add(vertex[v]);
		weight[u][v] = w;
	}
	
	int extractMin(){
		int index = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<v; i++){
			if(!vertex[i].extracted && vertex[i].distance<min){
				index = i;
				min = vertex[i].distance;
			}
		}
		if(index!=-1)
			vertex[index].extracted = true;
		return index;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//no vertex
		int m = sc.nextInt();//no of edges
		Dijkstra g = new Dijkstra(n,m);
		
		for(int i = 0; i<m; i++){
			g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		g.dijkstra(0);
		for(int i = 0; i<g.v; i++)
			System.out.println("Vertex: "+i+" Distance: "+g.vertex[i].distance);
		sc.close();
	}
}

