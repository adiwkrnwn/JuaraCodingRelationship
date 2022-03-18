package com.juaracoding.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
	
//	Select * from booking b join customer c on c.customer_id = b.customer_id where c.first_name="tessy"
	
	List<BookingModel> findByCustomerId_firstName(String firstName);
	List<BookingModel> findByCustomerId_lastName(String lastName);
	List<BookingModel> findBySeatIdRoomIdMaxOfSeat(int maxOfSeat);
	List<BookingModel> findByScreeningIdFilmIdCategory(String category);

}
