package projeto;

public class algoritimo {
	static class Grafo{
        int postes;
        int cabo[][];
   
        public Grafo(int vertices){
            this.postes = vertices;
            cabo = new int[vertices][vertices];
        }
        public void add_caminho(int origem, int destino, int peso) {
            cabo[origem][destino]=peso;
            cabo[destino][origem]=peso;
        }
        class Resultado {
            int ponto;
            int distancia;
        }
        int min_dist( boolean [] mst, int [] distancias){
            int min_dist = Integer.MAX_VALUE;
            int vertice = -1;

            for (int i = 0; i < postes; i++) {
                if (mst[i]== false && min_dist > distancias [i]) {
                	min_dist =distancias [i];
                    vertice = i;
                }
            }
            return vertice;
        }
        public void mst() {
            boolean [] mst = new boolean[postes];
            int [] distancia = new int [postes];
            Resultado [] resultado = new Resultado [postes];

            for (int i = 0; i < postes; i++) {
                distancia[i] = Integer.MAX_VALUE;
                resultado[i] = new Resultado();
            }
            distancia[0]=0;
            resultado[0].ponto=-1;
            for (int i = 0; i < postes; i++) {
                int vertice = min_dist(mst, distancia);
                mst[vertice]= true;
                for (int j = 0; j < postes; j++) {
                    if (cabo[vertice][j]>0) {
                        if (mst[j]==false && cabo[vertice][j]< distancia[j]) {
                            distancia[j] = cabo[vertice][j];
                            resultado[j].ponto=vertice;
                            resultado[j].distancia = distancia[j];
                        }                        
                    }                                        
                }                
            }
            printMst(resultado);
        }
        public void printMst( Resultado [] resultado ) {
            int caminho_minimo_total = 0;
            System.out.println("Árvore de cobertura mínima: ");
            System.out.println("----------------------------");
            for (int i = 1; i < postes; i++) {
                System.out.println("Aresta " + i + " - " + resultado[i].ponto + " distancia: " + resultado[i].distancia);
                caminho_minimo_total +=resultado[i].distancia;
            }
            System.out.println("----------------------------");
            System.out.println("Caminho Minimo Total: " + caminho_minimo_total); 
        }
    }

        public static void main(String[] args) {
            int vertices = 6;
            Grafo grafo = new Grafo(vertices);
            grafo.add_caminho(0, 1, 15);
	        grafo.add_caminho(0, 2, 11);
	        grafo.add_caminho(1, 4, 35);
	        grafo.add_caminho(1, 2, 35);
	        grafo.add_caminho(2, 4, 15);
	        grafo.add_caminho(2, 3, 22);
	        grafo.add_caminho(2, 5, 100);
	        grafo.add_caminho(5, 4, 90);
	        grafo.mst();
    }

}