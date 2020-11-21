import java.util.ArrayList;
import java.util.List;

class ChannelAllocationChromosome implements IChromosome {

    public List<Float> genes;

    ChannelAllocationChromosome() {
        genes = new ArrayList<>();
    }

    ChannelAllocationChromosome(int initialCapacity) {
        genes = new ArrayList<>(initialCapacity);
    }

    ChannelAllocationChromosome(List<Float> rhs) {
        genes = rhs;
    }

    ChannelAllocationChromosome(ChannelAllocationChromosome other) {
        this.genes = new ArrayList<>(other.genes.size());
        for (int i = 0; i < other.genes.size(); ++i) {
            this.genes.set(i, other.genes.get(i));
        }
    }

    public List<Float> getGenes() {
        return this.genes;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

}
