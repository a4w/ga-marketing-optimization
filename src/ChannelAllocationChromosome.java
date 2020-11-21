import java.util.ArrayList;
import java.util.List;

class ChannelAllocationChromosome implements IChromosome {

    public List<Float> genes;
    ChannelAllocationChromosome() { genes = new ArrayList<>();}
    ChannelAllocationChromosome(int initialCapacity){ genes = new ArrayList<>(initialCapacity); }
    ChannelAllocationChromosome(List<Float> rhs) {genes = rhs;}

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
