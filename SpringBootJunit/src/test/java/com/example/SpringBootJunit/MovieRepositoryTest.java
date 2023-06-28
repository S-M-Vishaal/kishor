package com.example.SpringBootJunit;



import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.SpringBootJunit.repo.MovieRepository;
import com.example.SpringBootJunit.entity.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {
	@Autowired
    MovieRepository movieRepo;

   
	
	@Test
    public void testInsertMovie() {

      Movie m= new Movie(104,"Big Bang Theory","English","Comedy",4);

      Movie savedInDB=movieRepo.save(m);

      Optional opt=movieRepo.findById(savedInDB.getId());

      Movie getFromDb=(Movie)opt.get();

       assertEquals(savedInDB.getId(),getFromDb.getId());

    }
    
}
