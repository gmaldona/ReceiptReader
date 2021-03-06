import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Miner {
    
    private int totalNumberOfTransactions = 14963;
    protected int minSupportCount = 1000;
    public double minSupport = 1;
    public double minConfidence = 1;

    public int calculateSupportCount(String item, ArrayList<ArrayList<String>> transactions) {

        int supportCount = 0;

        for (ArrayList<String> trans : transactions) {
            if (trans.contains(item)) supportCount++; 
        }

        return supportCount;
    }

    public int calculateSupportCount(ArrayList<String> set, ArrayList<ArrayList<String>> transactions) {

        int supportCount = 0; 

        for (ArrayList<String> trans : transactions) {
            if (trans.containsAll(set)) supportCount++;
        }

        return supportCount; 

    }

    public int calculateCount(ArrayList<String> A, ArrayList<String> B, ArrayList<ArrayList<String>> transactions) {

        Set<String> AB = new LinkedHashSet<>(A);
        AB.addAll(B);
        ArrayList<String> set = new ArrayList<>(AB);
        return calculateSupportCount(set, transactions);

    }

    public double calculateSupport(ArrayList<String> A, ArrayList<String> B, ArrayList<ArrayList<String>> transactions){

        Set<String> AB = new LinkedHashSet<>(A);
        AB.addAll(B);
        ArrayList<String> set = new ArrayList<>(AB);
        double support = (double) calculateSupportCount(set, transactions) / (double) totalNumberOfTransactions;
        return support * 100; 

    }

    public double calculateConfidence(ArrayList<String> A, ArrayList<String> B, ArrayList<ArrayList<String>> transactions) {

        Set<String> AB = new LinkedHashSet<>(A);
        AB.addAll(B);
        ArrayList<String> set = new ArrayList<>(AB);
        double confidence = (double) calculateSupportCount(set, transactions) / (double) calculateSupportCount(A, transactions);
        return confidence * 100;

    }

    public void setMinSupport(double support) { this.minSupport = support; }

    public void setMinCofidence(double confidence) { this.minConfidence = confidence; }

    // public double calculateConfidence()

    //public double calculateSupport(ArrayList<String> A, ArrayList<String> B,  ArrayList<ArrayList<String>> transactions) {



   //}
}