public class Stats {

    private int testCounter;
    private double TotalTime;
    private int numberOfFails;
    private int numberOfPasses;
    private int numberOfQuestions;


    Stats(){

    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getTestCounter() {
        return testCounter;
    }

    public void setTestCounter(int testCounter) {
        this.testCounter = testCounter;
    }

    public double getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(double totalTime) {
        TotalTime = totalTime;
    }

    public int getNumberOfFails() {
        return numberOfFails;
    }

    public void setNumberOfFails(int numberOfFails) {
        this.numberOfFails = numberOfFails;
    }

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public void setNumberOfPasses(int numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }

    public double getAverageTime(int testCounter, double TotalTime){
        double AverageTime;
        AverageTime = TotalTime / testCounter;
        return AverageTime;
    }
}
