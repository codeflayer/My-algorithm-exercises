package timeWheel;


/**
 * @author guest
 */
public abstract class TimerTask implements Runnable {

    /**
     * timestamp in millisecond
     */
    protected Long delayMs = 30000L;

    protected TimerTaskEntry timerTaskEntry;

    public void cancel() {
        synchronized (this) {
            if (timerTaskEntry != null) {
                timerTaskEntry.remove();
            }
            timerTaskEntry = null;
        }
    }

    public void setTimerTaskEntry(TimerTaskEntry entry) {
        // if this timerTask is already held by an existing timer task entry,
        // we will remove such an entry first.
        synchronized (this) {
            if (timerTaskEntry != null && timerTaskEntry != entry) {
                timerTaskEntry.remove();
            }
            timerTaskEntry = entry;
        }
    }

    @Override
    public void run() {
        System.out.println("do the job");
    }

    public TimerTaskEntry getTimerTaskEntry() {
        return timerTaskEntry;
    }

    public Long getDelayMs() {
        return delayMs;
    }
}
