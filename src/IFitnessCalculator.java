interface IFitnessCalculator<T extends IChromosome> {

    public float calculate(T chromosome);

}
