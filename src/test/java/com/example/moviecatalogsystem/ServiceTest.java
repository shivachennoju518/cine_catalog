package com.example.moviecatalogsystem;
import com.example.moviecatalogsystem.model.MovieEntity;
import com.example.moviecatalogsystem.repository.MovieRepository;
import com.example.moviecatalogsystem.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    MovieRepository movieRepository;
    @InjectMocks
     MovieServiceImpl movieServiceImpl;

    @Test // create
    void shouldAddMovie_whenCreateMovie(){
        MovieEntity movie = new MovieEntity(1L, "Inception", "Nolan", "Sci-Fi", 2010, 9.0);
        when(movieRepository.save(movie)).thenReturn(movie); // act

  MovieEntity result =movieServiceImpl.createMovie(movie);

  assertNotNull(result);
  assertEquals("Inception",result.getTitle());

        verify(movieRepository).save(movie);
    }

    @Test // get all
    void shouldReturnAllMovies_WhenGetAllMovies(){
        List<MovieEntity> movies=  List.of(
                new MovieEntity(1L, "Inception", "Nolan", "Sci-Fi", 2010, 9.0),
                new MovieEntity(2L, "Interstellar", "Nolan", "Sci-Fi", 2014, 9.5));
         when(movieRepository.findAll()).thenReturn(movies);
         List<MovieEntity> result=movieServiceImpl.getAllMovies();
         assertEquals(2,result.size());
        verify(movieRepository).findAll();
    }
    @Test // found
     void shouldReturnMovie_WhenGetById(){
        MovieEntity movie= new MovieEntity(1L, "Inception", "Nolan", "Sci-Fi", 2010, 9.0);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        MovieEntity result=movieServiceImpl.getById(1L);
        assertNotNull(result);
        assertEquals("Inception",result.getTitle());
        verify(movieRepository).findById(1L);
    }
    @Test // not found
    void shouldReturnNull_whenGetByIdNotFound(){
       when(movieRepository.findById(1L)).thenReturn(Optional.empty());
       MovieEntity result= movieServiceImpl.getById(1L);
       assertNull(result);
       verify(movieRepository).findById(1L);

    }

    @Test // update
    void shouldUpdateMovie_WhenUpdateMovie(){
        MovieEntity existing=new MovieEntity(1L,"old","drama","olddir",2000,5.0);
        MovieEntity updated=new MovieEntity(null,"New","SCI-FI","nolan",2010,9.0);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(movieRepository.save(existing)).thenReturn(existing);
        MovieEntity result=movieServiceImpl.updateMovie(1L,updated);
        assertNotNull(result);
        assertEquals("New",result.getTitle());
        assertEquals("nolan",result.getDirector());
        verify(movieRepository).findById(1L);
        verify(movieRepository).save(existing);

    }

    @Test // not found
    void ShouldReturnNull_whenUpdatingNotExistingMovie(){
        MovieEntity updated=new MovieEntity();
        when(movieRepository.findById(1L)).thenReturn(Optional.empty());
        MovieEntity result=movieServiceImpl.updateMovie(1L,updated);
        assertNull(result);
        verify(movieRepository).findById(1L);
        verify(movieRepository,never()).save(any());
    }

    @Test //delete
    void shouldDeleteMovie_WhenDeleteMovie(){
        doNothing().when(movieRepository).deleteById(1L);
        movieServiceImpl.deleteMovie(1L);
        verify(movieRepository).deleteById(1L);
    }
}
