public class ChannelAllocationChromosomeMutation implements IMutationAlgorithm<ChannelAllocationChromosome> {

    public ChannelAllocationChromosome mutate(ChannelAllocationChromosome chromosome, double geneMutationProbability, boolean uniform){
        float Pm = RandomGenerator.rand();
        int chromosomeSize = chromosome.getGenes().size();
        GeneticAlgorithmConfig geneticAlgorithmConfig = new GeneticAlgorithmConfig();
        int numberOfGenerations = geneticAlgorithmConfig.getNumberOfGenerations();
        for (int i = 0; i < chromosomeSize; i++) {
            float rand = RandomGenerator.rand();

            // if rand is smaller than or equal the mutation probability
            // we will mutate that gene
            // else we will leave as it is

            //===========================

            // Uniform Mutation
            if (rand <= Pm){
                float Xi = chromosome.getGene(i);
                MetaData chromosomeMetaData = chromosome.getMetaData();
                float lowerBound = chromosomeMetaData.getChannelLowerLimit(i);
                float upperBound = chromosomeMetaData.getChannelUpperLimit(i);
                float deltaLeft = Xi - lowerBound;
                float deltaRight = upperBound - Xi;
                float rand_1 = RandomGenerator.rand();
                float delta = 0.0f;
                if (rand_1 <= 0.5)
                    delta = deltaLeft;
                else
                    delta = deltaRight;
                float newXi = 0.0f;
                if(delta == deltaLeft)
                    newXi = Xi - delta;
                else
                    newXi = Xi + delta;

            }
        }

    }
}