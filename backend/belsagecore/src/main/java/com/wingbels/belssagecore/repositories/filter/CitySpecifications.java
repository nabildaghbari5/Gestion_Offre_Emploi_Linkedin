package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.servicesImp.request.FilterCity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CitySpecifications {

    public static Specification<Bccities> filterCities(FilterCity city) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (city.getNamecity() != null && !city.getNamecity().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("namecity")), "%" + city.getNamecity() + "%"));
            }
            if (city.getCountrycity() != null) {
                predicates.add(cb.equal(root.get("countrycity"), city.getCountrycity()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
