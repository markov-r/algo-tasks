import java.util.*;                                                                                                          
                                                                                                                             
public class Main {                                                                                                          
    static class Edge {                                                                                                      
        int source;                                                                                                          
        int destination;                                                                                                     
        int weight;                                                                                                          
                                                                                                                             
        Edge(int source, int destination, int weight) {                                                                      
            this.source = source;                                                                                            
            this.destination = destination;                                                                                  
            this.weight = weight;                                                                                            
        }                                                                                                                    
    }                                                                                                                        
                                                                                                                             
    static class Graph {                                                                                                     
        int vertices;                                                                                                        
        ArrayList<Edge> allEdges = new ArrayList<>();                                                                        
                                                                                                                             
        Graph(int vertices) {                                                                                                
            this.vertices = vertices;                                                                                        
        }                                                                                                                    
                                                                                                                             
        void addEgde(int source, int destination, int weight) {                                                              
            Edge edge = new Edge(source, destination, weight);                                                               
            allEdges.add(edge);                                                                                              
        }                                                                                                                    
                                                                                                                             
        void kruskalMST() {                                                                                                  
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));           
            pq.addAll(allEdges);                                                                                             
            int[] parent = new int[vertices];                                                                                
            for (int i = 0; i < vertices; i++) {                                                                             
                parent[i] = i;                                                                                               
            }                                                                                                                
            List<Edge> mst = new ArrayList<>();                                                                              
            int index = 0;                                                                                                   
            while (index < vertices - 1) {                        // process vertices - 1 edges                              
                Edge edge = pq.remove();                                                                                     
                int x_set = find(parent, edge.source);                                                                       
                int y_set = find(parent, edge.destination);                                                                  
                                                                                                                             
                if (x_set != y_set) {   // check for cycle                                                                   
                    mst.add(edge);                                                                                           
                    index++;                                                                                                 
                    union(parent, x_set, y_set);                                                                             
                }                                                                                                            
            }                                                                                                                
            System.out.println("Minimum Spanning Tree: ");                                                                   
            printGraph(mst);                                                                                                 
        }                                                                                                                    
                                                                                                                             
        int find(int[] parent, int vertex) {                      // chain of parent pointers from x upwards through the tree
            if (parent[vertex] != vertex) {                       // until an element is reached whose parent is itself      
                return find(parent, parent[vertex]);                                                                         
            }                                                                                                                
            return vertex;                                                                                                   
        }                                                                                                                    
                                                                                                                             
        void union(int[] parent, int x, int y) {                                                                             
            int x_set_parent = find(parent, x);                                                                              
            int y_set_parent = find(parent, y);                    //make x as parent of y                                                                                          
                                                                              
            parent[y_set_parent] = x_set_parent;                                                                             
        }                                                                                                                    
                                                                                                                             
        void printGraph(List<Edge> edgeList) {                                                                               
            for (int i = 0; i < edgeList.size(); i++) {                                                                      
                Edge edge = edgeList.get(i);                                                                                 
                System.out.println("Edge-" + i + " source: " + edge.source +                                                 
                        " destination: " + edge.destination +                                                                
                        " weight: " + edge.weight);                                                                          
            }                                                                                                                
        }                                                                                                                    
    }                                                                                                                        
                                                                                                                             
    public static void main(String[] args) {                                                                                 
        int vertices = 6;                                                                                                    
        Graph graph = new Graph(vertices);                                                                                   
        graph.addEgde(0, 1, 4);                                                                                              
        graph.addEgde(0, 2, 3);                                                                                              
        graph.addEgde(1, 2, 1);                                                                                              
        graph.addEgde(1, 3, 2);                                                                                              
        graph.addEgde(2, 3, 4);                                                                                              
        graph.addEgde(3, 4, 2);                                                                                              
        graph.addEgde(4, 5, 6);                                                                                              
        graph.kruskalMST();                                                                                                  
    }                                                                                                                        
}                                                                                                                            