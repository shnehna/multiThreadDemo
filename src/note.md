事务的手动回滚：
    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
String sql = "select * from " + tableName;
            Connection connection = SqlSessionUtils.getSqlSession(
                template.getSqlSessionFactory(), template.getExecutorType(),
                template.getPersistenceExceptionTranslator()).getConnection();
            ResultSetMetaData metaData = connection.prepareStatement(sql)
                .executeQuery(sql)
                .getMetaData();
            int metaSize = metaData.getColumnCount();
            String[] columns = new String[metaSize];
            String[] columnTypes = new String[metaSize];
            for (int i = 0; i < metaSize; i++)
            {
                columns[i] = metaData.getColumnName(i + 1);
                columnTypes[i] =
                    metaData.getColumnTypeName(i + 1) + "(" + metaData.getColumnType(i + 1) + ")";
            }