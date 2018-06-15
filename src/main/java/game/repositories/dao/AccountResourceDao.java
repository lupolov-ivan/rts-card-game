package game.repositories.dao;

import game.repositories.entities.AccountResourceEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface AccountResourceDao {
    List<AccountResourceEntity> getListOfAccountResources(Integer accountId, Integer lastTime);
}
