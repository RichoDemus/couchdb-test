package com.richodemus.test.couchdb;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;

import java.util.List;

public class UserRepository extends CouchDbRepositorySupport<User>
{
    public UserRepository(CouchDbConnector db) {
        super(User.class, db);
        initStandardDesignDocument();
    }

    @GenerateView
    public List<User> findByName(String name) {
            return queryView("by_name", name);
    }
}
