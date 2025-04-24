package com.vm.genAICoPilot.service;

import com.vm.genAICoPilot.model.Policy;
import com.vm.genAICoPilot.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    // Create or save a policy
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    // Get all policies
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    // Get a policy by policy number
    public Optional<Policy> getPolicyByPolicyNo(String policyNo) {
        return policyRepository.findById(policyNo);
    }

    // Update a policy
    public Policy updatePolicy(String policyNo, Policy updatedPolicy) {
        if (policyRepository.existsById(policyNo)) {
            updatedPolicy.setPolicyNo(policyNo);
            return policyRepository.save(updatedPolicy);
        }
        return null;
    }

    // Delete a policy
    public boolean deletePolicy(String policyNo) {
        if (policyRepository.existsById(policyNo)) {
            policyRepository.deleteById(policyNo);
            return true;
        }
        return false;
    }
}