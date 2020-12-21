package by.aginskiy.figure.model.warehouse;

import by.aginskiy.figure.model.entity.QuadrangleCondition;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleConditionWarehouse {

    private static QuadrangleConditionWarehouse warehouse = new QuadrangleConditionWarehouse();
    private Map<Long, QuadrangleCondition> conditions;

    private QuadrangleConditionWarehouse() {
        conditions = new HashMap<>();
    }

    public static QuadrangleConditionWarehouse getWarehouse() {
        return warehouse;
    }

    public int size() {
        return conditions.size();
    }

    public QuadrangleCondition get(Integer key) {
        return conditions.get(key);
    }

    public QuadrangleCondition put(Long key, QuadrangleCondition value) {
        return conditions.put(key, value);
    }

    public QuadrangleCondition remove(Integer key) {
        return conditions.remove(key);
    }
}
