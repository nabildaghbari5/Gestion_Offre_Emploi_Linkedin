package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.servicesImp.request.FilterCompany;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CompanySpecifications {

    public static Specification<Bccompanies> filterCompany(FilterCompany company) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (company.getNamecompany() != null && !company.getNamecompany().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("namecompany")), "%" + company.getNamecompany() + "%"));
            }

            if (company.getFiscalcodecompany() != null && !company.getFiscalcodecompany().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("fiscalcodecompany")), "%" + company.getFiscalcodecompany() + "%"));
            }

            if (company.getTypecompany() != null) {
                predicates.add(cb.equal(root.get("typecompany"), company.getTypecompany()));
            }

            if (company.getAssociatedgroup() != null) {
                predicates.add(cb.equal(root.get("associatedgroup"), company.getAssociatedgroup()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
