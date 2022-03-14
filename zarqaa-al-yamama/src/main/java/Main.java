import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.oss.driver.*;

public class Main {
    public static void main(String[] args) {
        try (CqlSession session = CqlSession.builder().withKeyspace("main").build()){
            ResultSet resultSet = session.execute("select * from student where class_id = 1");
            for(Row r : resultSet){
                System.out.println(r.get("first_name", String.class));
            }
        }
    }
}
