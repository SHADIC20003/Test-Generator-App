

/**
 * A simple java stopwatch
 */
public class StopWatch {
    private long startTime;
    private long stopTime = -1;
     private static long Ttime;
     private static int Number_of_times=0;
     private long Average;
    /**
     * Starts the timer
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the timer
     */
    public void stop() {
        stopTime = System.currentTimeMillis();
    }
    // The total time for taking any number of tests. 
    public static void Totalelapsedtime(long startTime, long stopTime)
    {
        if (stopTime >= 0) {
           Ttime+=  stopTime - startTime;
           Number_of_times++;
        }
        else
        {
        Ttime+= System.currentTimeMillis() - startTime;
        Number_of_times++;
        }
    }
    
 // This method calculates The average time taken to finish several number of tests. 
        // The average number of tests taken.

    public long average()
    {
       Average= Ttime/Number_of_times;
       return Average;
    }
    public long elapsed() {
        if (stopTime >= 0)
        {
            Totalelapsedtime(startTime,stopTime);
            return stopTime - startTime;
        }
        else
        {
          Totalelapsedtime(startTime,stopTime);
        return System.currentTimeMillis() - startTime;
        }
    }

    /**
     *
     * @return Time formatted in Hours:Minutes:Seconds:milliseconds format
     */
    @Override
    public String toString() {
        long milliseconds = elapsed();
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        int millis  = (int) (milliseconds - (seconds * 1000) - (minutes * 1000 * 60) - (hours * 1000 * 60 * 60));
        return String.format("%dh, %dmin, %ds, %dms", hours, minutes, seconds, millis);
    }

    // @return The "Average Time to finish a test" in the following format -> Hours:Minutes:Seconds:milliseconds
// The average time is calculated based on the Time taken to finsh each test separately divided by the number of tests taken by the user.
     public String AverageTimeString() {
        long milliseconds = average();
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        int millis  = (int) (milliseconds - (seconds * 1000) - (minutes * 1000 * 60) - (hours * 1000 * 60 * 60));
        return String.format("%dh, %dmin, %ds, %dms", hours, minutes, seconds, millis);
    }
}