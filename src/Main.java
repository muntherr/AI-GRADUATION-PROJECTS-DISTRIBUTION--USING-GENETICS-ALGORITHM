
//1182028 Muntherr anati
//1182523 Yasmin Shadi
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static public double mutationChance = 0.05;
	static public int MaxGen = 1000;
	static public int NumberOfIterations = 1000;
	static public int GoodFitness = 20;
	static public int GoodF1 = 20;
	public static Stage primaryStage;
	public static Chromosome fittest = new Chromosome(null, 0, 0, 0, 0);
	public static Chromosome F = new Chromosome(null, 0, 0, 0, 0);

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/Start.fxml"));
		this.primaryStage = primaryStage;
		// primaryStage.setTitle("Welcome");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}

	public static void startalgorithm() throws Exception {
		GroupsPreferences.ConvertTocsv();
		// GroupsPreferences.printCourses();
		ArrayList<Chromosome> population = Chromosome.RandomGenerator();
		Chromosome.FitnessCalc(population);// takes populations as an input and sets the fitness values back for each
											// chromosome

		// Printing the randomly generated population with fitness values into a text
		// file
		PrintWriter test;
		try {
			test = new PrintWriter("Population.txt");
			for (int i = 0; i <= 1000; i++) {
				test.print(Chromosome.population.get(i).getGenes() + ", [f1= " + population.get(i).getf1() + ", f2= "
						+ population.get(i).getf2() + ", f3= " + population.get(i).getf3() + "fitness= "
						+ population.get(i).getfitness() + "]" + "\n");
			}
			test.close();
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Chromosome> Parents = GeneticsOperation.selectParent(Chromosome.population);
		ArrayList<Chromosome> Children = GeneticsOperation.CrossOver(Parents);

		Chromosome P1 = new Chromosome(null, 0, 0, 0, 0);
		Chromosome P2 = new Chromosome(null, 0, 0, 0, 0);
		P1 = Children.get(0);
		P2 = Children.get(1);
		Chromosome.ChildFitness(P1);
		Chromosome.ChildFitness(P2);
		// System.out.println("\nC1 Genes: " + P1.getGenes() + "\nf1: " + P1.getf1() +
		// "\nf2: " + P1.getf2() + "\nf3: "
		// + P1.getf3() + "\nfitness: " + P1.getfitness());
		// System.out.println("C2 Genes: " + P2.getGenes() + "\nf1: " + P2.getf1() +
		// "\nf2: " + P2.getf2() + "\nf3: "
		// + P2.getf3() + "\nfitness: " + P2.getfitness());
		int n = 0;
		int flag = 0;
		Parents.add(P1);
		Parents.add(P2);

		// Terminate based on users input values
		while (n <= NumberOfIterations && flag == 0) {
			System.out.println("N===================================Ù€Ù€Ù€Ù€Ù€Ù€Ù€Ù€Ù€Ù€Ù�]((((((((((((((((((((((((((((=N" + n);

			Children = GeneticsOperation.CrossOver(Parents);
			Chromosome C1 = Children.get(0);
			Chromosome C2 = Children.get(1);
			Chromosome.ChildFitness(C1);
			Chromosome.ChildFitness(C2);

			if (Math.random() < mutationChance) {
				ApplyMutation(C1);
				ApplyMutation(C2);
				Chromosome.ChildFitness(C1);
				Chromosome.ChildFitness(C2);
			}

			if (C1.getfitness() >= GoodFitness || C1.getf1() >= GoodF1) {
				Terminate(C1);
				flag = 1;// solution found, C1 is a good solution --> terminate
			} else if (C2.getfitness() >= GoodFitness || C2.getf1() >= GoodF1) {
				Terminate(C2);
				flag = 1;// solution found, C2 is a good solution --> terminate
			} else {
				ApplyMutation(C1);
				ApplyMutation(C2);
				ArrayList<Chromosome> Mutated = new ArrayList<>(2);
				Mutated.add(C1);
				Mutated.add(C2);
				Children = GeneticsOperation.CrossOver(Mutated);
			}

			if (C1.getfitness() > Parents.get(0).getfitness() || C1.getfitness() > Parents.get(1).getfitness()
					|| C2.getfitness() > Parents.get(0).getfitness() || C2.getfitness() > Parents.get(1).getfitness()) {
				if (C1.getfitness() > C2.getfitness() && flag == 0) {
					fittest = C1;
				} else
					fittest = C2;

			}
			

			Parents.add(Children.get(0));
			Parents.add(Children.get(1));
			n++;
			// n == 1000

		}

		System.out.println("ENd");
		Terminate(fittest);

	}

//	@FXML
	void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/AlgorithmGenerator.fxml"));
			Scene scene = new Scene(root);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}

	public static Chromosome ApplyMutation(Chromosome C) {
		Chromosome MutatedC = GeneticsOperation.Mutation(C);
		C.setGenes(MutatedC.getGenes());
		Chromosome.ChildFitness(C);
		return C;

	}

	public static Chromosome findGoodSolution(ArrayList<Chromosome> population) {
		Chromosome C = new Chromosome(null, 0, 0, 0, 0);
		for (int i = 0; i < population.size(); i++) {
			int f1 = population.get(i).getf1();
			int fitness = population.get(i).getfitness();
			if (f1 >= GoodF1 || fitness >= GoodFitness) {
				C = population.get(i);
				return C;
			}
		}
		return C;
	}

	public static void Terminate(Chromosome C) {
		F = C;

		System.out.println("A GOOD SOLUTION WAS FOUND!\n");
		System.out.println("Projects Distribtution: " + C.getGenes() + "\nMatches with the First Choise: " + C.getf1()
				+ "\nTotal Number of Matches " + C.getfitness());
		// System.exit(1);
		return;
	}

	public static void Print(Chromosome C1, Chromosome C2) {
		System.out.println("\nC1 Genes: " + C1.getGenes() + "\nf1: " + C1.getf1() + "\nf2: " + C1.getf2() + "\nf3: "
				+ C1.getf3() + "\nfitness: " + C1.getfitness());
		System.out.println("C2 Genes: " + C2.getGenes() + "\nf1: " + C2.getf1() + "\nf2: " + C2.getf2() + "\nf3: "
				+ C2.getf3() + "\nfitness: " + C2.getfitness());

	}
}