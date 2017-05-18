package com.jee.library.mapper;

import com.jee.library.model.dto.BookDto;
import com.jee.library.model.entity.Book;
import org.mapstruct.Mapper;

/**
 * Created by Viktoriia_Moiseienko on 5/18/2017.
 */
@Mapper
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);


}
