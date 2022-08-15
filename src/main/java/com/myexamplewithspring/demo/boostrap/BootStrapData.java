package com.myexamplewithspring.demo.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myexamplewithspring.demo.domain.Author;
import com.myexamplewithspring.demo.domain.Book;
import com.myexamplewithspring.demo.domain.Publisher;
import com.myexamplewithspring.demo.repositories.AuthoRepository;
import com.myexamplewithspring.demo.repositories.BookRepository;
import com.myexamplewithspring.demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthoRepository authoRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthoRepository authoRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authoRepository = authoRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Boostrap...");

		Publisher publisher = new Publisher();
		publisher.setName("SFGF Publisher");
		publisher.setCity("St Petersburg");
		publisher.setState("PublisherState");

		publisherRepository.save(publisher);
		System.out.println("Publisher count is: " + publisherRepository.count());

		Author eric = new Author("Eric", "Avans");
		Book book = new Book("DDT", "123");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);

		book.setPublisher(publisher);
		publisher.getBooks().add(book);

		authoRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(publisher);

		Author eric2 = new Author("Eric2", "Avans2");
		Book book2 = new Book("DDT2", "123222");
		eric2.getBooks().add(book2);
		book2.getAuthors().add(eric2);

		book2.setPublisher(publisher);
		publisher.getBooks().add(book2);


		authoRepository.save(eric2);
		bookRepository.save(book2);
		publisherRepository.save(publisher);


		System.out.println("Number of Books is: " + bookRepository.count());
		System.out.println("Number of Authors is: " + authoRepository.count());
		System.out.println("Publisher of Books is: " + publisher.getBooks().size());

	}
}
