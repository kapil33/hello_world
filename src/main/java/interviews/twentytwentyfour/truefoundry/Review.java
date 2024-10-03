package interviews.twentytwentyfour.truefoundry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Review {
    int employeeId;
    int reviewerId;
    double rating;
    String comments;
    LocalDate reviewDate;

    public Review(int employeeId, int reviewerId, double rating, String comments, String reviewDate) {
        this.employeeId = employeeId;
        this.reviewerId = reviewerId;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = DateUtility.getLocalDate(reviewDate);
    }

    @Override
    public String toString() {
        return "Review{" +
                "employeeId=" + employeeId +
                ", reviewerId=" + reviewerId +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                '}' + "\n";
    }
}

class DateUtility {
    public static LocalDate getLocalDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.from(dtf.parse(date));
    }
}
