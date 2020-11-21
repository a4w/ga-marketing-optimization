import java.util.List;

class ChannelAllocationChromosomeFitnessCalculator implements IFitnessCalculator<ChannelAllocationChromosome> {

    private MetaData data;

    public ChannelAllocationChromosomeFitnessCalculator(MetaData data) {
        this.data = data;
    }

    @Override
    public float calculate(ChannelAllocationChromosome chromosome) {
        float total = 0;
        List<Float> genes = chromosome.getGenes();
        for (int i = 0; i < genes.size(); ++i) {
            total += genes.get(i) * data.getChannelROI(i);
        }
        return total;
    }

}
