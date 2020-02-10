package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree690
 * @Author: markey
 * @Description:
 * @Date: 2020/2/9 16:37
 * @Version: 1.0
 */
public class Tree690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }

        int res = 0;
        List<Integer> list = new ArrayList<>();
        list.add(id);

        while (!list.isEmpty()) {
            Employee employee = map.get(list.get(0));
            res += employee.importance;
            list.remove(0);
            list.addAll(employee.subordinates);
        }
        return res;
    }

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
