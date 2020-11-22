import java.util.ArrayList;
import java.util.Collections;

class ElitistReplacement<T extends IChromosome> implements IReplacementAlgorithm<T> {

    private float k;
    private IFitnessCalculator<T> fitnessCalculator;

    ElitistReplacement(float k, IFitnessCalculator<T> fitnessCalculator) {
        this.k = k;
        this.fitnessCalculator = fitnessCalculator;
    }

    @Override
    public ArrayList<T> getNewPopulation(ArrayList<T> oldPopulation, ArrayList<T> newGeneration) {
        // How much to keep from old population
        final int toKeep = (int) (this.k * oldPopulation.size());

        ArrayList<ChromosomeFitnessPair> fitness_list = new ArrayList<>();
        for (int i = 0; i < oldPopulation.size(); ++i) {
            ChromosomeFitnessPair pair = new ChromosomeFitnessPair();
            pair.chromosome = oldPopulation.get(i);
            pair.fitness = this.fitnessCalculator.calculate(oldPopulation.get(i));
            fitness_list.add(pair);
        }
        Collections.sort(fitness_list);

        ArrayList<T> nextGeneration = new ArrayList<>();

        // Add elitist to next generation
        for (int i = 0; i < toKeep; ++i) {
            nextGeneration.add(fitness_list.get(oldPopulation.size() - 1 - i).chromosome);
        }

        // Continue filling with new generation
        for (int i = 0; i < newGeneration.size(); ++i) {
            nextGeneration.add(newGeneration.get(i));
        }

        return nextGeneration;
    }

    private class ChromosomeFitnessPair implements Comparable<ChromosomeFitnessPair> {
        public T chromosome;
        public float fitness;

        @Override
        public int compareTo(ElitistReplacement<T>.ChromosomeFitnessPair other) {
            if (fitness == other.fitness) {
                return 0;
            } else if (fitness > other.fitness) {
                return 1;
            } else {
                return -1;
            }
        }

    }

}
