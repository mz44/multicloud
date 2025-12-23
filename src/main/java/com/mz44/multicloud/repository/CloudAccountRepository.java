package com.mz44.multicloud.repository;

import com.mz44.multicloud.model.CloudAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CloudAccountRepository extends JpaRepository<CloudAccount, Long> {
    Optional<CloudAccount> findByUsername(String username);
}
