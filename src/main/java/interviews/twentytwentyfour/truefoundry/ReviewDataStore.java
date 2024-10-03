package interviews.twentytwentyfour.truefoundry;

import javafx.util.Pair;

import java.time.LocalDate;
import java.util.*;

public class ReviewDataStore {
    Map<Integer, List<Review>> employeeIdToReviewMap;
    Map<Integer, List<Review>> reviewerIdToReviewMap;
    Map<Integer, Double> employeeIdToRatingSumMap;
    PriorityQueue<Pair<Integer, Double>> pq;


    public ReviewDataStore() {
        this.employeeIdToReviewMap = new HashMap<>();
        this.reviewerIdToReviewMap = new HashMap<>();
        this.employeeIdToRatingSumMap = new HashMap<>();
        pq = new PriorityQueue();
    }

    public void insert(Review review) {
        employeeIdToReviewMap.computeIfAbsent(review.employeeId, k->new ArrayList<>()).add(review);
        reviewerIdToReviewMap.computeIfAbsent(review.reviewerId, k->new ArrayList<>()).add(review);
        employeeIdToRatingSumMap.put(
                review.employeeId, employeeIdToRatingSumMap.getOrDefault(review.employeeId, 0.0) + review.rating);
    }

    public List<Review> getReviewsByEmployeeId(int employeeId) {
        return employeeIdToReviewMap.get(employeeId);
    }

    public List<Review> getReviewsByReviewerId(int reviewerId) {
        return reviewerIdToReviewMap.get(reviewerId);
    }

    public double getAvgRatingByEmployeeId(int employeeId) {
        return employeeIdToRatingSumMap.get(employeeId)/employeeIdToReviewMap.get(employeeId).size();
    }

    public List<Review> getReviewsInDateRange(String start, String end) {
        LocalDate startDate = DateUtility.getLocalDate(start);
        LocalDate endDate = DateUtility.getLocalDate(end);
        List<Review> result = new ArrayList<>();

        for (int employeeId: employeeIdToReviewMap.keySet()) {
            for (Review review: employeeIdToReviewMap.get(employeeId)) {
                if (review.reviewDate.isEqual(startDate) || review.reviewDate.isEqual(endDate)
                || (review.reviewDate.isAfter(startDate) && review.reviewDate.isBefore(endDate)))
                    result.add(review);
            }
        }

        return result;
    }

    public List<Pair<Integer, Double>> getTopPerformers(int n) {
        pq = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        List<Pair<Integer, Double>> result = new ArrayList<>();

        for (int employeeId: employeeIdToReviewMap.keySet()) {
            pq.add(new Pair<>(employeeId, getAvgRatingByEmployeeId(employeeId)));
        }

        while (n-- > 0) {
            result.add(pq.poll());
        }

        return result;
    }
}
