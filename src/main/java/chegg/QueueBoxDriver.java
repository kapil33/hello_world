package chegg;

public class QueueBoxDriver {
    public static void main(String[] args) {
        QueueBox q = new QueueBox();
        createQueue(q);
        destroyQueue(q);

        while (!q.isEmpty()){
            q.remove();
        }
    }

    //adds 60,000 integers
    public static QueueBox createQueue(QueueBox q){
        for (int i=0; i<60000; i++){
            q.add(i);
        }
        return q;
    }

    public static QueueBox destroyQueue(QueueBox q){
        for (int i=0; i<50000; i++){
            q.remove();
        }
        return q;
    }
}
