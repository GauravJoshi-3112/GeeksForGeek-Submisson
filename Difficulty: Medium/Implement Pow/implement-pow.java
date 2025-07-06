// User function Template for Java
class Solution {
    
    double powerHelp(double b, int e) {
        double value = 1;
        if (e == 0) return value;
        
        value = powerHelp(b, e/2);
        
        if (e%2 == 0) value = value*value;
        else value = value*value*b;
        
        return value;
    }
    double power(double b, int e) {
        // code here
        double result = powerHelp(b, Math.abs(e));
        return e > 0 ? result : 1/result;
    }
}