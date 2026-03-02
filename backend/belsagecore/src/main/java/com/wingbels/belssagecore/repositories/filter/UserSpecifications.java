package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bcprofiles;
import com.wingbels.belssagecore.entities.Bcusers;
import com.wingbels.belssagecore.enumerations.Bcroleuser;
import com.wingbels.belssagecore.servicesImp.request.FilterUser;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {

    public static Specification<Bcusers> filterUsers(FilterUser user) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (user.getUsername() != null && !user.getUsername().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("username")), "%" + user.getUsername() + "%"));
            }

            if (user.getNameusers() != null && !user.getNameusers().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nameusers")), "%" + user.getNameusers() + "%"));
            }

            if (user.getSurnameusers() != null && !user.getNameusers().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("surnameusers")), "%" + user.getSurnameusers() + "%"));
            }

            if (user.getAssociatedemployeeuser() != null) {
                predicates.add(cb.equal(root.get("associatedemployeeuser"), user.getAssociatedemployeeuser()));
            }

            if (user.getRoles() != null) {
                predicates.add(cb.equal(root.get("roles"), user.getRoles()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
