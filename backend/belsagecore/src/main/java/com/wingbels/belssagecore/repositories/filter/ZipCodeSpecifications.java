package com.wingbels.belssagecore.repositories.filter;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.entities.Bczipcode;
import com.wingbels.belssagecore.servicesImp.request.FilterCity;
import com.wingbels.belssagecore.servicesImp.request.FilterZipcode;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeSpecifications {

    public static Specification<Bczipcode> filterZipcodes(FilterZipcode zipcode) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (zipcode.getCodezipcode() != null && !zipcode.getCodezipcode().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("codezipcode")), "%" + zipcode.getCodezipcode() + "%"));
            }
            if (zipcode.getLocationzipcode() != null && !zipcode.getLocationzipcode().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("locationzipcode")), "%" + zipcode.getLocationzipcode() + "%"));
            }
            if (zipcode.getCityzipcode() != null) {
                predicates.add(cb.equal(root.get("cityzipcode"), zipcode.getCityzipcode()));
            }
            if (zipcode.getCountryzipcode() != null) {
                predicates.add(cb.equal(root.get("countryzipcode"), zipcode.getCountryzipcode()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
