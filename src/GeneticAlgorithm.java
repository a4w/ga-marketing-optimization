import java.util.ArrayList;

class GeneticAlgorithm<T extends IChromosome> {
    private GeneticAlgorithmConfig<T> config;
    private ArrayList<T> population;

    public GeneticAlgorithm(GeneticAlgorithmConfig<T> config) {
        this.config = config;
        this.population = this.generatePopulation(config.getInitialPopulationSize());
    }

    private ArrayList<T> generatePopulation(int size) {
        ArrayList<T> population = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            population.add(this.config.getChromosomeGenerator().generate());
        }
        return population;
    }

    public void iterate() {
        ArrayList<T> newPopulation = new ArrayList<>();
        final int numberOfParents = config.getCrossOverAlgorithm().getNumberOfParents();
        final int numberOfSelections = (int) config.getSelectionsPercent() * this.population.size() / numberOfParents;
        for (int I = 1; I <= numberOfSelections; ++I) {
            // Selection
            ArrayList<T> parents = new ArrayList<>();
            final IFitnessCalculator<T> calculator = config.getFitnessCalculator();
            for (int i = 0; i < numberOfParents; ++i) {
                parents.add(config.getSelectionAlgorithm().select(this.population, calculator));
            }
            // Cross over
            final double crossOverProbability = config.getCrossOverProbability();
            ArrayList<T> children = config.getCrossOverAlgorithm().cross(parents, crossOverProbability);
            // Mutate each
            final double mutationProbability = config.getMutationProbability();
            for (int i = 0; i < children.size(); ++i) {
                newPopulation.add(config.getMutationAlgorithm().mutate(children.get(i), mutationProbability));
            }
        }
        // Replace population
        this.population = config.getReplacementAlgorithm().getNewPopulation(this.population, newPopulation);
    }

    public void run() {
        final int numberOfGenerations = config.getNumberOfGenerations();
        for (int GENERATION = 1; GENERATION <= numberOfGenerations; ++GENERATION) {
            this.iterate();
        }
    }

    public ArrayList<T> getPopulation() {
        return population;
    }

    public T getBest() {
        double bestFitness = -1;
        T best = null;
        IFitnessCalculator<T> calculator = config.getFitnessCalculator();
        for (int i = 0; i < this.population.size(); ++i) {
            final double fitness = calculator.calculate(this.population.get(i));
            if (fitness > bestFitness) {
                bestFitness = fitness;
                best = this.population.get(i);
            }
        }
        return best;
    }
}
