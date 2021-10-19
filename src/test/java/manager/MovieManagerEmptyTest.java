package manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerEmptyTest {
    @Test
    public void shouldEmptyArrayNotNull() {

        MovieManager manager = new MovieManager();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}