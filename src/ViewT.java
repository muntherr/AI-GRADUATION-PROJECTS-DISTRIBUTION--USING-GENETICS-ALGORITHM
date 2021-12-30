
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

public class ViewT {// a chromosome is a genome that represents a solution
	private ArrayList<Integer> genes;// gene values represent numbers of projects
	private ArrayList<Integer> ind;
	private int f1 = 0; // represents the number of matches with the first choice
	private int f2 = 0; // represents the number of matches with the second choice
	private int f3 = 0; // represents the number of matches with the third choice
	private int Fittness = 0; // represents the total fitness of a chromosome (f1+f2+f3)
	// a chromosome is an arraylist containing the gene values, each value
	// represents the project number
	// for the group of number index+1

	public ViewT(ArrayList<Integer> ind, ArrayList<Integer> genes, int Fittness, int f1, int f2, int f3) {
		this.genes = genes;
		this.ind = ind;
		this.Fittness = Fittness;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;

	}

	public ArrayList<Integer> getInd() {
		return ind;
	}

	public void setInd(ArrayList<Integer> ind) {
		this.ind = ind;
	}

	public ArrayList<Integer> getGenes() {
		return genes;
	}

	public void setGenes(ArrayList<Integer> genes) {
		this.genes = genes;
	}

	public int getf1() {

		return f1;
	}

	public void setf1(int f1) {
		this.f1 = f1;
	}

	public int getf2() {
		return f2;
	}

	public void setf2(int f2) {
		this.f2 = f2;
	}

	public int getf3() {
		return f3;
	}

	public void setf3(int f3) {
		this.f3 = f3;
	}

	public int getFittness() {
		return Fittness;
	}

	public void setfitness(int Fittness) {
		this.Fittness = Fittness;
	}

	// this function generates and returns a random population of genomes or
	// chromosomes (initial solutions)

}
