import java.util.List;

public class NonUniformMutation implements IMutationAlgorithm<ChannelAllocationChromosome> {
    private MetaData metaData;
    private GeneticAlgorithmConfig config;

    NonUniformMutation(MetaData metaData, GeneticAlgorithmConfig config){
        this.metaData = metaData;
        this.config = config;
    }

    @Override
    public ChannelAllocationChromosome mutate(ChannelAllocationChromosome chromosome, int currentGeneration) {
        ChannelAllocationChromosome retChromosome = new ChannelAllocationChromosome(chromosome); // copy constructor
        List<Float> genes = retChromosome.getGenes();
        for(int i = 0; i < genes.size(); i++){
            if(RandomGenerator.randFloat(0, 1) > config.getMutationProbability()) // skip mutation of current gene if the randomly generated number is greater than geneMutationProbability
                continue;

            Float decision = RandomGenerator.randFloat(0,1);
            Float lowerRange = genes.get(i) - metaData.getChannelLowerLimit(i);
            Float upperRange = metaData.getChannelUpperLimit(i) - genes.get(i);
            if(decision <= 0.5f) // move towards lower limit
            {
                genes.set(i, genes.get(i) - delta(lowerRange, currentGeneration));
            }
            else // move towards upper limit
            {
                genes.set(i, genes.get(i) + delta(upperRange, currentGeneration));
            }

            assert(genes.get(i) >= metaData.getChannelLowerLimit(i) && genes.get(i) <= metaData.getChannelUpperLimit(i)); // assertion that gene is still within limits after mutation

        }
        if(retChromosome.isValid())
            return retChromosome;
        else // neglect invalid chromosomes
            return chromosome;
    }

    /**
     *                                        b
     *                          ( (1 - t/T) ^   )
     * delta = range * (1 - r ^                   )
     * r: a random float within [0:1]
     * t: the current generation
     * T: the max. number of generations
     * b: a float parameter that controls the degree of non-uniformity within [0.5, 5]
     */
    private Float delta(Float range, int currentGeneration)
    {
        Float r = RandomGenerator.randFloat(0, 1),
              b = config.getNonUniformityDegree();

        int t = currentGeneration,
            T = config.getNumberOfGenerations();

        Float ret = range * (1.0f - (float)Math.pow(r, Math.pow(1f - (t * 1.0f / T), b)));
        return ret;
    }
}
