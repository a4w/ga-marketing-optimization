import java.util.ArrayList;

interface ISelectionAlgorithm<T extends IChromosome> {

    public T select(ArrayList<T> population, IFitnessCalculator<T> calculator);

}
