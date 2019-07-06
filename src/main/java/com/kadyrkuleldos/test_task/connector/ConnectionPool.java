package com.kadyrkuleldos.test_task.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final static Log LOGGER = LogFactory.getLog(ConnectionPool.class);
    private static final int POOL_SIZE = 10;

    /* Class fields */
    private final BlockingQueue<Connection> pool;

    /* Constructor */
    private ConnectionPool() {
        pool = new ArrayBlockingQueue<>(POOL_SIZE);
        MySQLConnector connector = MySQLConnector.getInstance();
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection = connector.connect();
            pool.add(connection);
        }
    }

    /* Connection Pool Header */

    private static class ConnectionPoolHolder {
        private final static ConnectionPool POOL = new ConnectionPool();
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.POOL;
    }

    /**
     * Gets instance
     *
     * @return the connection
     */
    public Connection getConnection() {
        Connection result = null;
        try {
            result = pool.take();
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException", e);
        }
        return result;
    }

    /**
     * Return connection.
     *
     * @param connection the connection
     */
    public void returnConnection(Connection connection) {
        pool.add(connection);
    }

    /**
     * Close pool.
     */
    public void closePool() {
        for (Connection c : pool) {
            try {
                c.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

}
