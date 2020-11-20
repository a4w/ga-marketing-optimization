interface IMutationAlgorithm<T extends IChromosome> {

    public T mutate(T chromosome, double geneMutationProbability);

}
