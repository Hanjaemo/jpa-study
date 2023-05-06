package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        // given
        Book book = new Book();
        book.setAuthor("kim");

        // when
        itemService.saveItem(book);

        // then
        assertThat(book.getAuthor()).isEqualTo("kim");
    }

    @Test
    public void 상품_목록_조회() throws Exception {
        // given
        Book book = new Book();
        Album album = new Album();

        itemService.saveItem(book);
        itemService.saveItem(album);

        // when
        List<Item> items = itemService.findItems();

        // then
        assertThat(items.size()).isEqualTo(2);
    }

    @Test
    public void 상품_단일_조회() throws Exception {
        // given
        Book book1 = new Book();
        Book book2 = new Book();
        itemService.saveItem(book1);
        itemService.saveItem(book2);
        book1.setAuthor("kim");
        book2.setAuthor("jam");

        // when
        Item result = itemService.findOne(book1.getId());

        // then
        assertThat(result.getId()).isEqualTo(book1.getId());
    }
}