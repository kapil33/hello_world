package interviews.twentytwentyfour.truefoundry.employeereview;

public class ReviewManager {
    public static void main(String[] args) {
        ReviewDataStore reviewDataStore = new ReviewDataStore();
        reviewDataStore.insert(new Review(1, 101, 4.5, "Excellent work", "2024-04-20"));
        reviewDataStore.insert(new Review(1, 102, 3.8, "Good effort", "2024-04-22"));
        reviewDataStore.insert(new Review(2, 101, 4.2, "Consistently meets expectations", "2024-04-23"));
        reviewDataStore.insert(new Review(3, 103, 4.8, "Outstanding performance", "2024-04-25"));

        System.out.println(reviewDataStore.getReviewsByEmployeeId(1));
        System.out.println(reviewDataStore.getAvgRatingByEmployeeId(1));
        System.out.println(reviewDataStore.getReviewsByReviewerId(101));
        System.out.println(reviewDataStore.getReviewsInDateRange("2024-04-22", "2024-04-24"));
        System.out.println(reviewDataStore.getTopPerformers(2));
    }
}
