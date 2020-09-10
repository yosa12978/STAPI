package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yosa.stapi.domain.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByUsername(String username);
}
