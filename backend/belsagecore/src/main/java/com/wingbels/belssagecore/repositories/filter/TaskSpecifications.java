package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bctask;
import com.wingbels.belssagecore.servicesImp.request.FilterTask;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TaskSpecifications {

    public static Specification<Bctask> filterTasks(FilterTask task) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (task.getTitle() != null && !task.getTitle().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + task.getTitle() + "%"));
            }

            if (task.getDescription() != null && !task.getDescription().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("description")), "%" + task.getDescription() + "%"));
            }

            if (task.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), task.getStatus()));
            }

            if (task.getAssignedTo() != null) {
                predicates.add(cb.equal(root.get("assignedTo"), task.getAssignedTo()));
            }

            if (task.getCreatedBy() != null) {
                predicates.add(cb.equal(root.get("createdBy"), task.getCreatedBy()));
            }

            if (task.getStartdate() != null) {
                predicates.add(cb.equal(root.get("startdate"), task.getStartdate()));
            }

            if (task.getEnddate() != null) {
                predicates.add(cb.equal(root.get("enddate"), task.getEnddate()));
            }

            if (task.getCreatedat() != null) {
                predicates.add(cb.equal(root.get("createdat"), task.getCreatedat()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
