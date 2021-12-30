
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartController {

	@FXML
	private AnchorPane StartPane;

	@FXML
	private Button Exit;

	@FXML
	private Button Start;

	@FXML
	private TextField MaxIterations;

	@FXML
	private TextField populationsize;

	@FXML
	private TextField Mutation_Chance;

	public void initialize() { // StartPane.setVisible(true); //
		/// populationsize.setText("10000"); /// Mutation_Chance.setText("0.5");
		// MaxIterations.setText("10000");
//		populationsize.setText("10000"); /// Mutation_Chance.setText("0.5");
//		 MaxIterations.setText("1000");
//		 Mutation_Chance.setText("0.05");
		
	}

	public void Start() throws Exception { // Main.NumberOfIterations =
		
	
		if (MaxIterations.getText().isEmpty()) {
			MaxIterations.equals(Main.NumberOfIterations);
		} else
			Integer.parseInt(MaxIterations.getText());
		if (populationsize.getText().isEmpty()) {
			populationsize.equals(Main.MaxGen);
		} else
			Integer.parseInt(populationsize.getText());
		if (Mutation_Chance.getText().isEmpty()) {
			Mutation_Chance.equals(Main.mutationChance);
		} else
			Double.parseDouble(Mutation_Chance.getText());

//  //Main.MaxGen =
//   //Main.mutationChance =
//  

		Main.startalgorithm();
		
				
				
				
				}
	@FXML
	void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AlgorithmGenerator.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();
			

		} catch (Exception e) {
			

		}
		
	}
			
}
