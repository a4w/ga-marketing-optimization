interface IMutationAlgorithm<T extends IChromosome> {

    public T mutate(T chromosome, int currentGeneration);

}
