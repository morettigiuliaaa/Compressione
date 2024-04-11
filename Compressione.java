package it.edu.iisgubbio.tpsit.Compressione;
import java.util.Hashtable;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Compressione extends Application {
	char matrice [][]= new char [3][3];	
	TextField tCompresso = new TextField();
	TextField tNonCompresso = new TextField();
	TextField tPercentuale = new TextField();
	Label eCompresso = new Label("Compresso");
	Label eNonCompresso = new Label("Non compresso");
	Label ePercentuale = new Label("percentuale compress.");
	Button calcola= new Button("calcola");
	GridPane griglia = new GridPane();
	Hashtable<Integer,Integer> my_dict = new Hashtable<Integer,Integer>();
	public void start(Stage primaryStage) {
	
		
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		my_dict.put(1,1);
		my_dict.put(2,2);
		my_dict.put(3,2);
		my_dict.put(4,3);
		my_dict.put(5,3);
		my_dict.put(6,3);
		my_dict.put(7,3);
		
		matrice[0][0]='v';
		matrice[0][0]='b';
		matrice[0][0]='b';
		matrice[0][0]='g';
		matrice[0][0]='g';
		matrice[0][0]='g';
		matrice[0][0]='b';
		matrice[0][0]='v';
		matrice[0][0]='g';
		

		griglia.add(eCompresso, 0, 0);
		griglia.add(eNonCompresso, 0, 1);
		griglia.add(ePercentuale, 0, 2);
		griglia.add(tCompresso, 1, 0);
		griglia.add(tNonCompresso, 1, 1);
		griglia.add(tPercentuale, 1, 2);
		griglia.add(calcola, 0, 4);

		calcola.setOnAction(e -> controlla());
		
		Scene scena = new Scene(griglia, 400, 270);
		primaryStage.setTitle("Compressione");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void controlla() {
		int v[]=new int [matrice.length];
		double numeroCompresso=matrice[0].length*matrice.length*24;
		tCompresso.setText(numeroCompresso+"");
		int contatore=1;
		int compresso=0;
		
		for (int righe= 0;righe<matrice.length; righe++, contatore=1) {
			for (int colonne=0; colonne<matrice.length;colonne++) {
				if (matrice[colonne-1][righe]==matrice[colonne][righe]) {
					contatore++;
				}else {
					v[righe]+=my_dict.get(contatore)+24;
				}
			}
			v[righe]+=my_dict.get(contatore)+24;
		}
		for (int a=0;a<v.length;a++) {
			compresso+=v[a];
		}
		tCompresso.setText(compresso+"");
		
		double perCompresso=compresso/numeroCompresso*100;
		double meno100=100-perCompresso;
		tPercentuale.setText(""+meno100);
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
