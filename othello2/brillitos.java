package othello2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class brillitos extends JFrame {
	int tam=10;
	public JButton[][] botones = new JButton[tam][tam];
	private static JPanel contentPane;
	static Tablero tablero = new Tablero();
	int turno=1;
	/**
	 * Create the frame.
	 */
	public brillitos() {
		tablero.iniciar();
		setTitle("Othellover2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Thomasito-sempai");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
	}public void iniciarBotones(){
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 8, 0, 0));
		buttonControler controlador = new buttonControler();
		for(int i=1;i<tam-1;i++) {
			for(int j=1;j<tam-1;j++) {
				this.botones[i][j] = new JButton("");
				this.botones[i][j].addActionListener(controlador);
				this.botones[i][j].setBackground(Color.white);
				
				this.botones[i][j].setVisible(true);
				panel.add(this.botones[i][j]);
			}
		}
	}
	public  void pintar() {
		int jugador=0;
		int matriz[][] = tablero.getTablero();
		if(turno%2==0){
			jugador=1;
		}else{jugador=2;}
		for(int i=1; i<tam;i++) {
			for(int j=1;j<tam;j++) {
				
				tablero.ponerFichasPosibles(i, j, jugador);

				if (matriz[i][j]==0) {
					if(botones[i][j]!=null) {
					this.botones[i][j].setBackground(Color.white);
					this.botones[i][j].setIcon(null);
					}
				}
				if (matriz[i][j]==1) {
					if(botones[i][j]!=null) {
					this.botones[i][j].setBackground(Color.red);
					}
				}
				if (matriz[i][j]==2) {
					if(botones[i][j]!=null) {
					this.botones[i][j].setBackground(Color.black);
					}
				}if (matriz[i][j]==3) {
					
						if(botones[i][j]!=null) {
							this.botones[i][j].setBackground(Color.gray);
					
						
					
				}if (matriz[i][j]==4) {
					
						if(botones[i][j]!=null) {
							this.botones[i][j].setBackground(Color.green);
					
						
					}
				}
				}
				}
			}
		}
public class buttonControler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int jugador=1, jugador2;
			boolean pasa=false;
			if(turno%2==0) {
				jugador=1;
				jugador2=2;
				for (int i=1;i<tam;i++) {
					for (int j=1;j<tam;j++) {
						if(e.getSource().equals(botones[i][j])) {
							tablero.borrarJugadas();
							
							if(tablero.sePuedeJugar(i, j, jugador)) {
								tablero.ponerFicha(i, j, jugador);
								tablero.sePuedeJugar(i, j, jugador);
								pintar();
								pintar();
								turno ++;
							}
							
						}
					}
				}for (int i=1;i<tam-1;i++) {
					for (int j=1;j<tam-1;j++) {
						pasa = pasa || tablero.sePuedeJugar(i, j, jugador);
					}
				}if (pasa==false) {
					turno++;
				}
				pintar();
				
			}if (turno%2!=0) {
				jugador2=1;
				jugador=2;
				
				for (int i=1;i<tam;i++) {
					for (int j=1;j<tam;j++) {
						if(e.getSource().equals(botones[i][j])) {
							tablero.borrarJugadas();
							if(tablero.sePuedeJugar(i, j, jugador)){
								tablero.sePuedeJugar(i, j, jugador);
								tablero.ponerFicha(i, j, jugador);
								pintar();
								turno ++;
							}
						}
					}
				}
				for (int i=1;i<tam-1;i++) {
					for (int j=1;j<tam-1;j++) {
						pasa = pasa || tablero.sePuedeJugar(i, j, jugador);
					}
				}if (pasa==false) {
					turno++;
				}
				pintar();
				
			}
			//terminar el juego
			/*if(tablero.GameOver()) {
				JOptionPane.showMessageDialog(contentPane, "GameOver \n Rojas :"+tablero.ContarNegras()+" \n Negras :"+tablero.ContarRojas());
			}*/for (int i=1;i<tam-1;i++) {
				for (int j=1;j<tam-1;j++) {
					pasa = pasa || tablero.sePuedeJugar(i, j, jugador);
					
					if (jugador==1) {
						jugador2=2;
					}else {
						jugador2=1;
					}
					pasa = pasa || tablero.sePuedeJugar(i, j, jugador2);
				}
			}if (pasa==false) {
				turno++;
				JOptionPane.showMessageDialog(contentPane, "GameOver \n Rojas :"+tablero.ContarNegras()+" \n Negras :"+tablero.ContarRojas());
			}
			
		}
		
	}
}
