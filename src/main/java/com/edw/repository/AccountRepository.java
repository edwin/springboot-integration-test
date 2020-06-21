package com.edw.repository;

import com.edw.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 *     com.edw.repository.AccountRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Jun 2020 22:03
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
