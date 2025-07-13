/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        Stack<Integer> reverse = new Stack<>();
        
        while (!s.isEmpty()) {
            int element = s.pop();
            int shift = 0;
            while ((!reverse.isEmpty()) && (reverse.peek() > element)) {
                s.push(reverse.pop());
                shift++;
            } 
            
            reverse.push(element);
            
            while (shift > 0) {
                reverse.push(s.pop());
                shift--;
            }
        }
        
        return reverse;
    }
}