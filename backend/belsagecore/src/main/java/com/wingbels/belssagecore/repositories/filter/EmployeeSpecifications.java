package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.servicesImp.request.FilterEmployee;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bccontacts;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecifications {

	public static Specification<Bcemployees> filterEmployees(FilterEmployee filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getFirstnameemployee() != null && !filter.getFirstnameemployee().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("firstnameemployee")), "%" + filter.getFirstnameemployee().toLowerCase() + "%"));
            }
            if (filter.getLastnameemployee() != null && !filter.getLastnameemployee().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("lastnameemployee")), "%" + filter.getLastnameemployee().toLowerCase() + "%"));
            }
            if (filter.getGenderemployee() != null && !filter.getGenderemployee().isEmpty()) {
                predicates.add(cb.equal(root.get("genderemployee"), filter.getGenderemployee()));
            }
            if (filter.getCurrentpositionemployee() != null && !filter.getCurrentpositionemployee().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("currentpositionemployee")), "%" + filter.getCurrentpositionemployee().toLowerCase() + "%"));
            }
            if (filter.getCurrentmanageremployee() != null) {
                predicates.add(cb.equal(root.get("currentmanageremployee"), filter.getCurrentmanageremployee()));
            }
            if (filter.getCurrentdepartmentemployee() != null) {
                predicates.add(cb.equal(root.get("currentdepartmentemployee"), filter.getCurrentdepartmentemployee()));
            }

            if (filter.getTelephone() != null && !filter.getTelephone().isEmpty()) {
                Join<Bcemployees, Bccontacts> contactJoin = root.join("contactemployee");
                predicates.add(cb.and(
                    cb.equal(contactJoin.get("typecontact"), "phone"),
                    cb.like(cb.lower(contactJoin.get("valuecontact")), "%" + filter.getTelephone().toLowerCase() + "%")
                ));
            }
            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                Join<Bcemployees, Bccontacts> contactJoin = root.join("contactemployee");
                predicates.add(cb.and(
                    cb.equal(contactJoin.get("typecontact"), "email"),
                    cb.like(cb.lower(contactJoin.get("valuecontact")), "%" + filter.getEmail().toLowerCase() + "%")
                ));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
