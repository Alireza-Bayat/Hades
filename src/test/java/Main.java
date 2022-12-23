import com.hades.builder.sqlCommand.clauseBuilder.ClauseBuilder;
import com.hades.builder.sqlCommand.clauseBuilder.filter.FilterClause;
import com.hades.builder.sqlCommand.clauseBuilder.filter.SQLFilterClause;
import com.hades.builder.sqlCommand.clauseBuilder.join.JoinClause;
import com.hades.builder.sqlCommand.clauseBuilder.join.SQLJoinClause;
import com.hades.builder.sqlCommand.clauseBuilder.order.OrderClause;
import com.hades.builder.sqlCommand.clauseBuilder.order.SQLOrderClause;
import com.hades.model.enumeration.relational.JoinTypes;
import com.hades.model.enumeration.relational.OrderArrange;
import com.hades.model.type.Selection;
import com.hades.services.RelationalServices;
import entity.EntitySample;
import entity.ReferencedEntitySample;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    RelationalServices<EntitySample> relationalServices = null;
    ClauseBuilder<EntitySample> clauseBuilder = null;
    SQLFilterClause<EntitySample> filterClause = null;
    SQLJoinClause<EntitySample> joinClause = null;
    SQLOrderClause<EntitySample> orderClause = null;

    @Before
    public void setUp() {
        relationalServices = new RelationalServices<>();
        clauseBuilder = new ClauseBuilder<>();
        filterClause = new FilterClause<>(EntitySample.class);
        joinClause = new JoinClause<>(EntitySample.class);
        orderClause = new OrderClause<>(EntitySample.class);
    }


    @Test
    public void selectQuery() {
        System.out.println("select all -> " + relationalServices.findAllQuery(new EntitySample()));
    }

    @Test
    public void customizedSelectQuery() {
        System.out.println("select varargs -> " + relationalServices.findAllQuery(new EntitySample(), "id", "name", "Type", "asda"));
    }

    @Test
    public void customizedSelectQueryWithSelection() {
        List<Selection> selections = new ArrayList<>();
        selections.add(new Selection("id"));
        System.out.println("selection varargs -> " + relationalServices.findAllQuery(new EntitySample(), selections.toArray(new Selection[0])));
    }

    @Test
    public void selectQueryWithCriteria() {
        filterClause
                .equal("id", "10000")
                .and().equal("name", "harchi")
                .or().equal("family", "harchiiii")
                .and().in("id", "1", "2", "3", "4")
                .or().notIn("id", "5", "6", "7");

        joinClause.join(ReferencedEntitySample.class, "listing_type_id", "id", JoinTypes.LEFT_JOIN);

        orderClause.order("id", null).order("family", OrderArrange.DESC);

        clauseBuilder.setFilterClause(filterClause);
        clauseBuilder.setJoinClause(joinClause);
        clauseBuilder.setOrderClause(orderClause);

        System.out.println("select with where clause -> " + relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void selectQueryWithCriteriaCustomized() {
        filterClause
                .equal("id", 10000)
                .and().equal("name", "harchi")
                .or().equal("family", "harchiiii")
                .and().in("id", 1, 2, "1", "2")
                .or().notIn("id", "5", "6", "7")
                .or().customClause("listing.id = 1").and().customClause("listing_type.create_date is not null");

        joinClause.join(ReferencedEntitySample.class, "listing_type_id", "id", JoinTypes.LEFT_JOIN);

        orderClause.order("id", null).order("family", OrderArrange.DESC);

        clauseBuilder.setFilterClause(filterClause);
        clauseBuilder.setJoinClause(joinClause);
        clauseBuilder.setOrderClause(orderClause);

        System.out.println("select with where clause customized -> " + relationalServices.findAllQuery(new EntitySample(), clauseBuilder, "listing_type.id", "listing.id"));
    }


    @Test
    public void inAndNotInQueries() {
        filterClause.in("property_type_id", "select id from propertyTypes").and().notIn("listing_type_id", 1, 2);
        clauseBuilder.setFilterClause(filterClause);
        System.out.println(relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void and_multiLine() {
        filterClause.equal("id", 1).and("id not in (123,12)");
        clauseBuilder.setFilterClause(filterClause);
        System.out.println(relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void exists() {
        filterClause.equal("id", 1).and().exists("select id from foo where foo.id = 12");
        clauseBuilder.setFilterClause(filterClause);
        System.out.println(relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void like() {
        filterClause.like("name", "%alireza%");
        clauseBuilder.setFilterClause(filterClause);
        System.out.println(relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void between() {
        filterClause.between("id", 1, 12);
        clauseBuilder.setFilterClause(filterClause);
        System.out.println(relationalServices.findAllQuery(new EntitySample(), clauseBuilder));
    }

    @Test
    public void insert() throws IllegalAccessException, InvocationTargetException {
        EntitySample entitySample = new EntitySample(10001,10002,10003,"name_field","family_field", Timestamp.valueOf(LocalDateTime.now()),1);

        System.out.println(relationalServices.insertQuery(entitySample));
    }


}
