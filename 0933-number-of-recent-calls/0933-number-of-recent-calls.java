import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the new request
        requests.add(t);

        // Remove requests older than t - 3000
        while (requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the number of requests in the valid range
        return requests.size();
    }
}