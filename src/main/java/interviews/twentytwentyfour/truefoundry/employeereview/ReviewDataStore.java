package interviews.twentytwentyfour.truefoundry.employeereview;

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
        pq = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
    }

    // TC: O(1)
    public void insert(Review review) {
        // create Pair<employeeId, avgRating>
        Pair<Integer, Double> pair = new Pair<>(review.employeeId, getAvgRatingByEmployeeId(review.employeeId));
        // then remove it from the pq
        pq.remove(pair);

        employeeIdToReviewMap.computeIfAbsent(review.employeeId, k->new ArrayList<>()).add(review);
        reviewerIdToReviewMap.computeIfAbsent(review.reviewerId, k->new ArrayList<>()).add(review);

        // then add new sum of rating to employeeIdToRatingSumMap
        employeeIdToRatingSumMap.put(
                review.employeeId, employeeIdToRatingSumMap.getOrDefault(review.employeeId, 0d) + review.rating);
        // create new Pair<employeeId, avgRating> and insert in PQ
        pq.add(new Pair<>(review.employeeId, getAvgRatingByEmployeeId(review.employeeId)));
    }

    // TC: O(1)
    public List<Review> getReviewsByEmployeeId(int employeeId) {
        return employeeIdToReviewMap.get(employeeId);
    }

    // TC: O(1)
    public List<Review> getReviewsByReviewerId(int reviewerId) {
        return reviewerIdToReviewMap.get(reviewerId);
    }

    // TC: O(1)
    public double getAvgRatingByEmployeeId(int employeeId) {
        Double ratingSum = employeeIdToRatingSumMap.get(employeeId);

        if (ratingSum == null)
            return 0;

        return ratingSum/employeeIdToReviewMap.get(employeeId).size();
    }

    // TC: O(n), n = total no. of reviews
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

    // TC: O(nlogn), n = no. of employees, it takes O(nlogn) time to the build PQ and O(klogn) time to retrieve top k performers
    /*public List<Pair<Integer, Double>> getTopPerformers(int k) {
        pq = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        List<Pair<Integer, Double>> result = new ArrayList<>();

        for (int employeeId: employeeIdToReviewMap.keySet()) {
            pq.add(new Pair<>(employeeId, getAvgRatingByEmployeeId(employeeId)));
        }

        while (k-- > 0) {
            result.add(pq.poll());
        }

        return result;
    }*/

    // TC: O(klogn), n = no. of employees, k = top k performers, it takes O(klogn) time to retrieve top k performers
    public List<Pair<Integer, Double>> getTopPerformers(int k) {
        List<Pair<Integer, Double>> result = new ArrayList<>();

        while (k-- > 0) {
            result.add(pq.poll());
        }

        pq.addAll(result);

        return result;
    }
}
