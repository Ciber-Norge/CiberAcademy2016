package no.ciber.repositories;

import no.ciber.domain.Season;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeasonRepository extends PagingAndSortingRepository<Season, Long> {
}
