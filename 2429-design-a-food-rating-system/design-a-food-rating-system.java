//arinjayjha
import java.util.*;

class FoodRatings {
    private static class Entry {
        int rating;
        String name;
        Entry(int r, String n) { rating = r; name = n; }
    }
    private final Map<String, String> foodToCuisine;
    private final Map<String, Integer> foodToRating;
    private final Map<String, PriorityQueue<Entry>> cuisineToPQ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToPQ = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);
            cuisineToPQ.computeIfAbsent(c, k -> new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) return Integer.compare(b.rating, a.rating);
                return a.name.compareTo(b.name);
            })).offer(new Entry(r, f));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        cuisineToPQ.get(cuisine).offer(new Entry(newRating, food));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Entry> pq = cuisineToPQ.get(cuisine);
        while (true) {
            Entry top = pq.peek();
            if (top == null) return "";
            int current = foodToRating.get(top.name);
            if (top.rating == current) return top.name;
            pq.poll();
        }
    }
}
