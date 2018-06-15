package game.repositories.dao.impl;

import game.repositories.dao.AccountResourceDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountResourceEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceDaoImpl implements AccountResourceDao {

    private final String QUERY = "select AR.account_id, " +
            "       AR.resource_id, " +
            "       AR.number, " +
            "       total_num_per_minutes  from (" +
            "            select resource_id, " +
            "                   sum(num_per_minutes) total_num_per_minutes from (" +
            "                           select AB.building_id, " +
            "                                BP.resource_id, " +
            "                                (BP.number_per_sec * AB.number) num_per_minutes " +
            "                                from Account_Building AB " +
            "                           left join Building_Product BP on AB.building_id = BP.building_id " +
            "                            where AB.account_id = ?) res_per_minute " +
            "            group by resource_id) res_quantity_per_minutes " +
            "left join Account_Resource AR on AR.resource_id = res_quantity_per_minutes.resource_id " +
            "where account_id = ?;";


    @Override
    public List<AccountResourceEntity> getListOfAccountResources(Integer accountId, Integer lastTime) {
        return new QueryHelper<List<AccountResourceEntity>>(){
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountResourceEntity> accountResources = new LinkedList<>();

                Integer currTime = 5;
                Integer deltaTime = currTime - lastTime;

                PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

                preparedStatement.setInt(1, accountId);
                preparedStatement.setInt(2, accountId);

                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()) {

                    updateResourceNumber(rs, deltaTime);

                    AccountResourceEntity accountResource = new AccountResourceEntity(
                            rs.getInt("account_id"),
                            rs.getInt("resource_id"),
                            rs.getInt("number"),
                            rs.getInt("total_num_per_minutes")
                    );
                    accountResources.add(accountResource);
                }
                returnResult(accountResources);
            }
        }.run();
    }
    //TODO: Делать апдейт только для текущего пользователя, из токена > юзер > акк_id
    private void updateResourceNumber(ResultSet rs, Integer deltaTime) {
        new QueryHelper() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "UPDATE Account_Resource SET number = number + (? * ?) " +
                        "WHERE account_id = ? AND resource_id = ?");
                preparedStatement.setInt(1, rs.getInt("total_num_per_minutes"));
                preparedStatement.setInt(2, deltaTime);
                preparedStatement.setInt(3, rs.getInt("account_id"));
                preparedStatement.setInt(4, rs.getInt("resource_id"));
                preparedStatement.executeUpdate();
            }
        }.run();
    }

    //TODO: минусовать здания если не хватает ресуросов, которые он подтребляет


}
