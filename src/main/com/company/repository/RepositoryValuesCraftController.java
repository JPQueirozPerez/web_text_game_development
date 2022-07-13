package main.com.company.repository;

import main.com.company.model.ValuesCraftController;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RepositoryValuesCraftController extends CrudRepository<ValuesCraftController,Integer> {

    @Query("select x from ValuesCraftController x where x.id = ?1")
    public Optional<ValuesCraftController> findById(int id);

    @Query("select x from ValuesCraftController x where x.id is not null ")
    public Iterable<ValuesCraftController> findAll();
}
