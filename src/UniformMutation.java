import java.util.List;

public class UniformMutation implements IMutationAlgorithm<ChannelAllocationChromosome> {
    private MetaData metaData;
    private GeneticAlgorithmConfig<ChannelAllocationChromosome> config;

    UniformMutation(MetaData metaData, GeneticAlgorithmConfig<ChannelAllocationChromosome> config) {
        this.metaData = metaData;
        this.config = config;
    }

    @Override
    public ChannelAllocationChromosome mutate(ChannelAllocationChromosome chromosome,
                                              GeneticAlgorithm<ChannelAllocationChromosome> algorithmState) {
        ChannelAllocationChromosome retChromosome = new ChannelAllocationChromosome(chromosome); // copy constructor
        List<Float> genes = retChromosome.getGenes();
        for (int i = 0; i < genes.size(); i++) {
            if (RandomGenerator.randFloat(0, 1) > config.getMutationProbability()) // skip mutation of current gene if the randomly generated number is greater than geneMutationProbability
                continue;

            Float decision = RandomGenerator.randFloat(0, 1);
            Float lowerRange = genes.get(i) - metaData.getChannelLowerLimit(i);
            Float upperRange = metaData.getChannelUpperLimit(i) - genes.get(i);
            if (decision <= 0.5f) // move towards lower limit
            {
                genes.set(i, genes.get(i) - delta(lowerRange));
            } else // move towards upper limit
            {
                genes.set(i, genes.get(i) + delta(upperRange));
            }
            assert (genes.get(i) >= metaData.getChannelLowerLimit(i)
                    && genes.get(i) <= metaData.getChannelUpperLimit(i)); // assertion that gene is still within limits after mutation
        }
        if (retChromosome.isValid())
            return retChromosome;
        else // neglect invalid chromosomes
            return chromosome;
    }

    private Float delta(Float range) {
        Float ret = range * RandomGenerator.randFloat(0, 1);
        return ret;
    }
}
