import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClauseImpl;
import com.hades.model.type.Selection;
import com.hades.services.RelationalServices;
import entity.EntitySample;
import org.junit.Test;

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
        ClauseBuilder<EntitySample> clauseBuilder = new ClauseBuilder<>();
        FilterClauseImpl<EntitySample> filterClauseImpl = new FilterClauseImpl<>();
        filterClauseImpl.equal(new EntitySample(), "id", "10000")
                .and().equal(new EntitySample(), "name", "harchi")
                .or().equal(new EntitySample(), "family", "harchiiii")
                .and().in(new EntitySample(), "id", "1", "2", "3", "4")
                .or().notIn(new EntitySample(), "id", "5", "6", "7");

        clauseBuilder.setFilterClause(filterClauseImpl);
        System.out.println("select with where clause -> " + relationalServices.findAll(new EntitySample(), clauseBuilder));
    }

}
