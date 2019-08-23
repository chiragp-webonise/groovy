package com.todo.dataaccess
import com.google.inject.Provider
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.conf.Settings
import org.jooq.impl.DSL

import javax.sql.DataSource

@Slf4j
@CompileStatic
class DSLContextProvider implements Provider<DSLContext> {

    private final DataSource dataSource
    private final Boolean isReadOnly

    DSLContextProvider(DataSource dataSource, final Boolean isReadOnly) {
        this.dataSource = dataSource
        this.isReadOnly = isReadOnly
    }

    DSLContext get() {
        /**
         *  .withExecuteLogging (false) is added to avoid printing of logs from jooq so performance will not be
         *  affected -- Suggested by Sudarshan.
         */
        Settings settings = new Settings().withRenderSchema(false).withExecuteLogging(false)
        DSL.using(dataSource, SQLDialect.MYSQL, settings)
    }
}