import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.Random;


public class Chromosome {//a chromosome is a genome that represents a solution
	private ArrayList<Integer> genes;//gene values represent numbers of projects
	private int f1 = 0; //represents the number of matches with the first choice
	private int f2 = 0; //represents the number of matches with the second choice
	private int f3 = 0; //represents the number of matches with the third choice
	private int fitness = 0; //represents the total fitness of a chromosome (f1+f2+f3)
	//a chromosome is an arraylist containing the gene values, each value represents the project number 
	//for the group of number index+1
	
	public Chromosome(ArrayList<Integer> genes, int fitness, int f1, int f2, int f3) {
		super();
		this.genes = genes;
		this.fitness  = fitness;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}

	static public ArrayList<Chromosome> population ;

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
	public int getfitness () {
		return fitness ;
	}
	public void setfitness (int fitness ) {
		this.fitness  = fitness ;
	}
	
	//this function generates and returns a random population of genomes or chromosomes (initial solutions)
	public static ArrayList<Chromosome> RandomGenerator(){	   
		Chromosome.population= new ArrayList<>();
		for (int population_size = 0; population_size <= Main.MaxGen;population_size++) {
		ArrayList<Integer> Randomnumbers = new ArrayList<>();
	       for(int j = 0 ; j < 36;j++) { // Size = 37
	            int GeneValue = j+1;
	            Randomnumbers.add(GeneValue);
	            Collections.shuffle(Randomnumbers);
	        }
	       population.add(new Chromosome(Randomnumbers,0,0,0,0));
		}
		return population;
			
	}
	
	
	//This function calculates the fitness values (f1,f2,f3,fitness) for each chromosome of the initially generated population
	public static void FitnessCalc(ArrayList <Chromosome> population) {
		for(int i=0; i<population.size();i++) {
			ChildFitness(population.get(i));
		}
	}
	
	//This function calculates fitness values for a chromosome
	public static void ChildFitness(Chromosome C) {
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		int fitness = 0;
		for(int j=0;j<36;j++) {
			if(C.getGenes().get(j)==GroupsPreferences.Groups.get(j).getFirstchoice())
				f1++;
			else if(C.getGenes().get(j)==GroupsPreferences.Groups.get(j).getSecondchoice())
				f2++;
			else if(C.getGenes().get(j)==GroupsPreferences.Groups.get(j).getThirdchoice())
				f3++;
		}
		fitness= f1+f2+f3;
		C.setf1(f1);
		C.setf2(f2);
		C.setf3(f3);
		C.setfitness(fitness); 
	}
	//This function is used in the sorting process to sort a set of chromosomes based on their fitness value
	public int compareTo(Chromosome o) {
        if (this == o) return 0;
        if (!(o instanceof Chromosome)) return -2;
        if(this.getfitness() > o.getfitness())
            return 1;
        else if(this.getfitness() == o.getfitness())
            return 0;
        else
            return -1;

    }
	
	public static void printchromosome() {
		try {
		    for(int i=0;i<population.size();i++) {
		    	System.out.print("\n Chromosome"+i+" ");
		    	System.out.print( "[" + population.get(i).getGenes()+ "fitness =" + population.get(i).getfitness() + "]");
		    }
		}
		    catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static public int generateRandom(int min , int max){
      int n=0;
      Random rand = new Random();
      n=rand.nextInt((max - min) + 1) + min;
      return n;
  }
	
	
}
