import com.hades.builder.sqlCommand.clauserBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauserBuilder.filter.FilterClause;
import com.hades.builder.sqlCommand.clauserBuilder.join.JoinClause;
import com.hades.model.enumeration.relational.JoinTypes;
import com.hades.model.type.Selection;
import com.hades.services.RelationalServices;
import entity.EntitySample;
import entity.ReferencedEntitySample;
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
        FilterClause<EntitySample> filterClause = new FilterClause<>(EntitySample.class);
        filterClause
                .equal("id", "10000")
                .and().equal("name", "harchi")
                .or().equal("family", "harchiiii")
                .and().in("id", "1", "2", "3", "4")
                .or().notIn("id", "5", "6", "7");

        JoinClause<EntitySample> joinClause = new JoinClause<EntitySample>(EntitySample.class);
        joinClause.join(ReferencedEntitySample.class, "listing_type_id", "id", JoinTypes.LEFT_JOIN);

        clauseBuilder.setFilterClause(filterClause);
        clauseBuilder.setJoinClause(joinClause);
        System.out.println("select with where clause -> " + relationalServices.findAll(new EntitySample(), clauseBuilder));
    }

}
