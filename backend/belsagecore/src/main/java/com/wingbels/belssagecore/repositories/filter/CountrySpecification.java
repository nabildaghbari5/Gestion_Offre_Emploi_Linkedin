package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bccountries;
import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.servicesImp.request.FilterCountry;
import com.wingbels.belssagecore.servicesImp.request.FilterDepartment;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CountrySpecification {
    public static Specification<Bccountries> filterCountries(FilterCountry country) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (country.getCodecountry() != null && !country.getCodecountry().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("codecountry")), "%" + country.getCodecountry() + "%"));
            }

            if (country.getCountrydescription() != null && !country.getCountrydescription().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("countrydescription()")), "%" + country.getCountrydescription() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
