import java.util.ArrayList;

class TournamentSelection<T extends IChromosome> implements ISelectionAlgorithm<T> {

    private int k;

    TournamentSelection(int k) {
        this.k = k;
    }

    @Override
    public T select(ArrayList<T> population, IFitnessCalculator<T> calculator) {
        float best_fitness = -1;
        T best_chromosome;
        for (int i = 0; i < k; ++i) {
            int s = RandomGenerator.randIndex(population);
            T chromosome = population.get(i);
            float fitness = calculator.calculate(chromosome);
            if (fitness > best_fitness) {
                best_fitness = fitness;
                best_chromosome = chromosome;
            }
        }
        return chromosome;
    }

}
