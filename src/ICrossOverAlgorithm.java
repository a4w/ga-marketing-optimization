import java.util.ArrayList;

interface ICrossOverAlgorithm<T extends IChromosome> {

    public ArrayList<T> cross(ArrayList<T> parents, double crossOverProbability);

    public int getNumberOfParents();

}
