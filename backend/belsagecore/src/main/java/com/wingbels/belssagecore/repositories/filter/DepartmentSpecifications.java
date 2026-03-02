package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.servicesImp.request.FilterDepartment;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecifications {

    public static Specification<Bcdepartments> filterDepartments(FilterDepartment department) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (department.getCodedept() != 0) {
                predicates.add(cb.equal(root.get("codedept"), department.getCodedept()));
            }
            if (department.getNamedepartment() != null && !department.getNamedepartment().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("namedepartment")), "%" + department.getNamedepartment() + "%"));
            }
            if (department.getManagerdepartement() != null) {
                predicates.add(cb.equal(root.get("managerdepartement"), department.getManagerdepartement()));
            }
            if (department.getAssociatedcompany() != null) {
                predicates.add(cb.equal(root.get("associatedcompany"), department.getAssociatedcompany()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
