package PicoEngine.math;

/**
 * A terribly simple Bang-Bang system
 */
public class BangBangSolver {
    int setpoint = 0;

    public void setSetpoint(int x) {
        this.setpoint = x;
    }
    
    public int compute(int input) {
        if (input == setpoint) {
            return 0;
        }
        
        if (input < setpoint) {
            return -1;
        }
        return 1;
    }
}