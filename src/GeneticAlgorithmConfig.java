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
    private float selectionsPercent;
    private float crossOverProbability;
    private float mutationProbability;
    private float nonUniformityDegree;

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

    public float getSelectionsPercent() {
        return selectionsPercent;
    }

    public void setSelectionsPercent(float selectionsPercent) {
        this.selectionsPercent = selectionsPercent;
    }

    public float getCrossOverProbability() {
        return crossOverProbability;
    }

    public void setCrossOverProbability(float crossOverProbability) {
        this.crossOverProbability = crossOverProbability;
    }

    public float getMutationProbability() {
        return mutationProbability;
    }

    public void setMutationProbability(float mutationProbability) {
        this.mutationProbability = mutationProbability;
    }

    public Float getNonUniformityDegree() {return nonUniformityDegree;}
    public void setNonUniformityDegree(Float nonUniformityDegree) {this.nonUniformityDegree = nonUniformityDegree;}
}
