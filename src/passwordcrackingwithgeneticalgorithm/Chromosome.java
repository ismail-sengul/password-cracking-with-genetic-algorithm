
package passwordcrackingwithgeneticalgorithm;

public class Chromosome implements Comparable {
    private String chromosome;
    private int fitnessScore;
    
    public Chromosome(String chromosome, String target){
        this.chromosome = chromosome;
        this.fitnessScore = getFitnessScore(target);
    }
    public int getFitnessScore(String target){
        int fitnessScore = 0;
        for (int i = 0; i < chromosome.length(); i++) {
            if(chromosome.charAt(i) == target.charAt(i)){
                fitnessScore++;
            }
        }
        return fitnessScore;
    }
    public String getChromosome() {
        return chromosome;
    }

    public int getFitnessScore() {
        return fitnessScore;
    }
    @Override
    public int compareTo(Object other_chromosome) {
        Chromosome other_chrm = (Chromosome) other_chromosome;
        return other_chrm.fitnessScore - this.fitnessScore;
    }
    
}
