package builder.sqlCommand;

/**
 * @author alireza_bayat
 */
public interface SQLCommands<E> extends SQL_DCL<E>, SQL_DDL<E>, SQL_DML<E>, SQL_DQL<E>, SQL_TCL<E> {

    //DQL
    String getQuery(E e);

}
