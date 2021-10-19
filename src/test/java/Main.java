import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import entity.EntitySample;
import com.hades.model.type.Selection;
import org.junit.Test;
import com.hades.services.RelationalServices;

import java.util.ArrayList;
import java.util.List;

public class Main {


    @Test
    public void selectQuery() {
        RelationalServices<EntitySample> relationalServices = new RelationalServices<>();
        System.out.println("select all -> " + relationalServices.findAll(new EntitySample()));
    }

    @Test
    public void customizedSelectQuery() {
        RelationalServices<EntitySample> relationalServices = new RelationalServices<>();
        System.out.println("select varargs -> " + relationalServices.findAll(new EntitySample(), "id", "name", "Type", "asda"));
    }

    @Test
    public void customizedSelectQueryWithSelection() {
        RelationalServices<EntitySample> relationalServices = new RelationalServices<>();
        List<Selection> selections = new ArrayList<>();
        selections.add(new Selection("id"));
        System.out.println("selection varargs -> " + relationalServices.findAll(new EntitySample(), selections.toArray(new Selection[0])));
    }

    @Test
    public void selectQueryWithCriteria() {
        RelationalServices<EntitySample> relationalServices = new RelationalServices<>();
        System.out.println("select with where clause -> " + relationalServices.findAll(new EntitySample(), new ClauseBuilder()));
    }
}
