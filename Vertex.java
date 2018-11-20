/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diijkstra;
import java.util.LinkedList;

/**
 *
 * @author dtorres9
 */
public class Vertex {
	LinkedList<Vertex> adj;
	int data;
	int color;//0=white, 1=gray, 2=black
	int distance;//from start vertex
	Vertex parent;
	int discoveryTime;
	int finishTime;
	boolean extracted;
	
	public Vertex(int data){
		this.data=data;
		color=0;
		distance=-1;
		parent=null;
		adj = new LinkedList<>();
		discoveryTime=0;
		finishTime=0;
	}

}
