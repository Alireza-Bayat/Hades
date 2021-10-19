package builder.sqlCommand;

import builder.sqlCommand.clauserBuilder.ClauseBuilder;
import model.type.EntityType;
import model.type.Selection;

/**
 * @author alireza_bayat
 */
public interface SQLCommands<E extends EntityType> {

    //<editor-fold defaultstate="collapsed" desc="DQL">
    String findAll(E e);

    String findAll(E e, String... fieldsName);

    String findAll(E e, Selection... selections);

    String findAll(E e, ClauseBuilder clauseBuilder);

    String findAll(E e, ClauseBuilder clauseBuilder, String... fieldsName);
    //</editor-fold>

}
