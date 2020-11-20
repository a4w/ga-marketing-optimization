class GeneticAlgorithmConfig<T extends IChromosome> {
    // Algorithms
    private IChromosomeGenerator<T> chromosomeGenerator;
    private IFitnessCalculator<T> fitnessCalculator;
    private ISelectionAlgorithm<T> selectionAlgorithm;
    private ICrossOverAlgorithm<T> crossOverAlgorithm;
    private IMutationAlgorithm<T> mutationAlgorithm;
    private IReplacementAlgorithm<T> replacementAlgorithm;

    // Parameters
    private int initialPopulationSize;
    private int numberOfGenerations;
    private double selectionsPercent;
    private double crossOverProbability;
    private double mutationProbability;

    public IChromosomeGenerator<T> getChromosomeGenerator() {
        return chromosomeGenerator;
    }

    public void setChromosomeGenerator(IChromosomeGenerator<T> chromosomeGenerator) {
        this.chromosomeGenerator = chromosomeGenerator;
    }

    public IFitnessCalculator<T> getFitnessCalculator() {
        return fitnessCalculator;
    }

    public void setFitnessCalculator(IFitnessCalculator<T> fitnessCalculator) {
        this.fitnessCalculator = fitnessCalculator;
    }

    public ISelectionAlgorithm<T> getSelectionAlgorithm() {
        return selectionAlgorithm;
    }

    public void setSelectionAlgorithm(ISelectionAlgorithm<T> selectionAlgorithm) {
        this.selectionAlgorithm = selectionAlgorithm;
    }

    public ICrossOverAlgorithm<T> getCrossOverAlgorithm() {
        return crossOverAlgorithm;
    }

    public void setCrossOverAlgorithm(ICrossOverAlgorithm<T> crossOverAlgorithm) {
        this.crossOverAlgorithm = crossOverAlgorithm;
    }

    public IMutationAlgorithm<T> getMutationAlgorithm() {
        return mutationAlgorithm;
    }

    public void setMutationAlgorithm(IMutationAlgorithm<T> mutationAlgorithm) {
        this.mutationAlgorithm = mutationAlgorithm;
    }

    public IReplacementAlgorithm<T> getReplacementAlgorithm() {
        return replacementAlgorithm;
    }

    public void setReplacementAlgorithm(IReplacementAlgorithm<T> replacementAlgorithm) {
        this.replacementAlgorithm = replacementAlgorithm;
    }

    public int getInitialPopulationSize() {
        return initialPopulationSize;
    }

    public void setInitialPopulationSize(int initialPopulationSize) {
        this.initialPopulationSize = initialPopulationSize;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

    public double getSelectionsPercent() {
        return selectionsPercent;
    }

    public void setSelectionsPercent(double selectionsPercent) {
        this.selectionsPercent = selectionsPercent;
    }

    public double getCrossOverProbability() {
        return crossOverProbability;
    }

    public void setCrossOverProbability(double crossOverProbability) {
        this.crossOverProbability = crossOverProbability;
    }

    public double getMutationProbability() {
        return mutationProbability;
    }

    public void setMutationProbability(double mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

}
