
/*This class applies the genetics algorithm step by step:
 * It starts with the selection step, by selecting the best parent to reproduce, out of the randomly generated population.
 * Then it performs the crossover between the best selected chromosomes,
 * used the produced children to reproduce again and become the parent, and repeats.
 * It also applies mutation as needed 
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class GeneticsOperation {
	// This function returns the pair of chromosomes with the best fitness value out
	// of the random population
	public static ArrayList<Chromosome> selectParent(ArrayList<Chromosome> population) {
		population.sort(Chromosome::compareTo);// ascending sorting of the generated population based on fitness value
		ArrayList<Chromosome> Parent = new ArrayList<>();// to store the best selected pair of chromosomes
		Chromosome P1 = population.get(population.size() - 1);// chromosome with the maximum fitness
		Chromosome P2 = population.get(population.size() - 2);// chromosome with the second maximum fitness
		// storing selected parents in the Parent arraylist of chromosomes
		Parent.add(P1);
		Parent.add(P2);
		// Main.Print(P1, P2);
		return Parent;
	}

	// This function performs crossover between two parents and returns the two
	// produced children
	// a subsequence crossover is applied starting from a randomly generated index
	// until the end of a chromosome
	public static ArrayList<Chromosome> CrossOver(ArrayList<Chromosome> Parents) {
		Chromosome Parent1 = Parents.get(0);// first best chromosome
		Chromosome Parent2 = Parents.get(1);// second best chromosome
		int Parentsize = Parent1.getGenes().size();
		System.out.println(Parentsize);
		int index = 25;// Chromosome.generateRandom(0, 35);//generating a random index to start the
						// crossover from

		ArrayList<Chromosome> Children = new ArrayList<>(); // To store new produced chromosomes in
		ArrayList<Integer> Child1 = new ArrayList<>(Collections.nCopies(Parentsize, -1)); //
		ArrayList<Integer> Child2 = new ArrayList<>(Collections.nCopies(Parentsize, -1)); // To store To parent on
		ArrayList<Integer> replacement1 = new ArrayList<>(Collections.nCopies(Parentsize+1, -1));
		ArrayList<Integer> replacement2 = new ArrayList<>(Collections.nCopies(Parentsize+1, -1));

		for (int i = index; i < 36; i++) {
			// skip any gene value in Parent1 that matches any of the group preferences
			// (don't crossover or change position)
			if (Parent1.getGenes().get(i) == GroupsPreferences.Groups.get(i).getFirstchoice()
					|| Parent1.getGenes().get(i) == GroupsPreferences.Groups.get(i).getSecondchoice()
					|| Parent1.getGenes().get(i) == GroupsPreferences.Groups.get(i).getThirdchoice()) {
				Child1.set(i, Parent1.getGenes().get(i));// transfer the matching value into the reproduced child 1

			} else {
				Child1.set(i, Parent2.getGenes().get(i));
//				if (Parent2.getGenes().get(i) == 36) {
//					replacement1.set(Parent2.getGenes().get(35), Parent1.getGenes().get(i));
//				} else
					replacement1.set(Parent2.getGenes().get(i), Parent1.getGenes().get(i));

			}
			// skip any gene value in Parent2 that matches any of the group preferences
			// (don't crossover or change position)
			if (Parent2.getGenes().get(i) == GroupsPreferences.Groups.get(i).getFirstchoice()
					|| Parent2.getGenes().get(i) == GroupsPreferences.Groups.get(i).getSecondchoice()
					|| Parent2.getGenes().get(i) == GroupsPreferences.Groups.get(i).getThirdchoice()) {
				Child2.set(i, Parent2.getGenes().get(i));// transfer the matching value into the reproduced child 2
			} else {
				Child2.set(i, Parent1.getGenes().get(i));
//				if (Parent1.getGenes().get(i) == 36) {
//					replacement2.set(Parent1.getGenes().get(35), Parent2.getGenes().get(i));
//				} else
					replacement2.set(Parent1.getGenes().get(i), Parent2.getGenes().get(i));
			}
			// if the gene value in parent 1 and 2 doesn't match any choices apply cross
			// over
			// move content of Parent 1 into Child 2 and move content of Parent 2 into Child
			// 1

			// replacement1 and 2 are used to avoiding duplicates

		}

		// Parent1.setGenes(Child1);
		// Parent2.setGenes(Child2);
		// the following lines avoids duplicates in the newly produced children
		// by applying simple mapping

		for (int i = 0; i < Parentsize; i++) {
			if (i < index) {

				int n1 = Parent1.getGenes().get(i);// can't return a value of -1 because it will be an index later ///25
				System.out.println("n1 :" + n1);
//				if (n1 == 36) {
//					n1 = n1 - 1;
//				}
				// System.out.println(":::>>>>>>>>>>>>:"+replacement1.get(n1));

				int m1 = replacement1.get(n1);
				System.out.println("iiiii :" + i);
				int n2 = Parent2.getGenes().get(i);

//				if (n2 == 36) {
//					n2 = n2 - 1;
//				}
				System.out.println("n2 :" + n2);
				// System.out.println(":::>>>>>>>>>>>>:"+replacement2.get(n2));

				int m2 = replacement2.get(n2);
				System.out.println("m1 :" + m1);

				System.out.println("m2 :" + m2);

				while (m1 != -1) {
					System.out.println("iiiiii" + i);
					System.out.println("Indexxxx" + index);
//					if (m1 == 36) {
//						m1 = 35;
//					}
					n1 = m1;
					System.out.println("n1 :" + n1);

					m1 = replacement1.get(m1);
					System.out.println("m1 :" + m1);
					System.out.println("Parent1 :" + Parent1.getGenes());
					System.out.println("Parent2 :" + Parent2.getGenes());
					System.out.println("Replacement1 :" + replacement1);
					System.out.println("Replacement2 :" + replacement2);

				}

				while (m2 != -1) {
//					if (m2 == 36) {
//						m2 = 35;
//					}
					n2 = m2;
					System.out.println("iiiiii" + i);
					System.out.println("Indexxxx" + index);
					System.out.println("n2 :" + n2);
					m2 = replacement2.get(m2);
					System.out.println("m2 :" + m2);
					System.out.println("Parent1 :" + Parent1.getGenes());
					System.out.println("Parent2 :" + Parent2.getGenes());
					System.out.println("Replacement1 :" + replacement1);
					System.out.println("Replacement2 :" + replacement2);

				}

				Child1.set(i, n1);
				Child2.set(i, n2);

			}
		}
		System.out.println("Replacement1 :" + replacement1);
		System.out.println("Replacement2 :" + replacement2);

		// Main.Print(Parent1, Parent2);

		Chromosome C1 = new Chromosome(Child1, 0, 0, 0, 0);
		Chromosome C2 = new Chromosome(Child2, 0, 0, 0, 0);

		Children.add(C1);
		Children.add(C2);

		Chromosome.ChildFitness(C1);
		Chromosome.ChildFitness(C2);

		return Children;
	}

	// the mutation technique used is the swap mutation
	// Swap Mutation: choosing 2 genes at random positions and swapping them
	public static Chromosome Mutation(Chromosome arrayList) {
		Chromosome temp = new Chromosome(null, 0, 0, 0, 0);
		temp = arrayList;
		// System.out.println(arrayList.getGenes());
		int RandomIndex1 = Chromosome.generateRandom(0, arrayList.getGenes().size() - 1);// generating random index1
		int RandomIndex2 = Chromosome.generateRandom(0, arrayList.getGenes().size() - 1);// generating random index2
		if (RandomIndex1 <= RandomIndex2) {// checking if the two generated positions are the same
			RandomIndex2 = Chromosome.generateRandom(0, arrayList.getGenes().size() - 1);// regenerating index2 if it
																							// equals index1
			// System.out.println("While" + RandomIndex1);
		}

		// Collections.swap(temp.getGenes(), RandomIndex2, RandomIndex1);// swapping
		// gene value between positions
		if (arrayList.getGenes().get(RandomIndex1) == GroupsPreferences.Groups.get(RandomIndex1).getFirstchoice()
				|| arrayList.getGenes().get(RandomIndex1) == GroupsPreferences.Groups.get(RandomIndex1)
						.getSecondchoice()
				|| arrayList.getGenes().get(RandomIndex1) == GroupsPreferences.Groups.get(RandomIndex1)
						.getThirdchoice()) {
			RandomIndex1 = Chromosome.generateRandom(0, arrayList.getGenes().size() - 1);// generating random index1
			RandomIndex2 = Chromosome.generateRandom(0, arrayList.getGenes().size() - 1);// generating random index2
			// System.out.println("Random Index 1: " + RandomIndex1 + " --> Gene Value: " +
			// arrayList.getGenes().get(RandomIndex1));
			// System.out.println("Random Index 2: " + RandomIndex2 + " --> Gene Value: " +
			// arrayList.getGenes().get(RandomIndex2));
			Collections.swap(arrayList.getGenes(), RandomIndex1, RandomIndex2);// swapping gene value between positions
		} else {
			Collections.swap(arrayList.getGenes(), RandomIndex1, RandomIndex2);// swapping gene value between positions

		}

		return arrayList;// return the ArrayList of genes after swapping
	}

}
