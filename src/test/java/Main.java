import entity.EntitySample;
import org.junit.Test;
import services.RelationalServices;

public class Main {


    @Test
    public void main() {
        RelationalServices<EntitySample> relationalServices = new RelationalServices<>();
        System.out.println(relationalServices.getQuery(new EntitySample()));
    }
}
