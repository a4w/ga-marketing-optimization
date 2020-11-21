import java.util.ArrayList;

class TwoPointCrossOver implements ICrossOverAlgorithm<ChannelAllocationChromosome> {

    @Override
    public ArrayList<ChannelAllocationChromosome> cross(ArrayList<ChannelAllocationChromosome> parents,
            double crossOverProbability) {
        ChannelAllocationChromosome parent1 = parents.get(0);
        ChannelAllocationChromosome parent2 = parents.get(1);
        if (RandomGenerator.rand() < crossOverProbability) {
            // Generate two points
            int p1 = RandomGenerator.randInt(1, parents.size() - 2);
            int p2 = RandomGenerator.randInt(1, parents.size() - 2);
            // Sort both points
            if (p1 < p2) {
                int t = p1;
                p1 = p2;
                p2 = t;
            }
            // Swap
            ArrayList<ChannelAllocationChromosome> children = new ArrayList<>();
            children.add(new ChannelAllocationChromosome(parent1));
            children.add(new ChannelAllocationChromosome(parent2));
            for (int i = p1; i < p2; ++i) {
                children.get(0).genes.set(i, parent2.genes.get(i));
                children.get(1).genes.set(i, parent1.genes.get(i));
            }
            return children;
        } else {
            // No cross over
            return parents;
        }
    }

    @Override
    public int getNumberOfParents() {
        return 2;
    }

}
