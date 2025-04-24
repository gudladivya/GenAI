package com.vm.genAICoPilot.controller;

import com.vm.genAICoPilot.model.Policy;
import com.vm.genAICoPilot.service.PolicyService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private PolicyService policyService;

    private List<Policy> policies = new ArrayList<>();

    // Create a new policy
    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        policies.add(policy);
        return policy;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Hello World";
    }
    // Get all policies
    @GetMapping("/all")
    public List<Policy> getAllPolicies() {
        //return List.of(new Policy());
        return policyService.getAllPolicies();
    }

    // Get a policy by policy number
    @GetMapping("/{policyNo}")
    public Policy getPolicyByPolicyNo(@PathVariable String policyNo) {
        return policies.stream()
                .filter(policy -> policy.getPolicyNo().equals(policyNo))
                .findFirst()
                .orElse(null);
    }

    // Update a policy
    @PutMapping("/{policyNo}")
    public Policy updatePolicy(@PathVariable String policyNo, @RequestBody Policy updatedPolicy) {
        for (int i = 0; i < policies.size(); i++) {
            if (policies.get(i).getPolicyNo().equals(policyNo)) {
                policies.set(i, updatedPolicy);
                return updatedPolicy;
            }
        }
        return null;
    }

    // Delete a policy
    @DeleteMapping("/{policyNo}")
    public String deletePolicy(@PathVariable String policyNo) {
        policies.removeIf(policy -> policy.getPolicyNo().equals(policyNo));
        return "Policy with PolicyNo " + policyNo + " has been deleted.";
    }
}