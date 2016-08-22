package no.ciber.repositories;

import no.ciber.domain.Result;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResultRepository extends PagingAndSortingRepository<Result, Long> {
}
