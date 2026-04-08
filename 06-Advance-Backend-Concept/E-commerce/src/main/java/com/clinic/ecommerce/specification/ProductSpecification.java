package com.clinic.ecommerce.specification;

import com.clinic.ecommerce.dto.ProductFilterRequest;
import com.clinic.ecommerce.model.Products;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Products> withFilters(ProductFilterRequest filter) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.equal(root.get("isActive"), true));

            if (filter.getSearch() != null && !filter.getSearch().isBlank()) {
                String keyword = "%" + filter.getSearch().toLowerCase() + "%";

                Predicate byName = cb.like(
                        cb.lower(root.get("name")), keyword
                );
                Predicate byGenericName = cb.like(
                        cb.lower(root.get("genericName")), keyword
                );
                predicates.add(cb.or(byName, byGenericName));
            }
            if (filter.getCategoryId() != null) {
                predicates.add(
                        cb.equal(root.get("category").get("id"), filter.getCategoryId())
                );
            }

            if (filter.getRequiresPrescription() != null) {
                predicates.add(
                        cb.equal(root.get("requiresPrescription"),
                                filter.getRequiresPrescription())
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}