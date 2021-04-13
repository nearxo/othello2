package othello2;

public class Tablero {
	int tam=10;
	private int tablero[][] = new int [tam][tam];
	
	public int[][] getTablero() {
		return tablero;
	}
	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	
	public Tablero() {
		this.tablero= new int [tam][tam];
		this.tablero[4][4]=1;
		this.tablero[5][5]=1;
		this.tablero[4][5]=2;
		this.tablero[5][4]=2;
		
		
	}
	public void iniciar() {
		this.tablero[4][4]=1;
		this.tablero[5][5]=1;
		this.tablero[4][5]=2;
		this.tablero[5][4]=2;
	}
	public void borrarJugadas() {
		for(int i=0; i<tam;i++) {
			for(int j=0;j<tam;j++) {
				if(this.tablero[i][j]==3||this.tablero[i][j]==4) {
					this.tablero[i][j]=0;
				}
				
			}
		}
	}
public boolean GameOver() {
	boolean gameover=true;
	int contador=0;
	for (int i=1;i<tam-1;i++) {
		for (int j=1;j<tam-1;j++) {
			gameover = gameover && (this.tablero[i][j]==1||this.tablero[i][j]==2);
			if(this.tablero[i][j]==1) {
				contador++;
			}
			if(this.tablero[i][j]==2) {
				contador++;
			}
		}
	}
	
	return gameover;
}
public int ContarRojas() {
	int contador=0;
	for (int i=1;i<tam;i++) {
		for (int j=1;j<tam;j++) {
			if(this.tablero[i][j]==1) {
				contador++;
			}
		}
	}
	
	return contador;
}
public int ContarNegras() {
	
	int contador=0;
	for (int i=1;i<tam;i++) {
		for (int j=1;j<tam;j++) {
	
			if(this.tablero[i][j]==2) {
				contador++;
			}
		}
	}
	return contador;
}
public boolean sePuedeJugar (int x, int y,int jugador){ 
	try{
	boolean siSePuede=false;
	int NFichas=1, jugador2;
	if (jugador==1) {
		jugador2=2;
	}else {
		jugador2=1;
	}
	if(this.tablero[x][y]==0||this.tablero[x][y]==3||this.tablero[x][y]==4) {
		
			if(this.tablero[x+1][y]==jugador2) {
				NFichas=1;
				while(this.tablero[x+NFichas][y]==jugador2) {
					NFichas++;
				}
				if(this.tablero[x+NFichas][y]==jugador) {
					siSePuede=true;
					this.tablero[x][y]=jugador+2;
				}
			}
		
		
			if(this.tablero[x][y+1]==jugador2) {
				NFichas=1;
			while(this.tablero[x][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x][y+NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
				
			}
		}
		
		
			if(this.tablero[x+1][y+1]==jugador2) {
				NFichas=1;
			while(this.tablero[x+NFichas][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x+NFichas][y+NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
				
			}
		}
		
		
			if(this.tablero[x-1][y]==jugador2) {
				NFichas=1;
			while(this.tablero[x-NFichas][y]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
				
			}
		}
		
		
			if(this.tablero[x][y-1]==jugador2) {
				NFichas=1;
			while(this.tablero[x][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x][y-NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
				
			}
		}
		
		
			if(this.tablero[x-1][y-1]==jugador2) {
				NFichas=1;
			while(this.tablero[x-NFichas][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y-NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
			}
		}
		

		
			if(this.tablero[x+1][y-1]==jugador2) {
				NFichas=1;
			while(this.tablero[x+NFichas][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x+NFichas][y-NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
				
			}
		}
		

		
			if(this.tablero[x-1][y+1]==jugador2) {
				NFichas=1;
			while(this.tablero[x-NFichas][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y+NFichas]==jugador) {
				siSePuede=true;
				this.tablero[x][y]=jugador+2;
			}
		}
		
		
			return siSePuede;
		
	}else{return false;}
	}catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	}
	
public void ponerFicha (int x, int y,int jugador) {
	int NFichas=1, jugador2;
	if (jugador==1) {
		jugador2=2;
	}else {
		jugador2=1;
	}
	if(this.tablero[x][y]==0||this.tablero[x][y]==3||this.tablero[x][y]==4) {
		if(this.tablero[x+1][y]==jugador2) {
		NFichas=1;
		while(this.tablero[x+NFichas][y]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x+NFichas][y]==jugador) {
			for(int i=0;i<NFichas;i++){this.tablero[x+i][y]=jugador;}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x][y+1]==jugador2) {
		NFichas=1;
		while(this.tablero[x][y+NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x][y+NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){this.tablero[x][y+i]=jugador;}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x+1][y+1]==jugador2) {
		NFichas=1;
		while(this.tablero[x+NFichas][y+NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x+NFichas][y+NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){this.tablero[x+i][y+i]=jugador;}
			this.tablero[x][y]=jugador;
			
		}
	}
	if(this.tablero[x-1][y]==jugador2) {
		NFichas=1;
		while(this.tablero[x-NFichas][y]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x-NFichas][y]==jugador) {
			
			for(int i=0;i<NFichas;i++){this.tablero[x-i][y]=jugador;}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x][y-1]==jugador2) {
		NFichas=1;
		while(this.tablero[x][y-NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x][y-NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){this.tablero[x][y-i]=jugador;}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x-1][y-1]==jugador2) {
		NFichas=1;
		while(this.tablero[x-NFichas][y-NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x-NFichas][y-NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){
				if(this.tablero[x-i][y-i]==jugador2) {this.tablero[x-i][y-i]=jugador;}}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x+1][y-1]==jugador2) {
		NFichas=1;
		while(this.tablero[x+NFichas][y-NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x+NFichas][y-NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){
				if(this.tablero[x+i][y-i]==jugador2) {this.tablero[x+i][y-i]=jugador;}
				}
			this.tablero[x][y]=jugador;
		}
	}
	if(this.tablero[x-1][y+1]==jugador2) {
		NFichas=1;
		while(this.tablero[x-NFichas][y+NFichas]==jugador2) {
			NFichas++;
		}
		if(this.tablero[x-NFichas][y+NFichas]==jugador) {
			
			for(int i=0;i<NFichas;i++){
				if(this.tablero[x-i][y+1]==jugador2) {
					this.tablero[x-i][y+1]=jugador;
				}
				
			}
			this.tablero[x][y]=jugador;
		}
	}
	}
	
}
public void ponerFichasPosibles (int x, int y,int jugador){ 
	
		int NFichas=1, jugador2;
		if (jugador==1) {
			jugador2=2;
		}else {
			jugador2=1;
		}

	if(this.tablero[x][y]==0||this.tablero[x][y]==3||this.tablero[x][y]==4) {
			if(this.tablero[x+1][y]==jugador2) {
			NFichas=1;
			while(this.tablero[x+NFichas][y]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x+NFichas][y]==jugador) {
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x][y+1]==jugador2) {
			NFichas=1;
			while(this.tablero[x][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x][y+NFichas]==jugador) {
				
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x+1][y+1]==jugador2) {
			NFichas=1;
			while(this.tablero[x+NFichas][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x+NFichas][y+NFichas]==jugador) {
				this.tablero[x][y]=jugador+2;
				
			}
		}
		if(this.tablero[x-1][y]==jugador2) {
			NFichas=1;
			while(this.tablero[x-NFichas][y]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y]==jugador) {
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x][y-1]==jugador2) {
			NFichas=1;
			while(this.tablero[x][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x][y-NFichas]==jugador) {
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x-1][y-1]==jugador2) {
			NFichas=1;
			while(this.tablero[x-NFichas][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y-NFichas]==jugador) {
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x+1][y-1]==jugador2) {
			NFichas=1;
			while(this.tablero[x+NFichas][y-NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x+NFichas][y-NFichas]==jugador) {
				this.tablero[x][y]=jugador+2;
			}
		}
		if(this.tablero[x-1][y+1]==jugador2) {
			NFichas=1;
			while(this.tablero[x-NFichas][y+NFichas]==jugador2) {
				NFichas++;
			}
			if(this.tablero[x-NFichas][y+NFichas]==jugador) {
				
				this.tablero[x][y]=jugador+2;
			}
		}
		}
	
	}
}
