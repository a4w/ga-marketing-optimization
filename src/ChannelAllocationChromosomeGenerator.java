import java.util.ArrayList;
import java.util.List;

class ChannelAllocationChromosomeGenerator implements IChromosomeGenerator<ChannelAllocationChromosome> {

    private MetaData metaData;

    ChannelAllocationChromosomeGenerator(MetaData metaData)
    {
        this.metaData = metaData;
    }

    /**
     * generates a valid chromosome with respect to provided metaData
     * assumes provided metaData is valid
     * @return ChannelAllocationChromosome
     */
    @Override
    public ChannelAllocationChromosome generate() {
        int n = metaData.getNumberOfMarketChannels();
        ChannelAllocationChromosome retChromosome = new ChannelAllocationChromosome(metaData);
        while(!retChromosome.isValid())
        {
            List<Float> genes = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                Float lower = metaData.getChannelLowerLimit(i);
                Float upper = metaData.getChannelUpperLimit(i);
                genes.add(RandomGenerator.randFloat(lower, upper));
            }
            retChromosome.setGenes(genes);
        }
        return retChromosome;
    }

}
