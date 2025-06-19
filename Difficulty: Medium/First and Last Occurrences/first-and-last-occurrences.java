// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        int start = 0, end = arr.length - 1;
        // Floor
        int result = arr.length;
        while (start <= end) {
            int mid = (start + (end-start)/2);
            if (arr[mid] == x) {
                result = Math.min(result, mid);
                end = mid - 1;
            } 
            else if (arr[mid] < x) start = mid + 1;
            else end = mid - 1;
        }
        result = result == arr.length ? -1 : result;
        list.add(result);
        
        // Ceil
        result = -1;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = (start + (end-start)/2);
            if (arr[mid] == x) {
                result = Math.max(result, mid);
                start = mid + 1;
            } 
            else if (arr[mid] < x) start = mid + 1;
            else end = mid - 1;
        }
        list.add(result);
        
        return list;
    }
}
