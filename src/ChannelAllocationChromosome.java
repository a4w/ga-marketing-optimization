import java.util.ArrayList;
import java.util.List;

class ChannelAllocationChromosome implements IChromosome {

    private List<Float> genes;
    private MetaData metaData;

    ChannelAllocationChromosome(List<Float> rhs, MetaData metaData) {
        genes = rhs;
        this.metaData = metaData;
    }

    ChannelAllocationChromosome(MetaData metaData) {
        genes = new ArrayList<>();
        this.metaData = metaData;
    }

    ChannelAllocationChromosome(ChannelAllocationChromosome other) {
        this.genes = new ArrayList<>(other.genes.size());
        this.genes.addAll(other.genes);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "{";
        for (int i = 0; i < genes.size(); i++) {
            ret += "[" + i + "]" + " = " + genes.get(i);
            if (i != genes.size() - 1)
                ret += ", ";
        }
        ret += "}";

        return ret;
    }

    @Override
    public boolean isValid() {
        if (genes.isEmpty())
            return false;

        Float sum = 0f;
        for (Float f : genes)
            sum += f;

        return sum <= metaData.getTotalBudget();
    }

    public void setGenes(List<Float> genes) {
        this.genes = genes;
    }

    public List<Float> getGenes() {
        return genes;
    }

    public Float getGene(int i) {
        return genes.get(i);
    }

}
