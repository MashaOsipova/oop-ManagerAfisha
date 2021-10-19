package manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerNotEmptyTest {
    @Test
    public void shouldReverseOrder() {// обратный порядок, по умолчанию выводятся последние 10 добавленных фильмов, для массива с 12 элементами
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1, "link", "The Batman", "action");
        Movie second = new Movie(2, "link", "No Time To Die", "action");
        Movie third = new Movie(3, "link", "Free Guy", "comedy");
        Movie fourth = new Movie(4, "link", "Dune", "action");
        Movie fifth = new Movie(5, "link", "What if", "animation");
        Movie sixth = new Movie(6, "link", "Maid", "Drama");
        Movie seventh = new Movie(7, "link", "The Suicide Squad", "action");
        Movie eighth = new Movie(8, "link", "The Last Duel", "history");
        Movie nineth = new Movie(9, "link", "Interstellar", "adventure");
        Movie tenth = new Movie(10, "link", "The Green Knight", "adventure");
        Movie eleventh = new Movie(11, "link", "The Guilty", "crime");
        Movie twelve = new Movie(12, "link", "Midnight Mass", "horror");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelve);


        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleventh, tenth, nineth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseOrderForLessThenTen() { //обратный порядок, массив с 4-мя элементамими
        MovieManager manager = new MovieManager();

        Movie first = new Movie(1, "link", "The Batman", "action");
        Movie second = new Movie(2, "link", "No Time To Die", "action");
        Movie third = new Movie(3, "link", "Free Guy", "comedy");
        Movie fourth = new Movie(4, "link", "Dune", "action");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChangeAmountOfFilmsToShow() { //проверка возможности изменения количества фильмов на вывод
        MovieManager manager = new MovieManager(5);

        Movie first = new Movie(1, "link", "The Batman", "action");
        Movie second = new Movie(2, "link", "No Time To Die", "action");
        Movie third = new Movie(3, "link", "Free Guy", "comedy");
        Movie fourth = new Movie(4, "link", "Dune", "action");
        Movie fifth = new Movie(5, "link", "What if", "animation");
        Movie sixth = new Movie(6, "link", "Maid", "Drama");
        Movie seventh = new Movie(7, "link", "The Suicide Squad", "action");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {   // удалить существующий элемент
        MovieManager manager = new MovieManager();
        int idToRemove = 1;                  // определяем id элементата, который планируем удалить
        Movie first = new Movie(1, "link", "The Batman", "action");
        Movie second = new Movie(2, "link", "No Time To Die", "action");
        Movie third = new Movie(3, "link", "Free Guy", "comedy");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

        assertArrayEquals(expected, actual);
    }
}