package com.fang.springmongodb.employee.repository;

import com.fang.springmongodb.employee.domain.Employee;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    MongoOperations mongoOperations;

    public Employee findEmployeeById(String id) {
        return mongoOperations.findById(id, Employee.class);
    }

    @Override
    public Employee findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoOperations.findOne(query, Employee.class);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return mongoOperations.findAll(Employee.class);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        mongoOperations.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Document document = new Document();
        mongoOperations.getConverter().write(employee, document);
        Update update = new Update();
        document.forEach(update::set);
        return mongoOperations.findAndModify(
                Query.query(Criteria.where("id").is(employee.getId())), update, Employee.class);
    }

    public void deleteEmployee(String id) {
        Employee employee = findEmployeeById(id);
        mongoOperations.remove(employee);
    }
}
