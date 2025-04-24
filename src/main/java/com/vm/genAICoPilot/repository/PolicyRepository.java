package com.vm.genAICoPilot.repository;

import com.vm.genAICoPilot.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, String> {
}