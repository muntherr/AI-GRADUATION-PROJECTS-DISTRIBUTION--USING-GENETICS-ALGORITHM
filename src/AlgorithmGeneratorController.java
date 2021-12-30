
import javafx.fxml.FXML;

import javafx.scene.control.TreeTableColumn;

import javafx.scene.layout.AnchorPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;


public class AlgorithmGeneratorController implements Initializable{
	@FXML
	private AnchorPane StartPane;
	@FXML
	private  TableView <Object> AllTable;
	@FXML
	private TableColumn <ViewT, String> Chromosomeid;
	@FXML
	private TableColumn <ViewT,String> Geneid;
	@FXML
	private TableColumn <ViewT,String> Fittness;

	@FXML
	private Button View ;
	@FXML
	private  Label Gene ;
	@FXML
	private  TextField fitnessout ;
	@FXML
	private  TextField n1 ;
	@FXML
	private  TextField n2 ;
	@FXML
	private  TextField n3;
	@FXML
	private  TextField n4 ;
	@FXML
	private  TextField n5 ;
	@FXML
	private  TextField n6 ;
	@FXML
	private  TextField n7 ;
	@FXML
	private  TextField n8 ;
	@FXML
	private  TextField n9 ;
	@FXML
	private  TextField n10 ;
	@FXML
	private  TextField n11 ;
	@FXML
	private  TextField n12 ;
	@FXML
	private  TextField n13 ;
	@FXML
	private  TextField n14 ;
	@FXML
	private  TextField n15 ;
	@FXML
	private  TextField n16 ;
	@FXML
	private  TextField n17 ;
	@FXML
	private  TextField n18 ;
	@FXML
	private  TextField n19 ;
	@FXML
	private  TextField n20 ;
	@FXML
	private  TextField n21 ;
	@FXML
	private  TextField n22 ;
	@FXML
	private  TextField n23 ;
	@FXML
	private  TextField n24 ;
	@FXML
	private  TextField n25 ;
	@FXML
	private  TextField n26 ;
	@FXML
	private  TextField n27 ;
	@FXML
	private  TextField n28 ;
	@FXML
	private  TextField n29 ;
	@FXML
	private  TextField n30 ;
	@FXML
	private  TextField n31 ;
	@FXML
	private  TextField n32 ;
	@FXML
	private  TextField n33 ;
	@FXML
	private  TextField n34 ;
	@FXML
	private  TextField n35 ;
	@FXML
	private  TextField n36 ;
	@FXML
	private  TextField Fitnes ;
	@FXML
	private  TextField F1 ;
	@FXML
	private  TextField F2 ;
	@FXML
	private  TextField F3 ;

	
	
	 ObservableList<Object> ChromosomeList = FXCollections.observableArrayList();

	public static ArrayList <Chromosome> k = new ArrayList<Chromosome>();
	public static ArrayList <Integer> kw = new ArrayList<Integer>();
	
	ObservableList<Integer> FitnessList = FXCollections.observableArrayList();
	public static ArrayList<Integer> Fitness = new ArrayList<Integer>();
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	//	Chromosome P1 = new Chromosome(kw , 1 ,3 ,4 ,5);
		

		Chromosome P1 = Main.F;
		ChromosomeList.clear();
         //for creating the table for comparison
        // for (int i = 0; i < P1.si; i++) {
		ArrayList <Integer> index =  new ArrayList<Integer>();
		
		for (int i = 0 ; i < 36 ; i++) {
			index.add(i, i+1);
	}
		ViewT o  = new ViewT(null, index, 0 ,0,0,0);
		o.setInd(index);
		
       
		ChromosomeList.add(new ViewT(P1.getGenes(),o.getInd(),P1.getfitness(),P1.getf1(),P1.getf2(),P1.getf3()));
		System.out.println(o.getInd().get(2));

		//Geneid.setCellValueFactory(new PropertyValueFactory<ViewT, String>("genes"));
		//Fittness.setCellValueFactory(new PropertyValueFactory<ViewT, String>("ind"));
	
		
		//AllTable.setItems(ChromosomeList);
	
		n1.setText(P1.getGenes().get(0).toString());
		n2.setText(P1.getGenes().get(1).toString());
		n3.setText(P1.getGenes().get(2).toString());
		n4.setText(P1.getGenes().get(3).toString());
		n5.setText(P1.getGenes().get(4).toString());
		n6.setText(P1.getGenes().get(5).toString());
		n7.setText(P1.getGenes().get(6).toString());
		n8.setText(P1.getGenes().get(7).toString());
		n9.setText(P1.getGenes().get(8).toString());
		n10.setText(P1.getGenes().get(9).toString());
		n11.setText(P1.getGenes().get(10).toString());
		n12.setText(P1.getGenes().get(11).toString());
		n13.setText(P1.getGenes().get(12).toString());
		n14.setText(P1.getGenes().get(13).toString());
		n15.setText(P1.getGenes().get(14).toString());
		n16.setText(P1.getGenes().get(15).toString());
		n17.setText(P1.getGenes().get(16).toString());
		n18.setText(P1.getGenes().get(17).toString());
		n19.setText(P1.getGenes().get(18).toString());
		n20.setText(P1.getGenes().get(19).toString());
		n21.setText(P1.getGenes().get(20).toString());
		n22.setText(P1.getGenes().get(21).toString());
		n23.setText(P1.getGenes().get(22).toString());
		n24.setText(P1.getGenes().get(23).toString());
		n25.setText(P1.getGenes().get(24).toString());
		n26.setText(P1.getGenes().get(25).toString());
		n27.setText(P1.getGenes().get(26).toString());
		n28.setText(P1.getGenes().get(27).toString());
		n29.setText(P1.getGenes().get(28).toString());
		n30.setText(P1.getGenes().get(29).toString());
		n31.setText(P1.getGenes().get(30).toString());
		n32.setText(P1.getGenes().get(31).toString());
		n33.setText(P1.getGenes().get(32).toString());
		n34.setText(P1.getGenes().get(33).toString());
		n35.setText(P1.getGenes().get(34).toString());
		n36.setText(P1.getGenes().get(35).toString());
		Fitnes.setText(P1.getfitness()+"");
		F1.setText(P1.getf1()+"");
		F2.setText(P1.getf2()+"");
		F3.setText(P1.getf3()+"");
//	
//		
		System.out.println(":::::::");
		
//		for (Integer number : numbers) {
//		  sb.append(number != null ? number.toString() : "");
//		}
//		
//		
		//String Ge =Ge.join(",",P1.getGenes());
		//Gene.setText(Ge);
		
		
//		ObservableValue<Integer> obsInt = new SimpleIntegerProperty(P1.getf1()).asObject();
//
//		
//		Chromosomeid.setCellValueFactory(new PropertyValueFactory<Chromosome,Integer>("f1"));
//		
//		//Chromosomeid.setCellValueFactory(cellData -> new SimpleStringProperty(Chromosome.class.getSimpleName()));
//		System.out.println(ChromosomeList.get(0).getfitness());
//
//		Geneid.setCellValueFactory(new PropertyValueFactory<>("f1"));
//		Geneid.setCellValueFactory(cellData ->cellData.getValue().getfitness().as);
//
//		
//		
//		Fitnessidd.setCellValueFactory(new PropertyValueFactory<>("f2"));
		//AllTable.setItems(ChromosomeList);
		//Chromosomeid.setCellValueFactory(data -> new SimpleStringProperty(P1.getfitness()));
	}
public  Chromosome re (Chromosome d) {
	//openlist(d);
	return d;
	
}
}
