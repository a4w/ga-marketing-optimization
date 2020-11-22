import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        GeneticAlgorithmConfig<ChannelAllocationChromosome> config = new GeneticAlgorithmConfig<>();
        float totalBudget;
        int nMarketChannels;
        List<String> name_list = new ArrayList<>();
        List<Float> roi_list = new ArrayList<>();
        List<Limit> limit_list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the marketing budget (in thousands):");
        totalBudget = sc.nextFloat();

        System.out.println("Enter the number of marketing channels:");
        nMarketChannels = sc.nextInt();

        System.out.println("Enter the name and ROI (in %) of each channel separated by space:");
        for (int i = 0; i < nMarketChannels; ++i) {
            String name;
            float roi;
            name = sc.next();
            roi = sc.nextFloat() / 100.0f;
            roi_list.add(roi);
            name_list.add(name);
        }

        System.out.println(
                "Enter the lower(k) and upper bounds(%) of investment in each channel: (enter x if there is no bound)");
        for (int i = 0; i < nMarketChannels; ++i) {
            String lo, hi;
            lo = sc.next();
            hi = sc.next();
            Limit limit = new Limit(lo.equals("x") ? 0 : Float.valueOf(lo),
                    hi.equals("x") ? totalBudget : (Float.valueOf(hi) / 100.0f) * totalBudget);
            limit_list.add(limit);
        }

        sc.close();

        System.out.println("Please wait while running the GA...");

        MetaData metaData = new MetaData(totalBudget, nMarketChannels, roi_list, limit_list);

        config.setSelectionsPercent(0.8f);
        config.setNumberOfGenerations(1000);
        config.setMutationProbability(0.01);
        config.setInitialPopulationSize(1000);
        config.setCrossOverProbability(0.85f);
        IFitnessCalculator<ChannelAllocationChromosome> fitnessCalculator = new ChannelAllocationChromosomeFitnessCalculator(
                metaData);
        config.setFitnessCalculator(fitnessCalculator);
        /*
         * config.setMutationAlgorithm(new
         * ChannelAllocationChromosomeUniformMutation(metaData));
         */
        config.setCrossOverAlgorithm(new TwoPointCrossOver());
        config.setSelectionAlgorithm(new TournamentSelection<ChannelAllocationChromosome>(10));
        config.setReplacementAlgorithm(new ElitistReplacement<ChannelAllocationChromosome>(0.25f, fitnessCalculator));
        // Number of GA runs
        final int runs = 20;

        try {
            // Open file (with timestamp as name)
            String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss").format(LocalDateTime.now());
            FileWriter output = new FileWriter(timestamp + ".log");

            // Run GA and maximize fitness across runs
            ChannelAllocationChromosome overallWinner = null;
            float best_fitness = -1;
            for (int RUN = 1; RUN <= runs; ++RUN) {
                // New GA run
                GeneticAlgorithm<ChannelAllocationChromosome> ga = new GeneticAlgorithm<>(config);
                ga.run();
                ChannelAllocationChromosome winner = ga.getBest();

                // Update overallWinner
                float fitness = fitnessCalculator.calculate(winner);
                if (fitness > best_fitness) {
                    overallWinner = winner;
                    best_fitness = fitness;
                }

                // Write to file
                final String log_line = "Run #" + String.valueOf(RUN) + ": " + winner.toString();
                System.out.println(log_line);
                output.write(log_line);
            }
            // Write overall winner
            final String end_log_line = "\n Over all winner across " + String.valueOf(runs) + " runs is: "
                    + overallWinner.toString();
            System.out.println(end_log_line);
            output.write(end_log_line);
            output.close();
        } catch (Exception e) {
            System.err.println("Couldn't open file");
        }

    }
}
