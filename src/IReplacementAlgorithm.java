import java.util.ArrayList;

interface IReplacementAlgorithm<T extends IChromosome> {

    public ArrayList<T> getNewPopulation(ArrayList<T> oldPopulation, ArrayList<T> newGeneration);

}
