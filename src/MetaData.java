import java.util.List;

public class MetaData {

    private Float totalBudget;
    private int nMarketChannels;
    private List<Float> ROI;
    private List<Limit> channelLimits;

    public MetaData(float totalBudget, int nMarketChannels, List<Float> ROI, List<Limit> channelLimits) {
        this.totalBudget = totalBudget;
        this.nMarketChannels = nMarketChannels;
        this.ROI = ROI;
        this.channelLimits = channelLimits;
    }

    public Float getTotalBudget()
    {
        return totalBudget;
    }

    public int getNumberOfMarketChannels()
    {
        return nMarketChannels;
    }

    public Float getChannelROI(int i)
    {
        return ROI.get(i);
    }

    public Limit getChannelLimit(int i)
    {
        return channelLimits.get(i);
    }

    public Float getChannelUpperLimit(int i)
    {
        return channelLimits.get(i).upper;
    }

    public Float getChannelLowerLimit(int i)
    {
        return channelLimits.get(i).lower;
    }
}
